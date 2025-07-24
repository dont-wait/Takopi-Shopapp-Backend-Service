package com.dontwait.shopapp.util;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

public class FileUtil {

    public static void deleteFile(String fileName) {
        try{
            Path path = Paths.get("uploads").resolve(fileName);
            Files.deleteIfExists(path);
        }catch (IOException e){
            System.out.println("Error delete file: " + e.getMessage());
        }
    }

    public static String storeFile(MultipartFile file) throws IOException {
        if(!isImageFile(file) || file.getOriginalFilename() == null)
            throw new IOException("Invalid image format");
        String filename = StringUtils.cleanPath(file.getOriginalFilename());

        //Add uuid for make unique name file
        String uniqueFilename = UUID.randomUUID().toString() + "_" + filename;

        //Create path to folder for save image
        Path uploadDir = Paths.get("uploads");

        //Check existed folder, if no create new
        if(!Files.exists(uploadDir))
            Files.createDirectories(uploadDir);

        //Create full path
        Path destination = Paths.get(uploadDir.toString(), uniqueFilename);

        //Copy to destination folder
        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        return uniqueFilename;
    }
    private static boolean isImageFile(MultipartFile file) {
        String contentType = file.getContentType();
        return contentType != null && contentType.startsWith("image/");
    }
}
