import java.time.LocalDate;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        vbox.getChildren().addAll(nameLabel, nameField);
        vbox.setMargin(nameField, new Insets(0, 50,10, 50));

        Label authorLabel = new Label("Author:");
        TextField authorField = new TextField();
        vbox.getChildren().addAll(authorLabel, authorField);
        vbox.setMargin(authorField, new Insets(0, 50,10, 50));

        Label isbnLabel = new Label("ISBN:");
        TextField isbnField = new TextField();
        vbox.getChildren().addAll(isbnLabel, isbnField);
        vbox.setMargin(isbnField, new Insets(0, 50,10, 50));

        Label publicationDateLabel = new Label("Publication Date:");
        DatePicker publicationDatePicker = new DatePicker();
        vbox.getChildren().addAll(publicationDateLabel, publicationDatePicker);
        vbox.setMargin(publicationDatePicker, new Insets(0, 50,10, 50));

        isbnField.setPrefWidth(200);

        Button createButton = new Button("Create");
        createButton.setOnAction(e -> {
            String name = nameField.getText();
            String author = authorField.getText();
            String isbn = isbnField.getText();
            LocalDate publicationDate = publicationDatePicker.getValue();

            // Show a confirmation dialog before creating the document
            Alert confirmationDialog = new Alert(AlertType.CONFIRMATION);
            confirmationDialog.setTitle("Confirmacion");
            confirmationDialog.setHeaderText("Estas Seguro de crear un nuevo Documento?");
            confirmationDialog.setContentText("Nombre: "+name+"\nAutor: " + author + "\nISBN: " + isbn + "\nFecha de Publicacion: " + publicationDate.toString());

            Optional<ButtonType> result = confirmationDialog.showAndWait();
            // Create the document if the user confirms
            if (result.isPresent() && result.get() == ButtonType.OK) {
                //logic
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