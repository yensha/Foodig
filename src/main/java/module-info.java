module org.example.foodig_v2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.foodig_v2 to javafx.fxml;
    exports org.example.foodig_v2;

    exports org.example.foodig_v2.Mouse;
    opens org.example.foodig_v2.Mouse to javafx.fxml;
//    exports org.example.foodig_v2.Controller;
//    opens org.example.foodig_v2.Controller to javafx.fxml;
}