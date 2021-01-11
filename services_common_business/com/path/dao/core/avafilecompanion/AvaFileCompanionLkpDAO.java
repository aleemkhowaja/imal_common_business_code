package com.path.dao.core.avafilecompanion;

import java.util.List;

import com.path.dbmaps.vo.CTS_AVA_FILE_COMPANIONVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.avafilecompanion.AvaFileCompanionLkpSC;

public interface AvaFileCompanionLkpDAO
{
    public List<CTS_AVA_FILE_COMPANIONVO> returnAccompanistLookupList(AvaFileCompanionLkpSC criteria) throws DAOException;

    public int returnAccompanistLookupCount(AvaFileCompanionLkpSC criteria) throws DAOException;
    public CTS_AVA_FILE_COMPANIONVO dependencyByCompanionSeq(AvaFileCompanionLkpSC sc) throws DAOException;
}
