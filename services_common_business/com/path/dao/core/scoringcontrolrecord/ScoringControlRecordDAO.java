package com.path.dao.core.scoringcontrolrecord;

import java.util.List;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.scoringcontrolrecord.ScoringControlRecordCO;
import com.path.vo.core.scoringcontrolrecord.ScoringControlRecordSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * ScoringControlRecordDAO.java used to
 */
public interface ScoringControlRecordDAO
{

	ScoringControlRecordCO returnData(ScoringControlRecordCO scoringControlRecordCO) throws DAOException;

	Integer scoringControRecordGridCount(ScoringControlRecordSC scoringControlRecordSC) throws BaseException;

	List<ScoringControlRecordCO> scoringControRecordGrid(ScoringControlRecordSC scoringControlRecordSC) throws BaseException;

	Integer deleteGrid(ScoringControlRecordCO scoringControlRecordCO) throws BaseException;

	Integer approveScoringControlRecord(ScoringControlRecordCO scoringControlRecordCO) throws DAOException;
	
    Integer deleteScoringControlRecord(ScoringControlRecordCO scoringControlRecordCO) throws DAOException;

    Integer updateDeletedRows(ScoringControlRecordCO scoringControlRecordCO) throws BaseException;
    
    Integer deletedRows(ScoringControlRecordCO scoringControlRecordCO) throws BaseException;
    
    Integer cancelDeletedRows(ScoringControlRecordCO scoringControlRecordCO) throws BaseException;
    
    Integer updateFlagsControlRecord(ScoringControlRecordCO scoringControlRecordCO) throws DAOException;
    
    ScoringControlRecordCO returnDataHeader(ScoringControlRecordCO scoringControlRecordCO) throws DAOException;
}
