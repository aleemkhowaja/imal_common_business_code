package com.path.bo.core.oneobligor;

import java.util.List;

import com.path.dbmaps.vo.RIFOBTVO;
import com.path.dbmaps.vo.TRSCLASSVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.oneobligor.OneObligorCO;
import com.path.vo.core.oneobligor.OneObligorSC;

public interface OneObligorBO
{
    public int oneObligorListCount(OneObligorSC oneObligorSC) throws BaseException;

    public List oneObligorList(OneObligorSC oneObligorSC) throws BaseException;

    public RIFOBTVO returnOneObligorByCode(OneObligorSC oneObligorSC) throws BaseException;

    public OneObligorCO fillOneObligorForm(OneObligorSC oneObligorSC) throws BaseException;

    public int oneObligorTrendsListCount(OneObligorSC oneObligorSC) throws BaseException;

    public List oneObligorTrendsList(OneObligorSC oneObligorSC) throws BaseException;

    // TP#202527; Saheer.Naduthodi; 01/08/2014 [START]
    public Integer oneObligorClassCount(OneObligorSC oneObligorSC) throws BaseException;

    public List<TRSCLASSVO> oneObligorClassList(OneObligorSC oneObligorSC) throws BaseException;
    // TP#202527; Saheer.Naduthodi; 01/08/2014 [END]
}
