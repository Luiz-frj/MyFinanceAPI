package controller;

import java.util.HashMap;
import java.util.Map;

import controller.command.AtualizarTransacaoCommand;
import controller.command.BuscarTransacaoPorIDCommand;
import controller.command.BuscarTransacaoPorCategoriaETipoCommand;
import controller.command.Command;
import controller.command.CriarTransacaoCommand;
import controller.command.DeletarTransacaoCommand;
import controller.command.ListarTransacoesCommand;
import controller.command.ListarTransacoesPorCategoriaCommand;
import controller.command.ListarTransacoesPorTipoCommand;
import controller.command.ObterResumoFinanceiroCommand;
import jakarta.servlet.http.HttpServletRequest;

public class TransacaoDispatcher {

	private final Map<String, Command> rotas = new HashMap<>();

	public TransacaoDispatcher() {
		rotas.put("GET:/paginated", new ListarTransacoesCommand());
		rotas.put("POST:/", new CriarTransacaoCommand());
		rotas.put("GET:/id", new BuscarTransacaoPorIDCommand());
		rotas.put("PUT:/id", new AtualizarTransacaoCommand());
		rotas.put("DELETE:/id", new DeletarTransacaoCommand());
		rotas.put("GET:/tipo", new ListarTransacoesPorTipoCommand());
		rotas.put("GET:/resumo", new ObterResumoFinanceiroCommand());
		rotas.put("GET:/categoria", new ListarTransacoesPorCategoriaCommand());
		rotas.put("GET:/categoriaetipo", new BuscarTransacaoPorCategoriaETipoCommand());
	}

	public Command resolver(HttpServletRequest request) {
		String method = request.getMethod();
		String path = request.getPathInfo();
		if (path == null || path.equals("/")) {
			return rotas.get(method + ":/");
		} else if (path.equals("/paginated")) {
			return rotas.get(method + ":/paginated");
		} else if (path.matches("^/\\d+$")) {
			return rotas.get(method + ":/id");
		}else if (path.startsWith("/tipo/")) {
			return rotas.get(method + ":/tipo");
		}else if (path.startsWith("/categoria/")) { 
			return rotas.get(method + ":/categoria");
		} else if (path.startsWith("/categoriaetipo/") && path.contains("+")) { 
			return rotas.get(method + ":/categoriaetipo");
		} else if (path.equals("/resumo")) { 
            return rotas.get(method + ":/resumo");
        }
		return null;
	}

}