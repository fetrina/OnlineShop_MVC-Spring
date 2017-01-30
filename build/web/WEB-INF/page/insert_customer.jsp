<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
    <title>Customer</title>
    </head>
    <body>
        <h3>Masukkan Customer Baru</h3>
        <a href="list">Cancel</a>
        <form action="save" method="post">            
            
            <table bgcolor="#A9D0F5">
                <tr><td>Nama</td><td>:</td><td><input type=text name=nama></td></tr>
                <tr><td>Hp</td><td>:</td><td><input type=text name=hp></td></tr>
                <tr><td>Alamat</td><td>:</td><td><input type=text name=alamat></td></tr>
                <tr><td>Email</td><td>:</td><td><input type=text name=email></td></tr>
                <tr><td>Kota</td><td>:</td><td><input type=text name=kota></tr>
                <tr><td>Provinsi</td><td>:</td><td><input type=text name=provinsi></tr>
                
                <tr></tr>
                
                <tr><td colspan="3" align="right">
                    <input type="submit" value="Save"/></td>
                </tr>
            </table>
                       
        </form>
    </body>
</html>