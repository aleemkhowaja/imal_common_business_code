package com.path.bo.core.cifprofile;

import java.util.List;

import com.path.dbmaps.vo.CIF_PROFILEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cifprofile.CifProfileSC;

public interface CifProfileBO
{
    public int cifProfileListCount(CifProfileSC cifProfileSC) throws BaseException;

    public List cifProfileList(CifProfileSC cifProfileSC) throws BaseException;
    
    public CIF_PROFILEVO returnCifProfileByCode(CifProfileSC cifProfileSC)throws BaseException;
}
