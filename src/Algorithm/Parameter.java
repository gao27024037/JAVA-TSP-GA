package Algorithm;

import java.util.ArrayList;

/**
 * Created by gyl on 17-5-4.
 */
public class Parameter {
    public static double[][] distance;

    public static int citisNum = 48;

    public static int generation = 1000;

    public static int populationSize = 50;

    public static double[][] getDistance() {
        return distance;
    }

    public static void setDistance(double[][] distance) {
        Parameter.distance = distance;
    }

    public static int getCitisNum() {
        return citisNum;
    }

    public static void setCitisNum(int citisNum) {
        Parameter.citisNum = citisNum;
    }

    public static int getGeneration() {
        return generation;
    }

    public static void setGeneration(int generation) {
        Parameter.generation = generation;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    //计算各个城市之间的距离
    public static void calculatedistance(ArrayList<City> Cities) {
        distance = new double[Cities.size()][Cities.size()];
        for (int i = 0; i < Cities.size(); i++) {
            distance[i][i] = 0; //对角线为0
            for (int j = i + 1; j < Cities.size(); j++) {
                distance[j][i] = distance[i][j] = Cities.get(i).getdistanceToAnother(Cities.get(j));
            }
        }
    }
}
