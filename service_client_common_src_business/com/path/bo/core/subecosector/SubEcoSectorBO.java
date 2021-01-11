package com.path.bo.core.subecosector;

import java.util.List;

import com.path.dbmaps.vo.RIFSECVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.subecosector.SubEcoSectorSC;

public interface SubEcoSectorBO
{
    public int subEcoSectorListCount(SubEcoSectorSC subEcoSectorSC) throws BaseException;

    public List subEcoSectorList(SubEcoSectorSC subEcoSectorSC) throws BaseException;
    
    public int subEcoSectorParentListCount(SubEcoSectorSC subEcoSectorSC) throws BaseException;

    public List subEcoSectorParentList(SubEcoSectorSC subEcoSectorSC) throws BaseException;
    
    public RIFSECVO returnDependencyBySubSectorCode(SubEcoSectorSC subEcoSectorSC) throws BaseException;
    
    public RIFSECVO returnDependencyBySubSectorCodeforFOM(SubEcoSectorSC subEcoSectorSC) throws BaseException;
    
}
