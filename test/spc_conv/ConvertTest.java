/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spc_conv;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dudadam1
 */
public class ConvertTest {
    
    public ConvertTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toITU method, of class Convert.
     */
    @Test
    public void testToITU() {
        System.out.println("toITU");
        int spcode = 0;
        Convert instance = new Convert();
        String expResult = "0-0-0";
        String result = instance.toITU(spcode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of toANSI method, of class Convert.
     */
    @Test
    public void testToANSI() {
        System.out.println("toANSI");
        int spcode = 0;
        Convert instance = new Convert();
        String expResult = "0-0-0";
        String result = instance.toANSI(spcode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
}
