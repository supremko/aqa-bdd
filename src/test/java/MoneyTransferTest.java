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
        val dashboardPage = verificationPage.verify(verificationCode);
        val listCards = Data.getListCards();
        dashboardPage.topUpCard1(listCards);
        dashboardPage.topUpCard2(listCards);

    }
}
