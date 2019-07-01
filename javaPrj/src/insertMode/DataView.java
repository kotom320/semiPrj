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
		setTitle("리뷰");
		setVisible(false);
		// p1 만들기
		p1_1 = new JPanel();
		p1_1.setLayout(new GridLayout(2, 4));

		lName = new JLabel("이름");
		lName.setHorizontalAlignment(Label.LEFT);
		lVicode = new JLabel("번호");
		lVicode.setHorizontalAlignment(Label.LEFT);
		lPrice = new JLabel("가격");
		lPrice.setHorizontalAlignment(Label.LEFT);
		lThem = new JLabel("종류");
		lThem.setHorizontalAlignment(Label.LEFT);
		lReview = new JLabel("리뷰");
		lReview.setHorizontalAlignment(Label.LEFT);
		lStar = new JLabel("평점");
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
		// p2 만들기

		p2 = new JPanel();

		bInsert = new JButton("입력");
		bModify = new JButton("수정");
		bDelete = new JButton("삭제");

		p2.add(bInsert);
		p2.add(bModify);
		p2.add(bDelete);
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
	}

	public void connectDB() {
		try {
			play = new ConnectPg();
			System.out.println("비디오 연결 성공");
		} catch (Exception e) {
			System.out.println("비디오 연결 실패");
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("입력")) {
			insertView();

		}if (str.equals("수정")) {
			modifyView();

		}if (str.equals("삭제")) {
			deleteView();

		}
	}

	private void deleteView() {
		int no = Integer.parseInt(tfvicode.getText());
		try {
			play.deleteData(no);
			JOptionPane.showMessageDialog(null, "삭제완료"); // 작은 창이 나옴
			tfvicode.setText(null);
			tfName.setText(null);
			tfPrice.setText(null);
			tfThem.setText(null);
			taReview.setText(null);
			tfStar.setText(null);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "삭제실패"); // 작은 창이 나옴
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
			JOptionPane.showMessageDialog(null, "수정완료"); // 작은 창이 나옴
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "수정실패"); // 작은 창이 나옴
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
			JOptionPane.showMessageDialog(null, "입력완료"); // 작은 창이 나옴

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "입력실패"); // 작은 창이 나옴
			e1.printStackTrace();
		}
	}

}
