package View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTabbedPane;

public class BbsUpateview extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField idTextfield;
	private JTextField wdateTextfield;
	private JTextField readCountTextfield;
	private JTextField titleTextfield;

	public BbsUpateview() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 0, 0);
		contentPane.add(panel);
		panel.setLayout(null);

		getContentPane().setLayout(null);

		JLabel writerLabel = new JLabel("작성자:");
		writerLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		writerLabel.setBounds(10, 12, 76, 40);
		getContentPane().add(writerLabel);

		idTextfield = new JTextField();
		idTextfield.setBounds(120, 12, 299, 34);
		idTextfield.setEditable(false);
		getContentPane().add(idTextfield);

		JLabel writedLabel = new JLabel("작성일:");
		writedLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		writedLabel.setBounds(10, 62, 76, 24);
		getContentPane().add(writedLabel);

		wdateTextfield = new JTextField();
		wdateTextfield.setBounds(120, 58, 299, 36);
		wdateTextfield.setEditable(false);
		getContentPane().add(wdateTextfield);

		JLabel readLabel = new JLabel("조회수:");
		readLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		readLabel.setBounds(14, 110, 92, 24);
		getContentPane().add(readLabel);

		readCountTextfield = new JTextField();
		readCountTextfield.setBounds(120, 106, 299, 36);
		readCountTextfield.setEditable(false);
		getContentPane().add(readCountTextfield);

		JLabel titleLabel = new JLabel("제목 :");
		titleLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		titleLabel.setBounds(14, 165, 60, 24);
		getContentPane().add(titleLabel);

		titleTextfield = new JTextField();
		titleTextfield.setBounds(119, 159, 300, 40);
		getContentPane().add(titleTextfield);

		JLabel contentLabel = new JLabel("내용:");
		contentLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		contentLabel.setBounds(10, 223, 60, 29);
		getContentPane().add(contentLabel);

		JButton bbsBtn = new JButton("게시판목록");
		bbsBtn.setBounds(14, 760, 159, 70);
		getContentPane().add(bbsBtn);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(14, 264, 456, 443);
		contentPane.add(tabbedPane);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 917);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
