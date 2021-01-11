package com.path.dao.core.cifprofile;

import java.util.List;

import com.path.dbmaps.vo.CIF_PROFILEVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.cifprofile.CifProfileSC;

public interface CifProfileDAO
{
    public List cifProfileList(CifProfileSC cifProfileSC) throws DAOException;

    public int cifProfileListCount(CifProfileSC cifProfileSC) throws DAOException;
    
    public CIF_PROFILEVO returnCifProfileByCode(CifProfileSC cifProfileSC)throws DAOException;
}
