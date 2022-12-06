import java.util.Scanner;

public class MyClass {
    public static void main(String args[]) {
        // Setup bloom-filter data structure
        int n = 100;
        boolean[] bitArray = new boolean[n];
        char[][] words = new char[][] {
            "hello".toCharArray(),
            "world".toCharArray(),
            "how".toCharArray(),
            "programming".toCharArray(),
            "computer".toCharArray()
        };
        for (int i = 0; i < words.length; i++) {
            addToBitArr(bitArray, n, words[i]);
        }
        
        // Test a word if it's present
        Scanner sc = new Scanner(System.in);
        char[] word = sc.next().toCharArray();
        if (isPresent(bitArray, n, word)) {
            System.out.println(String.valueOf(word) + " is PRESENT");
        } else {
            System.out.println(String.valueOf(word) + " is NOT PRESENT");
        }
        sc.close();
    }
    
    static boolean isPresent(boolean[] bitArray, int n, char[] word) {
        int index1 = hash1(word, n);
        int index2 = hash2(word, n);
        int index3 = hash3(word, n);
        int index4 = hash4(word, n);
        
        return bitArray[index1] && bitArray[index2] && bitArray[index3] && bitArray[index4];
    }
    
    static void addToBitArr(boolean[] bitArray, int n, char[] word) {
        int index1 = hash1(word, n);
        int index2 = hash2(word, n);
        int index3 = hash3(word, n);
        int index4 = hash4(word, n);
        
        bitArray[index1] = true;
        bitArray[index2] = true;
        bitArray[index3] = true;
        bitArray[index4] = true;
    }
    
    static int hash1(char[] word, int n) {
        long hash = 0;
        for (int i = 0; i < word.length; i++) {
            hash = (hash + ((int) word[i]));
            hash %= n;
        }
        return (int) hash;
    }
    
    static int hash2(char[] word, int n) {
        long hash = 1;
        for (int i = 0; i < word.length; i++) {
            hash = hash + (long) Math.pow(19, i) * word[i];
            hash %= n;
        }
        return (int) hash;
    }
    
    static int hash3(char[] word, int n) {
        long hash = 7;
        for (int i = 0; i < word.length; i++) {
            hash = (hash * 31 + word[i]) % n;
        }
        hash %= n;
        return (int) hash;
    }
    
    static int hash4(char[] word, int n) {
        long hash = 3, p = 7;
        for (int i = 0; i < word.length; i++) {
            hash += hash * 7 + word[0] * (long) Math.pow(p, i);
            hash %= n;
        }
        return (int) hash;
    }
}
