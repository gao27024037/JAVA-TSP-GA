package Algorithm;

/**
 * Created by gao27024037 on 2017/4/28.
 */
public class City {

    //编号
    private int number;
    //X坐标
    private double X_Coordinate;
    //Y坐标
    private double Y_Coordinate;

    @Override
    public String toString() {
        return "City{" +
                "number=" + number +
                ", X_Coordinate=" + X_Coordinate +
                ", Y_Coordinate=" + Y_Coordinate +
                '}';
    }

    public City(int number, double x_Coordinate, double y_Coordinate) {

        this.number = number;
        X_Coordinate = x_Coordinate;
        Y_Coordinate = y_Coordinate;
    }

    public double getX_Coordinate() {
        return X_Coordinate;
    }

    public double getY_Coordinate() {
        return Y_Coordinate;
    }

    /**
     * 计算2个城市间距离
     * @param otherCity
     * @return
     */
    public double getDistanceToAnother(City otherCity) {
        return Math.sqrt((   Math.pow((this.getX_Coordinate() - otherCity.getX_Coordinate()),2)
                + Math.pow((this.getY_Coordinate() - otherCity.getY_Coordinate()),2))/10d);
    }
}
