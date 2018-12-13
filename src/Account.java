public class Account {
    private String password;
    private int balance;
    private int interestRate;

    public Account(String password){
        this.password=password;
        balance=0;
        interestRate=5;
    }

    public boolean deposit(int money){
        balance+=money;
        return true;
    }
    public boolean withdraw(int money){
        if(balance<money){
            System.out.println("Insufficient balance in account.");
            return false;
        }
        else{
            balance-=money;
            return true;
        }
    }

    public int getBalance() {
        return balance;
    }
    public String getPassword() {
        return password;
    }
    public int getInterestRate() {
        return interestRate;
    }
}
