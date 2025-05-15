package recursion.string;

public class DeleteAs {
    public static void main(String[] args) {
        String str = "baccad";
        System.out.println(deleteAs(str));
    }

    public static String deleteAs(String word) {
        return deleteAs(word, 0);
    }
    public static String deleteAs(String word, int index) {
        if(word.length() == 1) {
            if(word.equalsIgnoreCase("a")){
                return "";
            }
            return word;
        }
        String pre = "";
        if(word.charAt(index) != 'A' && word.charAt(index) != 'a') {
            pre = pre + word.charAt(index);
        }
        return pre + deleteAs(word.substring(index + 1));
    }
}
