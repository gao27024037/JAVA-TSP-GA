package Algorithm;

import java.util.ArrayList;

/**
 * Created by gao27024037 on 2017/4/28.
 */
public class Chromosome {
    private int[] gene;

    private ArrayList<Chromosome> population = new ArrayList<Chromosome>();

    private Chromosome mutation() {
        Chromosome chromosome = new Chromosome();
        return chromosome;
    }

    private double getFitness() {
        return 1;
    }
}
