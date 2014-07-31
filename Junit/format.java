import java.io.File;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class format {
		public static void main(String[] args) {
			// ����һ����״ͼ
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			// װ������
			dataset.setValue(6, "Profit", "Jane");
			dataset.setValue(3, "Profit2", "Jane");
			dataset.setValue(7, "Profit", "Tom");
			dataset.setValue(6, "Profit2", "Tom");
			dataset.setValue(8, "Profit", "Jill");
			dataset.setValue(9, "Profit2", "Jill");
			dataset.setValue(5, "Profit", "John");
			dataset.setValue(8, "Profit2", "John");
			dataset.setValue(12, "Profit", "Fred");
			dataset.setValue(11, "Profit2", "Fred");

			// ������״ͼ
			// JFreeChart chart =
			// ChartFactory.createXYLineChart("����"��"x���־","y���־","��������","����ͼ����ʾ����",�Ƿ���ʾͼ��,�Ƿ������ʾ,�Ƿ����ñ����ŵ�ַ);
			// ͼ����ʾ����
			// (1)HORIZONTAL:������ʾͼ��
			// (2)VERTICAL:������ʾͼ��
			// 3D��״ͼ
			JFreeChart chart = ChartFactory.createBarChart3D("����ͳ��ͼ", "��ֵ", "ʱ��", dataset, PlotOrientation.VERTICAL, true, true, false);

			// �����ܵı�����ɫ
			chart.setBackgroundPaint(ChartColor.WHITE);
			// ���ñ�����ɫ
			chart.getTitle().setPaint(ChartColor.blue);
			// ���ͼ�����
			CategoryPlot p = chart.getCategoryPlot();
			// ����ͼ�ı�����ɫ
			p.setBackgroundPaint(ChartColor.WHITE);
			// ���ñ������ɫ
			p.setRangeGridlinePaint(ChartColor.red);
			try {
				// // ����ͼ����ʾ���
				// ChartFrame cf = new ChartFrame("��״ͼ",chart);
				// cf.pack();
				// // ����ͼƬ��С
				// cf.setSize(500,300);
				// // ����ͼ�οɼ�
				// cf.setVisible(true);

				// ����ͼƬ��ָ���ļ���
				ChartUtilities.saveChartAsPNG(new File("d:\\BarChart.png"), chart, 500, 300);

			} catch (Exception e) {
				System.err.println("Problem occurred creating chart.");
			}
		}

}
