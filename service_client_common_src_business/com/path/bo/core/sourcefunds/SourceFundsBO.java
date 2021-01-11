package com.path.bo.core.sourcefunds;

import java.util.List;

import com.path.dbmaps.vo.CTS_SOURCE_FUNDSVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.sourcefunds.SourceFundsSC;

public interface SourceFundsBO
{
    public int sourceFundsListCount(SourceFundsSC sourceFundsSC) throws BaseException;

    public List sourceFundsList(SourceFundsSC sourceFundsSC) throws BaseException;

    public CTS_SOURCE_FUNDSVO returnSourceFundsCodeById(SourceFundsSC sourceFundsSC) throws BaseException;

}

