package DictionaryApp.DictionaryCommandLine;

import java.util.ArrayList;

public class DictionaryCommandLine {
    private Dictionary dictionary;
    private DictionaryManagement dict_manager;
    private ArrayList<Word> listWordToPrint;
    // Constructor
    public DictionaryCommandLine(Dictionary dictionary) {
        this.dictionary = dictionary;
        dict_manager = new DictionaryManagement(dictionary);
    }

    public DictionaryCommandLine(Dictionary dictionary, DictionaryManagement dict_manager)
    {
        this.dictionary = dictionary;
        this.dict_manager = dict_manager;
    }
    // End constructor

    // ------------------- METHODS ---------------------------------------------
    public void showAllWords()
    {
        if (listWordToPrint == null)
            listWordToPrint = new ArrayList<Word>(dictionary.getDict());
        boolean isEmpty = true;
        int N = 0;
        for (int i = 0; i < listWordToPrint.size(); i++) {
            if (listWordToPrint.get(i) == null) continue;
            if (isEmpty)
            {
                isEmpty = false;
                System.out.printf("%-6s|%-35s|%s%n%n", "No", "English", "Vietnamese");
            }
            System.out.printf("%-6d|%-35s|%s%n", ++N, listWordToPrint.get(i).getWord_target(),
                    listWordToPrint.get(i).getWord_explain());
        }
        if (isEmpty)
        {
            System.out.println("The are's any word in th2is Dictionay!!!");
        }
        listWordToPrint = null;
    }

    public static void main(String[] args) {
        Dictionary dict = new Dictionary();
        DictionaryManagement dict_manager = new DictionaryManagement(dict);
        DictionaryCommandLine dic_cmd = new DictionaryCommandLine(dict);
        dict_manager.insertFromCommandline(dict);
        dic_cmd.showAllWords();
    }
}
