package test;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import insertMode.Data;
import insertMode.DataView;
import testmodel.ConnectPg;

public class ThirdPanel extends JPanel implements ActionListener {
	private Playground F;
	private JTable tableReview;
	ReviewTableModel rvtableModel;
	DataView dtv = new DataView();
	ConnectPg play;
	private JButton checkBtn, look;
	private JPanel p1, p2, p3;

	public ThirdPanel(Playground f) {
		F = f;
		rvtableModel = new ReviewTableModel();
		tableReview = new JTable(rvtableModel);
		tableReview.setModel(rvtableModel);

		// 테이블에 마우스 리스너 부착
		tableReview.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableReview.getSelectedRow(); // row 넘버
				int col = 0;
				String data = (String) tableReview.getValueAt(row, col);
				int no = Integer.parseInt(data);
				try {
					Data d = play.selectbyPK(no);
					selectbyPK(d);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			
		});

		// 테이블 패널 p1
		p1 = new JPanel();
		p1.add(new JScrollPane(tableReview), BorderLayout.CENTER);

		// 버튼 구성 p2
		p2 = new JPanel();
		p2.setLayout(new GridLayout(0, 3));
		p3 = new JPanel();

		// next ,priv button
		JButton priv = new JButton("이전");
		priv.addActionListener(this);
		checkBtn = new JButton("입력하기");
		checkBtn.addActionListener(this);

		look = new JButton("보기");
		look.addActionListener(this);
		// p3에 버튼 부착
		p3.add(priv);
		p3.add(checkBtn);
		p3.add(look);

		setLayout(new BorderLayout());
		add(p1, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);

		connectDB();

	}
	private void selectbyPK(Data d) {
		dtv.insertDate(d);
	}
	public void connectDB() {
		try {
			play = new ConnectPg();
			System.out.println("비디오 연결 성공");
		} catch (Exception e) {
			System.out.println("비디오 연결 실패");
		}

	}

	class ReviewTableModel extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] columnNames = {"번호", "이름", "가격", "종류", "리뷰", "평점" };

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columnNames.length;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public Object getValueAt(int row, int col) {
			ArrayList temp = (ArrayList) data.get(row);
			return temp.get(col);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("이전")) {
			F.getCardLayout().show(F.getContentPane(), "A2");
		} else if (str.equals("입력하기")) {
			
			dtv.setVisible(true);

		} else if (str.equals("보기")) {
			try {
				ArrayList data2 = play.insert2();
				rvtableModel.data = data2;
				tableReview.setModel(rvtableModel);
				rvtableModel.fireTableDataChanged();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}
