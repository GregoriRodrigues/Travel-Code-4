<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de RecebeContatos</title>
</head>
<body>
    <h1>Listagem de RecebeContatos</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Contato</th>
            <th>Destino</th>
            <th>Ações</th>
        </tr>
        <c:forEach items="${recebeContatos}" var="recebeContato">
            <tr>
                <td>${recebeContato.ID_RecebeContato}</td>
                <td>${recebeContato.ID_Contato.Nome}</td>
                <td>${recebeContato.ID_Destino.Nome_Destino}</td>
                <td>
                    <a href="<c:url value='/recebecontato?action=edit&id=${recebeContato.ID_RecebeContato}' />">Editar</a>
                    <a href="<c:url value='/recebecontato?action=delete&id=${recebeContato.ID_RecebeContato}' />">Excluir</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="<c:url value='/recebecontato?action=create' />">Novo RecebeContato</a>
</body>
</html>
