<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>       
        <title>Customer</title>
        <link rel="stylesheet" href="../../asset/css/TableCSSCode.css" type="text/css">
    </head>
    <body>
        <h2>Customer</h2>
        <p><a href="home">Home</a>|
            <a href="forminsert">Insert</a></p>
        
        <div class="CSSTableGenerator">
        <table border="1">
           
                <tr>
                    <td>ID.</td>
                    <td>Customer</td>
                    <td>Hp</td>
                    <td>Email</td>
                    <td>Alamat</td>
                    <td>Kota</td>
                    <td>Provinsi</td>
                    <td>Action</td>
                </tr>  
            
            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.nama}</td>
                    <td>${customer.hp}</td>
                    <td>${customer.email}</td>
                    <td>${customer.alamat}</td>
                    <td>${customer.kota}</td>
                    <td>${customer.provinsi}</td>
                   
                    <td><a href="edit?id=${customer.id}">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
        </div>    
    </body>
</html>
