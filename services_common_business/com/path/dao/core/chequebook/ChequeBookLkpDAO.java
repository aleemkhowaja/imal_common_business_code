package com.path.dao.core.chequebook;

import java.math.BigDecimal;
import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.chequebook.ChequeBookCO;
import com.path.vo.core.chequebook.ChequeBookSC;

public interface ChequeBookLkpDAO
{
    public Integer chequeBookLkpCount(ChequeBookSC chequeBookSC) throws DAOException;

    public List chequeBookLkpList(ChequeBookSC chequeBookSC) throws DAOException;

    public Integer chequeBookPortalLkpCount(ChequeBookSC chequeBookSC) throws DAOException;

    public List<ChequeBookCO> chequeBookPortalLkpList(ChequeBookSC chequeBookSC) throws DAOException;

    /**
     * Return count of TRX Cheque
     * 
     * @author: BoushraFahs
     * @date: 27 Jan 2014
     * @PB:w_lookup_chq_trx/dw_lookup_cheque_on_trx_type(tfa01.pbl)
     */
    public int returnChqTrxLkpCount(ChequeBookSC chequeBookSC) throws DAOException;

    /**
     * Return list of of TRX Cheque
     * 
     * @author: BoushraFahs
     * @date: 27 Jan 2014
     * @PB: w_lookup_chq_trx/dw_lookup_cheque_on_trx_type(tfa01.pbl)
     */
    public List<ChequeBookCO> returnChqTrxLkpList(ChequeBookSC chequeBookSC) throws DAOException;

    /**
     * Return count of TRX Cheque
     * 
     * @author: BoushraFahs
     * @date: 27 Jan 2014
     * @PB:w_lookup_chq_trx/dw_lookup_cheque_on_trx_type(tfa01.pbl)
     */
    public int returnChqLkpCount(ChequeBookSC chequeBookSC) throws DAOException;

    /**
     * Return list of Cheques
     * 
     * @author: BoushraFahs
     * @date: 27 Jan 2014
     * @PB: w_lookup_chq/dw_lookup_cheque(tfa01.pbl)
     */
    public List<ChequeBookCO> returnChqLkpList(ChequeBookSC chequeBookSC) throws DAOException;
    
    /**
     * Return trxType from the table CTS_REMITT_TRXTYPE
     * 
     * @author: BoushraFahs
     * @date: 27 Jan 2014
     */
    public BigDecimal returnCtsRemittTrx(ChequeBookSC chequeBookSC) throws DAOException;
}
