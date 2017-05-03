package Algorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.zip.Inflater;

/**
 * Created by gao27024037 on 2017/4/28.
 */
public class Chromosome extends ArrayList<Integer>{

    //交叉概率
    private float probabilityOfCross;
    //变异率
    private float probabilityOfAberrance;
    //交叉分块  块数
    private int blocksNum = size()/11;
    //适应度
    private float fitness;

    public float getFitness() {
        return fitness;
    }

    public void setFitness(float fitness) {
        fitness = fitness;
    }



    //变异 将随机数2位置的元素放到随机数1的位置
    public void aberrance() {
        int random1 = (int)Math.random()*(size() - 1);
        int random2 = (int)Math.random()*(size() - 1);
        set(random2,get(random1));
    }

    public Chromosome crossToAnother(Chromosome chromosome) {
        int[] randoms = new int[10];//存放随机数的数组  即把染色体分几块儿
        for(int i = 0; i < blocksNum; i++) {
            randoms[i] = (int)Math.random() * (size() - 1);
        }
        Arrays.sort(randoms);
        probabilityOfAberrance = 0.5f + (this.fitness - chromosome.fitness) / (this.fitness + chromosome.fitness);
        return chromosome;
    }

    public void calculateFitness(float[][] distence) {
        float distenceSum = 0;
        int i = 0;
        for ( ; i < size(); i++) {
            distenceSum += distence[get(i)][get(i+1)];
        }
        distenceSum += distence[get(i)][get(0)];
        float MaxDistence = 100000f;
        fitness = MaxDistence - distenceSum;
    }
}
