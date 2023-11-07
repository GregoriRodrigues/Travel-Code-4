<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Destinos</title>
</head>
<body>
    <h1>Lista de Destinos</h1>
    
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Descrição</th>
            <th>ID da Promoção</th>
            <th>Ações</th>
        </tr>
        <c:forEach items="${listaDestinos}" var="destino">
            <tr>
                <td>${destino.ID_Destino}</td>
                <td>${destino.Nome_Destino}</td>
                <td>${destino.Descricao}</td>
                <td>${destino.ID_Promocao}</td>
                <td>
                    <a href="destino-edit?id=${destino.ID_Destino}">Editar</a>
                    <a href="destino-delete?id=${destino.ID_Destino}">Excluir</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    
    <a href="destino-create">Novo Destino</a>
</body>
</html>
