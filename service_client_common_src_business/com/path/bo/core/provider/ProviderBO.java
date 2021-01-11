package com.path.bo.core.provider;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.struts2.lib.common.GridParamsSC;

public interface ProviderBO
{

    public int returnProviderLookupCount(GridParamsSC criteria) throws BaseException;

    public List returnProviderLookup(GridParamsSC criteria) throws BaseException;

}
