package Algorithm;

/**
 * Created by gao27024037 on 2017/4/28.
 */
public class City {
    private int number;

    private double X_Coordinate;

    private double Y_Coordinate;

    @Override
    public String toString() {
        return "City{" +
                "number=" + number +
                ", X_Coordinate=" + X_Coordinate +
                ", Y_Coordinate=" + Y_Coordinate +
                '}';
    }

    public City() {
    }

    public City(int number, double x_Coordinate, double y_Coordinate) {

        this.number = number;
        X_Coordinate = x_Coordinate;
        Y_Coordinate = y_Coordinate;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getX_Coordinate() {
        return X_Coordinate;
    }

    public void setX_Coordinate(int x_Coordinate) {
        X_Coordinate = x_Coordinate;
    }

    public double getY_Coordinate() {
        return Y_Coordinate;
    }

    public void setY_Coordinate(int y_Coordinate) {
        Y_Coordinate = y_Coordinate;
    }

    public double getDistanceToAnother(City otherCity) {
        return Math.sqrt((   Math.pow((this.getX_Coordinate() - otherCity.getX_Coordinate()),2)
                + Math.pow((this.getY_Coordinate() - otherCity.getY_Coordinate()),2)    )/10d);
    }
}
