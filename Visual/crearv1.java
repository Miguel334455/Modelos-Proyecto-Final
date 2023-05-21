import java.time.LocalDate;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class crearv1{

    private VBox vbox;

    public crearv1(Stage popupStage) {
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        //Nombre del documento
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        vbox.getChildren().addAll(nameLabel, nameField);
        vbox.setMargin(nameField, new Insets(0, 50,10, 50));

        //Tipo de documento
        Label typeLabel = new Label("Type:");
        ComboBox<String> typeComboBox = new ComboBox<>();
        typeComboBox.getItems().addAll("Ponencia", "Articulo", "Libro");
        typeComboBox.getSelectionModel().selectFirst();
        typeComboBox.setPrefWidth(300);
        vbox.getChildren().addAll(typeLabel, typeComboBox);
        vbox.setMargin(typeComboBox, new Insets(0, 50,10, 50));
        
        //Nombre del autor
        Label authorLabel = new Label("Author:");
        TextField authorField = new TextField();
        vbox.getChildren().addAll(authorLabel, authorField);
        vbox.setMargin(authorField, new Insets(0, 50,10, 50));



        //agrergar el campo de ISBN
        Label isbnLabel = new Label("ISBN:");
        TextField isbnField = new TextField();
        vbox.getChildren().addAll(isbnLabel, isbnField);
        vbox.setMargin(isbnField, new Insets(0, 50,10, 50));

        //agregar el campo de fecha de publicacion
        Label publicationDateLabel = new Label("Publication Date:");
        DatePicker publicationDatePicker = new DatePicker();
        vbox.getChildren().addAll(publicationDateLabel, publicationDatePicker);
        vbox.setMargin(publicationDatePicker, new Insets(0, 50,10, 50));

        isbnField.setPrefWidth(200);
        // Crear el boton de crear
        Button createButton = new Button("Create");
        createButton.setOnAction(e -> {
            String type = typeComboBox.getSelectionModel().getSelectedItem();
            String name = nameField.getText();
            String author = authorField.getText();
            String isbn = isbnField.getText();
            LocalDate publicationDate = publicationDatePicker.getValue();

            //mostrar un mensaje de confirmacion
            Alert confirmationDialog = new Alert(AlertType.CONFIRMATION);
            confirmationDialog.setTitle("Confirmacion");
            confirmationDialog.setHeaderText("Estas Seguro de crear un nuevo Documento?");
            confirmationDialog.setContentText("Nombre: "+name+"\nAutor: " + author + "\nISBN: " + isbn + "\nFecha de Publicacion: " + publicationDate.toString());

            Optional<ButtonType> result = confirmationDialog.showAndWait();
            // crear el documento
            if (result.isPresent() && result.get() == ButtonType.OK) {
                //logica
                popupStage.close();
            }
        });
        vbox.getChildren().add(createButton);
        this.vbox = vbox;
    }

    public VBox getVBox(){
        return vbox;
    }
}
