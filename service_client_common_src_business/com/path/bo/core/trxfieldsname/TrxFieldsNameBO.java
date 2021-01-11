package com.path.bo.core.trxfieldsname;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.core.csmfom.FOMTrxDetailsCO;
import com.path.vo.core.trxfieldsname.TrxFieldsNameCO;
import com.path.vo.core.trxfieldsname.TrxFieldsNameSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * TrxFieldsNameBO.java used to
 */
public interface TrxFieldsNameBO

{
    public int returnTrxFieldsNameLookupCount(TrxFieldsNameSC criteria) throws BaseException;

    public List<TrxFieldsNameCO> returnTrxFieldsNameLookup(TrxFieldsNameSC criteria) throws BaseException;

    public FOMTrxDetailsCO dependencyByTrxFieldName(TrxFieldsNameSC trxFieldsNameSC) throws BaseException;

    public boolean returnTellerAccess(TrxFieldsNameSC trxFieldsNameSC) throws BaseException;

}