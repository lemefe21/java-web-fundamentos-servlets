<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<body>
		Bem vindo ao nosso gerenciador de empresas!<br/>
		
		<c:if test="${not empty usuarioLogado}">
			Logado como ${usuarioLogado.email}<br/>
		</c:if>
		
		<form action="controller" method="post">
		<input type="hidden" name="tarefa" value="NovaEmpresa"> 
			Nome: <input type="text" name="nome">
			<input type="submit" value="Enviar">
		</form>
		<form action="login" method="post">
			Email: <input type="text" name="email">
			Senha: <input type="text" name="senha">
			<input type="submit" value="Logar">
		</form>
		<form action="controller" method="post">
			<input type="hidden" name="tarefa" value="Logout"> 
			<input type="submit" value="Logout">
		</form>
	</body>
</html>