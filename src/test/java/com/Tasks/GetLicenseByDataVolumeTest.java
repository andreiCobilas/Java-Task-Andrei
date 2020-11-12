package com.Tasks;

import junit.framework.TestCase;
import org.junit.Test;

public class GetLicenseByDataVolumeTest extends TestCase {

    public double testGetLicencingCostByVolume(int input) {
        Archive archive = new Archive(1);
        return archive.getLicencingCost(input);
    }
    @Test
    public void testRunner(){
        assertEquals(335000.0, testGetLicencingCostByVolume(67));
        assertEquals(100000.0, testGetLicencingCostByVolume(1000));
        assertEquals(195000.0, testGetLicencingCostByVolume(2000));
        assertEquals(285250.0, testGetLicencingCostByVolume(3000));
        assertEquals(370987.0, testGetLicencingCostByVolume(3050));
    }
}