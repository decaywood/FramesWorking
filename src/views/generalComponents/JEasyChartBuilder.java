package views.generalComponents;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;

import java.awt.*;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/9/10 12:52
 *
 * step1 ：调用createDataSet方法
 * step2 ：调用createChart方法
 * step3 ：调用buildPanel方法
 *
 * 调用链：ChartPanel panel = builder.createDataset(...).createChart(...).buildPanel().
 *
 */
public class JEasyChartBuilder {

    private JFreeChart chart;
    private DefaultCategoryDataset dataset;


    public JEasyChartBuilder createChart(
            String title,
            String Xlabel,
            String Ylabel) {
        chart = ChartFactory.createLineChart(title, Xlabel, Ylabel,
                dataset, PlotOrientation.VERTICAL, false, false, false);
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

        chart.getTitle().setFont(new Font("宋体", Font.BOLD, 12));
        ValueAxis numberAxis = plot.getRangeAxis();
        numberAxis.setUpperMargin(0.15);
        numberAxis.setLowerMargin(0.15);
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));
        domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));
        numberAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));
        numberAxis.setLabelFont(new Font("黑体", Font.PLAIN, 12));
        return this;
    }

    public JEasyChartBuilder createDataset(String lineName, List<Double> data) {
        dataset = new DefaultCategoryDataset();
        for (Integer i = 0; i < data.size(); i++) dataset.addValue(data.get(i), lineName, i);
        return this;
    }

    public ChartPanel buildPanel() {
        ChartPanel panel = new ChartPanel(chart);
        panel.setDomainZoomable(true);
        panel.setRangeZoomable(true);
        panel.setMouseZoomable(false, true);
        panel.setFillZoomRectangle(true);
        panel.setMouseWheelEnabled(true);
        return panel;
    }
}


