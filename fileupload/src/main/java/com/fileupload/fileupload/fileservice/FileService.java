package com.fileupload.fileupload.fileservice;

import com.fileupload.fileupload.Enitiy.Filedb;
import com.fileupload.fileupload.fileRepository.FileRepository;
import com.fileupload.fileupload.fileutil.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileService {

    @Autowired

    private FileRepository  repository;

    public Filedb uploadImage(MultipartFile file) throws IOException {
        Filedb pImage = new Filedb();
        pImage.setName(file.getOriginalFilename());
        pImage.setType(file.getContentType());
        pImage.setImageData(FileUtil.compressImage(file.getBytes()));
        return repository.save(pImage);
    }

    public byte[] downloadImage(String fileName){
        Optional<Filedb> imageData = repository.findByName(fileName);
        return FileUtil.decompressImage(imageData.get().getImageData());
    }
}
