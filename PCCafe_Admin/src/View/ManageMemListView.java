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

public class ManageMemListView extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JButton logoutBtn,btnNewButton;
	private JTable jTable;
	private JScrollPane jScrPane;
	private JButton writeBtn;

	private JComboBox<String> choiceList;

	private JTextField selectField;
	private JButton selectBtn;

	String columnNames[] = { "번호", "상품명", "개수", "총금액" };

	Object rowData[][] = { { "1", "진라면", "1개", "2000" }};

	DefaultTableModel model;

	public ManageMemListView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 698);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		String cur = System.getProperty("user.dir");
		System.out.println("cur:" + cur);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		JLabel loginLabel = new JLabel("주문확인");
		loginLabel.setBounds(10, 10, 120, 15);
		getContentPane().add(loginLabel);

		model = new DefaultTableModel(columnNames, 0);

		model.setDataVector(rowData, columnNames);

		jTable = new JTable(model) {
			//테이블 클릭금지
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		jTable.getColumnModel().getColumn(0).setMaxWidth(700);
		jTable.getColumnModel().getColumn(1).setMaxWidth(700);
		jTable.getColumnModel().getColumn(2).setMaxWidth(700);
		jTable.getColumnModel().getColumn(3).setMaxWidth(700);

		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);

		jScrPane = new JScrollPane(jTable);
		jScrPane.setBounds(10, 50, 600, 300);
		getContentPane().add(jScrPane);


		getContentPane().setBackground(Color.GRAY);
		
		btnNewButton = new JButton("완료");
		btnNewButton.setBounds(503, 376, 105, 27);
		contentPane.add(btnNewButton);
		setBounds(100, 100, 640, 480);
		setVisible(true);
		btnNewButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnNewButton) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					dispose(); // 현재 창을 닫음
				}
			});
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
