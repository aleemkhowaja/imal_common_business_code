package com.path.bo.core.chequebook.impl;

import java.util.List;

import com.path.bo.core.chequebook.ChequeBookLkpBO;
import com.path.bo.core.common.base.RetailBaseBO;
import com.path.dao.core.chequebook.ChequeBookLkpDAO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.core.chequebook.ChequeBookCO;
import com.path.vo.core.chequebook.ChequeBookSC;

public class ChequeBookLkpBOImpl extends RetailBaseBO implements ChequeBookLkpBO
{
    private ChequeBookLkpDAO chequeBookLkpDAO;

    public Integer chequeBookLkpCount(ChequeBookSC chequeBookSC) throws BaseException
    {
	return chequeBookLkpDAO.chequeBookLkpCount(chequeBookSC);
    }

    public List chequeBookLkpList(ChequeBookSC chequeBookSC) throws BaseException
    {
	return chequeBookLkpDAO.chequeBookLkpList(chequeBookSC);
    }

    public Integer chequeBookPortalLkpCount(ChequeBookSC chequeBookSC) throws BaseException
    {
	NumberUtil.resetEmptyValues(chequeBookSC);
	return chequeBookLkpDAO.chequeBookPortalLkpCount(chequeBookSC);
    }

    public List<ChequeBookCO> chequeBookPortalLkpList(ChequeBookSC chequeBookSC) throws BaseException
    {
	NumberUtil.resetEmptyValues(chequeBookSC);
	return chequeBookLkpDAO.chequeBookPortalLkpList(chequeBookSC);
    }

    /**
     * Return count of TRX Cheque
     * 
     * @author: BoushraFahs
     * @date: 27 Jan 2014
     * @PB:w_lookup_chq_trx/dw_lookup_cheque_on_trx_type(tfa01.pbl)
     */
    public int returnChqTrxLkpCount(ChequeBookSC chequeBookSC) throws BaseException
    {
	return chequeBookLkpDAO.returnChqTrxLkpCount(chequeBookSC);
    }

    /**
     * Return list of of TRX Cheque
     * 
     * @author: BoushraFahs
     * @date: 27 Jan 2014
     * @PB: w_lookup_chq_trx/dw_lookup_cheque_on_trx_type(tfa01.pbl)
     */
    public List<ChequeBookCO> returnChqTrxLkpList(ChequeBookSC chequeBookSC) throws BaseException
    {
	return chequeBookLkpDAO.returnChqTrxLkpList(chequeBookSC);
    }

    /**
     * Return count of TRX Cheque
     * 
     * @author: BoushraFahs
     * @date: 27 Jan 2014
     * @PB:w_lookup_chq_trx/dw_lookup_cheque_on_trx_type(tfa01.pbl)
     */
    public int returnChqLkpCount(ChequeBookSC chequeBookSC) throws BaseException
    {
	chequeBookSC
		.setTrxTypeRemittType(NumberUtil.emptyDecimalToZero(chequeBookLkpDAO.returnCtsRemittTrx(chequeBookSC)));
	return chequeBookLkpDAO.returnChqLkpCount(chequeBookSC);
    }

    /**
     * Return list of Cheques
     * 
     * @author: BoushraFahs
     * @date: 27 Jan 2014
     * @PB: w_lookup_chq/dw_lookup_cheque(tfa01.pbl)
     */
    public List<ChequeBookCO> returnChqLkpList(ChequeBookSC chequeBookSC) throws BaseException
    {
	chequeBookSC
		.setTrxTypeRemittType(NumberUtil.emptyDecimalToZero(chequeBookLkpDAO.returnCtsRemittTrx(chequeBookSC)));
	return chequeBookLkpDAO.returnChqLkpList(chequeBookSC);
    }

    
    public ChequeBookLkpDAO getChequeBookLkpDAO()
    {
	return chequeBookLkpDAO;
    }

    public void setChequeBookLkpDAO(ChequeBookLkpDAO chequeBookLkpDAO)
    {
	this.chequeBookLkpDAO = chequeBookLkpDAO;
    }
}