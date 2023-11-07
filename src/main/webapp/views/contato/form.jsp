<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../assets/css/style.css" />
    <title>Formulário de Contato</title>
</head>
<body>
    <h1>Fale Conosco</h1>
    <form action="contato-create" method="post">
        <div class="form-group">
            <label for="nome">Nome:</label>
            <input type="text" name="nome" id="nome">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" name="email" id="email">
        </div>
        <div class="form-group">
            <label for="telefone">Telefone:</label>
            <input type="text" name="telefone" id="telefone">
        </div>
        <div class="form-group">
            <label for="assunto">Assunto:</label>
            <input type="text" name="assunto" id="assunto">
        </div>
        <div class="form-group">
            <label for="mensagem">Mensagem:</label>
            <textarea name="mensagem" id="mensagem" rows="4"></textarea>
        </div>
        <button type="submit">Enviar</button>
    </form>
</body>
</html>
