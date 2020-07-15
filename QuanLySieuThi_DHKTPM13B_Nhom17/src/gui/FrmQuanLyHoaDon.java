package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.Label;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import com.toedter.components.JSpinField;
import javax.swing.SpinnerNumberModel;

public class FrmQuanLyHoaDon extends JFrame {

	public static JPanel contentPane;
	private JTextField txtTim;
	private JTextField txtMaHoaDon;
	private JTextField txtNhanVienLap;
	private JTextField txtNgayLap;
	private JTable tblHoaDon;
	private JTable tblCTHoaDon;
	private JTextField txtTongTien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmQuanLyHoaDon frame = new FrmQuanLyHoaDon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmQuanLyHoaDon() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("Hinh\\pm.png"));
		setType(Type.POPUP);
		setForeground(new Color(51, 102, 255));
		setBackground(new Color(51, 102, 255));
		setTitle("Phần mềm quản lý siêu thị");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1049, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 204, 255));
		panel_4.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin h\u00E0ng h\u00F3a", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_4.setBounds(12, 87, 515, 182);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblMaHang = new JLabel("Mã Hóa Đơn");
		lblMaHang.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMaHang.setBounds(10, 22, 88, 20);
		panel_4.add(lblMaHang);

		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMaHoaDon.setEnabled(false);
		txtMaHoaDon.setBounds(116, 16, 363, 20);
		panel_4.add(txtMaHoaDon);
		txtMaHoaDon.setColumns(10);

		JLabel lblTnNhnVin = new JLabel("Nhân viên :");
		lblTnNhnVin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTnNhnVin.setBounds(10, 76, 88, 18);
		panel_4.add(lblTnNhnVin);

		txtNhanVienLap = new JTextField();
		txtNhanVienLap.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNhanVienLap.setBounds(116, 76, 363, 20);
		panel_4.add(txtNhanVienLap);
		txtNhanVienLap.setColumns(10);

		JLabel lblTenHang = new JLabel("Ngày lập :");
		lblTenHang.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTenHang.setBounds(10, 47, 80, 18);
		panel_4.add(lblTenHang);

		txtNgayLap = new JTextField();
		txtNgayLap.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNgayLap.setBounds(116, 47, 363, 20);
		panel_4.add(txtNgayLap);
		txtNgayLap.setColumns(10);
		
		JLabel lblTngTin = new JLabel("Tổng tiền :");
		lblTngTin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTngTin.setBounds(10, 116, 88, 18);
		panel_4.add(lblTngTin);
		
		txtTongTien = new JTextField();
		txtTongTien.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(116, 116, 363, 20);
		panel_4.add(txtTongTien);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(204, 204, 255));
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "C\u00E1c ch\u1EE9c n\u0103ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_5.setBounds(12, 465, 1019, 126);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		ImageIcon iconAdd = new ImageIcon("Hinh/add.png");
		ImageIcon iconDelete = new ImageIcon("Hinh/delete.png");
		ImageIcon iconUpdate = new ImageIcon("Hinh/update.png");
		ImageIcon iconSearch = new ImageIcon("Hinh/search.png");
		ImageIcon iconSave = new ImageIcon("Hinh/save.png");
		ImageIcon iconExit = new ImageIcon("Hinh/exit.png");
		ImageIcon iconExcel = new ImageIcon("Hinh/excel.png");

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(204, 204, 255));
		panel_8.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "T\u00ECm ki\u1EBFm h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_8.setBounds(10, 16, 565, 102);
		panel_5.add(panel_8);
		panel_8.setLayout(null);

		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(381, 16, 136, 35);
		panel_8.add(btnTimKiem);
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnTimKiem.setIcon(iconSearch);

		JLabel lblNhpThngTin = new JLabel("Nhập thông tin tìm kiếm:");
		lblNhpThngTin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNhpThngTin.setBounds(20, 21, 162, 30);
		panel_8.add(lblNhpThngTin);

		txtTim = new JTextField();
		txtTim.setBounds(184, 27, 168, 23);
		panel_8.add(txtTim);
		txtTim.setColumns(10);

		JLabel lblTmTheo = new JLabel("Tìm theo:");
		lblTmTheo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTmTheo.setBounds(20, 61, 63, 30);
		panel_8.add(lblTmTheo);

		JRadioButton radMaHoaDon = new JRadioButton("Mã \r\n");
		radMaHoaDon.setSelected(true);
		radMaHoaDon.setBounds(158, 68, 78, 23);
		panel_8.add(radMaHoaDon);

		JRadioButton radNgayLap = new JRadioButton("Ngày lập");
		radNgayLap.setBounds(251, 68, 78, 23);
		panel_8.add(radNgayLap);
		
		JRadioButton radNhanVien = new JRadioButton("Nhân viên");
		radNhanVien.setBounds(335, 68, 78, 23);
		panel_8.add(radNhanVien);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ImageIcon iconThoat = new ImageIcon("Hinh/exit.png");
		btnThoat.setIcon(iconThoat);
//		btnThot.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnThoat.setBounds(825, 78, 136, 40);
		panel_5.add(btnThoat);
		
		JButton btnThem = new JButton("Thêm CT hóa đơn");
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThem.setBackground(new Color(32, 178, 170));
		btnThem.setBounds(595, 11, 147, 23);
		panel_5.add(btnThem);
		
		JButton button = new JButton("Xóa ");
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBackground(new Color(32, 178, 170));
		button.setBounds(752, 12, 105, 23);
		panel_5.add(button);
		
		JButton button_1 = new JButton("Lưu ");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBackground(new Color(32, 178, 170));
		button_1.setBounds(867, 12, 94, 23);
		panel_5.add(button_1);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(0, 0, 1041, 76);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTieuDe = new JLabel("Quản Lý Hóa Đơn\r\n");
		lblTieuDe.setForeground(Color.RED);
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTieuDe.setBounds(10, 11, 1010, 56);
		panel.add(lblTieuDe);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.BLACK);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Danh s\u00E1ch h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBounds(10, 273, 1021, 182);
		contentPane.add(panel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 15, 1001, 168);
		panel_1.add(scrollPane);

		tblHoaDon = new JTable();
		tblHoaDon.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã hóa đơn", "Ngày lập", "Nhân viên","Giảm giá","Tổng tiền" }));
		scrollPane.setViewportView(tblHoaDon);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 255));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin nh\u00E0 cung c\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_2.setBounds(537, 87, 494, 182);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 22, 474, 149);
		panel_2.add(scrollPane_1);
		
		tblCTHoaDon = new JTable();
		tblCTHoaDon.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tên Hàng", "Đơn Giá", "Số Lượng","Thành Tiền"
			}
		));
		scrollPane_1.setViewportView(tblCTHoaDon);
	}
}
