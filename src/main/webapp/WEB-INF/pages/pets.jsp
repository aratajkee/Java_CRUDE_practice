<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css">
    <title>Pets</title>
</head>
<body>
    <h2>Pets table</h2>
    <table>
        <thead>
            <tr>
                <th>id</th>
                <th>type</th>
                <th>name</th>
                <th>action</th>
            </tr>
        </thead>
        <tbody>
           <c:forEach var="pet" items="${petList}">
               <tr>
                   <td>${pet.id}</td>
                   <td>${pet.type}</td>
                   <td>${pet.name}</td>
                   <td>
                       <a href="/edit/${pet.id}">edit</a>
                       <a href="/delete${pet.id}">delete</a>
                   </td>
               </tr>
           </c:forEach>
        </tbody>
    </table>
    <h2>Add</h2>
    <c:url value="/add" var="add"/>
    <a href ="${add}">Add new pet</a>


</body>
</html>
