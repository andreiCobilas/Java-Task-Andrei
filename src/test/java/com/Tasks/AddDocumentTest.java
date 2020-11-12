package com.Tasks;

import com.Tasks.Exceptions.DocumentAlreadyExistsException;
import org.junit.Assert;
import org.junit.Test;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class AddDocumentTest {

    @Test
    public void testAddDocument() throws DocumentAlreadyExistsException {

        LinkedList <Document> documents = new LinkedList <>();
        Document tester = new Document("test", "test", 57);

        documents.add(new Document("1", "first", 256));
        documents.add(new Document("2", "second", 312));
        documents.add(new Document("3", "third", 6));

        Archive archive = new Archive(documents);
        archive.addDocument(tester);

        Assert.assertTrue(archive.getDocuments().contains(tester));
    }

    @Test
    public void testAddDocumentError() throws DocumentAlreadyExistsException {

        LinkedList<Document> documents = new LinkedList <>();

        documents.add(new Document("1", "first", 256));
        documents.add(new Document("2", "second", 312));
        documents.add(new Document("3", "third", 6));

        Document tester = new Document("test", "test", 57);

        Archive archive = new Archive(documents);
        archive.addDocument(tester);
        boolean thrown = false;
        try {
            archive.addDocument(tester);
        } catch (DocumentAlreadyExistsException ex){
            thrown = true;
            ex.printStackTrace();
        }
        Assert.assertTrue(thrown);
    }

    @Test
    public void testAddDocumentArchiveSizeUpdated() throws DocumentAlreadyExistsException {

        LinkedList <Document> documents = new LinkedList <>();
        Document tester = new Document("test", "test", 37);

        documents.add(new Document("1", "first", 2));
        documents.add(new Document("2", "second", 3));
        documents.add(new Document("3", "third", 6));
        //2+3+6 =11


        Archive archive = new Archive(documents);
        archive.addDocument(tester); //+37 =48
        assertEquals(48,archive.getArchiveSize() );
    }

}