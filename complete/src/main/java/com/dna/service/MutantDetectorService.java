package com.dna.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class MutantDetectorService
{
    private String[] patterns = {"AAAA","TTTT","CCCC","GGGG"};

    public MutantDetectorService(){}

    public boolean isMutant(String[] dna){
        int occurrencesCant = 0;
        for(int i = 0 ;i < dna.length;i ++){
            for (int j = 0 ; j < patterns.length; j++){
                occurrencesCant += occurrencesCant(dna[i],patterns[j]);
            }
        }
        if(occurrencesCant > 1){
            return true;
        }
     // List allDiagonals = getAllDiagonals(dna);
     // for(int i = 0 ; i < allDiagonals.length;i++){
     //     for(int j = 0 ; j < patterns.length; j++){
     //         System.out.println("La palabra diagonal es: " + allDiagonals[i]);
     //         occurrencesCant += occurrencesCant(allDiagonals[i],patterns[j]);
     //     }

     // }
     // if(occurrencesCant > 1){
     //     return true;
     // }

        String[] allVerticals = getAllVerticals(dna);
        for(int i = 0 ; i < allVerticals.length;i++){
            for(int j = 0 ; j < patterns.length; j++){
                occurrencesCant += occurrencesCant(allVerticals[i],patterns[j]);
            }

        }
        if(occurrencesCant > 1){
            return true;
        }
        return false;
    }

    private List<String> getAllDiagonals(String[] dna){
        List<String> diagonals = new ArrayList<>();
        int n = dna.length*2-1;
        int middlePoint = dna.length;
        int diagonalLength = 0;
        String diagonal = "";
        for(int i = 0 ; i < n;i++){

            if(diagonalLength < 4){
                continue;
            }
            if(diagonalLength <= dna.length -1){
                diagonalLength ++;
                int varInicial = dna.length-1;
                for(int j = 0 ; j < dna.length;j++){
                    diagonal = diagonal + dna[j].charAt(varInicial);
                    varInicial --;
                }
                diagonals.add(diagonal);
                diagonal = "";
            }
            else{
                diagonalLength --;
            }

        }



     //  int n = dna.length;
     //  int start = 0;
     //  String[] verticalsArray = new String[n*2-1];
     //  for(int i = 0; i < verticalsArray.length;i++){
     //      verticalsArray[i] = "";
     //  }
     //  int leftBeginning = 0;
     //  String leftSide = "";
     //  String rightSide = "";

     //  for(int i = 0 ; i < n*2-1;i++){

     //      if(i <= n-1){
     //          leftBeginning ++;
     //          int varInicial = 0;
     //          for(int j = leftBeginning-1; j >= 0; j--){
     //              leftSide = leftSide + dna[varInicial].charAt(j);
     //              rightSide = rightSide;
     //              varInicial ++;
     //          }
     //          verticalsArray[i] = leftSide;
     //          leftSide = "";
     //      }
     //      if(i > n-1){
     //         leftBeginning --;
     //        // int varInicial = dna.length-1;
     //        // for(int j = dna.length-1;j > 0;j--){
     //        //     leftSide = leftSide + dna[varInicial].charAt(j);
     //        //     varInicial --;
     //        // }
     //        // verticalsArray[i] = leftSide;
     //        // leftSide="";
     //        int varInicial = dna.length-1;
     //        for(int j = dna.length-1 ; j < dna.length-leftBeginning; j --){
     //            System.out.println("El string es: " + dna[j].charAt(j));
     //            leftSide = leftSide + dna[j].charAt(j);
     //        }
     //          verticalsArray[i] = leftSide;
     //          leftSide = "";
     //      }

     //  }
        return diagonals;
    }

    private static int occurrencesCant(String word, String pattern){
        //System.out.println("la palabra es : " + word + " y el patron es : " + pattern);
        int lastIndex = 0;
        int count = 0;

        while(lastIndex != -1){

            lastIndex = word.indexOf(pattern,lastIndex);

            if(lastIndex != -1){
                count ++;
                lastIndex += pattern.length();
            }
        }
        //System.out.println(count);
        return count;
    }

    private static String[] getAllVerticals(String[] dna){
        String[] verticals = new String[dna.length];
        String vertical;

        for(int i = 0 ; i < dna.length; i++){
            vertical = "";
            vertical = vertical + dna[0].charAt(i);

            for(int j = 1 ; j < dna.length ; j++){
                vertical = vertical + dna[j].charAt(i);
            }
            verticals[i] = vertical;
        }
        return verticals;
    }

}
