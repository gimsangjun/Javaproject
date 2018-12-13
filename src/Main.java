import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Main extends JFrame {
    public LoginPanel loginPanel;
    private Account account1=new Account("abc");
    private User[] userlist={new User("park","abc", new Account[]{})};

    public Main() {
        setSize(500,500);
        setTitle("Bank");

        Container container=getContentPane();
        container.setLayout(new FlowLayout());
        loginPanel=new LoginPanel(userlist);
        container.add(loginPanel);
    }
    public static void main(String[] argc){
        //선언
        Main frame=new Main();

        frame.add(frame.loginPanel);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
