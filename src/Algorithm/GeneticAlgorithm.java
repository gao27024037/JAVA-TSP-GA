package Algorithm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by gao27024037 on 2017/4/28.
 */
public class GeneticAlgorithm {

    private static ArrayList<City> Cities = new ArrayList<City>();//初始城市群


    private void breed() {
        Population population = new Population();

        //breed
        {
            Population son = population.sift();
            son.cross();
            son.aberrance();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader data = new BufferedReader(new InputStreamReader(
                new FileInputStream("//home//gyl//桌面//data.txt")));
        int cityNum = 48;
        String strbuff;
        for (int i = 0; i < cityNum; i++) {
            // 读取一行数据，数据格式1 6734 1453
            strbuff = data.readLine();
            // 字符分割
            String[] strcol = strbuff.split(" ");
            Cities.add(new City(i,Integer.valueOf(strcol[1]),Integer.valueOf(strcol[2])));
        }
        Parameter.calculatedistance(Cities);
        System.out.println(Parameter.distance);
        Population population = new Population().initPopulation();

        int generation = 1000;
        for (int i = 0; i < generation; i++) {
            System.out.println("第 "+i+" 代");
            System.out.println(population.size());
            for (int j=0 ; j< population.size(); j++) {
                System.out.println(j+" "+population.get(j));
            }
            population = population.sift();
            population.cross();
            population.aberrance();
        }
//        System.out.println("迭代1000次后最短路径是"+(100000d - population.get(0).getFitness()));

    }


}
