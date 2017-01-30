<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
    </head>    
    <body>
        <h3>Ubah Customer</h3>
        <a href="list">Cancel</a>
        
        <form action = "update" method="post">            
           <table>
                <tr><td>Nama</td><td>:</td><td><input type=text name=nama value="${customer.nama}"></td></tr>
                <tr><td>Hp</td><td>:</td><td><input type=text name=hp value="${customer.hp}"></td></tr>
                <tr><td>Email</td><td>:</td><td><input type=text name=email value="${customer.email}"></td></tr>
                <tr><td>Alamat</td><td>:</td><td><input type=text name=alamat value="${customer.alamat}"></td></tr>
                <tr><td>Kota</td><td>:</td><td><input type=text name=kota value="${customer.kota}"></tr>
                <tr><td>Provinsi</td><td>:</td><td><input type=text name=provinsi value="${customer.provinsi}"></tr>
                     
                <tr></tr>
                
                <tr><td colspan="3" align="right">
                    <input type="hidden" name="id" value="${customer.id}"/>
                    <input type="submit" value="Update"/>
                    </td>
                </tr>
            </table>            
        </form>
    </body>
</html>