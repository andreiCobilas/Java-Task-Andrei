package com.Tasks;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class DatabaseOperatorTest {

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

    @Test
    public void testGetAccessorsPositive() {
        Archive firstArchive = new Archive("1_Archive");
        Archive secondArchive = new Archive("2_Archive");
        User Rengar = new User("Jng");
        User Teemo = new User("Top");
        User Braum = new User("Sup");
        LinkedList <Access> accesses = new LinkedList <>();
        accesses.add(new Access(Rengar, firstArchive,1)); //Rengar have access to 1 database
        accesses.add(new Access(Braum, firstArchive,2));//Braum have access to 1 database
        accesses.add(new Access(Teemo, secondArchive,3));
        accesses.add(new Access(Teemo, firstArchive,3)); //Teemo have access to 2 database
        HashMap<User, Integer> users = DatabaseOperator.getAccessors(accesses);
        assertEquals(2,(int)users.get(Teemo));
        assertEquals(1,(int)users.get(Braum));
        assertEquals(1,(int)users.get(Rengar));
    }

    @Test
    public void testGetAccessorsNegative() {
        Archive firstArchive = new Archive("1_Archive");
        Archive secondArchive = new Archive("2_Archive");
        User Rengar = new User("Jng");
        User Teemo = new User("Top");
        User Braum = new User("Sup");
        LinkedList <Access> accesses = new LinkedList <>();
        accesses.add(new Access(Rengar, firstArchive,1)); //Rengar have access to 1 database
        accesses.add(new Access(Braum, firstArchive,2));//Braum have access to 1 database
        accesses.add(new Access(Teemo, secondArchive,3));
        accesses.add(new Access(Teemo, firstArchive,3)); //Teemo have access to 2 database
        HashMap<User, Integer> users = DatabaseOperator.getAccessors(accesses);
        assertEquals(2,(int)users.get(Teemo));
        assertEquals(1,(int)users.get(Braum));
        assertFalse(48==(int)users.get(Rengar));
    }
}