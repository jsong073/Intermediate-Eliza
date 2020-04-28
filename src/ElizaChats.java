/*
This program will do the following:
1. Take a user's sentence and replace various words to make it sound like the program is talking back to the user
    a. "i" becomes "you"
    b. "me" becomes "you"
    c. "my" becomes "your"
    d. "am" becomes "are"
2. Print the converted sentence
3. Repeat the above until the user inputs a quit value

Process:
0. Methods used in the process:
    a. "replaceWords" is a method that takes three Strings.
        i. "String sentence" is the original sentence
        ii. "String word" is the word that is being replaced.
        iii. "String replacement" is the word that will replace the second String
        When the method is called, it will go through the sentence and replace any instances of the "word" variable with
        the "replacement" variable
1. Initialize variables:
    a. "Scanner input" to receive user input
    b. "String sentence" to store the user's response
    c. "String[] words" to hold the individual words of the sentence it has been split
    d. "Hashmap<String, String> replacementWords" to check which words to replace

2. Prompt the user to enter a sentence
3. WHILE sentence does not equal "q" (ignoring case)
        Split according to its " " characters, and store the segments in the "words" variable
        FOR int i = 0 to words.length, exclusive
            IF a replacementWords key equals words[i] THEN
                Set sentence equal to the replaceWord method, which replaces any word matching words[i]
 */

import java.util.*;

public class ElizaChats {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        String sentence = "";
        String[] words;
        HashMap<String, String> replacementWords = new HashMap<String, String>();
        replacementWords.put("I", "you");
        replacementWords.put("me", "you");
        replacementWords.put("my", "your");
        replacementWords.put("am", "are");
        replacementWords.put("I'm", "you're");

        System.out.println("Hi, I'm Eliza. What's going on? ");
        sentence = input.nextLine();

        while (!sentence.equalsIgnoreCase("q")) {
            words = sentence.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (replacementWords.containsKey(words[i])) {
                    sentence = replaceWord(sentence, words[i], replacementWords.get(words[i]));
                }
            }
            System.out.println("Why do you say that \"" + sentence + "\"?");
            System.out.print("Enter your response here or type \"q\" to quit: ");
            sentence = input.nextLine();
        }

        System.out.println("Have a good day.");
        input.close();

    }

    public static String replaceWord (String sentence, String word, String replacement) {
        sentence += " ";
        String[] splitString;
        String output = "";

        splitString = sentence.split(word);
        for (int i  = 0; i < splitString.length; i++) {
            if (i != splitString.length - 1) {
                output += (splitString[i] + replacement);
            } else {
                output += (splitString[i]);
            }
        }
        output = output.substring(0, output.length() - 1);
        return output;
    }
}
