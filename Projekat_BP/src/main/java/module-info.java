module org.unibl.etf.projekat_bp {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.desktop;
    requires java.sql;
    requires jdk.compiler;

    opens org.unibl.etf.projekat_bp to javafx.fxml;
    exports org.unibl.etf.projekat_bp;
    exports org.unibl.etf.projekat_bp.entity;
    opens org.unibl.etf.projekat_bp.entity to javafx.fxml;
    exports org.unibl.etf.projekat_bp.controllers;
    opens org.unibl.etf.projekat_bp.controllers to javafx.fxml;
}