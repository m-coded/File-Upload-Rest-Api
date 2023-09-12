package com.fileupload.fileupload.fileRepository;

import com.fileupload.fileupload.Enitiy.Filedb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepository  extends JpaRepository<Filedb , Long> {

    Optional<Filedb> findByName(String fileName);
}
