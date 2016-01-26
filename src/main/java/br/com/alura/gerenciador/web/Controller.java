package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/controller")
public class Controller extends HttpServlet {

	//aagora responsável por redirecionar as servlets
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String tarefa = req.getParameter("tarefa");
		if(tarefa == null) {
			throw new IllegalArgumentException("Você esqueceu de passar a tarefa");
		}
		tarefa = "br.com.alura.gerenciador.web." + tarefa;

		//abstração da tarefa em classe Java
		try {

			Class<?> tipo = Class.forName(tarefa);
			Tarefa instancia = (Tarefa) tipo.newInstance();
			String pagina = instancia.executa(req, resp);

			//redireciona
			RequestDispatcher dispacher = req.getRequestDispatcher(pagina);
			dispacher.forward(req, resp);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

	}

}
