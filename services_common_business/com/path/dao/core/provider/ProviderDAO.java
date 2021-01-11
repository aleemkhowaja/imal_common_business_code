package com.path.dao.core.provider;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.struts2.lib.common.GridParamsSC;

public interface ProviderDAO
{

    public int returnProviderLookupCount(GridParamsSC criteria) throws DAOException;

    public List returnProviderLookup(GridParamsSC criteria) throws DAOException;

}
