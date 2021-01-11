package com.path.dao.common.fms.limitscommon;

import com.path.lib.common.exception.DAOException;
import com.path.vo.common.fms.limitscommon.FmsLimitsInputCO;
import com.path.vo.common.fms.limitscommon.FmsOneObligorDetCO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Vysakh.das
 * 
 *          FmsLimitsCommonDAO.java used to write centralised FMS
 *          functionalities
 */
public interface FmsLimitsCommonDAO
{
    public FmsLimitsInputCO utilizeFMSLimit(FmsLimitsInputCO fmsLimitsInputCO) throws DAOException;

    public FmsLimitsInputCO utilizeGeneralFMSLimit(FmsLimitsInputCO fmsLimitsInputCO) throws DAOException;

    FmsOneObligorDetCO executeProcValidateOneObligor(FmsOneObligorDetCO fmsOneObligorDetCO) throws DAOException;

    FmsOneObligorDetCO executeProcValidateOneObligorGlobalLimit(FmsOneObligorDetCO fmsOneObligorDetCO)
	    throws DAOException;

    public FmsLimitsInputCO execProc_P_FMS_AMF_OVERDRAFT(FmsLimitsInputCO fmsLimitsInputCO) throws DAOException;

    // TP#1002268 - DBU191081;Azhar; 15/06/2020 [Start]
    public int getCountSubcidariesCif(FmsLimitsInputCO fmsLimitsInputCO) throws DAOException;

    public void execProc_P_FMS_INSERT_SUBSIDIARY_CIFS(FmsLimitsInputCO fmsLimitsInputCO) throws DAOException;
    // TP#1002268 - DBU191081;Azhar; 15/06/2020 [End]
}
