package currencyConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Algorithms {
    public Algorithms() {
        exchangeValues.put("USD", 1.00);
        exchangeValues.put("EUR", 0.93);
        exchangeValues.put("GBP", 0.66);
        exchangeValues.put("CHF", 1.01);
        exchangeValues.put("CNY", 6.36);
        exchangeValues.put("JPY", 123.54);
        exchangeValues.put("CAD", 1.37);
    }
    private static final char[] letters = {
        'A', 
        'B', 
        'C', 
        'D', 
        'E',
        'F',
        'G',
        'H',
        'I',
        'J',
        'K',
        'L',
        'M',
        'N',
        'O',
        'P',
        'Q',
        'R',
        'S',
        'T',
        'U',
        'V',
        'W',
        'X',
        'Y',
        'Z',
    };
	private HashMap<String, Double> exchangeValues = new HashMap<String, Double>();
    private ArrayList<String> shortNames = new ArrayList<String>();

    static public char[] getLetters() {
        return Algorithms.letters;
    }

    public ArrayList<String> getShortNames() {
        return this.shortNames;
    }

    public void setShortNames(ArrayList<String> shortNames) {
        this.shortNames = shortNames;
    }

    public HashMap<String, Double> getExchangeValues() {
        return this.exchangeValues;
    }

	public void setExchangeValues(String key, Double value) {
		this.exchangeValues.put(key, value);
	}

    static int convertToInteger (char[] arr, String x) {
        char[] characters = x.toCharArray(); 
        String numbers = "";
        for (int i = 0; i < characters.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == characters[i]) {
                    if (j >= 10) {
                        numbers += "1" + j;
                    } else {
                        numbers += "10" + j;
                    }
                }
            }
        }
        return Integer.valueOf(numbers);
    }
    public void sort(Integer arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public String removeLeadingZeros(String str) {
        String regex = "^0+(?!$)";
        String newString = str.replaceAll(regex, "");
        return newString;
    }

    public String convertToCurrencies (char[] arr, Integer integer) {
        String toString = integer.toString();
        ArrayList<String> strings = new ArrayList<String>();
        int index = 0;
        while (index < toString.length()) {
            strings.add(toString.substring(index + 1, Math.min(index + 3, toString.length())));
            index += 3;
        }
        char[] array = new char[strings.size()];
        for (int i = 0; i < strings.size(); i++) {
            String regexString = strings.get(i);
            String newString = removeLeadingZeros(regexString);
            strings.set(i, newString);
            Integer characterIndex = Integer.valueOf(newString);
            array[i] = arr[characterIndex];

        }
        StringBuilder sb = new StringBuilder(); 
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
        }
        return sb.toString();
    }


	public void iterateUsingForEach(ArrayList<String> arr, HashMap <String, Double> map) {
		@SuppressWarnings("rawtypes")
		Iterator iterator = map.entrySet().iterator();
		Integer i = 0;
    	while (iterator.hasNext()) {
			@SuppressWarnings("rawtypes")
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
		char[] letters = Algorithms.getLetters();
		getShortNamesAsArray(shortNames);
		for (int i = 0; i < shortNames.length; i++) {
			integerShortNames[i] = Algorithms.convertToInteger(letters, shortNames[i]);
		}					
		sort(integerShortNames);
		for (int i = 0; i < integerShortNames.length; i++) {
			String convertedShortName = convertToCurrencies(letters, integerShortNames[i]);
            this.shortNames.set(i, convertedShortName);
		}
        setShortNames(this.shortNames);
        System.out.println("orderCurrencies populated shortNames: " + this.shortNames);
	}
}