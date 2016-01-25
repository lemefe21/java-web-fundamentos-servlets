package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;

public class Logout implements Tarefa {

	/*@Override //causamos um efeito colateral no servidor, por isso usamos post
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//implementamos o sendRedirect para que depois de efetuar o logout
		//caso o usuario atualize a pagina (reflesh) não lançar erro 412
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
		if(usuario == null) {
			resp.sendRedirect("/gerenciador");
		}else {
			req.getSession().removeAttribute("usuarioLogado");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logout.html");
			dispatcher.forward(req, resp);
		}
	}*/

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
		if(usuario == null) {
			//redireciona para o index.html no lado do cliente caso não exista nenhum usuário logado
			return  "/gerenciador";
		}else {
			req.getSession().removeAttribute("usuarioLogado");
			//outra abordagem mais definitiva
			//req.getSession().invalidate();
			//dispacha uma requisição no lado do servidor sem o usuário ter conhecimento
			return "/WEB-INF/paginas/logout.html";
		}
	}

}
