package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import static Algorithm.Parameter.*;

/**
 * Created by gao27024037 on 2017/4/28.
 */
public class Chromosome extends ArrayList<Integer>{


    //交叉分块  块数
    private int blocksNum;
    //适应度
    private double fitness;
    //占比 在总的里面的占比 (累计占比)
    private double probability;

    public int getBlocksNum() {
        blocksNum = size() / 3;
        return blocksNum;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        fitness = fitness;
    }



    //变异 将随机数1位置的元素放到随机数2的位置 去掉随机数1位置的元素
    public void aberrance() {
        for (int i = 0; i< probabilityOfAberrance  * size(); i++) {
            int random1 = (int) (Math.random() * (this.size() - 1));
            int random2 = (int) (Math.random() * (this.size() - 1));
            add(random2, remove(random1));
        }
    }

    /**
     * 交叉算法 OX
     * @param chromosome
     * @return
     */
    public Chromosome crossByOX(Chromosome chromosome) {
        int randomLength = (int)(Math.random()*12 + 12);// 随机的长度范围：12 -- 24
        int randomLocation = (int)(Math.random()*(size() - randomLength - 1));//随机开始交叉位置
        Chromosome sonChromosome = new Chromosome();
        Chromosome subChromosome = new Chromosome();
//        System.out.println(this);
        subChromosome.addAll(this.subList(randomLocation,randomLocation + randomLength));
        for (int i = 0; i < size(); i++) {
            if (sonChromosome.size() == randomLocation) {
                sonChromosome.addAll(subChromosome);
            }
            if (!subChromosome.contains(chromosome.get(i))) {
                sonChromosome.add(chromosome.get(i));
            }
        }
        return sonChromosome;
    }

    /**
     * 交叉算法OBX
     * @param chromosome
     * @return
     */
    public Chromosome crossByOBX(Chromosome chromosome) {
        HashSet<Integer> randoms = new HashSet<Integer>();
        int[] changenum = new int[getBlocksNum()];//存放准交换数的数组
        Chromosome sonChromosome = (Chromosome) chromosome.clone();
        while(randoms.size() < blocksNum) {
            randoms.add((int)(Math.random() * (size() - 1)));
        }
        Integer r[] = randoms.toArray(new Integer[]{});
        Arrays.sort(r);
        //交叉
        //赋予 交换数组 值
        for (int i = 0; i < randoms.size(); i++) {
            changenum[i] = this.get(r[i]);
        }
            for (int i = 0, k = 0; i < chromosome.size(); i++) {
                for (int j = 0; j < changenum.length; j++) {
                    if (chromosome.get(i) == changenum[j]) {
//                    System.out.println(sonChromosome.get(i));
                        sonChromosome.set(i, changenum[k++]);
                        break;
                    }
                }
            }
           return sonChromosome;
    }

    /**
     * 交叉产生子代  按随机值选取交叉方式
     * @param chromosome
     * @return
     */
    public Chromosome crossWithAnother(Chromosome chromosome) {
        Chromosome sonChromosome = new Chromosome();
        if (Math.random() > 0.5) {
        /*Order Crossover (OX)*/
            sonChromosome = crossByOX(chromosome);
        } else {
        /*Order-Based Crossover (OBX)*/
            sonChromosome = crossByOBX(chromosome);
        }
        return sonChromosome;
    }

    public void calculateFitness() {
        double distanceSum = 0;
        int i = 0;
        for ( ; i < citisNum - 2; i++) {
            distanceSum += distance[get(i)][get(i+1)];
        }
        distanceSum += distance[get(i)][get(0)];
        fitness = MaxDistance - distanceSum;
    }
}
