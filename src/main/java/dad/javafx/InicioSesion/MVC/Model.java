package dad.javafx.InicioSesion.MVC;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;

public class Model {

	private String usuario;
	private String pass;
	

	public Model(String name, String password) {

		usuario = name;
		this.pass = password;

	}

	public String getPassword() {
		return pass;
	}

	public void setPassword(String password) {
		this.pass = password;
	}

	public String getUserName() {
		return usuario;
	}

	public void setUserName(String userName) {
		this.usuario = userName;
	}

	public boolean checkUserInfo() {

		boolean matches = false;
		boolean userExists = false;
		boolean passExists = false;

		int userPosition = 0, passPosition = 0;

		ArrayList<String> users = new ArrayList<String>();
		ArrayList<String> passcodes = new ArrayList<String>();

		try {
			
			// lectura del fichero

			String fileName = "users.csv";
			File file = new File(fileName);
			Scanner inputStream = new Scanner(file);

			while (inputStream.hasNext()) {
				String data = inputStream.next();
				String[] pass = data.split(",");

				// recogida lista de usuarios
				users.add(pass[0]);

				// recogida lista de contraseñas
				passcodes.add((pass[1]));
			}
			inputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < users.size(); i++) {

			if (users.get(i).equals(usuario) == true) {
				userPosition = i;
				userExists = true;
			}

			if (passcodes.get(i).equals(stringToMd5(getPassword())) == true) {
				passPosition = i;
				passExists = true;
			}

		}
		matches = (userPosition == passPosition && userExists == true && passExists == true) ? true : false;
		return matches;

	}

	private String stringToMd5(String pass) {
		String md5 = DigestUtils.md5Hex(pass).toUpperCase();
		return md5;
	}

}