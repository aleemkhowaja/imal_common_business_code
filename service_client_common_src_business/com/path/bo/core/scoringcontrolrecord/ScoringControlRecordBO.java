package com.path.bo.core.scoringcontrolrecord;

import java.math.BigDecimal;
import java.util.List;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.scoringcontrolrecord.ScoringControlRecordCO;
import com.path.vo.core.scoringcontrolrecord.ScoringControlRecordSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * ScoringControlRecordBO.java used to
 */
public interface ScoringControlRecordBO
{

	ScoringControlRecordCO loadData(ScoringControlRecordCO scoringControlRecordCO) throws BaseException, DAOException;

	Integer scoringControRecordGridCount(ScoringControlRecordSC scoringControlRecordSC) throws BaseException;

	List<ScoringControlRecordCO> scoringControRecordGrid(ScoringControlRecordSC scoringControlRecordSC) throws BaseException;
	
	ScoringControlRecordCO dependencyByFromScore(ScoringControlRecordCO scoringControlRecordCO)
			    throws BaseException;
	
	ScoringControlRecordCO dependencyByToScore(ScoringControlRecordCO scoringControlRecordCO)
		    throws BaseException;
	
	public ScoringControlRecordCO saveNew(ScoringControlRecordCO scoringControlRecordCO) throws BaseException, DAOException;

	public ScoringControlRecordCO updateControlRecord(ScoringControlRecordCO
			scoringControlRecordCO) throws BaseException, DAOException, BOException;
	
	ScoringControlRecordCO approveScoringControlRecord(ScoringControlRecordCO scoringControlRecordCO) throws BaseException;

	ScoringControlRecordCO deleteScoringControlRecord(ScoringControlRecordCO scoringControlRecordCO) throws BaseException;

	
	BigDecimal getDualParam (ScoringControlRecordCO scoringControlRecordCO) throws BaseException;



}
