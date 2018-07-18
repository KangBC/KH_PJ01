package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Dto.BbsDto;
import Singleton.Singleton;

public class BbsAddView extends JFrame implements ActionListener {

	JTextField writerText;
	JTextField titleText;
	JTextArea contentArea;
	JButton writeBtn;
	JButton backBtn;

	Singleton sc = Singleton.getInstance();

	public BbsAddView() {
		super("글쓰기");
		getContentPane().setLayout(null);

		JLabel writerLabel = new JLabel("작성자:");
		writerLabel.setBounds(10, 10, 120, 15);
		getContentPane().add(writerLabel);

		writerText = new JTextField("관리자");
		writerText.setBounds(120, 10, 200, 20);
		writerText.setEditable(false);
		getContentPane().add(writerText);

		JLabel titleLabel = new JLabel("제목:");
		titleLabel.setBounds(10, 40, 120, 32);
		getContentPane().add(titleLabel);

		titleText = new JTextField();
		titleText.setBounds(120, 40, 350, 32);
		getContentPane().add(titleText);

		JLabel contentLabel = new JLabel("내용:");
		contentLabel.setBounds(10, 90, 120, 15);
		getContentPane().add(contentLabel);

		contentArea = new JTextArea();
		contentArea.setLineWrap(true);

		JScrollPane scrPane = new JScrollPane(contentArea);
		scrPane.setBounds(10, 117, 460, 419);
		scrPane.setPreferredSize(new Dimension(200, 120));
		getContentPane().add(scrPane);

		writeBtn = new JButton("글올리기");
		writeBtn.setBorderPainted(true);
		writeBtn.setContentAreaFilled(false);
		writeBtn.setFocusable(false);
		writeBtn.setForeground(Color.black);
		writeBtn.setBounds(370, 559, 100, 40);
		getContentPane().add(writeBtn);

		backBtn = new JButton("목록");
		backBtn.setBorderPainted(true);
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusable(false);
		backBtn.setForeground(Color.black);
		backBtn.setBounds(14, 559, 100, 40);
		getContentPane().add(backBtn);
		
		setBounds(550, 200, 500, 700);
		setVisible(true);

		writeBtn.addActionListener(this);
		backBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		
		if(btn == writeBtn) {
			String title = titleText.getText();
			String content = contentArea.getText();

			// BbsAddView 가 TITLE,CONTENT 가 공백일때
			BbsDto dto = new BbsDto(1, 0, title, content);
			if (title.equals("") == true || content.equals("") == true) {
				JOptionPane.showMessageDialog(null, "제목,내용을 입력확인해주세요");
			} else {
				sc.bbsCtrl.bbsWriteAf(dto);
			}
			dispose();
		}else if(btn == backBtn) {
			sc.bbsCtrl.drawBbsList();
			dispose();
		}
	}

}
