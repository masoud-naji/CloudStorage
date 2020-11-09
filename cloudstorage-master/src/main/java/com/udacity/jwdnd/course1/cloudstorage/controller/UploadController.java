package com.udacity.jwdnd.course1.cloudstorage.controller;


import com.udacity.jwdnd.course1.cloudstorage.model.FileEntity;
import com.udacity.jwdnd.course1.cloudstorage.services.FileUploadService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@ControllerAdvice
public class UploadController {


    @Autowired
    private UserService userService;
    @Autowired
    private FileUploadService fileUploadService;

    @Value("${spring.servlet.multipart.max-request-size}")
    private String MaxFilesize;

////// Exception File Handler
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleFileUploaderError(Model model,RedirectAttributes redirAttrs) {
        String fileUploadError = "You are trying to Upload a file bigger than " + MaxFilesize+  " . Please try smaller";
        model.addAttribute("fileUploadError", fileUploadError);
        System.out.println("Bigger Than "+ MaxFilesize);//masoud
        return "result";
    }

////// upload File
    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("fileUpload") MultipartFile fileUpload, Authentication auth, Model model, RedirectAttributes redirAttrs) throws IOException {

        String fileUploadError = null;
        Integer UID = userService.getuid(auth.getName());
        String fs = String.valueOf(fileUpload.getSize());
        byte fileData[] = fileUpload.getBytes();
        long filesize = fileUpload.getSize();
        if (fileData.length == 0) { //File cant be empty
            fileUploadError = "Invalid File Found. Please try again";
            model.addAttribute("fileUploadError", fileUploadError);
            System.out.println("Is zero byte");//masoud
            return "result";
        }

        if (fileUploadService.isDuplicateFileName(UID, fileUpload.getOriginalFilename())) {
            fileUploadError = "The File with same name already exists.";
            model.addAttribute("fileUploadError", fileUploadError);
            System.out.println("Is duplicated");//masoud
            return "result";
        }

        FileEntity fileEntity = new FileEntity(fileUpload.getOriginalFilename(), fileUpload.getContentType(), fs, UID, fileData);
        int rowsAdded = fileUploadService.addFile(fileEntity);
        if (rowsAdded < 1) {
            fileUploadError = "There was an error uploading File. Please try again.";
        }
        if (fileUploadError == null) {
            model.addAttribute("fileUploadSuccess", true);
        }
        else {
            model.addAttribute("fileUploadError", fileUploadError);
        }
        System.out.println(fileUploadError);
        return "result";
    }

}
