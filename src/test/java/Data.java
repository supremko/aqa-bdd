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

    @Value
    public static class ListCards {
        private String card1;
        private String lastNumCard1;
        private String card2;
        private String lastNumCard2;
    }
    public static ListCards getListCards() {
        return new ListCards("5559 0000 0000 0001", "0001",
                "5559 0000 0000 0002", "0002");}
}
