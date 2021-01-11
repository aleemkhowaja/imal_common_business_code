package com.path.dao.core.sourcefunds;

import java.util.List;

import com.path.dbmaps.vo.CTS_SOURCE_FUNDSVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.sourcefunds.SourceFundsSC;

public interface SourceFundsDAO
{
    public CTS_SOURCE_FUNDSVO returnSourceFundsCodeById(SourceFundsSC sourceFundsSC) throws DAOException;

    public List sourceFundsList(SourceFundsSC sourceFundsSC) throws DAOException;

    public int sourceFundsListCount(SourceFundsSC sourceFundsSC) throws DAOException;
}
