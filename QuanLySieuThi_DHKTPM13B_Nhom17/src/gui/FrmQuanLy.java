package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class FrmQuanLy extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTable table;
	private JButton btnQuanLyHoaDon;
	private  final JPanel pnlMHNV = new JPanel();
	public static JTabbedPane tabbedPane ;
	private JButton btnQuanLyNhanVien;
	private JButton btnXemThongTinCaNhan;
	private JButton btnQuanLyHangHoa ;
	private FrmQuanLyHangHoa frmQuanLyHangHoa = new FrmQuanLyHangHoa();
	private FrmQuanLyHoaDon frmQuanLyHoaDon = new FrmQuanLyHoaDon();
	private FrmQuanLyNhanVien frmQuanLyNhanVien = new  FrmQuanLyNhanVien();
	private FrmXemThongTinCaNhan frmXemThongTinCaNhan = new FrmXemThongTinCaNhan();
	private SecurityManager securityManager ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmQuanLy frame = new FrmQuanLy();
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
	public FrmQuanLy() {
		getContentPane().setBackground(new Color(153, 204, 255));
		setTitle("M\u00E0n h\u00ECnh ch\u00EDnh nh\u00E2n vi\u00EAn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1350, 738);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		pnlMHNV.setForeground(Color.DARK_GRAY);
		pnlMHNV.setBackground(new Color(102, 153, 255));
		pnlMHNV.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		pnlMHNV.setBounds(10, 10, 225, 689);
		getContentPane().add(pnlMHNV);
		pnlMHNV.setLayout(null);
		
		JLabel lblMHNV_XinChao = new JLabel("Xin chào nhân viên");
		lblMHNV_XinChao.setHorizontalAlignment(SwingConstants.CENTER);
		lblMHNV_XinChao.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMHNV_XinChao.setBounds(10, 218, 199, 51);
		pnlMHNV.add(lblMHNV_XinChao);
		
		btnQuanLyHoaDon = new JButton("Quản lý hóa đơn");
		btnQuanLyHoaDon.setBackground(new Color(0, 255, 102));
		btnQuanLyHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyHoaDon.setIcon(new ImageIcon("Hinh\\list.png"));
		btnQuanLyHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnQuanLyHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnQuanLyHoaDon.setBounds(10, 469, 199, 57);
		pnlMHNV.add(btnQuanLyHoaDon);
		
		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setBackground(new Color(255, 51, 102));
		btnDangXuat.setHorizontalAlignment(SwingConstants.LEFT);
		btnDangXuat.setIcon(new ImageIcon("Hinh\\logout.png"));
		btnDangXuat.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnDangXuat.setBounds(39, 280, 154, 33);
		pnlMHNV.add(btnDangXuat);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBackground(new Color(255, 51, 102));
		btnThoat.setHorizontalAlignment(SwingConstants.LEFT);
		btnThoat.setIcon(new ImageIcon("Hinh\\close.png"));
		btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnThoat.setBounds(39, 325, 154, 33);
		pnlMHNV.add(btnThoat);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Hinh\\NhanVien.PNG"));
		lblNewLabel.setBounds(28, 34, 181, 191);
		pnlMHNV.add(lblNewLabel);
		
		btnQuanLyNhanVien = new JButton("Quản lý nhân viên");
		btnQuanLyNhanVien.setBackground(new Color(0, 255, 102));
		btnQuanLyNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyNhanVien.setIcon(new ImageIcon("Hinh\\list.png"));
		btnQuanLyNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnQuanLyNhanVien.setBounds(10, 537, 199, 57);
		pnlMHNV.add(btnQuanLyNhanVien);
		
		btnXemThongTinCaNhan = new JButton("Xem thông tin cá nhân");
		btnXemThongTinCaNhan.setBackground(new Color(0, 255, 102));
		btnXemThongTinCaNhan.setHorizontalAlignment(SwingConstants.LEFT);
		btnXemThongTinCaNhan.setIcon(new ImageIcon("Hinh\\edit.png"));
		btnXemThongTinCaNhan.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnXemThongTinCaNhan.setBounds(10, 605, 199, 57);
		pnlMHNV.add(btnXemThongTinCaNhan);
		
		btnQuanLyHangHoa = new JButton("Hàng Hóa");
		btnQuanLyHangHoa.setBackground(new Color(0, 255, 102));
		btnQuanLyHangHoa.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyHangHoa.setIcon(new ImageIcon("Hinh\\iconAdd.png"));
		btnQuanLyHangHoa.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnQuanLyHangHoa.setBounds(10, 401, 199, 57);
		pnlMHNV.add(btnQuanLyHangHoa);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(153, 153, 255));
		tabbedPane.setBounds(245, 10, 1079, 689);
		getContentPane().add(tabbedPane);
		
		JPanel pnlHangHoa = new JPanel();
		pnlHangHoa.setLayout(null);
		
		btnQuanLyHoaDon.addActionListener(this);
		btnQuanLyNhanVien.addActionListener(this);
		btnXemThongTinCaNhan.addActionListener(this);
		btnQuanLyHangHoa.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btnQuanLyHangHoa)) {
			tabbedPane.addTab("Quản lý hàng hóa", frmQuanLyHangHoa.contentPane);
			tabbedPane.setSelectedComponent(frmQuanLyHangHoa.contentPane);
		}
		else if(obj.equals(btnQuanLyHoaDon)) {
			tabbedPane.addTab("Quản lý hóa đơn", frmQuanLyHoaDon.contentPane);
			tabbedPane.setSelectedComponent(frmQuanLyHoaDon.contentPane);
		}
		else if(obj.equals(btnQuanLyNhanVien)) {
			tabbedPane.addTab("Quản lý nhân viên", frmQuanLyNhanVien.pnlTabQLNV);
			tabbedPane.setSelectedComponent(frmQuanLyNhanVien.pnlTabQLNV);
		}
		else if(obj.equals(btnXemThongTinCaNhan)) {
			tabbedPane.addTab("Thông tin cá nhân", frmXemThongTinCaNhan.pnlTabXemThongTinCaNhan);
			tabbedPane.setSelectedComponent(frmXemThongTinCaNhan.pnlTabXemThongTinCaNhan);
		}
	}
}
