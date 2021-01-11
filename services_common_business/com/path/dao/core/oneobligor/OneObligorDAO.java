package com.path.dao.core.oneobligor;

import java.util.List;

import com.path.dbmaps.vo.RIFOBTVO;
import com.path.dbmaps.vo.TRSCLASSVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.oneobligor.OneObligorCO;
import com.path.vo.core.oneobligor.OneObligorSC;

public interface OneObligorDAO
{
    public int oneObligorListCount(OneObligorSC oneObligorSC) throws DAOException;

    public List oneObligorList(OneObligorSC oneObligorSC) throws DAOException;

    public RIFOBTVO returnOneObligorByCode(OneObligorSC oneObligorSC) throws DAOException;

    public int oneObligorTrendsListCount(OneObligorSC oneObligorSC) throws DAOException;

    public List oneObligorTrendsList(OneObligorSC oneObligorSC) throws DAOException;

    public OneObligorCO fillOneObligorForm(OneObligorSC oneObligorSC) throws DAOException;

    // TP#202527; Saheer.Naduthodi; 01/08/2014 [START]
    public Integer oneObligorClassCount(OneObligorSC oneObligorSC) throws DAOException;

    public List<TRSCLASSVO> oneObligorClassList(OneObligorSC oneObligorSC) throws DAOException;
    // TP#202527; Saheer.Naduthodi; 01/08/2014 [END]
}
