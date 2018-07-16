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

public class OrderListView사용안함 extends JFrame implements ActionListener,MouseListener {

	private JPanel contentPane;
	private JButton logoutBtn;
	private JTable jTable;
	private JScrollPane jScrPane;
	private JButton writeBtn;

	private JComboBox<String> choiceList;

	private JTextField selectField;
	private JButton selectBtn;

	String columnNames[] = { "번호", "상품명", "상품수량", "상품금액", "총상품금액" };

	Object rowData[][] = { { "1", "신라면", "10개", "4000", "4000" } };
		
	DefaultTableModel model;

	public OrderListView사용안함() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		getContentPane().setLayout(null);

		String cur = System.getProperty("user.dir");
		System.out.println("cur:" + cur);
		contentPane.setLayout(null);

		JLabel loginLabel = new JLabel("주문상세보기");
		loginLabel.setBounds(10, 10, 120, 15);
		getContentPane().add(loginLabel);

		model = new DefaultTableModel(columnNames, 0);

		model.setDataVector(rowData, columnNames);

		jTable = new JTable(model) {
		public boolean isCellEditable(int row, int column) {
			if(column == 4) {
				return true;
			}else {
				return false;
			}
		}
		};
		jTable.addMouseListener(this);

		jTable.getColumnModel().getColumn(0).setMaxWidth(500);
		jTable.getColumnModel().getColumn(1).setMaxWidth(700);
		jTable.getColumnModel().getColumn(2).setMaxWidth(700);
		jTable.getColumnModel().getColumn(3).setMaxWidth(700);
		jTable.getColumnModel().getColumn(4).setMaxWidth(700);

		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);

		jScrPane = new JScrollPane(jTable);

		jScrPane.setBounds(10, 50, 1902, 708);
		getContentPane().add(jScrPane);

		writeBtn = new JButton("수정 완료");
		writeBtn.addActionListener(this);
		writeBtn.setBounds(1659, 859, 164, 114);
		getContentPane().add(writeBtn);

		getContentPane().setBackground(Color.cyan);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == writeBtn) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					    dispose(); // 현재 창을 닫음
				}
			});
		}
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
}
