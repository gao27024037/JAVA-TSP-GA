package Algorithm;

import java.util.ArrayList;

/**
 * Created by gao27024037 on 2017/4/28.
 */
public class GeneticAlgorithm {

    private ArrayList<City> Cities = new ArrayList<City>();//初始城市群

    private double[][] distance;//距离矩阵

    //计算各个城市之间的距离
    private void calculatedistance() {
        distance = new double[Cities.size()][Cities.size()];
        for (int i = 0; i < Cities.size(); i++) {
            distance[i][i] = 0; //对角线为0
            for (int j = i + 1; j < Cities.size(); j++) {
                distance[j][i] = distance[i][j] = Cities.get(i).getdistanceToAnother(Cities.get(j));
            }
        }
    }

    private void breed() {
        Population population = new Population();

        //breed
        {
            Population son = population.sift();
            son.cross();
            son.aberrance();
        }
    }
}
