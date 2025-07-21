package controller.command;

import java.io.BufferedReader;
import java.io.PrintWriter;

import com.google.gson.Gson;

import DAO.TransacaoDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Transacao;

public class AtualizarTransacaoCommand implements Command{
	
	public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = request.getPathInfo();
		if (path == null || !path.matches("^/\\d+$")) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID da transação inválido.");
			return;
		}
		
		int id = Integer.parseInt(path.substring(1));
		BufferedReader reader = request.getReader();
		Transacao transacaoAtualizada = new Gson().fromJson(reader, Transacao.class);
		TransacaoDAO dao = new TransacaoDAO();
		boolean atualizado = dao.atualizar(id, transacaoAtualizada);
		
		if (atualizado) {
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(new Gson().toJson(transacaoAtualizada));
			out.flush();
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Transação não encontrada.");
		}
	}

}
