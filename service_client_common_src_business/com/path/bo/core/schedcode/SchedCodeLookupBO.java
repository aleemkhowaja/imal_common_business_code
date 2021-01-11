package com.path.bo.core.schedcode;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.core.schedcode.SchedCodeLookupCO;
import com.path.vo.core.schedcode.SchedCodeLookupSC;

/**
 * 
 * Copyright 2016, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 */
public interface SchedCodeLookupBO
{
    public int returnSchedCodeLookupCount(SchedCodeLookupSC criteria) throws BaseException;

    public List<SchedCodeLookupCO> returnSchedCodeLookup(SchedCodeLookupSC criteria) throws BaseException;
}