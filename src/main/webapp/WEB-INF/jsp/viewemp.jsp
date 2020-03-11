<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<h1>Employees List</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>Edit</th><th>Delete</th></tr>
   <c:forEach var="emp" items="${list}"> 
   <tr>
   <td>${pr.id}</td>
   <td>${pr.name}</td>
   <td>${pr.price}</td>
   <td>${pr.quantity}</td>
   <td>${pr.description}</td>
   <td><a href="editemp/${pr.id}">Edit</a></td>
   <td><a href="deleteemp/${pr.id}">Delete</a></td>
   </tr>
   </c:forEach>
   </table>
   <br/>
   <a href="empform">Add New Product</a>