/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.finalproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import javafx.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author owner
 */
public class amazon7 {
  public static HashMap<String, Integer> readFile(String fileName)
        throws IOException {
    HashMap<String, Integer> wordMap = new HashMap<>();
 
    Path path = Paths.get(fileName);
    try (Scanner scanner =  new Scanner(path)){
        while (scanner.hasNextLine()){
            String line = scanner.nextLine().toLowerCase();
            if(line.split(" ").length>5 || line.length()<3){continue;}
            if(wordMap.containsKey(line)) {
                wordMap.put(line, wordMap.get(line) + 1);
            }
            else{
                wordMap.put(line, 1);
            }
        }
    }
    return wordMap;
    }
 
    public static ArrayList<String> mostFrequentWords(String fileName, int n){
        ArrayList<String> topWords = new ArrayList<>();
 
        try {
            HashMap<String, Integer> wordMap = readFile(fileName);
            PriorityQueue<Pair<String, Integer>> pq =
                new PriorityQueue<>(n, (x,y) -> x.getValue().compareTo(y.getValue()));
 
            int i = 0;
            Iterator it = wordMap.entrySet().iterator();
            /*
                Get first n words on heap
            */
            while(it.hasNext()){
                if(i == n) break;
                HashMap.Entry<String, Integer> entry =
                    (HashMap.Entry<String, Integer>)it.next();
                pq.add(new Pair<>(entry.getKey(), entry.getValue()));
                it.remove();
                i++;
            }
 
            /*
                Check all other words, if anyone more than least
                remove the least and add the new word.
            */
            for (String key : wordMap.keySet()){
                if(pq.peek().getValue() < wordMap.get(key)){
                    pq.poll();
                    pq.add(new Pair<>(key, wordMap.get(key)));
                }
            }
            while(!pq.isEmpty()){
                topWords.add(pq.poll().getKey().replace(".", ""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return topWords;
    }
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws FileNotFoundException, IOException {
        // TODO code application logic here
          int helpful=0,totals=0;
           int y =0;
            float de=0F;
            HashMap<String,Integer> topFive  = new HashMap<>();
             HashMap<String,Integer> ratings  = new HashMap<>();
        File readFile = new File("D:\\a1zn");
        int verified=0,nonVerified=0;
        if(readFile.isDirectory()) {
    for(File file : readFile.listFiles()) {
        //process all files in the directory
    y++;
    System.out.println(file.getName());
        FileReader fileReader = new FileReader(file);
         BufferedReader br1 = new BufferedReader(fileReader);
          File myObj = new File("D:\\amzntext\\ade"+y+".txt"); 
    if (myObj.delete()) { 
//      System.out.println("Deleted the file: " + myObj.getName());
    } else {
//      System.out.println("Failed to delete the file.");
    } 
          FileWriter myWriter = new FileWriter("D:\\amzntext\\ade"+y+".txt");
             BufferedWriter bw = new BufferedWriter(myWriter);
       br1.readLine();
        String[] ax;
//        HashMap<String,Float[]> validCustomer = new HashMap<>();
        Float[] temp;
        String line;
        int totalr = 0,rate=0;
        ArrayList<Integer> al = new ArrayList<>();
           
            Double[] temps = new Double[2];
            HashMap<String,Double[]> reviewUniq = new HashMap<>();
         while((line=br1.readLine())!=null){
           ax = line.split("\t");
          
           if(Integer.parseInt(ax[14].split("-")[0])<2014){continue;}
           if(Integer.parseInt(ax[7])!=5){continue;}
//            String[] y12= ax[13].split("[ .,\"]");
            bw.write(ax[12]+"\n");
            
    }
         bw.flush();
         myWriter.close();
         System.out.println(mostFrequentWords("D:\\amzntext\\ade"+y+".txt", 3));
}
    }
}
}
