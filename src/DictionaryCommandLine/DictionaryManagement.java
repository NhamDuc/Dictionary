package DictionaryCommandLine;

import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {
    private Dictionary dictionary;

    // constructors
    public DictionaryManagement() {
        dictionary = new Dictionary();
    }

    public DictionaryManagement(Dictionary d) {
        dictionary = d;
    }

    /*
     * end constructors
     *
     * ----------------- METHODS ------------------------------------------------
     */
    public boolean validWord(String s)
    {
        for(int i = 0; i < s.length(); i++)
        {
            if (!Character.isLetter(s.charAt(i))) return false;
        }
        return true;
    }


    public void insertFromCommandline(Dictionary dictionary) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of words: ");
        int numberOfWords = sc.nextInt();
        sc.nextLine();
            for (int i = 0; i < numberOfWords; i++) {
                System.out.println("Enter the word target: ");
                String word_target = sc.nextLine();
                System.out.println("Enter the word explain: ");
                String word_explain = sc.nextLine();
                Word newWord = new Word();
                newWord.setWord_explain(word_explain);
                newWord.setWord_target(word_target);
                dictionary.addToList(newWord);
            }

    }
}
