package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException { 
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String confSenha = request.getParameter("senha2");
		
		if ( nome != null && !nome.isEmpty() && email != null && !email.isEmpty() && senha != null && !senha.isEmpty() &&  confSenha != null && !confSenha.isEmpty()){
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("mensagem", "Deu certo!");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("mensagem", "Deu erro!");
			rd.forward(request, response);
		}
	
	}

}
