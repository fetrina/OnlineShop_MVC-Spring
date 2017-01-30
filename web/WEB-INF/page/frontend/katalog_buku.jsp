<%-- 
    page client
--%>

<!--Halaman home customer-->
<!--menampilkan katalog buku-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>      
    </head>
    <body>
        <h3>Katalog Buku</h3>
        <p>
        <a href="home">Home</a> &nbsp;
        <a href="search">Cari Buku</a> &nbsp;
        <a href="keranjangbelanja">Keranjang Belanja</a> &nbsp;
        <a href="register">Register</a> &nbsp;
        </p>
        
        <c:forEach items="${books}" var="buku"> 
        <table>
           <tr>
               <td><table>
                        <tr><td><img src="/OnlineShop_MVC-Spring/asset/image/produk/${buku.gambar}" width="70" height="80"></td>
                        </tr>
                   </table>
               </td>
                <td>
                    <table width="350">
               
                    <tr><td>Judul </td><td>:</td><td> ${buku.judul}</td></tr>
                    <tr><td>Penulis </td><td>:</td><td>${buku.penulis}</td></tr>
                    <tr><td>Penerbit </td><td>:</td><td>${buku.penerbit}</td></tr>
                    <tr><td>Harga </td><td>:</td><td> Rp. ${buku.harga}</td></tr>
            
                    <tr></tr>
                    <tr><td colspan="3" align="right">
                        <a href="belibuku?id=${buku.id}">Beli</a> 
                        <a href="detailbuku?id=${buku.id}">Lihat Detail</a></td>
                    </tr>
      
                    </table>
                </td>
            </tr>
            <tr></tr>
        </table>
        </c:forEach>
       
    </body>
</html>