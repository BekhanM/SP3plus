import java.util.ArrayList;

public class DataValidator {
    TextUI ui = new TextUI();

    // Tjekker om en String (password) indeholder minimum et stort bogstav
    public boolean checkUpperCase(String str) {
        char c;
        boolean upperCaseFlag = false;
        boolean lowerCaseFlag = false;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                upperCaseFlag = true;
            } else if (Character.isLowerCase(c)) {
                lowerCaseFlag = true;
            }
            if (upperCaseFlag && lowerCaseFlag)
                return true;
        }
        ui.displayMessage("Kodeord skal indeholde mindst et stort bogstav");
        return false;
    }

    // tjekker længden er minimum på 8 characters i en String (password)
    public boolean checkLength(String str) {

        if (str.length() < 129 && str.length() > 7) {
            return true;
        } else {
            ui.displayMessage("Kodeord skal mindst være 8 karakterer langt");
            return false;
        }
    }

    // tjekker om en String (password) indeholder et tal
    public boolean checkNumeric(String str) {
        char c;
        boolean numberFlag = false;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (Character.isDigit(c)) {
                return true;
            }
        }

        if (!numberFlag) {
            ui.displayMessage("Kodeord skal indeholde mindst 1 tal");
        }
        return false;
    }

    //tjekker om password opfylder kriterier og returnerer boolean
    public boolean validatePassword(String password) {
        boolean i = checkNumeric(password);
        boolean j = checkLength(password);
        boolean k = checkUpperCase(password);
        if (i && j && k) {
            return true;
        } else {
            return false;
        }
    }

    // Skal tjekke om username allerede eksisterer ved at sammenligne indhold i arraylist med ny brugerinput
    public boolean checkRegisterUsername(ArrayList<String> users, String enteredUsername) {

        for (String user : users) {
            String[] userInfo = user.split(",");
            String username = userInfo[0];
            if (username.contentEquals(enteredUsername)) {
                ui.displayMessage("Brugernavn findes, prøv igen ");
                return false;
            }
        }
        return true;
    }

    public boolean checkLoginUsername(ArrayList<String> users, String enteredUsername) {
        for (String user : users) {
            String[] userInfo = user.split(",");
            String username = userInfo[0];
            if (username.contentEquals(enteredUsername)) {
                return true;  // Username exists
            }
        }
        ui.displayMessage("Brugernavn findes ikke, prøv igen ");
        return false;
    }

    public boolean checkLoginPassword(ArrayList<String> users, String enteredPassword) {
        for (String user : users) {
            String[] userInfo = user.split(",");
            String password = userInfo[1];
            if (password.contentEquals(enteredPassword)) {
                return true;  // Password exists
            }
        }
        ui.displayMessage("Forkert kodeord, prøv igen ");
        return false;
    }


}