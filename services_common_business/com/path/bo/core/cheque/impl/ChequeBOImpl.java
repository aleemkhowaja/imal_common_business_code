package com.path.bo.core.cheque.impl;

import java.util.List;

import com.path.bo.core.cheque.ChequeBO;
import com.path.dao.core.cheque.ChequeDAO;
import com.path.dbmaps.vo.CTSCHEQUESVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cheque.ChequeCO;
import com.path.vo.core.cheque.ChequeSC;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Chady Assaf ChequeBOImpl.java
 */
public class ChequeBOImpl extends BaseBO implements ChequeBO
{
    private ChequeDAO chequeDAO;

    public ChequeDAO getChequeDAO()
    {
	return chequeDAO;
    }

    public void setChequeDAO(ChequeDAO chequeDAO)
    {
	this.chequeDAO = chequeDAO;
    }

    /**
     * chequesLkpCount.
     */
    public int chequesLkpCount(ChequeSC chequeSC) throws BaseException
    {
	return chequeDAO.chequesLkpCount(chequeSC);
    }

    /**
     * chequesLkpRecords.
     */
//    public List chequesLkpRecords(ChequeSC chequeSC) throws BaseException
//    {
//	return chequeDAO.chequesLkpRecords(chequeSC);
//    }

    /**
     * loadChequeRequestByCode
     * 
     * @param cheque
     * @return CTSCHEQUESVO.
     * @throws BaseException
     */
    public ChequeCO loadChequeRequestByCode(ChequeCO cheque) throws BaseException
    {
	return chequeDAO.loadChequeRequestByCode(cheque);
    }

    @Override
    public CTSCHEQUESVO returnDefaultedChequeByCifTypeCode(ChequeSC criteria) throws BaseException
    {
	return chequeDAO.returnDefaultedChequeByCifTypeCode(criteria);
    }

    @Override
    public List chequesLkpRecords(ChequeSC criteria) throws BaseException
    {
	return chequeDAO.chequesLkpRecords(criteria);
    }

    public CTSCHEQUESVO returnDefaultedBillByCifTypeCode(ChequeSC criteria) throws BaseException
    {
	return chequeDAO.returnDefaultedBillByCifTypeCode(criteria);
    }
}