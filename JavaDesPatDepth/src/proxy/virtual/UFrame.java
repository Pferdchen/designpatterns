package proxy.virtual;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class UFrame extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;

	ManageItems manage = new ManageItems();
	JTable table;
	JTextArea t = new JTextArea();
	JTextArea t2 = new JTextArea();

	public void init() throws Exception {
		setLayout(null);
		manage.firstSearch();

		String title[] = { "Account", "Name", "Project" };
		String data[][] = null;
		Vector<ProxyItem> v = manage.v;
		data = new String[v.size()][title.length];
		for (int i = 0; i < v.size(); i++) {
			ProxyItem proxy = v.get(i);
			data[i][0] = proxy.getAccount();
			data[i][1] = proxy.getName();
			data[i][2] = proxy.getProject();
		}

		table = new JTable(data, title);
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(10, 10, 200, 340);
		JLabel label = new JLabel("Projct Main Content");
		JLabel label2 = new JLabel("Plan");
		label.setBounds(230, 5, 100, 20);
		t.setBounds(230, 40, 200, 100);
		label2.setBounds(230, 160, 100, 20);
		t2.setBounds(230, 195, 200, 100);

		add(pane);
		add(label);
		add(t);
		add(label2);
		add(t2);

		table.addMouseListener(this);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 350);
		setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			int n = table.getSelectedRow();
			if (n >= 0) {
				ProxyItem item = manage.v.get(n);
				item.itemFill();
				t.setText(item.getContent());
				t2.setText(item.getPlan());
			}
		} catch (Exception ee) {
		}
	}

	public static void main(String[] args) throws Exception {
		new UFrame().init();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
