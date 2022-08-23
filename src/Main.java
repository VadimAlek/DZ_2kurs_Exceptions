import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) {
        String login = "vados1985";
        String password = "1985";
        String confirmPassword = "1985";
        System.out.println(checkCorrect(login, password, confirmPassword));
        String loginNegative = "vados1985_987654321000";
        String passwordNegative = "1985-abcd_987654321000";
        String confirmPasswordNegative = "1985-abcd_987654321000";
        System.out.println(checkCorrect(loginNegative, passwordNegative, confirmPasswordNegative));
    }

    public static boolean checkCorrect(String login, String password, String confirmPassword) {
        try {
            if (login.toCharArray().length > 20) {
                throw new WrongLoginException("Слишком длинный логин.");
            }

            if (password.toCharArray().length > 20 || confirmPassword.toCharArray().length > 20) {
                throw new WrongPasswordException("Слишком длинный пароль.");
            }
            if (!login.matches("\\w{1,20")) {
                throw new WrongLoginException("Логин не соответствует требованиям.");
            }
            if (!password.matches("\\w{1,20") || !confirmPassword.matches("\\w{1,20}")) {
                throw new WrongPasswordException("Пароль не соответствует требованиям.");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароль не совпадает");
            }
        }catch (WrongLoginException | WrongPasswordException exception) {
            System.out.println(LoginException.getMessage());
            return false;
        }
        }
        return true;

    }
}

