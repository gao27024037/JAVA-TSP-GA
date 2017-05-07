package Algorithm;

import java.util.ArrayList;
import java.util.Collections;

import static Algorithm.Parameter.*;

/**
 * Created by gao27024037 on 2017/5/3.
 */

//种群
public class Population extends ArrayList<Chromosome> {

    ArrayList<Integer> num = new ArrayList<Integer>();

    /**
     * 筛选优良个体 利用轮盘赌筛选，但前3个必须留到下一代
     * @return
     */
    public Population sift() {
        Population sonPopulation = new Population();
        sonPopulation.addAll(this.roulette());      //子代 加入父代轮盘赌筛选出来的染色体
        this.sort();                                //父代排序
        clearProbability();
        sonPopulation.clearProbability();//去掉probability的值，便于比较 是否存在
        for (Chromosome chromosome:sonPopulation
             ) {
            if (chromosome.equals(this.get(0))) {
                sonPopulation.remove(chromosome);
                sonPopulation.add(0,this.get(0));
                break;
            }
        }
        for (int i = 0; i < size()/12; i++) {       //将父代前size()/12个元素加入子代中
            if (!sonPopulation.contains(this.get(i))) {
                sonPopulation.add(i, this.get(i));
            }
        }
//        printPopulation(sonPopulation);
        return sonPopulation;
    }

    /**
     * 清除probability
     */
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
        /*相邻交叉*/
        for (int i = 0; i < sizeNow - 1; i += 1) {
            if (Math.random() < probabilityOfCross) {
                Chromosome chromosome = this.get(i).crossWithAnother(this.get(i + 1));
                chromosome.calculateFitness();
                if (!this.contains(chromosome)) {       //如果已存在，则不加入
                    this.add(chromosome);
                }
            }
        }

        /*随机交叉*/
        int k = 0;
        while(this.size() < populationSize && k++ < populationSize * probabilityOfCross * 2) {  //加入一个阈值，超过阈值退出
            Chromosome chromosome = this.get((int)(Math.random()*(sizeNow - 1))).crossWithAnother(get((int)(Math.random()*(sizeNow - 1))));
            chromosome.calculateFitness();
            if (!this.contains(chromosome)) {       //如果已存在，则不加入
                this.add(chromosome);
            }
        }
        /*超过阈值，取一定量的随机个体 填满种群*/
        for (int i = 0; i < Cities.size() ;i++) {       //初始化存num的数组
            num.add(i);
        }
        while (this.size() < populationSize) {
                Chromosome chromosome = new Chromosome();
                chromosome.addAll(num);
                Collections.shuffle(chromosome);        //打乱chromosome
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
        for (int i = size()/12; i < size(); i++) {
            if (Math.random() < probabilityOfAberrance) {
                this.get(i).aberrance();
            }
        }
        this.sort();        //按适应值排序
        System.out.println("最短路径"+(MaxDistance-this.get(0).getFitness())+""+this.get(0));
        addDataToChart();
    }

    /**
     * 将数据加入图表中
     */
    public void addDataToChart() {
        chartData.add(MaxDistance-this.get(0).getFitness());    //最佳距离
        chartData2.add(MaxDistance-this.get(1).getFitness());   //次佳距离
        double sum = 0;
        for (Chromosome chromosose: this
                ) {
            sum += (MaxDistance-chromosose.getFitness());
        }
        chartDataAverage.add(sum/size());               //平均距离
    }

    /**
     * 轮盘赌 按适应度所占的比例选取，比例越大越容易选中
     */
    private Population roulette() {
        calculateProbabilities();
        Population sonPopulation = new Population();
        /*轮盘赌 随机值在哪个占比之间，就是那一个染色体选中*/
        for (int i = 0; i < size() / 6; i++) {
            double random = Math.random();
            if (random < this.get(0).getProbability() && !sonPopulation.contains(this.get(0))) {
                sonPopulation.add(this.get(0));
            } else {
                for (int j = 1; j < size(); j++) {
                    if (random > this.get(j - 1).getProbability() && random < this.get(j).getProbability()
                            && !sonPopulation.contains(this.get(j))) {
                        sonPopulation.add(this.get(j));
                        break;
                    }
                }
            }
        }
        return sonPopulation;
    }

    /**
     * 计算各个染色体的累计占比
     */
    private void calculateProbabilities(){
        double fitnessSum = 0;          //适应度之和
        double probabilitySum = 0;      //累计占比
        calculateFitness();
        for (Chromosome chromosome:this
                ) {
            fitnessSum += chromosome.getFitness();
        }
        for (Chromosome chromosome:this
                ) {
            probabilitySum += chromosome.getFitness() / fitnessSum;
            chromosome.setProbability(probabilitySum);
        }
    }

    /**
     * 重新计算每一个适应度值
     */
    public void calculateFitness() {
        for (Chromosome chromosome: this
                ) {
            chromosome.calculateFitness();
        }
    }

    /**
     * 按适应值从大到小排序
     */
    public void sort() {
        calculateFitness();
        Collections.sort(this, (o1, o2) -> (int)(o2.getFitness() - o1.getFitness()));
    }

    /**
     * 初始化种群
     * @return
     */
    public Population initPopulation(){
        Population population = new Population();
        for (int i = 0; i < Cities.size() ;i++) {       //初始化存num的数组
            num.add(i);
        }
        for (int i = 0; i < populationSize; i++) {
            Chromosome chromosome = new Chromosome();
            chromosome.addAll(num);
            Collections.shuffle(chromosome);        //打乱chromosome
            chromosome.calculateFitness();
            population.add(chromosome);
        }
        return population;
    }

    //输出种群
    public void printPopulation(Population population) {
        for (int i = 0; i < Math.min(population.size(),25); i++) {
            System.out.println(population.get(i).getFitness()+" ||"+population.get(i).getProbability()+"||"+population.get(i));
        }
    }
}
