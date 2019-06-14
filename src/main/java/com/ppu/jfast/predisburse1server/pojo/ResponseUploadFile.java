package com.ppu.jfast.predisburse1server.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * UploadFileInfo
 */
@ToString
@Getter
@Setter
@AllArgsConstructor
public class ResponseUploadFile {
    private String fileName;
    private String fileDownloadUri;//    <-- generated, see How to create links...
    private String fileType;
    private long size;
}