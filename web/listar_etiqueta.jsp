<%-- 
    Document   : listar_etiqueta
    Created on : 30/11/2018, 22:23:35
    Author     : Raphael
--%>

<%@page import="modelo.EtiquetaDAO"%>
<%@page import="modelo.Etiqueta"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">
            function excluir (id, nome){
                if(confirm("Tem certeza que deseja excluir a etiqueta "+ nome +" ?")){
                    window.open("excluir_etiqueta.do?id="+id,"_parent");
                }
            }
        </script>    
        <title>Nutrichef</title>
    </head>
    <body>
        <%@include file="menu.jsp"%>
        <h1> Lista de Etiquetas (<a href="form_inserir_etiqueta.jsp"> Adicionar </a>) </h1>
        <table> 
            <tr>
                <td>NOME</td>
                <td>ALUNO</td>
                <td>CURSO</td>
                <td>OPÇÕES</td>
            </tr>
            
            <%
                ArrayList<Etiqueta> lista = new ArrayList<Etiqueta>();
                EtiquetaDAO eDAO = new EtiquetaDAO();
                try {
                       lista = eDAO.listar();
                    
                    } catch (Exception e) {
                        out.print("Erro: " + e);
                    }
                    
                    for(Etiqueta e:lista) {
            %>    
            
            <tr>    
                
                 <td><%=e.getNome() %></td>
                <td><%=e.getAluno().getNome() %></td>
                <td><%=e.getCurso().getNome() %></td>
                <td><a href="form_alterar_etiqueta.jsp?id=<%=e.getId() %>"> Alterar </a> <a href="#" onclick="excluir(<%=e.getId() %>, '<%=e.getNome() %>')"> Excluir </a> </td>
            </tr>
            
            
            <%
            }
            %>
        </table>
    </body>
</html>
