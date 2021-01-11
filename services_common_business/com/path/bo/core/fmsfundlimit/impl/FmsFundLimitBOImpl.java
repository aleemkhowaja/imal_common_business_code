package com.path.bo.core.fmsfundlimit.impl;

import java.util.List;

import com.path.bo.core.fmsfundlimit.FmsFundLimitBO;
import com.path.dao.core.fmsfundlimit.FmsFundLimitDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.fmsfundlimit.FmsFundLimitSC;

public class FmsFundLimitBOImpl extends BaseBO implements FmsFundLimitBO
{
    private FmsFundLimitDAO fmsFundLimitDAO;
    @Override
    public int fmsFundLimitListCount(FmsFundLimitSC criteria) throws BaseException
    {
	return fmsFundLimitDAO.fmsFundLimitListCount(criteria);
    }

    @Override
    public List fmsFundLimitList(FmsFundLimitSC criteria) throws BaseException
    {
	return fmsFundLimitDAO.fmsFundLimitList(criteria);
    }

    public FmsFundLimitDAO getFmsFundLimitDAO()
    {
        return fmsFundLimitDAO;
    }

    public void setFmsFundLimitDAO(FmsFundLimitDAO fmsFundLimitDAO)
    {
        this.fmsFundLimitDAO = fmsFundLimitDAO;
    }

}
