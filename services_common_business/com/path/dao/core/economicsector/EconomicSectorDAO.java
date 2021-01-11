package com.path.dao.core.economicsector;

import java.util.List;

import com.path.dbmaps.vo.ECO_SECTORSVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.economicsector.EconomicSectorSC;

public interface EconomicSectorDAO
{
    public List economicSectorList(EconomicSectorSC economicSectorSC) throws DAOException;

    public int economicSectorListCount(EconomicSectorSC economicSectorSC) throws DAOException;
    
    public List economicSectorAddRefList(EconomicSectorSC economicSectorSC) throws DAOException;
    
    public int economicSectorAddRefListCount(EconomicSectorSC economicSectorSC) throws DAOException;
    
    public ECO_SECTORSVO returnDependencyBySectorCode(EconomicSectorSC economicSectorSC) throws DAOException;
    
    public ECO_SECTORSVO returnDependencyBySectorCodeforFOM(EconomicSectorSC economicSectorSC) throws DAOException;

    public boolean checkIfSubEcoSectorMandatoryInAdmin(EconomicSectorSC economicSectorSC)throws DAOException;
}
