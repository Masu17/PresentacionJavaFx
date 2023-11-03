module com.aguerecoders.presentacionjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.aguerecoders.presentacionjavafx to javafx.fxml;
    exports com.aguerecoders.presentacionjavafx;
    exports com.aguerecoders.presentacionjavafx.controller;
    opens com.aguerecoders.presentacionjavafx.controller to javafx.fxml;
}