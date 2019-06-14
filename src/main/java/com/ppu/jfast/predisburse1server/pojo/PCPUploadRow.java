package com.ppu.jfast.predisburse1server.pojo;

import com.ppu.jfast.predisburse1server.domain.CFINPCPUploads;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * PCPUpload
 */
@Getter
@Setter
@ToString
public class PCPUploadRow {

    private CFINPCPUploads pcp;

    private String mfShortName;

    private String mfFullName;
    
}