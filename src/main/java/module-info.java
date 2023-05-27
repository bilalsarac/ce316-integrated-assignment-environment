module ieu.edu.tr.iae {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens ieu.edu.tr.iae to javafx.fxml;
    exports ieu.edu.tr.iae;
    exports ieu.edu.tr.iae.controllers;
    opens ieu.edu.tr.iae.controllers to javafx.fxml;
}
