<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel="stylesheet" href="../../asset/css/TableCSSCode.css" type="text/css">
        <link rel="stylesheet" href="../../asset/css/jquery-ui.css" type="text/css">
        <script src="../../asset/js/jquery.js" type="text/javascript"></script>
        <script src="../../asset/js/jquery-ui.js" type="text/javascript"></script>

        <script src="../../asset/js/categorydialog_script.js" type="text/javascript">          
        </script>
        <title>Kategori</title>
    </head>
    <body>
        <h2>Kategori</h2>
        <p><a href="home">Home</a></p>
        <form action = "save" method="post">            
            <p>
                Kategori : <input type="text" name="name" size="30"/>
                <input type="submit" value="Save"/>
            </p>            
        </form>
        <!--
        <div id="dialog-form">
            <table>
                <tr>
                    <td>Kategori</td>
                    <td>:</td>
                    <td><input type="text" id="name"/></td>
                </tr>
                
            </table>           
        </div>
        
        <p><a href="#" id="btnInsert" style="font-size: 12px">Insert New</a></p> -->
        
        <h3>Daftar Kategori</h3>
        
        <div class="CSSTableGenerator">
        <table border="1">
            <tr>
                <td>Id</td>
                <td>Nama</td>
                <td>Action</td>
            </tr>
            <c:forEach items="${categories}" var="category">
                <tr>
                    <td>${category.id}</td>
                    <td>${category.name}</td>
                   
                    <td><a href="edit?id=${category.id}">Edit</a> | <a href="delete?id=${category.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        </div>
    </body>
</html>