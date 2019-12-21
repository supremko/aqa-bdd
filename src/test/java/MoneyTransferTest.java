import lombok.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

public class MoneyTransferTest {
    @Test
    void shouldTransferMoneyBetweenOwnCards() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = Data.getAuthInfo();
        val verificationPage = loginPage.login(authInfo);
        verificationPage.availableVerifyBtn();
        val verificationCode = Data.getVerificationCodeFor();
        verificationPage.verify(verificationCode);
        val dashboardPage = new DashboardPage();
        dashboardPage.topUpCard1();
        dashboardPage.topUpCard2();
    }
}
