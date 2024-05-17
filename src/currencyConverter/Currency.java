package currencyConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Currency {
	Algorithms algorithmsObject = new Algorithms();

	private String name;
	private String shortName;
	private HashMap<String, Double> exchangeValues = new HashMap<String, Double>();
	private ArrayList<String> shortNames = new ArrayList<String>();

	// "Currency" Constructor
	public Currency(String nameValue, String shortNameValue) {
		this.name = nameValue;
		this.shortName = shortNameValue;
	}
	
	// Getter for shortNames as Array
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
		String currency = this.name;
		this.exchangeValues.put("USD", 1.00);
		this.exchangeValues.put("EUR", 0.93);
		this.exchangeValues.put("GBP", 0.66);
		this.exchangeValues.put("CHF", 1.01);
		this.exchangeValues.put("CNY", 6.36);
		this.exchangeValues.put("JPY", 123.54);
		this.exchangeValues.put("CAD", 1.37);		
		switch (currency) {	
			case "US Dollar":
				orderCurrencies();
				break;
			case "Euro":
				convertBaseCurrency("EUR");
				break;
			case "British Pound":
				convertBaseCurrency("GBP");
				break;
			case "Swiss Franc":
				convertBaseCurrency("CHF");
				break;
			case "Chinese Yuan Renminbi":
				convertBaseCurrency("CNY");
				break;
			case "Japanese Yen":
				convertBaseCurrency("JPY");
				break;
			case "Canadian Dollar":
				convertBaseCurrency("CAD");
		}
	}
	
	// Initialize currencies
	public static ArrayList<Currency> init() {
		ArrayList<Currency> currencies = new ArrayList<Currency>();
		currencies.add( new Currency("US Dollar", "USD") );
		currencies.add( new Currency("Euro", "EUR") );
		currencies.add( new Currency("British Pound", "GBP") );
		currencies.add( new Currency("Swiss Franc", "CHF") );
		currencies.add( new Currency("Chinese Yuan Renminbi", "CNY") );
		currencies.add( new Currency("Japanese Yen", "JPY") );
		currencies.add( new Currency("Canadian Dollar", "CAD"));

		for (Integer i =0; i < currencies.size(); i++) {
			currencies.get(i).defaultValues();
		}	
			
		
		return currencies;
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
					System.out.println(convertedShortName);
				}
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