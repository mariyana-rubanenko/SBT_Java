/**
 * Created by 11007122 on 13.12.2017.
 */
public class TerminalServer {
    private static double balance;

    public double getBalance() {
        return balance;
    }

    public void addMoney(double sum) {
        balance += sum;
    }

    public void takeMoney (double sum) {
        balance -= sum;
    }
}
