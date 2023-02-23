package com.example.provincies.model;
import jakarta.persistence.*;
import java.util.UUID;
@Entity
@Table(name = "file")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID fileid;
    public String contenttype;
    @Lob
    public byte[] data;
    public File(){}
    public File(String contenttype, byte[] data) {
        this.contenttype = contenttype;
        this.data = data;
    }
}
