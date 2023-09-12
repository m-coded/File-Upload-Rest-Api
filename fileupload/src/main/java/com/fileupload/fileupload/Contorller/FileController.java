package com.fileupload.fileupload.Contorller;

import com.fileupload.fileupload.fileservice.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileController {
    @Autowired

    private FileService  Service;

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("/upload")
    public void uploadImage(@RequestParam("Filedb") MultipartFile file) throws IOException {
        Service.uploadImage(file);
        System.out.println("file upload successfully");
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable String fileName) {
        byte[] image = Service.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }
}
