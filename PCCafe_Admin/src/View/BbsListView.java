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

	String columnNames[] = { "번호", "제목", "내용", "작성자", "조회수" };

	Object rowData[][] = { { "진라면", "10", "50", "100", "2" } };

	DefaultTableModel model;
	private JButton btnNewButton;

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
		jTable.getColumnModel().getColumn(3).setMaxWidth(700);
		jTable.getColumnModel().getColumn(4).setMaxWidth(700);

		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);

		jScrPane = new JScrollPane(jTable);
		jScrPane.setBounds(0, 39, 1910, 684);
		getContentPane().add(jScrPane);

		// 글쓰기
		writeBtn = new JButton("글쓰기");
		writeBtn.setBounds(10, 747, 290, 99);
		writeBtn.addActionListener(this);
		getContentPane().add(writeBtn);
		writeBtn.addActionListener(this);

		selectField = new JTextField();
		selectField.setBounds(482, 902, 813, 99);
		getContentPane().add(selectField);

		// 검색
		selectBtn = new JButton("검색");
		selectBtn.setBounds(1299, 901, 147, 101);
		selectBtn.addActionListener(this);
		getContentPane().add(selectBtn);
		getContentPane().setBackground(Color.GRAY);

		btnNewButton = new JButton("확인");
		btnNewButton.setBounds(1606, 901, 290, 100);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);

		// Choice(AWT) -> JComboBox(swing)
		String[] selects = new String[] { "번호", "제목", "내용", "작성자" };
		choiceList = new JComboBox<>(selects);
		choiceList.setBounds(180, 900, 290, 100);
		add(choiceList);

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
	// 확인버튼
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnNewButton) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					ControlView frame = new ControlView();
					frame.setVisible(true);
				}
			});

	//글쓰기
		} else if (obj == writeBtn) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					ControlView frame = new ControlView();
					frame.setVisible(true);
				}
			});
		}
	}
}
