<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
    </head>    
    <body>
        <h3>Cari Buku</h3>
        <a href="home">Home</a>
        
        <form action = "getsearch" method="get">            
            <p>
                Judul : <input type="text" name="search" size="30"/>
                <input type="submit" value="Search"/>
            </p>            
        </form>
        
        <p>ATAU </p>
        
        <form action = "getsearch_byprice" method="get">            
            <p>
                Harga : <input type="text" name="harga" size="30"/>
                <input type="submit" value="Search"/>
            </p>            
        </form>
        
        <p>ATAU </p>
        
        <form action = "getsearch_bycategory" method="get">            
            <p>
                Kategori : 
                <select name="category">
                        <option selected=selected value="">Pilih Kategori</option>   
                        <c:forEach items="${categories}" var="category"> 
                            <option value="${category.id}">${category.name}</option>
                        </c:forEach> 
                </select>
                <input type="submit" value="Search"/>
            </p>            
        </form>
        
    </body>
</html>