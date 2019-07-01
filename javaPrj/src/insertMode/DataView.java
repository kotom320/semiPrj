package insertMode;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import test.Playground;
import test.ThirdPanel;
import testmodel.ConnectPg;

public class DataView extends JFrame implements ActionListener {
	private JLabel lVicode,lName, lPrice, lThem, lReview, lStar;
	private JTextField tfvicode,tfName, tfPrice, tfThem,  tfStar;
	private JTextArea taReview;
	private JButton bInsert, bModify, bDelete;
	private JPanel p1, p2 ,p1_1,p1_2,p1_3;
	ConnectPg play;

	public DataView() {
		addLayout();
		eventProc();
		connectDB();
		

	}

	public void insertDate(Data d) {
		tfvicode.setText(String.valueOf(d.getVicode()));
		tfName.setText(d.getName());
		tfPrice.setText(String.valueOf(d.getPrice()));
		tfThem.setText(d.getThem());
		taReview.setText(d.getReview());
		tfStar.setText(String.valueOf(d.getStar()));
	}

	private void eventProc() {
		bInsert.addActionListener(this);
		bModify.addActionListener(this);
		bDelete.addActionListener(this);
	}

	private void addLayout() {
		setSize(400, 400);
		setLocation(750, 250);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setTitle("����");
		setVisible(false);
		// p1 �����
		p1_1 = new JPanel();
		p1_1.setLayout(new GridLayout(2, 4));

		lName = new JLabel("�̸�");
		lName.setHorizontalAlignment(Label.LEFT);
		lVicode = new JLabel("��ȣ");
		lVicode.setHorizontalAlignment(Label.LEFT);
		lPrice = new JLabel("����");
		lPrice.setHorizontalAlignment(Label.LEFT);
		lThem = new JLabel("����");
		lThem.setHorizontalAlignment(Label.LEFT);
		lReview = new JLabel("����");
		lReview.setHorizontalAlignment(Label.LEFT);
		lStar = new JLabel("����");
		lStar.setHorizontalAlignment(Label.LEFT);

		tfvicode = new JTextField(10);
		tfvicode.setEnabled(false);
		tfName = new JTextField(10);
		tfPrice = new JTextField(10);
		tfThem = new JTextField(10);
	
		tfStar = new JTextField(10);
		taReview = new JTextArea();

		
		
		p1_1.add(lVicode);
		p1_1.add(tfvicode);
		p1_1.add(lName);
		p1_1.add(tfName);
		p1_1.add(lPrice);
		p1_1.add(tfPrice);
		p1_1.add(lThem);
		p1_1.add(tfThem);
		
		p1_2 = new JPanel();
		p1_2.setLayout(new BorderLayout());
		p1_2.add(lReview,BorderLayout.NORTH);
		p1_2.add(taReview,BorderLayout.CENTER);
		
		p1_3 = new JPanel();
		p1_3.setLayout(new GridLayout(0, 4));
		p1_3.add(lStar);
		p1_3.add(tfStar);
		
		p1= new JPanel();
		p1.setLayout(new BorderLayout());
		p1.add(p1_1,BorderLayout.NORTH);
		p1.add(p1_2,BorderLayout.CENTER);
		p1.add(p1_3,BorderLayout.SOUTH);
//		p1.add(lStar);
//		p1.add(tfStar);
//		p1.add(lReview);
//		p1.add(taReview);
		// p2 �����

		p2 = new JPanel();

		bInsert = new JButton("�Է�");
		bModify = new JButton("����");
		bDelete = new JButton("����");

		p2.add(bInsert);
		p2.add(bModify);
		p2.add(bDelete);
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
	}

	public void connectDB() {
		try {
			play = new ConnectPg();
			System.out.println("���� ���� ����");
		} catch (Exception e) {
			System.out.println("���� ���� ����");
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("�Է�")) {
			insertView();

		}if (str.equals("����")) {
			modifyView();

		}if (str.equals("����")) {
			deleteView();

		}
	}

	private void deleteView() {
		int no = Integer.parseInt(tfvicode.getText());
		try {
			play.deleteData(no);
			JOptionPane.showMessageDialog(null, "�����Ϸ�"); // ���� â�� ����
			tfvicode.setText(null);
			tfName.setText(null);
			tfPrice.setText(null);
			tfThem.setText(null);
			taReview.setText(null);
			tfStar.setText(null);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��������"); // ���� â�� ����
			e.printStackTrace();
		}
	}

	private void modifyView() {
		Data dat = new Data();
		dat.setVicode(Integer.parseInt(tfvicode.getText()));
		dat.setName(tfName.getText());
		dat.setPrice(Integer.parseInt(tfPrice.getText()));
		dat.setThem(tfThem.getText());
		dat.setReview(taReview.getText());
		dat.setStar(Integer.parseInt(tfStar.getText()));
		try {
			play.modifyData(dat);
			JOptionPane.showMessageDialog(null, "�����Ϸ�"); // ���� â�� ����
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��������"); // ���� â�� ����
			e.printStackTrace();
		}
	}

	private void insertView() {
		Data dat = new Data();
		dat.setName(tfName.getText());
		dat.setPrice(Integer.parseInt(tfPrice.getText()));
		dat.setThem(tfThem.getText());
		dat.setReview(taReview.getText());
		dat.setStar(Integer.parseInt(tfStar.getText()));

		try {
			play.insertData(dat);
			JOptionPane.showMessageDialog(null, "�Է¿Ϸ�"); // ���� â�� ����

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "�Է½���"); // ���� â�� ����
			e1.printStackTrace();
		}
	}

}
