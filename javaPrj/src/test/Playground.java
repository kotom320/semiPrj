package test;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;

public class Playground extends JFrame {

	private CardLayout card = new CardLayout();
	
	public Playground() {
		super("우리동네놀이터");
		setSize(500, 500);
		setLocation(200, 200);
		getContentPane().setLayout(card);

		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add("A2", new SecondPanel(this));
		getContentPane().add("A3", new ThirdPanel(this));

		setVisible(false);

	}

	public CardLayout getCardLayout() {
		return card;
	}
	public static void main(String[] args) {
		new Login();
	}

}
