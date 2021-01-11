package com.path.bo.core.segmentcriteria;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.struts2.lib.common.GridParamsSC;

public interface CriteriaLkpBO
{

    public int returnCriteriaLookupCount(GridParamsSC criteria) throws BaseException;

    public List returnCriteriaLookup(GridParamsSC criteria) throws BaseException;

}
