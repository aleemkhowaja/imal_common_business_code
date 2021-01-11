package com.path.bo.core.avafilecompanion.impl;

import java.util.List;

import com.path.bo.core.avafilecompanion.AvaFileCompanionLkpBO;
import com.path.dao.core.avafilecompanion.AvaFileCompanionLkpDAO;
import com.path.dbmaps.vo.CTS_AVA_FILE_COMPANIONVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.avafilecompanion.AvaFileCompanionLkpSC;

public class AvaFileCompanionLkpBOImpl extends BaseBO implements AvaFileCompanionLkpBO
{
    private AvaFileCompanionLkpDAO avaFileCompanionLkpDAO;



    public void setAvaFileCompanionLkpDAO(AvaFileCompanionLkpDAO avaFileCompanionLkpDAO)
    {
        this.avaFileCompanionLkpDAO = avaFileCompanionLkpDAO;
    }

    @Override
    public List<CTS_AVA_FILE_COMPANIONVO> returnAccompanistLookupList(AvaFileCompanionLkpSC criteria)
	    throws BaseException
    {
	return avaFileCompanionLkpDAO.returnAccompanistLookupList(criteria);
    }

    @Override
    public int returnAccompanistLookupCount(AvaFileCompanionLkpSC criteria) throws BaseException
    {
	return avaFileCompanionLkpDAO.returnAccompanistLookupCount(criteria);
    }
    
    @Override
    public CTS_AVA_FILE_COMPANIONVO dependencyByCompanionSeq(AvaFileCompanionLkpSC sc) throws BaseException
    {
	return avaFileCompanionLkpDAO.dependencyByCompanionSeq(sc);
    }
}
