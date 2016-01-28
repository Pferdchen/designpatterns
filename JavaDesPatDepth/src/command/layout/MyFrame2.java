package command.layout;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame2 extends JFrame implements ActionListener {

	JPanel content = new JPanel();

	class FlowBtn extends JButton implements IReceiver {

		public FlowBtn(String name) {
			super(name);
		}

		@Override
		public void response() {
			content.removeAll();
			content.setLayout(new FlowLayout());
			content.add(new JButton("1"));
			content.add(new JButton("2"));
			content.add(new JButton("3"));
			content.add(new JButton("4"));
			content.add(new JButton("5"));
			content.updateUI();
		}
	}

	class BorderBtn extends JButton implements IReceiver {

		public BorderBtn(String name) {
			super(name);
		}

		@Override
		public void response() {
			content.removeAll();
			content.setLayout(new BorderLayout());
			content.add(new JButton("NORTH"), BorderLayout.NORTH);
			content.add(new JButton("SOUTH"), BorderLayout.SOUTH);
			content.add(new JButton("WEST"), BorderLayout.WEST);
			content.add(new JButton("EAST"), BorderLayout.EAST);
			content.add(new JButton("CENTER"), BorderLayout.CENTER);
			content.updateUI();
		}
	}

	public void init() {
		JPanel p = new JPanel();
		FlowBtn btn = new FlowBtn("FlowLayout Show");
		BorderBtn btn2 = new BorderBtn("BorderLayout Show");
		p.add(btn);
		p.add(btn2);

		add(p, BorderLayout.NORTH);
		add(content);

		btn.addActionListener(this);
		btn2.addActionListener(this);

		setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IReceiver obj = (IReceiver) e.getSource();
		obj.response();
	}

	public static void main(String[] args) {
		new MyFrame2().init();
	}
}
