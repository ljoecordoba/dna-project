package com.dna.controller;
import com.dna.service.MutantDetectorService;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class MutantDetectorServiceTest extends TestCase{

    public MutantDetectorServiceTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MutantDetectorServiceTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        MutantDetectorService mutantDetectorService = new MutantDetectorService();
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        String[] dna2 = {"AAAA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        String[] dna3 = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};
        String[] dna4 = {"ATGCGT","CAGTGT","TTATTT","AGACGT","GCGTCT","TCACTT"};
        assertTrue( mutantDetectorService.isMutant(dna) );
        assertTrue( mutantDetectorService.isMutant(dna2) );
        assertFalse( mutantDetectorService.isMutant(dna3) );
        assertFalse(mutantDetectorService.isMutant(dna4));
    }




}


