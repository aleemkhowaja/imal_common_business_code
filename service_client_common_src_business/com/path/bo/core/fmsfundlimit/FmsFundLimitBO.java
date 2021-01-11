package com.path.bo.core.fmsfundlimit;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.core.fmsfundlimit.FmsFundLimitSC;


public interface FmsFundLimitBO
{
    public int fmsFundLimitListCount(FmsFundLimitSC criteria) throws BaseException;
    public List fmsFundLimitList(FmsFundLimitSC criteria) throws BaseException;
}
