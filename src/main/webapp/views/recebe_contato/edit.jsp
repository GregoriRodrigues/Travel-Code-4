<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edição de RecebeContato</title>
</head>
<body>
    <h1>Edição de RecebeContato</h1>
    <form method="post" action="<c:url value='/recebecontato' />">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${recebeContato.ID_RecebeContato}">
        <!-- Campos do formulário de edição de RecebeContato -->
        <button type="submit">Atualizar RecebeContato</button>
    </form>
    <a href="<c:url value='/recebecontato?action=list' />">Voltar para a listagem</a>
</body>
</html>
