package com.path.dao.common.global360view.oneobligor;

import java.util.List;

import com.path.dbmaps.vo.RIFOBTVO;
import com.path.dbmaps.vo.TRSCLASSVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.global360view.oneobligor.DashOneObligorCO;
import com.path.vo.common.global360view.oneobligor.DashOneObligorSC;

public interface DashOneObligorDAO
{
    public int oneObligorListCount(DashOneObligorSC dashOneObligorSC) throws DAOException;

    public List oneObligorList(DashOneObligorSC dashOneObligorSC) throws DAOException;

    public RIFOBTVO returnOneObligorByCode(DashOneObligorSC dashOneObligorSC) throws DAOException;

    public int oneObligorTrendsListCount(DashOneObligorSC dashOneObligorSC) throws DAOException;

    public List oneObligorTrendsList(DashOneObligorSC dashOneObligorSC) throws DAOException;

    
    
    public DashOneObligorCO fillOneObligorForm(DashOneObligorSC dashOneObligorSC) throws DAOException;

    
    
    
    // TP#202527; Saheer.Naduthodi; 01/08/2014 [START]
    public Integer oneObligorClassCount(DashOneObligorSC dashOneObligorSC) throws DAOException;

    public List<TRSCLASSVO> oneObligorClassList(DashOneObligorSC dashOneObligorSC) throws DAOException;
    // TP#202527; Saheer.Naduthodi; 01/08/2014 [END]
}
