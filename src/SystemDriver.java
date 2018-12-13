public class SystemDriver {
    // file managing not used.
    private User[] userList;
    private User runningUser;
    private VarPutter varputter;
    private Account runningAccount, recevingAccount;

    public SystemDriver(User[] userList) {
        this.userList=userList;
        varputter=new VarPutter();
    }

    public void displayUserList() {
        System.out.println("User list");
        for (int i=0;i<userList.length;i++) {
            System.out.println(i+"."+userList[i].getID());
        }
    }
    public void setRunningUser(int n) {
        runningUser=userList[n];
    }
    public void setRunningAccount(int n) {
        runningAccount=runningUser.chooseAccount(n);
    }
    //how can I choose receiver easily?
    public void setRecevingAccount(User anotherUser, int n) {
        anotherUser.displayAccountList();
        recevingAccount= anotherUser.chooseAccount(n);
    }

    //일반 업무 프로세스
    public void normalTaskProcess() {
        //일단은 로그인을 여기에 구현
        displayUserList();
        setRunningUser(varputter.putInt());
        runningUser.displayAccountList();
        setRunningAccount(varputter.putInt());

        System.out.println("q/d/w/t");
        switch (varputter.putChar()) {
            case 'q':
                //back to choose phase!
                return;
            case 'd':
                System.out.println("Deposit");
                runningAccount.deposit(varputter.putInt());
                break;
            case 'w':
                System.out.println("Withdraw");
                runningAccount.withdraw(varputter.putInt());
                break;
            case 't':
                System.out.println("Choose what account to transaction");
                displayUserList();
                User receiveUser=userList[varputter.putInt()];
                setRecevingAccount(receiveUser,varputter.putInt());
                int amount=varputter.putInt();
                if (!runningAccount.withdraw(amount)) {
                    break;
                }
                recevingAccount.deposit(amount);
                break;
            default:
                System.out.println("Invalid command.");//오류발생 처리 필요함
                return;
        }
        System.out.println("Calculating the interest...");
        int interest=runningAccount.getBalance()*runningAccount.getInterestRate()/100;
        runningAccount.deposit(interest);

        System.out.println("Task processed. "+runningAccount.getBalance()+" - "+runningAccount.getPassword());
        System.out.println("Thank You.");
    }
    //계좌 관리 프로세스
    public void accountTaskProcess() {
        //일단은 로그인을 여기에 구현
        displayUserList();
        setRunningUser(varputter.putInt());
        runningUser.displayAccountList();

        System.out.println("c/r");
        switch (varputter.putChar()) {
            case 'c':
                System.out.println("Create Account");
                runningUser.accountCreate(varputter.putString());
                break;
            case 'r':
                System.out.println("Remove Account");
                runningUser.accountRemove(varputter.putInt());
                break;
            default:
                System.out.println("Invalid command.");//오류발생 처리 필요함
                return;
        }
    }
    //계정 관리 프로세스
    public void userTaskProcess() {

    }
}