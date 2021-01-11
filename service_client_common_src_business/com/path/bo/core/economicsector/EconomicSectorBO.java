package com.path.bo.core.economicsector;

import java.util.List;

import com.path.dbmaps.vo.ECO_SECTORSVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.economicsector.EconomicSectorSC;

public interface EconomicSectorBO
{
    public int economicSectorListCount(EconomicSectorSC economicSectorSC) throws BaseException;

    public List economicSectorList(EconomicSectorSC economicSectorSC) throws BaseException;
    
    public ECO_SECTORSVO returnDependencyBySectorCode(EconomicSectorSC economicSectorSC) throws BaseException;
    
    public ECO_SECTORSVO returnDependencyBySectorCodeforFOM(EconomicSectorSC economicSectorSC) throws BaseException;
    
    public int economicSectorAddRefListCount(EconomicSectorSC economicSectorSC) throws BaseException;
    
    public List economicSectorAddRefList(EconomicSectorSC economicSectorSC) throws BaseException;
    
    public boolean checkIfSubEcoSectorMandatoryInAdmin(EconomicSectorSC economicSectorSC)throws BaseException;
    
}
