package com.path.dao.core.cheque;

import java.util.List;

import com.path.dbmaps.vo.CTSCHEQUESVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.cheque.ChequeCO;
import com.path.vo.core.cheque.ChequeSC;
/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Chady Assaf
 *
 * ChequeDAO.java used to
 */
public interface ChequeDAO
{
    public int chequesLkpCount(ChequeSC chequeSC) throws DAOException;

    public List chequesLkpRecords(ChequeSC chequeSC) throws DAOException;
//	public List chequesLkpRecords(RetAuxServiceSC criteria) throws DAOException;	
    public ChequeCO loadChequeRequestByCode(ChequeCO cheque) throws DAOException;

    public CTSCHEQUESVO returnDefaultedChequeByCifTypeCode(ChequeSC criteria) throws DAOException;

    public CTSCHEQUESVO returnDefaultedBillByCifTypeCode(ChequeSC criteria) throws DAOException;
}
