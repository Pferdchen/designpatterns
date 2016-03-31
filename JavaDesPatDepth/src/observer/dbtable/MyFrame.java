package observer.dbtable;

import java.awt.BorderLayout;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public void init() {
		setLayout(null);

		JTable nameTable = new JTable();
		JTable structTable = new JTable();
		JTable showTable = new JTable();
		JScrollPane namePane = new JScrollPane(nameTable);
		JScrollPane structPane = new JScrollPane(structTable);
		JScrollPane showPane = new JScrollPane(showTable);

		JPanel left = new JPanel();
		left.setLayout(new BorderLayout());
		JPanel struct = new JPanel();
		struct.setLayout(new BorderLayout());
		JPanel show = new JPanel();
		show.setLayout(new BorderLayout());

		left.add(namePane);
		struct.add(structPane);
		show.add(showPane);
		add(left);
		add(struct);
		add(show);
		left.setSize(200, 500);
		struct.setSize(500, 200);
		show.setSize(500, 290);
		left.setBounds(0, 0, left.getWidth(), left.getHeight());
		struct.setBounds(210, 0, struct.getWidth(), struct.getHeight());
		show.setBounds(210, 210, show.getWidth(), show.getHeight());

		setSize(700, 500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			Subject subject = new Subject(nameTable);
			Observer obj = new StructObserver(structTable);
			Observer obj2 = new ShowObserver(showTable);
			subject.addObserver(obj);
			subject.addObserver(obj2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MyFrame().init();
	}
}
