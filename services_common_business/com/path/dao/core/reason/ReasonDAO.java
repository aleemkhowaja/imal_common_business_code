/**
 * 
 */
package com.path.dao.core.reason;

import java.util.List;
import com.path.dbmaps.vo.AML_REASONVO;
import com.path.dbmaps.vo.CTSREASONSVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.reason.ReasonSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: nabilfeghali
 * 
 *          ReasonDAO.java used to
 */
public interface ReasonDAO
{
    public int reasonsCount(ReasonSC reasonSC) throws DAOException;

    public List<CTSREASONSVO> reasonsList(ReasonSC reasonSC) throws DAOException;

    public CTSREASONSVO returnReasonByCode(ReasonSC reasonSC) throws DAOException;

    public CTSREASONSVO returnReasonsRelatedToTrxType(ReasonSC reasonSC) throws DAOException;

    public Integer loadBillPurposeCount(ReasonSC reasonSC) throws DAOException;

    public List<CTSREASONSVO> loadBillPurposeList(ReasonSC reasonSC) throws DAOException;
    
    // added  BY NOUR for #864398
    public int amlReasonsCount(ReasonSC reasonSC) throws DAOException;

    public List<AML_REASONVO> amlReasonsList(ReasonSC reasonSC) throws DAOException;

}
