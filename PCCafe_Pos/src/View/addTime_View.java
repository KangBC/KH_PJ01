package View;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Dao.POS_Dao;
import Dto.member_Dto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;

public class addTime_View extends JFrame implements ActionListener, KeyListener, MouseListener {
	private POS_Dao dao = POS_Dao.getInstance();

	private JButton bt_Insert, bt_mainView, bt_time_1, bt_time_2, bt_time_3, bt_time_4, bt_time_5;
	private JLabel lb_cho_time, lb_cho_price;
	private JTable jTable;
	private JPanel pl_mid_3;
	private JTextField tf_showID, tf_inputID, tf_showTime;
	private JScrollPane jScrPane;
	private ArrayList<member_Dto> List;

	// Table Variable
	private String columnNames[] = { "검색된 ID" };
	private Object rowData[][];
	private DefaultTableModel model;

	public addTime_View() {
		ImageIcon icon = new ImageIcon("backGround.jpg");
		JPanel contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pl_mid = new JPanel();
		pl_mid.setBounds(49, 45, 1816, 979);
		contentPane.add(pl_mid);
		pl_mid.setLayout(null);

		pl_mid_3 = new JPanel();
		pl_mid_3.setBounds(1074, 0, 742, 979);
		pl_mid_3.setBackground(Color.BLACK);
		pl_mid.add(pl_mid_3);
		pl_mid_3.setLayout(null);

		JPanel pl_title_3 = new JPanel();
		pl_title_3.setForeground(Color.BLACK);
		pl_title_3.setBackground(Color.LIGHT_GRAY);
		pl_title_3.setBounds(0, 0, 742, 90);
		pl_mid_3.add(pl_title_3);
		pl_title_3.setLayout(null);

		JLabel lb_IDCheck = new JLabel("ID 확인");
		lb_IDCheck.setFont(new Font("굴림", Font.BOLD, 20));
		lb_IDCheck.setHorizontalAlignment(SwingConstants.CENTER);
		lb_IDCheck.setBounds(0, 0, 126, 89);
		pl_title_3.add(lb_IDCheck);

		tf_inputID = new JTextField();
		tf_inputID.setHorizontalAlignment(SwingConstants.CENTER);
		tf_inputID.setFont(new Font("굴림", Font.BOLD, 23));
		tf_inputID.setColumns(10);
		tf_inputID.setBounds(29, 741, 493, 90);
		pl_mid_3.add(tf_inputID);

		bt_mainView = new JButton("메인화면");
		bt_mainView.setFont(new Font("굴림", Font.BOLD, 18));
		bt_mainView.setBounds(400, 865, 312, 90);
		pl_mid_3.add(bt_mainView);

		jTable = new JTable();
		jScrPane = new JScrollPane();

		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel.setBounds(536, 115, 114, 45);
		pl_mid_3.add(lblNewLabel);

		JLabel lblTime = new JLabel("남은시간");
		lblTime.setForeground(Color.LIGHT_GRAY);
		lblTime.setFont(new Font("굴림", Font.BOLD, 25));
		lblTime.setBounds(536, 242, 114, 45);
		pl_mid_3.add(lblTime);

		tf_showID = new JTextField();
		tf_showID.setBounds(536, 172, 191, 58);
		tf_showID.setEditable(false);
		tf_showID.setFont(new Font("굴림", Font.BOLD, 18));
		tf_showID.setColumns(10);
		pl_mid_3.add(tf_showID);

		tf_showTime = new JTextField();
		tf_showTime.setBounds(536, 299, 191, 58);
		tf_showTime.setEditable(false);
		tf_showTime.setFont(new Font("굴림", Font.BOLD, 18));
		tf_showTime.setColumns(10);
		pl_mid_3.add(tf_showTime);

		JLabel lblId = new JLabel("ID 검색");
		lblId.setForeground(Color.LIGHT_GRAY);
		lblId.setFont(new Font("굴림", Font.BOLD, 25));
		lblId.setBounds(29, 683, 222, 45);
		pl_mid_3.add(lblId);

		JPanel pl_mid_2 = new JPanel();
		pl_mid_2.setBackground(Color.BLACK);
		pl_mid_2.setBounds(0, 489, 1073, 490);
		pl_mid.add(pl_mid_2);
		pl_mid_2.setLayout(null);

		JPanel pl_title_2 = new JPanel();
		pl_title_2.setBackground(new Color(192, 192, 192));
		pl_title_2.setBounds(0, 0, 1073, 90);
		pl_mid_2.add(pl_title_2);
		pl_title_2.setLayout(null);

		JLabel label_2 = new JLabel("선택확인");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("굴림", Font.BOLD, 20));
		label_2.setBounds(0, 0, 160, 89);
		pl_title_2.add(label_2);

		bt_Insert = new JButton("결제하기");
		bt_Insert.setBounds(726, 372, 312, 90);
		pl_mid_2.add(bt_Insert);
		bt_Insert.setFont(new Font("굴림", Font.BOLD, 18));

		JPanel panel = new JPanel();
		panel.setBounds(51, 136, 627, 326);
		pl_mid_2.add(panel);
		panel.setLayout(null);

		JLabel mid_2_lb_time = new JLabel("시간 :");
		mid_2_lb_time.setFont(new Font("굴림", Font.BOLD, 40));
		mid_2_lb_time.setHorizontalAlignment(SwingConstants.CENTER);
		mid_2_lb_time.setBounds(107, 75, 148, 63);
		panel.add(mid_2_lb_time);

		JLabel mid_2_lb_price = new JLabel("상품가격 : ");
		mid_2_lb_price.setFont(new Font("굴림", Font.BOLD, 40));
		mid_2_lb_price.setHorizontalAlignment(SwingConstants.CENTER);
		mid_2_lb_price.setBounds(27, 178, 228, 63);
		panel.add(mid_2_lb_price);

		lb_cho_time = new JLabel("0 원");
		lb_cho_time.setFont(new Font("굴림", Font.BOLD, 40));
		lb_cho_time.setHorizontalAlignment(SwingConstants.CENTER);
		lb_cho_time.setBounds(250, 75, 321, 63);
		panel.add(lb_cho_time);

		lb_cho_price = new JLabel("0 원");
		lb_cho_price.setFont(new Font("굴림", Font.BOLD, 40));
		lb_cho_price.setHorizontalAlignment(SwingConstants.CENTER);
		lb_cho_price.setBounds(269, 178, 281, 63);
		panel.add(lb_cho_price);

		JPanel pl_mid_1 = new JPanel();
		pl_mid_1.setBackground(Color.BLACK);
		pl_mid_1.setLayout(null);
		pl_mid_1.setBounds(0, 0, 1073, 490);
		pl_mid.add(pl_mid_1);

		JPanel pl_title_1 = new JPanel();
		pl_title_1.setBackground(new Color(192, 192, 192));
		pl_title_1.setLayout(null);
		pl_title_1.setBounds(0, 0, 1073, 90);
		pl_mid_1.add(pl_title_1);

		JLabel lb_struct = new JLabel("시간 & 가격");
		lb_struct.setForeground(Color.BLACK);
		lb_struct.setHorizontalAlignment(SwingConstants.CENTER);
		lb_struct.setFont(new Font("굴림", Font.BOLD, 20));
		lb_struct.setBounds(0, 0, 158, 89);
		pl_title_1.add(lb_struct);

		bt_time_1 = new JButton("1000원 1시간");
		bt_time_1.setBounds(54, 174, 171, 227);
		pl_mid_1.add(bt_time_1);

		bt_time_2 = new JButton("2000원 2시간+15분");
		bt_time_2.setBounds(250, 174, 171, 227);
		pl_mid_1.add(bt_time_2);

		bt_time_3 = new JButton("3000원 3시간+30분");
		bt_time_3.setBounds(447, 174, 171, 227);
		pl_mid_1.add(bt_time_3);

		bt_time_4 = new JButton("5000원 7시간+30분");
		bt_time_4.setBounds(643, 174, 171, 227);
		pl_mid_1.add(bt_time_4);

		bt_time_5 = new JButton("10000원 12시간");
		bt_time_5.setBounds(838, 174, 171, 227);
		pl_mid_1.add(bt_time_5);

		setBounds(0, 0, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		bt_Insert.addActionListener(this);
		bt_mainView.addActionListener(this);
		bt_time_1.addActionListener(this);
		bt_time_2.addActionListener(this);
		bt_time_3.addActionListener(this);
		bt_time_4.addActionListener(this);
		bt_time_5.addActionListener(this);

		tf_inputID.addKeyListener(this);
	}

	public void selectItem(int time, int price) {
		dao.setChoTime(time);
		dao.setChoPrice(price);
		lb_cho_time.setText(dao.getChoTime() / 60 + "시간" + dao.getChoTime() % 60 + "분");
		lb_cho_price.setText(dao.getChoPrice() + "원");
	}

	public void actionPerformed(ActionEvent e) {
		POS_Dao dao = POS_Dao.getInstance();
		Object obj = e.getSource();
		if (obj == bt_mainView) {
			dao.mainView();
			this.dispose();
		} else if (obj == bt_Insert) {
			if (dao.getChoTime() == 0 || dao.getUserDto() == null) {
				JOptionPane.showMessageDialog(null, "시간충전을 위한 필요사항을 다시 확인해 주세요");
			} else {
				dao.demandView();
				this.dispose();
			}
		} else if (obj == bt_time_1) {
			selectItem(60, 1000);
		} else if (obj == bt_time_2) {
			selectItem(135, 2000);
		} else if (obj == bt_time_3) {
			selectItem(210, 3000);
		} else if (obj == bt_time_4) {
			selectItem(450, 5000);
		} else if (obj == bt_time_5) {
			selectItem(720, 10000);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		pl_mid_3.remove(jScrPane);
		List = dao.findId(tf_inputID.getText());
		jTable = new JTable();

		if (List.size() > 0) {
			rowData = new Object[List.size()][1];
			for (int i = 0; i < List.size(); i++) {
				member_Dto dto = List.get(i);
				rowData[i][0] = dto.getId();
			}
			model = new DefaultTableModel(rowData, columnNames) {
				public boolean isCellEditable(int rowIndex, int mColIndex) {
					return false;
				}
			};
			model.setDataVector(rowData, columnNames);

			jTable.setModel(model);
			jTable.addMouseListener(this);
			jTable.setAutoCreateRowSorter(true);
			jTable.setFillsViewportHeight(true);

			jTable.setRowHeight(50);
			jTable.setBackground(Color.LIGHT_GRAY);
			jTable.setFont(new Font("굴림", Font.BOLD, 20));

			DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
			celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
			jScrPane = new JScrollPane(jTable);
			jScrPane.setBounds(29, 115, 493, 556);
			pl_mid_3.add(jScrPane);
		}
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		int rowNum = jTable.getSelectedRow();
		if (rowNum == -1) {
			return;
		}
		dao.setUserDto(List.get(rowNum));
		tf_showID.setText(List.get(rowNum).getId());
		tf_showTime.setText(List.get(rowNum).getTime() / 60 + "시간" + List.get(rowNum).getTime() % 60 + "분");
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}