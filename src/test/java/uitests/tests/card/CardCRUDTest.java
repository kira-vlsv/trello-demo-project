package uitests.tests.card;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uitests.tests.BaseUITest;
import uitests.pageobjects.boardpage.BoardPage;

import static utils.RandomGenerator.randomString;

@Tag("Regression")
class CardCRUDTest extends BaseUITest {

    private BoardPage boardPage;

    @Test
    @Feature("Trello cards")
    @Story("As a user I can create a card in the board's list")
    @DisplayName("Create new card from Board Page")
    @Tag("Cards")
    void createCard() {
        String listName = randomString("List");
        String cardName = randomString("Card");
        boardPage = mainPage.openBoard("Trello Demo Testing", "CardCRUDTest");
        boardPage.createList(listName);
        boardPage.createCard(listName, cardName);
        boardPage.verifyCardIsCreatedAndDisplayedInTheList(listName, cardName);
    }
}
