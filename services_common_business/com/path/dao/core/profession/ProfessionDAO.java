package com.path.dao.core.profession;

import java.util.List;

import com.path.dbmaps.vo.CTS_PROFESSIONVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.profession.ProfessionSC;


public interface ProfessionDAO
{
    public List professionList(ProfessionSC professionSC) throws DAOException;

    public int professionListCount(ProfessionSC professionSC) throws DAOException;
 
    public CTS_PROFESSIONVO returnDependencyByProfession(ProfessionSC professionSC) throws DAOException;
}
