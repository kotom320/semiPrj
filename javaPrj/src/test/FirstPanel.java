//package test;
//
//import java.awt.BorderLayout;
//import java.awt.CardLayout;
//import java.awt.Color;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;
//
//import javax.swing.ButtonGroup;
//import javax.swing.JButton;
//import javax.swing.JCheckBox;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JRadioButton;
//import javax.swing.JTextField;
//import javax.swing.border.TitledBorder;
//
//import hidden.Game;
//import insertMode.Data;
//import testmodel.ConnectPg;
//
//public class FirstPanel extends JPanel implements ActionListener, ItemListener {
//	// ȸ������â���� �����
//	Data da = new Data();
//	ConnectPg con;
//	private JButton btn1;
//	private JPanel p1, p2, p3, p4;
//	private JTextField f1, fId, fPass, fPassCheck;
//	private JLabel lId, lPass, lPassCheck, lb1, lb3_1, lb3_2;
//	private JCheckBox chb;
//	private JRadioButton rd2_1, rd2_2, rd2_3, rd2_4, rd3_1, rd3_2, rd3_3, rd3_4;
//	private Playground F;
//	static int i = 0;
//	String a = "", b = "";
//	String idc = "";
//
//	public FirstPanel(Playground f) {
//
//		F = f;
//		connecDB();
//		// p1 ����� ���̵�, ��ȣ ���� �Է�.
//		p1 = new JPanel();
//		lId = new JLabel("���̵�");
//		lPass = new JLabel("��ȣ");
//		lPassCheck = new JLabel("��ȣȮ��");
//		fId = new JTextField("", 10);
//		fPass = new JTextField("", 10);
//		fPassCheck = new JTextField("", 10);
//		lb1 = new JLabel("����");
//		f1 = new JTextField(10);
//		btn1 = new JButton("CHECK");
//		btn1.addActionListener(this);
//
//		// ���̾ƿ� ����
//		JPanel pLogin = new JPanel();
//		pLogin.setLayout(new GridLayout(4, 2));
//
//		pLogin.add(lb1);
//		pLogin.add(f1);
//		pLogin.add(lId);
//		pLogin.add(fId);
//		pLogin.add(lPass);
//		pLogin.add(fPass);
//		pLogin.add(lPassCheck);
//		pLogin.add(fPassCheck);
//
//		p1.add(pLogin);
//		p1.add(btn1);
//
//		// p2 �����
//		p2 = new JPanel();
//
//		chb = new JCheckBox("���̵���");
//		chb.addItemListener(this);
//		rd2_1 = new JRadioButton("2~3��");
//		rd2_1.addItemListener(this);
//		rd2_1.setVisible(false);
//
//		rd2_2 = new JRadioButton("3~4��");
//		rd2_2.addItemListener(this);
//		rd2_2.setVisible(false);
//
//		rd2_3 = new JRadioButton("4~6��");
//		rd2_3.addItemListener(this);
//		rd2_3.setVisible(false);
//
//		rd2_4 = new JRadioButton("7~10��");
//		rd2_4.addItemListener(this);
//		rd2_4.setVisible(false);
//
//		ButtonGroup bg = new ButtonGroup();
//		bg.add(rd2_1);
//		bg.add(rd2_2);
//		bg.add(rd2_3);
//		bg.add(rd2_4);
//
//		JPanel p2_left = new JPanel();
//		p2_left.add(chb);
//
//		JPanel p2_right = new JPanel();
//
//		p2_right.setLayout(new GridLayout(2, 0));
//		p2_right.add(rd2_1);
//		p2_right.add(rd2_2);
//		p2_right.add(rd2_3);
//		p2_right.add(rd2_4);
//
//		p2.setLayout(new GridLayout(0, 2));
//		p2.add(p2_left);
//		p2.add(p2_right);
//		p2.setBorder(new TitledBorder("���̵�������"));
//
//		// p3�����
//		p3 = new JPanel();
//		JPanel p3_pPanel = new JPanel();
//		JPanel p3_tPanel = new JPanel();
//		JPanel p3_lnPanel = new JPanel();
//		JPanel p3_lsPanel = new JPanel();
//
//		lb3_1 = new JLabel("��Ҽ���");
//		lb3_2 = new JLabel("�׸� ����");
//
//		rd3_1 = new JRadioButton("�ǳ�");
//		rd3_1.addItemListener(this);
//
//		rd3_2 = new JRadioButton("�߿�");
//		rd3_2.addItemListener(this);
//
//		rd3_3 = new JRadioButton("��Ƽ��Ƽ");
//		rd3_3.addItemListener(this);
//
//		rd3_4 = new JRadioButton("�޽�");
//		rd3_4.addActionListener(this);
//		rd3_4.addItemListener(this);
//
//		ButtonGroup bg2 = new ButtonGroup();
//		ButtonGroup bg3 = new ButtonGroup();
//		bg2.add(rd3_1);
//		bg2.add(rd3_2);
//		bg3.add(rd3_3);
//		bg3.add(rd3_4);
//
//		p3.setLayout(new GridLayout(2, 2));
//
//		p3_pPanel.setLayout(new GridLayout(2, 0));
//		p3_tPanel.setLayout(new GridLayout(2, 0));
//		p3_pPanel.add(rd3_1);
//		p3_pPanel.add(rd3_2);
//
//		p3_tPanel.add(rd3_3);
//		p3_tPanel.add(rd3_4);
//
//		p3_lnPanel.add(lb3_1);
//		p3_lsPanel.add(lb3_2);
//		p3.add(p3_lnPanel);
//		p3.add(p3_pPanel);
//		p3.add(p3_lsPanel);
//		p3.add(p3_tPanel);
//
//		p3.setBorder(new TitledBorder("��ȣ��Ҽ���"));
//
//		// p4 �����
//		p4 = new JPanel();
//		JPanel p4_btn = new JPanel();
//		p4.setLayout(new BorderLayout());
//		JButton next = new JButton("Ȯ��");
//		next.addActionListener(this);
//		p4_btn.add(next);
//		p4.add(p4_btn, BorderLayout.SOUTH);
//
//		setBackground(Color.DARK_GRAY);
//		setLayout(new GridLayout(4, 0, 10, 10));
//		add(p1);
//		add(p2);
//		add(p3);
//		add(p4);
//	}
//
//	private void connecDB() {
//		try {
//			con = new ConnectPg();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		String obj = e.getActionCommand();
//		// System.out.println(obj);
//
//		if (obj.equals("Ȯ��")) {
//			try {
//				
//				idc = con.checkID(fId.getText());
//				System.out.println("idc = " + idc);
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//			if(idc == "") {
//			JOptionPane.showMessageDialog(null, "�����ϴ� ���� : " + da.getChild() + " ��ȣ�ϴ� ��� : " + da.getPrefer());
//			da.setLoca(f1.getText());
//			da.setId(fId.getText());
//			da.setPass(fPass.getText());
//
//			try {
//				con.setInfo(da);
//
//			} catch (Exception e1) {
//				e1.printStackTrace();
//
//			}
//
//			F.getCardLayout().show(F.getContentPane(), "A2");
//			}else {
//				JOptionPane.showMessageDialog(null, "�ߺ��� ���̵��Դϴ�.");
//
//			}
//
//		} else if (obj.equals("CHECK")) {
//			
//			if (fPass.getText().equals("")) {
//				JOptionPane.showMessageDialog(null, "��ȣ�� �ٽ� Ȯ���� �ּ���");
//			} else if (fPass.getText().equals(fPassCheck.getText())) {
//				JOptionPane.showMessageDialog(null, "����");
//			} else {
//				JOptionPane.showMessageDialog(null, "��ȣ�� �ٽ� Ȯ���� �ּ���");
//			}
//
//		}
//
//		else if (obj.equals("�޽�")) {
//
//			i++;
//			System.out.println(i);
//			if (i == 5) {
//				Game g = new Game();
//				g.setVisible(true);
//
//				i = 0;
//			}
//		}
//	}
//
//	@Override
//	public void itemStateChanged(ItemEvent e) {
//
//		if (e.getSource() == chb) {
//			System.out.println(da.getPrefer());
//			System.out.println(da.getChild());
//			if (e.getStateChange() == ItemEvent.SELECTED) {
//				rd2_1.setVisible(true);
//				rd2_2.setVisible(true);
//				rd2_3.setVisible(true);
//				rd2_4.setVisible(true);
//
//			} else if (e.getStateChange() == ItemEvent.DESELECTED) {
//				rd2_1.setVisible(false);
//				rd2_2.setVisible(false);
//				rd2_3.setVisible(false);
//				rd2_4.setVisible(false);
//			}
//		} else if (e.getSource() == rd2_1) {
//			if (e.getStateChange() == ItemEvent.SELECTED) {
//				da.setChild("2~3��");
//			}
//
//		} else if (e.getSource() == rd2_2) {
//			if (e.getStateChange() == ItemEvent.SELECTED) {
//				da.setChild("3~4��");
//			}
//		} else if (e.getSource() == rd2_3) {
//			if (e.getStateChange() == ItemEvent.SELECTED) {
//				da.setChild("4~6��");
//			}
//		} else if (e.getSource() == rd2_4) {
//			if (e.getStateChange() == ItemEvent.SELECTED) {
//				da.setChild("7~10��");
//			}
//
//		} else if (e.getSource() == rd3_1) {
//			if (e.getStateChange() == ItemEvent.SELECTED) {
//				a = "�ǳ�";
//			}
//
//		} else if (e.getSource() == rd3_2) {
//			if (e.getStateChange() == ItemEvent.SELECTED) {
//				a = "�߿�";
//			}
//		} else if (e.getSource() == rd3_3) {
//			if (e.getStateChange() == ItemEvent.SELECTED) {
//				b = "��Ƽ��Ƽ";
//			}
//
//		} else if (e.getSource() == rd3_4) {
//			if (e.getStateChange() == ItemEvent.SELECTED) {
//				b = "�޽�";
//			}
//
//		}
//		da.setPrefer(a + " " + b);
//
//	}
//}
