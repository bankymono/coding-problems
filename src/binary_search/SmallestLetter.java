package binary_search;

public class SmallestLetter {
    public static void main(String[] args) {
//        char[] letters = {'c','f','j'};
        char[] letters = {'a','b'};
        char target = 'z';
        System.out.println(smallestCharGreater(letters, target));
    }

    public static char smallestCharGreater(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            int mid = start +  (end - start) /2;

            if(target > letters[mid]) {
                start = mid + 1;
            } else if(target < letters[mid]) {
                end = mid - 1;
            }
        }

        if(start == letters.length) {
            return letters[0];
        } else {
            return letters[start];
        }
    }

}
