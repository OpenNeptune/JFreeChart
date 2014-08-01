package LineTest;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.TextAnchor;
import org.junit.Test;

import constant.Constant;
/**
 * 
 * @Summary��
 * 		����timeSeries��ͳһ��ͼ�����������ߣ����Ƚ�
 */
public class LineTest_02 {
	@Test
	public void CreateLine() throws IOException{
		TimeSeries  timeSeries  = new TimeSeries("2012������ͳ��");
		
		//�������ݼ���
		timeSeries.add(new  Month(1,  2013),  11200);
		timeSeries.add(new  Month(2,  2013),  9000);
		timeSeries.add(new  Month(3,  2013),  6200);
		timeSeries.add(new  Month(4,  2013),  8200);
		timeSeries.add(new  Month(5,  2013),  8200);
		timeSeries.add(new  Month(6,  2013),  12200);
		timeSeries.add(new  Month(7,  2013),  13200);
		timeSeries.add(new  Month(8,  2013),  8300);
		timeSeries.add(new  Month(9,  2013),  12400);
		timeSeries.add(new  Month(10,  2013),  12500);
		timeSeries.add(new  Month(11,  2013),  13600);
		timeSeries.add(new  Month(12,  2013),  12500);
		
		TimeSeries  timeSeries1  = new TimeSeries("2013������ͳ��");
		
		//�������ݼ���
		timeSeries1.add(new  Month(1,  2013),  11800);
		timeSeries1.add(new  Month(2,  2013),  8000);
		timeSeries1.add(new  Month(3,  2013),  9200);
		timeSeries1.add(new  Month(4,  2013),  9200);
		timeSeries1.add(new  Month(5,  2013),  10200);
		timeSeries1.add(new  Month(6,  2013),  12200);
		timeSeries1.add(new  Month(7,  2013),  9900);
		timeSeries1.add(new  Month(8,  2013),  11300);
		timeSeries1.add(new  Month(9,  2013),  10400);
		timeSeries1.add(new  Month(10,  2013),  8800);
		timeSeries1.add(new  Month(11,  2013),  10200);
		timeSeries1.add(new  Month(12,  2013),  14500);
		
		//ʱ���������ݼ���
		TimeSeriesCollection  lineDataset  = new TimeSeriesCollection();
		
		
		lineDataset.addSeries(timeSeries);
		lineDataset.addSeries(timeSeries1);
		
		JFreeChart  chart  = ChartFactory.createTimeSeriesChart(" ������ͳ��ʱ����",  "�·�", "������", lineDataset,  true,  true,  true);
		//��������
		chart.getTitle().setFont(new Font("����", Font.BOLD, 25));
		//��ʾ������
		chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 15));
		//�õ���ͼ��
		XYPlot plot = (XYPlot) chart.getPlot();
		//���ñ�����ɫ
		plot.setBackgroundPaint(ChartColor.WHITE);
		
		//��������������ɫ
		plot.setDomainGridlinePaint(ChartColor.BLACK);
		
		//�������������ɫ
		plot.setRangeGridlinePaint(ChartColor.BLACK);
		

		
		//domain���ǩ����
		plot.getDomainAxis().setLabelFont(new Font("����", Font.PLAIN, 15));
		//domain��С��ǩ����
		plot.getDomainAxis().setTickLabelFont(new Font("����", Font.PLAIN, 15));
		
		//range���ǩ����
		plot.getRangeAxis().setLabelFont(new Font("����", Font.PLAIN, 15));
		
		//������������ʾ����
		XYItemRenderer  xyitem  = plot.getRenderer();     
		xyitem.setBaseItemLabelsVisible(true);  
		xyitem.setBasePositiveItemLabelPosition( new  ItemLabelPosition
				(ItemLabelAnchor.OUTSIDE12,   TextAnchor.BASELINE_LEFT));
				xyitem.setBaseItemLabelGenerator( new  StandardXYItemLabelGenerator());
				xyitem.setBaseItemLabelFont(new  Font("Dialog",  1, 14));
		plot.setRenderer(xyitem);
		
		String file_name = Constant.path +"/JFreeChar/pie/LineTest_02.jpg";
		
		ChartUtilities.saveChartAsJPEG(new File(file_name), chart, 800, 500);
	}
}
