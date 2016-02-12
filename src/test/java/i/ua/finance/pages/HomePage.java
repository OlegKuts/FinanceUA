package i.ua.finance.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://finance.i.ua")
public class HomePage extends PageObject {

	@FindBy(xpath = ".//*[@id='feMain2']/ul/li[2]/i/a")
	WebElementFacade eurTab;

	public EurPage switchToEurPage() {
		eurTab.click();
		return switchToPage(EurPage.class);
	}

}
