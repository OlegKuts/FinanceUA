package i.ua.finance.pages;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.collect.ImmutableMap;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://finance.i.ua/eur/")
public class EurPage extends PageObject {

	@FindBy(xpath = ".//*[@id='feMain2']/table/tbody/tr[not(@class='expired') and not(@class='sum')]/td[2]")
	private List<WebElement> elementsForPurchase;

	@FindBy(xpath = ".//*[@id='feMain2']/table/tbody/tr[not(@class='expired') and not(@class='sum')]/td[3]")
	private List<WebElement> elementsForSale;

	@FindBy(xpath = ".//*[@id='feMain2']/table/tbody/tr[@class='sum']")
	private List<WebElement> summaryElements;

	private Double valueHolder;

	private Map<String, String> valueVocabulary = ImmutableMap
			.<String, String> builder().put("minimum", "Минимальный")
			.put("maximum", "Максимальний").put("average", "Средний")
			.put("optimal", "Оптимальний").build();

	private Map<String, String> operationVocabulary = ImmutableMap
			.<String, String> builder().put("purchase", "Покупка")
			.put("sale", "Продажа").build();

	public void lookForCertainExchangeRate(String value, String operation) {

		checkInputData(value, operation);

		List<WebElement> currentToUse = operation.equals("purchase") ? elementsForPurchase
				: elementsForSale;

		List<Double> currency = new ArrayList<Double>();

		value = valueVocabulary.get(value);

		currency = currentToUse.stream().map(WebElement::getText)
				.map(Double::parseDouble).collect(Collectors.toList());

		Collections.sort(currency);

		switch (value) {
		case "Минимальный":
			valueHolder = currency.get(0);
			break;
		case "Максимальний":
			valueHolder = currency.get(currency.size() - 1);
			break;
		case "Средний":
			valueHolder = currency.stream().reduce(0.0, (a, b) -> a + b)
					/ currency.size();
			valueHolder = new BigDecimal(valueHolder).setScale(4,
					RoundingMode.HALF_UP).doubleValue();
			break;
		case "Оптимальний":
			valueHolder = operation.equals("purchase") ? currency.get(currency
					.size() - 1) : currency.get(0);
			break;

		default:
			break;
		}
	}

	public Double getCurrentValue() {
		return valueHolder;
	}

	public Double getExpectedValueFromSummaryTable(String value,
			String operation) {
		
		checkInputData(value, operation);
		
		Double result = null;

		value = valueVocabulary.get(value);

		for (WebElement webElement : summaryElements) {
			String currentRowName = webElement
					.findElement(By.xpath(".//td[1]")).getText().trim();
			if (value.equals(currentRowName)) {
				if (operation.equals("purchase")) {
					result = Double.parseDouble(webElement.findElement(
							By.xpath(".//td[2]")).getText());
					break;
				} else if (operation.equals("sale")) {
					result = Double.parseDouble(webElement.findElement(
							By.xpath(".//td[3]")).getText());
					break;
				}
			}
		}
		return result;
	}

	private void checkInputData(String value, String operation) {
		if (!(valueVocabulary.containsKey(value) && operationVocabulary
				.containsKey(operation))) {
			throw new IllegalArgumentException("Either value " + "\'" + value
					+ "\'" + " or operation " + "\'" + operation + "\'"
					+ " has been typed incorrectly");
		}
	}
}
