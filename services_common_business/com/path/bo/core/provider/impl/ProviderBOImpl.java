package com.path.bo.core.provider.impl;

import java.util.List;

import com.path.bo.core.provider.ProviderBO;
import com.path.dao.core.provider.ProviderDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.struts2.lib.common.GridParamsSC;

public class ProviderBOImpl extends BaseBO implements ProviderBO
{
    private ProviderDAO providerDAO;
    
    @Override
    public int returnProviderLookupCount(GridParamsSC criteria) throws BaseException
    {		
	return providerDAO.returnProviderLookupCount(criteria);
    }

    @Override
    public List returnProviderLookup(GridParamsSC criteria) throws BaseException
    {
	return providerDAO.returnProviderLookup(criteria);
    }

    public ProviderDAO getProviderDAO()
    {
        return providerDAO;
    }

    public void setProviderDAO(ProviderDAO providerDAO)
    {
        this.providerDAO = providerDAO;
    }

}
