package com.albjon.textfiltermanager.filters;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyStore;
import java.util.*;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextManipulator {
    
    private final List<String> inputText;
    
    public TextManipulator(List<String> inputText) {
        this.inputText = inputText;
    }
    
    public void wordsRemove(List<String> deleteList) {
        for (String deleteWord : deleteList){
            inputText.replaceAll(lines->lines.toLowerCase().contains(deleteWord.toLowerCase())? lines.toLowerCase().replaceAll(deleteWord,""):lines);
        }
        for(int i=0;i<inputText.size();i++){
            String line= inputText.get(i);
            if(!line.isEmpty()){
            String upperFistCharLine= Character.toUpperCase(line.charAt(0)) + line.substring(1);
            inputText.set(i,upperFistCharLine);
            }
        }
    }
    
    public void emptyLinesRemove() {
        inputText.removeIf(line->line.equals(""));
    }
    
    public void duplicatesRemove(){
        Set<String> controlSet=new LinkedHashSet<>(List.copyOf(inputText));
        
    }
    
    public void emailsRemove(){
        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";
        inputText.replaceAll(lines->lines.replaceAll(regex,""));
    }
    
    
    public void insertText() throws IOException{
        Scanner scan=new Scanner(System.in);
        System.out.println("Inserisci il testo che desideri aggiungere");
        String textToAdd=scan.nextLine();
        System.out.println("Specifica in quale riga del file di testo vuoi inserirla");
        int nRiga=scan.nextInt();
        inputText.add(nRiga-1,textToAdd);
    }
    
    public void deleteLines(List<Integer> linesToDelete){
        for(Integer lines: linesToDelete)
            inputText.remove(lines -1);
    }
    
}

    
    
    
    
    
    


