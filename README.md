# JAVA-TSP-GA
遗传算法解决旅行商问题


但还是留有BUG：基因数太少时，交叉始终难以得到与父辈不同的个体，需要一致随机，才能进行下去，相当于死循环

根据走势平均值来看，并没有能很好地优化种群作用，只是一昧地选取随机出来地最佳值。
