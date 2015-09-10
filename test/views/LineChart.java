package views;

/**
 * @author: decaywood
 * @date: 2015/9/10 13:12
 */

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;

public class LineChart extends ApplicationFrame {
    public LineChart(String s) {
        super(s);
        setContentPane(createDemoLine());
    }
    public static void main(String[] args) {
        LineChart fjc = new LineChart("haha");
        fjc.pack();
        RefineryUtilities.centerFrameOnScreen(fjc);
        fjc.setVisible(true);
    }
    // 生成显示图表的面板
    public static JPanel createDemoLine() {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }
    // 生成图表主对象JFreeChart
    public static JFreeChart createChart(CategoryDataset linedataset) {
        //定义图表对象
        Font font = new Font("宋体", Font.BOLD, 16);
        JFreeChart chart = ChartFactory.createLineChart("折线图", // chart title
                "时间", // domain axis label
                "销售额(百万)", // range axis label
                linedataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips
                false // urls
        );
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setAxisOffset(new RectangleInsets(0, 0, 0, 0));//设置曲线图与xy轴的距离
        plot.setDomainGridlinesVisible(true);//横向网格可见
        plot.setDomainGridlinePaint(Color.gray);
        plot.setRangeGridlinesVisible(true);//纵向网格课件
        plot.setRangeGridlinePaint(Color.gray);
        plot.setBackgroundAlpha(0);

        LineAndShapeRenderer renderer = (LineAndShapeRenderer)plot.getRenderer();
        renderer.setBaseShapesVisible(true);
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);
        chart.getLegend().setVisible(false);

        chart.getTitle().setFont(new Font("宋体", Font.BOLD, 12));
        ValueAxis numberAxis = plot.getRangeAxis();
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));
        domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));
        numberAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));
        numberAxis.setLabelFont(new Font("黑体", Font.PLAIN, 12));
        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));
        return chart;
    }
    //生成数据
    public static CategoryDataset createDataset() {
        DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
        String dummy = "";
        for (Integer i = 0; i < 25; i++) {
            linedataset.addValue(i - 25 * Math.random(), dummy, i);
        }
        return linedataset;
    }
}