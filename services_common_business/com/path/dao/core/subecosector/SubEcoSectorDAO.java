package com.path.dao.core.subecosector;

import java.util.List;

import com.path.dbmaps.vo.RIFSECVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.subecosector.SubEcoSectorSC;

public interface SubEcoSectorDAO
{
    public int subEcoSectorListCount(SubEcoSectorSC subEcoSectorSC) throws DAOException;

    public List subEcoSectorList(SubEcoSectorSC subEcoSectorSC) throws DAOException;
    
    public int subEcoSectorParentListCount(SubEcoSectorSC subEcoSectorSC) throws DAOException;

    public List subEcoSectorParentList(SubEcoSectorSC subEcoSectorSC) throws DAOException;
    
    public RIFSECVO returnDependencyBySubSectorCode(SubEcoSectorSC subEcoSectorSC) throws DAOException;
    
    public RIFSECVO returnDependencyBySubSectorCodeforFOM(SubEcoSectorSC subEcoSectorSC) throws DAOException;
    
}
