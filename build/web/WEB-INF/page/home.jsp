<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
    <head>
        <link rel="stylesheet" href="../../asset/css/jquery-ui.css" type="text/css">
        <link rel="stylesheet" href="../../asset/css/style.css" type="text/css">
        <script src="../../asset/js/boxOver.js" type="text/javascript">
        <script src="asset/js/jquery.js" type="text/javascript"></script>
        <script src="asset/js/jquery-ui.js" type="text/javascript"></script>
        <script src="asset/js/myscript.js" type="text/javascript">          
        </script>        
    </head>
    <body>       
        <c:if test="${pageContext.request.userPrincipal.name != null}">
	   <h2>Selamat datang, ${pageContext.request.userPrincipal.name} !
           | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a></h2>  
        </c:if> &nbsp;

            <a href="category/list">Kategori</a> &nbsp;
            <a href="buku/list">Buku</a> &nbsp;
            <a href="customer/list">Customer</a> &nbsp;
            <a href="order/list">Order</a> &nbsp;
            <a href="order_detail/list">Order Detail</a> &nbsp;
      
        <!--
        <p> <br>
            <h2> Menu Client </h2>
         <a href="buku/katalog">Katalog Buku</a> &nbsp;
         <a href="buku/caribuku">Cari Buku</a> &nbsp;
        -->
       
    </body>
</html>