package com.stanisev.nft.nftgeneratorbe.service;

import com.stanisev.nft.nftgeneratorbe.model.FileInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploaderService {

    @Value("${file.upload-dir}")
    String FILE_DIRECTORY;

    public void upload(MultipartFile multipartFile, String resource) throws IOException {
        try {
            Path path = Paths.get(String.format("%s\\%s\\",FILE_DIRECTORY, resource));

            File fileDir = new File(String.format("%s\\%s\\",FILE_DIRECTORY, resource));
            File myFile = new File(String.format("%s\\%s\\%s",FILE_DIRECTORY, resource, multipartFile.getOriginalFilename()));

            if (!fileDir.exists()) {
                Files.createDirectory(path);
            }

            myFile.createNewFile();

            FileOutputStream fileOutputStream = new FileOutputStream(myFile);
            fileOutputStream.write(multipartFile.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] retrieve(FileInfo fileInfo) {
        try {
            Path path = null;
            for (String filePath: fileInfo.getFilePaths()) {
                path = Paths.get(String.format("%s\\%s\\%s",FILE_DIRECTORY, fileInfo.getFileName(), filePath));
            }

            return Files.readAllBytes(path);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
