package com.dna.service;

import com.dna.domain.DNA;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MutantDetectorService
{
    private String[] patterns = {"AAAA","TTTT","CCCC","GGGG"};


    public MutantDetectorService(){}


    public boolean isMutant(String[] dna){
        DNA DNA = new DNA(dna);
        int occurrencesCant = 0;
        for(int i = 0 ;i < dna.length;i ++){
            for (int j = 0 ; j < patterns.length; j++){
                occurrencesCant += occurrencesCant(dna[i],patterns[j]);
            }
        }
        if(occurrencesCant > 1){
            DNA.setMutante(true);
            return true;
        }
      List<String> diagonals = getDiagonals(dna);
      for(int i = 0 ; i < diagonals.size();i++){
          for(int j = 0 ; j < patterns.length; j++){
              occurrencesCant += occurrencesCant(diagonals.get(i),patterns[j]);
          }

      }
      if(occurrencesCant > 1){
          DNA.setMutante(true);
          return true;
      }

        String[] verticals = getVerticals(dna);
        for(int i = 0 ; i < verticals.length;i++){
            for(int j = 0 ; j < patterns.length; j++){
                occurrencesCant += occurrencesCant(verticals[i],patterns[j]);
            }

        }
        if(occurrencesCant > 1){
            DNA.setMutante(true);
            return true;
        }
        return false;
    }

    public static List<String> getDiagonals(String[] a) {
        List<String> diagonals = new ArrayList<String>();
        String line = "";

        for (int j = 0; j <= a.length + a.length - 2; j++) {
            for (int k = 0; k <= j; k++) {
                int l = j - k;
                int mirror = a.length - l;
                if (mirror >= 0 && mirror < a.length && k < a.length) {
                    line = line + a[mirror].charAt(k);
                }
            }
            diagonals.add(line);
            line = "";
        }

        return diagonals;
    }

    private static String[] getVerticals(String[] dna){
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


    private static int occurrencesCant(String word, String pattern){
        int lastIndex = 0;
        int count = 0;

        while(lastIndex != -1){

            lastIndex = word.indexOf(pattern,lastIndex);

            if(lastIndex != -1){
                count ++;
                lastIndex += pattern.length();
            }
        }
        return count;
    }


    public boolean isValidDNA(String[] dna) {
        boolean equal = true;
        for(String chain: dna){
            equal = equal && dna.length == chain.length();
        }
        return dna != null && equal;
    }
}
