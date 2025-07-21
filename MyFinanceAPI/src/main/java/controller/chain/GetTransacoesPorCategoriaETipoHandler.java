package controller.chain;

import controller.command.BuscarTransacaoPorCategoriaETipoCommand;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetTransacoesPorCategoriaETipoHandler extends AbstractHandler{
	
	@Override
    protected boolean canHandle(HttpServletRequest request) {
        return request.getMethod().equals("GET") && request.getPathInfo() != null && request.getPathInfo().startsWith("/categoriaetipo/") && request.getPathInfo().contains("+");
    }

    @Override
    protected void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        new BuscarTransacaoPorCategoriaETipoCommand().executar(request, response);
    }

}
