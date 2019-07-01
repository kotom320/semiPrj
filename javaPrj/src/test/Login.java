package test;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import insertMode.Data;
import testmodel.ConnectPg;

public class Login extends JFrame implements ActionListener {

	Playground pg = new Playground();
	SecondPanel sp;
	ConnectPg con;
	private JPanel main;
	private JLabel lbName, lbPass;
	private JTextField tfName, tfPass;
	private JButton lgBtn, signBtn;
	String[] idpass;

	public Login() {
		setSize(350, 90);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(200, 200);
		setTitle("Login");

		setVisible(true);
		main = new JPanel();

		lbName = new JLabel("아이디");
		lbPass = new JLabel("암호");

		tfName = new JTextField(10);
		tfPass = new JTextField(10);
		tfPass.addActionListener(this);

		lgBtn = new JButton("login");
		lgBtn.addActionListener(this);

		signBtn = new JButton("Sign UP");
		signBtn.addActionListener(this);

		main.add(lbName);
		main.add(tfName);

		main.add(lbPass);
		main.add(tfPass);

		main.add(signBtn);
		main.add(lgBtn);

		add(main);
		connectDB();

	}

	private void connectDB() {
		try {
			con = new ConnectPg();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == lgBtn||e.getSource()==tfPass) {

			loginKey();

		}
		if (e.getSource() == signBtn) {
			Member mb = new Member();
			mb.setVisible(true);
		}
	}

	private void loginKey() {
		try {
			idpass = con.loginIdPass(tfName.getText());
			if ((idpass[0].equals(tfName.getText())) && (idpass[1].equals(tfPass.getText()))) {
				JOptionPane.showMessageDialog(null, "Succeed Login");

				pg.setVisible(true);
				this.setVisible(false);

			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Login Failed");
		}

	}

	
}
