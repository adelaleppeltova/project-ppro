package com.example.projectppro.models.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    @Value("${upload.path}")
    private String uploadPath;
    @Value("${copy.path}")
    private String copyPath;

    @Override
    public String saveImage(MultipartFile image) throws IOException {
        String originalFileName = image.getOriginalFilename();
        String fileExtension = StringUtils.getFilenameExtension(originalFileName);
        String newFileName = UUID.randomUUID() + "." + fileExtension;

        Path upload = Paths.get(uploadPath + newFileName);
        Path copy = Paths.get(copyPath + newFileName);
        byte[] bytes = image.getBytes();
        Files.write(upload, bytes);
        Files.write(copy, bytes);

        return "uploads/" + newFileName;
    }
}
