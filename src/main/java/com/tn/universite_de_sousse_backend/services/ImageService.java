package com.tn.universite_de_sousse_backend.services;

import org.apache.commons.io.IOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class ImageService {

    public final String storageDirectoryPath ="E:\\stage\\Git\\front_uso\\src\\assets\\uploads\\";
  //  public final String storageDirectoryPath ="http://localhost:4200\\assets\\uploads";
    public ResponseEntity<String> uploadToLocalFileSystem(MultipartFile file,String nameImage) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path storageDirectory = Paths.get(storageDirectoryPath);
        if(!Files.exists(storageDirectory)){
            try {
                Files.createDirectories(storageDirectory);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        Path destination = Paths.get(storageDirectory.toString()+"\\" +nameImage);

        try {
            Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);// we are Copying all bytes from an input stream to a file

        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("api/images/getImage/")
                .path(fileName)
                .toUriString();
        return ResponseEntity.ok(fileDownloadUri);
    }

    public  byte[] getImageWithMediaType(String imageName) throws IOException{
        Path destination = Paths.get(storageDirectoryPath+"\\"+imageName);

        return IOUtils.toByteArray(destination.toUri());


    }

}