package com.path.core.actions.blacklistmanagement;

import com.path.core.bo.blacklistmanagement.BlackListBO;
import com.path.core.bo.blacklistmanagement.BlackListConstant;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.blacklistmanagement.BlackListSC;

public class BlackListGridAction extends GridBaseAction
{
    private BlackListBO blackListBO;
    private BlackListSC blackListSC = new BlackListSC();

    @Override
    public Object getModel()
    {
	return blackListSC;
    }

    public String loadBlackListGrid()
    {
	try
	{
	    String[] searchCol = { "blackListVO.CODE", "blackListVO.BRIEF_NAME_ENG", "blackListVO.LONG_NAME_ENG",
		    "blackListVO.CIF", "cifDesc", "blackListVO.OID_DOCUMENT_NBR", "blackListVO.STATUS", "statusDesc" };

	    SessionCO sessionCO = returnSessionObject();
	    blackListSC.setCompCode(sessionCO.getCompanyCode());
	    blackListSC.setIvCrud(getIv_crud());
	    blackListSC.setLangCode(sessionCO.getLanguage());

	    blackListSC.setSearchCols(searchCol);
	    blackListSC.setLovType( BlackListConstant.BLACK_LIST_STATUS_LOV_TYPE);
	    
	    String originalProgRef = StringUtil.nullEmptyToValue(returnCommonLibBO().returnOrginProgRef(
		    sessionCO.getCurrentAppName(), get_pageRef()), get_pageRef());
	    blackListSC.setSectionKey(originalProgRef);
	    blackListSC.setCurrAppName(sessionCO.getCurrentAppName());

	    /**
	     * Use the scanned CIF NO in case its selected.
	     */
	    if(!NumberUtil.isEmptyDecimal(sessionCO.getScannedCIFNo()))
	    {
		blackListSC.setCif(sessionCO.getScannedCIFNo());
	    }
	    copyproperties(blackListSC);

	    if(checkNbRec(blackListSC))
	    {
		setRecords(blackListBO.blackListMgmtCount(blackListSC));
	    }

	    setGridModel(blackListBO.blackListMgmtList(blackListSC));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setBlackListBO(BlackListBO blackListBO)
    {
	this.blackListBO = blackListBO;
    }

    public BlackListSC getBlackListSC()
    {
	return blackListSC;
    }

    public void setBlackListSC(BlackListSC blackListSC)
    {
	this.blackListSC = blackListSC;
    }
}
