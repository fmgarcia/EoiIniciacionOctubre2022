module electro.electrodofx {
    requires javafx.controls;
    requires javafx.fxml;


    opens electro.electrodofx to javafx.fxml;
    opens model to javafx.base;
    exports electro.electrodofx;
}