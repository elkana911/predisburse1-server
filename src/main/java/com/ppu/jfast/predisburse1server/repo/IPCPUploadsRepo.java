package com.ppu.jfast.predisburse1server.repo;

import java.util.List;

import com.ppu.jfast.predisburse1server.domain.CFINPCPUploads;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * IPCPUploadsRepo
 */
@Repository
public interface IPCPUploadsRepo extends JpaRepository<CFINPCPUploads, String> {

  // @Query(value = "select id, name from table2", nativeQuery = true)
  // List<PCPUploadsMF> findPCPMF();

  @Query(value = "SELECT MFCOY.MFCOY_ID, MFCOY.MFCOY_SHORTNAME, CUST.CUST_FULL_NAME"
      + " FROM APPL.APPL_MST_MFCOY MFCOY, CFIN.CFIN_MSTJF_AGREEMENT AGMT, APPL.APPL_MST_CUSTOMER CUST"
      + " WHERE AGMT.AGR_SHORTNAME = :shortName" + " AND AGMT.AGR_MFCOY_ID = MFCOY.MFCOY_ID"
      + " AND CUST.CUST_ID = AGMT.AGR_MFCOY_ID", nativeQuery = true)
  List<String[]> findMFByShortName(@Param("shortName") String shortName); // 'RFDTK02'

  @Query(value = "SELECT AGMT.AGR_SHORTNAME, MFCOY.MFCOY_SHORTNAME SHORTNAME, AGMT.AGR_MFCOY_ID MFCOY_ID, CUST.CUST_FULL_NAME"
      // + "TO_CHAR(APPL.APPL_JFBANK_PKG.F_OUTS_PLAFOND(AGMT.AGR_SHORTNAME), '999G999G999G999G999') OUTSPLAFOND"
      + " FROM CFIN.CFIN_MSTJF_AGREEMENT AGMT, APPL.APPL_MST_MFCOY MFCOY, APPL.APPL_MST_CUSTOMER CUST"
      + " WHERE AGMT.AGR_MFCOY_ID = MFCOY.MFCOY_ID AND MFCOY.MFCOY_STATUS = 'AC'"
      + " AND CUST.CUST_ID = MFCOY.MFCOY_ID", nativeQuery = true)
  List<String[]> lovAgreementWithPkg();

  @Query(value = "SELECT SCHEME, DESCRIPTION FROM CFIN.CFIN_PCP_SCH_HDRS WHERE STATUS='AC'", nativeQuery = true)
  List<String[]> lovScheme();
}