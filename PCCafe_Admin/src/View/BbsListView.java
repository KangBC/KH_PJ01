package View;

import java.awt.Color;
<<<<<<< HEAD
import java.awt.EventQueue;
=======
import java.awt.Dimension;
import java.awt.Font;
>>>>>>> KH_MiniProject/hyunwoo
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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Dto.BbsDto;
import Singleton.Singleton;

public class BbsListView extends JFrame implements ActionListener, MouseListener {
	private JPanel contentPane;
	private JTable jTable;
	private JScrollPane jScrPane;
	private JButton logoutBtn;
	private JButton writeBtn;
	private JButton selectBtn;
	private JComboBox<String> choiceList;
	private JTextField selectField;
	private JButton btnNewButton;
<<<<<<< HEAD

	String columnNames[] = { "번호", "제목", "내용", "작성자", "조회수" };
=======

	Singleton sc = Singleton.getInstance();

	String columnNames[] = { "번호", "제목", "작성자", "조회수", "날짜" };
>>>>>>> KH_MiniProject/hyunwoo

	Object rowData[][];

	DefaultTableModel model;

	List<BbsDto> list;

	public BbsListView(List<BbsDto> list) {
		
		super("게시판");

		this.list = list;

		this.setLayout(null);

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
		
		int len = list != null ? list.size() : 0;
		int n = 1;
<<<<<<< HEAD
		
		rowData = new Object[len][3];
				
		for(int i = 0;i < len; i++){
			BbsDto dto = list.get(i);			
			rowData[i][0] = n;
			if(dto.getDel() == 1) {
				rowData[i][1] = "************************이 글은 삭제되었습니다************************";
			}else {
				rowData[i][1] = dto.getTitle();
			}
			rowData[i][2] = dto.getUserNum();
=======

		rowData = new Object[len][5];

		for (int i = 0; i < len; i++) {
			BbsDto dto = list.get(i);
			rowData[i][0] = n;
			rowData[i][1] = dto.getTitle();
			rowData[i][2] = dto.getDel(); //  user_id 작성자로 바꿔야함
			rowData[i][3] = dto.getReadCount();
			rowData[i][4] = dto.getCreatedDate();
>>>>>>> KH_MiniProject/hyunwoo
			n++;

		}

		model = new DefaultTableModel(columnNames, 0);

		model.setDataVector(rowData, columnNames);

<<<<<<< HEAD
		jTable = new JTable(model);
=======
		jTable = new JTable(model) {
			// 테이블 text 수정방지
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		jTable.setPreferredScrollableViewportSize(new Dimension(400, 200));

>>>>>>> KH_MiniProject/hyunwoo
		jTable.addMouseListener(this);
		jTable.setFont(new Font(null, 0, 18)); // 글씨크기

<<<<<<< HEAD
		jTable.getColumnModel().getColumn(0).setMaxWidth(700);
		jTable.getColumnModel().getColumn(1).setMaxWidth(700);
		jTable.getColumnModel().getColumn(2).setMaxWidth(700);
		jTable.getColumnModel().getColumn(3).setMaxWidth(700);
		jTable.getColumnModel().getColumn(4).setMaxWidth(700);
=======
		jTable.getColumnModel().getColumn(0).setMaxWidth(100);
		jTable.getColumnModel().getColumn(1).setMaxWidth(3000);
		jTable.getColumnModel().getColumn(2).setMaxWidth(200);
		jTable.getColumnModel().getColumn(3).setMaxWidth(100);
		jTable.getColumnModel().getColumn(4).setMaxWidth(1000);
>>>>>>> KH_MiniProject/hyunwoo

		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);

		// List 내용 가운데 정렬
		jTable.getColumn("번호").setCellRenderer(celAlignCenter);
		jTable.getColumn("제목").setCellRenderer(celAlignCenter);
		jTable.getColumn("작성자").setCellRenderer(celAlignCenter);
		jTable.getColumn("조회수").setCellRenderer(celAlignCenter);
		jTable.getColumn("날짜").setCellRenderer(celAlignCenter);

		// List 전체틀
		jScrPane = new JScrollPane(jTable);
		jScrPane.setBounds(0, 40, 1500, 400);
		getContentPane().add(jScrPane);

		// 글쓰기
		writeBtn = new JButton("글쓰기");
<<<<<<< HEAD
		writeBtn.setBounds(10, 747, 290, 99);
		writeBtn.addActionListener(this);
=======
		writeBtn.setBounds(10, 500, 150, 100);
		writeBtn.setFont(new Font("굴림", Font.PLAIN, 30));
>>>>>>> KH_MiniProject/hyunwoo
		getContentPane().add(writeBtn);
		writeBtn.addActionListener(this);

		selectField = new JTextField();
		selectField.setBounds(482, 500, 800, 99);
		getContentPane().add(selectField);

		// 검색
		selectBtn = new JButton("검색");
		selectBtn.setBounds(1299, 500, 150, 101);
		selectBtn.setFont(new Font("굴림", Font.PLAIN, 30));
		selectBtn.addActionListener(this);
		getContentPane().add(selectBtn);
		getContentPane().setBackground(Color.GRAY);

		btnNewButton = new JButton("확인");
		btnNewButton.setBounds(1606, 901, 290, 100);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);

		// Choice(AWT) -> JComboBox(swing)
<<<<<<< HEAD
		String[] selects = new String[] { "번호", "제목", "내용", "작성자" };
=======
		String[] selects = new String[] { "제목", "작성자" };
>>>>>>> KH_MiniProject/hyunwoo
		choiceList = new JComboBox<>(selects);
		choiceList.setBounds(180, 500, 290, 100);
		choiceList.setFont(new Font("굴림", Font.PLAIN, 30));
		add(choiceList);

		setVisible(true);
		setBounds(100, 100, 1500, 700);
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
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	// 확인버튼
	public void actionPerformed(ActionEvent e) {
		Singleton sc = Singleton.getInstance();
		Object obj = e.getSource();
<<<<<<< HEAD
		
		//검색
		if (obj == selectBtn) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					String selectedItem = (String)choiceList.getSelectedItem();
				
					sc.bbsCtrl.getBbsFindList(selectField.getText(), selectedItem);			
			
				}
			});

			// 글쓰기
		} else if (obj == writeBtn) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					BbsAddView frame = new BbsAddView();
					frame.setVisible(true);
				}
			});
=======

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
>>>>>>> KH_MiniProject/hyunwoo
		}
		

		this.dispose();
	}
}
