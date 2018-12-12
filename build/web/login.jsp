<%-- 
    Document   : login
    Created on : 03/10/2018, 16:10:37
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
<title>Nutrichef Brasília</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
<body>
    <div class="loginbox">
    <img src="css/avatar.png" class="avatar">
        <h1>Nutrichef</h1>
        <form action = "valida_login.do" method = "post">
            <p>Login</p>
            <input type="text" name="login" placeholder="Digite seu Login">
            <p>Senha</p>
            <input type="password" name="senha" placeholder="Digite sua Senha">
            <input type="submit" name="" value="Entrar">
           
        </form>
        
    </div>

</body>
</head>
</html>