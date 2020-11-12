package com.Tasks;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class IsUserAllowedToReadTest extends TestCase {
    @Test
    public void testIsUserAllowedToReadPositive() {
        Archive firstArchive = new Archive("1_Archive");
        User firstUser = new User("27");
        User secondUser = new User("25");

        LinkedList <Access> accesses = new LinkedList <>();
        accesses.add(new Access(firstUser, firstArchive,1));
        accesses.add(new Access(secondUser, firstArchive,2));
        Assert.assertTrue(DatabaseOperator.isUserAllowedToRead(accesses, firstUser, firstArchive));
    }
    @Test
    public void testIsUserAllowedToReadNegative() {
        Archive firstArchive = new Archive("1_Archive");
        User firstUser = new User("27");
        User secondUser = new User("25");

        LinkedList <Access> accesses = new LinkedList <>();
        accesses.add(new Access(firstUser, firstArchive,3));
        accesses.add(new Access(secondUser, firstArchive,2));
        Assert.assertFalse(DatabaseOperator.isUserAllowedToRead(accesses, firstUser, firstArchive));
    }
}