package javaproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

import practice1.ActionListener; // �̰� �� �̷��� �ɱ�?

public class SignUp extends JFrame{ //����� �޾��ִ� ������?
	public SignUp() {
		
	JPanel panel = new JPanel();
	JLabel id = new JLabel("ID : ");
	JLabel pswrd = new JLabel("Passwrod : ");
	JTextField txtid = new JTextField(10); //���ڼ�
	JPasswordField txtpwd = new JPasswordField(10); //��й�ȣó�� ��ǥ�÷� ��
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
				if(Arrays.asList(Id).contains(txtid.getText())) { // �迭�ȿ� �� ���̵��� �ִ��� ������ 
					if(Id.get(i).equals(txtid.getText())) {
						if (Pass.get(i).equals(txtpwd.getText())) { //��й�ȣ�� �´��� �ٸ���
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

	
	add(panel); // �̰��� ���ִ� ������ �����Ӿȿ� �ִ°��ΰ�?
	
	setVisible(true);
	setSize(450,300);
	setLocationRelativeTo(null); // frame? panel�� ���������� �� ȭ�鿡���� ������� ��ġ
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	
	
	public static void main(String[] args) {
		new SignUp(); //���� Ŭ������ ��ӿ����� ���� ���� ���ذ� �ʿ��ҵ� �ʹ�.
		//new Login(); // ���⼭ �̷��� �����ص� �ȴ�.

	}

}

