
package com.ppu.jfast.predisburse1server.controllers;

import java.util.ArrayList;
import java.util.List;

import com.ppu.jfast.predisburse1server.domain.CFINPCPUploads;
import com.ppu.jfast.predisburse1server.pojo.PCPUploadRow;
import com.ppu.jfast.predisburse1server.repo.IPCPUploadsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PCPProcessController
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PCPProcessController {

    @Autowired
    IPCPUploadsRepo repo;

    // @GetMapping(value = "/pcp_uploadslist")
    public List<CFINPCPUploads> getAll() {
        return repo.findAll(Sort.by(Direction.DESC, "sessionNo"));
    }

    @GetMapping(value = "/pcp_processlist")
    public List<PCPUploadRow> getPCPProcessList(){

        // we'll modify this list later
        List<CFINPCPUploads> list = getAll();

        // get unique short names from previous list
        List<String> shortNames = new ArrayList<>();
        List<String[]> mfByShortNames = new ArrayList<>();
        String lastSearchShortName = null;
        for (CFINPCPUploads _obj : list) {

            if (shortNames.size() < 1){
                shortNames.add(_obj.getAgmtShortname());

                //langsung tambahin
                List<String[]> _buffer = repo.findMFByShortName(_obj.getAgmtShortname());
                mfByShortNames.addAll(_buffer);
                
                continue;
            }

            // for faster scan, avoid duplicate seach
            if (lastSearchShortName != null && lastSearchShortName.equals(_obj.getAgmtShortname()))
                continue;
            
            lastSearchShortName = _obj.getAgmtShortname();
            boolean exist = false;
            for (String _s : shortNames){
                if (_s.equals(_obj.getAgmtShortname())) {
                    exist = true;
                    break;
                }
            }

            if (!exist){
                shortNames.add(_obj.getAgmtShortname());

                //langsung tambahin
                List<String[]> _buffer = repo.findMFByShortName(_obj.getAgmtShortname());
                mfByShortNames.addAll(_buffer);
            }
            
        }

        // lastly, modify the mainlist
        List<PCPUploadRow> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){

            PCPUploadRow row = new PCPUploadRow();

            for (String[] _ss : mfByShortNames){

                if (_ss[0].equals(list.get(i).getMfCoyId())){

                    row.setMfShortName(_ss[1]);
                    row.setMfFullName(_ss[2]);
                    row.setPcp(list.get(i));
        
                    newList.add(row);
        
                    break;
                }
            }
           
        }

        return newList;
    }

    @GetMapping(value = "/lov_agreement")
    public List<String[]> getLOVAgreement(){
        return repo.lovAgreementWithPkg();
    }

    @GetMapping(value = "/lov_scheme")
    public List<String[]> getLOVScheme(){
        return repo.lovScheme();
    }

}