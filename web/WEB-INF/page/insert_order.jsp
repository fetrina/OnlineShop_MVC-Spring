<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
    <title>Order</title>
    </head>
    <body>
        <h3>Masukkan Order</h3>
        <a href="list">Cancel</a>
        <form action="save" method="post">            
            
            <table bgcolor="#A9D0F5">
                <tr><td>Waktu</td><td>:</td><td><input type=time name=waktu></td></tr>
                <tr><td>Total Bayar</td><td>:</td><td><input type=text name=total_bayar></td></tr>
                <tr></tr>
                
                <tr><td colspan="3" align="right">
                    <input type="hidden" name="status_order" value="Belum Bayar"/>    
                    <input type="submit" value="Save"/></td>
                </tr>
            </table>
                       
        </form>
    </body>
</html>