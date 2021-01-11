package com.path.dao.core.segmentcriteria;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.struts2.lib.common.GridParamsSC;

public interface CriteriaLkpDAO
{

    public int returnCriteriaLookupCount(GridParamsSC criteria) throws DAOException;

    public List returnCriteriaLookup(GridParamsSC criteria) throws DAOException;

}
