package com.path.bo.core.postalcode;

import java.util.List;

import com.path.dbmaps.vo.POSTAL_CODEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.postalcode.PostalCodeSC;

public interface PostalCodeBO
{
	public int postalCodeListCount(PostalCodeSC criteria) throws BaseException;
    public List postalCodeList(PostalCodeSC criteria) throws BaseException;
    public POSTAL_CODEVO returnPostalCodeById(PostalCodeSC criteria) throws BaseException;
}
