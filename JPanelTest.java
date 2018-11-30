package javaproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.*;

import javaproject.JPanel02.MyActionListener;




class JPanel01 extends JPanel{
	private JTextField textField ;
	private JPasswordField passwordField;
	private JPanelTest win;
	
	public JPanel01(JPanelTest win) {
		setLayout(null);
		this.win = win;
		JLabel id = new JLabel("아이디  ");
		id.setBounds(85,50,50,25);
		add(id);
		
		textField = new JTextField();
		textField.setBounds(133,52,116,24);
		add(textField);
		textField.setColumns(10);
		
		JLabel pswrd = new JLabel("암호  ");
		pswrd.setBounds(85,80,80,25);
		add(pswrd);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(133,80,116,24);
		add(passwordField);
		
		JButton btn = new JButton("로그인");
		btn.setSize(85,20);
		btn.setLocation(263,54);
		add(btn);
		btn.addActionListener(new MyActionListener());
		
		JButton btn_1 = new JButton("회원가입"); 
		btn_1.setSize(85,20);
		btn_1.setLocation(263, 84);
		add(btn_1);
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("panel02");
			}
		});
}
	class MyActionListener implements ActionListener{
		ArrayList<String> Id  = new ArrayList<>(Arrays.asList("Dan","Sang")); //Arrays.asList는 무엇을 의미하는가?
		ArrayList<String> Pass  = new ArrayList<>(Arrays.asList("1234","0327")); // 전역변수로 만들어야 회원가입이 될듯 
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//win.change("panel01"); 패널 교체
			
			for (int i = 0 ; i < Id.size() ; i++) {
				if(Id.contains(textField.getText())) { // 배열안에 그 아이디값이 있는지 없는지 
					if(Id.get(i).equals(textField.getText())) {
						if (Pass.get(i).equals(passwordField.getText())) { //비밀번호가 맞는지 다른지
							JOptionPane.showMessageDialog(null,"You have logged in successfully");
							break;
						}
						else {
							JOptionPane.showMessageDialog(null, "You failed to log in");
							break;
						}
					}
					else ;
				}
				else { 
					JOptionPane.showMessageDialog(null, "This Id not exists");
					break;
				}
			}
		}
			
	}
		
}

class JPanel02 extends JPanel{
	private JTextField textField ;
	private JPasswordField passwordField;
	private JPanelTest win;
	
	public JPanel02 (JPanelTest win) {
		setLayout(null);
		this.win = win;
		JLabel id = new JLabel("아이디  ");
		id.setBounds(85,50,50,25);
		add(id);
		
		textField = new JTextField();
		textField.setBounds(133,52,116,24);
		add(textField);
		textField.setColumns(10);
		
		JLabel pswrd = new JLabel("암호  ");
		pswrd.setBounds(85,80,80,25);
		add(pswrd);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(133,80,116,24);
		add(passwordField);
		
		JButton btn = new JButton("회원가입");
		btn.setSize(85,20);
		btn.setLocation(263,54);
		add(btn);
		btn.addActionListener(new MyActionListener());
		
		JButton btn_1 = new JButton("돌아가기"); 
		btn_1.setSize(85,20);
		btn_1.setLocation(263, 84);
		add(btn_1);
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("panel01");
			}
		});
		btn.addActionListener(new MyActionListener());
	}
	class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			//win.change("panel02");
			ArrayList<String> Id  = new ArrayList<>(Arrays.asList("Dan","Sang"));
			ArrayList<String> Pass  = new ArrayList<>(Arrays.asList("1234","0327"));
				
			//Arrays.asList(Id).contains(txtid.getText()) && Arrays.asList(Pass).contains(txtpwd.getText())
			//Id.equals(txtid.getText()) && Pass.equals(txtpwd.getText())
			
			for (int i = 0 ; i < Id.size() ; i++) {
				if(Id.contains(textField.getText())) { // 배열안에 그 아이디값이 있는지 없는지 
					JOptionPane.showMessageDialog(null, "This Id already exists ");
					break;
				}
				else { 

					Id.add(textField.getText());
					Pass.add(passwordField.getText());
					break;
				}
			}
		}
			
	}
		
}



class JPanelTest extends JFrame{
	public JPanel jpanel01 = null;
	public JPanel jpanel02 = null;
	
	public void change(String panelName) {
		
		if(panelName.equals("panel01")) {
			getContentPane().removeAll();
			getContentPane().add(jpanel01);
			revalidate();
			repaint();
		}else {	
			getContentPane().removeAll();
			getContentPane().add(jpanel02);
			revalidate();
			repaint();
		}
	}
	public static void main(String[] args) {
		JPanelTest win = new JPanelTest();
		
		win.setTitle("frame test");
		win.jpanel01 = new JPanel01(win);
		win.jpanel02 = new JPanel02(win);
		
		win.add(win.jpanel01);
		win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		win.setSize(450,300);
		win.setVisible(true);
	}
}

