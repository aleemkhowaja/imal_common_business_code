package com.path.dao.core.floatingratecode;

import java.util.List;

import com.path.dbmaps.vo.IBOR_HDRVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.floatingratecode.FloatingRateCodeSC;


public interface FloatingRateCodeDAO {	
	public List floatingRateCodeList(FloatingRateCodeSC floatingRateCodeSC) throws DAOException;
	public int  floatingRateCodeListCount(FloatingRateCodeSC floatingRateCodeSC) throws DAOException;
	public IBOR_HDRVO returnFloatingRateCodeById(FloatingRateCodeSC criteria) throws DAOException;		
}
