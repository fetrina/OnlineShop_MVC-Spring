<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
    <title>Buku</title>
    </head>
    <body>
        <h3>Masukkan Buku Baru</h3>
        <a href="list">Cancel</a>
        <form action="save" method="post">            
            
            <table bgcolor="#A9D0F5">
                <tr><td>Judul</td><td>:</td><td><input type=text name=judul></td></tr>
                <tr><td>Category</td><td>:</td>
                    <td><select name="category">
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach> 
                    </select>
                    </td></tr>
                
                <tr><td>Penulis</td><td>:</td><td><input type=text name=penulis></td></tr>
                <tr><td>Penerbit</td><td>:</td><td><input type=text name=penerbit></td></tr>
                <tr><td>Gambar</td><td>:</td><td><input type=file name="gambar"/></td></tr>
                <tr><td>Tahun Terbit</td><td>:</td><td><input type=text name=tahun_terbit></td></tr>
                <tr><td>Jumlah Hal</td><td>:</td><td><input type=text name=jml_hal></tr>
                <tr><td>Jenis Cover</td><td>:</td><td><input type=text name=jenis_cover></tr>
                <tr><td>ISBN</td><td>:</td><td><input type=text name=isbn></tr>
                <tr><td>Bahasa</td><td>:</td><td><input type=text name=bahasa></tr>
                <tr><td>Harga</td><td>:</td><td><input type=text name=harga></tr>
                <tr><td>Stok</td><td>:</td><td><input type=text name=stok></tr>
                <tr><td>Deskripsi</td><td>:</td><td><input type=text name=deskripsi></tr>
                
                <tr></tr>
                
                <tr><td colspan="3" align="right">
                    <input type="submit" value="Save"/></td>
                </tr>
            </table>
                       
        </form>
    </body>
</html>