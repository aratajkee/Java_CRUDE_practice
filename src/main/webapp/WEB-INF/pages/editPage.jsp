
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit-page of ${pet.name}</title>
</head>
<body>
    <c:if test="${!empty pet.name}">
        <h2 style="accent-color: fuchsia">EDIT-PAGE of ${pet.name}</h2>
    </c:if>
    <c:if test="${empty pet.name}">
        <h2>Adding new pet</h2>
    </c:if>

    <c:if test="${!empty pet.name}">
        <c:url value="/edit" var="var"/>
    </c:if>
    <c:if test="${empty pet.name}">
        <c:url value="/add" var="var"/>
    </c:if>
    <form action="${var}" method="POST">
        <c:if test="${!empty pet.name}">
            <input type="hidden" name="id" value="${pet.id}">
        </c:if>
        <label for="type">Type</label>
        <input type="text" name="type" id="type">
        <label for="name">Name</label>
        <input type="text" name="name" id="name">

        <c:if test="${!empty pet.name}">
            <input type="submit" value="Edit pet">
        </c:if>
        <c:if test="${empty pet.name}">
            <input type="submit" value="Add pet">
        </c:if>
    </form>
</body>
</html>
