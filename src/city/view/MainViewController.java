package city.view;

import city.Main;
import javafx.fxml.FXML;

import java.io.IOException;

public class MainViewController {

    private Main main;

    @FXML
    private void goMap() throws IOException {
        main.showMap();
    }

    @FXML
    private void goList() throws IOException {
        main.showList();
    }

    @FXML
    private void goFind() throws IOException {
        main.showFind();
    }

    @FXML
    private void goAdd() throws IOException{
        main.showAdd();
    }

}
