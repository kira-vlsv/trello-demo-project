package uitests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uitests.pageobjects.boardpage.BoardPage;

public class CardCRUDTest extends BaseTest {

    private BoardPage boardPage;

    @Test
    @Feature("Trello cards")
    @Story("As a user I can create a card in the board's list")
    @DisplayName("Create new card from Board Page")
    public void createCard() {
        String listName = faker.artist().name();
        String cardName = faker.animal().name();
        boardPage = mainPage.openBoard("Trello Demo Testing", "CardCRUDTest");
        boardPage.createList(listName);
        boardPage.createCard(listName, cardName);
        boardPage.verifyCardIsCreatedAndDisplayedInTheList(listName, cardName);
    }
}
