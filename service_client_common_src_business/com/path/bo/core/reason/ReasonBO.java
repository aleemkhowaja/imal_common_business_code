/**
 * 
 */
package com.path.bo.core.reason;

import java.util.List;
import com.path.dbmaps.vo.AML_REASONVO;
import com.path.dbmaps.vo.CTSREASONSVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.reason.ReasonSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: nabilfeghali
 * 
 *          ReasonBO.java used to
 */
public interface ReasonBO
{
    public int reasonLookupCount(ReasonSC reasonSC) throws BaseException;

    public List<CTSREASONSVO> reasonLookupList(ReasonSC reasonSC) throws BaseException;
    
    public int amlReasonLookupCount(ReasonSC reasonSC) throws BaseException; //#864398

    public List<AML_REASONVO> amlReasonLookupList(ReasonSC reasonSC) throws BaseException;//#864398

    public CTSREASONSVO returnReasonByCode(ReasonSC reasonSC) throws BaseException;

    /**
     * get reason related to a trx type
     * 
     * @author EliasAoun 18/11/2013
     * @param reasonSC
     * @return CTSREASONSVO
     */
    public CTSREASONSVO returnReasonsRelatedToTrxType(ReasonSC reasonSC) throws BaseException;

    public Integer loadBillPurposeCount(ReasonSC criteria) throws BaseException;

    public List<CTSREASONSVO> loadBillPurposeList(ReasonSC criteria) throws BaseException;

}
