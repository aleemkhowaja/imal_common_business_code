package com.path.dao.core.cifreserved.impl;

import com.path.dao.core.cifreserved.CifReservedDAO;
import com.path.dbmaps.vo.CIF_RESERVEDVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;

public class CifReservedDAOimpl extends BaseDAO implements CifReservedDAO
{

    public void  updateCifReserved(CIF_RESERVEDVO cifReservedVO )throws DAOException
    {
	
	getSqlMap().update("cifReservedMapper.updateCifReservedDetails", cifReservedVO);	
	
    }
}
