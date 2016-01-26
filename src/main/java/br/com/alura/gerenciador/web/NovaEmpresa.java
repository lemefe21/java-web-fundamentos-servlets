package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

public class NovaEmpresa implements Tarefa{

	/*@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//camada de lógica
		String nome = req.getParameter("nome");
		Empresa empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);

		//devolve para o cliente - separamos essa parte para a camada de View
		//PrintWriter writer = resp.getWriter();
		//writer.println("<html><body>Empresa adicionada com sucesso: " + empresa.getNome() +"</body></html>");

		//seta um atributo/objeto na requisição para a view
		//continua ativo no servidor até executar o resp
		req.setAttribute("empresa", empresa);

		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/paginas/novaEmpresa.jsp");
		dispatcher.forward(req, resp);

	}*/

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		String nome = req.getParameter("nome");
		Empresa empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);
		req.setAttribute("empresa", empresa);

		return "WEB-INF/paginas/novaEmpresa.jsp";
		//http://localhost:8085/gerenciador/fazTudo?tarefa=NovaEmpresa&nome=new
	}

}
