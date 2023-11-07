<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../assets/css/style.css" />
    <title>Lista de Contatos</title>
</head>
<body>
    <h1>Lista de Contatos</h1>
    <table>
        <thead>
            <tr>
                <th>Nome</th>
                <th>Email</th>
                <th>Telefone</th>
                <th>Assunto</th>
                <th>Mensagem</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listaContatos}" var="contato">
                <tr>
                    <td>${contato.nome}</td>
                    <td>${contato.email}</td>
                    <td>${contato.telefone}</td>
                    <td>${contato.assunto}</td>
                    <td>${contato.mensagem}</td>
                    <td>
                        <a href="contato-edit?id=${contato.id}">Editar</a>
                        <a href="contato-delete?id=${contato.id}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
