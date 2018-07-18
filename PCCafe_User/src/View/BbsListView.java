package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Dto.BbsDto;
import Singleton.Singleton;

public class BbsListView extends JFrame implements ActionListener, MouseListener {
	private JPanel contentPane;
	private JTable jTable;
	private JScrollPane jScrPane;
	private JTextField selectField;
	private JComboBox<String> choiceList;
	private JButton logoutBtn;
	private JButton writeBtn;
	private JButton selectBtn;
	private JButton btnNewButton;

	Singleton sc = Singleton.getInstance();

	String columnNames[] = { "번호", "제목", "작성자", "조회수", "날짜" };

	Object rowData[][];

	DefaultTableModel model;

	List<BbsDto> list;

	public BbsListView(List<BbsDto> list) {
		super("게시판");
		
		ImageIcon icon = new ImageIcon("Search.png");
		

		this.list = list;

		this.setLayout(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		String cur = System.getProperty("user.dir");
		System.out.println("cur:" + cur);
		contentPane.setLayout(null);

		JLabel loginLabel = new JLabel("게시판");
		loginLabel.setBounds(10, 10, 120, 15);
		getContentPane().add(loginLabel);

		// List size
		int len = list.size();
		int n = 1;

		rowData = new Object[len][5];

		for (int i = 0; i < len; i++) {
			BbsDto dto = list.get(i);
			rowData[i][0] = n;
			rowData[i][1] = dto.getTitle();
			rowData[i][2] = dto.getUserID(); //  user_id 작성자로 바꿔야함
			rowData[i][3] = dto.getReadCount();
			rowData[i][4] = dto.getCreatedDate();
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
		jTable.setPreferredScrollableViewportSize(new Dimension(400, 200));

		jTable.addMouseListener(this);
		jTable.setRowHeight(25);//////////// 테이블 폭 간격 설정
		jTable.setBackground(Color.white);/////////////////  테이블 색상
		jTable.setFont(new Font("굴림", Font.BOLD, 20));/////////////// 테이블 글씨

		jTable.getColumnModel().getColumn(0).setMaxWidth(100);
		jTable.getColumnModel().getColumn(1).setMaxWidth(3000);
		jTable.getColumnModel().getColumn(2).setMaxWidth(200);
		jTable.getColumnModel().getColumn(3).setMaxWidth(100);
		jTable.getColumnModel().getColumn(4).setMaxWidth(1000);

		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);

		// List 내용 가운데 정렬
		jTable.getColumn("번호").setCellRenderer(celAlignCenter);
		jTable.getColumn("제목").setCellRenderer(celAlignCenter);
		jTable.getColumn("작성자").setCellRenderer(celAlignCenter);
		jTable.getColumn("조회수").setCellRenderer(celAlignCenter);
		jTable.getColumn("날짜").setCellRenderer(celAlignCenter);

		// List 전체틀 및 색상
		jScrPane = new JScrollPane(jTable);
		jScrPane.setBounds(0, 40, 1700, 400);
		getContentPane().add(jScrPane);
		jScrPane.getViewport().setBackground(Color.white); // List 색상

		

		// 글쓰기
		writeBtn = new JButton("글쓰기"); 
		writeBtn.setBounds(50, 500, 200, 100); 
		writeBtn.setFont(new Font("굴림", Font.PLAIN, 30));
		getContentPane().add(writeBtn);
		writeBtn.addActionListener(this);

		// 검색
		selectField = new JTextField();
		selectField.setBounds(550, 500, 800, 100);
		getContentPane().add(selectField);

		selectBtn = new JButton(icon);
		selectBtn.setBounds(1400, 500, 200, 100);
		selectBtn.setBorderPainted(false);
		selectBtn.setContentAreaFilled(false);
		selectBtn.setFocusable(false);
		getContentPane().add(selectBtn); 
		getContentPane().setBackground(new Color(238,238,238));
		selectBtn.addActionListener(this);

		// Choice(AWT) -> JComboBox(swing)
		String[] selects = new String[] { "제목", "작성자" };
		choiceList = new JComboBox<>(selects);
		choiceList.setBounds(350, 500, 150, 100);
		choiceList.setFont(new Font("굴림", Font.PLAIN, 30));
		add(choiceList);
		
		setVisible(true);
		setBounds(90, 200, 1700, 700); //전체틀
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 

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
	// 게시글 마우스 클릭
	public void mouseReleased(MouseEvent e) {

		int rowNum = jTable.getSelectedRow();
		sc.bbsCtrl.bbsDetail(list.get(rowNum).getPostNum());

	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();

		// 글쓰기 view
		if (obj == writeBtn) {
			sc.bbsCtrl.bbsWrite();

			// 검색
		} else if (obj == selectBtn) {
			String selectedItem = (String) choiceList.getSelectedItem();
			if (selectedItem.equals("제목")) {
				sc.bbsCtrl.getBbsFindList("BBS_TITLE", selectField.getText());

				/*
				 * } else if (selectedItem.equals("내용")) {
				 * sc.bbsCtrl.getBbsFindList("BBS_CONTENT", selectField.getText());
				 */
				
			} else if (selectedItem.equals("작성자")) {
				sc.bbsCtrl.getBbsFindList("MEMBER_ID", selectField.getText());
			}

			this.dispose();
		}
	}
}
