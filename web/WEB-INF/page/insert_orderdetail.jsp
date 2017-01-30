<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
    <title>Order</title>
    </head>
    <body>
        <h3>Masukkan Order Detail</h3>
        <a href="list">Cancel</a>
        <form action="save" method="post">            
            
            <table bgcolor="#A9D0F5">
                <tr><td>ID Order</td><td>:</td>
                    <td><select name="orderBarang">
                        <c:forEach items="${orders}" var="orderbarang">
                            <option value="${orderbarang.id}">${orderbarang.id}</option>
                        </c:forEach> 
                        </select>
                    </td>
                </tr>
                <tr><td>Judul Buku</td><td>:</td>
                    <td><select name="buku">
                        <c:forEach items="${books}" var="buku">
                            <option value="${buku.id}">${buku.judul}</option>
                        </c:forEach> 
                    </select>
                    </td>
                </tr>
                <tr><td>Qty</td><td>:</td><td><input type=text name=qty></td></tr>
                <tr><td>Sub Total</td><td>:</td><td><input type=text name=subtotal></td></tr>
                <tr></tr>
                
                <tr><td colspan="3" align="right">   
                    <input type="submit" value="Save"/></td>
                </tr>
            </table>
                       
        </form>
    </body>
</html>