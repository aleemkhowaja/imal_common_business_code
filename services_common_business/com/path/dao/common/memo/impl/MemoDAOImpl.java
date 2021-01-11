package com.path.dao.common.memo.impl;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.path.dao.common.memo.MemoDAO;
import com.path.dbmaps.vo.CTSMEMOVO;
import com.path.dbmaps.vo.CTSMEMOVOKey;
import com.path.dbmaps.vo.CTSMEMO_DETVO;
import com.path.dbmaps.vo.CTSMEMO_DETVOKey;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.common.memo.MemoCO;
import com.path.vo.common.memo.MemoDtlCO;
import com.path.vo.common.memo.MemoDtlLogCO;
import com.path.vo.common.memo.MemoSC;

@SuppressWarnings("unchecked")
public class MemoDAOImpl extends BaseDAO implements MemoDAO {

	/**
	 * checks whether there is any memo available based on the criteria
	 */
	@Override
	public Integer getMemoCount(MemoSC memoSC) throws DAOException {
		DAOHelper.fixGridMaps(memoSC, getSqlMap(), "memoMapper.memoListMap");
		return (Integer) getSqlMap().queryForObject("memoMapper.memoCount",
				memoSC);

	}

	/**
	 * returns memo list
	 */
	@Override
	public ArrayList<MemoCO> getMemoList(MemoSC memoSC) throws DAOException {
		DAOHelper.fixGridMaps(memoSC, getSqlMap(), "memoMapper.memoListMap");

		if (memoSC.getNbRec() == -1) 
		{
		    return (ArrayList<MemoCO>) getSqlMap().queryForList(
				"memoMapper.memoList", memoSC);
		} 
		else 
		{
		    return (ArrayList<MemoCO>) getSqlMap().queryForList(
				"memoMapper.memoList", memoSC, memoSC.getRecToskip(),
				memoSC.getNbRec());		
		}
	}

	/**
	 * returns memo details list count
	 */
	@Override
	public Integer getMemoDtlListCount(MemoSC memoSC) throws DAOException {
		DAOHelper.fixGridMaps(memoSC, getSqlMap(), "memoMapper.memoListMap");
		return (Integer) getSqlMap().queryForObject(
				"memoMapper.memoDtlListCount", memoSC);

	}

	/**
	 * returns memo details list count
	 */
	@Override
	public ArrayList<MemoCO> getMemoDtlList(MemoSC memoSC) throws DAOException {
		DAOHelper.fixGridMaps(memoSC, getSqlMap(), "memoMapper.memoListMap");
		
		if (memoSC.getNbRec() == -1) 
		{
			return (ArrayList<MemoCO>) getSqlMap().queryForList(
				"memoMapper.memoDtlList", memoSC);
		}
		else 
		{
		    return (ArrayList<MemoCO>) getSqlMap().queryForList(
				"memoMapper.memoDtlList", memoSC, memoSC.getRecToskip(),
				memoSC.getNbRec());		
		}
	}

	/**
	 * returns memo details form data based on criteria
	 */
	@Override
	public MemoDtlCO getMemoFormData(MemoDtlCO memoDtlCO) throws DAOException {
		return (MemoDtlCO) getSqlMap().queryForObject(
				"memoMapper.memoFormData", memoDtlCO);

	}

	/**
	 * returns memo count
	 */
	@Override
	public Integer getCtsMemoCount(MemoSC memoSC) throws DAOException {
		DAOHelper.fixGridMaps(memoSC, getSqlMap(), "CTSMEMO.BaseResultMap");
		return (Integer) getSqlMap().queryForObject(
				"memoMapper.selectCTSMEMOCount", memoSC);

	}

	/**
	 * returns memo list
	 */
	@Override
	public ArrayList<CTSMEMOVO> getCtsMemoList(MemoSC memoSC)
			throws DAOException {
		DAOHelper.fixGridMaps(memoSC, getSqlMap(), "CTSMEMO.BaseResultMap");

		if (memoSC.getNbRec() == -1) 
		{
		    return (ArrayList<CTSMEMOVO>) getSqlMap().queryForList(
				"memoMapper.selectCTSMEMOList", memoSC);
		}
		else 
		{
		    return (ArrayList<CTSMEMOVO>) getSqlMap().queryForList(
				"memoMapper.selectCTSMEMOList", memoSC,
				memoSC.getRecToskip(), memoSC.getNbRec());		
		}
	}

	/**
	 * return memo object based on criteria for lookup
	 */
	public CTSMEMOVO getMemoById(CTSMEMOVOKey ctsMemoVOKey) throws DAOException {
		return (CTSMEMOVO) getSqlMap().queryForObject("CTSMEMO.selectCTSMEMO",
				ctsMemoVOKey);

	}

	public Integer getCtsMemoLogCount(MemoSC memoSC) throws DAOException {
		DAOHelper.fixGridMaps(memoSC, getSqlMap(), "memoMapper.memoLogListMap");
		return (Integer) getSqlMap().queryForObject(
				"memoMapper.selectCTSMEMOLOGCount", memoSC);

	}

	public ArrayList<MemoDtlLogCO> getCtsMemoLogList(MemoSC memoSC)
			throws DAOException {

		DAOHelper.fixGridMaps(memoSC, getSqlMap(), "memoMapper.memoLogListMap");

		if (memoSC.getNbRec() == -1) 
		{
		    return (ArrayList<MemoDtlLogCO>) getSqlMap().queryForList(
				"memoMapper.selectCTSMEMOLOGList", memoSC);
		}
		else 
		{
		    return (ArrayList<MemoDtlLogCO>) getSqlMap().queryForList(
				"memoMapper.selectCTSMEMOLOGList", memoSC,
				memoSC.getRecToskip(), memoSC.getNbRec());		
		}

	}

	public void reviewMemo(CTSMEMO_DETVOKey reviewMemo) throws DAOException {
		getSqlMap().update("memoMapper.reviewMemo", reviewMemo);

	}

	@Override
	public int updateStatus(CTSMEMO_DETVO detVO) throws DAOException {
		
	    return getSqlMap().update("memoMapper.updateStatus", detVO);
	}

	@Override
	public CTSMEMOVO getMemo(CTSMEMOVO ctsMemoVO) throws DAOException {
		return (CTSMEMOVO) getSqlMap().queryForObject(
				"memoMapper.memoData", ctsMemoVO);
	}

    /**
     * serial counter management ...
     * 
     * @return
     * @throws DAOException
     */
    public void serialCounter(MemoDtlCO memoDtlCO) throws DAOException
    {
//    	int serialCounter = ((Integer) getSqlMap().queryForObject("linksManagementMapper.serialCounter", memoDtlCO)).intValue();
//    	getSqlMap().update("linksManagementMapper.updateSerial",memoDtlCO);
    }
	/**
	 * returns memo trx details list count
	 */
	@Override
	public Integer getMemoDtlTrxListCount(MemoSC memoSC) throws DAOException {
		DAOHelper.fixGridMaps(memoSC, getSqlMap(), "memoMapper.memoTrxListMap");
		return (Integer)getSqlMap().queryForObject(
				"memoMapper.memoDtlTrxListCount", memoSC);

	}

	/**
	 * returns memo trx details list count
	 */
	@Override
	public ArrayList<MemoCO> getMemoDtlTrxList(MemoSC memoSC) throws DAOException {
		DAOHelper.fixGridMaps(memoSC, getSqlMap(), "memoMapper.memoTrxListMap");
		
		if (memoSC.getNbRec() == -1) 
		{
		    return (ArrayList<MemoCO>) getSqlMap().queryForList("memoMapper.memoDtlTrxList", memoSC);
		}
		else 
		{
		    return (ArrayList<MemoCO>) getSqlMap().queryForList("memoMapper.memoDtlTrxList", memoSC, memoSC.getRecToskip(),memoSC.getNbRec());
		}
	}

	@Override
	public MemoDtlCO loadAlertMemoDescription(MemoSC memoSC) throws DAOException 
	{
		return (MemoDtlCO) getSqlMap().queryForObject("memoMapper.loadAlertMemoDescription", memoSC);
	}
	
	public void updateMemoLog(MemoDtlCO memoDtlCO) throws DAOException
	{
	    getSqlMap().insert("memoMapper.updateMemoLog", memoDtlCO);
	}

	public int updateMemoDetls(MemoDtlCO memoDtlCO) throws DAOException
	{
	    return getSqlMap().update("memoMapper.updateMemoDetls",memoDtlCO);
	}

	public CTSMEMO_DETVO recalcitrantIncompleteMemoList(MemoDtlCO memoDtlCO) throws DAOException
	{
	return (CTSMEMO_DETVO) getSqlMap().queryForObject("memoMapper.recalcitrantIncompleteMemoList", memoDtlCO);
	}

	public int updateCTSMEMODET_Desc(MemoDtlCO memoDtlCO) throws DAOException
	{
	    return getSqlMap().update("memoMapper.updateCTSMEMODET_Desc",memoDtlCO);
	}

	public int updateCTSMEMODET_Status(MemoDtlCO memoDtlCO) throws DAOException
	{
	    return getSqlMap().update("memoMapper.updateCTSMEMODET_Status",memoDtlCO);
	}

	public int updateCTSMEMODET_FSDStatus(MemoDtlCO memoDtlCO) throws DAOException
	{
	    return getSqlMap().update("memoMapper.updateCTSMEMODET_FSDStatus",memoDtlCO);
	}
	//NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
	public int updateCTSMEMODET_CondAutoStatus(MemoDtlCO memoDtlCO) throws DAOException
	{
	    return getSqlMap().update("memoMapper.updateCTSMEMODET_CondAutoStatus",memoDtlCO);
	}

	@Override
	public int returnCountAvailableMemo(MemoSC memoSC) throws DAOException
	{
	    return (Integer) getSqlMap().queryForObject("memoMapper.returnCountAvailableMemo",	memoSC);
	}
	
	public BigDecimal getMinMemoCrmCode(MemoSC memoSC) throws DAOException
	{
	    return (BigDecimal) getSqlMap().queryForObject("memoMapper.getMinMemoCrmCode",	memoSC);
	}		
}
