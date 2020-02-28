package city;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

public class Main extends Application {

    private static Stage primaryStage;
    private static BorderPane mainLayout;

    @Override
    public void start(Stage primaryStage) throws IOException, SQLException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("City Application");


        showMainView();
        showMap();


        Town a = new Town("Poznań",1,3,Arrays.asList("Sopot", "Gdansk"));
        DataBaseStuff.saveTownInDB(a);

        System.out.println(DataBaseStuff.getTownsFromDB().get(0).getName());
        System.out.println(DataBaseStuff.getTownsFromDB().get(1).getName());

    }

    private void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/MainView.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showMap() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("map/Map.fxml"));
        AnchorPane map = loader.load();
        mainLayout.setCenter(map);
    }

    public static void showList() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("list/List.fxml"));
        AnchorPane list = loader.load();
        mainLayout.setCenter(list);
    }

    public static void showFind() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("find/Find.fxml"));
        AnchorPane find = loader.load();
        mainLayout.setCenter(find);
    }

    public static void showAdd() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("add/Add.fxml"));
        AnchorPane add = loader.load();
        mainLayout.setCenter(add);
    }


    public static void main(String[] args) {
        launch(args);
    }



}