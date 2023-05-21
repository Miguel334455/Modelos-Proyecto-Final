import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;

public class bienvenida{
    private Stage primaryStage;
    private final VBox vbox;

    public bienvenida(Stage primaryStage){

        this.primaryStage = primaryStage;

        primaryStage.getIcons().add(new Image("logo.png"));
        // Crear un VBox para contener los componentes de la interfaz de usuario
        VBox vbox = new VBox();

        ImageView logoImageView = new ImageView(new Image("logo.png"));
        // Establecer el tamaño de la imagen
        logoImageView.setFitWidth(200);
        logoImageView.setFitHeight(200);

        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);

        // Crear un letrero de bienvenida
        Label welcomeLabel = new Label("Bienvenido");
        vbox.getChildren().add(welcomeLabel);

        // Crear un botón para registrar un nuevo usuario
        Button registerButton = new Button("Registrarse");
        registerButton.setOnAction(event -> {
            // Lógica para abrir la ventana de registro
            registrov1 userRegistration = new registrov1(primaryStage, popupStage);
            Scene scene = new Scene(userRegistration.getGrid(), 600, 300);
            popupStage.setScene(scene);
            scene.getStylesheets().add("style.css");
            popupStage.show();

        });

        // Crear un botón para iniciar sesión
        Button loginButton = new Button("Iniciar sesión");
        loginButton.setOnAction(event -> {
            // Lógica para abrir la ventana de inicio de sesión
            loginv1 login = new loginv1(popupStage, primaryStage);
            Scene scene = new Scene(login.getVBox(), 500, 500);
            popupStage.setScene(scene);
            scene.getStylesheets().add("style.css");
            popupStage.show();
        });

        // Agregar los botones al VBox
        vbox.setSpacing(20);
        vbox.getChildren().addAll(logoImageView,registerButton, loginButton);

        vbox.setAlignment(Pos.CENTER);

        // Establecer el tamaño de los botones
        registerButton.setPrefWidth(200);
        loginButton.setPrefWidth(200);

        this.vbox = vbox;

    }

    public VBox getVBox() {
        return vbox;
    }
}