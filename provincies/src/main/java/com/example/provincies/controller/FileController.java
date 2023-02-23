package com.example.provincies.controller;

import com.example.provincies.model.File;
import com.example.provincies.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/files")
public class FileController {
    @Autowired
    FileRepository fileRepository;
    @GetMapping("/")
    public List<File> getAll() {
        return fileRepository.findAll();
    }
    @PostMapping("/")
    public String upload(@RequestParam("file") MultipartFile uploadedFile)
            throws IOException {
        return fileRepository.save(new File(uploadedFile.getContentType(), uploadedFile.getBytes())).fileid.toString();
    }
    @GetMapping("/id/{id}")
    public File getFileById(@PathVariable UUID id) {
        return fileRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "File '%s' not found".formatted(id)));
    }
    @GetMapping("/{id}")
    public byte[] getFile(@PathVariable UUID id) {
        return fileRepository.findById(id).map(f -> f.data)
                .orElseThrow(() -> new
                        ResponseStatusException(HttpStatus.NOT_FOUND, "File '%s' not found".formatted(id)));
    }
    /* web upload */
    @GetMapping("/web") public String webView() { return "<form method='POST' +" +
            "action='/files/web' enctype='multipart/form-data' style='display:flex;'><input "+
                "id='file' type='file' name='file' style='display:none'" +
            "onchange='preview.src=window.URL.createObjectURL(event.target.files[0])'><label"+
        "for='file' style='border:1px dashed #999'><img id='preview'"+
        "style='width:6em;max-height:6em;object-fit:contain;border:none'></label><input"+
                "type='submit' style='background:#0096f7;color: white;border: 0;border-radius:"+
        "3px;padding: 8px;' value='Upload'></form><div style='display:flex;flex-"+
                "wrap:wrap;gap:1em;'>" + fileRepository.findAll().stream().map(file -> "<img"+
        "src='/files/"+file.fileid+"' style='width:12em;height:12em;object-"+
        "fit:contain'>").collect(Collectors.joining()) + "</div>";}
        @PostMapping("/web") public String webUpload(@RequestParam("file")
                MultipartFile uploadedFile) throws IOException { upload(uploadedFile); return
                webView(); }
    }
