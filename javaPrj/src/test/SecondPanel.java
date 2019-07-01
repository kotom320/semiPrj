package test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import insertMode.Data;

public class SecondPanel extends JPanel implements ActionListener, ItemListener {
	// 실내 엑티비티

	private JComboBox place;
	private JTextArea taExp;

	private JPanel p1, p2, p3;
	private JButton b1, b2, b3;
	private JCheckBox chb1, chb2;
	boolean check1 = true, check2 = true, check3 = true;
	private String[] cafe = { "키즈카페", "방탈출카페" };
	private String[] pool = { "온천수영장", "호텔수영장" };
	private String[] park = { "수목원", "공원" };
	private Playground F;
	private String  comb;

	ArrayList list;

	public SecondPanel(Playground f) {

		F = f;
		list = new ArrayList();

		b1 = new JButton("카페");
		b1.addActionListener(this); // b1에 리스너 달기
		b2 = new JButton("수영장");
		b2.addActionListener(this); // b2에 리스너 달기
		b3 = new JButton("공원");
		b3.addActionListener(this); // b3에 리스너 달기

		// p1만들기
		p1 = new JPanel();

		Object[] temp = list.toArray(new String[list.size()]);

		place = new JComboBox(temp);
		place.addItemListener(this);

		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(place);

		// p2 만들기
		p2 = new JPanel();
		taExp = new JTextArea(20, 20);
		taExp.setText("설명");
		taExp.setEditable(false);
		p2.add(taExp);

		// p3 만들기
		p3 = new JPanel();

		// next ,priv button
		JButton next = new JButton("다음");
		next.addActionListener(this);

		// p3에 버튼 부착
		p3.add(next);

		// secondpanel
		setLayout(new BorderLayout());
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("다음")) {
			F.getCardLayout().show(F.getContentPane(), "A3");

		} else if (str.equals("수영장")) {

			while (check1) {
				ArrayList l2 = new ArrayList();
				for (String l : pool) {

					l2.add(l);

				}
				Object[] temp2 = l2.toArray(new String[l2.size()]);

				for (int i = 0; i < temp2.length; i++) {
					place.addItem(temp2[i]);
				}
				check1 = false;
			}
		} else if (str.equals("카페")) {
			while (check2) {
				ArrayList l2 = new ArrayList();
				for (String l : cafe) {

					l2.add(l);

				}
				Object[] temp2 = l2.toArray(new String[l2.size()]);

				for (int i = 0; i < temp2.length; i++) {
					place.addItem(temp2[i]);
				}
				check2 = false;
			}
		} else if (str.equals("공원")) {
			while (check3) {
				ArrayList l2 = new ArrayList();
				for (String l : park) {

					l2.add(l);

				}
				Object[] temp2 = l2.toArray(new String[l2.size()]);

				for (int i = 0; i < temp2.length; i++) {
					place.addItem(temp2[i]);
				}
				check3 = false;
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getItem() == "호텔수영장") {
			taExp.setText("호텔수영장에 오신것을 환영합니다.");

		} else if (e.getItem() == "온천수영장") {
			taExp.setText("온천수영장에 오신것을 환영합니다.");

		} else if (e.getItem() == "키즈카페") {
			taExp.setText("키즈카페에 오신것을 환영합니다.");

		} else if (e.getItem() == "방탈출카페") {
			taExp.setText("방탈출카페에 오신것을 환영합니다.");

		} else if (e.getItem() == "수목원") {
			taExp.setText("수목원에 오신것을 환영합니다.");

		} else if (e.getItem() == "공원") {
			taExp.setText("공원에 오신것을 환영합니다.");

		}
	}

	

}
