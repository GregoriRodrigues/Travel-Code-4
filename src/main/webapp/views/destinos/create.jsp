<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Criar Novo Destino</title>
</head>
<body>
    <h1>Criar Novo Destino</h1>
    
    <form action="destino-create" method="post">
        Nome: <input type="text" name="nome"><br>
        Descrição: <input type="text" name="descricao"><br>
        ID da Promoção: <input type="text" name="idPromocao"><br>
        <input type="submit" value="Criar">
    </form>
    
    <a href="destino">Voltar para a lista de destinos</a>
</body>
</html>
