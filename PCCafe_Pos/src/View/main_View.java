package View;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.POS_Dao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main_View extends JFrame implements ActionListener {
	private POS_Dao dao = POS_Dao.getInstance();
	private JButton checkSpot, addTime;

	public main_View() {
		ImageIcon icon = new ImageIcon("backGround.jpg");
		JPanel contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		checkSpot = new JButton(new ImageIcon("checkSpot.png"));
		checkSpot.setBounds(996, 186, 557, 672);
		checkSpot.setOpaque(false);
		checkSpot.setContentAreaFilled(false);
		checkSpot.setBorder(null);
		contentPane.add(checkSpot);

		addTime = new JButton(new ImageIcon("addTime.png"));
		addTime.setBounds(335, 186, 557, 672);
		addTime.setOpaque(false);
		addTime.setContentAreaFilled(false);
		addTime.setBorder(null);
		contentPane.add(addTime);

		setResizable(false);
		setContentPane(contentPane);
		setBounds(0, 0, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		checkSpot.addActionListener(this);
		addTime.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == addTime) {
			dao.addTimeView();
			this.dispose();
		} else if (obj == checkSpot) {
			dao.serCtrl.sendSign();
			dao.checkSpotView();
			this.dispose();
		}
	}
}