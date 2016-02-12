package i.ua.finance.steps.serenity;



import i.ua.finance.pages.EurPage;
import i.ua.finance.pages.HomePage;
import net.thucydides.core.steps.ScenarioSteps;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserSteps extends ScenarioSteps {

	HomePage homePage;
	EurPage eurPage;

	public void is_on_home_page() {
		homePage.open();

	}

	public void opens_eur_tab() {
		homePage.switchToEurPage();

	}

	public void looks_for_interested_in_exchange_rate(String value,
			String operation) {
		eurPage.lookForCertainExchangeRate(value, operation);

	}

	public void values_should_be_equal(String value, String operation) {
		assertThat(eurPage.getCurrentValue(), equalTo(eurPage.getExpectedValueFromSummaryTable(value, operation)));
	}

}
