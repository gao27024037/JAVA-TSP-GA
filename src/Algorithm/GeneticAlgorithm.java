package Algorithm;

import Frame.StatisticsFrame;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static Algorithm.Parameter.*;

/**
 * Created by gao27024037 on 2017/4/28.
 */
public class GeneticAlgorithm {
    /**
     * 返回结果路线
     * @return
     */
    public static Chromosome Route() {
        Population population = initParameter();//初始化参数
        for (int i = 0; i < generation; i++) {
            System.out.println("第 "+i+" 代");
            population = population.sift();        //筛选
            population.cross();                    //交叉
            population.aberrance();                //变异
        }
        creatChart();   //产生图表
        return population.get(0);
    }

    /**
     * 初始化参数
     */
    public static Population initParameter(){
        chartDataAverage.clear();
        chartData.clear();
        chartData2.clear();
        distance = null;
        Parameter.calculatedistance(Cities);//计算Cities
        return new Population().initPopulation();//初始化种群
    }

    /**
     * 产生图表
     */
    public static void creatChart(){
        JFrame frame=new JFrame("Java数据统计图");
        frame.add(new StatisticsFrame().getChartPanel());
        frame.setBounds(50, 50, 800, 600);
        frame.setVisible(true);
    }
}
