package city.map;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ResourceBundle;

public class MapController implements Initializable {

    @FXML
    private LineChart<Number, Number> lineChart;

    @FXML
    private NumberAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data(1, 100));
        series.getData().add(new XYChart.Data(3, 23));
        series.getData().add(new XYChart.Data(5, 23));
        series.getData().add(new XYChart.Data(2, 50));
        series.getData().add(new XYChart.Data(1, 70));

        lineChart.getData().addAll(series);
        lineChart.setMaxHeight(450);
        lineChart.setMinHeight(450);
        lineChart.setMaxWidth(700);
        lineChart.setMinWidth(700);
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(0);
        xAxis.setUpperBound(100);
        xAxis.setTickUnit(10);
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(100);
        yAxis.setTickUnit(10);

        Line line = new Line(2,4,10,16);
        series.getData().add(line);
    }
}
