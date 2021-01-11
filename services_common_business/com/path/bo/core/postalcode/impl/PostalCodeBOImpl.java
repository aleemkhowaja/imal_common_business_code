package com.path.bo.core.postalcode.impl;

import java.util.List;

import com.path.bo.core.postalcode.PostalCodeBO;
import com.path.dao.core.postalcode.PostalCodeDAO;
import com.path.dbmaps.vo.POSTAL_CODEVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.postalcode.PostalCodeSC;

public class PostalCodeBOImpl extends BaseBO implements PostalCodeBO
{
	private PostalCodeDAO postalCodeDAO;
	@Override
	public List postalCodeList(PostalCodeSC criteria) throws BaseException
	{
		return postalCodeDAO.postalCodeList(criteria);
	}

	@Override
	public int postalCodeListCount(PostalCodeSC criteria) throws BaseException
	{
		return postalCodeDAO.postalCodeListCount(criteria);
	}

	public PostalCodeDAO getPostalCodeDAO()
	{
		return postalCodeDAO;
	}

	public void setPostalCodeDAO(PostalCodeDAO postalCodeDAO)
	{
		this.postalCodeDAO = postalCodeDAO;
	}

	@Override
	public POSTAL_CODEVO returnPostalCodeById(PostalCodeSC criteria) throws BaseException
	{
	    return (POSTAL_CODEVO) postalCodeDAO.returnPostalCodeById(criteria);
	}

}
