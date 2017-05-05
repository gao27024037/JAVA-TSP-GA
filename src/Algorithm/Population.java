package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static Algorithm.Parameter.*;

/**
 * Created by gao27024037 on 2017/5/3.
 */

//种群
public class Population extends ArrayList<Chromosome> {




    /**
     * 筛选优良个体 利用轮盘赌筛选，但前3个必须留到下一代
     * @return
     */
    public void printpopulation(Population population) {
        for (int i = 0; i < Math.min(population.size(),15); i++) {
            System.out.println(population.get(i).getFitness()+" "+population.get(i));
        }
    }

    public Population sift() {
        Collections.sort(this, new Comparator<Chromosome>() {// 按适应值从大到小排序
            @Override
            public int compare(Chromosome o1, Chromosome o2) {
                return (int)(o2.getFitness() - o1.getFitness());
            }
        });
//        System.out.println("第0代本身：");
//        printpopulation(this);
        Population sonPopulation = this.roulette();//子代
//        sonPopulation.addAll(0,this.subList(0, 3));
//        System.out.println("加了父代前3个的子代");
//        printpopulation(sonPopulation);
        System.out.println("最短路径"+(200000d-sonPopulation.get(0).getFitness())+""+sonPopulation.get(0));
        return sonPopulation;
    }


    /**
     * 交叉 个体之间
     * @return
     */
    public void cross() {
        Collections.sort(this, new Comparator<Chromosome>() {// 按适应值从大到小排序
            @Override
            public int compare(Chromosome o1, Chromosome o2) {
                return (int)(o2.getFitness() - o1.getFitness());
            }
        });
        int sizeNow = this.size(); //未交叉前的长度（只有之前的父代）
//        System.out.println("交叉前的子代");
//        printpopulation(this);
        //相邻交叉
        for (int i = 0; i < sizeNow - 1; i++) {
            if (Math.random() < probabilityOfCross) {
                this.add(this.get(i).crossWithAnother(this.get(i + 1)));
            }
        }
        //随机交叉
        while(this.size() < populationSize) {
            this.add(this.get((int)(Math.random()*(sizeNow - 1))).crossWithAnother(get((int)(Math.random()*(sizeNow - 1)))));
        }
//        System.out.println("交叉后的子代");
//        printpopulation(this);
    }

    /**
     * 个体变异
     * @return
     */
    public void aberrance() {
        for (int i = 3; i < size(); i++) {
            if (Math.random() < probabilityOfAberrance) {
                this.get(i).aberrance();
            }
        }
    }

    /**
     * 计算各个染色体的累计占比
     */
    private void caculateProbabilitis(){
        double fitnessSum = 0;
        double probabilitySum = 0;
        for (int i = 0; i < size(); i++) {
            fitnessSum += this.get(i).getFitness();
        }
        for (int i = 0; i < size(); i++) {
            probabilitySum += this.get(i).getFitness() / fitnessSum;
            this.get(i).setProbability(probabilitySum);
        }
    }

    /**
     * 轮盘赌
     */
    private Population roulette() {
        caculateProbabilitis();
        Population sonPopulation = new Population();
        for (int i = 0; i < size() / 8; i++) { //轮盘赌筛选
            double random = Math.random();
            if (random < this.get(0).getProbability()) {
                sonPopulation.add(this.get(0));
            } else {
                for (int j = 1; j < size(); j++) {
                    if (random > this.get(j - 1).getProbability() && random < this.get(j).getProbability()) {
                        sonPopulation.add(this.get(j));
                    }
                }
            }
        }
        return sonPopulation;
    }

    public Population initPopulation(){
        ArrayList<Integer> num = new ArrayList<Integer>();
        Population population = new Population();
        for (int i = 0; i < citisNum ;i++) {
            num.add(i);
        }
        for (int i = 0; i < populationSize; i++) {
            Chromosome chromosome = new Chromosome();
            chromosome.addAll(num);
            Collections.shuffle(chromosome);
            chromosome.calculateFitness();
//            System.out.println(chromosome.getFitness());
            population.add(chromosome);
        }
        return population;
    }
}
