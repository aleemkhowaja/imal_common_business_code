package com.path.bo.core.chequebook;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.core.chequebook.ChequeBookCO;
import com.path.vo.core.chequebook.ChequeBookSC;

public interface ChequeBookLkpBO
{
    // lookups
    public Integer chequeBookLkpCount(ChequeBookSC chequeBookSC) throws BaseException;

    public List chequeBookLkpList(ChequeBookSC chequeBookSC) throws BaseException;

    public Integer chequeBookPortalLkpCount(ChequeBookSC chequeBookSC) throws BaseException;

    public List<ChequeBookCO> chequeBookPortalLkpList(ChequeBookSC chequeBookSC) throws BaseException;

    /**
     * Return count of TRX Cheque
     * 
     * @author: BoushraFahs
     * @date: 27 Jan 2014
     * @PB:w_lookup_chq_trx/dw_lookup_cheque_on_trx_type(tfa01.pbl)
     */
    public int returnChqTrxLkpCount(ChequeBookSC chequeBookSC) throws BaseException;

    /**
     * Return list of of TRX Cheque
     * 
     * @author: BoushraFahs
     * @date: 27 Jan 2014
     * @PB: w_lookup_chq_trx/dw_lookup_cheque_on_trx_type(tfa01.pbl)
     */
    public List<ChequeBookCO> returnChqTrxLkpList(ChequeBookSC chequeBookSC) throws BaseException;

    /**
     * Return count of TRX Cheque
     * 
     * @author: BoushraFahs
     * @date: 27 Jan 2014
     * @PB:w_lookup_chq_trx/dw_lookup_cheque_on_trx_type(tfa01.pbl)
     */
    public int returnChqLkpCount(ChequeBookSC chequeBookSC) throws BaseException;

    /**
     * Return list of Cheques
     * 
     * @author: BoushraFahs
     * @date: 27 Jan 2014
     * @PB: w_lookup_chq/dw_lookup_cheque(tfa01.pbl)
     */
    public List<ChequeBookCO> returnChqLkpList(ChequeBookSC chequeBookSC) throws BaseException;

}
