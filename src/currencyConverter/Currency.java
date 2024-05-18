package currencyConverter;

import java.util.ArrayList;
import java.util.HashMap;

public class Currency {
	Algorithms algorithmsObject = new Algorithms();

	private String shortName;
	private HashMap<String, Double> exchangeValues = algorithmsObject.getExchangeValues();

	// "Currency" Constructor
	public Currency(String shortNameValue) {
		this.shortName = shortNameValue;
	}
	
	// Getter for shortName
	public String getShortName() {
		return this.shortName;
	}
	
	// Setter for shortName
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	// Getter for exchangeValues
	public HashMap<String, Double> getExchangeValues() {
		return this.exchangeValues;
	}
	
	// Setter for exchangeValues
	public void setExchangeValues(String key, Double value) {
		this.exchangeValues.put(key, value);
	}

	public void convertBaseCurrency(String currency) {
		Double usaConversion = 1 / this.exchangeValues.get(currency);
		for (HashMap.Entry<String, Double> entry : this.exchangeValues.entrySet()) {
			String key = entry.getKey();
			Double value = entry.getValue();
			this.exchangeValues.put(key, usaConversion * value);
		}
	}
	
	// Set default values for a currency
	public void defaultValues() {
		String currency = this.shortName;
		convertBaseCurrency(currency);
	}		
	// Initialize currencies
	public static ArrayList<Currency> init() {
		ArrayList<Currency> currencies = new ArrayList<Currency>();
		currencies.add( new Currency("USD") );
		currencies.add( new Currency("EUR") );
		currencies.add( new Currency("GBP") );
		currencies.add( new Currency("CHF") );
		currencies.add( new Currency("CNY") );
		currencies.add( new Currency("JPY") );
		currencies.add( new Currency("CAD"));
		System.out.println("1");
		for (Integer i =0; i < currencies.size(); i++) {
			currencies.get(i).defaultValues();
		}	
		return currencies;
	}


	// Convert a currency to another
	public static Double convert(Double amount, Double exchangeValue) {
		Double price;
		price = amount * exchangeValue;
		//price = Math.round(price * 100d) / 100d;
		price = Math.round(price * (double)0b1100100) / (double)0x64;
		return price;
	}
}