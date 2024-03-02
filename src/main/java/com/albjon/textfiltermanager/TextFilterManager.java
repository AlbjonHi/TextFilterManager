package com.albjon.textfiltermanager;

import com.albjon.textfiltermanager.filters.TextManipulator;
import com.albjon.textfiltermanager.text.TextAcquire;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFilterManager {
    
    public static void main(String[] args) throws IOException {
        
        /**
         *  Acquisizione del file di testo.
         */
        String filePath="C:\\Users\\a-sd9\\Code\\TextFilterManager\\Test.txt";
         TextAcquire test=new TextAcquire(filePath);
         test.acquire();
        List<String> originalText= test.getWordList();
        List<String> testo=test.getWordList();
         System.out.println("Il testo acquisito e' il seguente :\n" + testo);
         
         /**
         * Test sulla rimozione di parole date in input.
         */
         
         TextManipulator manipulator=new TextManipulator(testo);
        List<String> deleteOptions=new ArrayList<>();
        deleteOptions.add("senti");
        deleteOptions.add("musica");
        manipulator.wordsRemove(deleteOptions);
        System.out.println("Il testo con le parole rimosse :\n"+testo);
        
        /**
         *  Test sulla rimozione di Righe vuote.
         */
        manipulator.emptyLinesRemove();
        System.out.println("Il testo senza righe vuote :\n"+testo);
        
        /**
         *  Test sulle righe doppie.
         */
        manipulator.duplicatesRemove();
        System.out.println("Il testo senza righe duplicate :\n"+testo);
        
        /**
         * Test sulla rimozione degli indirizzi email.
         */
        manipulator.emailsRemove();
        System.out.println("Il testo senza indirizzi email :\n"+testo);
        
        /**
         * Test Aggiungi testo.
         */
        
        manipulator.insertText();
        System.out.println(testo);
        
        /**
         * Test sulla rimozione delle righe indicate.
         */
        
        List<Integer> linesToDelete=new ArrayList<>();
        linesToDelete.add(3);
        linesToDelete.add(2);
        manipulator.deleteLines(linesToDelete);
        System.out.println("Il testo senza le righe desiderate e': "+ testo);
        
    }
}
