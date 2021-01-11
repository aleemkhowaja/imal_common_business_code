package com.path.dao.core.tempcode;

import java.util.List;

import com.path.dbmaps.vo.TRSPAYPLANTMPLTVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.tempcode.TempCodeSC;

public interface TempCodeDAO {
	 public int tempCodeListCount(TempCodeSC tempCodeSC) throws DAOException;

	    public List tempCodeList(TempCodeSC tempCodeSC) throws DAOException;
	    
	    public TRSPAYPLANTMPLTVO returnTempCodeById(TempCodeSC criteria) throws DAOException;

}
