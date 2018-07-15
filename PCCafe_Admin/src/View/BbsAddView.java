package View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Dao.BbsDao;
import Dto.BbsDto;
import Singleton.Singleton;
import View.BbsListView;

public class BbsAddView extends JFrame implements ActionListener {

	JTextField writerText;
	JTextField titleText;
	JTextArea contentArea;
	JButton btn;
	JButton backBtn;

	public BbsAddView() {
		super("글쓰기");
		setLayout(null);

		JLabel writerLabel = new JLabel("작성자:");
		writerLabel.setBounds(10, 10, 120, 15);
		add(writerLabel);

		writerText = new JTextField();
		writerText.setBounds(120, 10, 200, 20);
		writerText.setEditable(false);
		add(writerText);

		JLabel titleLabel = new JLabel("제목:");
		titleLabel.setBounds(10, 40, 120, 15);
		add(titleLabel);

		titleText = new JTextField();
		titleText.setBounds(120, 40, 350, 20);
		add(titleText);

		JLabel contentLabel = new JLabel("내용:");
		contentLabel.setBounds(10, 70, 120, 15);
		add(contentLabel);

		contentArea = new JTextArea();
		contentArea.setLineWrap(true);

		JScrollPane scrPane = new JScrollPane(contentArea);
		scrPane.setPreferredSize(new Dimension(200, 120));
		scrPane.setBounds(10, 100, 460, 300);
		add(scrPane);

		btn = new JButton("글올리기");
		btn.setBounds(150, 420, 100, 20);
		add(btn);

		setBounds(100, 100, 500, 500);
		setVisible(true);

		backBtn = new JButton("목록");
		backBtn.setBounds(10, 420, 100, 20);
		add(backBtn);

		// 글올리기
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton sc = Singleton.getInstance();
				System.out.println("btn.addActionListener");

				// Date d = new Date();
				// SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
				// System.out.println("sdf = " + sdf.format(d));

				// String id = sc.memCtrl.getLoginId();
				String id = "관리자";
				String title = titleText.getText();
				String content = contentArea.getText();
				// String wdate = sdf.format(d);

				// BbsAddView 가 TITLE,CONTENT 가 공백일때
				BbsDto dto = new BbsDto(0, 0, title, content);
				if (title.equals("") == true || content.equals("") == true) {
					JOptionPane.showMessageDialog(null, "제목,내용을 입력확인해주세요");
				} else {
					sc.bbsCtrl.bbsWriteAf(dto);
				}
				dispose();
			}
		});

		// 목록
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton sc = Singleton.getInstance();
				sc.bbsCtrl.getBbsList();
				dispose();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
