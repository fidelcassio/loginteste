package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Usuario;

public class UsuarioDAO {
	
	public Usuario buscaUsuario(Usuario user){
		Connection conn = null;
		PreparedStatement prepStatement = null;
		Usuario usuario = null;
		
		String sql = "SELECT nome, email, senha FROM usuario WHERE email = ?";
		
		try{
			conn = this.getConnection();
			prepStatement = conn.prepareStatement(sql);
			
			prepStatement.setString(1, user.getEmail());
			ResultSet result = prepStatement.getResultSet();
			while(result.next()){
				String nome = result.getString("nome");
				String email = result.getString("email");
				String senha = result.getString("senha");
				usuario = new Usuario(nome,email,senha);
			}
			return usuario;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public void insertUsuario(Usuario user){
		Connection conn = null;
		PreparedStatement prepStatement = null;
		
		String sql = "INSERT INTO usuario VALUES (?,?,?)";
		
		try{
			conn = this.getConnection();
			prepStatement = conn.prepareStatement(sql);
			
			prepStatement.setString(1, user.getNome());
			prepStatement.setString(2, user.getEmail());
			prepStatement.setString(3, user.getSenha());
			prepStatement.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteUsuario(Usuario user){
		Connection conn = null;
		PreparedStatement prepStatement = null;
		
		String sql = "DELETE FROM usuario WHERE email = ?";
		
		try{
			conn = this.getConnection();
			prepStatement = conn.prepareStatement(sql);
			
			prepStatement.setString(1, user.getEmail());
			prepStatement.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void updateUsuario(Usuario user){
		Connection conn = null;
		PreparedStatement prepStatement = null;
		
		String sql = "UPDATE usuario SET nome = ?, senha = ? WHERE email = ?";
		
		try{
			conn = this.getConnection();
			prepStatement = conn.prepareStatement(sql);
			
			prepStatement.setString(1, user.getNome());
			prepStatement.setString(2, user.getSenha());
			prepStatement.setString(3, user.getEmail());
			prepStatement.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	public Connection getConnection(){
		
	}

}
