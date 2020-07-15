package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window.Type;
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
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

import Entities.HangHoa;
import impls.HangHoaDAOImpl;
import interface_rmi.HangHoaDAO;

import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;

public class FrmQuanLyHangHoa extends JFrame implements ActionListener,MouseListener  {
	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	private JTextField txtMaHang;
	private JTextField txtDVT;
	private JTextField txtTenHang;
	private JTable table;
	private JTextField txtTenNhaCungCap;
	private JTextField txtDiaChi;
	private JTextField txtNgaySanXuat;
	private JTextField txtHanSuDung;
	private JComboBox cboLoaiHang;
	private JButton btnThemHangHoa;
	private JButton btnLuu;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnHuyThemHang ;
	private JPanel pnlChucNang;
	private JButton btnTimKiem;
	private JRadioButton radTenHang;
	private JRadioButton radLoaiHang;
	private JComboBox cboTimKiem;
	private JComboBox cboTrangThai;
	private JRadioButton radHetHang;
	private JLabel lblHanSuDung;
	private DefaultTableModel tableModel;
	private DefaultComboBoxModel cboModelLoaiHang = new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModelTimKiem = new DefaultComboBoxModel();
	private HangHoaDAO hangHoaDAO = null;
	private SecurityManager securityManager ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		FrmQuanLyHangHoa frame = new FrmQuanLyHangHoa();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	/**
	 * Create the frame.
	 */
	public FrmQuanLyHangHoa() {
		try {
			this.securityManager  = System.getSecurityManager();
			if (securityManager == null) {
				System.setProperty("java.security.policy", "mypolicy\\policy.policy");
				System.setSecurityManager(new SecurityManager());
			}
			this.hangHoaDAO =  (HangHoaDAO) Naming.lookup("rmi://localhost:1099/xyLyHangHoa");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("loi1");
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("loi2");
		} catch (NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("loi3");
		}

		//////////////////////
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("Hinh\\pm.png"));
		setType(Type.POPUP);
		setResizable(false);
		setForeground(new Color(51, 102, 255));
		setBackground(new Color(51, 102, 255));
		setTitle("Phần mềm quản lý siêu thị");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1084, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 204, 255));
		panel_4.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin h\u00E0ng h\u00F3a", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_4.setBounds(12, 87, 515, 215);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblMaHang = new JLabel("Mã hàng");
		lblMaHang.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMaHang.setBounds(10, 22, 88, 20);
		panel_4.add(lblMaHang);

		txtMaHang = new JTextField();
		txtMaHang.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMaHang.setBounds(116, 16, 363, 20);
		panel_4.add(txtMaHang);
		txtMaHang.setColumns(10);

		JLabel lblTnKhchHng = new JLabel("Đơn vị tính :");
		lblTnKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTnKhchHng.setBounds(10, 103, 100, 18);
		panel_4.add(lblTnKhchHng);

		txtDVT = new JTextField();
		txtDVT.setEditable(false);
		txtDVT.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDVT.setBounds(116, 103, 363, 20);
		panel_4.add(txtDVT);
		txtDVT.setColumns(10);

		JLabel lblLoaiHang = new JLabel("Loại hàng :");
		lblLoaiHang.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblLoaiHang.setBounds(10, 76, 88, 18);
		panel_4.add(lblLoaiHang);

		JLabel lblNgyLp = new JLabel("Hạn sử dụng :");
		lblNgyLp.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNgyLp.setBounds(10, 186, 80, 18);
		panel_4.add(lblNgyLp);

		JLabel lblTenHang = new JLabel("Tên Hàng:");
		lblTenHang.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTenHang.setBounds(10, 47, 80, 18);
		panel_4.add(lblTenHang);

		txtTenHang = new JTextField();
		txtTenHang.setEditable(false);
		txtTenHang.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTenHang.setBounds(116, 47, 363, 20);
		panel_4.add(txtTenHang);
		txtTenHang.setColumns(10);

		JLabel lblNgySnXut = new JLabel("Ngày sản xuất :");
		lblNgySnXut.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNgySnXut.setBounds(10, 162, 100, 18);
		panel_4.add(lblNgySnXut);

		cboLoaiHang = new JComboBox();
		cboLoaiHang.setBounds(116, 76, 363, 20);
		panel_4.add(cboLoaiHang);

		txtNgaySanXuat = new JTextField();
		txtNgaySanXuat.setToolTipText("21/11/1999");
		txtNgaySanXuat.setEditable(false);
		txtNgaySanXuat.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNgaySanXuat.setColumns(10);
		txtNgaySanXuat.setBounds(116, 160, 363, 20);
		panel_4.add(txtNgaySanXuat);

		txtHanSuDung = new JTextField();
		txtHanSuDung.setEditable(false);
		txtHanSuDung.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHanSuDung.setColumns(10);
		txtHanSuDung.setBounds(116, 186, 363, 20);
		panel_4.add(txtHanSuDung);

		JLabel lblnGi_1 = new JLabel("Đơn Giá :");
		lblnGi_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblnGi_1.setBounds(10, 133, 100, 18);
		panel_4.add(lblnGi_1);

		txtDonGia = new JTextField();
		txtDonGia.setEditable(false);
		txtDonGia.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(116, 133, 363, 20);
		panel_4.add(txtDonGia);

		pnlChucNang = new JPanel();
		pnlChucNang.setBackground(new Color(204, 204, 255));
		pnlChucNang.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "C\u00E1c ch\u1EE9c n\u0103ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		pnlChucNang.setBounds(12, 534, 1056, 126);
		contentPane.add(pnlChucNang);
		pnlChucNang.setLayout(null);
		ImageIcon iconAdd = new ImageIcon("Hinh/add.png");
		ImageIcon iconDelete = new ImageIcon("Hinh/delete.png");
		ImageIcon iconUpdate = new ImageIcon("Hinh/update.png");
		ImageIcon iconSearch = new ImageIcon("Hinh/search.png");
		ImageIcon iconSave = new ImageIcon("Hinh/save.png");
		ImageIcon iconExit = new ImageIcon("Hinh/exit.png");
		ImageIcon iconExcel = new ImageIcon("Hinh/excel.png");

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(204, 204, 255));
		panel_8.setBorder(null);
		panel_8.setBounds(10, 16, 616, 102);
		pnlChucNang.add(panel_8);
		panel_8.setLayout(null);

		btnTimKiem = new JButton("Tìm");
		btnTimKiem.setBounds(367, 5, 111, 30);
		panel_8.add(btnTimKiem);
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnTimKiem.setIcon(iconSearch);

		JLabel lblNhpThngTin = new JLabel("Nhập thông tin tìm kiếm:");
		lblNhpThngTin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNhpThngTin.setBounds(10, 0, 162, 30);
		panel_8.add(lblNhpThngTin);

		JLabel lblTmTheo = new JLabel("Tìm theo:");
		lblTmTheo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTmTheo.setBounds(10, 40, 63, 30);
		panel_8.add(lblTmTheo);

		radTenHang = new JRadioButton("Tên Hàng");
		radTenHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cboTimKiem.removeAllItems();
				updateCboTimKiemTenHangHoa();
			}
		});
		radTenHang.setBounds(86, 45, 86, 23);
		panel_8.add(radTenHang);

		radLoaiHang = new JRadioButton("Loại hàng");
		radLoaiHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//cboModelTimKiem.removeAllElements();
				cboTimKiem.removeAllItems();
				updateCboTimKiemLoaiHang();
			}
		});
		radLoaiHang.setBounds(182, 45, 101, 23);
		radTrangThai = new JRadioButton("Trạng Thái");
		radTrangThai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cboTimKiem.removeAllItems();
				cboTimKiem.addItem("Đang kinh doanh");
				cboTimKiem.addItem("Ngừng kinh doanh");
			}
		});
		radTrangThai.setBounds(297, 45, 101, 23);
		panel_8.add(radTrangThai);
		
		////
		radHetHang = new JRadioButton("Sản phẩm hết hạn");
		radHetHang.setBounds(413, 45, 136, 23);
		panel_8.add(radHetHang);
		
		radConHang = new JRadioButton("Sản phẩm còn hạn");
		radConHang.setBounds(413, 71, 136, 23);
		panel_8.add(radConHang);
		ButtonGroup group = new ButtonGroup();
		group.add(radTenHang);
		group.add(radLoaiHang);
		group.add(radTrangThai);
		group.add(radHetHang);
		group.add(radConHang);
		panel_8.add(radLoaiHang);

		cboTimKiem = new JComboBox();
		cboTimKiem.setEditable(true);
		cboTimKiem.setBounds(182, 5, 162, 22);
		panel_8.add(cboTimKiem);
		
		
		
		



		JButton btnThoat = new JButton("Thoát");
		btnThoat.setHorizontalAlignment(SwingConstants.LEFT);
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmQuanLy.tabbedPane.remove(contentPane);
			}
		});
		ImageIcon iconThoat = new ImageIcon("Hinh/exit.png");
		btnThoat.setIcon(new ImageIcon("Hinh\\close.png"));
		//		btnThot.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent e) {
		//			}
		//		});
		btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnThoat.setBounds(915, 78, 120, 40);
		pnlChucNang.add(btnThoat);

		btnThemHangHoa = new JButton("Thêm hàng");
		btnThemHangHoa.setHorizontalAlignment(SwingConstants.LEFT);
		btnThemHangHoa.setIcon(new ImageIcon("Hinh\\add.png"));
		btnThemHangHoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThemHangHoa.setBackground(new Color(32, 178, 170));
		btnThemHangHoa.setBounds(636, 12, 147, 44);
		pnlChucNang.add(btnThemHangHoa);

		btnXoa = new JButton("Xóa ");
		btnXoa.setHorizontalAlignment(SwingConstants.LEFT);
		btnXoa.setIcon(new ImageIcon("iconDelete.png"));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoa.setBackground(new Color(32, 178, 170));
		btnXoa.setBounds(793, 12, 105, 44);
		pnlChucNang.add(btnXoa);

		btnLuu = new JButton("Lưu hàng");
		btnLuu.setIcon(new ImageIcon("Hinh\\iconSave.png"));
		btnLuu.setHorizontalAlignment(SwingConstants.LEFT);
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLuu.setBackground(new Color(32, 178, 170));
		btnLuu.setBounds(793, 78, 112, 40);
		pnlChucNang.add(btnLuu);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(0, 0, 1068, 76);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTieuDe = new JLabel("Thông Tin Các Loại Hàng Hóa");
		lblTieuDe.setForeground(Color.RED);
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTieuDe.setBounds(10, 11, 1023, 56);
		panel.add(lblTieuDe);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.BLACK);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch h\u00E0ng h\u00F3a", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBounds(10, 313, 1058, 210);
		contentPane.add(panel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 23, 1030, 176);
		panel_1.add(scrollPane);

		String[] tb = new String[]{"Mã" ,"Tên hàng", "Nhà cung cấp", "Đơn vị tính","Đơn Giá","Ngày Sản Xuất","Hạn Sử Dụng","Loại Hàng","Địa Chỉ" ,"Trạng Thái"};

		tableModel = new DefaultTableModel(tb,0);
		table = new JTable(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		scrollPane.setViewportView(table);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 255));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin nh\u00E0 cung c\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_2.setBounds(537, 87, 531, 215);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblLoiThngK = new JLabel("Tên\r\n");
		lblLoiThngK.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblLoiThngK.setBounds(10, 20, 64, 14);
		panel_2.add(lblLoiThngK);

		txtTenNhaCungCap = new JTextField();
		txtTenNhaCungCap.setEditable(false);
		txtTenNhaCungCap.setBounds(106, 18, 353, 20);
		panel_2.add(txtTenNhaCungCap);
		txtTenNhaCungCap.setColumns(10);

		JLabel lblnGi = new JLabel("Địa chỉ :");
		lblnGi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblnGi.setBounds(10, 51, 54, 18);
		panel_2.add(lblnGi);

		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setBounds(106, 48, 353, 20);
		panel_2.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		table.addMouseListener(this);
		btnLuu.setEnabled(false);

		btnSua = new JButton("Sửa");
		btnSua.setHorizontalAlignment(SwingConstants.LEFT);
		btnSua.setIcon(new ImageIcon("Hinh\\sua.png"));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSua.setBackground(new Color(32, 178, 170));
		btnSua.setBounds(915, 11, 120, 45);
		pnlChucNang.add(btnSua);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon("Hinh\\Refresh-icon.png"));
		btnLamMoi.setHorizontalAlignment(SwingConstants.LEFT);
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLamMoi.setBackground(new Color(32, 178, 170));
		btnLamMoi.setBounds(636, 78, 147, 40);
		pnlChucNang.add(btnLamMoi);

		btnHuyThemHang = new JButton("Hủy thêm hàng");
		btnHuyThemHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHuyThemHang.setBackground(new Color(32, 178, 170));
		btnHuyThemHang.setBounds(585, 46, 147, 23);
		txtMaHang.setEditable(false);
		txtTenHang.setEditable(true);
		cboLoaiHang.setEditable(true);
		txtDVT.setEditable(true);
		txtDonGia.setEditable(true);
		txtNgaySanXuat.setEditable(true);
		txtHanSuDung.setEditable(true);

		btnXoaTxtTenHang = new JButton("");
		btnXoaTxtTenHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTenHang.setText("");
			}
		});
		btnXoaTxtTenHang.setIcon(new ImageIcon("Hinh\\iconDelete.png"));
		btnXoaTxtTenHang.setBounds(489, 46, 18, 20);
		panel_4.add(btnXoaTxtTenHang);

		btnXoaTxtLoaiHang = new JButton("");
		btnXoaTxtLoaiHang.setIcon(new ImageIcon("Hinh\\iconDelete.png"));
		btnXoaTxtLoaiHang.setBounds(489, 75, 18, 20);
		panel_4.add(btnXoaTxtLoaiHang);

		btnXoaTxtDonViTinh = new JButton("");
		btnXoaTxtDonViTinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDVT.setText("");
			}
		});
		btnXoaTxtDonViTinh.setIcon(new ImageIcon("Hinh\\iconDelete.png"));
		btnXoaTxtDonViTinh.setBounds(489, 102, 18, 20);
		panel_4.add(btnXoaTxtDonViTinh);

		btnXoaTxtDonGia = new JButton("");
		btnXoaTxtDonGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDonGia.setText("");
			}
		});
		btnXoaTxtDonGia.setIcon(new ImageIcon("Hinh\\iconDelete.png"));
		btnXoaTxtDonGia.setBounds(489, 132, 18, 20);
		panel_4.add(btnXoaTxtDonGia);

		btnXoaTxtNgaySanXuat = new JButton("");
		btnXoaTxtNgaySanXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNgaySanXuat.setText("");
			}
		});
		btnXoaTxtNgaySanXuat.setIcon(new ImageIcon("Hinh\\iconDelete.png"));
		btnXoaTxtNgaySanXuat.setBounds(489, 161, 18, 20);
		panel_4.add(btnXoaTxtNgaySanXuat);

		btnXoaTxtHanSuDung = new JButton("");
		btnXoaTxtHanSuDung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtHanSuDung.setText("");
			}
		});
		btnXoaTxtHanSuDung.setIcon(new ImageIcon("Hinh\\iconDelete.png"));
		btnXoaTxtHanSuDung.setBounds(489, 185, 18, 20);
		panel_4.add(btnXoaTxtHanSuDung);
		txtTenNhaCungCap.setEditable(true);
		txtDiaChi.setEditable(true);

		btnXoaTxtTen = new JButton("");
		btnXoaTxtTen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTenNhaCungCap.setText("");
			}
		});
		btnXoaTxtTen.setIcon(new ImageIcon("Hinh\\iconDelete.png"));
		btnXoaTxtTen.setBounds(466, 17, 18, 20);
		panel_2.add(btnXoaTxtTen);

		btnXoaTxtDiaChi = new JButton("");
		btnXoaTxtDiaChi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDiaChi.setText("");
			}
		});
		btnXoaTxtDiaChi.setIcon(new ImageIcon("Hinh\\iconDelete.png"));
		btnXoaTxtDiaChi.setBounds(466, 50, 18, 20);
		panel_2.add(btnXoaTxtDiaChi);

		JLabel lblTrangThaiHang = new JLabel("Trạng thái:");
		lblTrangThaiHang.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTrangThaiHang.setBounds(10, 88, 93, 20);
		panel_2.add(lblTrangThaiHang);

		cboTrangThai = new JComboBox();
		cboTrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cboTrangThai.setModel(new DefaultComboBoxModel(new String[] {"Đang kinh doanh", "Ngừng kinh doanh"}));
		cboTrangThai.setBounds(106, 87, 173, 22);
		panel_2.add(cboTrangThai);
		
		lblHanSuDung = new JLabel("");
		lblHanSuDung.setForeground(Color.BLUE);
		lblHanSuDung.setBackground(Color.BLUE);
		lblHanSuDung.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHanSuDung.setBounds(106, 120, 269, 20);
		panel_2.add(lblHanSuDung);
		btnXoa.addActionListener(this);
		//	pnlChucNang.add(btnHuyThemHang);
		btnHuyThemHang.setEnabled(false);
		btnThemHangHoa.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnTimKiem.addActionListener(this);
		radTenHang.addActionListener(this);
		radLoaiHang.addActionListener(this);
		radHetHang.addActionListener(this);
		radConHang.addActionListener(this);
		btnLamMoi.addActionListener(this);
		updataTableHangHoa();
	}
	String loaiHangCbo="";
	private JTextField txtDonGia;
	private JButton btnLamMoi;
	public void updataTableHangHoa() {
		try {
			hangHoaDAO.getDsHangHoa().forEach(x->{
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				int maHang = x.getId();
				String tenHang = x.getTenHangHoa();
				String nhaCungCap = x.getTenNhaCungCap();
				String donViTinh = x.getDonViTinh();
				LocalDate ngaySanXuat = x.getNgaySanXuat();
				String ngaySanXuatFomat = ngaySanXuat.format(formatter);
				LocalDate hanSuDung = x.getHanSuDung();
				String hanSuDungFomat = hanSuDung.format(formatter);
				String loaiHang = x.getLoaiHangHoa();
				String diaChi = x.getDiaChiCungCap();
				double donGia = x.getDonGia();
				String trangThai = x.getTrangThai();
				tableModel.addRow(new Object[] {
						maHang,tenHang,nhaCungCap,donViTinh,donGia,ngaySanXuatFomat,hanSuDungFomat,loaiHang,diaChi,trangThai
				});

				if(loaiHang.equalsIgnoreCase(loaiHangCbo)==false){
					cboModelLoaiHang.addElement(x.getLoaiHangHoa());
					cboLoaiHang.setModel(cboModelLoaiHang);
				}
				loaiHangCbo = x.getLoaiHangHoa();
			});

		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("loi");
		}
	}
	String tenHang = "";
	public void updateCboTimKiemTenHangHoa() {
		try {
			hangHoaDAO.getDsHangHoa().forEach(x->{
				if(x.getTenHangHoa().equalsIgnoreCase(tenHang)==false) {
					cboModelTimKiem.addElement(x.getTenHangHoa());
					cboTimKiem.setModel(cboModelTimKiem);
				}
				tenHang = x.getTenHangHoa();
			});
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	String loaiHangTim = "";
	private JButton btnXoaTxtTenHang;
	private JButton btnXoaTxtLoaiHang;
	private JButton btnXoaTxtDonViTinh;
	private JButton btnXoaTxtDonGia;
	private JButton btnXoaTxtNgaySanXuat;
	private JButton btnXoaTxtHanSuDung;
	private JButton btnXoaTxtTen;
	private JButton btnXoaTxtDiaChi;
	private JRadioButton radTrangThai;
	private JRadioButton radConHang;
	public void updateCboTimKiemLoaiHang() {
		try {

			hangHoaDAO.getDsHangHoa().forEach(x->{
				String loaiHang = x.getLoaiHangHoa();
				if(loaiHang.equalsIgnoreCase(loaiHangTim)==false) {
					cboModelTimKiem.addElement(x.getLoaiHangHoa());
					cboTimKiem.setModel(cboModelTimKiem);
				}
				loaiHangTim = x.getLoaiHangHoa();
			});
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void xoaHetDuLieuTrenTableModel() {
		tableModel.addRow(new Object[] {

		});
		cboTrangThai.setSelectedIndex(0);
		tableModel = (DefaultTableModel) table.getModel();
		tableModel.getDataVector().removeAllElements();
	}
	public boolean kiemTraDuLieu() {
		if(txtTenHang.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tên hàng!");
			txtTenHang.requestFocus();
			return false;
		}
		else if(cboLoaiHang.getSelectedItem()=="") {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn loại hàng!");
			cboLoaiHang.requestFocus();
			return false;
		}
		else if(txtDVT.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đơn vị tính!");
			txtDVT.requestFocus();
			return false;
		}
		else if(txtDonGia.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đơn giá!");
			txtDonGia.requestFocus();
			return false;
		}
		else if(txtDonGia.getText().matches("^[0-9.]+$")==false) {
			JOptionPane.showMessageDialog(this, "Đơn giá chỉ bao gồm các số [0-9.]!");
			txtDonGia.requestFocus();
			return false;
		}
		else if(txtNgaySanXuat.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày sản xuất!");
			txtNgaySanXuat.requestFocus();
			return false;
		}
		else if(txtNgaySanXuat.getText().matches("^[0-9][0-9]/[0-9][0-9]/[0-9]{4}$")==false) {
			JOptionPane.showMessageDialog(this, "Ngày sản xuất định dạng dd/MM/yyyy");
			txtNgaySanXuat.requestFocus();
			return false;
		}
		else if(txtHanSuDung.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập hạn sử dụng!");
			txtHanSuDung.requestFocus();
			return false;
		}
		else if(txtHanSuDung.getText().matches("^[0-9][0-9]/[0-9][0-9]/[0-9]{4}$")==false) {
			JOptionPane.showMessageDialog(this, "Hạn sử dụng định dạng dd/MM/yyyy");
			txtNgaySanXuat.requestFocus();
			return false;
		}
		else if(txtTenNhaCungCap.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tên nhà cung cấp!");
			txtTenNhaCungCap.requestFocus();
			return false;
		}
		else if(txtDiaChi.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ!");
			txtDiaChi.requestFocus();
			return false;
		}
		return true;
	}
	
	/*
	 * Kiem tra het han su dung
	 * 
	 * 
	 * 
	 * 
	 * */
	public List<HangHoa> kiemTraHetHangSuDung(){
		List<HangHoa> hangHoas = new ArrayList<HangHoa>();
		LocalDate ngayHienTai = LocalDate.now();
		try {
			for(HangHoa hangHoa: hangHoaDAO.getDsHangHoa()) {
				if(hangHoa.getHanSuDung().isBefore(ngayHienTai)) {
					hangHoas.add(hangHoa);
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hangHoas;
	}
	/*
	 * Kiem tra san pham con han su dung
	 * 
	 * 
	 * */
	public List<HangHoa> kiemTraConHangSuDung(){
		List<HangHoa> hangHoas = new ArrayList<HangHoa>();
		LocalDate ngayHienTai = LocalDate.now();
		try {
			for(HangHoa hangHoa: hangHoaDAO.getDsHangHoa()) {
				if(hangHoa.getHanSuDung().isAfter(ngayHienTai)) {
					hangHoas.add(hangHoa);
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hangHoas;
	}
	public void setTextNull() {
		txtTenHang.setText("");
		txtTenHang.setEditable(true);
		txtTenNhaCungCap.setText("");
		txtTenNhaCungCap.setEditable(true);
		txtDVT.setText("");
		txtDVT.setEditable(true);
		txtDonGia.setText("");
		txtDonGia.setEditable(true);
		txtNgaySanXuat.setText("");
		txtNgaySanXuat.setEditable(true);
		txtHanSuDung.setText("");
		txtHanSuDung.setEditable(true);
		txtDiaChi.setText("");
		txtDiaChi.setEditable(true);
		cboLoaiHang.setSelectedItem("");
		cboLoaiHang.setEditable(true);
		btnLuu.setEnabled(true);
		cboTrangThai.setSelectedItem("Đang kinh doanh");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btnThemHangHoa)) {
			try {
				int idMaHang = hangHoaDAO.getIdHangHoaMax() +1;
				txtMaHang.setText(idMaHang+"");
				setTextNull();
				xoaHetDuLieuTrenTableModel();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(obj.equals(btnLuu)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			if(kiemTraDuLieu()) {
				int maHang = Integer.parseInt(txtMaHang.getText());
				String tenHangHoa = txtTenHang.getText();
				String ngaySanXuatText = txtNgaySanXuat.getText();
				LocalDate ngaySanXuat = LocalDate.parse(ngaySanXuatText,formatter);
				String hanSuDungText = txtHanSuDung.getText();
				LocalDate hanSuDung = LocalDate.parse(hanSuDungText,formatter);

				String donViTinh = txtDVT.getText();
				double donGia = Double.parseDouble(txtDonGia.getText());
				String loaiHangHoa = cboModelLoaiHang.getSelectedItem().toString();
				String tenNhaCungCap = txtTenNhaCungCap.getText();
				String diaChiNhaCungCap = txtDiaChi.getText();
				String trangThai = cboTrangThai.getSelectedItem().toString();
				HangHoa hangHoa = new HangHoa(maHang, tenHangHoa, ngaySanXuat, hanSuDung, donViTinh, donGia, loaiHangHoa, tenNhaCungCap, diaChiNhaCungCap,trangThai);
				String ngaySanXuatFormat = hangHoa.getNgaySanXuat().format(formatter);
				try {
					hangHoaDAO.addHangHoa(hangHoa);
					tableModel.addRow(new Object[] {
							hangHoa.getId(),hangHoa.getTenHangHoa(),hangHoa.getTenNhaCungCap(),hangHoa.getDonViTinh(),hangHoa.getDonGia(),hangHoa.getNgaySanXuat().format(formatter),hangHoa.getHanSuDung().format(formatter),hangHoa.getLoaiHangHoa(),hangHoa.getDiaChiCungCap(),hangHoa.getTrangThai()
					});
					table.setModel(tableModel);
					btnLuu.setEnabled(false);
					JOptionPane.showMessageDialog(this,"Thêm thành công!");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("Them hang hoa bi loi");
				}catch (IllegalStateException e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(this,"Mã hàng bị trùng!");
				}catch (EntityExistsException e3) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(this, "Mã hàng bị trùng");
				}


			}
		}
		else if(obj.equals(btnSua)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			if(kiemTraDuLieu()) {
				HangHoa hangHoaUpdate = new HangHoa(Integer.parseInt(txtMaHang.getText()), txtTenHang.getText(),LocalDate.parse(txtNgaySanXuat.getText(),formatter),LocalDate.parse(txtHanSuDung.getText(),formatter) , txtDVT.getText(), Double.parseDouble(txtDonGia.getText()), cboLoaiHang.getSelectedItem().toString(), txtTenNhaCungCap.getText(), txtDiaChi.getText(),cboTrangThai.getSelectedItem().toString());
				try {
					hangHoaDAO.updateHangHoa(hangHoaUpdate);
					tableModel.getDataVector().removeAllElements();
					updataTableHangHoa();
					JOptionPane.showMessageDialog(this,"Sửa thành công! mã sản phẩm "+hangHoaUpdate.getId());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		else if(obj.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if(row!=-1) {
				int id =Integer.parseInt(tableModel.getValueAt(row, 0).toString());
				Object o =JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn xóa ?");
				if(o.equals(0)) {
					try {
						HangHoa hangHoa = hangHoaDAO.getHangHoaById(id);
						hangHoa.setTrangThai("Ngừng kinh doanh");
						hangHoaDAO.updateHangHoa(hangHoa);
						tableModel.removeRow(row);
						JOptionPane.showMessageDialog(this,"Xóa thành công!");
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(this,"Xóa thất bại!");
					}
				}
				else if(o.equals(1)) {

				}

			}
		}
		else if(obj.equals(btnTimKiem)) {
			if(radTenHang.isSelected()) {
				xoaHetDuLieuTrenTableModel();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				try {
					for(HangHoa hangHoa : hangHoaDAO.getMaHangHoaByTen(cboTimKiem.getSelectedItem().toString())) {
						LocalDate ngaySanXuat = hangHoa.getNgaySanXuat();
						String ngaySanXuatFomat = ngaySanXuat.format(formatter);
						LocalDate hanSuDung = hangHoa.getHanSuDung();
						String hanSuDungFomat = hanSuDung.format(formatter);
						tableModel.addRow(new Object[] {
								hangHoa.getId(),hangHoa.getTenHangHoa(),hangHoa.getTenNhaCungCap(),hangHoa.getDonViTinh(),hangHoa.getDonGia(),ngaySanXuatFomat,hanSuDungFomat,hangHoa.getLoaiHangHoa(),hangHoa.getDiaChiCungCap(),hangHoa.getTrangThai()
						});

					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}catch (NullPointerException e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this, "Xin chọn đối tượng cần tìm kiếm");
				}

			}
			else if(radLoaiHang.isSelected()) {

				xoaHetDuLieuTrenTableModel();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				try {
					for(HangHoa hangHoa : hangHoaDAO.getHangHoaByLoaiHang(cboTimKiem.getSelectedItem().toString())) {
						LocalDate ngaySanXuat = hangHoa.getNgaySanXuat();
						String ngaySanXuatFomat = ngaySanXuat.format(formatter);
						LocalDate hanSuDung = hangHoa.getHanSuDung();
						String hanSuDungFomat = hanSuDung.format(formatter);
						tableModel.addRow(new Object[] {
								hangHoa.getId(),hangHoa.getTenHangHoa(),hangHoa.getTenNhaCungCap(),hangHoa.getDonViTinh(),hangHoa.getDonGia(),ngaySanXuatFomat,hanSuDungFomat,hangHoa.getLoaiHangHoa(),hangHoa.getDiaChiCungCap(),hangHoa.getTrangThai()
						});
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			else if(radTrangThai.isSelected()) {
				xoaHetDuLieuTrenTableModel();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				try {
					for(HangHoa hangHoa : hangHoaDAO.getDsHangHoa()) {
						if(hangHoa.getTrangThai().equalsIgnoreCase(cboTimKiem.getSelectedItem().toString())) {
							LocalDate ngaySanXuat = hangHoa.getNgaySanXuat();
							String ngaySanXuatFomat = ngaySanXuat.format(formatter);
							LocalDate hanSuDung = hangHoa.getHanSuDung();
							String hanSuDungFomat = hanSuDung.format(formatter);
							tableModel.addRow(new Object[] {
									hangHoa.getId(),hangHoa.getTenHangHoa(),hangHoa.getTenNhaCungCap(),hangHoa.getDonViTinh(),hangHoa.getDonGia(),ngaySanXuatFomat,hanSuDungFomat,hangHoa.getLoaiHangHoa(),hangHoa.getDiaChiCungCap(),hangHoa.getTrangThai()
							});
						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			else if(radHetHang.isSelected()) {
				xoaHetDuLieuTrenTableModel();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				for(HangHoa hangHoa:kiemTraHetHangSuDung()) {
					LocalDate ngaySanXuat = hangHoa.getNgaySanXuat();
					String ngaySanXuatFomat = ngaySanXuat.format(formatter);
					LocalDate hanSuDung = hangHoa.getHanSuDung();
					String hanSuDungFomat = hanSuDung.format(formatter);
					tableModel.addRow(new Object[] {
							hangHoa.getId(),hangHoa.getTenHangHoa(),hangHoa.getTenNhaCungCap(),hangHoa.getDonViTinh(),hangHoa.getDonGia(),ngaySanXuatFomat,hanSuDungFomat,hangHoa.getLoaiHangHoa(),hangHoa.getDiaChiCungCap(),hangHoa.getTrangThai()
					});
				}
			}
			else if(radConHang.isSelected()) {
				xoaHetDuLieuTrenTableModel();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				for(HangHoa hangHoa:kiemTraConHangSuDung()) {
					LocalDate ngaySanXuat = hangHoa.getNgaySanXuat();
					String ngaySanXuatFomat = ngaySanXuat.format(formatter);
					LocalDate hanSuDung = hangHoa.getHanSuDung();
					String hanSuDungFomat = hanSuDung.format(formatter);
					tableModel.addRow(new Object[] {
							hangHoa.getId(),hangHoa.getTenHangHoa(),hangHoa.getTenNhaCungCap(),hangHoa.getDonViTinh(),hangHoa.getDonGia(),ngaySanXuatFomat,hanSuDungFomat,hangHoa.getLoaiHangHoa(),hangHoa.getDiaChiCungCap(),hangHoa.getTrangThai()
					});
				}
			}
		}
		else if(obj.equals(btnLamMoi)) {
			xoaHetDuLieuTrenTableModel();
			updataTableHangHoa();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			try {
				for(HangHoa hangHoa : kiemTraHetHangSuDung()) {
						LocalDate ngaySanXuat = hangHoa.getNgaySanXuat();
						String ngaySanXuatFomat = ngaySanXuat.format(formatter);
						LocalDate hanSuDung = hangHoa.getHanSuDung();
						String hanSuDungFomat = hanSuDung.format(formatter);
						tableModel.addRow(new Object[] {
								hangHoa.getId(),hangHoa.getTenHangHoa(),hangHoa.getTenNhaCungCap(),hangHoa.getDonViTinh(),hangHoa.getDonGia(),ngaySanXuatFomat,hanSuDungFomat,hangHoa.getLoaiHangHoa(),hangHoa.getDiaChiCungCap(),hangHoa.getTrangThai()
						});
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		int row = table.getSelectedRow();
		String maHang = tableModel.getValueAt(row, 0).toString();
		String tenHangHoa = tableModel.getValueAt(row, 1).toString();
		String tenNhaCungCap = tableModel.getValueAt(row, 2).toString();
		String donViTinh = tableModel.getValueAt(row, 3).toString();
		String donGia = tableModel.getValueAt(row, 4).toString();
		String ngaySanXuat = tableModel.getValueAt(row, 5).toString();
		String hanSuDung = tableModel.getValueAt(row, 6).toString();
		String loaiHang = tableModel.getValueAt(row, 7).toString();
		String diaChi = tableModel.getValueAt(row, 8).toString();
		String trangThai = tableModel.getValueAt(row, 9).toString();
		LocalDate hanSuDungPare = LocalDate.parse(hanSuDung, formatter);
		if(hanSuDungPare.isAfter(LocalDate.now())) {
			lblHanSuDung.setForeground(Color.BLUE);
			lblHanSuDung.setText("Còn hạn sử dụng.");
		}
		else if(hanSuDungPare.isBefore(LocalDate.now())) {
			lblHanSuDung.setForeground(Color.RED);
			lblHanSuDung.setText("Đã hết hạn sử dụng.");
		}
		txtMaHang.setText(maHang);
		txtTenHang.setText(tenHangHoa);
		txtTenNhaCungCap.setText(tenNhaCungCap);
		txtDVT.setText(donViTinh);
		txtDonGia.setText(donGia);
		txtNgaySanXuat.setText(ngaySanXuat);
		txtHanSuDung.setText(hanSuDung);
		txtDiaChi.setText(diaChi);
		cboLoaiHang.setSelectedItem(loaiHang);
		cboTrangThai.setSelectedItem(trangThai);
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
}
