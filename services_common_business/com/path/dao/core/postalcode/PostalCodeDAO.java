package com.path.dao.core.postalcode;

import java.util.List;

import com.path.dbmaps.vo.POSTAL_CODEVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.postalcode.PostalCodeSC;

public interface PostalCodeDAO
{
	public int postalCodeListCount(PostalCodeSC criteria) throws DAOException;
    public List postalCodeList(PostalCodeSC criteria) throws DAOException;
    public POSTAL_CODEVO returnPostalCodeById(PostalCodeSC criteria) throws DAOException;
}
