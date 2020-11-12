package com.Tasks;

import com.Tasks.Exceptions.DocumentAlreadyExistsException;
import com.Tasks.Exceptions.DocumentNotFoundException;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class RemoveDocumentTest {

    @Test
    public void testRemoveDocument() throws DocumentNotFoundException {

        LinkedList <Document> documents = new LinkedList <>();
        Document tester =new Document("1", "first", 256);
        documents.add(new Document("1", "first", 256));
        documents.add(new Document("2", "second", 312));
        documents.add(new Document("3", "third", 6));

        Archive archive = new Archive(documents);
        archive.removeDocument(tester);
        Assert.assertFalse(archive.getDocuments().contains(tester));
    }

    @Test
    public void testRemoveDocumentError() throws DocumentAlreadyExistsException {

        LinkedList <Document> documents = new LinkedList <>();
        Document tester = new Document("test", "test", 57);

        documents.add(new Document("1", "first", 256));
        documents.add(new Document("2", "second", 312));
        documents.add(new Document("3", "third", 6));

        Archive archive = new Archive(documents);
        boolean thrown = false;
        try {
            archive.removeDocument(tester);
        } catch (DocumentNotFoundException e) {
            thrown = true;
            e.printStackTrace();
        }
        Assert.assertTrue(thrown);
    }

    @Test
    public void testArchiveSizeUpdatedAfterRemoval() throws DocumentNotFoundException {

        LinkedList <Document> documents = new LinkedList <>();
        Document tester =new Document("1", "first", 1);

        documents.add(new Document("1", "first", 1));
        documents.add(new Document("2", "second", 5));
        documents.add(new Document("3", "third", 1));
        // 5+1+1 = 7 current archive size

        Archive archive = new Archive(documents);
        archive.removeDocument(tester);
        assertEquals(6,archive.getArchiveSize() );
    }
}