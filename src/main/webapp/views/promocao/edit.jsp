<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Promoção</title>
</head>
<body>
    <h1>Editar Promoção</h1>
    
    <form action="PromocaoServlet" method="post">
        <input type="hidden" name="idPromocao" value="${promocao.idPromocao}">
        
        <label for="detalhesPromocao">Detalhes da Promoção:</label>
        <input type="text" name="detalhesPromocao" id="detalhesPromocao" value="${promocao.detalhesPromocao}" required>
        
        <label for="dataInicio">Data de Início:</label>
        <input type="text" name="dataInicio" id="dataInicio" value="${promocao.dataInicio}" required>
        
        <label for="dataFim">Data de Término:</label>
        <input type="text" name="dataFim" id="dataFim" value="${promocao.dataFim}" required>
        
        <input type="submit" value="Atualizar Promoção">
    </form>
    
    <a href="index.jsp">Voltar para a Listagem de Promoções</a>
</body>
</html>
