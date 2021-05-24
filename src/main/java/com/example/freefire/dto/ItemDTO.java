package com.example.freefire.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ItemDTO {
    private Integer id;
    private String enabled;
    private String title;
    private String fileName;
    private MultipartFile multipartFile;
}
