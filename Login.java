package javaproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.*;

import practice1.ActionListener; // �̰� �� �̷��� �ɱ�?

public class Login extends JFrame{ //����� �޾��ִ� ������?
	public Login() {
		
	JPanel panel = new JPanel();
	JLabel id = new JLabel("ID : ");
	JLabel pswrd = new JLabel("Passwrod : ");
	JTextField txtid = new JTextField(10); //���ڼ�
	JPasswordField txtpwd = new JPasswordField(10); //��й�ȣó�� ��ǥ�÷� ��
	JButton logbtn = new JButton("Log in");
	
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
			String [] Id = new String[] {"Dan","Sang"}; // ���� �α��α�� �߰��� Arrlist<>�� �߰��ϸ�ɵ�
			String [] Pass = new String[] {"1234","0327"};
			
			//Arrays.asList(Id).contains(txtid.getText()) && Arrays.asList(Pass).contains(txtpwd.getText())
			//Id.equals(txtid.getText()) && Pass.equals(txtpwd.getText())
			
			int num = Id.length;
			for (int i = 0 ; i < num ; i++) {
				if(Arrays.asList(Id).contains(txtid.getText())) { // �迭�ȿ� �� ���̵��� �ִ��� ������ 
					if(Id[i].equals(txtid.getText())) {
						if (Pass[i].equals(txtpwd.getText())) { //��й�ȣ�� �´��� �ٸ���
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
					JOptionPane.showMessageDialog(null, "You failed to log in : not have");
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
		//JFrame frame = new JFrame();
		//frame.setVisible(true);
		//frame.setSize(450,300);
		//frame.setTitle("Log in");
		//frame.setLocationRelativeTo(null); // frame? panel�� ���������� �� ȭ�鿡���� ������� ��ġ
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new Login(); //���� Ŭ������ ��ӿ����� ���� ���� ���ذ� �ʿ��ҵ� �ʹ�.

	}

}
