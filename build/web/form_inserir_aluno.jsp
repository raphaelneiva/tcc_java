<%-- 
    Document   : form_inserir_aluno
    Created on : 20/11/2018, 17:28:10
    Author     : Raphael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/style_index.css">
        <link rel="stylesheet" href="css/buttons.css">
        <link rel="stylesheet" href="css/forms.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NutriChef - Escola de Culinária</title>
    </head>
    <body>
        <div class="principal">
        <div class="imgcontainer">
            <img src="img/logo.PNG" alt="Avatar" class="avatar">
        </div>
        <%@include file="menu.jsp" %>
        <h1 id="form">Novo Aluno</h1>
        <form class="form" action="inserir_aluno.do" method="post">
            <label id="ver">Nome:</label><br/><input id="for" type="text" name="nome" size="60" placeholder="Nome" required/><br/><br/>
            <label id="ver">Email:</label><br/><input id="for" type ="email" name ="email" size="60" placeholder="Email" required/><br/><br/>
            <label id="ver">Telefone:</label><br/><input id="for" type ="text" name ="telefone" size="60" placeholder="Telefone" required/><br/><br/> 
            
            <br/><label id="ver">Status: </label><br/>
            <select name = "status" size = "1" required>
                <option value="">Selecione...</option>
                <option value="1 - Interesse geral">1 - Interesse geral</option>
                <option value="2 - Interesse específico">2 - Interesse específico</option>
                <option value="3 - Inscrição confirmada">3 - Inscrição confirmada</option>
                <option value="4 - Pagamento confirmado">4 - Pagamento confirmado</option>
                <option value="5 - Confirmar presença">5 - Confirmar presença</option>
                <option value="6 - Aluno compareceu a aula">6 - Aluno compareceu a aula</option>
                <option value="7 - Aluno com crédito">7 - Aluno com crédito</option>
                <option value="7.1 - Aluno crédito parcial">7.1 - Aluno com crédito parcial</option>
                <option value ="8 - Devolução do dinheiro">8 - Devolução do dinheiro</option>
            </select>
            <br/> <br/>
            <input class="button" type="submit" value="Inserir"/>
        </form>
        </div>
    </body>
</html>
