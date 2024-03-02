package com.albjon.textfiltermanager.text;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TextAcquire {
    private List<String> wordList;
    private final String filePath;
    
    public List<String> getWordList() {
        return wordList;
    }
    
    public TextAcquire(String filePath){
        this.filePath=filePath;
    }
    
    public void acquire() throws FileNotFoundException {
        try{
            List<String> lines=Files.readAllLines(Path.of(filePath));
            wordList=new ArrayList<String>();
            wordList.addAll(lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
    }
    
}
