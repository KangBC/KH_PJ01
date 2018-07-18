package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Dto.BbsDto;
import Dto.MemberDto;
import Singleton.Singleton;

public class OrderView extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTable jTable;
	private JScrollPane jScrPane;
	private JTextField selectField;
	private JButton logoutBtn;
	private JButton writeBtn;
	private JButton selectBtn;
	private JButton btnNewButton;

	Singleton sc = Singleton.getInstance();

	String columnNames[] = { "번호", "ID", "상품명", "가격", "작성자", "날자" };

	Object rowData[][];

	DefaultTableModel model;

	List<BbsDto> list;

	public OrderView(List<BbsDto> list) {
		super("주문확인");

		this.list = list;

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		String cur = System.getProperty("user.dir");
		System.out.println("cur:" + cur);
		contentPane.setLayout(null);

		JLabel loginLabel = new JLabel("주문확인");
		loginLabel.setBounds(10, 10, 120, 15);
		getContentPane().add(loginLabel);

		// List size
		int len = list.size();
		int n = 1;

		rowData = new Object[len][6];

		// String columnNames[] = { "번호", "ID","상품명", "가격","작성자", "날자" };

		for (int i = 0; i < len; i++) {
			// BbsDto dto = list.get(i);
			BbsDto dto = list.get(i);
			rowData[i][0] = n;
			rowData[i][1] = dto.getTitle();
			rowData[i][2] = dto.getContent();
			rowData[i][3] = dto.getUserNum();
			rowData[i][4] = dto.getReadCount();
			rowData[i][5] = dto.getCreatedDate();
			n++;
		}

		model = new DefaultTableModel(columnNames, 0);

		model.setDataVector(rowData, columnNames);

		jTable = new JTable(model) {
			// 테이블 text 수정방지
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		jTable.addMouseListener(this);

		jTable.getColumnModel().getColumn(0).setMaxWidth(700);
		jTable.getColumnModel().getColumn(1).setMaxWidth(700);
		jTable.getColumnModel().getColumn(2).setMaxWidth(700);
		jTable.getColumnModel().getColumn(3).setMaxWidth(700);
		jTable.getColumnModel().getColumn(4).setMaxWidth(700);
		jTable.getColumnModel().getColumn(5).setMaxWidth(700);

		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);

		jScrPane = new JScrollPane(jTable);
		jScrPane.setBounds(0, 39, 1910, 684);
		getContentPane().add(jScrPane);

		// menu
		writeBtn = new JButton("menu");
		writeBtn.setBounds(10, 747, 290, 99);
		getContentPane().add(writeBtn);
		writeBtn.addActionListener(this);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
	// 게시글 마우스 클릭 -- 나중에 확인?
	public void mouseReleased(MouseEvent e) {
		/*
		 * int rowNum = jTable.getSelectedRow();
		 * sc.bbsCtrl.bbsDetail(list.get(rowNum).getPostNum());
		 */
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		/*
		 * DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		 * 
		 * // menu view 돌아가기 if (obj == writeBtn) { sc.bbsCtrl.bbsWrite();
		 * 
		 * this.dispose(); }
		 */
	}
}
