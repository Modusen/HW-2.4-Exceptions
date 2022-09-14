public class Main {
    public static void main(String[] args) {
        String login = "Lisk149feoa12k11112";
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
            if (login.length() > 20) {
                exceptionCounter++;
                throw new WrongLoginException();
            }
            if (password.length() > 19) {
                exceptionCounter++;
                throw new WrongPasswordLengthException();
            }
            if (!password.equals(confirmPassword)) {
                exceptionCounter++;
                throw new WrongPasswordException();
            }
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
