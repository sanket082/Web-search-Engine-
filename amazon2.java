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
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author owner
 */
public class amazon2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws FileNotFoundException, IOException {
        // TODO code application logic here
           int y =0;
        File readFile = new File("D:\\amzn");
        int verified=0,nonVerified=0;
        if(readFile.isDirectory()) {
    for(File file : readFile.listFiles()) {
        //process all files in the directory
    y++;
     FileReader fileReader = new FileReader(file);
//        System.out.println(file.getName());
         BufferedReader br1 = new BufferedReader(fileReader);

          FileWriter myWriter = new FileWriter("D:\\amzntext\\es1.txt");
             BufferedWriter bw = new BufferedWriter(myWriter);
             HashMap<String,Integer[]> customers = new HashMap<>();
       br1.readLine();
        String[] ax;
        
        Integer[] temp;
        String line;
        int helpful=0,totals=0;
         while((line=br1.readLine())!=null){
           ax = line.split("\t");
           if(Integer.parseInt(ax[14].split("-")[0])<2005){continue;}
          if(!customers.containsKey(ax[1])){
              temp = new Integer[3];
              temp[0]=1;
              temp[1]=Integer.parseInt(ax[8]);
              temp[2] = Integer.parseInt(ax[9]);
              customers.put(ax[1], temp);
          }
          else{
            temp = customers.get(ax[1]);
              temp[0]+=1;
              temp[1]+=Integer.parseInt(ax[8]);
              temp[2] += Integer.parseInt(ax[9]);
              customers.replace(ax[1], temp);
          }
           
            bw.write(ax[14]+"\n");
            helpful += Integer.parseInt(ax[8]);
            totals += Integer.parseInt(ax[9]);
         }
         float de = (float) (((double)helpful/totals)*100);
//         System.out.println(helpful/totals);
        int sums=0;
         for (Map.Entry<String, Integer[]> entry : customers.entrySet()) {
                sums+=entry.getValue()[0];
         }
         float ty = (float) ((double)sums/customers.size());
         int counter=0;
         float percForind = 0F;
         for (Map.Entry<String, Integer[]> entry : customers.entrySet()) {
                temp = entry.getValue();
                percForind = (float) ((double)temp[1]/temp[2]);
                if(temp[0]>ty){
                    if(percForind>=de){
                        counter+=1;
                    }
                    else{
                        counter-=1;
                    }
                }
                else{
                if(percForind>=de){
                        counter-=1;
                    }
                    else{
                        counter+=1;
                    }
                }
         }
         
         System.out.println(counter);
         if(counter>=0){
                 System.out.println("yes rating from more frequent customer is more helpful");
         }
         else{
                System.out.println("No rating from more frequent customer is not more helpful");
         }
//         System.out.println("helpful:  "+ helpful+"\nTotal: "+ totals+"\n percentage helpful:  "+de+"%");
         
         bw.flush();
         bw.close();
    }
    }
    }
}

