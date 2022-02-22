package crudUsuario;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		Usuario user = new Usuario("lisbela", "jakundo ferreira 123", "9124");
		
		Dao dao = new Dao();
		
		
		//dao.insert(user);
		System.out.println(dao.select().toString());

	}

}
