package Frame;

/**
 * Created by gao27024037 on 2017/5/6.
 */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;

import static Algorithm.Parameter.chartData;
import static Algorithm.Parameter.generation;


public class StatisticsFrame {
    ChartPanel frame1;
    public StatisticsFrame(){
        JFreeChart jfreechart = ChartFactory.createLineChart("遗传算法最小距离进化图", "总代数："+generation, "距离", this.createDataset(),  PlotOrientation.VERTICAL, true, false,false);
        CategoryPlot plot = jfreechart.getCategoryPlot();
        plot.setNoDataMessage("没有数据");
//        DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
        frame1=new ChartPanel(jfreechart,true);
//        dateaxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
//        dateaxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
//        ValueAxis rangeAxis=xyplot.getRangeAxis();//获取柱状
//        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
//        jfreechart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
//        jfreechart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体

    }

    public DefaultCategoryDataset createDataset() {

        DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
        // 曲线名称
        String series = "最佳距离";  // series指的就是报表里的那条数据线
        //因此 对数据线的相关设置就需要联系到serise
        //比如说setSeriesPaint 设置数据线的颜色
        for (int i = 0; i < generation; i++) {
            linedataset.addValue(chartData.get(i),series+"",""+i);

        }
        return linedataset;
    }

    public ChartPanel getChartPanel(){
        return frame1;

    }
}