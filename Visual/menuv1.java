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
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDate;
import java.time.Month;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Toggle;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class menuv1 {
    private Stage primaryStage;
    private final BorderPane border;
    
    
    public menuv1(Stage primaryStage) {
        this.primaryStage = primaryStage;
        
        primaryStage.setTitle("Biblioteca");
        //primaryStage.initStyle(StageStyle.UNDECORATED); 
        primaryStage.getIcons().add(new Image("logo.png"));

        BorderPane root = new BorderPane();

        // Crea una barra de menú
        MenuBar menuBar = new MenuBar();

         // Crea un menú
        Menu libraryMenu = new Menu("Menú");

         // Crea elementos de menú
        MenuItem reserveMenuItem = new MenuItem("Reservar");
        MenuItem unsubscribeMenuItem = new MenuItem("Cancelar suscripción");
        MenuItem createMenuItem = new MenuItem("Crear");

    Stage popupStage = new Stage();
    popupStage.initModality(Modality.APPLICATION_MODAL);

    reserveMenuItem.setOnAction(event1 -> {
     // Crea la escena y muestra la ventana emergente
    reservarv1 reservedoc = new reservarv1(popupStage);
    Scene popupScene = new Scene(reservedoc.getVBox(), 400, 450);
    popupStage.setScene(popupScene);
    popupStage.setTitle("Reservar documento");
    popupScene.getStylesheets().add("style.css");
    popupStage.showAndWait();

    });

    createMenuItem.setOnAction(event -> {
    // Crea una nueva etapa para la ventana emergente
    popupStage.setTitle("Crear documento");

    // Crea la escena y muestra la ventana emergente
    crearv1 createdoc=new crearv1(popupStage);
    Scene popupScene = new Scene(createdoc.getVBox(), 400, 600);
    popupStage.setScene(popupScene);
    popupScene.getStylesheets().add("style.css");
    popupStage.showAndWait();
    
    });
    
        // Agrega elementos de menú al menú
        libraryMenu.getItems().addAll (reserveMenuItem, unsubscribeMenuItem, createMenuItem);

        // Agrega los menús a la barra de menú
        menuBar.getMenus().addAll(libraryMenu);
   
   
        // Agrega la barra de menú a la raíz del panel
        root.setTop(menuBar);

        // Crea un GridPane para los controles de búsqueda
        GridPane searchPane = new GridPane();
        searchPane.setPadding(new Insets(10));
        searchPane.setHgap(10);
        searchPane.setVgap(10);
      

        // Crea una etiqueta para el campo de búsqueda
        Label searchLabel = new Label("Buscar:");

        // Crea un cuadro de texto para la consulta de búsqueda
        TextField searchField = new TextField();
        searchField.setPrefColumnCount(30);

        // Crea un botón para iniciar la búsqueda
        Button searchButton = new Button("Buscar");

        // Agrega la etiqueta, el cuadro de texto y el botón al panel de búsqueda
        searchPane.add(searchLabel, 0, 0);
        searchPane.add(searchField, 1, 0);
        searchPane.add(searchButton, 2, 0);

        // Agrega el panel de búsqueda a la raíz del panel
        root.setLeft(searchPane);
        
        Label titleLabel = new Label("Biblioteca");
        titleLabel.setId("titlelabel");
       
        titleLabel.setPadding(new Insets(3));
        titleLabel.setPrefWidth(Region.USE_COMPUTED_SIZE);
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setMaxWidth(Double.MAX_VALUE);

        TableView<Book> tableView = new TableView<>();

        TableColumn<Book, String> titleColumn = new TableColumn<>("Título");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        titleColumn.setPrefWidth(200);

        TableColumn<Book, LocalDate> publicationDateColumn = new TableColumn<>("Fecha de publicación");
        publicationDateColumn.setCellValueFactory(new PropertyValueFactory<>("publicationDate"));
        titleColumn.setPrefWidth(200);

        TableColumn<Book, String> authorsColumn = new TableColumn<>("Autores");
        authorsColumn.setCellValueFactory(new PropertyValueFactory<>("authors"));
        titleColumn.setPrefWidth(200);

        TableColumn<Book, String> isbnColumn = new TableColumn<>("ISBN");
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        titleColumn.setPrefWidth(200);

        TableColumn<Book, Month> publicationMonthColumn = new TableColumn<>("Mes de publicación");
        publicationMonthColumn.setCellValueFactory(new PropertyValueFactory<>("publicationMonth"));
        titleColumn.setPrefWidth(200);

        TableColumn<Book, Integer> publicationDayColumn = new TableColumn<>("Día de publicación");
        publicationDayColumn.setCellValueFactory(new PropertyValueFactory<>("publicationDay"));
        titleColumn.setPrefWidth(200);

        TableColumn<Book, String> publisherColumn = new TableColumn<>("Editorial");
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        titleColumn.setPrefWidth(200);

        ObservableList<Book> books = FXCollections.observableArrayList();

      
        Book book1 = new Book("Java 8", LocalDate.of(2014, Month.MARCH, 18), "Oracle Press", "978-0071835796");
        books.add(book1);
       
        Book book2 = new Book("JavaFX 8", LocalDate.of(2014, Month.MARCH, 18), "Oracle Press", "978-0071842558");
       
        tableView.setItems(books);

       tableView.getColumns().addAll(titleColumn, publicationDateColumn, authorsColumn, isbnColumn, publicationMonthColumn, publicationDayColumn, publisherColumn);


tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

// Create a context menu with a delete item
ContextMenu contextMenu = new ContextMenu();
MenuItem deleteItem = new MenuItem("Eliminar");
deleteItem.setOnAction(event -> {
    Book selectedBook = tableView.getSelectionModel().getSelectedItem();
    if (selectedBook != null) {
        tableView.getItems().remove(selectedBook);
    }
});
Author  author = new Author("Herbert Schildt", "555-12345", "123 Main Street");

MenuItem seeMoreDetailsItem = new MenuItem("Ver más detalles del autor");
seeMoreDetailsItem.setOnAction(event -> {
    Book selectedBook = tableView.getSelectionModel().getSelectedItem();
    if (selectedBook != null) {
        //Author author = selectedBook.getAuthor();
        String message = "Teléfono: " + author.getPhoneNumber() + "\n" +
                         "Dirección: " + author.getAddress() + "\n" +
                         "Correo electrónico: " + author.getEmailAddress();
        Alert alert = new Alert(AlertType.INFORMATION, message);
        alert.setTitle("Detalles del autor");
        alert.setHeaderText(author.getName());
        alert.showAndWait();
    }
});


Document document= new Document("Java 8", LocalDate.of(2014, Month.MARCH, 18), Arrays.asList("Java 8", "JavaFX 8", "Android"));

MenuItem viewDocumentDetailsItem = new MenuItem("Ver detalles del documento");
viewDocumentDetailsItem.setOnAction(event -> {
    // Code to display the details of the selected document
    String message = "Creado por: " + document.getName() +"Modificaciones: " + document.getModifications().toString();
    Alert alert = new Alert(AlertType.INFORMATION, message);
    alert.setTitle("Detalles del documento");
    alert.setHeaderText(document.getName());
    alert.showAndWait();
});

contextMenu.getItems().addAll(deleteItem, seeMoreDetailsItem, viewDocumentDetailsItem);


// Set the context menu of the table view
tableView.setContextMenu(contextMenu);


// Set the context menu of the table view
tableView.setContextMenu(contextMenu);

// Create a VBox for the search pane, title label, and list view
        VBox leftBox = new VBox(searchPane, titleLabel, tableView);
          leftBox.setPadding(new Insets(10));
           leftBox.setSpacing(10);

// Add the VBox to the left of the BorderPane
root.setLeft(leftBox);

        // Create a HBox for the buttons
        HBox buttonBox = new HBox();
        buttonBox.setPadding(new Insets(10));
        buttonBox.setSpacing(10);


        VBox centerBox = new VBox(searchPane, titleLabel, tableView);
          centerBox.setPadding(new Insets(10));
            centerBox.setSpacing(10);

        // Add the VBox to the center of the BorderPane
         root.setCenter(centerBox);


        //Save BorderPane
        this.border = root;
        // Create a scene
        Scene scene = new Scene(root, 1000, 700);
    
        // Set the scene on the stage
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show(); 

         scene.getStylesheets().add("style.css");
    
         
    }
       public BorderPane getBorderPane() {
        return border;
       }
    public class Book {
    private String title;
    private LocalDate publicationDate;
    private String authors;
    private String isbn;
    private Month publicationMonth;
    private int publicationDay;
    private String publisher;

    public Book(String title, LocalDate publicationDate, String authors, String isbn) {
        this.title = title;
        this.publicationDate = publicationDate;
        this.authors = authors;
        this.isbn = isbn;
        this.publicationMonth = publicationDate.getMonth();
        this.publicationDay = publicationDate.getDayOfMonth();
    }

   }

   public class Author {
    private String name;
    private String phoneNumber;
    private String address;
    private String emailAddress;

    public Author(String phoneNumber, String address, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
  }

  public class Document {
    private String name;
    private LocalDate fecha;
    private List<String> modifications;

    public Document(String name, LocalDate fecha, List<String> modifications) {
        this.name = name;
        this.fecha=fecha;
        this.modifications = modifications;
    }

    public String getName() {
        return name;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public List<String> getModifications() {
        return modifications;
    }
  }
}



    
    

    












    

