package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns="/busca")
public class BuscaEmpresa extends HttpServlet{

	public BuscaEmpresa() {
		System.out.println("Construindo uma servlet do tipo BuscaEmpresa " + this);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Inicializando a servlet " + this);
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Destruindo a servlet " + this);
	}

	//String filtro; fora do doGet é uma variável membro da servlet
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//req - dados que o cliente manda
		//resp - dados que devolvo para o cliente
		//parâmetro da requisição > req /busca?filtro=doc
		//filtro tem que ser uma variavel local, pois a servlet é instanciada uma única vez
		//podendo dar algum problema com multiplos acessos ao mesmo tempo que a utilizam

		String filtro = req.getParameter("filtro");

		//para testar o erro do uso de variáveis membro em uma servlet
		/*try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/

		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		req.setAttribute("empresas", empresas);
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/paginas/buscaEmpresas.jsp");
		dispatcher.forward(req, resp);

	}

}
