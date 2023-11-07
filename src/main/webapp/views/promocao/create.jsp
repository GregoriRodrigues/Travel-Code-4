<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Criar Nova Promoção</title>
</head>
<body>
    <h1>Criar Nova Promoção</h1>
    
    <form action="PromocaoServlet" method="post">
        <label for="detalhesPromocao">Detalhes da Promoção:</label>
        <input type="text" name="detalhesPromocao" id="detalhesPromocao" required>
        
        <label for="dataInicio">Data de Início:</label>
        <input type="text" name="dataInicio" id="dataInicio" required>
        
        <label for="dataFim">Data de Término:</label>
        <input type="text" name="dataFim" id="dataFim" required>
        
        <input type="submit" value="Criar Promoção">
    </form>
    
    <a href="index.jsp">Voltar para a Listagem de Promoções</a>
</body>
</html>
