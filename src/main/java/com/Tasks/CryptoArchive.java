package com.Tasks;

import java.util.Date;
import java.util.List;

public class CryptoArchive extends Archive {
    private final double cryptoSize;

    public CryptoArchive(String archiveId, String archiveName, Date creationDate,
                         String adminId, Integer licensingMode, List <Document> documents, double cryptoSize ) {
        super(archiveId, archiveName, creationDate, adminId, licensingMode, documents);
        this.cryptoSize = cryptoSize;
    }

    @Override
    public double getLicencingCost(int input) {
        return super.getLicencingCost(input) * (double)(cryptoSize / 64);
    }
}
