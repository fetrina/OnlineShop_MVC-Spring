<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" href="../../asset/css/TableCSSCode.css" type="text/css">
        <title>Order Detail</title>
    </head>
    <body>
        <h2>Order Detail</h2>
        <p><a href="home">Home</a>|
            <a href="forminsert">Insert</a></p>
        
        <p>ID Order anda : ${orderdetail.orderBarang.id}</p>
        <div class="CSSTableGenerator">
        <table border="1">
           
                <tr>
                    <td>ID Order Detail</td>
                    <td>ID Order</td>
                    <td>Judul Buku</td>
                    <td>Qty</td>
                    <td>Sub Total</td>
                </tr>  
            
            <c:forEach items="${orderdetails}" var="orderdetail">
                <tr>
                    <td>${orderdetail.id}</td>
                    <td>${orderdetail.orderBarang.id}</td>
                    <td>${orderdetail.buku.judul}</td>
                    <td>${orderdetail.qty}</td>
                    <td>${orderdetail.subtotal}</td>
                </tr>
            </c:forEach>
        </table>
        </div>    
    </body>
</html>
