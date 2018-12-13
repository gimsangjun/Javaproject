import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    private JButton goToLogin, goToSignIn;
    private String id, password;
    private JLabel label;
    private User[] userlist;
    private User user;

    public LoginPanel(User[] userlist) {
        this.userlist=userlist;

        setLayout(null);
        setSize(500,250);

        goToLogin=new JButton("로그인");
        goToSignIn=new JButton("회원가입");
        label=new JLabel("Offline ATM Service");
        add(goToLogin);
        add(goToSignIn);
        add(label);

        LoginListener listener=new LoginListener();
        goToSignIn.addActionListener(listener);
        goToLogin.addActionListener(listener);
    }
    private class LoginListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==goToLogin) {
                id=JOptionPane.showInputDialog("ID");
                for (int i=0;i<userlist.length;i++){
                    if (userlist[i].getID().equals(id)) {
                        user=userlist[i];
                        password=JOptionPane.showInputDialog("Password");
                        if (user.getPassword().equals(password)){
                            label.setText("환영합니다, "+user.getID());
                            break;
                        }
                        else {
                            label.setText("로그인 실패:비밀번호가 틀립니다");
                            break;
                        }
                    }
                    else {
                        label.setText("로그인 실패:회원정보가 존재하지 않습니다");
                        break;
                    }
                }
            }
            else {
                id=JOptionPane.showInputDialog("새 ID를 입력하세요");
                password=JOptionPane.showInputDialog("새 비번을 입력하세요");

                createUser(id, password);
                label.setText("회원가입 완료");
            }
        }
    }
    public void createUser(String id, String password) {
        Account account=new Account("abc");
        Account[] accountlist=new Account[]{account};
        User created=new User(id, password, accountlist);
        User[] temp=new User[userlist.length+1];
        for(int i=0;i<userlist.length;i++) {
            temp[i]=userlist[i];
        }
        temp[userlist.length]=created;
        userlist=temp;
        System.out.println(userlist);
    }

    public User getUser() {
        return user;
    }
}
