import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;


public class Account //extends JFrame�� Ȱ���ϴ� ���, �������� �г��� ���� �ϰ������
{ 
	JTextField idfield_login = new JTextField() ;
	JPasswordField passwordfield_login = new JPasswordField();
	JTextField idfield_member = new JTextField() ;
	JPasswordField passwordfield_member = new JPasswordField();
	JTextField account = new JTextField() ; // account_panel, ��������� �ݾ��� �Է¹��������� 
	
	JButton login = new JButton("�α���"); //login_panel
	JButton member_join = new JButton("ȸ������"); //member_panel
	JButton member_move = new JButton("ȸ������"); //login_panel
	JButton back = new JButton("���ư���"); //member_panel
	JButton back_1 = new JButton("�ڷ�"); // account_panel
	JButton back_2 = new JButton("���ư���"); // trans_panel
	JButton plus = new JButton("�Ա�"); // account_panel
	JButton minus = new JButton("���"); // account_panel
	JButton withdraw = new JButton("��ü"); // account_panel
	JButton member_out = new JButton("ȸ��Ż��"); //member_panel
	JButton trans_button = new JButton("�ŷ�����"); //login_panel
	//JButton current_account = new JButton("�����ܾ�"); //account_panel
	
	JLabel id_login = new JLabel("���̵�  "); //login_panel
	JLabel pswrd_login = new JLabel("��ȣ  "); //login_panel
	JLabel id_member = new JLabel("���̵�  "); // member_panel
	JLabel pswrd_member = new JLabel("��ȣ  "); //member_panel
	JLabel user = new JLabel ("�����"); //account_panel
	JLabel user_name = new JLabel ("����� �̸�"); // account_panel
	JLabel current_account_msg = new JLabel("���ܾ� "); //account_panel
	JLabel current_account = new JLabel("���"); // account_panel
	JLabel money_account = new JLabel("�ݾ�"); // account_panel
	
	ArrayList<String> Id  = new ArrayList<>(Arrays.asList("Dan","Sang")); //Arrays.asList�� ������ �ǹ��ϴ°�?
	ArrayList<String> Pass  = new ArrayList<>(Arrays.asList("1234","0327")); // ���������� ������ ȸ�������� �ɵ� 
	ArrayList<Integer> money  = new ArrayList<>(Arrays.asList(10000,50000)); // ���� �ݾ� 
	
	JFrame main_frame = new JFrame("Account");
	JPanel login_panel = new JPanel();
	JPanel member_panel = new JPanel();
	JPanel account_panel = new JPanel();
	JPanel trans_panel = new JPanel();
	
	JTextArea trans = new JTextArea(); // �ֱ� �ŷ����� �����Ұ� 
	
	int i = 0 ; //list�� ����� �ε����� ���ϳ�
	
	public Account()
	{
		main_frame.setSize(450, 300);
		main_frame.setVisible(true);
		main_frame.setLayout(null);
		login_panel();
		//main_frame.getContentPane().add(login_panel);
		main_frame.add(login_panel);
		member_panel();
		main_frame.add(member_panel);
		//main_frame.getContentPane().add(member_panel);
		account_panel();
		main_frame.add(account_panel);
		trans_panel();
		main_frame.add(trans_panel);
		main_frame.setVisible(true);
	}
	
	public void login_panel()
	{
		login_panel.setLayout(null);
		login_panel.setSize(450, 300);
		
		id_login.setBounds(65,50,50,25); //��
		login_panel.add(id_login); //�гο� �߰�
		
		pswrd_login.setBounds(65,80,80,25); //��
		login_panel.add(pswrd_login);  //�гο� �߰�
		
		idfield_login.setBounds(113,52,116,24); //�ؽ�Ʈ�ʵ�
		login_panel.add(idfield_login); //�гο� �߰�
		idfield_login.setColumns(10);
		
		passwordfield_login.setBounds(113,80,116,24); // �ؽ�Ʈ�ʵ�
		login_panel.add(passwordfield_login); //�гο� �߰�
		passwordfield_login.setColumns(10);
		
		login.setSize(85,20); //��ư
		login.setLocation(243,54);
		login_panel.add(login); //�гο� �߰�
		
		member_move.setSize(85,20); //��ư
		member_move.setLocation(243, 84);
		login_panel.add(member_move); //�гο� �߰�
		
		trans_button.setSize(85,20); // �ֱٰŷ����� ��ư
		trans_button.setLocation(243,114);
		login_panel.add(trans_button);
		
		// ��� ������ ��ü�� ����� �� ���� ���� ��ü���� ��� �����ʷ� ����Ѵ�
		ButtonListener listener = new ButtonListener();
        login.addActionListener(listener);
        member_move.addActionListener(listener);
        trans_button.addActionListener(listener);
        login_panel.setVisible(true);
		
		//login_panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void member_panel()
	{
		member_panel.setLayout(null);
		member_panel.setSize(450, 300);
		
		id_member.setBounds(65,50,50,25); //��
		member_panel.add(id_member); //�гο� �߰�
		
		pswrd_member.setBounds(65,80,80,25); //��
		member_panel.add(pswrd_member); //��ο� �߰�
		
		idfield_member.setBounds(113,52,116,24); //�ؽ�Ʈ�ʵ�
		member_panel.add(idfield_member); //�гο� �߰�
		idfield_member.setColumns(10); 
		
		passwordfield_member.setBounds(113,80,116,24); // �ؽ�Ʈ�ʵ�
		member_panel.add(passwordfield_member); //�гο� �߰�
		passwordfield_member.setColumns(10);

		member_join.setSize(85,20); //ȸ�����Թ�ư
		member_join.setLocation(243,54);
		member_panel.add(member_join); //�гο� �߰�
		
		member_out.setSize(85,20); //ȸ��Ż���ư
		member_out.setLocation(243,84);
		member_panel.add(member_out); //��ο� �߰�
		
		back.setSize(85,20); //�ڷΰ����ư
		back.setLocation(243,114);
		member_panel.add(back); //�гο� �߰�
		
		// ��� ������ ��ü�� ����� �� ���� ���� ��ü���� ��� �����ʷ� ����Ѵ�
		ButtonListener listener = new ButtonListener();
		back.addActionListener(listener); // �Ϸ� 
		member_join.addActionListener(listener); // �Ϸ� 
		member_out.addActionListener(listener); // ���� ��ư�� �̺�Ʈ �߻��� ���� �ʾ���.
		
		member_panel.setVisible(false);
		
		//member_panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void account_panel()
	{
		account_panel.setLayout(null);
		account_panel.setSize(450, 300);
		
		//current_account.setBounds(65,50,50,25); //��
		//account_panel.add(current_account); //�гο� �߰�
		
		//pswrd_member.setBounds(65,80,80,25); //��
		//member_panel.add(pswrd_member); //�гο� �߰�
		
		user.setBounds(65,20,50,25); //�� ,���� ����ڴ� �����ΰ�? user 
		account_panel.add(user); //�гο� �߰�
		
		money_account.setBounds(65,80,80,25);
		account_panel.add(money_account);
		
		user_name.setBounds(113, 20, 116, 24); //�� , ���� ����ϴ� ���: Sang
		account_panel.add(user_name);
		
		current_account_msg.setBounds(65, 50, 50, 25); // ���ܾ�
		account_panel.add(current_account_msg);
		
		current_account.setBounds(113,50,116,24); //���
		account_panel.add(current_account);
		/*
		current_account.setSize(116,24); //���� �ܾ� Ȯ�� ��ư
		current_account.setLocation(113,52);
		account_panel.add(current_account); //�гο� �߰�
		*/
		
		account.setBounds(113,80,116,24); // /�ݾ��Է��ϴ� �ؽ�Ʈ�ʵ�
		account_panel.add(account); //�гο� �߰�
		account.setColumns(10);

		plus.setSize(85,20); //�Աݹ�ư
		plus.setLocation(243,54);
		account_panel.add(plus); //�гο� �߰� 
		
		minus.setSize(85,20); // ��ݹ�ư
		minus.setLocation(243,84);
		account_panel.add(minus); //�гο� �߰�
		
		withdraw.setSize(85,20); // ���ݹ�ư
		withdraw.setLocation(340,54);
		account_panel.add(withdraw); //�гο� �߰�
		
		back_1.setSize(85,20); // �ڷ� ��ư
		back_1.setLocation(340,84);
		account_panel.add(back_1); //�гο� �߰�
		
		// ��� ������ ��ü�� ����� �� ���� ���� ��ü���� ��� �����ʷ� ����Ѵ�
		ButtonListener listener = new ButtonListener(); // ���� �̺�Ʈ�� ����� ���� �ʾ���.
		plus.addActionListener(listener);
		minus.addActionListener(listener);
		withdraw.addActionListener(listener);
		back_1.addActionListener(listener);
		//current_account.addActionListener(listener); //�����ܾ� �Ϸ� , j��ư�ϰ��
		
		account_panel.setVisible(false);
		
		//member_panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void trans_panel()
	{
		trans_panel.setLayout(null);
		trans_panel.setSize(450, 300);
		
		trans.setBounds(0, 0, 335, 300);
		trans_panel.add(trans);
		
		back_2.setSize(85,20); //�ڷΰ��� ��ư
		back_2.setLocation(345,10);
		trans_panel.add(back_2); //�гο� �߰�
		
		ButtonListener listener = new ButtonListener();
		back_2.addActionListener(listener);
		trans_panel.setVisible(false);
	}
	
	class ButtonListener implements ActionListener
	{	
		@Override
		public void actionPerformed(ActionEvent event) 
		{

			if (event.getSource() == login) // �α��� ���
			{	
				i = 0 ;
				for (i = 0 ; i < Id.size() ; i++) 
				{
					if(Id.contains(idfield_login.getText())) // �迭�ȿ� �� ���̵��� �ִ��� ������ 
					{ 
						if(Id.get(i).equals(idfield_login.getText())) 
						{
							if (Pass.get(i).equals(passwordfield_login.getText()))
							{ //��й�ȣ�� �´��� �ٸ���
								user_name.setText(Id.get(i)); // �̺κ� �߿� 
								current_account.setText(Integer.toString(money.get(i))); // string�� �����ϹǷ� 
								login_panel.setVisible(false);
								account_panel.setVisible(true);
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
				login_panel.setVisible(false);
				member_panel.setVisible(true);
			}
			else if (event.getSource() == back) // back�������� , member_panel���� login_panel�� �̵�
			{
				member_panel.setVisible(false);
				login_panel.setVisible(true);
			}
			else if (event.getSource() == back_1) // account_panel���� login_panel�� �̵�
			{
				account_panel.setVisible(false);
				login_panel.setVisible(true);
			}
			else if (event.getSource() == back_2 ) // �ֱٰŷ����� �гο��� �α����гη� ���ư���
			{
				trans_panel.setVisible(false);
				login_panel.setVisible(true);
			}
			else if (event.getSource() == trans_button) // �ֱٰŷ����� ��ȸ
			{
				login_panel.setVisible(false);
				trans_panel.setVisible(true);
			}
			else if (event.getSource() == member_join ) //ȸ������ ��ư
			{	
				i = 0 ;
				for (i = 0 ; i < Id.size() ; i++) 
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
				for (i = 0 ; i < Id.size() ; i++) 
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
			else if ( event.getSource() == current_account)
			{
				for (i = 0 ; i < Id.size() ; i++) // ���° �ε��� ���� Ȯ��
				{
					if(Id.get(i).equals(idfield_login.getText()))  // �迭�ȿ� �� ���̵��� �ִ��� ������ 
					{ 	
						int m = money.get(i);
						JOptionPane.showMessageDialog(null,"�����ܾ�  : "+ m + " ��"); // �̷������� ���� �ִ�.
						break;
					}
						
				}
			}
		}
	}
	
	
	public static void main (String[] args)
    {
		Account frame = new Account();
		//frame.Panel_login();
		//frame.Panel_member();
		//frame.main_frame();
    }
}
