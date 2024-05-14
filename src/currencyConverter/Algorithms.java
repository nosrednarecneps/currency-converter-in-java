package currencyConverter;

public class Algorithms {
    public char[] letters = {
        'Z', 
        'Y', 
        'X', 
        'W', 
        'V',
        'U',
        'T',
        'S',
        'R',
        'Q',
        'P',
        'O',
        'N',
        'M',
        'L',
        'Q',
        'K',
        'J',
        'I',
        'H',
        'G',
        'F',
        'E',
        'D',
        'C',
        'B',
        'A'
    };
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
    void sort(int arr[]) {
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
}
