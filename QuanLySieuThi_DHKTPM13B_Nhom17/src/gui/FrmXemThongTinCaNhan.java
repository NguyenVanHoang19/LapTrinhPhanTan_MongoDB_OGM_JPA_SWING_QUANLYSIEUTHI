package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPasswordField;
import javax.swing.border.EtchedBorder;
import javax.swing.DefaultComboBoxModel;

public class FrmXemThongTinCaNhan extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaNhanVien;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtCMND;
	private JTextField txtMa;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField txtKQTK;
	private JTextField textField_16;
	private JTable table_1;
	private JTabbedPane tabbedPane ;
	public static JPanel pnlTabXemThongTinCaNhan ;
	private JTextField txtNgaySinh;
	private JTextField txtTenDangNhap;
	private JPasswordField txtMatKhau;
	private JPasswordField txtMatKhauMoi;
	public FrmXemThongTinCaNhan() {
		setSize(1042,685);
		setLocationRelativeTo(null);
		pnlTabXemThongTinCaNhan = new JPanel();
		getContentPane().add(pnlTabXemThongTinCaNhan);
		

		pnlTabXemThongTinCaNhan.setLayout(null);

		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setLayout(null);
		pnlChucNang.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"C\u00E1c ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlChucNang.setBackground(new Color(204, 204, 255));
		pnlChucNang.setBounds(10, 440, 1005, 195);
		pnlTabXemThongTinCaNhan.add(pnlChucNang);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 34, 985, 150);
		pnlChucNang.add(panel);
		panel.setLayout(null);

		/**
		 * Thoat tab quan ly nhan vien
		 */
		JButton btnThoat = new JButton("Thoát");
		
		btnThoat.setBackground(new Color(255, 0, 51));
		btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnThoat.setBounds(829, 86, 146, 40);
		btnThoat.setIcon(new ImageIcon("images\\exit.png"));
		panel.add(btnThoat);

		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCapNhat.setBounds(429, 22, 149, 40);
		btnCapNhat.setIcon(new ImageIcon("images\\update.png"));
		panel.add(btnCapNhat);

		JPanel pnlThongTinNhanVien = new JPanel();
		pnlThongTinNhanVien.setLayout(null);
		pnlThongTinNhanVien.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlThongTinNhanVien.setBackground(new Color(153, 204, 255));
		pnlThongTinNhanVien.setBounds(10, 82, 1005, 347);
		pnlTabXemThongTinCaNhan.add(pnlThongTinNhanVien);

		JPanel pnlThongTinCoBan = new JPanel();
		pnlThongTinCoBan.setLayout(null);
		pnlThongTinCoBan.setForeground(Color.BLACK);
		pnlThongTinCoBan.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Th\u00F4ng tin c\u01A1 b\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongTinCoBan.setBackground(new Color(153, 204, 255));
		pnlThongTinCoBan.setBounds(10, 27, 985, 309);
		pnlThongTinNhanVien.add(pnlThongTinCoBan);

		JLabel lblMaNhanVien = new JLabel("Mã nhân viên:");
		lblMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMaNhanVien.setBounds(62, 25, 88, 14);
		pnlThongTinCoBan.add(lblMaNhanVien);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMaNhanVien.setToolTipText("");
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(160, 24, 290, 20);
		pnlThongTinCoBan.add(txtMaNhanVien);

		JLabel lblHo = new JLabel("Tên:");
		lblHo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblHo.setBounds(541, 24, 82, 20);
		pnlThongTinCoBan.add(lblHo);

		txtHo = new JTextField();
		txtHo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHo.setToolTipText("Nhập họ");
		txtHo.setColumns(10);
		txtHo.setBounds(659, 25, 262, 20);
		pnlThongTinCoBan.add(txtHo);

		JLabel lblTen = new JLabel("Tên:");
		lblTen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTen.setBounds(541, 121, 82, 14);
		pnlThongTinCoBan.add(lblTen);

		txtTen = new JTextField();
		txtTen.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTen.setToolTipText("Nhập tên");
		txtTen.setColumns(10);
		txtTen.setBounds(659, 119, 262, 20);
		pnlThongTinCoBan.add(txtTen);

		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGioiTinh.setBounds(540, 71, 82, 14);
		pnlThongTinCoBan.add(lblGioiTinh);

		JComboBox<Object> cboGioiTinh = new JComboBox<Object>();
		cboGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		cboGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cboGioiTinh.setToolTipText("Chọn giới tính");
		cboGioiTinh.setBounds(658, 69, 56, 20);
		pnlThongTinCoBan.add(cboGioiTinh);

		JLabel lblCMND = new JLabel("CMND:");
		lblCMND.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCMND.setBounds(541, 174, 82, 14);
		pnlThongTinCoBan.add(lblCMND);

		txtCMND = new JTextField();
		txtCMND.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCMND.setToolTipText("Nhập chứng minh nhân dân");
		txtCMND.setColumns(10);
		txtCMND.setBounds(659, 168, 262, 20);
		pnlThongTinCoBan.add(txtCMND);
		
		JLabel lblNgaySinh = new JLabel("Ngày Sinh :");
		lblNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNgaySinh.setBounds(62, 70, 88, 15);
		pnlThongTinCoBan.add(lblNgaySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNgaySinh.setToolTipText("");
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(160, 67, 290, 20);
		pnlThongTinCoBan.add(txtNgaySinh);
		
		JLabel lblTenDangNhap = new JLabel("Tên đăng nhập:");
		lblTenDangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTenDangNhap.setBounds(62, 119, 95, 20);
		pnlThongTinCoBan.add(lblTenDangNhap);
		
		txtTenDangNhap = new JTextField();
		txtTenDangNhap.setToolTipText("");
		txtTenDangNhap.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTenDangNhap.setColumns(10);
		txtTenDangNhap.setBounds(160, 117, 290, 20);
		pnlThongTinCoBan.add(txtTenDangNhap);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu:");
		lblMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMatKhau.setBounds(62, 172, 82, 14);
		pnlThongTinCoBan.add(lblMatKhau);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(160, 166, 290, 20);
		pnlThongTinCoBan.add(txtMatKhau);
		
		JLabel lblMatKhauMoi = new JLabel("Mật khẩu mới:");
		lblMatKhauMoi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMatKhauMoi.setBounds(62, 222, 88, 14);
		pnlThongTinCoBan.add(lblMatKhauMoi);
		
		txtMatKhauMoi = new JPasswordField();
		txtMatKhauMoi.setBounds(160, 220, 290, 20);
		pnlThongTinCoBan.add(txtMatKhauMoi);
		
		JRadioButton radHienMatKhau = new JRadioButton("Hiện mật khẩu");
		radHienMatKhau.setBounds(160, 256, 109, 23);
		pnlThongTinCoBan.add(radHienMatKhau);

		JPanel pnlTitle = new JPanel();
		pnlTitle.setBackground(new Color(102, 153, 255));
		pnlTitle.setBounds(10, 11, 1005, 60);
		pnlTabXemThongTinCaNhan.add(pnlTitle);
		pnlTitle.setLayout(null);

		JLabel lblTitle = new JLabel("THÔNG TIN CÁ NHÂN");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblTitle.setForeground(Color.RED);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 11, 985, 38);
		pnlTitle.add(lblTitle);


	}
	public static void main(String[] args) {
		FrmXemThongTinCaNhan frmQuanLyNhanVien = new FrmXemThongTinCaNhan();
		frmQuanLyNhanVien.setVisible(true);
	}
}
