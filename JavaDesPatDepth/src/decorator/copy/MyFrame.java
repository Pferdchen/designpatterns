package decorator.copy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyFrame extends JFrame {

	private String directSrc;
	private String directDest;
	JTextField fromtxt = new JTextField(60);
	JTextField totxt = new JTextField(60);

	public void init() {
		setLayout(null);
		JButton frombtn = new JButton("Select Source Folder");
		JButton tobtn = new JButton("Select Destination Folder");
		JButton btn = new JButton("Start Copy");
		fromtxt.setEnabled(false);
		totxt.setEnabled(false);
		frombtn.setBounds(20, 30, 100, 30);
		tobtn.setBounds(20, 70, 100, 30);
		btn.setBounds(200, 110, 100, 30);
		fromtxt.setBounds(140, 30, 300, 30);
		totxt.setBounds(140, 70, 300, 30);
		add(frombtn);
		add(fromtxt);
		add(tobtn);
		add(totxt);
		add(btn);

		frombtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				directSrc = getDirect();
				fromtxt.setText(directSrc);
			}
		});

		tobtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				directDest = getDirect();
				totxt.setText(directDest);
			}
		});

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ICopy obj = new Copy();
				ICopy obj2 = new DirectCopy(obj);
				try {
					obj2.copy(directSrc, directDest);
				} catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});

		setSize(460, 180);
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private String getDirect() {
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int ret = fc.showDialog(this, "Please select folder");
		if (ret == JFileChooser.APPROVE_OPTION)
			return fc.getSelectedFile().getAbsolutePath();
		return null;
	}

	public static void main(String[] args) {
		new MyFrame().init();
	}
}
