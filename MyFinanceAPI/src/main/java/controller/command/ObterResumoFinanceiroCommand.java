package controller.command;

import java.io.PrintWriter;

import com.google.gson.Gson;

import DAO.TransacaoDAO; 
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ResumoFinanceiro;

public class ObterResumoFinanceiroCommand implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TransacaoDAO dao = new TransacaoDAO();
		ResumoFinanceiro resumo = dao.obterResumo();
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(resumo));
        out.flush();
        response.setStatus(HttpServletResponse.SC_OK);
	}

}