package com.path.actions.common.memo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.struts2.ServletActionContext;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.FormatUtils;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.memo.MemoBO;
import com.path.bo.common.memo.MemoConstants;
import com.path.dbmaps.vo.CTSMEMO_DETVO;
import com.path.dbmaps.vo.CTSMEMO_DETVOKey;
import com.path.dbmaps.vo.CTSMEMO_LOGVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.common.memo.MemoCO;
import com.path.vo.common.memo.MemoDtlLogCO;
import com.path.vo.common.memo.MemoSC;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.common.status.StatusCO;

@SuppressWarnings("unchecked")
public class MemoGridAction extends RetailBaseAction {
	
	private MemoBO memoBO;
	private MemoSC memoSC  =  new MemoSC() ; 
	private String url;
	private CTSMEMO_DETVOKey ctsMemoDetVOKey ;  //for memo status
	private BigDecimal compCode;
	private ArrayList<MemoCO> reviewMemoList;
	private String memoJson;
	/**
	 * Load the data for Memo alert overlay
	 * @return
	 */
    public String loadMemo()
    {

	String[] searchCol = { "BRANCH_CODE", "TRX_NO", "ENG_COMENT", "ARAB_COMENT", "COMMON_DESC_ENG",
		"BRIEF_DESC_ARAB", "LONG_DESC_ENG", "LONG_DESC_ARAB", "TYPE" };
	try
	{
	    memoSC.setSearchCols(searchCol);
	    SessionCO sessionCO = returnSessionObject();
	    memoSC.setLangCode(sessionCO.getLanguage());
	    memoSC.setRunningDate(sessionCO.getRunningDateRET());
	    memoSC.setCompCode(sessionCO.getCompanyCode());
	    memoSC.setLovType(MemoConstants.LOV_TYPE);
	    memoSC.setAppName(sessionCO.getCurrentAppName());
	    copyproperties(memoSC);
	    //IIAB120195 - iMAL Memo Alert
	    ArrayList<MemoSC> memoLoadList = new ArrayList<MemoSC>();
	    if(StringUtil.isNotEmpty(memoJson))
	    {
		
		JSONObject jsonFilter = (JSONObject) JSONSerializer.toJSON(memoJson);
		JSONArray jsonModel = jsonFilter.getJSONArray("root");
		for(int i=0; i< jsonModel.size(); i++) 
		{
		    JSONObject jsonObj = (JSONObject)jsonModel.get(i);
		    MemoSC memoItem = (MemoSC)JSONObject.toBean(jsonObj, MemoSC.class);
		    memoLoadList.add(memoItem);
	        }
		
		memoSC.setAppType(memoLoadList.get(0).getAppType());
		memoSC.setOptRef(memoLoadList.get(0).getOptRef());
		memoSC.setTrxType(memoLoadList.get(0).getTrxType());
		memoSC.setForAccOrCif(memoLoadList.get(0).getForAccOrCif());//Abdo TP#471634 04/02/2017
		memoSC.setMemoList(memoLoadList);
		
	    }

	    if(checkNbRec(memoSC))
	    {
		setRecords(memoBO.getMemoCount(memoSC));
	    }
	    ArrayList<MemoCO> memoList = memoBO.getMemoList(memoSC);
	    if(memoList != null && !memoList.isEmpty())
	    {
		String forAccValue = "";
		String forCifValue = "";
		String forSegmentValue = "";
		
		SelectSC selectSC  = new SelectSC();
		selectSC.setLovTypeId(MemoConstants.FOR_ACC_CIF_LOV_TYPE);
		selectSC.setLanguage(sessionCO.getLanguage());
		Map<String, SelectCO> resultMap = returnCommonLibBO().returnLOVMap(selectSC);
		if(resultMap != null && !resultMap.isEmpty())
		{
		    if(resultMap.get("A") != null)
		    {
			forAccValue = resultMap.get("A").getDescValue();
		    }
		    if(resultMap.get("C") != null)
		    {
			forCifValue = resultMap.get("C").getDescValue();
		    }
		    
		    //Rania - DB180100 - Customers Segmentation Enhancement
		    if(resultMap.get("S") != null)
		    {
			forSegmentValue = resultMap.get("S").getDescValue();
		    }
		    //
		}
		
		//IIAB120195 - iMAL Memo Alert
		for(MemoCO memoCO : memoList)
		{
		    // BUG#330707
		    /*if(NumberUtil.isEmptyDecimal(memoCO.getACC_BR()) || NumberUtil.isEmptyDecimal(memoCO.getACC_CY())
				 || NumberUtil.isEmptyDecimal(memoCO.getACC_GL())
				 || NumberUtil.isEmptyDecimal(memoCO.getACC_CIF())
				 || NumberUtil.isEmptyDecimal(memoCO.getACC_SL()))*/
		    if(MemoConstants.CIF.equals(memoSC.getForAccOrCif()))
		    {
			   // MEMO by CIF
			   if(memoCO.getCIF_NO() != null)
			   {
				   memoCO.setCIF_ACCNO(FormatUtils.formatCIF(memoCO.getCIF_NO()));
				   memoCO.setForCifOrAcc(forCifValue);
			   }
		    }
		    else if(MemoConstants.ACCOUNTS.equals(memoSC.getForAccOrCif()))
		    {
			   if(!NumberUtil.isEmptyDecimal(memoCO.getACC_BR())
				     && !NumberUtil.isEmptyDecimal(memoCO.getACC_CY())
				     && !NumberUtil.isEmptyDecimal(memoCO.getACC_GL())
				     && !NumberUtil.isEmptyDecimal(memoCO.getACC_CIF())
				     && !NumberUtil.isEmptyDecimal(memoCO.getACC_SL()))
			   {
				   // MEMO by Acc
				   memoCO.setCIF_ACCNO(FormatUtils.formatAccount(memoCO.getACC_BR(), memoCO.getACC_CY(),
					     memoCO.getACC_GL(), memoCO.getACC_CIF(), memoCO.getACC_SL()));
				   memoCO.setForCifOrAcc(forAccValue);
			   }
			   else if(memoCO.getCIF_NO() != null && "1".equals(memoCO.getCIF_SPECIFIC()))
			   {
				   memoCO.setCIF_ACCNO(FormatUtils.formatCIF(memoCO.getCIF_NO()));
				   memoCO.setForCifOrAcc(forCifValue);
			   }
		    }

		    //Rania - DB180100 - Customers Segmentation Enhancement
		    if("1".equals(memoCO.getSEGMENT_SPECIFIC_YN()) && memoCO.getCtsmemoDETVO() != null && memoCO.getCtsmemoDETVO().getSEGMENT_CODE() != null)
		    {
			memoCO.setCIF_ACCNO(String.format("%04d", memoCO.getCtsmemoDETVO().getSEGMENT_CODE().longValue()));
			memoCO.setForCifOrAcc(forSegmentValue);
		    }
		    //			    	
		}
	    }
	    setGridModel(memoList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in Memo Grid");
	    handleException(e, null, null);
	}
	return SUCCESS;

    }
	
	/**
	 * Load the data for Trx Memo grid 
	 * @return
	 */
    public String loadMemoTrx()
    {

	String[] searchCol = { "MEMO_CODE", "ENG_COMENT", "ARAB_COMENT", "CIF_NO", "CURRENCY", "AMOUNT", "PROD_CLASS",
		"TRX_REF", "APP_NAME" };
	try
	{
	    memoSC.setSearchCols(searchCol);
	    memoSC.setLangCode(returnSessionObject().getLanguage());
	    memoSC.setRunningDate(returnSessionObject().getRunningDateRET());
	    memoSC.setCompCode(returnSessionObject().getCompanyCode());
	    memoSC.setBranchCode(returnSessionObject().getBranchCode());
	    memoSC.setLovType(MemoConstants.LOV_TYPE);
	    copyproperties(memoSC);
	    if(checkNbRec(memoSC))
	    {
		setRecords(memoBO.getMemoDtlTrxListCount(memoSC));
	    }
	    ArrayList<MemoCO> memoList = memoBO.getMemoDtlTrxList(memoSC);
	    for(MemoCO memoCO : memoList)
	    {
		if("1".equals(memoCO.getCIF_SPECIFIC()))
		{
		    memoCO.setCIF_ACCNO(FormatUtils.formatCIF(memoCO.getCIF_NO()));
		}
		else
		{
		    memoCO.setCIF_ACCNO(FormatUtils.formatAccount(memoCO.getACC_BR(), memoCO.getACC_CY(),
			    memoCO.getACC_GL(), memoCO.getACC_CIF(), memoCO.getACC_SL()));
		}
	    }
	    setGridModel(memoList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in Memo Grid");
	    handleException(e, null, null);
	}
	return SUCCESS;

    }
	
	
    /**
     * checking if there is a link before opening the link grid dialog
     * 
     * @return
     */
    public String checkMemosExists()
    {
	try
	{
	    /**
	     * copy the details related to search criteria to the SC
	     */
	    SessionCO sessionCO = returnSessionObject();
	    memoSC.setLangCode(sessionCO.getLanguage());
	    memoSC.setRunningDate(sessionCO.getRunningDateRET());
	    memoSC.setCompCode(sessionCO.getCompanyCode());
	    memoSC.setBranchCode(sessionCO.getBranchCode());
	    memoSC.setLovType(MemoConstants.LOV_TYPE);
	    int result = memoBO.getMemoDtlTrxListCount(memoSC);
	    /* Check BUG#216017 System is not retrieving the approved memos under the "Memo" button in trx screen */
	    if(result == 0)
	    {
		throw new BOException(MessageCodes.NO_RECORD_FOUND);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
	
    /**
     * Load the Memo alert overlay grid definition
     * 
     * @throws BaseException
     * @return
     */

    public String loadDef() throws BaseException
    {
	// NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
	try
	{
	    if(StringUtil.isNotEmpty(memoSC.getOptRef()))
	    {
		// If f_checkaccess_without_message
		memoSC.setReviewBtnEnabled((checkAccessByProgRef(memoSC.getOptRef()) == 1));
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return (StringUtil.nullToEmpty(memoSC.getFromScreen()).equals("trx")) ? "loadDefTrx" : "loadDef";
    }
 
	
    /**
     * Load the data for Memo details grid
     * 
     * @return
     */

    public String loadMemoDtlsGrid()
    {
	String[] searchCol = { "TRX_NO", "MEMO_CODE", "ENG_COMENT", "ARAB_COMENT", "CIF_NO", "ACC_BR", "ACC_CY",
		"ACC_GL", "ACC_CIF", "ACC_SL", "FROM_DATE", "DATE_TO", "LAST_REVIEW_NO", "STATUS" };
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    HashMap<String, String> hmDate = new HashMap<String, String>();//raed saad bug #427154 - bug #427162 
	    hmDate.put("FROM_DATE", "FROM_DATE");//raed saad bug #427154 - bug #427162 
	    hmDate.put("DATE_TO", "DATE_TO");//raed saad bug #427154 - bug #427162 
	    memoSC.setSearchCols(searchCol);
	    memoSC.setCompCode(returnSessionObject().getCompanyCode());
	    memoSC.setLovType(MemoConstants.STATUS_LOV_TYPE);
	    memoSC.setAppName(sessionCO.getCurrentAppName());
	    memoSC.setLangCode(sessionCO.getLanguage());
	    memoSC.setProgRef(get_pageRef());
	    memoSC.setDateSearchCols(hmDate);
	    memoSC.setBranchCode(returnSessionObject().getBranchCode());
	    memoSC.setIvCrud(getIv_crud());
	    memoSC.setDateSearchCols(hmDate);//raed saad bug #427154 - bug #427162 
	    copyproperties(memoSC);
	    
	  /**  Habib Baalbaki accocunt restriction 372747
	    if(checkNbRec(memoSC))
	    {
		setRecords(memoBO.getMemoDtlListCount(memoSC));
	    }
	    ArrayList<MemoCO> memoList = memoBO.getMemoDtlList(memoSC);
	    setGridModel(memoList);
	    */
	    //Habib Baalbaki accocunt restriction 372747
	    String originalProgRef = StringUtil.nullEmptyToValue(returnCommonLibBO().returnOrginProgRef(
		    sessionCO.getCurrentAppName(), get_pageRef()), get_pageRef());
	    memoSC.setCurrAppName(sessionCO.getCurrentAppName());
	    memoSC.setPageRef(originalProgRef);
	    memoSC.setUserId(sessionCO.getUserName());
//	    memoSC.setCompCode(returnSessionObject().getCompanyCode());
	    
	    memoSC.setCheckNbRec(checkNbRec(memoSC));
	    memoSC = memoBO.returnMemoDtlList(memoSC);
	    if(memoSC.isCheckNbRec())
	    {
		setRecords(memoSC.getTrxMgntNbRecords());
	    }
	    setGridModel(memoSC.getListRecords());
	}
	catch(Exception e)
	{
	    log.error(e, "Error in Memo Grid");
	    handleException(e, null, null);
	}
	return SUCCESS;

    }
	
	

	/**
	 * Sets the url and loads the common status grid page
	 * @return
	 */
	public String loadStatusGridDef()
	{		 
	    url = ServletActionContext.getServletContext().getContextPath() +"/path/memo/MemoGrid_loadStatusGridData?ctsMemoDetVOKey.TRX_NO="+ctsMemoDetVOKey.getTRX_NO();	    
		return "SUCCESS_STATUS";
		
	}
	/**
	 * Loads the status grid data
	 * @return
	 */
	public String loadStatusGridData()
	{
		String[] searchCol = { "userName", "status_desc", "status_date" };		 
		SelectSC lovCriteria = new SelectSC();
		try
		{
		    SessionCO sessionCO = returnSessionObject();
		    BigDecimal compCode  = sessionCO.getCompanyCode();
		    memoSC.setSearchCols(searchCol);
		    copyproperties(memoSC);			    
		    ctsMemoDetVOKey.setCOMP_CODE(compCode);
		    ctsMemoDetVOKey.setBRANCH_CODE(sessionCO.getBranchCode());

	            lovCriteria.setLanguage(sessionCO.getLanguage());
	            lovCriteria.setCompCode(compCode);
	            lovCriteria.setLovTypeId(MemoConstants.STATUS_LOV_TYPE);
		    
		    
		    List<StatusCO> statusList= returnCommonLibBO().generateStatusList(ctsMemoDetVOKey, MemoConstants.getStatusFields(), lovCriteria);
		    setGridModel(statusList);
		}
		catch(Exception ex)
		{
		    log.error("Error in the loadStatusGrid method");
		    handleException(ex, null, null);
		}
		return SUCCESS;
	    }
	/**
	 * Load Memo log page
	 * @return
	 */
 
	public String loadMemoLogDef()
	{
		return "loadMemoLogDef";
	}
	
    public String loadMemoLogData()
    {
	try
	{
	    String[] searchCol = { "MEMO_DATE", "CODE", "BRIEF_DESC_ENG", "CIF_NO", "ACC_BR", "ACC_CY", "ACC",
		    "ACC_GL", "ACC_CIF", "ACC_SL", "ENG_COMENT", "USER_ID" };
	    
	    
	    
	    memoSC.setSearchCols(searchCol);
	    memoSC.setCompCode(returnSessionObject().getCompanyCode());
	    
	    HashMap<String,String> dateSearchCols = new HashMap<String, String>();
	    dateSearchCols.put("MEMO_DATE","MEMO_DATE");
	    memoSC.setDateSearchCols(dateSearchCols);
	    
	    copyproperties(memoSC);
	    if(checkNbRec(memoSC))
	    {
		setRecords(memoBO.getCtsMemoLogCount(memoSC));
	    }
	    ArrayList<MemoDtlLogCO> memoLogList = memoBO.getCtsMemoLogList(memoSC);
	    for(MemoDtlLogCO memoDtlLogCO : memoLogList)
	    {
		CTSMEMO_LOGVO ctsMemoLogVO = memoDtlLogCO.getCtsMemoLogVO();
		if(ctsMemoLogVO.getACC_GL() != null)
		{
		    memoDtlLogCO.setAccNo(FormatUtils.formatAccount(ctsMemoLogVO.getACC_BR(), ctsMemoLogVO.getACC_CY(),
			    ctsMemoLogVO.getACC_GL(), ctsMemoLogVO.getACC_CIF(), ctsMemoLogVO.getACC_SL()));
		}
	    }
	    setGridModel(memoLogList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in Memo Log Grid");
	    handleException(e, null, null);
	}
	return SUCCESS;

    }
	
    /**
     * Review Memo
     */

    public String reviewMemo()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    memoSC.setCompCode(sessionCO.getCompanyCode());
	    memoSC.setRunningDate(sessionCO.getRunningDateRET());
	    memoSC.setUserId(sessionCO.getUserName());
	    memoSC.setAppName(sessionCO.getCurrentAppName());
	    if(StringUtil.nullToEmpty(memoSC.getForAccOrCif()).equals(MemoConstants.ACCOUNTS))
	    {
		memoSC.setType(MemoConstants.ACC_TYPE);
	    }
	    else if(StringUtil.nullToEmpty(memoSC.getForAccOrCif()).equals(MemoConstants.CIF))
	    {
		memoSC.setType(MemoConstants.CIF_TYPE);
	    }
	    else if(StringUtil.nullToEmpty(memoSC.getForAccOrCif()).equals("P"))
	    {
		memoSC.setType("P");
	    }
	    memoBO.reviewMemo(reviewMemoList, memoSC);
	}
	catch(Exception e)
	{
	   handleException(e, null, null);
	}
	return SUCCESS;

    }
	
	/**
	 * @param memoBO the memoBO to set
	 */
	@Override
	public void setMemoBO(MemoBO memoBO) {
		this.memoBO = memoBO;
	} 

	/**
	 * @param memoSC the memoSC to set
	 */
	public void setMemoSC(MemoSC memoSC) {
		this.memoSC = memoSC;
	}

	/**
	 * @return the memoSC
	 */
	public MemoSC getMemoSC() {
		return memoSC;
	}
	
	@Override
	public Object getModel()
	{
		return memoSC;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	public CTSMEMO_DETVOKey getCtsMemoDetVOKey() {
		return ctsMemoDetVOKey;
	}
	
	public void setCtsMemoDetVOKey(CTSMEMO_DETVOKey ctsMemoDetVOKey) {
		this.ctsMemoDetVOKey = ctsMemoDetVOKey;
	}
	public BigDecimal getCompCode() {
		return compCode;
	}
	public void setCompCode(BigDecimal compCode) {
		this.compCode = compCode;
	}

	public ArrayList<MemoCO> getReviewMemoList()
	{
	    return reviewMemoList;
	}

	public void setReviewMemoList(ArrayList<MemoCO> reviewMemoList)
	{
	    this.reviewMemoList = reviewMemoList;
	}

	public String getMemoJson()
	{
	    return memoJson;
	}

	public void setMemoJson(String memoJson)
	{
	    this.memoJson = memoJson;
	}
	
 }