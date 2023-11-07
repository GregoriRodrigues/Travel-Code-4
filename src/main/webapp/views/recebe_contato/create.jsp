<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Criação de RecebeContato</title>
</head>
<body>
    <h1>Criação de RecebeContato</h1>
    <form method="post" action="<c:url value='/recebecontato' />">
        <input type="hidden" name="action" value="create">
        <!-- Campos do formulário de criação de RecebeContato -->
        <button type="submit">Criar RecebeContato</button>
    </form>
    <a href="<c:url value='/recebecontato?action=list' />">Voltar para a lista</a>
</body>
</html>
