package com.path.bo.core.tempcode;

import java.util.List;

import com.path.dbmaps.vo.TRSPAYPLANTMPLTVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.tempcode.TempCodeSC;


public interface TempCodeBO {
	 public int tempCodeListCount(TempCodeSC tempCodeSC) throws BaseException;

	    public List tempCodeList(TempCodeSC tempCodeSC) throws BaseException;
	    
	    public TRSPAYPLANTMPLTVO returnTempCodeById(TempCodeSC criteria) throws BaseException;

}
