package com.path.bo.common.memo;

import java.util.ArrayList;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CTSMEMOVO;
import com.path.dbmaps.vo.CTSMEMOVOKey;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.memo.MemoCO;
import com.path.vo.common.memo.MemoDtlCO;
import com.path.vo.common.memo.MemoDtlLogCO;
import com.path.vo.common.memo.MemoSC;
import com.path.vo.core.account.AccountSC;

public interface MemoBO {
	
	public boolean isMemoAvailable(MemoSC memoSC)throws BaseException;
	
	public ArrayList<MemoCO> getMemoList(MemoSC memoSC)throws BaseException; 
	
	public Integer getMemoCount(MemoSC memoSC)throws BaseException ;
	
	public Integer getMemoDtlListCount(MemoSC memoSC)throws BaseException;
	
	public ArrayList<MemoCO> getMemoDtlList(MemoSC memoSC)throws BaseException;	
	
	public MemoDtlCO getMemoFormData(MemoDtlCO memoDtlCO)throws BaseException;
	
	public Integer getCtsMemoCount(MemoSC memoSC)throws BaseException ;
	
	public ArrayList<CTSMEMOVO> getCtsMemoList(MemoSC memoSC)throws BaseException ;	
	
	public CTSMEMOVO getMemoById(CTSMEMOVOKey ctsMemoVOKey)throws BaseException ;
	
	public ArrayList<MemoDtlLogCO> getCtsMemoLogList(MemoSC memoSC)throws BaseException ;
	
	public Integer getCtsMemoLogCount(MemoSC memoSC)throws BaseException ;
	
	public void reviewMemo(ArrayList<MemoCO> reviewMemoList, MemoSC memoSC) throws BaseException;

	public MemoDtlCO saveNew(MemoDtlCO memoDtlCO)throws BaseException;

	public void approve(MemoDtlCO memoDtlCO)throws BaseException;

	public void toCancel(MemoDtlCO memoDtlCO)throws BaseException;

	public void cancel(MemoDtlCO memoDtlCO)throws BaseException;

	public void toSuspend(MemoDtlCO memoDtlCO)throws BaseException;

	public void suspend(MemoDtlCO memoDtlCO)throws BaseException;

	public void toReactivate(MemoDtlCO memoDtlCO)throws BaseException;

	public void reactivate(MemoDtlCO memoDtlCO)throws BaseException;

	public MemoDtlCO getMemo(MemoDtlCO memoDtlCO)throws BaseException;

	public void update(MemoDtlCO memoDtlCO)throws BaseException;

	public void delete(MemoDtlCO memoDtlCO)throws BaseException;
	
	public Integer getMemoDtlTrxListCount(MemoSC memoSC)throws BaseException;
	
	public ArrayList<MemoCO> getMemoDtlTrxList(MemoSC memoSC)throws BaseException;

	public void checkMemoDtls(MemoDtlCO memoDtlCO) throws BaseException;

	public void rejectMemoDtls(MemoDtlCO memoDtlCO) throws BaseException;	
	
	public MemoDtlCO loadAlertMemoDetails(MemoDtlCO memoDtlCO) throws BaseException;

	public MemoDtlCO ctrlMandatoryFields(MemoDtlCO memoDtlCO) throws BaseException;

	public AMFVO returnAccountByReference(AccountSC criteria) throws BaseException;

	public MemoDtlCO checkKYC(MemoDtlCO memoDtlCO) throws BaseException;

	public MemoSC returnMemoDtlList(MemoSC criteria) throws BaseException;
	
	//public MemoDtlCO createDeleteMemo(MemoDtlCO memoDtlCO) throws BaseException;
	 
}
