module teotihuacan.teotihuacan {
    requires javafx.controls;
    requires javafx.fxml;


    opens teotihuacan.teotihuacan to javafx.fxml;
    exports teotihuacan.teotihuacan;
}