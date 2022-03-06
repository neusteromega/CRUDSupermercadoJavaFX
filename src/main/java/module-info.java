module com.pmp.crudjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.pmp.crudjavafx to javafx.fxml;
    exports com.pmp.crudjavafx;
}
