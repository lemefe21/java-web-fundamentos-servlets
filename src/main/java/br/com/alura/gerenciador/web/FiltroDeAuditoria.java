package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns="/*") //todo mundo passa por esse filtro
public class FiltroDeAuditoria implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		//dados que estão chegando da requisição
		String uri = req.getRequestURI();

		String usuario = getUsuario(req);

		//para cada requisição
		System.out.println("Usuário "+ usuario +" acessando a URI: " + uri);

		//filtro continua o processo da requisição
		chain.doFilter(request, response);

	}

	private String getUsuario(HttpServletRequest req) {

		//quem faz o req (envio) é cliente
		//passamos a utilizar Session no lugar de Cookie
		//Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();

		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario.logado");

		if(usuario == null) {
			return "<deslogado>";
		}
		return usuario.getEmail();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
