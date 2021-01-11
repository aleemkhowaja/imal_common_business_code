package com.path.bo.core.passbook;

import java.util.List;

import com.path.dbmaps.vo.CTSPASSBOOK_TYPEVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.passbook.PassBookCO;
import com.path.vo.core.passbook.PassbookSC;
import com.path.vo.core.passbookinventory.PassBookinventoryCO;
import com.path.vo.core.passbookinventory.PassBookinventorySC;

public interface PassbookBO
{
    public int passbookListCount(PassbookSC criteria) throws BaseException;
    public List passbookList(PassbookSC criteria) throws BaseException;
    public PassBookCO returnPassbookById(PassbookSC criteria) throws BaseException;
    public PassBookinventoryCO checkQuantityMinimumAlert(PassBookinventorySC passBookinventorySC) throws DAOException;
    
    public CTSPASSBOOK_TYPEVO returnDefaultedPassbookByCifTypeCode(PassbookSC criteria) throws BaseException;

}
