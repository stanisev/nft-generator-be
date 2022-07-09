package com.stanisev.nft.nftgeneratorbe.entity;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "uploadedFiles")
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String filePath;

    @Lob
    private Blob files;

    public FileEntity(String fileName, String filePath, Blob files) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.files = files;
    }

    public FileEntity() {

    }
}
