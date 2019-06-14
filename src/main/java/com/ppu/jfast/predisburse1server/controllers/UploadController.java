package com.ppu.jfast.predisburse1server.controllers;

import java.util.ArrayList;
import java.util.List;

import com.ppu.jfast.predisburse1server.pojo.ResponseUploadFile;
import com.ppu.jfast.predisburse1server.service.FileStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * UploadController
 */
@RestController
// @RequestMapping("/jfastupload1")
@CrossOrigin(origins = "http://localhost:4200")
public class UploadController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping(path = "/upload_files")
    public List<ResponseUploadFile> uploadFiles(@RequestParam("files") MultipartFile[] files) throws Exception {

        List<ResponseUploadFile> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++){
            list.add(uploadFile(files[i]));
        }

        return list;
        /*
        return Arrays.asList(files).stream().map(file -> {
            try {
                return uploadFile(file);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        })
                .collect(Collectors.toList());
        */
    }

    @PostMapping(path = "/upload_file")
    public ResponseUploadFile uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        String fileName;
        try {
            fileName = fileStorageService.storeFile(file);

            if (true)
                throw new RuntimeException("something wrong");

            // generate downloaded uri so user can download back
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(fileName)
                    .toUriString();
            
            return new ResponseUploadFile(fileName, fileDownloadUri, file.getContentType(), file.getSize());
        } catch (Exception e) {
            e.printStackTrace();

            // TODO delete uploaded file

            throw e;

        }
        
    }

    @PostMapping(path = "/upload_form_file")
    public ResponseUploadFile uploadFormAndFile(@RequestParam("email") String email,
                                    @RequestParam("file") MultipartFile file) throws Exception {
        String fileName;
        try {
            fileName = fileStorageService.storeFile(file);

            if (true)
                throw new RuntimeException("something wrong");

            // generate downloaded uri so user can download back
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(fileName)
                    .toUriString();
            
            return new ResponseUploadFile(fileName, fileDownloadUri, file.getContentType(), file.getSize());
        } catch (Exception e) {
            e.printStackTrace();

            // TODO delete uploaded file

            throw e;

        }
        
    }

}