package controller.command;

import java.io.BufferedReader;
import java.io.PrintWriter;

import com.google.gson.Gson;

import DAO.TransacaoDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Transacao;

public class CriarTransacaoCommand implements Command{
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BufferedReader reader = request.getReader();
		Transacao transacao = new Gson().fromJson(reader, Transacao.class);
		TransacaoDAO dao = new TransacaoDAO();
		dao.inserir(transacao);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(new Gson().toJson(transacao));
		out.flush();
		response.setStatus(HttpServletResponse.SC_CREATED);
	}

}
