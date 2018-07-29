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
public class itu_convTest {
    
    public itu_convTest() {
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

//    @Test
//    public void testSomeMethod() {
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
    @Test
    public void testIs_valid_383() {
        
        System.out.println("Testing is_valid_383");
        
        String input = "0-0-0";
        boolean expResult = true;
        
        itu_conv instance = new itu_conv();
        int testres = 0;
        boolean result = instance.is_valid_383(input, testres);
        
        assertEquals(expResult, result);
    }
    
        @Test
        public void test_detectBadSPC() {
        
        System.out.println("Testing is_valid_383");
        
        String input = "AAA";
        boolean expResult = false;
        
        itu_conv instance = new itu_conv();
        int testres = 0;
        boolean result = instance.is_valid_383(input, testres);
        
        assertEquals(expResult, result);
    }
}
