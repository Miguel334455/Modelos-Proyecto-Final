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

public class loginv1 {
    private final Stage popupStage;
    private final VBox vbox;
    private final Stage welcome;
    
    public loginv1 (Stage popupStage,Stage welcome) {
        this.welcome = welcome;
        this.popupStage = popupStage;
        
        popupStage.getIcons().add(new Image("logo.png"));
        popupStage.setTitle("Inicio de sesión");

        // Crear el diseño de la GUI
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);

        // Agregar espacio para el logotipo
        HBox logoBox = new HBox();
        logoBox.setAlignment(Pos.CENTER);
        logoBox.setPadding(new Insets(20, 0, 20, 0));
        ImageView logoImage = new ImageView(new Image("logo.png"));
        logoImage.setFitHeight(100);
        logoImage.setPreserveRatio(true);
        logoBox.getChildren().add(logoImage);

        Label usernameLabel = new Label("Nombre de usuario:");
        TextField usernameField = new TextField();
        usernameField.setPrefWidth(200);
        usernameField.setAlignment(Pos.CENTER);
        VBox.setMargin(usernameField, new Insets(0, 100, 10, 100));

        Label passwordLabel = new Label("Contraseña:");
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefWidth(200);
        passwordField.setAlignment(Pos.CENTER);
        VBox.setMargin(passwordField, new Insets(0, 100, 10, 100));

        Button loginButton = new Button("Iniciar sesión");
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            if (username.equals("admin") && password.equals("admin")) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Inicio de sesión exitoso");
                alert.setHeaderText(null);
                alert.setContentText("¡Bienvenido, " + username + "!");
                alert.showAndWait();
                // Realice la lógica de inicio de sesión aquí


                popupStage.close();
                welcome.close();

                // Abra la ventana principal
                Stage primaryStage = new Stage();
                primaryStage.setTitle("Menú");
                menuv1 menu = new menuv1(primaryStage);
                Scene scene = new Scene(menu.getBorderPane(), 1000, 700);
                primaryStage.setScene(scene);
                scene.getStylesheets().add("style.css");
                primaryStage.show();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Inicio de sesión inválido");
                alert.setHeaderText("Nombre de usuario o contraseña inválidos");
                alert.setContentText("Por favor, inténtelo de nuevo.");
                alert.showAndWait();
            }

        });

        vbox.getChildren().addAll(logoBox, usernameLabel, usernameField, passwordLabel, passwordField, loginButton);
        this.vbox = vbox;
    
    }

    public VBox getVBox() {
        return vbox;
    }


    
}
