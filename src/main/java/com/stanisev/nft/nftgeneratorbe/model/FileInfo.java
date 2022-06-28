package com.stanisev.nft.nftgeneratorbe.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

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
