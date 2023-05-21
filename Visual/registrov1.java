import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

public class registrov1{
    private Stage primaryStage;
    private Stage popupStage;
    private final GridPane grid;

    public registrov1(Stage primaryStage, Stage popupStage) {
        
        this.primaryStage = primaryStage;
        this.popupStage = popupStage;

        // Crea el formulario de registro
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setAlignment(Pos.CENTER_LEFT);

        // Agregar etiquetas para el nombre de usuario, dirección de correo electrónico y contraseña
        Label nameLabel = new Label("Usuario:");
        Label emailLabel = new Label("Email:");
        Label passwordLabel = new Label("Contraseña:");

        // Agregar campos de texto para el nombre de usuario, dirección de correo electrónico y contraseña
        TextField nameField = new TextField();
        TextField emailField = new TextField();
        PasswordField passwordField = new PasswordField();

        // Agregar un botón para enviar el formulario de registro
        Button submitButton = new Button("Enviar");

        // Agregar una etiqueta de mensaje de error
        Label errorMessageLabel = new Label();
        errorMessageLabel.setVisible(false);

        // Agregar las etiquetas, los campos de texto y el botón a la cuadrícula
        grid.add(nameLabel, 0, 1);
        grid.add(nameField, 1, 1);
        grid.add(emailLabel, 0, 2);
        grid.add(emailField, 1, 2);
        grid.add(passwordLabel, 0, 3);
        grid.add(passwordField, 1, 3);
        grid.add(submitButton, 1, 4);
        grid.setMargin(submitButton, new Insets(0, 0, 0, 55));

        // Agregar espacio para un logotipo
        Image logoImage = new Image("logo.png");
        ImageView logoImageView = new ImageView(logoImage);

        // Agregar una caja vertical
        VBox hbox = new VBox();
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.getChildren().add(logoImageView);
        grid.alignmentProperty().set(Pos.CENTER_LEFT);
        grid.setHgap(10);
        grid.setVgap(15);
        grid.add(hbox, 2, 0, 7, 4); //(columna, fila, columnas que ocupa, filas que ocupa)
        grid.setMargin(hbox, new Insets(50, 10, 35, 15)); //(arriba, derecha, abajo, izquierda)

        logoImageView.setFitHeight(170);
        logoImageView.setFitWidth(170);
        logoImageView.setPreserveRatio(true);

        // Establecer la acción para el botón Enviar
        submitButton.setOnAction(event -> {

            // Validar el nombre de usuario, la dirección de correo electrónico y la contraseña
            String userName = nameField.getText();
            String emailAddress = emailField.getText();
            String password = passwordField.getText();

            // Validar los campos
            if (userName.isEmpty() || emailAddress.isEmpty() || password.isEmpty()) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Por favor, introduzca un nombre de usuario, una dirección de correo electrónico y una contraseña.");
                alert.showAndWait();
            } else if (!emailAddress.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Por favor, introduzca una dirección de correo electrónico válida.");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Información");
                alert.setContentText("Gracias por registrarse, " + userName + ".");
                alert.showAndWait();
                popupStage.close();
            }

            // Limpiar los campos del formulario
            nameField.clear();
            emailField.clear();
            passwordField.clear();

        });

        this.grid = grid;
    }

    public GridPane getGrid() {
        return grid;
    }

}

