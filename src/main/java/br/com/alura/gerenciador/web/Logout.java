package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/logout")
public class Logout extends HttpServlet{

	@Override //efeito colateral no servidor, por isso usamos post
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getSession().removeAttribute("usuario.logado");

		//outra abordagem mais definitiva
		//req.getSession().invalidate();

		PrintWriter writer = resp.getWriter();

		/*Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
		if(cookie == null) {
			writer.println("<html><body>Usuário não estava logado!</body></html>");
			return;
		}
		cookie.setMaxAge(0);
		resp.addCookie(cookie);*/

		writer.println("<html><body>Deslogado com sucesso!</body></html>");

	}

}
