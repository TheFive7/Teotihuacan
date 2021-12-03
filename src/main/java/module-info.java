module teotihuacan.teotihuacan {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens teotihuacan.teotihuacan to javafx.fxml;
    exports teotihuacan.teotihuacan;
}