package com.path.dao.core.passbook;

import java.util.List;

import com.path.dbmaps.vo.CTSPASSBOOK_TYPEVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.passbook.PassbookSC;
import com.path.vo.core.passbookinventory.PassBookinventoryCO;
import com.path.vo.core.passbookinventory.PassBookinventorySC;

public interface PassbookDAO
{
	public int passbookListCount(PassbookSC criteria) throws DAOException;
    public List passbookList(PassbookSC criteria) throws DAOException;
    public CTSPASSBOOK_TYPEVO returnPassbookById(PassbookSC criteria) throws DAOException;
    public PassBookinventoryCO checkQuantityMinimumAlert(PassBookinventorySC passBookinventorySC) throws DAOException;
    
    public CTSPASSBOOK_TYPEVO returnDefaultedPassbookByCifTypeCode(PassbookSC criteria) throws DAOException;
}

