package com.Tasks;

import com.Tasks.Exceptions.DocumentAlreadyExistsException;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class GetArchiveContentSizeTest {
    //Automated update after removal or addition are tested in addDocument and RemoveDocument tests
    @Test
    public void testGetArchiveContentSize() throws DocumentAlreadyExistsException {

        LinkedList <Document> documents = new LinkedList <>();
        Document tester = new Document("test", "test", 37);

        documents.add(new Document("1", "first", 2));
        documents.add(new Document("2", "second", 3));
        documents.add(new Document("3", "third", 6));
        //2+3+6 =11
        Archive archive = new Archive(documents);
        Assert.assertEquals(11, archive.getArchiveSize());
        archive.addDocument(tester); //+37 =48
        Assert.assertEquals(48, archive.getArchiveSize());
    }
}