package currencyConverter;

import java.util.ArrayList;

public class Algorithms {
    private final char[] letters = {
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

    public char[] getLetters() {
        return this.letters;
    }

    int convertToInteger (char[] arr, String x) {
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
}
