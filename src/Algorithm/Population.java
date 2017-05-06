package Algorithm;

import org.omg.CORBA.Object;

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
            System.out.println(population.get(i).getFitness()+" ||"+population.get(i).getProbability()+"||"+population.get(i));
        }
    }

    public void caculateFitness() {
        for (Chromosome chromosome: this
             ) {
            chromosome.calculateFitness();
        }
    }

    public void sort() {
        caculateFitness();
        Collections.sort(this, new Comparator<Chromosome>() {// 按适应值从大到小排序
            @Override
            public int compare(Chromosome o1, Chromosome o2) {
                return (int)(o2.getFitness() - o1.getFitness());
            }
        });
    }

    public Population sift() {
//        this.sort();
        Population sonPopulation = new Population();
        sonPopulation.addAll(this.roulette());//子代
        clearProbability();
        for (int i = 0; i < size()/12; i++) {
            if (!sonPopulation.contains(this.get(i))) {
                sonPopulation.add(i, this.get(i));
            }
        }
        this.sort();
        return sonPopulation;
    }

    private void clearProbability() {
        for (Chromosome chromosome:this
             ) {
            chromosome.setProbability(0);
        }
    }

    /**
     * 交叉 个体之间
     * @return
     */
    public void cross() {
        int sizeNow = this.size(); //未交叉前的长度（只有之前的父代）
        //相邻交叉
        for (int i = 0; i < sizeNow - 1; i += 1) {
            if (Math.random() < probabilityOfCross) {
                Chromosome chromosome = this.get(i).crossWithAnother(this.get(i + 1));
                chromosome.calculateFitness();
                if (!this.contains(chromosome)) {
                    this.add(chromosome);
                }
            }
        }

        //随机交叉
        while(this.size() < populationSize) {
//            System.out.println("++++++++++++++++++++++");
//            System.out.println(sizeNow+" "+ this.size());
//            printpopulation(this);
            Chromosome chromosome = this.get((int)(Math.random()*(sizeNow - 1))).crossWithAnother(get((int)(Math.random()*(sizeNow - 1))));
            chromosome.calculateFitness();
            if (!this.contains(chromosome)) {
                this.add(chromosome);
            }
        }
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
        this.sort();
        int i =1 ;
        System.out.println("最短路径"+(MaxDistance-this.get(0).getFitness())+""+this.get(0));
        chartData.add(MaxDistance-this.get(0).getFitness());
        chartData2.add(MaxDistance-this.get(1).getFitness());
        double a = 0;
        for (Chromosome chromosose: this
             ) {
            a += (MaxDistance-chromosose.getFitness());
        }
        chartDataAverage.add(a/size());
//        System.out.println((MaxDistance-his.get(i).getFitness())+""+this.get(i++));
//        System.out.println((MaxDistance-this.get(i).getFitness())+""+this.get(i++));
//        System.out.println((MaxDistance-this.get(i).getFitness())+""+this.get(i++));
//        System.out.println((MaxDistance-this.get(i).getFitness())+""+this.get(i++));
//        System.out.println((MaxDistance-this.get(i).getFitness())+""+this.get(i++) + " "+i);
    }

    /**
     * 计算各个染色体的累计占比
     */
    private void caculateProbabilitis(){
        double fitnessSum = 0;
        double probabilitySum = 0;
        caculateFitness();
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
        for (int i = 0; i < size() / 6; i++) { //轮盘赌筛选
            double random = Math.random();
            if (random < this.get(0).getProbability() && !sonPopulation.contains(this.get(0))) {
                sonPopulation.add(this.get(0));
            } else {
                for (int j = 1; j < size(); j++) {
                    if (random > this.get(j - 1).getProbability() && random < this.get(j).getProbability()
                            && !sonPopulation.contains(this.get(j))) {
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
        for (int i = 0; i < Cities.size() ;i++) {
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
