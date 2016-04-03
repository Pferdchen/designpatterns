package bridge.bsshow;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import db.connection.DbProc;

public class GraphShow extends AbstractShow {

	@Override
	public String show(String no) throws Exception {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		String s = "";
		String title[] = para.getTitle();
		String strSQL = para.getPreSQL() + "'" + no + "'";
		DbProc dbobj = new DbProc();
		Connection conn = dbobj.connect();
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(strSQL);
		String name = "";
		if (rst.next()) {
			name = rst.getString(2);
			for (int i = 3; i <= title.length; i++) {
				dataset.addValue(rst.getInt(i), name, title[i - 1]);
			}
		}
		JFreeChart chart = ChartFactory.createLineChart(name, "", "", dataset, PlotOrientation.VERTICAL, false, false,
				false);
		ChartUtilities.saveChartAsJPEG(new File("d:/tmp.jpg"), 0.5f, chart, 500, 300);

		stm.close();
		conn.close();
		s = "<img src='d:/tmp.jpg' border='0'></img>";
		return s;
	}

}
