package command.layout;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {

	JPanel content = new JPanel();

	ActionListener a = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			content.removeAll();
			content.setLayout(new FlowLayout());
			content.add(new JButton("1"));
			content.add(new JButton("2"));
			content.add(new JButton("3"));
			content.add(new JButton("4"));
			content.add(new JButton("5"));
			content.updateUI();
		}
	};

	ActionListener a2 = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			content.removeAll();
			content.setLayout(new BorderLayout());
			content.add(new JButton("NORTH"), BorderLayout.NORTH);
			content.add(new JButton("SOUTH"), BorderLayout.SOUTH);
			content.add(new JButton("WEST"), BorderLayout.WEST);
			content.add(new JButton("EAST"), BorderLayout.EAST);
			content.add(new JButton("CENTER"), BorderLayout.CENTER);
			content.updateUI();
		}

	};

	public void init() {
		JPanel p = new JPanel();
		JButton btn = new JButton("FlowLayout Show");
		JButton btn2 = new JButton("BorderLayout Show");
		p.add(btn);
		p.add(btn2);

		add(p, BorderLayout.NORTH);
		add(content);

		btn.addActionListener(a);
		btn2.addActionListener(a2);

		setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MyFrame().init();
	}
}
