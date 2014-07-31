package LineTest;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.Test;

import constant.Constant;

public class LineTest_01 {
	@Test
	public void CreateLine() throws IOException{
		
		//����������ݼ�
		DefaultCategoryDataset ds = new DefaultCategoryDataset();
		ds.addValue(3400, "HOST1", "0");
		ds.addValue(3100, "HOST2", "0");
		ds.addValue(1950, "HOST3", "0");
		
		ds.addValue(3300, "HOST1", "2");
		ds.addValue(3600, "HOST2", "2");
		ds.addValue(2150, "HOST3", "2");
		
		
		ds.addValue(3600, "HOST1", "4");
		ds.addValue(3600, "HOST2", "4");
		ds.addValue(2350, "HOST3", "4");
		
		ds.addValue(3400, "HOST1", "6");
		ds.addValue(3200, "HOST2", "6");
		ds.addValue(1850, "HOST3", "6");
		
		ds.addValue(3800, "HOST1", "8");
		ds.addValue(3000, "HOST2", "8");
		ds.addValue(2950, "HOST3", "8");
		
		ds.addValue(3000, "HOST1", "10");
		ds.addValue(3400, "HOST2", "10");
		ds.addValue(1800, "HOST3", "10");
		
		ds.addValue(3900, "HOST1", "12");
		ds.addValue(3200, "HOST2", "12");
		ds.addValue(1950, "HOST3", "12");
		
		ds.addValue(3400, "HOST1", "14");
		ds.addValue(3100, "HOST2", "14");
		ds.addValue(1950, "HOST3", "14");
		
		ds.addValue(3300, "HOST1", "16");
		ds.addValue(3600, "HOST2", "16");
		ds.addValue(2150, "HOST3", "16");
		
		
		ds.addValue(3600, "HOST1", "18");
		ds.addValue(3600, "HOST2", "18");
		ds.addValue(2350, "HOST3", "18");
		
		ds.addValue(3400, "HOST1", "20");
		ds.addValue(3200, "HOST2", "20");
		ds.addValue(1850, "HOST3", "20");
		
		ds.addValue(3800, "HOST1", "22");
		ds.addValue(3000, "HOST2", "22");
		ds.addValue(2950, "HOST3", "22");
		
		ds.addValue(3000, "HOST1", "24");
		ds.addValue(3400, "HOST2", "24");
		ds.addValue(1800, "HOST3", "24");
		
		
		//����jfreechart����( ��ͼ)
		String title1 = "�����������" ;
		String title2 = "Сʱ" ;
		String title3 = "������(��:��)";
		JFreeChart chart = ChartFactory.createLineChart(title1, title2, title3, ds, PlotOrientation.VERTICAL, true, false, false);
		//��������
		chart.getTitle().setFont(new Font("����", Font.BOLD, 25));
		//��ʾ������
		chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 15));
		//�õ���ͼ��
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		//���ñ�����ɫ
		plot.setBackgroundPaint(ChartColor.BLACK);
		//domain���ǩ����
		plot.getDomainAxis().setLabelFont(new Font("����", Font.PLAIN, 15));
		//domain��С��ǩ����
		plot.getDomainAxis().setTickLabelFont(new Font("����", Font.PLAIN, 15));
		
		//range���ǩ����
		plot.getRangeAxis().setLabelFont(new Font("����", Font.PLAIN, 15));
		
		String file_name = Constant.path +"/JFreeChar/pie/LineTest_01.jpg";
		
		ChartUtilities.saveChartAsJPEG(new File(file_name), chart, 800, 500);
	}
}
