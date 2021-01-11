package com.path.dao.core.fmsfundlimit;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.fmsfundlimit.FmsFundLimitSC;


public interface FmsFundLimitDAO
{
    public int fmsFundLimitListCount(FmsFundLimitSC criteria) throws DAOException;
    public List fmsFundLimitList(FmsFundLimitSC criteria) throws DAOException;
}
