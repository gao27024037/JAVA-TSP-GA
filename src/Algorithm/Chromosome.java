package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static Algorithm.Parameter.*;
import static java.util.Collections.swap;

/**
 * Created by gao27024037 on 2017/4/28.
 */
public class Chromosome extends ArrayList<Integer>{

    //适应度
    private double fitness;
    //占比 在总的里面的占比 (累计占比)
    private double probability = 0;

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

    public int getBlocksNum() {
        return size() / 3;
    }


    /**
     * 交叉产生子代  按随机值选取交叉方式 obx & bx
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

    /**
     * 变异 按随机值选取变异  移动区块和交换元素2种方式
     */
    public void aberrance() {
        if (Math.random() > 0.5) {
            /*移动区块*/
            aberraceByBlock();
        } else {
            /*交换元素*/
            aberraceByElement();
        }
    }

    /**
     * 交叉算法 OX
     * @param chromosome
     * @return
     */
    public Chromosome crossByOX(Chromosome chromosome) {
        int randomLength = (int)(Math.random()*(Cities.size()/4) + Cities.size()/4);// 随机的长度范围：12 -- 24
        int randomLocation = (int)(Math.random()*(size() - randomLength - 1));//随机开始交叉位置
        Chromosome sonChromosome = new Chromosome();
        Chromosome subChromosome = new Chromosome();
        subChromosome.addAll(this.subList(randomLocation,randomLocation + randomLength));   //被交叉的区块
        /*将A的区块放入son中，然后将B中的区块元素去掉后 按顺序放入son中*/
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
        HashSet<Integer> randoms = new HashSet<Integer>();  //产生数个随机位置
        int[] changenum = new int[getBlocksNum()];          //存放准交换数的数组
        Chromosome sonChromosome = (Chromosome) chromosome.clone();
        while(randoms.size() < getBlocksNum()) {
            randoms.add((int)(Math.random() * (size() - 1)));
        }
        Integer r[] = randoms.toArray(new Integer[]{});      //对 随机位置排序
        Arrays.sort(r);
        for (int i = 0; i < randoms.size(); i++) {           //对changnum[] 按顺序 赋值
            changenum[i] = this.get(r[i]);
        }
        /*在A中随机取一定数量的元素，然后在B中把这些元素去掉，再按照A中元素的排列顺序填入B中空缺的位置，组成son*/
        for (int i = 0, k = 0; i < chromosome.size() && k < changenum.length; i++) {
            for (int j = 0; j < changenum.length; j++) {
                if (chromosome.get(i) == changenum[j]) {
                    sonChromosome.set(i, changenum[k++]);
                    break;
                }
            }
        }
           return sonChromosome;
    }

    /**
     * 交换区块方式变异
     */
    public void aberraceByBlock() {
        for (int i = 0; i < probabilityOfAberrance * getBlocksNum(); i++) {     //交换一定次数
            int random1 = (int) (Math.random() * (this.size() - 1));    //区块起始位置  随机数1
            int random2 = (int) (Math.random() * (this.size() - 1));    //区块结束位置  随机数2
            int site = (int) (Math.random() * (this.size() - 1));       //区块移动后的位置 起始位置
            //要求 随机数1和2  不能相等 且 1小于2
            while (random1 >= random2) {
                if (random2 == random1) {
                    random2 = (int) (Math.random() * (this.size() - 1));
                } else {
                    int temp = random1;
                    random1 = random2;
                    random2 = temp;
                }
            }
            /*移动区块，考虑site与[random1, random2)区间的相对位置  三种情况 将区块移动到预订位置（site）*/
            Chromosome chromosome = (Chromosome) this.clone();
            if (site <= random1) {                                  //小于区间
                chromosome.removeRange(random1,random2);
                chromosome.addAll(site, this.subList(random1,random2));
            } else if (random2 > site && site > random1 ) {         //区间内
                if (random2 - random1 > size() - site) {
                    chromosome.addAll(this.subList(random1,random2));
                } else {
                    chromosome.removeRange(random1,random2);
                    chromosome.addAll(site, this.subList(random1, random2));
                }
            } else {                                                //大于区间
                chromosome.addAll(site, this.subList(random1, random2));
                chromosome.removeRange(random1,random2);
            }
            for (int j = 0; j < size(); j++) {                      //因为是变异，所以要将变化从chromosome映射到this
                this.set(j,chromosome.get(j));
            }
        }
    }

    /**
     * 交换元素方式变异
     */
    public void aberraceByElement() {
        for (int i = 0; i< probabilityOfAberrance  * size(); i++) {
            int random1 = (int) (Math.random() * (this.size() - 1));
            int random2 = (int) (Math.random() * (this.size() - 1));
            /*交换元素*/
            swap(this,random1,random2);
        }
    }

    /**
     * 计算适应度： 最大距离 - 距离
     */
    public void calculateFitness() {
        double distanceSum = 0;
        int i = 0;
        for ( ; i < Cities.size() - 2; i++) {
            distanceSum += distance[get(i)][get(i+1)];
        }
        distanceSum += distance[get(i)][get(0)];
        fitness = MaxDistance - distanceSum;
    }


}
