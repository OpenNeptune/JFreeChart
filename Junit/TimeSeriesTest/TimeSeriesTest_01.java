package TimeSeriesTest;

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
import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
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
public class TimeSeriesTest_01 {
	@Test
	public void CreateLine() throws IOException{
		TimeSeries  timeSeries  = new TimeSeries("ǰ��");
		for(int j=0;j<24;j++){
			//ÿ��Сʱһ����
			timeSeries.add(new Hour(j,02,03,2013), (int)(Math.random()* 8000 + 6000) );
			//û30����һ����
//			for(int i=0;i<2;i++){
//				timeSeries.add(new Minute(i*30,new Hour(j,02,03,2013)), (int)(Math.random()* 8000 + 6000) );
//			}
		}

		TimeSeries  timeSeries1  = new TimeSeries("����");
		for(int j=0;j<24;j++){
			//ÿ��Сʱһ����
			timeSeries1.add(new Hour(j,02,03,2013), (int)(Math.random()* 8000 + 6000) );
			//û30����һ����
//			for(int i=0;i<2;i++){
//				timeSeries1.add(new Minute(i*30,new Hour(j,02,03,2013)), (int)(Math.random()* 8000 + 6000) );
//			}
		}

		//ʱ���������ݼ���
		TimeSeriesCollection  lineDataset  = new TimeSeriesCollection();
		
		
		lineDataset.addSeries(timeSeries);
		lineDataset.addSeries(timeSeries1);
		
		JFreeChart  chart  = ChartFactory.createTimeSeriesChart(" ������ͳ��ʱ����",  "ʱ���", "������", lineDataset,  true,  true,  true);
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
		
		String file_name = Constant.path +"/JFreeChar/pie/TimeSeriesTest_03.jpg";
		
		ChartUtilities.saveChartAsJPEG(new File(file_name), chart, 1300, 800);
	}
}
