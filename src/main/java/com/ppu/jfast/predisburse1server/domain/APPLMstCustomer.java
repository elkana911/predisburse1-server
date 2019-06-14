package com.ppu.jfast.predisburse1server.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * ApplMstCustomer
 */
@Entity
@Data
@Table(name = "APPL_MST_CUSTOMER", schema = "APPL")
public class APPLMstCustomer {

    @Id
    @Column(name = "CUST_ID", length = 20)
    private String custId;

    @Column(name = "CUST_FULL_NAME", length = 100, nullable = false)
    private String custFullName;

    /*
    CUST_ID              VARCHAR2(20 BYTE),
    CUST_FULL_NAME       VARCHAR2(100 BYTE)       NOT NULL,
    CUST_ADDR            VARCHAR2(255 BYTE),
    CUST_ADDR_RT         VARCHAR2(5 BYTE),
    CUST_ADDR_RW         VARCHAR2(5 BYTE),
    CUST_ADDR_KEL        VARCHAR2(50 BYTE),
    CUST_ADDR_KEC        VARCHAR2(50 BYTE),
    CUST_ADDR_KABKOTA    VARCHAR2(50 BYTE),
    CUST_ADDR_PROV       VARCHAR2(50 BYTE),
    CUST_ADDR_ZIP        VARCHAR2(5 BYTE),
    CUST_TYPE            VARCHAR2(3 BYTE)         NOT NULL,
    CUST_FX1_AREA_PH     VARCHAR2(5 BYTE),
    CUST_FX1_PHONE       VARCHAR2(30 BYTE),
    CUST_TGH_ADDR        VARCHAR2(255 BYTE),
    CUST_TGH_RT          VARCHAR2(5 BYTE),
    CUST_TGH_RW          VARCHAR2(5 BYTE),
    CUST_TGH_KEL         VARCHAR2(50 BYTE),
    CUST_TGH_KEC         VARCHAR2(50 BYTE),
    CUST_TGH_KABKOTA     VARCHAR2(50 BYTE),
    CUST_TGH_PROV        VARCHAR2(50 BYTE),
    CUST_TGH_ZIP         VARCHAR2(5 BYTE),
    CUST_SRT_ADDR        VARCHAR2(255 BYTE),
    CUST_SRT_RT          VARCHAR2(5 BYTE),
    CUST_SRT_RW          VARCHAR2(5 BYTE),
    CUST_SRT_KEL         VARCHAR2(50 BYTE),
    CUST_SRT_KEC         VARCHAR2(50 BYTE),
    CUST_SRT_KABKOTA     VARCHAR2(50 BYTE),
    CUST_SRT_PROV        VARCHAR2(50 BYTE),
    CUST_SRT_ZIP         VARCHAR2(5 BYTE),
    CUST_NPWP_NO         VARCHAR2(30 BYTE),
    CUST_NPWP_ADDR       VARCHAR2(255 BYTE),
    CUST_NPWP_RT         VARCHAR2(5 BYTE),
    CUST_NPWP_RW         VARCHAR2(5 BYTE),
    CUST_NPWP_KEL        VARCHAR2(50 BYTE),
    CUST_NPWP_KEC        VARCHAR2(50 BYTE),
    CUST_NPWP_KABKOTA    VARCHAR2(50 BYTE),
    CUST_NPWP_PROV       VARCHAR2(50 BYTE),
    CUST_NPWP_ZIP        VARCHAR2(5 BYTE),
    CUST_CREATED_BY      VARCHAR2(30 BYTE)        NOT NULL,
    CUST_CREATED_DATE    DATE                     NOT NULL,
    CUST_UPDATED_BY      VARCHAR2(30 BYTE),
    CUST_UPDATED_DATE    DATE,
    CUST_FAX_AREA_CODE   VARCHAR2(5 BYTE),
    CUST_FAX_NO          VARCHAR2(30 BYTE),
    CUST_GOL_CODE        VARCHAR2(10 BYTE),
    CUST_RELATION_CODE   VARCHAR2(10 BYTE),
    CUST_KODE_DATI2      VARCHAR2(5 BYTE),
    CUST_LAST_ORDER      NUMBER                   DEFAULT 1                     NOT NULL,
    CUST_TGL_NPWP        DATE,
    TANGGAL_UPDATE_NPWP  DATE
    */
      
}