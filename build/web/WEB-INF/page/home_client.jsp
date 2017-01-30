<!--Halaman home customer-->
<!--menampilkan katalog buku-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" href="../../asset/css/TableCSSCode.css" type="text/css">
        <link rel="stylesheet" href="../../asset/css/style.css" type="text/css">
    </head>
    <body>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
	   <h2>Selamat datang di Palasari Book Store, ${pageContext.request.userPrincipal.name} !
           | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a></h2>  
        </c:if> &nbsp;
        <p> 
            <a href="katalog">Katalog Buku</a> &nbsp;
            <a href="search">Cari Buku</a> &nbsp;
            <a href="keranjangbelanja">Keranjang Belanja</a> &nbsp;
            <a href="register">Register</a> &nbsp;
        </p>
       
    </body>
</html>