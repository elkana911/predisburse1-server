package com.ppu.jfast.predisburse1server.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * PCPUploads
 */
@Entity
@Data
@Table(name = "CFIN_PCP_UPLOADS", schema = "CFIN")
public class CFINPCPUploads {
    @Id
    @Column(name = "SESSION_NO", length = 30)
    private String sessionNo;

    @Column(name = "MFCOY_ID", length = 20)
    private String mfCoyId;

    @Column(name = "AGMT_SHORTNAME", length = 50)
    private String agmtShortname;

    @Column(length = 50)
    private String scheme;

    @Column(name = "LETTER_NO", length = 50)
    private String letterNo;

    @Column(length = 30)
    private String status;

    /*
    SESSION_NO         VARCHAR2(30 BYTE),
    SESSION_DATE       DATE,
    MFCOY_ID           VARCHAR2(20 BYTE),
    SCHEME             VARCHAR2(50 BYTE),
    CONTENT_KONTRAK    BLOB,
    CONTENT_ENDUSER    BLOB,
    CONTENT_KENDARAAN  BLOB,
    CONTENT_PENGURUS   BLOB,
    PRINTLHP_FLAG      VARCHAR2(2 BYTE)           DEFAULT 'N',
    JOBNAME            VARCHAR2(30 BYTE),
    CREATED_BY         VARCHAR2(30 BYTE),
    CREATED_DATE       DATE,
    UPDATED_BY         VARCHAR2(30 BYTE),
    UPDATED_DATE       DATE
    */
}