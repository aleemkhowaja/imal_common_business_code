package com.path.dao.core.schedcode;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.schedcode.SchedCodeLookupCO;
import com.path.vo.core.schedcode.SchedCodeLookupSC;

/**
 * 
 * Copyright 2016, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 */
public interface SchedCodeLookupDAO
{
    public int returnSchedCodeLookupCount(SchedCodeLookupSC criteria) throws DAOException;

    public List<SchedCodeLookupCO> returnSchedCodeLookupList(SchedCodeLookupSC criteria) throws DAOException;

}