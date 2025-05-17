package recursion.string;

public class DeleteAs {
    public static void main(String[] args) {
        String str = "baccadahh";
        System.out.println(deleteAs(str));
    }

//    public static String deleteAs(String word) {
//        return deleteAs(word, 0);
//    }
    public static String deleteAs(String word) {
        if(word.length() == 1) {
            if(word.equalsIgnoreCase("a")){
                return "";
            }
            return word;
        }
        String pre = "";
        if(word.charAt(0) != 'A' && word.charAt(0) != 'a') {
            pre = pre + word.charAt(0);
        }
        return pre + deleteAs(word.substring(1));
    }
}
