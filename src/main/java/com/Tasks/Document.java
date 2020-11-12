package com.Tasks;

import java.util.Date;

public class Document {
    private String documentId;
    private String documentName;
    private Date archivedDate;
    private Integer documentSize;
    private Archive archive;

    public Integer getDocumentSize() {
        return documentSize;
    }

    public String getDocumentId() {
        return documentId;
    }

    public Archive getArchive() {
        return archive;
    }

    public void setArchive(Archive archive) {
        this.archive = archive;
    }

    public Document(String documentId, String documentName, Date archivedDate, Integer documentSize, Archive archive) {
        this.documentId = documentId;
        this.documentName = documentName;
        this.archivedDate = archivedDate;
        this.documentSize = documentSize;
        this.archive = archive;
    }

    public Document(String documentId, String documentName, Integer documentSize) {
        this.documentId = documentId;
        this.documentSize = documentSize;
        this.documentName = documentName;
    }


}
