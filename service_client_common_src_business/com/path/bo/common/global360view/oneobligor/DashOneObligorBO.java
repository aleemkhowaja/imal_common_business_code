package com.path.bo.common.global360view.oneobligor;

import java.util.List;

import com.path.dbmaps.vo.RIFOBTVO;
import com.path.dbmaps.vo.TRSCLASSVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.global360view.oneobligor.DashOneObligorCO;
import com.path.vo.common.global360view.oneobligor.DashOneObligorSC;

public interface DashOneObligorBO
{
    public int oneObligorListCount(DashOneObligorSC dashOneObligorSC) throws BaseException;

    public List oneObligorList(DashOneObligorSC dashOneObligorSC) throws BaseException;

    public RIFOBTVO returnOneObligorByCode(DashOneObligorSC dashOneObligorSC) throws BaseException;

    public DashOneObligorCO fillOneObligorForm(DashOneObligorSC dashOneObligorSC) throws BaseException;

    public int oneObligorTrendsListCount(DashOneObligorSC dashOneObligorSC) throws BaseException;

    public List oneObligorTrendsList(DashOneObligorSC dashOneObligorSC) throws BaseException;

    // TP#202527; Saheer.Naduthodi; 01/08/2014 [START]
    public Integer oneObligorClassCount(DashOneObligorSC dashOneObligorSC) throws BaseException;

    public List<TRSCLASSVO> oneObligorClassList(DashOneObligorSC dashOneObligorSC) throws BaseException;
    // TP#202527; Saheer.Naduthodi; 01/08/2014 [END]
}
