package controller.command;

import DAO.TransacaoDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeletarTransacaoCommand implements Command{
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = request.getPathInfo();
		
		if (path == null || !path.matches("^/\\d+$")) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID da Transação inválido.");
			return;
		}
		
		int id = Integer.parseInt(path.substring(1));
		TransacaoDAO dao = new TransacaoDAO();
		boolean removido = dao.deletar(id);
		
		if (removido) {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Transação não encontrada.");
		}
	}

}