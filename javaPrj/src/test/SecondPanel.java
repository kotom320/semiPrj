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
	// �ǳ� ��Ƽ��Ƽ

	private JComboBox place;
	private JTextArea taExp;

	private JPanel p1, p2, p3;
	private JButton b1, b2, b3;
	private JCheckBox chb1, chb2;
	boolean check1 = true, check2 = true, check3 = true;
	private String[] cafe = { "Ű��ī��", "��Ż��ī��" };
	private String[] pool = { "��õ������", "ȣ�ڼ�����" };
	private String[] park = { "�����", "����" };
	private Playground F;
	private String  comb;

	ArrayList list;

	public SecondPanel(Playground f) {

		F = f;
		list = new ArrayList();

		b1 = new JButton("ī��");
		b1.addActionListener(this); // b1�� ������ �ޱ�
		b2 = new JButton("������");
		b2.addActionListener(this); // b2�� ������ �ޱ�
		b3 = new JButton("����");
		b3.addActionListener(this); // b3�� ������ �ޱ�

		// p1�����
		p1 = new JPanel();

		Object[] temp = list.toArray(new String[list.size()]);

		place = new JComboBox(temp);
		place.addItemListener(this);

		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(place);

		// p2 �����
		p2 = new JPanel();
		taExp = new JTextArea(20, 20);
		taExp.setText("����");
		taExp.setEditable(false);
		p2.add(taExp);

		// p3 �����
		p3 = new JPanel();

		// next ,priv button
		JButton next = new JButton("����");
		next.addActionListener(this);

		// p3�� ��ư ����
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
		if (str.equals("����")) {
			F.getCardLayout().show(F.getContentPane(), "A3");

		} else if (str.equals("������")) {

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
		} else if (str.equals("ī��")) {
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
		} else if (str.equals("����")) {
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
		if (e.getItem() == "ȣ�ڼ�����") {
			taExp.setText("ȣ�ڼ����忡 ���Ű��� ȯ���մϴ�.");

		} else if (e.getItem() == "��õ������") {
			taExp.setText("��õ�����忡 ���Ű��� ȯ���մϴ�.");

		} else if (e.getItem() == "Ű��ī��") {
			taExp.setText("Ű��ī�信 ���Ű��� ȯ���մϴ�.");

		} else if (e.getItem() == "��Ż��ī��") {
			taExp.setText("��Ż��ī�信 ���Ű��� ȯ���մϴ�.");

		} else if (e.getItem() == "�����") {
			taExp.setText("������� ���Ű��� ȯ���մϴ�.");

		} else if (e.getItem() == "����") {
			taExp.setText("������ ���Ű��� ȯ���մϴ�.");

		}
	}

	

}
