package decorator.importdb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class MyFrame extends JFrame {

	JTextField seltxt = new JTextField(60);
	JProgressBar bar = new JProgressBar();
	String strFile;

	public void init() {
		setLayout(null);
		JButton selbtn = new JButton("Select file");
		JButton btn = new JButton("Start import");
		seltxt.setEnabled(false);// seltxt.setEnabled(false);
		selbtn.setBounds(20, 30, 100, 30);
		btn.setBounds(20, 70, 100, 30);
		seltxt.setBounds(140, 30, 200, 30);
		bar.setBounds(140, 70, 200, 30);
		add(selbtn);
		add(seltxt);
		add(btn);
		add(bar);

		selbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int ret = fc.showDialog(MyFrame.this, "Please select file");
				if (ret == JFileChooser.APPROVE_OPTION) {
					strFile = fc.getSelectedFile().getAbsolutePath();
					seltxt.setText(strFile);
				}
			}
		});

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DbEntry obj = new DbEntry();
					Progress pg = new Progress(obj, strFile);
					pg.setBar(bar);
					new Thread(pg).start();
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
	
	public static void main (String[] args) throws Exception {
		new MyFrame().init();
	}
}
