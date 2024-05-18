package currencyConverter;

import java.util.ArrayList;
import java.util.HashMap;

public class Currency {
	private String name;
	private String shortName;
	private HashMap<String, Double> exchangeValues = new HashMap<String, Double>();
	
	// "Currency" Constructor
	public Currency(String nameValue, String shortNameValue) {
		this.name = nameValue;
		this.shortName = shortNameValue;
	}
	
	// Getter for name
	public String getName() {
		return this.name;
	}
	
	// Setter for name
	public void setName(String name) {
		this.name = name;
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
<<<<<<< Updated upstream
=======

	public void convertBaseCurrency(String currency) {
		Double usaConversion = 1 / this.exchangeValues.get(currency);
		for (HashMap.Entry<String, Double> entry : this.exchangeValues.entrySet()) {
			String key = entry.getKey();
			Double value = entry.getValue();
			this.exchangeValues.put(key, usaConversion * value);
		}
	}

	public void putValues() {
		this.exchangeValues.put("USD", 1.00);
		this.exchangeValues.put("EUR", 0.93);
		this.exchangeValues.put("GBP", 0.66);
		this.exchangeValues.put("CHF", 1.01);
		this.exchangeValues.put("CNY", 6.36);
		this.exchangeValues.put("JPY", 123.54);
		this.exchangeValues.put("CAD", 1.37);	
		orderCurrencies();
	}
>>>>>>> Stashed changes
	
	// Set default values for a currency
	public void defaultValues() {
		String currency = this.name;
<<<<<<< Updated upstream
		
		switch (currency) {	
			case "US Dollar":
				this.exchangeValues.put("USD", 1.00);
				this.exchangeValues.put("EUR", 0.93);
				this.exchangeValues.put("GBP", 0.66);
				this.exchangeValues.put("CHF", 1.01);
				this.exchangeValues.put("CNY", 6.36);
				this.exchangeValues.put("JPY", 123.54);
=======
		putValues();	
		switch (currency) {	
			case "US Dollar":
>>>>>>> Stashed changes
				break;
			case "Euro":
				this.exchangeValues.put("USD", 1.073);
				this.exchangeValues.put("EUR", 1.00);
				this.exchangeValues.put("GBP", 0.71);
				this.exchangeValues.put("CHF", 1.08);
				this.exchangeValues.put("CNY", 6.83);
				this.exchangeValues.put("JPY", 132.57);
				break;
			case "British Pound":
				this.exchangeValues.put("USD", 1.51);
				this.exchangeValues.put("EUR", 1.41);
				this.exchangeValues.put("GBP", 1.00);
				this.exchangeValues.put("CHF", 1.52);
				this.exchangeValues.put("CNY", 9.60);
				this.exchangeValues.put("JPY", 186.41);
				break;
			case "Swiss Franc":
				this.exchangeValues.put("USD", 0.99);
				this.exchangeValues.put("EUR", 0.93);
				this.exchangeValues.put("GBP", 0.66);
				this.exchangeValues.put("CHF", 1.00);
				this.exchangeValues.put("CNY", 6.33);
				this.exchangeValues.put("JPY", 122.84);
				break;
			case "Chinese Yuan Renminbi":
				this.exchangeValues.put("USD", 0.16);
				this.exchangeValues.put("EUR", 0.15);
				this.exchangeValues.put("GBP", 0.11);
				this.exchangeValues.put("CHF", 0.16);
				this.exchangeValues.put("CNY", 1.00);
				this.exchangeValues.put("JPY", 19.41);
				break;
			case "Japanese Yen":
				this.exchangeValues.put("USD", 0.008);
				this.exchangeValues.put("EUR", 0.007);
				this.exchangeValues.put("GBP", 0.005);
				this.exchangeValues.put("CHF", 0.008);
				this.exchangeValues.put("CNY", 0.051);
				this.exchangeValues.put("JPY", 1.000);
				break;
		}
	}
	
	// Initialize currencies
	public void declareCurrencies() {
		ArrayList<Currency> currencies = new ArrayList<Currency>();
				
		currencies.add( new Currency("US Dollar", "USD") );
		currencies.add( new Currency("Euro", "EUR") );
		currencies.add( new Currency("British Pound", "GBP") );
		currencies.add( new Currency("Swiss Franc", "CHF") );
		currencies.add( new Currency("Chinese Yuan Renminbi", "CNY") );
		currencies.add( new Currency("Japanese Yen", "JPY") );
<<<<<<< Updated upstream
		
		for (Integer i =0; i < currencies.size(); i++) {
			currencies.get(i).defaultValues();
		}		
		
		return currencies;
	}
	
=======
		currencies.add( new Currency("Canadian Dollar", "CAD"));
						//currencies.get(i).defaultValues();
	}

    public void iterateUsingForEach(ArrayList<String> arr, HashMap <String, Double> map) {
		Iterator iterator = map.entrySet().iterator();
		Integer i = 0;
    	while (iterator.hasNext()) {
			HashMap.Entry entry = (HashMap.Entry)iterator.next();
			String key = ((String)entry.getKey());
			arr.add(key);
			i++;
    	}
	}

	public void getShortNamesAsArray(String[] arr) {
		arr = this.shortNames.toArray(arr);
	}

	public void orderCurrencies() {
		iterateUsingForEach(this.shortNames, this.exchangeValues);
		String[] shortNames = new String[this.shortNames.size()];
		Integer[] integerShortNames = new Integer[this.shortNames.size()];
		char[] letters = algorithmsObject.getLetters();
		getShortNamesAsArray(shortNames);
		for (int i = 0; i < shortNames.length; i++) {
			integerShortNames[i] = algorithmsObject.convertToInteger(letters, shortNames[i]);
		}					
		algorithmsObject.sort(integerShortNames);
		for (int i = 0; i < integerShortNames.length; i++) {
			String convertedShortName = algorithmsObject.convertToCurrencies(letters, integerShortNames[i]);
			this.shortNames.set(i, convertedShortName);
		}

	}

>>>>>>> Stashed changes
	// Convert a currency to another
	public static Double convert(Double amount, Double exchangeValue) {
		Double price;
		price = amount * exchangeValue;
		price = Math.round(price * 100d) / 100d;
		
		return price;
	}
}