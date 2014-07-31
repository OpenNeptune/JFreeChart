package BarTest;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.Test;

import constant.Constant;

/**
 * 
 * @Summary:�����򵥵���״ͼ
 */
public class BarTest_01 {
	@Test
	public void CreateBar() throws IOException{
		//������״ͼ����Ҫ�����ݼ�����
		DefaultCategoryDataset ds = new DefaultCategoryDataset();
		ds.addValue(6000,"PHP","Windows");
		ds.addValue(5000,"JAVA","Windows");
		ds.addValue(4000,"Python","Windows");
		
		ds.addValue(5000,"PHP","Linux");
		ds.addValue(4500,"JAVA","Linux");
		ds.addValue(3200,"Python","Linux");
		
		ds.addValue(5000,"PHP","Mac");
		ds.addValue(3000,"JAVA","Mac");
		ds.addValue(3000,"Python","Mac");
		
		JFreeChart chart = ChartFactory.createBarChart(
				"����������ϵͳƽ̨����ʹ��", // ͼ�����
				"��������", // Ŀ¼�����ʾ��ǩ
				"ʹ������", // ��ֵ�����ʾ��ǩ
				ds, // ���ݼ�
				PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
				true, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
				false, // �Ƿ����ɹ���
				false // �Ƿ�����URL����
		);
		
		//���ñ������壨����ͨ�������������������⣩
		chart.getTitle().setFont(new Font("����", Font.BOLD, 25));
		
		//��ʾ������
		chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 15));
		
		//�õ���ͼ��
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		//domain���ǩ����
		plot.getDomainAxis().setLabelFont(new Font("����", Font.PLAIN, 15));
		//domain��С��ǩ����
		plot.getDomainAxis().setTickLabelFont(new Font("����", Font.PLAIN, 15));
		
		//range���ǩ����
		plot.getRangeAxis().setLabelFont(new Font("����", Font.PLAIN, 15));
		
		
		String file_name = Constant.path +"/JFreeChar/pie/BarTest_01.jpg";
		
		//���浽ͼƬ��
		ChartUtilities.saveChartAsJPEG(new File(file_name), chart, 800, 500);
		
	}
}
