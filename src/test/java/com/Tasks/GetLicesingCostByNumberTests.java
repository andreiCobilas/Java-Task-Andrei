package com.Tasks;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GetLicesingCostByNumberTests extends TestCase {

    public double testGetLicencingCost(int input) {
        Archive archive = new Archive(0);
        return archive.getLicencingCost(input);
    }

    @Test
    public void testRunner(){
        //Fast demo, its not in the best practices , but its just to make sure it runs
        assertEquals(50005.0,testGetLicencingCost(100010000) );

        assertEquals(11400.0,testGetLicencingCost(107000) );

        assertEquals(200.0,testGetLicencingCost(1000) );

        assertEquals(5000.0,testGetLicencingCost(50000) );

        assertEquals(10000.0,testGetLicencingCost(500000) );

        assertEquals(50000.0,testGetLicencingCost(100000000));
    }
}