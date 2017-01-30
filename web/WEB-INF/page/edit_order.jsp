<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
    </head>    
    <body>
        <h3>Ubah Status Order</h3>
        <a href="list">Cancel</a>
        
        <form action = "update" method="post">            
           <table>
                <tr><td>Tanggal</td><td>:</td><td><input type=text name=tanggal value="${order.tanggal}" readonly></td></tr>
                <tr><td>Waktu</td><td>:</td><td><input type=text name=waktu value="${order.waktu}" readonly></td></tr>
                <tr><td>Customer</td><td>:</td><td><input type=text name=customer value="${order.customer.nama}" readonly></td></tr>
                <tr><td>Total Bayar</td><td>:</td><td><input type=text name=total_bayar value="${order.total_bayar}" readonly></td></tr>
                <tr><td>Status Order</td><td>:</td>
                    <td>
                        <select name="status_order">
                            <option selected=selected value="${order.status_order}">${order.status_order}</option>
                            <option value="Sudah Bayar">Sudah Bayar</option>
                            <option value="Belum Bayar">Belum Bayar</option>
                        </select>
                   
                </tr>
                
                <tr></tr>
                
                <tr><td colspan="3" align="right">
                    <input type="hidden" name="customer" value="${customer.id}"/>
                    <input type="hidden" name="id" value="${order.id}"/>
                    <input type="submit" value="Update"/>
                    </td>
                </tr>
            </table>            
        </form>
    </body>
</html>