<html>
    <head>
    <title>Register</title>
    </head>
    <body>
        <h3>Register User</h3>
        <p> 
            <a href="home">Home</a> &nbsp;
        </p>
        <p>Untuk berberlanja, silahkan mendaftar terlebih dahulu dengan mengisi form berikut</p>
        <form action="saveregister" method="post">            
            
            <table bgcolor="#A9D0F5">  
                <tr><td>Username</td><td>:</td><td><input type=text name=username></tr>  
                <tr><td>Password</td><td>:</td><td><input type="password" name=password></tr>  
                <tr></tr>
                
                <tr><td colspan="3" align="right">
                    <input type="hidden" name="leveluser" value="customer"/>
                    <input type="submit" value="Save"/></td>
                </tr>
            </table>
                       
        </form>
    </body>
</html>