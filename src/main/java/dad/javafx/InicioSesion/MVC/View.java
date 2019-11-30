package dad.javafx.InicioSesion.MVC;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class View extends VBox {

	private Label userLabel;
	private Label passwordLabel;
	private PasswordField passField;
	private TextField userField;
	private Button accessButton;
	private Button cancelButton;

	public View() {

		super();

		userLabel = new Label("Usuario:");
		passwordLabel = new Label("Contraseña:");

		userField = new TextField();
		userField.setPromptText("Usuario");

		passField = new PasswordField();
		passField.setPromptText("Contraseña");

		accessButton = new Button("Acceder");
		accessButton.setPrefWidth(60);

		cancelButton = new Button("Cancelar");
		cancelButton.setPrefWidth(65);

		GridPane userPassbox = new GridPane();
		userPassbox.add(userLabel, 0, 0);
		userPassbox.add(passwordLabel, 0, 1);
		userPassbox.add(userField, 1, 0);
		userPassbox.add(passField, 1, 1);
		userPassbox.setAlignment(Pos.BASELINE_CENTER);
		userPassbox.setVgap(15);
		userPassbox.setHgap(35);
		userPassbox.setGridLinesVisible(false);

		ColumnConstraints[] cols1 = { new ColumnConstraints(), new ColumnConstraints(), };
		userPassbox.getColumnConstraints().setAll(cols1);

		cols1[0].setHalignment(HPos.LEFT);
		cols1[1].setFillWidth(true);

		HBox buttonBox = new HBox();
		buttonBox.getChildren().addAll(accessButton, cancelButton);
		buttonBox.setSpacing(10);
		buttonBox.setAlignment(Pos.CENTER);

		this.setSpacing(15);
		this.setAlignment(Pos.CENTER);
		this.setPrefHeight(20);
		this.getChildren().addAll(userPassbox, buttonBox);
		this.setPadding(new Insets(30, 50, 50, 5));

	}

	public PasswordField getPassField() {
		return passField;
	}

	public TextField getUserField() {
		return userField;
	}

	public Button getAccessButtonn() {
		return accessButton;
	}

	public Button getCancelButton() {
		return cancelButton;
	}
}