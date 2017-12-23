/**
 * Created by 11007122 on 13.12.2017.
 */
public class PinValidator {
    private static int pin;
    public boolean checkPin (int enterPin) {
        if (enterPin == pin)
            return true;
        else
            return false;
    }

    public boolean changePin () {
        // TO DO: запрос старого пина, подтверждающего слова
        // Отправка серверу на проверку
        return false;
    }

}
