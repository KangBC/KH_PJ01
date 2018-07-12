package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class BbsListView extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTable jTable;
	private JScrollPane jScrPane;
	private JButton logoutBtn;
	private JButton writeBtn;
	private JButton selectBtn;

	private JComboBox<String> choiceList;

	private JTextField selectField;

	String columnNames[] = { "번호", "내용", "작성자" };

	Object rowData[][] = { { "진라면", "10", "50", "100" }, 
			{ "홈런볼", "20", "40", "90" }, 
			{ "햄버거", "30", "30", "70" },
			{ "핫바", "30", "30", "70" }, 
			{ "콜라", "30", "30", "70" } };

	DefaultTableModel model;

	public BbsListView() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		String cur = System.getProperty("user.dir");
		System.out.println("cur:" + cur);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		JLabel loginLabel = new JLabel("게시판");
		loginLabel.setBounds(10, 10, 120, 15);
		getContentPane().add(loginLabel);

		model = new DefaultTableModel(columnNames, 0);

		model.setDataVector(rowData, columnNames);

		jTable = new JTable(model);
		jTable.addMouseListener(this);

		jTable.getColumnModel().getColumn(0).setMaxWidth(700);
		jTable.getColumnModel().getColumn(1).setMaxWidth(700);
		jTable.getColumnModel().getColumn(2).setMaxWidth(700);

		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);

		jScrPane = new JScrollPane(jTable);
		jScrPane.setBounds(0, 39, 1910, 684);
		getContentPane().add(jScrPane);

		writeBtn = new JButton("글쓰기");
		writeBtn.setBounds(10, 751, 161, 91);
		writeBtn.addActionListener(this);
		getContentPane().add(writeBtn);

		// 검색
		selectField = new JTextField();
		selectField.setBounds(608, 881, 813, 99);
		getContentPane().add(selectField);

		selectBtn = new JButton("검색");
		selectBtn.setBounds(1418, 880, 147, 101);
		selectBtn.addActionListener(this);
		getContentPane().add(selectBtn);

		getContentPane().setBackground(Color.GRAY);
		
		JButton button = new JButton("수정");
		button.setBounds(191, 746, 147, 101);
		contentPane.add(button);
		
		JButton button_1 = new JButton("삭제");
		button_1.setBounds(1763, 746, 147, 101);
		contentPane.add(button_1);
		setBounds(100, 100, 1928, 1060);
		setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
