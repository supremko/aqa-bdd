import lombok.*;

public class Data{
    private Data() {}

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }
    public static VerificationCode getVerificationCodeFor() {
        return new VerificationCode("12345");
    }
}
