package com.aguerecoders.presentacionjavafx.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainAppController {

    public TextField nombre;
    public TextField apellido;
    public TextField correo_electronico;
    public Button enviarBttn;
    public TableView<ArrayList<String>> tablaDatos;
    public TableColumn<ArrayList<String>, String> nombreColumn;
    public TableColumn<ArrayList<String>, String> apellidoColumn;
    public TableColumn<ArrayList<String>, String> correoColumn;

    public void initialize() {

        setTableValue();

        ArrayList<String> row = new ArrayList<>();

        row.add("Nombre");
        row.add("Apellido");
        row.add("Correo");

        ObservableList<ArrayList<String>> data = FXCollections.observableArrayList();
        data.add(row);

        tablaDatos.setItems(data);

    }

    public void enviarBotonAction(ActionEvent actionEvent) {

        try {
            setTableValue();

            ObservableList<ArrayList<String>> data = FXCollections.observableArrayList();
            tablaDatos.getItems().forEach(data::add);
            data.add(checkTextField(actionEvent));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Nuevo registro");
            alert.setContentText("Se ha añadido un nuevo registro");
            alert.show();

            tablaDatos.setItems(data);

        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error en los campos");
            alert.setContentText("Por favor, rellene todos los campos");
            alert.show();
        }
    }

    private ArrayList<String> checkTextField(ActionEvent actionEvent) throws RuntimeException {
        ArrayList<String> row = new ArrayList<>();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        ObservableList<Node> children = stage.getScene().getRoot().getChildrenUnmodifiable();
        children.forEach(node -> {
            if (node instanceof TextField textField) {
                if (!((TextField) node).getText().isEmpty()){
                    row.add(textField.getText());
                    textField.setText("");
                } else if (node instanceof  Button boton) {
                    
                } else {
                    throw new RuntimeException();
                }
            }
        });

        return row;
    }

    private void setTableValue() {
        nombreColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));
        apellidoColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));
        correoColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));
    }
}