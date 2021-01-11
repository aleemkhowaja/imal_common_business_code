package com.path.dao.core.scoringcontrolrecord.impl;

import java.util.List;
import com.path.dao.core.scoringcontrolrecord.ScoringControlRecordDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.scoringcontrolrecord.ScoringControlRecordCO;
import com.path.vo.core.scoringcontrolrecord.ScoringControlRecordSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * ScoringControlRecordDAOImpl.java used to
 */
public class ScoringControlRecordDAOImpl extends BaseDAO implements ScoringControlRecordDAO
{

	@Override
	public ScoringControlRecordCO returnData(ScoringControlRecordCO scoringControlRecordCO) throws DAOException
	{
		//Modified by bilal for TP#987360
		ScoringControlRecordCO scoringControlRecordCO1 = (ScoringControlRecordCO) getSqlMap().queryForObject("scoringControlRecordMapper.returnData", scoringControlRecordCO);
		ScoringControlRecordCO scoringControlRecordCO2 = returnDataHeader(scoringControlRecordCO);//(ScoringControlRecordCO) getSqlMap().queryForObject("scoringControlRecordMapper.returnControlRecordFlags", scoringControlRecordCO);
		if (scoringControlRecordCO1 == null)
		{
			scoringControlRecordCO1 = scoringControlRecordCO2;
		}
		else if(scoringControlRecordCO2 != null)
		{
			scoringControlRecordCO1.setAmlCifControlScoreVO(scoringControlRecordCO2.getAmlCifControlScoreVO());
		}
		
		return scoringControlRecordCO1;
	}

	@Override
	public Integer scoringControRecordGridCount(ScoringControlRecordSC scoringControlRecordSC) throws BaseException
	{
		DAOHelper.fixGridMaps(scoringControlRecordSC, getSqlMap(), "scoringControlRecordMapper.scoringControlRecordDetailsResMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("scoringControlRecordMapper.scoringControlRecordCount", scoringControlRecordSC)).intValue();
		return nb;
	}

	@Override
	public List<ScoringControlRecordCO> scoringControRecordGrid(ScoringControlRecordSC scoringControlRecordSC) throws BaseException
	{
		DAOHelper.fixGridMaps(scoringControlRecordSC, getSqlMap(), "scoringControlRecordMapper.scoringControlRecordDetailsResMap");
		if (scoringControlRecordSC.getNbRec() == -1)
		{
			return getSqlMap().queryForList("scoringControlRecordMapper.scoringControlRecordGrid", scoringControlRecordSC);
		}
		else
		{
			return getSqlMap().queryForList("scoringControlRecordMapper.scoringControlRecordGrid", scoringControlRecordSC,
					scoringControlRecordSC.getRecToskip(), scoringControlRecordSC.getNbRec());
		}
	}

	public Integer deleteGrid(ScoringControlRecordCO scoringControlRecordCO) throws BaseException
	{
		return getSqlMap().delete("scoringControlRecordMapper.deleteGrid", scoringControlRecordCO);

	}

	public Integer approveScoringControlRecord(ScoringControlRecordCO scoringControlRecordCO) throws DAOException
	{
		//Modified by bilal for TP#987360
		getSqlMap().update("scoringControlRecordMapper.approveScoringControlRecord", scoringControlRecordCO);
		getSqlMap().update("scoringControlRecordMapper.deleteControlRecordFlags", scoringControlRecordCO);
		return getSqlMap().update("scoringControlRecordMapper.approveControlRecordFlags", scoringControlRecordCO);
	}

	public Integer deleteScoringControlRecord(ScoringControlRecordCO scoringControlRecordCO) throws DAOException
	{
		return getSqlMap().update("scoringControlRecordMapper.deleteScoringControlRecord", scoringControlRecordCO);

	}
	
	//by bilal for BUG#973477
	@Override
	public Integer updateDeletedRows(ScoringControlRecordCO scoringControlRecordCO) throws BaseException {
		return getSqlMap().update("scoringControlRecordMapper.updateDeletedRows", scoringControlRecordCO);
	}
	
	//by bilal for BUG#973477
	@Override
	public Integer deletedRows(ScoringControlRecordCO scoringControlRecordCO) throws BaseException {
		return getSqlMap().update("scoringControlRecordMapper.deletedRows", scoringControlRecordCO);
	}

	//by bilal for BUG#973477
	@Override
	public Integer cancelDeletedRows(ScoringControlRecordCO scoringControlRecordCO) throws BaseException {
		//Modified by bilal for TP#987360 
		getSqlMap().update("scoringControlRecordMapper.cancelDeletedRows", scoringControlRecordCO);
		 return getSqlMap().delete("scoringControlRecordMapper.cancelControlRecordFlags", scoringControlRecordCO);
	}
	
	//added by bilal for TP#987360
	@Override
	public Integer updateFlagsControlRecord(ScoringControlRecordCO scoringControlRecordCO) throws DAOException {
		return getSqlMap().update("scoringControlRecordMapper.updateFlagsControlRecord", scoringControlRecordCO);
	}

	@Override
	public ScoringControlRecordCO returnDataHeader(ScoringControlRecordCO scoringControlRecordCO) throws DAOException {
		return (ScoringControlRecordCO) getSqlMap().queryForObject("scoringControlRecordMapper.returnControlRecordFlags", scoringControlRecordCO);
	}

}
