import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Crear un objeto Welcome y pasarle el objeto Stage
        bienvenida welcome = new bienvenida(primaryStage);

        // Obtener el VBox de la clase Welcome y establecerlo como la escena principal
        primaryStage.setScene(new Scene(welcome.getVBox(), 500, 500));

        // Establecer la escena principal de la ventana principal
        primaryStage.setScene(primaryStage.getScene());
         
        // Establecer la hoja de estilo para la escena
        primaryStage.getScene().getStylesheets().add("style.css");

        // Establecer el título de la ventana principal
        primaryStage.setTitle("Bienvenido");
        // Mostrar la ventana principal
        primaryStage.show();

       
    }

    public static void main(String[] args) {
        launch(args);
    }
}