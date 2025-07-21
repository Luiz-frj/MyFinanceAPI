package controller.command;

import java.io.PrintWriter;

import com.google.gson.Gson;

import DAO.TransacaoDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Transacao;

public class BuscarTransacaoPorIDCommand implements Command{
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = request.getPathInfo();
		if (path == null || !path.matches("^/\\d+$")) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido na URL.");
			return;
		}
		
		int id = Integer.parseInt(path.substring(1));
		TransacaoDAO dao = new TransacaoDAO();
		Transacao tarefa = dao.buscarId(id);
		
		if (tarefa != null) {
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(new Gson().toJson(tarefa));
			out.flush();
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Transação não encontrada.");
		}
	}
	
}
