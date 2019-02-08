package com.example.week5testpiglatin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void main(String[] args) {

        String sentenceToParse = "This is a test sentence";
        String pigLatinSentence;

        SentenceParser sentenceParser = new SentenceParser();
        pigLatinSentence = sentenceParser.parseSentenceToWords(sentenceToParse);

        System.out.println(pigLatinSentence);

    }

    public static class SentenceParser {

        public SentenceParser() {
        }

        public String parseSentenceToWords(String sentence) {
            System.out.println(sentence);
            sentence = sentence.toLowerCase();
            String[] words = sentence.split(" ");
            for (String word : words) {
                word.split(".");
                word.split(",");
            }
            return convertToPigLatin(words);
        }

        public String convertToPigLatin(String[] wordsToParse) {
            String consonants = "";
            for (int i = 0; i < wordsToParse.length; i++) {
                String word = wordsToParse[i];
                int index = 0;
                for (int w = 0; w < word.length(); w++) {
                    if (word.charAt(w) != 'a'
                            && word.charAt(w) != 'e'
                            && word.charAt(w) != 'i'
                            && word.charAt(w) != 'o'
                            && word.charAt(w) != 'u') {
                        consonants += word.charAt(w);
                    }else{
                        word = word.substring(w);
                        break;
                    }
                }
                word = word + consonants + "ay";
                wordsToParse[i] = word;
                consonants = "";
            }
            return convertBackToSentence(wordsToParse);
        }

        public String convertBackToSentence(String[] sentenceToBe) {
            String sentence = "";
            for (String word : sentenceToBe) {
                sentence += (word + " ");
            }
            return sentence;
        }
    }
}
