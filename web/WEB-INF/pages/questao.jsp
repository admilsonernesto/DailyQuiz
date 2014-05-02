<%--
  Created by IntelliJ IDEA.
  User: ADMILSON
  Date: 22/04/14
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--@elvariable id="questao" type="br.com.sidlar.dailyQuiz.domain.Questao"--%>
<html>
<head>
    <title>DailyQuiz</title>
</head>
<body>
<form action="<c:url value="/Quiz"/>">

    <c:if test="${questao.enunciado==null}">
        <h2>Não existe questão cadastrada para hoje!</h2>
    </c:if>

    <c:if test="${questao.enunciado!=null}">
        <input type="hidden" name="logica" value="Resposta">
        <h2>Questão do dia <fmt:formatDate value="${questao.dataDivulgacao}" pattern="dd/MM/yyyy"/></h2>

        <h3>${questao.enunciado}</h3>

        <OL type="A">
            <c:forEach var="alternativa" items="${questao.alternativas}">
                <li>
                    <input type="radio" name="alternativa"  value="${alternativa.numero}">
                        ${alternativa.descricao}
                    </input>
                </li>
            </c:forEach>
        </OL>

        <input type="submit" value="Enviar"/>
    </c:if>


</form>
</body>
</html>
