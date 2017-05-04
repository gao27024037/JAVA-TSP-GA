package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by gao27024037 on 2017/5/3.
 */

//种群
public class Population extends ArrayList<Chromosome> {


    private int MaxSize = 60;

    private int size = size();
    //变异率
    private double probabilityOfAberrance = Math.random()*0.05 + 0.05;

    /**
     * 筛选优良个体 利用轮盘赌筛选，但前3个必须留到下一代
     * @return
     */
    public Population sift() {
        Population sonPopulation = this.roulette();//子代
        Collections.sort(this, new Comparator<Chromosome>() {// 按适应值从小到大排序
            @Override
            public int compare(Chromosome o1, Chromosome o2) {
                return (int)(o1.getFitness() - o2.getFitness());
            }
        });
        sonPopulation.addAll(0,this.subList(0, 3));
        return sonPopulation;
    }


    /**
     * 交叉 个体之间
     * @return
     */
    public ArrayList<Chromosome> cross() {
        Collections.sort(this, new Comparator<Chromosome>() {// 按适应值从小到大排序
            @Override
            public int compare(Chromosome o1, Chromosome o2) {
                return (int)(o1.getFitness() - o2.getFitness());
            }
        });
        int i = 0;
        int sizeNow = this.size();
        for (; i < sizeNow - 1; i++) {
            this.add(this.get(i).crossWithAnother(this.get(i + 1)));
        }
        for(;this.size() < MaxSize;) {

        }
        return null;
    }

    /**
     * 个体变异
     * @return
     */
    public void aberrance() {
        for (int i = 3; i < size; i++) {
            if (Math.random() > probabilityOfAberrance) {
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
        for (int i = 0; i < size; i++) {
            fitnessSum += this.get(i).getFitness();
        }
        for (int i = 0; i < size; i++) {
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
        for (int i = 0; i < size / 8; i++) { //轮盘赌筛选
            double random = Math.random();
            if (random < this.get(0).getProbability()) {
                sonPopulation.add(this.get(0));
            } else {
                for (int j = 1; j < size; j++) {
                    if (random > this.get(j - 1).getProbability() && random < this.get(j).getProbability()) {
                        sonPopulation.add(this.get(i));
                    }
                }
            }
        }
        return sonPopulation;
    }
}
