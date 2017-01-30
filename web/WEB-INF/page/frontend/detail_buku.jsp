<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>       
        <title>Detail Buku</title>
    </head>
    <body>
        <h2>Detail Buku</h2>
        <p><a href="home">Home</a></p>
        <table>
            <tr>
                <td valign='top'><img src="/OnlineShop_MVC-Spring/asset/image/produk/${buku.gambar}" width="70" height="80" align="top"/></td>
                <td><table>           
                        <tr><td>Judul</td><td>:</td><td>${buku.judul}</td></tr>
                        <tr><td>Penulis</td><td>:</td><td>${buku.penulis}</td></tr>
                        <tr><td>Penerbit</td><td>:</td><td>${buku.penerbit}</td></tr>
                        <tr><td></td></tr>
                        <tr><td>Tahun Terbit</td><td>:</td><td>${buku.tahun_terbit}</td></tr>
                        <tr><td>Jumlah Hal</td><td>:</td><td>${buku.jml_hal}</tr>
                        <tr><td>Jenis Cover</td><td>:</td><td>${buku.jenis_cover}</tr>
                        <tr><td>ISBN</td><td>:</td><td>${buku.isbn}</tr>
                        <tr><td>Bahasa</td><td>:</td><td>${buku.bahasa}</tr>
                        <tr><td>Harga</td><td>:</td><td>${buku.harga}</tr>
                        <tr><td>Stok</td><td>:</td><td>${buku.stok}</tr>
                        <tr><td>Deskripsi</td><td>:</td><td>${buku.deskripsi}</tr>   
                    </table>
                </td>
                
            </tr>     
                <tr><td colspan="3" align="right"><input type="hidden" name="id" value="${buku.id}"/>
                    <input type="submit" value="Beli"/></td>
                </tr>
        </table>
    </body>
</html>
