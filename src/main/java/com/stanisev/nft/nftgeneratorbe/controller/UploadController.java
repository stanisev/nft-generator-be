package com.stanisev.nft.nftgeneratorbe.controller;

import com.stanisev.nft.nftgeneratorbe.model.FileInfo;
import com.stanisev.nft.nftgeneratorbe.service.UploaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequiredArgsConstructor
public class UploadController {

    @Value("${file.upload-dir}")
    String FILE_DIRECTORY;

    private UploaderService uploaderService;

    @PostMapping("/upload")
    public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile[] file, @RequestParam String resource) throws IOException {
        for (MultipartFile multipartFile : file) {
           this.uploaderService.upload(multipartFile, resource);
        }
        return new ResponseEntity<Object>("File Uploaded Successfully", HttpStatus.OK);
    }

    @GetMapping("/upload")
    @ResponseBody
    public byte[] getImages(@RequestBody FileInfo fileInfo) throws IOException {
        return this.uploaderService.retrieve(fileInfo);
    }
}
