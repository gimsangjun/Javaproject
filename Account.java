
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class Account //extends JFrame을 활용하는 방법, 여러가지 패널은 만들어서 하고싶은데
{ 
	JTextField idfield_login = new JTextField() ;
	JPasswordField passwordfield_login = new JPasswordField();
	JTextField idfield_member = new JTextField() ;
	JPasswordField passwordfield_member = new JPasswordField();
	JTextField account = new JTextField() ; // account_panel, 어느정도의 금액을 입력받을것인지 
	
	JButton login = new JButton("로그인"); //login_panel
	JButton member_join = new JButton("회원가입"); //member_panel
	JButton member_move = new JButton("회원가입"); //login_panel
	JButton back = new JButton("돌아가기"); //member_panel
	JButton back_1 = new JButton("뒤로"); // account_panel
	JButton back_2 = new JButton("돌아가기"); // trans_panel
	JButton back_3 = new JButton("돌아가기"); //list_panel
	JButton plus = new JButton("입금"); // account_panel
	JButton minus = new JButton("출금"); // account_panel
	JButton withdraw = new JButton("이체"); // account_panel
	JButton member_out = new JButton("회원탈퇴"); //member_panel
	JButton trans_button = new JButton("거래내역"); //login_panel
	JButton list = new JButton("사용자들") ; // login_panel
	//JButton current_account = new JButton("현재잔액"); //account_panel
	
	JLabel id_login = new JLabel("아이디  "); //login_panel
	JLabel pswrd_login = new JLabel("암호  "); //login_panel
	JLabel id_member = new JLabel("아이디  "); // member_panel
	JLabel pswrd_member = new JLabel("암호  "); //member_panel
	JLabel user = new JLabel ("사용자"); //account_panel
	JLabel user_name = new JLabel ("사용자 이름"); // account_panel
	JLabel current_account_msg = new JLabel("현잔액 "); //account_panel
	JLabel current_account = new JLabel("몇원"); // account_panel
	JLabel money_account = new JLabel("금액"); // account_panel
	
	ArrayList<String> Id  = new ArrayList<>(Arrays.asList("Dan","Sang")); //Arrays.asList는 무엇을 의미하는가?
	ArrayList<String> Pass  = new ArrayList<>(Arrays.asList("1234","0327")); // 전역변수로 만들어야 회원가입이 될듯 
	ArrayList<Integer> money  = new ArrayList<>(Arrays.asList(10000,50000)); // 계좌 금액 
	
	JFrame main_frame = new JFrame("Account");
	JPanel login_panel = new JPanel();
	JPanel member_panel = new JPanel();
	JPanel account_panel = new JPanel();
	JPanel trans_panel = new JPanel();
	JPanel list_panel = new JPanel();
	
	JTextArea trans = new JTextArea(); // 최근 거래내역 저장할곳 
	JTextArea lists = new JTextArea(); // 어떤 사용자들 있나 보여주는 lists
	
	int i = 0 ; //list의 몇번쨰 인덱스를 원하나
	
	public static boolean isNumeric(String s) { // 숫자인지 문자열인지 판단하는 메소드
		  try {
		      Double.parseDouble(s);
		      return true;
		  } catch(NumberFormatException e) {
		      return false;
		  }
		}
	
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
		list_panel();
		main_frame.add(list_panel);
		main_frame.setVisible(true);
	}
	
	public void login_panel()
	{
		login_panel.setLayout(null);
		login_panel.setSize(450, 300);
		
		id_login.setBounds(65,50,50,25); //라벨
		login_panel.add(id_login); //패널에 추가
		
		pswrd_login.setBounds(65,80,80,25); //라벨
		login_panel.add(pswrd_login);  //패널에 추가
		
		idfield_login.setBounds(113,52,116,24); //텍스트필드
		login_panel.add(idfield_login); //패널에 추가
		idfield_login.setColumns(10);
		
		passwordfield_login.setBounds(113,80,116,24); // 텍스트필드
		login_panel.add(passwordfield_login); //패널에 추가
		passwordfield_login.setColumns(10);
		
		login.setSize(85,20); //버튼
		login.setLocation(243,54);
		login_panel.add(login); //패널에 추가
		
		member_move.setSize(85,20); //버튼
		member_move.setLocation(243, 84);
		login_panel.add(member_move); //패널에 추가
		
		trans_button.setSize(85,20); // 최근거래내역 버튼
		trans_button.setLocation(243,114);
		login_panel.add(trans_button);
		
		list.setSize(85,20); //어떤 사용자들이 있나 보여주는 panel로 이동하는 버튼
		list.setLocation(340, 54);
		login_panel.add(list);
		
		// 사건 리스너 객체를 만들고 두 개의 단추 객체들의 사건 리스너로 등록한다
		ButtonListener listener = new ButtonListener();
        login.addActionListener(listener);
        member_move.addActionListener(listener);
        trans_button.addActionListener(listener);
        list.addActionListener(listener);
        login_panel.setVisible(true);
        
		
		//login_panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void member_panel()
	{
		member_panel.setLayout(null);
		member_panel.setSize(450, 300);
		
		id_member.setBounds(65,50,50,25); //라벨
		member_panel.add(id_member); //패널에 추가
		
		pswrd_member.setBounds(65,80,80,25); //라벨
		member_panel.add(pswrd_member); //페널에 추가
		
		idfield_member.setBounds(113,52,116,24); //텍스트필드
		member_panel.add(idfield_member); //패널에 추가
		idfield_member.setColumns(10); 
		
		passwordfield_member.setBounds(113,80,116,24); // 텍스트필드
		member_panel.add(passwordfield_member); //패널에 추가
		passwordfield_member.setColumns(10);

		member_join.setSize(85,20); //회원가입버튼
		member_join.setLocation(243,54);
		member_panel.add(member_join); //패널에 추가
		
		member_out.setSize(85,20); //회원탈퇴버튼
		member_out.setLocation(243,84);
		member_panel.add(member_out); //페널에 추가
		
		back.setSize(85,20); //뒤로가기버튼
		back.setLocation(243,114);
		member_panel.add(back); //패널에 추가
		
		// 사건 리스너 객체를 만들고 두 개의 단추 객체들의 사건 리스너로 등록한다
		ButtonListener listener = new ButtonListener();
		back.addActionListener(listener); // 완료 
		member_join.addActionListener(listener); // 완료 
		member_out.addActionListener(listener); // 아직 버튼의 이벤트 발생은 넣지 않았음.
		
		member_panel.setVisible(false);
		
		//member_panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void account_panel()
	{
		account_panel.setLayout(null);
		account_panel.setSize(450, 300);
		
		//current_account.setBounds(65,50,50,25); //라벨
		//account_panel.add(current_account); //패널에 추가
		
		//pswrd_member.setBounds(65,80,80,25); //라벨
		//member_panel.add(pswrd_member); //패널에 추가
		
		user.setBounds(65,20,50,25); //라벨 ,현재 사용자는 누구인가? user 
		account_panel.add(user); //패널에 추가
		
		money_account.setBounds(65,80,80,25);
		account_panel.add(money_account);
		
		user_name.setBounds(113, 20, 116, 24); //라벨 , 현자 사용하는 사람: Sang
		account_panel.add(user_name);
		
		current_account_msg.setBounds(65, 50, 50, 25); // 현잔액
		account_panel.add(current_account_msg);
		
		current_account.setBounds(113,50,116,24); //몇원
		account_panel.add(current_account);
		/*
		current_account.setSize(116,24); //현재 잔액 확인 버튼
		current_account.setLocation(113,52);
		account_panel.add(current_account); //패널에 추가
		*/
		
		account.setBounds(113,80,116,24); // /금액입력하는 텍스트필드
		account_panel.add(account); //패널에 추가
		account.setColumns(10);

		plus.setSize(85,20); //입금버튼
		plus.setLocation(243,54);
		account_panel.add(plus); //패널에 추가 
		
		minus.setSize(85,20); // 출금버튼
		minus.setLocation(243,84);
		account_panel.add(minus); //패널에 추가
		
		withdraw.setSize(85,20); // 예금버튼
		withdraw.setLocation(340,54);
		account_panel.add(withdraw); //패널에 추가
		
		back_1.setSize(85,20); // 뒤로 버튼
		back_1.setLocation(340,84);
		account_panel.add(back_1); //패널에 추가
		
		// 사건 리스너 객체를 만들고 두 개의 단추 객체들의 사건 리스너로 등록한다
		ButtonListener listener = new ButtonListener(); // 아직 이벤트에 기능은 넣지 않았음.
		plus.addActionListener(listener);
		minus.addActionListener(listener);
		withdraw.addActionListener(listener);
		back_1.addActionListener(listener);
		//current_account.addActionListener(listener); //현재잔액 완료 , j버튼일경우
		
		account_panel.setVisible(false);
		
		//member_panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void trans_panel()
	{
		trans_panel.setLayout(null);
		trans_panel.setSize(450, 300);
		
		trans.setBounds(0, 0, 335, 300);
		trans_panel.add(trans);
		
		back_2.setSize(85,20); //뒤로가기 버튼
		back_2.setLocation(345,10);
		trans_panel.add(back_2); //패널에 추가
		
		ButtonListener listener = new ButtonListener();
		back_2.addActionListener(listener);
		trans_panel.setVisible(false);
	}
	public void list_panel()
	{
		list_panel.setLayout(null);
		list_panel.setSize(450, 300);
		
		lists.setBounds(0, 0, 335, 300); //TextField 
		list_panel.add(lists);
		
		back_3.setSize(85,20); //뒤로가기 버튼
		back_3.setLocation(345,10);
		list_panel.add(back_3);//패널에 추가
		
		ButtonListener listener = new ButtonListener();
		back_3.addActionListener(listener);
		list_panel.setVisible(false);
	}
	
	class ButtonListener implements ActionListener
	{	
		@Override
		public void actionPerformed(ActionEvent event) 
		{

			if (event.getSource() == login) // 로그인 기능
			{	
				i = 0 ;
				for (i = 0 ; i < Id.size() ; i++) 
				{
					if(Id.contains(idfield_login.getText())) // 배열안에 그 아이디값이 있는지 없는지 
					{ 
						if(Id.get(i).equals(idfield_login.getText())) 
						{
							if (Pass.get(i).equals(passwordfield_login.getText()))
							{ //비밀번호가 맞는지 다른지
								user_name.setText(Id.get(i)); // 이부분 중요 
								current_account.setText(Integer.toString(money.get(i))); // string만 가능하므로 
								login_panel.setVisible(false);
								account_panel.setVisible(true);
							}
							else 
							{
								JOptionPane.showMessageDialog(null, " 로그인에 실패하였습니다. ");
								break;
							}
						}
					}
					else
					{ 
						JOptionPane.showMessageDialog(null, " 이 아이디는 존재하지않습니다. ");
						break;
					}
				}
		    }	
			else if(event.getSource()== member_move) //member_move눌렀을때 member_panel으로 이동.
			{	
				login_panel.setVisible(false);
				member_panel.setVisible(true);
			}
			else if (event.getSource() == back) // back눌럿을때 , member_panel에서 login_panel로 이동
			{
				member_panel.setVisible(false);
				login_panel.setVisible(true);
			}
			else if (event.getSource() == back_1) // account_panel에서 login_panel로 이동
			{
				account_panel.setVisible(false);
				login_panel.setVisible(true);
			}
			else if (event.getSource() == back_2 ) // 최근거러내역 패널에서 로그인패널로 돌아가기
			{
				trans_panel.setVisible(false);
				login_panel.setVisible(true);
			}
			else if (event.getSource() == back_3 )
			{
				list_panel.setVisible(false);
				login_panel.setVisible(true);
			}
			else if (event.getSource() == trans_button) // 최근거래내역 조회
			{
				login_panel.setVisible(false);
				trans_panel.setVisible(true);
			}
			else if (event.getSource() == list) // 사용자목록 보여주는 패널로 이동	
			{
				login_panel.setVisible(false);
				lists.setText("");
				for ( i = 0 ; i < Id.size() ; i++)
				{
					lists.append(Id.get(i) + " 의 잔액은 " + money.get(i) + "원 입니다\n");
				}
				list_panel.setVisible(true);
			}
			else if (event.getSource() == member_join ) //회원가입 버튼
			{	
				i = 0 ;
				for (i = 0 ; i < Id.size() ; i++) 
				{
					if(Id.contains(idfield_member.getText())) // 배열안에 그 아이디값이 있는지 없는지 
					{ 
						JOptionPane.showMessageDialog(null, " 이미 존재하는 아이디입니다. ");
						break;
					}
					else 
					{ 
						Id.add(idfield_member.getText());
						Pass.add(passwordfield_member.getText());
						money.add(0); // 아이디를 생성했으므로, 
						JOptionPane.showMessageDialog(null, " 회원가입이 되었습니다. ");
						break;
					}
				}
			}
			else if ( event.getSource() == member_out ) //회원탈퇴 
			{	
				if(Id.contains(idfield_login.getText()))
				{
					for (i = 0 ; i < Id.size() ; i++) 
					{
						if(Id.get(i).equals(idfield_login.getText())) 
						{
							if (Pass.get(i).equals(passwordfield_login.getText()))
							{ //비밀번호가 맞는지 다른지
								Id.remove(i); 
								Pass.remove(i);
								money.remove(i);
								JOptionPane.showMessageDialog(null, " 회원 탈퇴가 되었습니다. ");
								break;
							}
							else 
							{
								JOptionPane.showMessageDialog(null, " 비밀번호가 일치하지 않습니다. ");
								break;
							}
						}
					}
				}
				else 
				{
						JOptionPane.showMessageDialog(null,"없는 아이디 입니다. ");
				}
			}
			else if ( event.getSource() == current_account)
			{
				for (i = 0 ; i < Id.size() ; i++) // 몇번째 인덱스 인지 확인
				{	
					if(Id.get(i).equals(idfield_login.getText()))  // 배열안에 그 아이디값이 있는지 없는지 
					{ 	
						int m = money.get(i);
						JOptionPane.showMessageDialog(null,"현재잔액  : "+ m + " 원"); // 이런식으로 쓸수 있다.
						break;
					}
						
				}
			}
			else if (event.getSource() == plus)
			{
				if(isNumeric(account.getText()) == true)
				{
					for (i = 0 ; i < Id.size() ; i++) // 몇번째 인덱스 인지 확인
					{
						if(Id.get(i).equals(idfield_login.getText()))  // 배열안에 그 아이디값이 있는지 없는지 
						{ 	
							int m = money.get(i);
							int n = Integer.parseInt(account.getText()); // string의 값을 정수형으로 전환 
							m = m + n ;
							money.set(i,m); //특정 인덱스 값 m으로 수정
							trans.append(Id.get(i) + " 에게 " + n + " 원이 입금되었습니다. \n");
							current_account.setText(Integer.toString(money.get(i))); // 현재몇원인지 보여주는 label의 text를 지정해줌.
							JOptionPane.showMessageDialog(null,"현재잔액  : "+ m + " 원"); // 이런식으로 쓸수 있다.
							break;
						}
							
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"잘못된 입력입니다. ");
				}
			}
			else if (event.getSource() == minus)
			{	
				if(isNumeric(account.getText()) == true) // 숫자인지 문자열인지 확인 
				{
					for (i = 0 ; i < Id.size() ; i++) // 몇번째 인덱스 인지 확인
						{
							if(Id.get(i).equals(idfield_login.getText()))  // 배열안에 그 아이디값이 있는지 없는지 
							{ 	
								int m = money.get(i);
								int n = Integer.parseInt(account.getText()); // string의 값을 정수형으로 전환 
								m = m - n ;
								if ( m < 0 )
								{
									JOptionPane.showMessageDialog(null,"돈이 부족합니다.");
									break;
								}
								money.set(i,m); //특정 인덱스 값 m으로 수정
								trans.append(Id.get(i) + " 에게 " + n + " 원이 출금되었습니다.\n ");
								current_account.setText(Integer.toString(money.get(i))); // 현재몇원인지 보여주는 label의 text를 지정해줌.
								JOptionPane.showMessageDialog(null,"현재잔액  : "+ m + " 원"); // 이런식으로 쓸수 있다.
								break;
							}
								
						}
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"잘못된 입력입니다. ");
				}
			}
			else if (event.getSource() == withdraw) //이체
			{
				
				if(isNumeric(account.getText()) == true) // 숫자인지 ,문자열인지 확인
				{	
					String who = JOptionPane.showInputDialog(" 누구에서 이체하시겠습니까? ");
					if(Id.contains(who)) // who라는 사람이 Id가 있는지 확인 
					{
						for (i = 0 ; i < Id.size() ; i++) // 몇번째 인덱스 인지 확인
						{	
		
							if(Id.get(i).equals(who));  // 배열안에 그 아이디값이 있는지 없는지 
							{ 	
								int m = money.get(i); //받는 사람의 돈
								int n = Integer.parseInt(account.getText()); // string의 값을 정수형으로 전환 
								money.set(i,m+n); //돈 받은사람의 돈을 올려줌
								for (int a = 0 ; a < Id.size() ; a++) // 몇번째 인덱스 인지 확인
								{
									if(Id.get(a).equals(idfield_login.getText())) //돈을 보낸사람 찾기
									{ 	
										int b = money.get(a); // 보내는 사람의 돈
										b = b - n;
										if ( b < 0 )
										{
											JOptionPane.showMessageDialog(null,"돈이 부족합니다.");
											break;
										}
										money.set(a,b); //특정 인덱스 값 m으로 수정
										trans.append(Id.get(a) + " 이/가 ");
										current_account.setText(Integer.toString(money.get(a))); // 현재몇원인지 보여주는 label의 text를 지정해줌.
										break;
									}
										
								}
								trans.append(Id.get(i) + " 에게 " + n + " 원을 이체하였습니다.\n ");
								break;
							}		
						}
					}
					else //who라는 사람이 없으면 메세지 출력 
					{
						JOptionPane.showMessageDialog(null,"없는 사용자 입니다.");
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"잘못된 입력입니다. ");
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
