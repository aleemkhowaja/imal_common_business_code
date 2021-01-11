package com.path.dao.core.charges;

import java.util.List;


import com.path.dbmaps.vo.TRSCHARGESVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.charges.ChargesSC;
public interface ChargesDAO {
	
	  public int chargesListCount(ChargesSC chargesSC) throws DAOException;
	    public List chargesList(ChargesSC chargesSC) throws DAOException;	    
	    public TRSCHARGESVO returnChargesById(ChargesSC criteria) throws DAOException;

}
