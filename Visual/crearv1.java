import java.util.Optional;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;

public class crearv1 {
    
    private final VBox vbox;
    private final Stage popupStage;

    public crearv1(Stage popupStage) {

        this.popupStage = popupStage;
        
        // Agrega la imagen del logo a la ventana de reserva
        Image logoImage = new Image("logo.png");
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitWidth(200);
        logoImageView.setPreserveRatio(true);
       

        
        // Crea una ComboBox para mostrar la lista de documentos disponibles
        ComboBox<String> documentComboBox = new ComboBox<>();
        documentComboBox.getItems().addAll("Ponencia", "Paper", "Libro");
        documentComboBox.getSelectionModel().selectFirst();

        // Crea un botón para reservar el documento seleccionado
        Button reserveButton = new Button("Reservar");

        reserveButton.setOnAction(reserveEvent -> {
          String selectedDocument = documentComboBox.getSelectionModel().getSelectedItem();
     
         if (selectedDocument.equals("Ponencia")) {
            crearponencia crearponencia = new crearponencia(popupStage);
            popupStage.setScene(new Scene(crearponencia.getVBox(), 800, 600));
            popupStage.getScene().getStylesheets().add("style.css");
            popupStage.show();
        } else if (selectedDocument.equals("Paper")) {
                crearpaper crearpaper = new crearpaper(popupStage);
                popupStage.setScene(new Scene(crearpaper.getVBox(), 800, 600));
                popupStage.getScene().getStylesheets().add("style.css");
                popupStage.show();
        } else if (selectedDocument.equals("Libro")) {
                crearlibro crearlibro = new crearlibro(popupStage);
                popupStage.setScene(new Scene(crearlibro.getVBox(), 800, 600));
                popupStage.getScene().getStylesheets().add("style.css");
                popupStage.show();
       }
        });
        
     

        // Crea un diseño para la ventana desplegable
        VBox dropdownLayout = new VBox();
        dropdownLayout.setSpacing(30);
        dropdownLayout.setAlignment(Pos.CENTER);
        dropdownLayout.setPadding(new Insets(10, 50, 50, 50));
        dropdownLayout.getChildren().addAll(logoImageView,documentComboBox, reserveButton);
        

        //Guardar vbox
        
      
        this.vbox = dropdownLayout;
        
    }

    public VBox getVBox() {
        return vbox;
    }

 

}