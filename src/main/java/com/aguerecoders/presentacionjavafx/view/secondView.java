package com.aguerecoders.presentacionjavafx.view;

import com.aguerecoders.presentacionjavafx.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class secondView {

    private Stage secondStage;

    public void show() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("secondView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        secondStage.setTitle("Hola que tal!");
        secondStage.setScene(scene);
        secondStage.show();
    }

    public Stage getSecondStage() {
        return secondStage;
    }

}
