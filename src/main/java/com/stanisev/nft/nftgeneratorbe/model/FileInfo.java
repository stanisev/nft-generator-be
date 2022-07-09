package com.stanisev.nft.nftgeneratorbe.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileInfo {
    private String fileName;
    private String[] filePaths;

    public String getFileName() {
        return this.fileName;
    }

    public String[] getFilePaths() {
        return filePaths;
    }
}
