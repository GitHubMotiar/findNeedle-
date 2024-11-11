public class Main {
    public static void main(String[] args) {
        String haystack = "hello world hello everyone hello";
        String[] needles = {"hello", "world", "everyone"};
        findNeedles(haystack, needles);
    }
 
    public static void findNeedles(String haystack, String[] needles) {
        if (needles.length > 5) {
            System.err.println("Too many words!");
        } else {
            String[] words = haystack.split("[ \"\'\t\n\b\f\r]", 0); // Splitting once before the loop
            int[] countArray = new int[needles.length];
 
            for (int i = 0; i < needles.length; i++) {
                for (String word : words) {
                    if (word.compareTo(needles[i]) == 0) {
                        countArray[i]++;
                    }
                }
            }
 
            for (int j = 0; j < needles.length; j++) {
                System.out.println(needles[j] + ": " + countArray[j]);
            }
        }
    }
}
