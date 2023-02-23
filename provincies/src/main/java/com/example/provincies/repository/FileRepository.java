package com.example.provincies.repository;

import com.example.provincies.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
public interface FileRepository extends JpaRepository<File, UUID> {
}