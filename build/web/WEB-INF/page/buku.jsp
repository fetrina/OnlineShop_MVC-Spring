<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel="stylesheet" href="../../asset/css/TableCSSCode.css" type="text/css">
        <title>Buku</title>
    </head>
    <body>
        
        <h2>Buku</h2>
        <p><a href="home">Home</a> |
            <a href="forminsert">Insert</a></p>
        
        <div class="CSSTableGenerator">
        <table border="1">
     
                <tr>
                    <td>ID.</td>
                    <td>Gambar</td>
                    <td>Judul</td>
                    <td>Penulis</td>
                    <td>Penerbit</td>
                    <td>Tahun Terbit</td>
                    <td>Jumlah Hal</td>
                    <td>Jenis Cover</td>
                    <td>ISBN</td>
                    <td>Bahasa</td>
                    <td>Kategori</td>
                    <td>Harga</td>
                    <td>Stok</td>
                    <td>Deskripsi</td>
                    
                    <td>Action</td>
                </tr>
                
                <c:forEach items="${books}" var="buku">
                <tr>
                    <td>${buku.id}</td>
                    <td><img src="/OnlineShop_MVC-Spring/asset/image/produk/${buku.gambar}" width="45" height="60"/></td>
                    <td>${buku.judul}</td>
                    <td>${buku.penulis}</td>
                    <td>${buku.penerbit}</td>
                    <td>${buku.tahun_terbit}</td>
                    <td>${buku.jml_hal}</td>
                    <td>${buku.jenis_cover}</td>
                    <td>${buku.isbn}</td>
                    <td>${buku.bahasa}</td>
                    <td>${buku.category.name}</td>
                    <td>${buku.harga}</td>
                    <td>${buku.stok}</td>
                    <td>${buku.deskripsi}</td>
                    <td><a href="edit?id=${buku.id}">Edit</a> | <a href="delete?id=${buku.id}">Delete</a></td>
                </tr>
                </c:forEach>
            
        </table>
        </div>
        
    </body>
</html>
