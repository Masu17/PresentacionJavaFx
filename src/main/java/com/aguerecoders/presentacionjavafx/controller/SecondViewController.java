package com.aguerecoders.presentacionjavafx.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.stream.IntStream;

public class SecondViewController {


    public VBox columnTexts;

    public void crearTextos(ActionEvent actionEvent) {
        IntStream.range(0,3).forEach(i -> {
            columnTexts.getChildren().add(new Text("TEXTO" + i));
        });
    }
}
