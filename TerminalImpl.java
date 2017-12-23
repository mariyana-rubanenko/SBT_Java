import java.util.concurrent.TimeUnit;

/**
 * Created by 11007122 on 13.12.2017.
 */
public class TerminalImpl implements Terminal {
    private static TerminalServer terminalServer = new TerminalServer();
    private  static PinValidator pinValidator = new PinValidator();
    private  static GuiKeyboard  gui = new GuiKeyboard();
    private static  int wrongPinAttempt = 0;
    private  static boolean pinFlag = false;


    @Override
    public void checkBalance() throws InterruptedException {
        // проверка введенного ПИНа
        while (!pinFlag) {
            pinEnter ();
        }
        try {
            gui.showMessage("You balance is " + terminalServer.getBalance());
        } catch (Throwable tr) {
            throw new IllegalStateException("Server Error");
        }
    }

    // снятие денег
    public void withdrawMoney () throws InterruptedException {
        while (!pinFlag) {
            pinEnter ();
        }

        gui.showMessage("Введите сумму");
        double sum = gui.readSum();
        if (sum % 100 != 0) {
            gui.showMessage("Сумма должна быть кратна 100");
        } else if (sum > terminalServer.getBalance()){
            gui.showMessage("Недостаточно средств");
        } else {
            terminalServer.takeMoney(sum);
            gui.showMessage("Деньги успешно выданы");
        }
    }


    public void ReplenishMoney () throws InterruptedException {
        while (!pinFlag) {
            pinEnter ();
        }
        gui.showMessage("Введите сумму"); // не могу же я считать деньги, как банкомат
        double sum = gui.readSum();
        if (sum % 100 != 0) {
            gui.showMessage("Сумма должна быть кратна 100");
        } else {
            terminalServer.addMoney(sum);
            gui.showMessage("Счет успешно пополнен");
        }


    }



    //Проверка ПИНа
    private static void pinEnter () throws InterruptedException {
        if (!pinFlag && wrongPinAttempt < 3) {
            if(pinValidator.checkPin(gui.readPin())) {
                pinFlag = true;
            }

        } else if (wrongPinAttempt >= 3) {
            //block
            TimeUnit.SECONDS.sleep(5);
        }
    }

}
