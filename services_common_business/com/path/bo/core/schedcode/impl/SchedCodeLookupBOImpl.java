package com.path.bo.core.schedcode.impl;

import java.util.List;

import com.path.bo.core.schedcode.SchedCodeLookupBO;
import com.path.dao.core.schedcode.SchedCodeLookupDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.schedcode.SchedCodeLookupCO;
import com.path.vo.core.schedcode.SchedCodeLookupSC;

/**
 * 
 * Copyright 2016, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 */
public class SchedCodeLookupBOImpl extends BaseBO implements SchedCodeLookupBO
{
    SchedCodeLookupDAO schedCodeLookupDAO;

    @Override
    public int returnSchedCodeLookupCount(SchedCodeLookupSC criteria) throws BaseException
    {
	return schedCodeLookupDAO.returnSchedCodeLookupCount(criteria);
    }

    @Override
    public List<SchedCodeLookupCO> returnSchedCodeLookup(SchedCodeLookupSC criteria) throws BaseException
    {
	return schedCodeLookupDAO.returnSchedCodeLookupList(criteria);
    }
    
    public SchedCodeLookupDAO getSchedCodeLookupDAO()
    {
        return schedCodeLookupDAO;
    }

    public void setSchedCodeLookupDAO(SchedCodeLookupDAO schedCodeLookupDAO)
    {
        this.schedCodeLookupDAO = schedCodeLookupDAO;
    }
}
