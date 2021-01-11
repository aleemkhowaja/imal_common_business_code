package com.path.dao.common.memo;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.path.dbmaps.vo.CTSMEMOVO;
import com.path.dbmaps.vo.CTSMEMOVOKey;
import com.path.dbmaps.vo.CTSMEMO_DETVO;
import com.path.dbmaps.vo.CTSMEMO_DETVOKey;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.memo.MemoCO;
import com.path.vo.common.memo.MemoDtlCO;
import com.path.vo.common.memo.MemoDtlLogCO;
import com.path.vo.common.memo.MemoSC;

public interface MemoDAO {
	
	
	public Integer getMemoCount(MemoSC memoSC)throws DAOException;
	
	public ArrayList<MemoCO> getMemoList(MemoSC memoSC)throws DAOException;
	
	public Integer getMemoDtlListCount(MemoSC memoSC) throws DAOException ;	

	public ArrayList<MemoCO> getMemoDtlList(MemoSC memoSC) throws DAOException ;
	
	public MemoDtlCO getMemoFormData(MemoDtlCO memoDtlCO)throws DAOException;	
	
	public Integer getCtsMemoCount(MemoSC memoSC) throws DAOException ;
	
	public ArrayList<CTSMEMOVO> getCtsMemoList(MemoSC memoSC) throws DAOException ;
	
	public CTSMEMOVO getMemoById(CTSMEMOVOKey ctsMemoVOKey) throws DAOException;
	
	public Integer getCtsMemoLogCount(MemoSC memoSC) throws DAOException ;
	
	public ArrayList<MemoDtlLogCO> getCtsMemoLogList(MemoSC memoSC) throws DAOException ;
	
	public void reviewMemo(CTSMEMO_DETVOKey reviewMemo) throws DAOException ;

	public int updateStatus(CTSMEMO_DETVO detVO) throws DAOException ;

	public CTSMEMOVO getMemo(CTSMEMOVO ctsMemoVO)throws DAOException ;
	public void serialCounter(MemoDtlCO memoDtlCO) throws DAOException;
	
	public Integer getMemoDtlTrxListCount(MemoSC memoSC) throws DAOException ;	

	public ArrayList<MemoCO> getMemoDtlTrxList(MemoSC memoSC) throws DAOException;
	
	public MemoDtlCO loadAlertMemoDescription(MemoSC memoSC) throws DAOException;
	
	public void updateMemoLog(MemoDtlCO memoDtlCO) throws DAOException;
	
	public int updateMemoDetls(MemoDtlCO memoDtlCO) throws DAOException;

	public CTSMEMO_DETVO recalcitrantIncompleteMemoList(MemoDtlCO memoDtlCO) throws DAOException;

	public int updateCTSMEMODET_Desc(MemoDtlCO memoDtlCO) throws DAOException;

	public int updateCTSMEMODET_Status(MemoDtlCO memoDtlCO) throws DAOException;

	public int updateCTSMEMODET_FSDStatus(MemoDtlCO memoDtlCO) throws DAOException;
	
	//NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
	public int updateCTSMEMODET_CondAutoStatus(MemoDtlCO memoDtlCO) throws DAOException;

	public int returnCountAvailableMemo(MemoSC memoSC) throws DAOException;
	
	public BigDecimal getMinMemoCrmCode(MemoSC memoSC) throws DAOException;
}
