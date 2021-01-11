package com.path.bo.core.avafilecompanion;

import java.util.List;

import com.path.dbmaps.vo.CTS_AVA_FILE_COMPANIONVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.avafilecompanion.AvaFileCompanionLkpSC;

public interface AvaFileCompanionLkpBO
{
    public List<CTS_AVA_FILE_COMPANIONVO> returnAccompanistLookupList(AvaFileCompanionLkpSC criteria) throws BaseException;

    public int returnAccompanistLookupCount(AvaFileCompanionLkpSC criteria) throws BaseException;
    public CTS_AVA_FILE_COMPANIONVO dependencyByCompanionSeq(AvaFileCompanionLkpSC sc) throws BaseException;
}
 