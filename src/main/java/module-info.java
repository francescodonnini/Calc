module io.francescodonnini.calc {
    requires javafx.controls;
    requires javafx.fxml;


    opens io.francescodonnini.calc to javafx.fxml;
    exports io.francescodonnini.calc;
    exports io.francescodonnini.calc.error;
    opens io.francescodonnini.calc.error to javafx.fxml;
    exports io.francescodonnini.calc.scanner;
    opens io.francescodonnini.calc.scanner to javafx.fxml;
    exports io.francescodonnini.calc.token;
}