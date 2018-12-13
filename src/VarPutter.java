import java.util.*;

public class VarPutter {
    private Scanner scan = new Scanner(System.in);
    private String varString;
    private int varint;
    private char varchar;
    private boolean boolYesOrNo;

    //타입이 다른 경우 오류!
    public String putString() {
        System.out.println("Enter String.");
        varString=scan.next();
        return varString;
    }
    public int putInt() {
        System.out.println("Enter Int.");
        varint=scan.nextInt();
        return varint;
    }
    public char putChar() {
        System.out.println("Enter Command key.");
        varchar=scan.next().charAt(0);
        return varchar;
    }
    public boolean putYesOrNo() {
        System.out.println("Will you continue? (Y/N)");
        char temp=putChar();
        if (temp=='y') {
            return true;
        }
        else if (temp=='n') {
            return false;
        }
        return false;//exception please!
    }
}
