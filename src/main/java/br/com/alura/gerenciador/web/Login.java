package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns="/login")
public class Login extends HttpServlet{

	//se traz efeito colateral para o servidor? POST
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);

		PrintWriter writer = resp.getWriter();
		if(usuario == null) {
			writer.println("<html><body>Usuário ou Senha inválida!</body></html>");
		}else {

			HttpSession session = req.getSession();
			session.setAttribute("usuario.logado", usuario);

			//subtituimos por Session
			/*Cookie cookie = new Cookie("usuario.logado", usuario.getEmail());
			cookie.setMaxAge(10 * 60);
			//envia o cookie para o cliente na resposta
			resp.addCookie(cookie);*/

			writer.println("<html><body>Usuário logado: "+ usuario.getEmail() +"</body></html>");

		}

	}

}
