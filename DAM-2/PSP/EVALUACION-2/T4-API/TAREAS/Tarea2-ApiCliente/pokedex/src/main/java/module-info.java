module com.cafeconpalito.pokedex {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires org.json;
    requires java.net.http;

    opens com.cafeconpalito.pokedex to javafx.fxml;
    exports com.cafeconpalito.pokedex;
}