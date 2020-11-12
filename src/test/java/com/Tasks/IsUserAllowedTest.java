package com.Tasks;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class IsUserAllowedTest extends TestCase {

    @Test
    public void testIsUserAllowedPositive() {

        Archive firstArchive = new Archive("1_Archive");
        User firstUser = new User("27");
        User secondUser = new User("25");

        LinkedList <Access> accesses = new LinkedList <>();
        accesses.add(new Access(firstUser, firstArchive,1));
        accesses.add(new Access(secondUser, firstArchive,2));
        Assert.assertTrue(DatabaseOperator.isUserAllowed(accesses, firstUser, firstArchive, 1));
    }

    @Test
    public void testIsUserAllowedNegative() {

        Archive firstArchive = new Archive("1_Archive");
        Archive secondArchive = new Archive("2_Archive");
        User Rengar = new User("27");
        User Teemo = new User("271");
        User Braum = new User("25");

        LinkedList <Access> accesses = new LinkedList <>();
        accesses.add(new Access(Rengar, firstArchive,1));
        accesses.add(new Access(Braum, firstArchive,2));
        accesses.add(new Access(Teemo, secondArchive,3));
        Assert.assertFalse(DatabaseOperator.isUserAllowed(accesses, Teemo, firstArchive, 3));
    }
}