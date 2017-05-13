package Algorithm;

import java.util.ArrayList;

/**
 * 用于存取全局需要的确定变量
 * Created by gyl on 17-5-4.
 */
public class Parameter {
    //最大距离
    public static double MaxDistance = 5000;
    //距离数组
    public static double[][] distance;
    //代数
    public static int generation =3000;
    //种群数量
    public static int populationSize = 50;
    //最佳距离
    public static ArrayList<Double> chartData = new ArrayList<Double>();
    //次佳距离
    public static ArrayList<Double> chartData2 = new ArrayList<Double>();
    //平均距离
    public static ArrayList<Double> chartDataAverage = new ArrayList<Double>();
    //交叉概率
    public static double probabilityOfCross = 0.9;
    //变异率
    public static double probabilityOfAberrance = Math.random()*0.25 + 0.05;
    //初始城市群
    public static ArrayList<City> Cities = new ArrayList<City>();

    //计算各个城市之间的距离
    public static void calculatedistance(ArrayList<City> Cities) {
        distance = new double[Cities.size()][Cities.size()];
        for (int i = 0; i < Cities.size(); i++) {
            distance[i][i] = 0; //对角线为0
            for (int j = i + 1; j < Cities.size(); j++) {
                distance[j][i] = distance[i][j] = Cities.get(i).getDistanceToAnother(Cities.get(j));
            }
        }
    }
}
