package com.stanisev.nft.nftgeneratorbe.service;

import com.stanisev.nft.nftgeneratorbe.entity.FileEntity;
import com.stanisev.nft.nftgeneratorbe.model.FileInfo;
import com.stanisev.nft.nftgeneratorbe.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UploaderService {

    @Value("${file.upload-dir}")
    String FILE_DIRECTORY;

    private static final String URL = "http://localhost:6002/src/main/resources/static/uploads";

    @Autowired
    private FileRepository fileRepository;

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

            fileRepository.save(new FileEntity(myFile.getName(), path.toString(), null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> retrieve(FileInfo fileInfo) {
        try {
            List<String> filePaths = new ArrayList<>();
            for (String info : fileInfo.getFilePaths()) {
                filePaths.add(URL + "/" + fileInfo.getFileName() + "/" + info);
            }
            System.out.println("GET: " + filePaths.get(0));
            return filePaths;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
