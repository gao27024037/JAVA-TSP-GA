package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;

import static Algorithm.Parameter.citisNum;
import static Algorithm.Parameter.distance;

/**
 * Created by gao27024037 on 2017/4/28.
 */
public class Chromosome extends ArrayList<Integer>{

    //交叉概率
    private double probabilityOfCross;
    //交叉分块  块数
    private int blocksNum;
    //适应度
    private double fitness;
    //占比 在总的里面的占比 (累计占比)
    private double probability;

    public int getBlocksNum() {
        blocksNum = size() / 11;
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



    //变异 将随机数2位置的元素放到随机数1的位置
    public void aberrance() {
            int random1 = (int) (Math.random() * (this.size() - 1));
            int random2 = (int) (Math.random() * (this.size() - 1));
            set(random2, get(random1));
        this.calculateFitness();
    }

    /**
     * 交叉产生子代  借鉴网络上的 基于适应度的启发式多点交叉 http://blog.csdn.net/xujinpeng99/article/details/8982126
     * @param chromosome
     * @return
     */
    public Chromosome crossWithAnother(Chromosome chromosome) {
        int[] randoms = new int[getBlocksNum() + 1];//存放随机数的数组  即把染色体分几块儿
        randoms[0] = 0;
        randoms[1] = size() - 1;
        for(int i = 2; i < blocksNum + 1; i++) {
            double r = Math.random() * (size() - 1);
            randoms[i] = (int)(r);
        }
        Arrays.sort(randoms);
        probabilityOfCross = 0.5d + (chromosome.fitness - this.fitness) / (this.fitness + chromosome.fitness);

        //交叉
        Chromosome sonChromosome = new Chromosome();
        for (int i = 0; i < blocksNum ; i++) {
            if(Math.random() < probabilityOfCross) {
                sonChromosome.addAll(this.subList(randoms[i],randoms[i + 1]));
            } else {
                sonChromosome.addAll(chromosome.subList(randoms[i],randoms[i + 1]));
            }
        }
        sonChromosome.calculateFitness();
        return sonChromosome;
    }

    public void calculateFitness() {
        double distanceSum = 0;
        int i = 0;
        for ( ; i < citisNum - 2; i++) {
//            System.out.println(i+" "+distance[get(i)][get(i+1)]);
            distanceSum += distance[get(i)][get(i+1)];
        }
        distanceSum += distance[get(i)][get(0)];
        double MaxDistance = 200000d;
        fitness = MaxDistance - distanceSum;
    }
}
