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

public class reservarv1 {
    
    private final VBox vbox;
    private final Stage popupStage;

    public reservarv1(Stage popupStage) {

        this.popupStage = popupStage;
        
        // Agrega la imagen del logo a la ventana de reserva
        Image logoImage = new Image("logo.png");
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitWidth(200);
        logoImageView.setPreserveRatio(true);
       

        
        // Crea una ComboBox para mostrar la lista de documentos disponibles
        ComboBox<String> documentComboBox = new ComboBox<>();
        documentComboBox.getItems().addAll("Documento 1", "Documento 2", "Documento 3");
        documentComboBox.getSelectionModel().selectFirst();

        // Crea un botón para reservar el documento seleccionado
        Button reserveButton = new Button("Reservar");

        reserveButton.setOnAction(reserveEvent -> {
        String selectedDocument = documentComboBox.getSelectionModel().getSelectedItem();
         // Reserva el documento seleccionado
    
        Alert confirmationDialog = new Alert(AlertType.CONFIRMATION);
        confirmationDialog.setTitle("Confirmar reserva");
        confirmationDialog.setHeaderText("¿Estás seguro de querer reservar " + selectedDocument + "?");
        Optional<ButtonType> result = confirmationDialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Reserve el documento seleccionado
            popupStage.close();
        }
        });
        
     

        // Crea un diseño para la ventana desplegable
        VBox dropdownLayout = new VBox();
        dropdownLayout.setSpacing(30);
        dropdownLayout.setAlignment(Pos.CENTER);
        dropdownLayout.setPadding(new Insets(10, 50, 50, 50));
        dropdownLayout.getChildren().addAll(logoImageView,documentComboBox, reserveButton);
        

;
        
      
        this.vbox = dropdownLayout;
        
    }

    public VBox getVBox() {
        return vbox;
    }

 

}
