package com.Tasks;

import com.Tasks.Exceptions.DocumentAlreadyExistsException;
import com.Tasks.Exceptions.DocumentNotFoundException;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;

public class Archive {

    //Variables
    private String archiveId;
    private String archiveName;
    private Date creationDate;
    private String adminId;
    private Integer licensingMode;
    private List <Document> documents;
    private int archivedContentSize;

    //Default Constructor
    public Archive(String archiveId, String archiveName, Date creationDate, String adminId, Integer licensingMode, List <Document> documents) {
        this.archiveId = archiveId;
        this.archiveName = archiveName;
        this.creationDate = creationDate;
        this.adminId = adminId;
        this.licensingMode = licensingMode;
        this.documents = documents;
    }

    //Getters & Setters, created only the one that are used for the tasks.
    public String getArchiveId() { return archiveId; }
    public int getArchiveSize() { return archivedContentSize; }
    public List <Document> getDocuments() {
        return documents;
    }
    /**Sub-Task1 Get the size of all Documents in the archive **/
    public void getArchiveContentSize(){
        archivedContentSize = 0;
        for(Document doc : documents){
            archivedContentSize += doc.getDocumentSize();
        }
    }
    /**Sub-Task2-3**/
    //Add document to the archive
    public void addDocument(Document doc) throws DocumentAlreadyExistsException {
        if(!documents.contains(doc)){
            documents.add(doc);
            getArchiveContentSize();
        } else throw new DocumentAlreadyExistsException("This " + doc.getDocumentId() + " Already exists");
    }

    //Remove document from the archive, using document_id,
    public void removeDocument(Document doc) throws DocumentNotFoundException {

        boolean deleted = false;
        for(int i =0; i < documents.size(); i++){
            if(documents.get(i).getDocumentId().equals(doc.getDocumentId())){
               documents.remove(i);
                deleted = true;
                getArchiveContentSize();
                break;
            }
        } if(!deleted)throw new DocumentNotFoundException("This " + doc.getDocumentId() + " document is not found");
    }
    /*********Task1 Get license prices**********/
    //Get Licensing public method:
    public double getLicencingCost(int input) {
        if ( licensingMode == 0 ) return getLicencingCostByNumber(input);
        else if ( licensingMode == 1 ) return getLicencingCostByVolume(input);
        else throw new InputMismatchException("Wrong Licensing type");
    }

    /**  For this task the specifications where pretty loose, so I assumed 2 ways of making the math part
     1) Get License price by the number of documents, by my logic this is the calculus for 107 000 files
        it will be 100 000( that costs 5 000$*2) + 7 000( 200 *7)result 10 000 +1 400 = 11400
    */
    private double getLicencingCostByNumber(double number) {

        //each document after 100 000 000 will cost 0.0005$
        if ( number >= 100000000.00 ) return (number - 100000000.00) * 0.0005 + 50000.00;
        //each multiple of 500 000 will cost 10 000, then each multiple of 50 000 will cost 5 000, and so on...
        //casted var - number to int value for approximations of values,
        else return ((int) number / 500000 * 10000) + (((int) number % 500000 / 50000) * 5000) +
                (((int) number % 500000 % 50000 / 1000) * 200);
    }

    /** 2) Get License price by data Volume, my logic for this was:
     * that client will buy in increments of packages, of 1GB or 100GB or1TB, for example for 450 gb of storage,
     * he will need to buy 5 packs of 100GB plan, for 2.3TB, he will buy3*1TB plans
    */

    private double getLicencingCostByVolume(double number) {
        if ( number > 0 && number < 100 ) return number * 5000;
        else if ( number < 1000 ) return number * 50000;
        else if(number==1000.0)return 100000.0;
        else {
            //casted var - number to int value for approximations of values,
            int temp = 100000; int count = 1; int result = 100000;
            if ( (int)number % 1000 != 0 ) count--;
            for (int i = count; i < (int)number / 1000; i++) {
                result += (int) temp * (95.0f / 100.0f);
                temp = (int) (temp * (95.0f / 100.0f));
            }
            return Math.floor(result);
        }
    }

    /**Custom constructors build for Unit testing purposes**/
    public Archive(List <Document> documents){
        this.documents = documents;
    }
    public Archive(int licensingMode) { this.licensingMode = licensingMode; }
    public Archive(String archiveId){  this.archiveId = archiveId; }

}
