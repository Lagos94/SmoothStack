package com.ss.lms;

/**@author: Juan Lagos
 * @version: 1.0
 * @since 08/05/19
 */

import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static javafx.geometry.Pos.CENTER;

public class LibManSys extends VBox {
    private TableView<LMS> placeholder = new TableView<LMS>();
    private final ObservableList<LMS> data =
            FXCollections.observableArrayList(
                    new LMS("The Philosopher's Stone", "J. K. Rowling", "Bloomsbury Publishing"),
                    new LMS("The Chamber of Secrets", "J. K. Rowling", "Bloomsbury Publishing"),
                    new LMS("The Prisoner of Azkaban", "J. K. Rowling", "Bloomsbury Publishing"),
                    new LMS("Running with the Family", "Michael Ondaatje", "Vintage"),
                    new LMS("The Cure for All Cancers", "Hulda Regehr Clarke", "New Century Press")
            );

    LibManSys(Stage stage) {
        placeholder.setEditable(true);
        final Label title = new Label("Library Management System");
        title.setAlignment(CENTER);
        title.setFont(new Font("Times New Roman", 25));

        /**
         * 'LMS' columns with the ability to bubble sort data in increasing or decreasing value.
         */

        TableColumn bookNameCol = new TableColumn("Book Name");
        bookNameCol.setMinWidth(150);
        bookNameCol.setCellValueFactory(
                new PropertyValueFactory<LMS, String>("bookName"));
        bookNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        bookNameCol.setOnEditCommit(
                new EventHandler<CellEditEvent<LMS, String>>() {
                    @Override

                    /**
                     * @param handle each column contains this method to rearrange data based
                     * on user input and bubbleSort increasing/decreasing order. Also enables the user to edit data.
                     */

                    public void handle(CellEditEvent<LMS, String> aN) {
                        ((LMS) aN.getTableView().getItems().get(aN.getTablePosition().getRow())).setBookName(aN.getNewValue());
                    }
                }
        );

        /**
         * 'Author' column with the ability to bubble sort data in increasing or decreasing value.
         */

        TableColumn authorCol = new TableColumn("Author");
        authorCol.setMinWidth(150);
        authorCol.setCellValueFactory(
                new PropertyValueFactory<LMS, String>("author"));
        authorCol.setCellFactory(TextFieldTableCell.forTableColumn());
        authorCol.setOnEditCommit(
                new EventHandler<CellEditEvent<LMS, String>>() {
                    @Override
                    public void handle(CellEditEvent<LMS, String> mC) {
                        ((LMS) mC.getTableView().getItems().get(mC.getTablePosition().getRow())).setAuthor(mC.getNewValue());
                    }
                }
        );

        TableColumn publisherCol = new TableColumn("Publisher");
        publisherCol.setMinWidth(150);
        publisherCol.setCellValueFactory(
                new PropertyValueFactory<LMS, String>("Publisher"));
        publisherCol.setCellFactory(TextFieldTableCell.forTableColumn());
        publisherCol.setOnEditCommit(
                new EventHandler<CellEditEvent<LMS, String>>() {
                    @Override
                    public void handle(CellEditEvent<LMS, String> hP) {
                        ((LMS) hP.getTableView().getItems().get(hP.getTablePosition().getRow())).setPublisher(hP.getNewValue());
                    }
                }
        );

        //combine all 3 columns to form 1 table called placeholder.
        placeholder.setItems(data);
        placeholder.getColumns().addAll(bookNameCol, authorCol, publisherCol);

        // 3 textfields in which the user can input new book/author/publisher values.
        final TextField addBookName = new TextField();
        addBookName.setMaxSize(400, 1);
        addBookName.setPromptText("Book name");
        addBookName.setMaxWidth(bookNameCol.getPrefWidth());
        final TextField addAuthor = new TextField();
        addAuthor.setMaxWidth(authorCol.getPrefWidth());
        addAuthor.setPromptText("Author");
        final TextField addPublisher = new TextField();
        addPublisher.setMaxWidth(publisherCol.getPrefWidth());
        addPublisher.setPromptText("Publisher");

        /** two buttons are made accessible to the user: Add & Delete. Aside from column title button and
         * the ability to edit by double clicking textfied, these two buttons take care of manipulating data
         * more directly and organized.
         *
         * @param addButton takes care of adding new data field whenever user has filled all 3 textfields.
         * @param deleteButton takes care of erasing any data, including pre-existing data or newly added data.
         */

        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new LMS(
                        addBookName.getText(),
                        addAuthor.getText(),
                        addPublisher.getText()));
                addBookName.clear();
                addAuthor.clear();
                addPublisher.clear();
            }
        });

        final Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> {
            int selectedIdx = placeholder.getSelectionModel().getSelectedIndex();
            if (selectedIdx != -1) {
                LMS itemToRemove = placeholder.getSelectionModel().getSelectedItem();

                int newSelectedIdx =
                        (selectedIdx == placeholder.getItems().size() - 1)
                                ? selectedIdx - 1
                                : selectedIdx;

                placeholder.getItems().remove(selectedIdx);
                placeholder.getSelectionModel().select(newSelectedIdx);

                //Display removal procedure to console
                System.out.println("Selected Index: " + selectedIdx);
                System.out.println("Item: " + itemToRemove);
            }
        });

        //@param presentData focuses on placement of buttons and textfield.
        final HBox presentData = new HBox();
        presentData.getChildren().addAll(addBookName, addAuthor, addPublisher, addButton, deleteButton);
        presentData.setSpacing(10);
        presentData.setAlignment(CENTER);

        setSpacing(5);

        if (stage.isMaximized())
            setPadding(new Insets(150, 650, 650, 650));
        else
            setPadding(new Insets(0,0,0,0));

        getChildren().addAll(title, placeholder, presentData);
        setAlignment(CENTER);
    }
}