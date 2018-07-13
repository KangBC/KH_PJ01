package View;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Label;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;



public class BbsListView extends JFrame implements ActionListener, MouseListener {

	private JButton logoutBtn;
	private JTable jTable;
	private JScrollPane jScrPane;
	private JButton writeBtn;
	
	private JComboBox<String> choiceList;
	
	private JTextField selectField;
	private JButton selectBtn;
	
	String columnNames[] = {
			"번호", "제목", "작성자"
	};
	
	Object rowData[][];
	
	DefaultTableModel model;	

	
	public BbsListView() {
		super();
		
		setLayout(null);
		
		JLabel loginLabel = new JLabel("게시판");
		loginLabel.setBounds(10, 10, 120, 15);
		add(loginLabel);
		
		
		model = new DefaultTableModel(columnNames, 0);
		model.setDataVector(rowData, columnNames);
		
		jTable = new JTable(model);
		jTable.addMouseListener(this);
		
		
		
		// 컬럼의 넓이 설정
		jTable.getColumnModel().getColumn(0).setMaxWidth(50);
		jTable.getColumnModel().getColumn(1).setMaxWidth(500);
		jTable.getColumnModel().getColumn(2).setMaxWidth(200);
		
		// 테이블안에 컬럼을 위치설정
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		jTable.getColumn("번호").setCellRenderer(celAlignCenter);
		jTable.getColumn("작성자").setCellRenderer(celAlignCenter);
				
		
		
		jScrPane = new JScrollPane(jTable);
		
		jScrPane.setBounds(10, 50, 600, 300);
		add(jScrPane);
		
		
		// 글쓰기 버튼
		writeBtn = new JButton("글쓰기");
		writeBtn.addActionListener(this);
		writeBtn.setBounds(10, 380, 100, 20);		
		add(writeBtn);
		
		// 검색
		selectField = new JTextField();
		selectField.setBounds(250, 380, 150, 20);
		add(selectField);
		
		selectBtn = new JButton("검색");
		selectBtn.addActionListener(this);
		selectBtn.setBounds(420, 380, 100, 20);		
		add(selectBtn);
		
		
		// Choice(AWT) -> JComboBox(swing)
		String[] selects = new String[] {"제목", "내용", "작성자"};		
		choiceList = new JComboBox<>(selects);
		choiceList.setBounds(150, 380, 80, 20);
		add(choiceList);
		
		setBackground(Color.cyan);
		setBounds(100, 100, 640, 480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BbsListView frame = new BbsListView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		if(btn == writeBtn) {
			new BbsAddView();
	 }
  }
}
