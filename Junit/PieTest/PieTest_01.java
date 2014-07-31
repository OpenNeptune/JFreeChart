package PieTest;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.junit.Test;

import constant.Constant;

public class PieTest_01 {
	
	/**
	 * ����һ����״ͼ
	 * @throws IOException 
	 */
	@Test
	public void CreatePieTest() throws IOException{
		
		String file_name = Constant.path +"/JFreeChar/pie/PieTest_01.jpg";
		
		File file = new File(file_name);
		
		//����jfreechart����( ��ͼ)
		JFreeChart chart=ChartFactory.createPieChart("Title",null,true,true,false);
		
		//��ͼ�񱨴�ָ�����ļ���
		ChartUtilities.saveChartAsJPEG(file, chart, 400, 300);
	}
}
