<%--
  Created by IntelliJ IDEA.
  User: ADMILSON
  Date: 29/04/14
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--@elvariable id="resposta" type="br.com.sidlar.dailyQuiz.presentation.Resposta"--%>
<html>
<head>
    <title>DailyQuiz</title>
</head>
<body>
    <h2>Questão do dia <fmt:formatDate value="${resposta.questao.dataDivulgacao}" pattern="dd/MM/yyyy"/></h2>

    <h3>${resposta.questao.enunciado}</h3>

    <OL type="A">
        <c:forEach var="alternativa" items="${resposta.questao.alternativas}">
            <li>
                <span style="color: ${not alternativa.correta and resposta.numeroAlternativaSelecionada == alternativa.numero?'red':alternativa.correta?'green':'black'}">
                    ${alternativa.descricao} (${alternativa.quantidadeRespostas})
                </span>
            </li>
        </c:forEach>
    </OL>

    <c:if test="${resposta.acertou}">
        <span>Parabéns você acertou.</span>
    </c:if>

    <c:if test="${not resposta.acertou}">
        <span>Resposta errada! A resposta correta esta destacada acima na cor verde.</span>
    </c:if>

</body>
</html>
