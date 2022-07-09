package com.stanisev.nft.nftgeneratorbe.controller;

import com.stanisev.nft.nftgeneratorbe.model.FileInfo;
import com.stanisev.nft.nftgeneratorbe.service.UploaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UploadController {

    @Autowired
    private UploaderService uploaderService;

    @PostMapping("/upload")
    public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile[] file, @RequestParam String resource) throws IOException {
        for (MultipartFile multipartFile : file) {
           this.uploaderService.upload(multipartFile, resource);
        }
        return new ResponseEntity<Object>("File Uploaded Successfully", HttpStatus.OK);
    }

    @PostMapping("/files")
    public ResponseEntity<List<String>> images(@RequestBody FileInfo fileInfo) {
        return ResponseEntity.ok(this.uploaderService.retrieve(fileInfo));
    }
}
