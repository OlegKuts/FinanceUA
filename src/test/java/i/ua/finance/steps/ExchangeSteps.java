package i.ua.finance.steps;

import i.ua.finance.steps.serenity.UserSteps;
import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;



public class ExchangeSteps {

	@Steps
	UserSteps user;

	@Given("the user is on the Finance home page")
	public void givenTheUserIsOnTheFinanceHomePage() {
		user.is_on_home_page();
	}

	@Given("the user switches to eur tab")
	public void givenTheUserSwitchesToEurTab() {
		user.opens_eur_tab();
	}

	@When("the user looks up for '$value' '$opertaion' rate in the summary table")
	public void whenTheUserLooksUpForCorrespondingRateInTheSummaryTab(
			String value, String operation) {
		user.looks_for_interested_in_exchange_rate(value, operation);
	}

	@Then("they should see it to be the corresponding '$value' '$opertaion' rate of the previous table")
	public void thenTheyShouldSeeTheCorrespondingMinimumsellingRateOfThePreviousTable(
			String value, String operation) {
		user.values_should_be_equal(value, operation);
	}
}
