package javaproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

import practice1.ActionListener; // 이게 왜 이렇게 될까?

public class SignUp extends JFrame{ //상속을 받아주는 이유는?
	public SignUp() {
		
	JPanel panel = new JPanel();
	JLabel id = new JLabel("ID : ");
	JLabel pswrd = new JLabel("Passwrod : ");
	JTextField txtid = new JTextField(10); //글자수
	JPasswordField txtpwd = new JPasswordField(10); //비밀번호처럼 별표시로 뜸
	JButton logbtn = new JButton("OK");
	
	panel.setLayout(null);
	
	id.setBounds(100, 50, 28, 25);
	pswrd.setBounds(56, 80, 80, 25);
	txtid.setBounds(133,52,116,24);
	txtpwd.setBounds(133, 80, 116, 24);
	logbtn.setBounds(263, 64, 105, 27);
	
	panel.add(id);
	panel.add(txtid);
	panel.add(pswrd);
	panel.add(txtpwd);
	panel.add(logbtn);

	logbtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ArrayList<String> Id  = new ArrayList<>(Arrays.asList("Dan","Sang"));
			ArrayList<String> Pass  = new ArrayList<>(Arrays.asList("1234","0327"));
				
			//Arrays.asList(Id).contains(txtid.getText()) && Arrays.asList(Pass).contains(txtpwd.getText())
			//Id.equals(txtid.getText()) && Pass.equals(txtpwd.getText())
			
			for (int i = 0 ; i < Id.size() ; i++) {
				if(Arrays.asList(Id).contains(txtid.getText())) { // 배열안에 그 아이디값이 있는지 없는지 
					if(Id.get(i).equals(txtid.getText())) {
						if (Pass.get(i).equals(txtpwd.getText())) { //비밀번호가 맞는지 다른지
							JOptionPane.showMessageDialog(null,"You have logged in successfully");
							break;
						}
						else {
							JOptionPane.showMessageDialog(null, "You failed to log in");
							break;
						}
					}
				}
				else { 
					JOptionPane.showMessageDialog(null, "You failed to log in");
					break;
				}
			}
		}
			
	});

	
	add(panel); // 이것을 해주는 이유는 프레임안에 넣는것인가?
	
	setVisible(true);
	setSize(450,300);
	setLocationRelativeTo(null); // frame? panel이 실행됬을때 내 화면에서의 상대적인 위치
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	
	
	public static void main(String[] args) {
		new SignUp(); //뭔가 클래스와 상속에대해 좀더 깊은 이해가 필요할듯 싶다.
		//new Login(); // 여기서 이렇게 선언해도 된다.

	}

}

