<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" href="../../asset/css/TableCSSCode.css" type="text/css">
        <title>Order</title>
    </head>
    <body>
        <h2>Order</h2>
        <p><a href="home">Home</a>|
            <a href="forminsert">Insert</a></p>
        
        <div class="CSSTableGenerator">
        <table border="1">
                <tr>
                    <td>ID.</td>
                    <td>Tanggal</td>
                    <td>Waktu</td>
                    <td>Total Bayar</td>
                    <td>Status Order</td>
                    <td>Customer</td>
                    <td>Action</td>
                </tr>  
            
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.tanggal}</td>
                    <td>${order.waktu}</td>
                    <td>${order.total_bayar}</td>
                    <td>${order.status_order}</td>
                    <td>${order.customer.nama}</td>
                   
                    <td><a href="edit?id=${order.id}">Edit</a> | 
                        <a href="order_detail?id=${order.id}">Lihat Detail Order</a> 
                    </td>
                </tr>
            </c:forEach>
        </table>
        </div>
    </body>
</html>
