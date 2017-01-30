<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
    </head>    
    <body>
        <h3>Ubah Kategori</h3>
        <a href="list">Cancel</a>
        
        <form action = "update" method="post">            
            <p>
                Kategori : <input type="text" name="name" size="30" value="${category.name}"/>
                <input type="hidden" name="id" value="${category.id}"/>
                <input type="submit" value="Save"/>
            </p>            
        </form>
    </body>
</html>