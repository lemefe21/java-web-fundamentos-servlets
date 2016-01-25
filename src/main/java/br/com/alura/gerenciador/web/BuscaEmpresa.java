package br.com.alura.gerenciador.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

public class BuscaEmpresa implements Tarefa{

	public BuscaEmpresa() {
		System.out.println("Construindo uma servlet do tipo BuscaEmpresa " + this);
	}

	//String filtro; fora do doGet é uma variável membro da servlet
	/*@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//req - dados que o cliente manda
		//resp - dados que devolvo para o cliente
		//parâmetro da requisição > req /busca?filtro=doc
		//filtro tem que ser uma variavel local, pois a servlet é instanciada uma única vez
		//podendo dar algum problema com multiplos acessos ao mesmo tempo que a utilizam

		//para testar o erro do uso de variáveis membro em uma servlet
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}*/

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		String filtro = req.getParameter("filtro");
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		req.setAttribute("empresas", empresas);
		return "/WEB-INF/paginas/buscaEmpresas.jsp";

		//exemplo
		//http://localhost:8085/gerenciador/fazTudo?tarefa=BuscaEmpresa&filtro=oo

	}

}
