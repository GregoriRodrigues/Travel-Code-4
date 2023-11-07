<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Destino</title>
</head>
<body>
    <h1>Editar Destino</h1>
    
    <form action="destino-update" method="post">
        <input type="hidden" name="id" value="${destino.ID_Destino}">
        Nome: <input type="text" name="nome" value="${destino.Nome_Destino}"><br>
        Descrição: <input type="text" name="descricao" value="${destino.Descricao}"><br>
        ID da Promoção: <input type="text" name="idPromocao" value="${destino.ID_Promocao}"><br>
        <input type="submit" value="Atualizar">
    </form>
    
    <a href="destino">Voltar para a lista de destinos</a>
</body>
</html>
