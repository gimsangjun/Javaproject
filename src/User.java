public class User {
    private String id,password;
    private Account[] activeAccountList;

    public User(String id, String password, Account[] list) {
        this.id=id;
        this.password=password;
        activeAccountList=list;
    }

    public String getID() {
        return id;
    }
    public String getPassword() {
        return password;
    }

    public Account chooseAccount(int n) {
        return activeAccountList[n];
    }

    public void displayAccountList() {
        System.out.println("Account list");
        //if (activeAccountList.length==0) { System.out.println("No Account"); }  이것도 오류임
        for(int i=0;i<activeAccountList.length;i++){
            System.out.println(i+". "+activeAccountList[i].getPassword()+" - "+activeAccountList[i].getBalance()+"Won");
        }
    }

    public void accountCreate(String password) {
        Account created=new Account(password);
        Account[] temp=new Account[activeAccountList.length+1];
        for(int i=0;i<activeAccountList.length;i++) {
            temp[i]=activeAccountList[i];
        }
        temp[activeAccountList.length]=created;
        activeAccountList=temp;
    }
    public void accountRemove(int n) {
        //숫자가 안 맞으면 오류!
        Account[] temp=new Account[activeAccountList.length-1];
        for(int i=0;i<activeAccountList.length-1;i++) {
            if (i==n) { continue; }
            temp[i]=activeAccountList[i];
        }
        activeAccountList=temp;
    }
}
