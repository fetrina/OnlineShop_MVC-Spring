<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
    </head>    
    <body>
        <h3>Ubah Buku</h3>
        <a href="list">Cancel</a>
        
        <form action = "update" method="post">            
           <table>
                <tr><td>Judul</td><td>:</td><td><input type=text name=judul value="${buku.judul}"></td></tr>
                <tr><td>Kategori</td><td>:</td>
                    <td><select name="category">
                        <option selected=selected value="${buku.category.id}">${buku.category.name}</option>   
                        <c:forEach items="${categories}" var="category">
                            <option value="${category.id}">${category.name}</option>
                        </c:forEach> 
                    </select>
                    </td>
                </tr> 
                <tr><td>Penulis</td><td>:</td><td><input type=text name=penulis value="${buku.penulis}"></td></tr>
                <tr><td>Penerbit</td><td>:</td><td><input type=text name=penerbit value="${buku.penerbit}"></td></tr>
                <tr><td>Gambar</td><td>:</td><td><input type=file name="gambar" /></td></tr>
                <tr><td>Terbit</td><td>:</td><td><input type=text name=tahun_terbit value="${buku.tahun_terbit}"></td></tr>
                <tr><td>Jml Hal</td><td>:</td><td><input type=text name=jml_hal value="${buku.jml_hal}"></tr>
                <tr><td>Jenis Cover</td><td>:</td><td><input type=text name=jenis_cover value="${buku.jenis_cover}"></tr>
                <tr><td>ISBN</td><td>:</td><td><input type=text name=isbn value="${buku.isbn}"></tr>
                <tr><td>Bahasa</td><td>:</td><td><input type=text name=bahasa value="${buku.bahasa}"></tr>
                <tr><td>Harga</td><td>:</td><td><input type=text name=harga value="${buku.harga}"></tr>
                <tr><td>Stok</td><td>:</td><td><input type=text name=stok value="${buku.stok}"></tr>
                <tr><td>Deskripsi</td><td>:</td><td><input type=text name=deskripsi value="${buku.deskripsi}"></tr>            
                <tr></tr>
                
                <tr><td colspan="3" align="right">
                    <input type="hidden" name="id" value="${buku.id}"/>
                    <input type="submit" value="Update"/>
                    </td>
                </tr>
            </table>            
        </form>
    </body>
</html>