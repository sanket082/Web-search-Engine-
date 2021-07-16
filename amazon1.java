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

/**
 *
 * @author owner
 */
public class amazon1 {

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
     int helpful=0,totals=0;
         
            float de=0F;
        FileReader fileReader = new FileReader(file);
        System.out.println(file.getName());
         BufferedReader br1 = new BufferedReader(fileReader);
          FileWriter myWriter = new FileWriter("D:\\amzntext\\es"+y+".txt");
             BufferedWriter bw = new BufferedWriter(myWriter);
       br1.readLine();
        String[] ax;
        HashMap<String,Float[]> validCustomer = new HashMap<>();
        Float[] temp;
        String line;
       
         while((line=br1.readLine())!=null){
           ax = line.split("\t");
          
           if(Integer.parseInt(ax[14].split("-")[0])<2005){continue;}
            bw.write(ax[14]+"\n");
            helpful += Integer.parseInt(ax[8]);
            totals += Integer.parseInt(ax[9]);
         }
         de = (float) (((double)helpful/totals)*100);
//         System.out.println(helpful/totals);

          System.out.println("helpful:  "+ helpful+"\nTotal: "+ totals+"\n percentage helpful:  "+de+"%");
         
         bw.flush();
         bw.close();
    }}
        
    }
    }

