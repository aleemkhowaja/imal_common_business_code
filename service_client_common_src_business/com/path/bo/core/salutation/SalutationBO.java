package com.path.bo.core.salutation;

import java.util.List;

import com.path.dbmaps.vo.CIVIL_CODESVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.salutation.SalutationSC;

public interface SalutationBO
{
	public int salutationListCount(SalutationSC criteria) throws BaseException;
    public List salutationList(SalutationSC criteria) throws BaseException;
    public CIVIL_CODESVO returnSalutationById(SalutationSC criteria) throws BaseException;
}
