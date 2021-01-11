package com.path.bo.core.vatcode;

import java.util.List;


import com.path.dbmaps.vo.TRSVATVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.vatcode.VatCodeSC;

	
public interface VatCodeBO {
	 public int vatCodeListCount(VatCodeSC vatCodeSC) throws BaseException;

	    public List vatCodeList(VatCodeSC vatCodeSC) throws BaseException;
	    
	    public TRSVATVO returnVatCodeById(VatCodeSC criteria) throws BaseException;

}
