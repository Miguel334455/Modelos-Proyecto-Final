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

public class crearpaper{

    private VBox vbox;

    public crearpaper(Stage popupStage) {
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        popupStage.setTitle("Crear Paper");

        //Nombre del documento
        Label nameLabel = new Label("Nombre:");
        TextField nameField = new TextField();
        vbox.getChildren().addAll(nameLabel, nameField);
        vbox.setMargin(nameField, new Insets(0, 50,10, 50));

        //Numero de paginas
        Label pagesLabel = new Label("Paginas:");
        TextField pagesField = new TextField();
        vbox.getChildren().addAll(pagesLabel, pagesField);
        vbox.setMargin(pagesField, new Insets(0, 50,10, 50));

        //agrergar el campo de ISBN
        Label smmLabel = new Label("SMM:");
        TextField smmField = new TextField();
        vbox.getChildren().addAll(smmLabel, smmField);
        vbox.setMargin(smmField, new Insets(0, 50,10, 50));


         //agregar el campo de fecha de publicacion
        Label publicationDateLabel = new Label("Fecha de Publicacion:");
        DatePicker publicationDatePicker = new DatePicker();
        vbox.getChildren().addAll(publicationDateLabel, publicationDatePicker);
        vbox.setMargin(publicationDatePicker, new Insets(0, 50,10, 50));


        
        //Nombre del autor
        Label authorLabel = new Label("Autor:");
        TextField authorField = new TextField();
        vbox.getChildren().addAll(authorLabel, authorField);
        vbox.setMargin(authorField, new Insets(0, 50,10, 50));

        //Correo del autor
        Label emailLabel = new Label("Correo:");
        TextField emailField = new TextField();
        vbox.getChildren().addAll(emailLabel, emailField);
        vbox.setMargin(emailField, new Insets(0, 50,10, 50));

        //Direccion del autor
        Label addressLabel = new Label("Direccion:");
        TextField addressField = new TextField();
        vbox.getChildren().addAll(addressLabel, addressField);
        vbox.setMargin(addressField, new Insets(0, 50,10, 50));


        //telefono del autor
        Label phoneLabel = new Label("Telefono:");
        TextField phoneField = new TextField();
        vbox.getChildren().addAll(phoneLabel, phoneField);
        vbox.setMargin(phoneField, new Insets(0, 50,10, 50));
        





        //agregar el campo de SMM
        smmField.setPrefWidth(200);
        // Crear el boton de crear
        Button createButton = new Button("Crear");
        createButton.setOnAction(e -> {
            //obtener los valores de los campos
            String pages = pagesField.getText();
            String email = emailField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String name = nameField.getText();
            String author = authorField.getText();
            String smm = smmField.getText();
            LocalDate publicationDate = publicationDatePicker.getValue();



            //mostrar un mensaje de confirmacion
            Alert confirmationDialog = new Alert(AlertType.CONFIRMATION);
            confirmationDialog.setTitle("Confirmacion");
            confirmationDialog.setHeaderText("Estas Seguro de crear un nuevo Documento?");
            confirmationDialog.setContentText("Nombre: " + name + "\n" +"Paginas: " + pages + "\n" +"smm: " + smm + "\n" +"Fecha de Publicacion: " + publicationDate + "\n" + "Autor: " + author + "\n" + "Email: " + email + "\n" + "Direccion: " + address + "\n" + "Telefono: " + phone);

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

    public void setVBox(VBox vbox){
        this.vbox = vbox;
    }
}


