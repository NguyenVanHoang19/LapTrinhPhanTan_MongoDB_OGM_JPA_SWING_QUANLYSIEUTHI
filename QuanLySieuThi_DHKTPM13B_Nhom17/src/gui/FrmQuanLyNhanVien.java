package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout.Group;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Entities.NhanVien;
import Entities.TaiKhoan;
import interface_rmi.HangHoaDAO;
import interface_rmi.NhanVienDAO;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;

public class FrmQuanLyNhanVien extends JFrame implements ActionListener,MouseListener {

	private JPanel contentPane;
	private JTextField txtTimKiem;
	private JTextField txtMaNhanVien;
	private JTextField txtTen;
	private JTextField txtSoDienThoai;
	private JTextField txtDiaChi;
	private JTextField txtCMND;
	private JTable table;
	private JTextField txtMa;
	private JTable table_1;
	private JTabbedPane tabbedPane ;
	public static JPanel pnlTabQLNV ;
	private JTextField txtNgaySinh;
	private JButton btnThem ;
	private JComboBox cboGioiTinh;
	private DefaultComboBoxModel cboGioiTinhMode = new DefaultComboBoxModel();
	private DefaultTableModel tableModel = new DefaultTableModel();
	private NhanVienDAO nhanVienDAO =null;
	private SecurityManager securityManager ;
	private JTextField txtTaiKhoan;
	private JComboBox cboLoaiNhanVien;
	private JPasswordField txtMatKhau;
	private JPasswordField txtXacNhanMatKhau;
	private JRadioButton radChungMinh;
	private JRadioButton radSoDT;
	private JRadioButton radTen;
	private JRadioButton radMa;
	private JButton btnTimKiem ;
	private JLabel lblThongBao;
	private JButton btnXoa;
	private JButton btnCapNhat;
	private JRadioButton radXemMatKhau;
	private JButton btnLamMoi;
	private JRadioButton radNhanVienNghi;
	private JButton btnLuu;
	public FrmQuanLyNhanVien() {

		try {
			this.securityManager  = System.getSecurityManager();
			if (securityManager == null) {
				System.setProperty("java.security.policy", "mypolicy\\policy.policy");
				System.setSecurityManager(new SecurityManager());
			}
			this.nhanVienDAO =  (NhanVienDAO) Naming.lookup("rmi://localhost:1099/xyLyNhanVien");
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setSize(1091,701);
		setLocationRelativeTo(null);
		pnlTabQLNV = new JPanel();
		getContentPane().add(pnlTabQLNV);


		pnlTabQLNV.setLayout(null);

		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setLayout(null);
		pnlChucNang.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"C\u00E1c ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlChucNang.setBackground(new Color(204, 204, 255));
		pnlChucNang.setBounds(10, 440, 1055, 211);
		pnlTabQLNV.add(pnlChucNang);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(new Color(204, 204, 255));
		panel_3.setBounds(10, 39, 451, 149);
		pnlChucNang.add(panel_3);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setHorizontalAlignment(SwingConstants.LEFT);
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnTimKiem.setBounds(291, 58, 133, 40);
		btnTimKiem.setIcon(new ImageIcon("Hinh\\search.png"));
		panel_3.add(btnTimKiem);

		JLabel label = new JLabel("Nhập thông tin tìm kiếm:");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label.setBounds(20, 11, 161, 30);
		panel_3.add(label);

		txtTimKiem = new JTextField();
		txtTimKiem.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(192, 16, 232, 23);
		panel_3.add(txtTimKiem);

		JLabel label_1 = new JLabel("Tìm theo:");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_1.setBounds(20, 63, 63, 30);
		panel_3.add(label_1);

		radMa = new JRadioButton("Mã");
		radMa.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		radMa.setBounds(94, 48, 63, 23);
		panel_3.add(radMa);

		radTen = new JRadioButton("Tên");
		radTen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		radTen.setBounds(94, 80, 63, 23);
		panel_3.add(radTen);

		radSoDT = new JRadioButton("Số ĐT");
		radSoDT.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		radSoDT.setBounds(175, 48, 106, 23);
		panel_3.add(radSoDT);

		radChungMinh = new JRadioButton("Chứng minh");
		radChungMinh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		radChungMinh.setBounds(175, 80, 106, 23);
		panel_3.add(radChungMinh);

		radNhanVienNghi = new JRadioButton("Nhân viên nghỉ việc");
		radNhanVienNghi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		radNhanVienNghi.setBounds(94, 107, 187, 23);
		panel_3.add(radNhanVienNghi);
		ButtonGroup group = new ButtonGroup();
		group.add(radMa);
		group.add(radTen);
		group.add(radSoDT);
		group.add(radChungMinh);
		group.add(radNhanVienNghi);

		lblThongBao = new JLabel("");
		lblThongBao.setForeground(Color.BLUE);
		lblThongBao.setBounds(191, 0, 232, 14);
		panel_3.add(lblThongBao);
		
		

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(503, 51, 492, 137);
		pnlChucNang.add(panel);
		panel.setLayout(null);



		btnThem = new JButton("Thêm");
		btnThem.setBackground(Color.GREEN);
		btnThem.setHorizontalAlignment(SwingConstants.LEFT);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnThem.setIcon(new ImageIcon("Hinh\\add.png"));
		btnThem.setBounds(10, 22, 136, 40);

		panel.add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setBackground(Color.GREEN);
		btnXoa.setHorizontalAlignment(SwingConstants.LEFT);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnXoa.setIcon(new ImageIcon("Hinh\\delete.png"));
		btnXoa.setBounds(156, 22, 136, 40);
		panel.add(btnXoa);

		/**
		 * Thoat tab quan ly nhan vien
		 */
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmQuanLy.tabbedPane.remove(pnlTabQLNV);
			}
		});
		btnThoat.setHorizontalAlignment(SwingConstants.LEFT);

		btnThoat.setBackground(new Color(255, 0, 51));
		btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnThoat.setBounds(302, 73, 146, 40);
		btnThoat.setIcon(new ImageIcon("Hinh\\close.png"));
		panel.add(btnThoat);

		btnLuu = new JButton("Lưu");
		btnLuu.setBackground(Color.GREEN);
		btnLuu.setHorizontalAlignment(SwingConstants.LEFT);
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnLuu.setBounds(156, 73, 136, 40);
		btnLuu.setIcon(new ImageIcon("Hinh\\iconSave.png"));
		panel.add(btnLuu);

		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBackground(Color.GREEN);
		btnCapNhat.setHorizontalAlignment(SwingConstants.LEFT);
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCapNhat.setBounds(302, 22, 149, 40);
		btnCapNhat.setIcon(new ImageIcon("Hinh\\sua.png"));
		panel.add(btnCapNhat);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBackground(Color.GREEN);
		btnLamMoi.setForeground(Color.BLACK);
		btnLamMoi.setIcon(new ImageIcon("Hinh\\Refresh-icon.png"));
		btnLamMoi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnLamMoi.setBounds(10, 73, 136, 40);
		panel.add(btnLamMoi);

		JPanel pnlDanhSachNhanVien = new JPanel();
		pnlDanhSachNhanVien.setLayout(null);
		pnlDanhSachNhanVien.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Danh s\u00E1ch nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDanhSachNhanVien.setBackground(new Color(204, 204, 255));
		pnlDanhSachNhanVien.setBounds(10, 233, 1055, 196);
		pnlTabQLNV.add(pnlDanhSachNhanVien);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 17, 1035, 168);
		pnlDanhSachNhanVien.add(scrollPane);


		String[] tb = new String[] {"Mã NV", "Tên", "Ngày Sinh", "Giới tính", "CMND", "Số ĐT", "Địa chỉ","Loại NV","Trạng Thái"};
		tableModel = new DefaultTableModel(tb, 0);
		table = new JTable(tableModel);
		//		((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.RIGHT);

		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		scrollPane.setViewportView(table);

		JPanel pnlThongTinNhanVien = new JPanel();
		pnlThongTinNhanVien.setLayout(null);
		pnlThongTinNhanVien.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlThongTinNhanVien.setBackground(new Color(153, 204, 255));
		pnlThongTinNhanVien.setBounds(10, 82, 1055, 150);
		pnlTabQLNV.add(pnlThongTinNhanVien);

		JPanel pnlThongTinCoBan = new JPanel();
		pnlThongTinCoBan.setLayout(null);
		pnlThongTinCoBan.setForeground(Color.BLACK);
		pnlThongTinCoBan.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Th\u00F4ng tin c\u01A1 b\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongTinCoBan.setBackground(new Color(153, 204, 255));
		pnlThongTinCoBan.setBounds(10, 22, 585, 120);
		pnlThongTinNhanVien.add(pnlThongTinCoBan);

		JLabel lblMaNhanVien = new JLabel("Mã nhân viên:");
		lblMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMaNhanVien.setBounds(10, 24, 96, 14);
		pnlThongTinCoBan.add(lblMaNhanVien);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMaNhanVien.setToolTipText("");
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(94, 22, 117, 20);
		pnlThongTinCoBan.add(txtMaNhanVien);

		JLabel lblTen = new JLabel("Tên:");
		lblTen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTen.setBounds(245, 24, 26, 14);
		pnlThongTinCoBan.add(lblTen);

		txtTen = new JTextField();
		txtTen.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTen.setToolTipText("Nhập tên");
		txtTen.setColumns(10);
		txtTen.setBounds(270, 22, 154, 20);
		pnlThongTinCoBan.add(txtTen);

		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGioiTinh.setBounds(247, 68, 62, 14);
		pnlThongTinCoBan.add(lblGioiTinh);

		cboGioiTinh = new JComboBox<Object>();
		cboGioiTinh.setToolTipText("Chọn giới tính");
		cboGioiTinh.setBounds(310, 66, 52, 20);
		pnlThongTinCoBan.add(cboGioiTinh);

		JLabel lblCMND = new JLabel("CMND:");
		lblCMND.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCMND.setBounds(372, 68, 52, 14);
		pnlThongTinCoBan.add(lblCMND);

		txtCMND = new JTextField();
		txtCMND.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCMND.setToolTipText("Nhập chứng minh nhân dân");
		txtCMND.setColumns(10);
		txtCMND.setBounds(420, 62, 140, 20);
		pnlThongTinCoBan.add(txtCMND);

		JLabel lblNgaySinh = new JLabel("Ngày Sinh :");
		lblNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNgaySinh.setBounds(10, 69, 86, 17);
		pnlThongTinCoBan.add(lblNgaySinh);

		txtNgaySinh = new JTextField();
		txtNgaySinh.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNgaySinh.setToolTipText("");
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(94, 66, 117, 20);
		pnlThongTinCoBan.add(txtNgaySinh);

		JPanel pnlThongTinLienLac = new JPanel();
		pnlThongTinLienLac.setLayout(null);
		pnlThongTinLienLac.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Th\u00F4ng tin li\u00EAn l\u1EA1c", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongTinLienLac.setBackground(new Color(153, 204, 255));
		pnlThongTinLienLac.setBounds(596, 27, 449, 120);
		pnlThongTinNhanVien.add(pnlThongTinLienLac);

		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDiaChi.setBounds(10, 21, 58, 17);
		pnlThongTinLienLac.add(lblDiaChi);

		JLabel lblSoDienThoai = new JLabel("Số ĐT:");
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSoDienThoai.setBounds(233, 19, 52, 20);
		pnlThongTinLienLac.add(lblSoDienThoai);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSoDienThoai.setToolTipText("Nhập số điện thoại");
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(295, 20, 92, 20);
		pnlThongTinLienLac.add(txtSoDienThoai);

		txtDiaChi = new JTextField();
		txtDiaChi.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDiaChi.setToolTipText("Nhập địa chỉ");
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(77, 20, 149, 20);
		pnlThongTinLienLac.add(txtDiaChi);

		JLabel lblTaiKhoan = new JLabel("Tài khoản:");
		lblTaiKhoan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTaiKhoan.setBounds(10, 49, 69, 17);
		pnlThongTinLienLac.add(lblTaiKhoan);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setToolTipText("Nhập địa chỉ");
		txtTaiKhoan.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTaiKhoan.setColumns(10);
		txtTaiKhoan.setBounds(77, 51, 149, 20);
		pnlThongTinLienLac.add(txtTaiKhoan);

		JLabel label_2 = new JLabel("M.Khẩu :");
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_2.setBounds(10, 77, 69, 20);
		pnlThongTinLienLac.add(label_2);

		JLabel lblXacNhanMatKhau = new JLabel("Xác nhận mật khẩu:");
		lblXacNhanMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblXacNhanMatKhau.setBounds(247, 50, 140, 20);
		pnlThongTinLienLac.add(lblXacNhanMatKhau);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(77, 78, 149, 19);
		pnlThongTinLienLac.add(txtMatKhau);

		txtXacNhanMatKhau = new JPasswordField();
		txtXacNhanMatKhau.setBounds(247, 78, 149, 19);
		pnlThongTinLienLac.add(txtXacNhanMatKhau);

		radXemMatKhau = new JRadioButton("Xem mật khẩu");
		radXemMatKhau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(radXemMatKhau.isSelected()) {
					txtMatKhau.setEchoChar((char)0);
					txtXacNhanMatKhau.setEchoChar((char)0);
				}
				else if(radXemMatKhau.isSelected()==false) {
					txtMatKhau.setEchoChar('*');
					txtXacNhanMatKhau.setEchoChar('*');
				}
			}
		});
		radXemMatKhau.setBounds(78, 101, 109, 15);
		pnlThongTinLienLac.add(radXemMatKhau);

		JPanel pnlTitle = new JPanel();
		pnlTitle.setBackground(new Color(102, 153, 255));
		pnlTitle.setBounds(10, 11, 1055, 60);
		pnlTabQLNV.add(pnlTitle);
		pnlTitle.setLayout(null);

		JLabel lblTitle = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblTitle.setForeground(Color.RED);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 11, 985, 38);
		pnlTitle.add(lblTitle);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(7).setPreferredWidth(5);
		btnThem.addActionListener(this);
		cboGioiTinhMode.addElement("Nam");
		cboGioiTinhMode.addElement("Nữ");
		cboGioiTinh.setModel(cboGioiTinhMode);

		JLabel lblLoaiNhanVien = new JLabel("Loại NV:");
		lblLoaiNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblLoaiNhanVien.setBounds(462, 25, 56, 14);
		pnlThongTinCoBan.add(lblLoaiNhanVien);

		cboLoaiNhanVien = new JComboBox();
		cboLoaiNhanVien.setModel(new DefaultComboBoxModel(new String[] {"NV", "QL"}));
		cboLoaiNhanVien.setToolTipText("Chọn Loại Nhân Viên");
		cboLoaiNhanVien.setBounds(523, 21, 52, 20);
		pnlThongTinCoBan.add(cboLoaiNhanVien);

		JButton btnXoaTxtTen = new JButton("");
		btnXoaTxtTen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTen.setText("");
			}
		});
		btnXoaTxtTen.setIcon(new ImageIcon("Hinh\\iconDelete.png"));
		btnXoaTxtTen.setBounds(428, 23, 18, 18);
		pnlThongTinCoBan.add(btnXoaTxtTen);

		JButton btnXoaTxtNgaySinh = new JButton("");
		btnXoaTxtNgaySinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNgaySinh.setText("");
			}
		});
		btnXoaTxtNgaySinh.setIcon(new ImageIcon("Hinh\\iconDelete.png"));
		btnXoaTxtNgaySinh.setBounds(213, 68, 18, 18);
		pnlThongTinCoBan.add(btnXoaTxtNgaySinh);

		JButton btnXoaTxtCMND = new JButton("");
		btnXoaTxtCMND.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCMND.setText("");
			}
		});
		btnXoaTxtCMND.setIcon(new ImageIcon("Hinh\\iconDelete.png"));
		btnXoaTxtCMND.setBounds(562, 63, 18, 18);
		pnlThongTinCoBan.add(btnXoaTxtCMND);
		table.addMouseListener(this);
		radMa.addActionListener(this);
		radTen.addActionListener(this);
		radChungMinh.addActionListener(this);
		radSoDT.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnXoa.addActionListener(this);
		btnCapNhat.addActionListener(this);
		radNhanVienNghi.addActionListener(this);
		btnLuu.addActionListener(this);
		updateTableNhanVien();
	}
	public void updateTableNhanVien() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			for(NhanVien nhanVien : nhanVienDAO.getDsNhanVien()) {
					tableModel.addRow(new Object[] {
							nhanVien.getId(),nhanVien.getTenNhanVien(),nhanVien.getNgaySinh().format(formatter),nhanVien.getGioiTinh(),nhanVien.getSoCMND(),nhanVien.getSoDienThoai(),nhanVien.getDiaChi(),nhanVien.getLoaiNV(),nhanVien.getTrangThai()
					});
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public static void main(String[] args) {
		FrmQuanLyNhanVien frmQuanLyNhanVien = new FrmQuanLyNhanVien();
		frmQuanLyNhanVien.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		if(row != -1) {
			txtMaNhanVien.setText(tableModel.getValueAt(row, 0).toString());
			txtTen.setText(tableModel.getValueAt(row, 1).toString());
			txtNgaySinh.setText(tableModel.getValueAt(row, 2).toString());
			cboGioiTinh.setSelectedItem(tableModel.getValueAt(row, 3).toString());
			txtCMND.setText(tableModel.getValueAt(row, 4).toString());
			txtSoDienThoai.setText(tableModel.getValueAt(row, 5).toString());
			txtDiaChi.setText(tableModel.getValueAt(row, 6).toString());
			cboLoaiNhanVien.setSelectedItem(tableModel.getValueAt(row, 7).toString());
			try {
				TaiKhoan taiKhoan =nhanVienDAO.getTaiKhoanById(Integer.parseInt(tableModel.getValueAt(row, 0).toString()));
				txtTaiKhoan.setText(taiKhoan.getTenTaiKhoan());
				txtMatKhau.setText(taiKhoan.getMatKhau());
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
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
	public boolean kiemTraDuLieu() {
		if(txtTen.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Tên không được để trống!");
			txtTen.requestFocus();
			return false;
		}
		else if(txtMaNhanVien.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Mã không được để trống!");
			txtMaNhanVien.requestFocus();
			return false;
		}
		else if(txtNgaySinh.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Ngày sinh không được để trống!");
			txtNgaySinh.requestFocus();
			return false;
		}
		else if(txtNgaySinh.getText().matches("^[0-9][0-9]/[0-9][0-9]/[0-9]{4}$")==false) {
			JOptionPane.showMessageDialog(this, "Ngày sinh định dạng dd//MM/yyyy ");
			txtNgaySinh.requestFocus();
			return false;
		}
		else if(txtCMND.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Chứng minh nhân dân không được để trống!");
			txtCMND.requestFocus();
			return false;
		}
		else if(txtDiaChi.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống!");
			txtDiaChi.requestFocus();
			return false;
		}
		else if(txtSoDienThoai.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống!");
			txtSoDienThoai.requestFocus();
			return false;
		}
		else if(txtTaiKhoan.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Tài khoản không được để trống!");
			txtTaiKhoan.requestFocus();
			return false;
		}
		else if(txtMatKhau.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống!");
			txtMatKhau.requestFocus();
			return false;
		}
		return true;
	}
	public void xoaHetDuLieuTrenTableModel() {
		tableModel.addRow(new Object[] {
				
		});
		tableModel = (DefaultTableModel) table.getModel();
		tableModel.getDataVector().removeAllElements();
		
	}
	public void xoaTrangTxt() {
		txtMaNhanVien.setText("");
		txtTen.setText("");
		txtNgaySinh.setText("");
		txtCMND.setText("");
		txtDiaChi.setText("");
		txtSoDienThoai.setText("");
		txtTaiKhoan.setText("");
		txtMatKhau.setText("");
		txtXacNhanMatKhau.setText("");
		txtXacNhanMatKhau.setEditable(true);
	}
	public void themNhanVien() {
		String matKhau = txtMatKhau.getText();
		String xacNhanMatKhau = txtXacNhanMatKhau.getText();
		int maNV = 0;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			maNV = nhanVienDAO.getIdNhanVienMax()+1;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(kiemTraDuLieu()) {
			if(matKhau.equalsIgnoreCase(xacNhanMatKhau)) {
				NhanVien nhanVien = new NhanVien(maNV,txtTen.getText(),LocalDate.parse(txtNgaySinh.getText(), formatter), cboGioiTinh.getSelectedItem().toString(), txtCMND.getText(), txtSoDienThoai.getText(),cboLoaiNhanVien.getSelectedItem().toString(), txtDiaChi.getText(),"Đang Làm",new TaiKhoan(txtTaiKhoan.getText(), txtMatKhau.getText()));
				try {
					nhanVienDAO.addNhanVien(nhanVien);
					JOptionPane.showMessageDialog(this,"Thêm thành công!");
					tableModel.addRow(new Object[] {
							nhanVien.getId(),nhanVien.getTenNhanVien(),nhanVien.getNgaySinh().format(formatter),nhanVien.getGioiTinh(),nhanVien.getSoCMND(),nhanVien.getSoDienThoai(),nhanVien.getDiaChi(),nhanVien.getLoaiNV(),nhanVien.getTrangThai()
					});
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(this, "Thêm thất bại!");
				}catch (EntityExistsException e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(this, "Trung ma");
				}
			}
			else 
				JOptionPane.showMessageDialog(this, "Xác nhận mật khẩu tài khoản không khớp");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		if(obj.equals(btnThem)) {
			xoaTrangTxt();
			txtMaNhanVien.setEditable(false);
			try {
				txtMaNhanVien.setText(nhanVienDAO.getIdNhanVienMax()+1+"");
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			xoaHetDuLieuTrenTableModel();
		}
		else if(obj.equals(btnTimKiem)) {
			if(radMa.isSelected()) {
				if(txtTimKiem.getText().equalsIgnoreCase("")) {
					lblThongBao.setText("Nhập vào mã nhân viên!");
					JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm!");
					txtTimKiem.requestFocus();
				}
				else {
					try {
						NhanVien nhanVien = nhanVienDAO.getNhanVienById(Integer.parseInt(txtTimKiem.getText()));
						xoaHetDuLieuTrenTableModel();
						tableModel.addRow(new Object[] {
								nhanVien.getId(),nhanVien.getTenNhanVien(),nhanVien.getNgaySinh(),nhanVien.getGioiTinh(),nhanVien.getSoCMND(),nhanVien.getSoDienThoai(),nhanVien.getDiaChi(),nhanVien.getLoaiNV(),nhanVien.getTrangThai()
						});
						table.setSelectionMode(0);
						lblThongBao.setText("");
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}catch (NullPointerException e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(this, "Không tìm thấy mã nhân viên nào phù hợp!");
					}catch (NumberFormatException e3) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(this,"Vui lòng nhập mã là số!");
						txtTimKiem.requestFocus();
					}
				}
			}
			else if(radTen.isSelected()) {
				if(txtTimKiem.getText().equalsIgnoreCase("")) {
					lblThongBao.setText("Nhập vào tên nhân viên!");
					JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm!");
					txtTimKiem.requestFocus();
				}
				else {
					try {
						List<NhanVien> nhanViens = nhanVienDAO.getDsNhanVienByTen(txtTimKiem.getText());
						if(nhanViens.isEmpty()==false) {
							xoaHetDuLieuTrenTableModel();
							for(NhanVien nhanVien : nhanVienDAO.getDsNhanVienByTen(txtTimKiem.getText())) {
								tableModel.addRow(new Object[] {
										nhanVien.getId(),nhanVien.getTenNhanVien(),nhanVien.getNgaySinh(),nhanVien.getGioiTinh(),nhanVien.getSoCMND(),nhanVien.getSoDienThoai(),nhanVien.getDiaChi(),nhanVien.getLoaiNV(),nhanVien.getTrangThai()
								});
							}
							lblThongBao.setText("");
						}
						else
							JOptionPane.showMessageDialog(this, "Không tìm thấy tên nhân viên nào phù hợp!");
					}catch (RemoteException e3) {
						// TODO: handle exception
					}catch (NullPointerException e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(this, "Không tìm thấy tên nhân viên nào phù hợp!");
					}
				}
			}
			else if(radSoDT.isSelected()) {
				if(txtTimKiem.getText().equalsIgnoreCase("")) {
					lblThongBao.setText("Nhập vào số điện thoại!");
					JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm!");
					txtTimKiem.requestFocus();
				}
				else {
					try {
						List<NhanVien> nhanViens = nhanVienDAO.getNhanVienBySDT(txtTimKiem.getText());
						if(nhanViens.isEmpty()==false) {
							xoaHetDuLieuTrenTableModel();
							for(NhanVien nhanVien : nhanVienDAO.getNhanVienBySDT(txtTimKiem.getText())) {
								tableModel.addRow(new Object[] {
										nhanVien.getId(),nhanVien.getTenNhanVien(),nhanVien.getNgaySinh(),nhanVien.getGioiTinh(),nhanVien.getSoCMND(),nhanVien.getSoDienThoai(),nhanVien.getDiaChi(),nhanVien.getLoaiNV(),nhanVien.getTrangThai()
								});
							}
							
						}
						else 
							JOptionPane.showMessageDialog(this, "Không tìm thấy số điện thoại nào phù hợp!");
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}catch (NullPointerException e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(this, "Không tìm thấy số điện thoại nào phù hợp!");
					}
				}
			}
			else if(radChungMinh.isSelected()) {
				if(txtTimKiem.getText().equalsIgnoreCase("")) {
					lblThongBao.setText("Nhập vào số chứng minh!");
					JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm!");
					txtTimKiem.requestFocus();
				}
				else {
					try {
						List<NhanVien> nhanViens = nhanVienDAO.getNhanVienByCMND(txtTimKiem.getText());
						if(nhanViens.isEmpty()==false) {
							xoaHetDuLieuTrenTableModel();
							for(NhanVien nhanVien : nhanVienDAO.getNhanVienByCMND(txtTimKiem.getText())) {
								tableModel.addRow(new Object[] {
										nhanVien.getId(),nhanVien.getTenNhanVien(),nhanVien.getNgaySinh(),nhanVien.getGioiTinh(),nhanVien.getSoCMND(),nhanVien.getSoDienThoai(),nhanVien.getDiaChi(),nhanVien.getLoaiNV(),nhanVien.getTrangThai()
								});
							}
						}
						else 
							JOptionPane.showMessageDialog(this,"Không tìm thấy số chứng minh nào phù hợp!" );
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}catch (NullPointerException e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(this, "Không tìm thấy số chứng minh nào phù hợp!");
					}
				}
			}
			else if(radNhanVienNghi.isSelected()) {
				//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				xoaHetDuLieuTrenTableModel();
				try {
					for(NhanVien nhanVien : nhanVienDAO.getDsNhanVien()) {
						if(nhanVien.getTrangThai().equalsIgnoreCase("N")) {
							tableModel.addRow(new Object[] {
									nhanVien.getId(),nhanVien.getTenNhanVien(),nhanVien.getNgaySinh().format(formatter),nhanVien.getGioiTinh(),nhanVien.getSoCMND(),nhanVien.getSoDienThoai(),nhanVien.getDiaChi(),nhanVien.getLoaiNV(),nhanVien.getTrangThai()
							});
						}
					}
				} catch (RemoteException e6) {
					// TODO Auto-generated catch block
					e6.printStackTrace();

				}
			}
		}
		else if(obj.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if(row != -1) {
				Object o = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa?");
				if(o.equals(0)) {
					int id = Integer.parseInt(table.getValueAt(row, 0).toString());
					try {
						NhanVien nhanVien = nhanVienDAO.getNhanVienById(id);
						nhanVien.setTrangThai("Đã Nghỉ");
						nhanVienDAO.updateNhanVien(nhanVien);
						tableModel.removeRow(row);

					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn vào nhân viên cần xóa!");
			}
		}
		else if(obj.equals(btnCapNhat)) {
			if(kiemTraDuLieu()) {
				String id = txtMaNhanVien.getText();
				String tenNhanVien = txtTen.getText();
				LocalDate ngaySinh = LocalDate.parse(txtNgaySinh.getText(), formatter);
				String gioiTinh = cboGioiTinh.getSelectedItem().toString();
				String soCMND = txtCMND.getText();
				String soDienThoai = txtSoDienThoai.getText();
				String loaiNV = cboLoaiNhanVien.getSelectedItem().toString();
				String diaChi = txtDiaChi.getText();
				String tenTaiKhoan = txtTaiKhoan.getText();
				String matKhau = txtMatKhau.getText();
				String xacNhanMatKhau = txtXacNhanMatKhau.getText();
				if(matKhau.equalsIgnoreCase(xacNhanMatKhau)) {
					TaiKhoan taiKhoan = new TaiKhoan(tenTaiKhoan, matKhau);
					NhanVien nhanVien = new NhanVien(Integer.parseInt(id), tenNhanVien, ngaySinh, gioiTinh, soCMND, soDienThoai, loaiNV, diaChi,"Đang Làm" ,taiKhoan);
					try {
						nhanVienDAO.updateNhanVien(nhanVien);
						JOptionPane.showMessageDialog(this, "Cập nhật thông tin nhân viên có mã " + id);
						xoaHetDuLieuTrenTableModel();
						updateTableNhanVien();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(this,"Xác nhận mật khẩu không khớp!");
				}
			}
		}
		else if(obj.equals(btnLamMoi)) {
			xoaHetDuLieuTrenTableModel();
			updateTableNhanVien();
		}
		else if(obj.equals(btnLuu)) {
			themNhanVien();
		}
	}
}
