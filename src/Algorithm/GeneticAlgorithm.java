package Algorithm;

import Frame.StatisticsFrame;
import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static Algorithm.Parameter.*;

/**
 * Created by gao27024037 on 2017/4/28.
 */
public class GeneticAlgorithm {


    public static Chromosome Route() {
        chartDataAverage.clear();
        chartData.clear();
        chartData2.clear();
        distance = null;
        Parameter.calculatedistance(Cities);//计算Cities
        Population population = new Population().initPopulation();//初始化种群
        for (int i = 0; i < generation; i++) {
            System.out.println("第 "+i+" 代");
            population = population.sift();
            population.cross();
            population.aberrance();
        }
        JFrame frame=new JFrame("Java数据统计图");
        frame.add(new StatisticsFrame().getChartPanel());
        frame.setBounds(50, 50, 800, 600);
        frame.setVisible(true);
        return population.get(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader data = new BufferedReader(new InputStreamReader(
                new FileInputStream("src//data.txt")));
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
//        int a[] = {2,13,12,22,11,10,14,39,37,0,7,8,30,43,6,17,27,5,29,42,16,26,36,18,35,45,32,19,46,24,20,31,38,23,9,3,25,44,34,41,47,4,1,28,33,40,15,21};
//        Chromosome chromosome = new Chromosome();
//        for ( int i = 0; i < a.length; i++) {
//            chromosome.add(a[i]);
//        }
//        chromosome.calculateFitness();
//        System.out.println(MaxDistance -chromosome.getFitness());
//        Population population = new Population().initPopulation();
////        population.printpopulation(population);
//        for (int i = 0; i < generation; i++) {
//
//            System.out.println("第 "+i+" 代");
////            for (int j=0 ; j< population.size(); j++) {
////                System.out.println(j+" "+population.get(j));
////            }
//            population = population.sift();
//            population.cross();
//            population.aberrance();
        }
//        JFrame frame=new JFrame("Java数据统计图");
//        frame.add(new StatisticsFrame().getChartPanel());
//        frame.setBounds(50, 50, 800, 600);
//        frame.setVisible(true);
//        System.out.println("迭代1000次后最短路径是"+(100000d - population.get(0).getFitness()));
//    }

}
