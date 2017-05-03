package Algorithm;

import java.util.ArrayList;

/**
 * Created by gao27024037 on 2017/5/3.
 */

//种群
public class Population extends ArrayList<Chromosome> {

    private int size;


    /**
     * 筛选优良个体 利用轮盘赌筛选，但前n个必须留到下一代
     * @return
     */
    public ArrayList<Chromosome> sift() {
        return null;
    }

    /**
     * 让优异个体繁殖
     * @return
     */
    public ArrayList<Chromosome> breed() {
        return null;
    }

    /**
     * 交叉 个体之间
     * @return
     */
    public ArrayList<Chromosome> cross() {
        return null;
    }

    /**
     * 个体变异
     * @return
     */
    public ArrayList<Chromosome> aberrance() {
        return null;
    }

}
