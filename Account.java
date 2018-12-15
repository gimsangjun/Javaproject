package Accountdemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

class Login_panel extends JPanel
{	
	JButton list = new JButton("����ڵ�") ; // login_panel
	JButton member_move = new JButton("ȸ������"); //login_panel
	JButton login = new JButton("�α���"); //login_panel
	JButton trans_button = new JButton("�ŷ�����"); //login_panel
	
	JLabel id_login = new JLabel("���̵�  "); //login_panel
	JLabel pswrd_login = new JLabel("��ȣ  "); //login_panel
	
	public Account frame ;
	public ArrayList<String> Id ; //Arrays.asList�� ������ �ǹ��ϴ°�?
	public ArrayList<String> Pass  ; // ���������� ������ ȸ�������� �ɵ� 
	public ArrayList<Integer> money ; // ���� �ݾ� 
	JLabel user_name ; // account_panel
	JLabel current_account ;
	JTextArea lists ;
	JTextField idfield_login ;
	JPasswordField passwordfield_login ;
	
	
	public Login_panel(Account frame)
	{	
		this.frame = frame;
		this.Id = frame.Id;
		this.Pass = frame.Pass;
		this.money = frame.money;
		this.user_name = frame.user_name;
		this.current_account = frame.current_account;
		this.lists = frame.lists ;
		this.idfield_login = frame.idfield_login;
		this.passwordfield_login = frame.passwordfield_login;
		
		setLayout(null);
		setSize(450, 300);
		
		id_login.setBounds(65,50,50,25); //��
		add(id_login); //�гο� �߰�
		
		pswrd_login.setBounds(65,80,80,25); //��
		add(pswrd_login);  //�гο� �߰�
		
		idfield_login.setBounds(113,52,116,24); //�ؽ�Ʈ�ʵ�
		add(idfield_login); //�гο� �߰�
		idfield_login.setColumns(10);
		
		passwordfield_login.setBounds(113,80,116,24); // �ؽ�Ʈ�ʵ�
		add(passwordfield_login); //�гο� �߰�
		passwordfield_login.setColumns(10);
		
		login.setSize(85,20); //��ư
		login.setLocation(243,54);
		add(login); //�гο� �߰�
		
		member_move.setSize(85,20); //��ư
		member_move.setLocation(243, 84);
		add(member_move); //�гο� �߰�
		
		trans_button.setSize(85,20); // �ֱٰŷ����� ��ư
		trans_button.setLocation(243,114);
		add(trans_button);
		
		list.setSize(85,20); //� ����ڵ��� �ֳ� �����ִ� panel�� �̵��ϴ� ��ư
		list.setLocation(340, 54);
		add(list);
		
		// ��� ������ ��ü�� ����� �� ���� ���� ��ü���� ��� �����ʷ� ����Ѵ�
		ButtonListener listener = new ButtonListener();
        login.addActionListener(listener);
        member_move.addActionListener(listener);
        trans_button.addActionListener(listener);
        list.addActionListener(listener);
        setVisible(true);
		
	}
	class ButtonListener implements ActionListener
	{	
		@Override
		public void actionPerformed(ActionEvent event) 
		{
			if (event.getSource() == login)	
			{
				for (int i = 0 ; i < Id.size() ; i++) 
				{
					if(Id.contains(idfield_login.getText())) // �迭�ȿ� �� ���̵��� �ִ��� ������ 
					{ 
						if(Id.get(i).equals(idfield_login.getText())) 
						{
							if (Pass.get(i).equals(passwordfield_login.getText()))
							{ //��й�ȣ�� �´��� �ٸ���
								user_name.setText(Id.get(i)); // �̺κ� �߿� 
								current_account.setText(Integer.toString(money.get(i))); // string�� �����ϹǷ� 
								
								frame.change("account_panel");
								
							}
							else 
							{
								JOptionPane.showMessageDialog(null, " �α��ο� �����Ͽ����ϴ�. ");
								break;
							}
						}
					}
					else
					{ 
						JOptionPane.showMessageDialog(null, " �� ���̵�� ���������ʽ��ϴ�. ");
						break;
					}
				}
			}
			else if(event.getSource()== member_move) //member_move�������� member_panel���� �̵�.
			{	
				frame.change("member_panel");

			}
			else if (event.getSource() == trans_button) // �ֱٰŷ����� ��ȸ
			{
				frame.change("trans_panel");

			}
			else if (event.getSource() == list) // ����ڸ�� �����ִ� �гη� �̵�	
			{	
				lists.setText("");
				for (int i = 0 ; i < Id.size() ; i++)
				{
					lists.append(Id.get(i) + " �� �ܾ��� " + money.get(i) + "�� �Դϴ�\n");
				}
				frame.change("list_panel");

			}
			
		}
	}
		
}

class Member_panel extends JPanel
{	
	
	JTextField idfield_member = new JTextField() ;
	JPasswordField passwordfield_member = new JPasswordField();
	
	JButton member_join = new JButton("ȸ������"); //member_panel
	JButton back = new JButton("���ư���"); //member_panel
	JButton member_out = new JButton("ȸ��Ż��"); //member_panel
	
	JLabel id_member = new JLabel("���̵�  "); // member_panel
	JLabel pswrd_member = new JLabel("��ȣ  "); //member_panel
	
	public Account frame;
	public ArrayList<String> Id ; //Arrays.asList�� ������ �ǹ��ϴ°�?
	public ArrayList<String> Pass  ; // ���������� ������ ȸ�������� �ɵ� 
	public ArrayList<Integer> money ; // ���� �ݾ� 
	JTextField idfield_login;
	JPasswordField passwordfield_login ;
	
	public Member_panel(Account frame)
	{	
		this.frame = frame;
		this.Id = frame.Id;
		this.Pass = frame.Pass;
		this.money = frame.money;
		this.idfield_login = frame.idfield_login;
		this.passwordfield_login = frame.passwordfield_login;
		
		setLayout(null);
		setSize(450, 300);
		
		id_member.setBounds(65,50,50,25); //��
		add(id_member); //�гο� �߰�
		
		pswrd_member.setBounds(65,80,80,25); //��
		add(pswrd_member); //��ο� �߰�
		
		idfield_member.setBounds(113,52,116,24); //�ؽ�Ʈ�ʵ�
		add(idfield_member); //�гο� �߰�
		idfield_member.setColumns(10); 
		
		passwordfield_member.setBounds(113,80,116,24); // �ؽ�Ʈ�ʵ�
		add(passwordfield_member); //�гο� �߰�
		passwordfield_member.setColumns(10);

		member_join.setSize(85,20); //ȸ�����Թ�ư
		member_join.setLocation(243,54);
		add(member_join); //�гο� �߰�
		
		member_out.setSize(85,20); //ȸ��Ż���ư
		member_out.setLocation(243,84);
		add(member_out); //��ο� �߰�
		
		back.setSize(85,20); //�ڷΰ����ư
		back.setLocation(243,114);
		add(back); //�гο� �߰�
		
		// ��� ������ ��ü�� ����� �� ���� ���� ��ü���� ��� �����ʷ� ����Ѵ�
		ButtonListener listener = new ButtonListener();
		back.addActionListener(listener); // �Ϸ� 
		member_join.addActionListener(listener); // �Ϸ� 
		member_out.addActionListener(listener); // ���� ��ư�� �̺�Ʈ �߻��� ���� �ʾ���.
		
		setVisible(false);
		
		
	}
	class ButtonListener implements ActionListener
	{	
		@Override
		public void actionPerformed(ActionEvent event) 
		{
			if (event.getSource() == back) // back�������� , member_panel���� login_panel�� �̵�
			{	
				//member_panel.setVisible(false);
				//login_panel.setVisible(true);
				frame.change("login_panel");
			}
			else if (event.getSource() == member_join ) //ȸ������ ��ư
			{	
				for (int i = 0 ; i < Id.size() ; i++) 
				{
					if(Id.contains(idfield_member.getText())) // �迭�ȿ� �� ���̵��� �ִ��� ������ 
					{ 
						JOptionPane.showMessageDialog(null, " �̹� �����ϴ� ���̵��Դϴ�. ");
						break;
					}
					else 
					{ 
						Id.add(idfield_member.getText());
						Pass.add(passwordfield_member.getText());
						money.add(0); // ���̵� ���������Ƿ�, 
						JOptionPane.showMessageDialog(null, " ȸ�������� �Ǿ����ϴ�. ");
						break;
					}
				}
			}
			else if ( event.getSource() == member_out ) //ȸ��Ż�� 
			{	
				for (int i = 0 ; i < Id.size() ; i++) 
				{
					if(Id.get(i).equals(idfield_login.getText())) 
					{
						if (Pass.get(i).equals(passwordfield_login.getText()))
						{ //��й�ȣ�� �´��� �ٸ���
							Id.remove(i); 
							Pass.remove(i);
							money.remove(i);
							JOptionPane.showMessageDialog(null, " ȸ�� Ż�� �Ǿ����ϴ�. ");
							break;
						}
						else 
						{
							JOptionPane.showMessageDialog(null, " ��й�ȣ�� ��ġ���� �ʽ��ϴ�. ");
							break;
						}
					}
				}
			}
		}
	}
}

class Account_panel extends JPanel 
{	
	
	JLabel user = new JLabel ("�����"); //account_panel
	
	JLabel current_account_msg = new JLabel("���ܾ� "); //account_panel
	 // account_panel
	JLabel money_account = new JLabel("�ݾ�"); // account_panel
	
	JButton back_1 = new JButton("�ڷ�"); // account_panel
	JButton plus = new JButton("�Ա�"); // account_panel
	JButton minus = new JButton("���"); // account_panel
	JButton withdraw = new JButton("��ü"); // account_panel
	
	JTextField account = new JTextField() ; // account_panel, ��������� �ݾ��� �Է¹��������� 
	
	public Account frame ;
	public ArrayList<String> Id ; //Arrays.asList�� ������ �ǹ��ϴ°�?
	public ArrayList<String> Pass  ; // ���������� ������ ȸ�������� �ɵ� 
	public ArrayList<Integer> money ; // ���� �ݾ� 
	JLabel user_name ; // account_panel
	JTextField idfield_login;
	JTextArea trans ; // �ֱ� �ŷ����� �����Ұ� 
	JLabel current_account ;
	
	public Account_panel(Account frame)
	{
		this.frame = frame;
		this.Id = frame.Id;
		this.Pass = frame.Pass;
		this.money = frame.money;
		this.user_name =frame.user_name;
		this.idfield_login = frame.idfield_login;
		this.trans= frame.trans;
		this.current_account = frame.current_account;
		
		setLayout(null);
		setSize(450, 300);
	
		user.setBounds(65,20,50,25); //�� ,���� ����ڴ� �����ΰ�? user 
		add(user); //�гο� �߰�
		
		money_account.setBounds(65,80,80,25);
		add(money_account);
		
		user_name.setBounds(113, 20, 116, 24); //�� , ���� ����ϴ� ���: Sang
		add(user_name);
		
		current_account_msg.setBounds(65, 50, 50, 25); // ���ܾ�
		add(current_account_msg);
		
		current_account.setBounds(113,50,116,24); //���
		add(current_account);
		
		account.setBounds(113,80,116,24); // /�ݾ��Է��ϴ� �ؽ�Ʈ�ʵ�
		add(account); //�гο� �߰�
		account.setColumns(10);

		plus.setSize(85,20); //�Աݹ�ư
		plus.setLocation(243,54);
		add(plus); //�гο� �߰� 
		
		minus.setSize(85,20); // ��ݹ�ư
		minus.setLocation(243,84);
		add(minus); //�гο� �߰�
		
		withdraw.setSize(85,20); // ���ݹ�ư
		withdraw.setLocation(340,54);
		add(withdraw); //�гο� �߰�
		
		back_1.setSize(85,20); // �ڷ� ��ư
		back_1.setLocation(340,84);
		add(back_1); //�гο� �߰�
		
		// ��� ������ ��ü�� ����� �� ���� ���� ��ü���� ��� �����ʷ� ����Ѵ�
		ButtonListener listener = new ButtonListener(); // ���� �̺�Ʈ�� ����� ���� �ʾ���.
		plus.addActionListener(listener);
		minus.addActionListener(listener);
		withdraw.addActionListener(listener);
		back_1.addActionListener(listener);
		
		setVisible(false);
		
	}
	
	public boolean isNumeric(String s) { // �������� ���ڿ����� �Ǵ��ϴ� �޼ҵ�
		  try {
		      Double.parseDouble(s);
		      return true;
		  } catch(NumberFormatException e) {
		      return false;
		  }
	}
	
	class ButtonListener implements ActionListener
	{	
		@Override
		public void actionPerformed(ActionEvent event) 
		{
			if (event.getSource() == plus)
			{
				if(isNumeric(account.getText()) == true)
				{
					for (int i = 0 ; i < Id.size() ; i++) // ���° �ε��� ���� Ȯ��
					{
						if(Id.get(i).equals(idfield_login.getText()))  // �迭�ȿ� �� ���̵��� �ִ��� ������ 
						{ 	
							int m = money.get(i);
							int n = Integer.parseInt(account.getText()); // string�� ���� ���������� ��ȯ 
							m = m + n ;
							money.set(i,m); //Ư�� �ε��� �� m���� ����
							trans.append(Id.get(i) + " ���� " + n + " ���� �ԱݵǾ����ϴ�. \n");
							current_account.setText(Integer.toString(money.get(i))); // ���������� �����ִ� label�� text�� ��������.
							JOptionPane.showMessageDialog(null,"�����ܾ�  : "+ m + " ��"); // �̷������� ���� �ִ�.
							break;
						}
							
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"�߸��� �Է��Դϴ�. ");
				}
			}
			else if (event.getSource() == minus)
			{	
				if(isNumeric(account.getText()) == true) // �������� ���ڿ����� Ȯ�� 
				{
					for (int i = 0 ; i < Id.size() ; i++) // ���° �ε��� ���� Ȯ��
						{
							if(Id.get(i).equals(idfield_login.getText()))  // �迭�ȿ� �� ���̵��� �ִ��� ������ 
							{ 	
								int m = money.get(i);
								int n = Integer.parseInt(account.getText()); // string�� ���� ���������� ��ȯ 
								m = m - n ;
								if ( m < 0 )
								{
									JOptionPane.showMessageDialog(null,"���� �����մϴ�.");
									break;
								}
								money.set(i,m); //Ư�� �ε��� �� m���� ����
								trans.append(Id.get(i) + " ���� " + n + " ���� ��ݵǾ����ϴ�.\n ");
								current_account.setText(Integer.toString(money.get(i))); // ���������� �����ִ� label�� text�� ��������.
								JOptionPane.showMessageDialog(null,"�����ܾ�  : "+ m + " ��"); // �̷������� ���� �ִ�.
								break;
							}
								
						}
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"�߸��� �Է��Դϴ�. ");
				}
			}
			else if (event.getSource() == withdraw) //��ü
			{
				if(isNumeric(account.getText()) == true) // �������� ,���ڿ����� Ȯ��
				{	
					String who = JOptionPane.showInputDialog(" �������� ��ü�Ͻðڽ��ϱ�? ");
					if(Id.contains(who)) // who��� ����� Id�� �ִ��� Ȯ�� 
					{
						for (int i = 0 ; i < Id.size() ; i++) // ���° �ε��� ���� Ȯ��
						{	
		
							if(Id.get(i).equals(who));  // �迭�ȿ� �� ���̵��� �ִ��� ������ 
							{ 	
								int m = money.get(i); //�޴� ����� ��
								int n = Integer.parseInt(account.getText()); // string�� ���� ���������� ��ȯ 
								money.set(i,m+n); //�� ��������� ���� �÷���
								for (int a = 0 ; a < Id.size() ; a++) // ���° �ε��� ���� Ȯ��
								{
									if(Id.get(a).equals(idfield_login.getText())) //���� ������� ã��
									{ 	
										int b = money.get(a); // ������ ����� ��
										b = b - n;
										if ( b < 0 )
										{
											JOptionPane.showMessageDialog(null,"���� �����մϴ�.");
											break;
										}
										money.set(a,b); //Ư�� �ε��� �� m���� ����
										trans.append(Id.get(a) + " ��/�� ");
										current_account.setText(Integer.toString(money.get(a))); // ���������� �����ִ� label�� text�� ��������.
										break;
									}
										
								}
								trans.append(Id.get(i) + " ���� " + n + " ���� ��ü�Ͽ����ϴ�.\n ");
								break;
							}		
						}
					}
					else //who��� ����� ������ �޼��� ��� 
					{
						JOptionPane.showMessageDialog(null,"���� ����� �Դϴ�.");
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"�߸��� �Է��Դϴ�. ");
				}
			}
			else if (event.getSource() == back_1) // account_panel���� login_panel�� �̵�
			{
				frame.change("login_panel");
			}
		}
	}
}

class Trans_panel extends JPanel
{	
	
	JButton back_2 = new JButton("���ư���"); // trans_panel
	
	
	public Account frame ;
	JTextArea trans ; // �ֱ� �ŷ����� �����Ұ� 
	
	public Trans_panel(Account frame) // ���� ���� �߰��ؾ��ҵ�
	{	
		this.frame = frame;
		this.trans = frame.trans; // �ֱ� �ŷ����� �����Ұ� 
		
		setLayout(null);
		setSize(450, 300);
		
		trans.setBounds(0, 0, 335, 300);
		add(trans);
		
		back_2.setSize(85,20); //�ڷΰ��� ��ư
		back_2.setLocation(345,10);
		add(back_2); //�гο� �߰�
		
		ButtonListener listener = new ButtonListener();
		back_2.addActionListener(listener);
		setVisible(false);
	}
	class ButtonListener implements ActionListener
	{	
		@Override
		public void actionPerformed(ActionEvent event) 
		{
			if (event.getSource() == back_2 ) // �ֱٰŷ����� �гο��� �α����гη� ���ư���
			{
				frame.change("login_panel");
			}
		}
	}
}
	

class List_panel extends JPanel
{	
	
	JButton back_3 = new JButton("���ư���"); //list_panel
	public Account frame ;
	JTextArea lists ; // � ����ڵ� �ֳ� �����ִ� lists
	
	public List_panel(Account frame)
	{
		this.frame= frame;
		this.lists = frame.lists;
		
		setLayout(null);
		setSize(450, 300);
		
		lists.setBounds(0, 0, 335, 300); //TextField 
		add(lists);
		
		back_3.setSize(85,20); //�ڷΰ��� ��ư
		back_3.setLocation(345,10);
		add(back_3);//�гο� �߰�
		
		ButtonListener listener = new ButtonListener();
		back_3.addActionListener(listener);
		setVisible(false);
	}
	class ButtonListener implements ActionListener
	{	
		@Override
		public void actionPerformed(ActionEvent event) 
		{
			if (event.getSource() == back_3 )
			{
				frame.change("login_panel");
			}
		}
	}
}


public class Account extends JFrame //extends JFrame�� Ȱ���ϴ� ���, �������� �г��� ���� �ϰ������
{ 
	ArrayList<String> Id  = new ArrayList<>(Arrays.asList("Sang","Park")); //Arrays.asList�� ������ �ǹ��ϴ°�?
	ArrayList<String> Pass  = new ArrayList<>(Arrays.asList("0327","1234")); // ���������� ������ ȸ�������� �ɵ� 
	ArrayList<Integer> money  = new ArrayList<>(Arrays.asList(10000,50000)); // ���� �ݾ� 
	
	public JPanel login_panel = null;
	public JPanel member_panel = null ;
	public JPanel account_panel = null;
	public JPanel trans_panel = null;
	public JPanel list_panel = null ;
	
	JLabel user_name = new JLabel ("����� �̸�");
	int i = 0 ; //list�� ����� �ε����� ���ϳ�
	JLabel current_account = new JLabel("���");
	JTextArea lists = new JTextArea();
	JTextField idfield_login = new JTextField() ;
	JPasswordField passwordfield_login = new JPasswordField();
	JTextArea trans = new JTextArea(); // �ֱ� �ŷ����� �����Ұ� 
	
	public void change(String name) // panel�� ��ü���ִ� �Լ�
	{
		if(name.equals("account_panel")) //�α�����ο��� account�гη� �̵�
		{
			login_panel.setVisible(false);
			account_panel.setVisible(true);
		}
		else if (name.equals("member_panel")) //�α����гο��� ����гη� �̵� 
		{
			login_panel.setVisible(false);
			member_panel.setVisible(true);
		}
		else if  (name.equals("login_panel"))
		{
			account_panel.setVisible(false);
			member_panel.setVisible(false);
			trans_panel.setVisible(false);
			list_panel.setVisible(false);
			login_panel.setVisible(true);
		}
		else if  (name.equals("trans_panel"))
		{
			login_panel.setVisible(false);
			trans_panel.setVisible(true);
		}
		else if (name.equals("list_panel"))
		{
			login_panel.setVisible(false);
			list_panel.setVisible(true);
		}
	}

	public static void main (String[] args)
    {
		Account frame = new Account();
		frame.setTitle("account");
		frame.login_panel = new Login_panel(frame);
		frame.member_panel = new Member_panel(frame);
		frame.account_panel = new Account_panel(frame);
		frame.trans_panel = new Trans_panel(frame);
		frame.list_panel = new List_panel(frame);
		
		frame.add(frame.login_panel);
		frame.add(frame.member_panel);
		frame.add(frame.account_panel);
		frame.add(frame.trans_panel);
		frame.add(frame.list_panel);
		
		frame.setSize(450,300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
    }
}
