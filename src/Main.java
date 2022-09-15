public class Main {
    public static void main(String[] args) {
        String login = "Lisk1w9fe_oa12k112";
        String password = "C1diWAgo2k_eg2u4S11";
        String confirmPassword = "C1diWAgo2k_eg2u4S11";
        boolean result = checkAuthorization(login, password, confirmPassword);
        if (result) {
            System.out.println("Валидация пройдена");
        } else {
            System.out.println("Валидация не пройдена");
        }

    }
    public static boolean checkAuthorization(String login, String password, String confirmPassword) {
        int exceptionCounter = 0;
        boolean result;

        try {
            if (!login.matches("[a-zA-Z_0-9]+")) {
                exceptionCounter++;
                throw new WrongSyntaxException();
            }
            if (login.length() > 20) {
                exceptionCounter++;
                throw new WrongLoginException();
            }
            if (!password.matches("[a-zA-Z_0-9]+")) {
                exceptionCounter++;
                throw new WrongSyntaxException();
            }
            if (password.length() > 19) {
                exceptionCounter++;
                throw new WrongPasswordLengthException();
            }
            if (!password.equals(confirmPassword)) {
                exceptionCounter++;
                throw new WrongPasswordException();
            }
        } catch (WrongSyntaxException e) {
            System.out.println("Введены недопустимые символы");
        } catch (WrongLoginException e) {
            System.out.println("Длина логина слишком велика");
        } catch (WrongPasswordLengthException e) {
            System.out.println("Длина пароля слишком велика");
        } catch (WrongPasswordException e) {
            System.out.println("Пароли не совпадают");
        } finally {
            result = exceptionCounter <= 0;
        }
        return result;
    }
}
