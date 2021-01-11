package com.path.dao.core.vatcode;

import java.util.List;

import com.path.dbmaps.vo.TRSVATVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.vatcode.VatCodeSC;


	
	public interface VatCodeDAO {
		 public int vatCodeListCount(VatCodeSC vatCodeSC) throws DAOException;

		    public List vatCodeList(VatCodeSC vatCodeSC) throws DAOException;
		    
		    public TRSVATVO returnVatCodeById(VatCodeSC criteria) throws DAOException;

	}


