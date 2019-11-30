package dad.javafx.InicioSesion.MVC;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Controller {

	// view
	
	private View view = new View();

	public Controller() {

		view.getAccessButtonn().setOnAction(e -> onAccessButtonAction(e));

	}

	private void onAccessButtonAction(ActionEvent e) {

		Model userData = new Model(view.getUserField().getText(), view.getPassField().getText());

		if (userData.checkUserInfo() == true) {

			Alert correct = new Alert(AlertType.INFORMATION);
			correct.setTitle("Iniciar sesión");
			correct.setHeaderText("Acceso permitido");
			correct.setContentText("Las credenciales de acceso son válidas");
			correct.showAndWait();

		} else {

			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Iniciar sesión");
			error.setHeaderText("Acceso denegado");
			error.setContentText("El usuario y/o la contraseña no son válidos.");
			error.showAndWait();

		}

	}

	public View getView() {
		return view;
	}

}