module electro.electrodomesticosfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens electro.electrodomesticosfx to javafx.fxml;
    opens modelo to javafx.base;
    exports electro.electrodomesticosfx;
}