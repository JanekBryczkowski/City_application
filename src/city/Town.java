package city;

import java.util.List;

public class Town {

    private String name;
    private Integer x;
    private Integer y;
    private List connections;

    public Town(String name, Integer x, Integer y, List connections) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.connections = connections;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public List getConnections() {
        return connections;
    }

    public void setConnections(List connections) {
        this.connections = connections;
    }

}
