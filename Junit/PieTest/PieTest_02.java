package PieTest;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.Test;

import constant.Constant;
/**
 * @summary��
 * 		������ͼ�������ñ��⣨���ı��⣩ 
 *
 */
public class PieTest_02 {
	@Test
	public void CreatePie_test() throws IOException{
		//������ͼ��Ҫ������
		DefaultPieDataset ds = new DefaultPieDataset();
		ds.setValue("C/C++", 27);
		ds.setValue("Java", 18);
		ds.setValue("object-c",10);
		ds.setValue("C#", 6);
		ds.setValue("PHP", 4);
		ds.setValue("vb", 4);
		ds.setValue("Python", 4);
		ds.setValue("SQL", 4);
		ds.setValue("Javascript", 4);
		ds.setValue("Ruby", 2);
		
		//����JFreeChart����
		JFreeChart chart = ChartFactory.createPieChart("�й����еı������", ds, true, false, false);
		
		//���ñ������壨����ͨ�������������������⣩
		chart.getTitle().setFont(new Font("����", Font.BOLD, 25));
		
		//��ʾ������
		chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 15));
		
		//�õ���ͼ��
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setLabelFont(new Font("����", Font.ITALIC, 15));
		
		
		
		//����ǰ��͸��
		//plot.setForegroundAlpha(0.75f);
		
		//���Ʊ�ǩ
		//{0}:����
		//{1}:����
		//{2}:�ٷֱ�
		//{3}:�ܺ�
		//{4}:û����
		//�˴�����ͨ��log4j��־����������
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}:{2}"));
		
		String file_name = Constant.path +"/JFreeChar/pie/PieTest_02.jpg";
		
		//���浽ͼƬ��
		ChartUtilities.saveChartAsJPEG(new File(file_name), chart, 800, 500);
	}
}
