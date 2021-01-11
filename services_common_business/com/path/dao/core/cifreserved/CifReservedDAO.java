package com.path.dao.core.cifreserved;

import com.path.dbmaps.vo.CIF_RESERVEDVO;
import com.path.lib.common.exception.DAOException;

public interface CifReservedDAO
{
    public void  updateCifReserved(CIF_RESERVEDVO cifReservedVO )throws DAOException;
}
