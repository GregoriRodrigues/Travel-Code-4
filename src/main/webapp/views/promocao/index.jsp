<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Promoções</title>
</head>
<body>
    <h1>Listagem de Promoções</h1>
    
    <!-- Aqui você pode usar tags JSTL ou scriptlet para exibir as promoções -->
    <c:forEach items="${promocoes}" var="promocao">
        <p>${promocao.detalhesPromocao}</p>
        <!-- Adicione mais informações de promoção, se necessário -->
    </c:forEach>

    <a href="create.jsp">Criar Nova Promoção</a>
</body>
</html>
