package com.path.vo.core.chargesrefund;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.CTSCHARGES_ENTRY_LOGVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTS_CHARGES_REFUNDVO;
import com.path.dbmaps.vo.CTS_CHARGES_REFUND_DETVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.core.common.RetailBaseVO;

public class ChargesRefundCO extends RetailBaseVO
{
    private CTS_CHARGES_REFUNDVO ctsChargesRefundVO = new CTS_CHARGES_REFUNDVO();
    private CTS_CHARGES_REFUND_DETVO ctsChargesRefundDetVO = new CTS_CHARGES_REFUND_DETVO();
    private CTSCHARGES_ENTRY_LOGVO ctsChargesEntityLogVO = new CTSCHARGES_ENTRY_LOGVO();
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> sysParamScreenToPropertyHashMap = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private String pageRef;
    private String cifOrAccountName;
    private String accountName;
    private String cifName;
    private BigDecimal custAccBr;
    private BigDecimal custAccCy;
    private BigDecimal custAccCif;
    private BigDecimal custAccGl;
    private BigDecimal custAccSl;
    private BigDecimal addRef;
    private BigDecimal cifNumber;
    private String statusDesc;
    private String jsonString;
    private Boolean editMode;
    private Boolean isFromAlert;
    private Boolean remoteAlertApprove;
    private String localApproveUserName;
    private String userIsBranchManager;
    private ArrayList<SmartCO> smartCOList;
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private AlertsParamCO alertsParamCO = new AlertsParamCO();
    private List<ChargesRefundCO> chargesRefundDetailsList = new ArrayList<ChargesRefundCO>();
    
    public void setCifOrAccountName(String obj)
    {
	cifOrAccountName = obj;
	if(StringUtil.isNotEmpty(obj))
	{
	    final String entityType = ctsChargesRefundVO.getENTITY_TYPE();
	    if(StringUtil.isNotEmpty(entityType))
	    {
		if("A".equals(entityType))
		{
		    setAccountName(cifOrAccountName);
		}
		else if("C".equals(entityType))
		{
		    setCifName(cifOrAccountName);
		}
	    }
	}
    }
    public CTS_CHARGES_REFUNDVO getCtsChargesRefundVO()
    {
        return ctsChargesRefundVO;
    }

    public void setCtsChargesRefundVO(CTS_CHARGES_REFUNDVO ctsChargesRefundVO)
    {
        this.ctsChargesRefundVO = ctsChargesRefundVO;
    }

    public CTS_CHARGES_REFUND_DETVO getCtsChargesRefundDetVO()
    {
        return ctsChargesRefundDetVO;
    }

    public void setCtsChargesRefundDetVO(CTS_CHARGES_REFUND_DETVO ctsChargesRefundDetVO)
    {
        this.ctsChargesRefundDetVO = ctsChargesRefundDetVO;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getSysParamScreenToPropertyHashMap()
    {
        return sysParamScreenToPropertyHashMap;
    }

    public void setSysParamScreenToPropertyHashMap(
    	HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> sysParamScreenToPropertyHashMap)
    {
        this.sysParamScreenToPropertyHashMap = sysParamScreenToPropertyHashMap;
    }

    public String getPageRef()
    {
        return pageRef;
    }

    public void setPageRef(String pageRef)
    {
        this.pageRef = pageRef;
    }
    public String getAccountName()
    {
        return accountName;
    }
    public void setAccountName(String accountName)
    {
        this.accountName = accountName;
    }
    public String getCifName()
    {
        return cifName;
    }
    public void setCifName(String cifName)
    {
        this.cifName = cifName;
    }
    public String getCifOrAccountName()
    {
        return cifOrAccountName;
    }
    public String getStatusDesc()
    {
        return statusDesc;
    }
    public void setStatusDesc(String statusDesc)
    {
        this.statusDesc = statusDesc;
    }
    public Boolean getEditMode()
    {
        return editMode;
    }
    public void setEditMode(Boolean editMode)
    {
        this.editMode = editMode;
    }
    public String getUserIsBranchManager()
    {
        return userIsBranchManager;
    }
    public void setUserIsBranchManager(String userIsBranchManager)
    {
        this.userIsBranchManager = userIsBranchManager;
    }
    public CTSTELLERVO getCtsTellerVO()
    {
        return ctsTellerVO;
    }
    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
        this.ctsTellerVO = ctsTellerVO;
    }
    public AlertsParamCO getAlertsParamCO()
    {
        return alertsParamCO;
    }
    public void setAlertsParamCO(AlertsParamCO alertsParamCO)
    {
        this.alertsParamCO = alertsParamCO;
    }
    public ArrayList<SmartCO> getSmartCOList()
    {
        return smartCOList;
    }
    public void setSmartCOList(ArrayList<SmartCO> smartCOList)
    {
        this.smartCOList = smartCOList;
    }
    public CTSCHARGES_ENTRY_LOGVO getCtsChargesEntityLogVO()
    {
        return ctsChargesEntityLogVO;
    }
    public void setCtsChargesEntityLogVO(CTSCHARGES_ENTRY_LOGVO ctsChargesEntityLogVO)
    {
        this.ctsChargesEntityLogVO = ctsChargesEntityLogVO;
    }

    public List<ChargesRefundCO> getChargesRefundDetailsList()
    {
        return chargesRefundDetailsList;
    }
    public void setChargesRefundDetailsList(List<ChargesRefundCO> chargesRefundDetailsList)
    {
        this.chargesRefundDetailsList = chargesRefundDetailsList;
    }
    public BigDecimal getCustAccBr()
    {
        return custAccBr;
    }
    public void setCustAccBr(BigDecimal custAccBr)
    {
        this.custAccBr = custAccBr;
    }
    public BigDecimal getCustAccCy()
    {
        return custAccCy;
    }
    public void setCustAccCy(BigDecimal custAccCy)
    {
        this.custAccCy = custAccCy;
    }
    public BigDecimal getCustAccCif()
    {
        return custAccCif;
    }
    public void setCustAccCif(BigDecimal custAccCif)
    {
        this.custAccCif = custAccCif;
    }
    public BigDecimal getCustAccGl()
    {
        return custAccGl;
    }
    public void setCustAccGl(BigDecimal custAccGl)
    {
        this.custAccGl = custAccGl;
    }
    public BigDecimal getCustAccSl()
    {
        return custAccSl;
    }
    public void setCustAccSl(BigDecimal custAccSl)
    {
        this.custAccSl = custAccSl;
    }
    public BigDecimal getCifNumber()
    {
        return cifNumber;
    }
    public void setCifNumber(BigDecimal cifNumber)
    {
        this.cifNumber = cifNumber;
    }
    public String getJsonString()
    {
        return jsonString;
    }
    public void setJsonString(String jsonString)
    {
        this.jsonString = jsonString;
    }
    public Boolean getIsFromAlert()
    {
        return isFromAlert;
    }
    public void setIsFromAlert(Boolean isFromAlert)
    {
        this.isFromAlert = isFromAlert;
    }
    public Boolean getRemoteAlertApprove()
    {
        return remoteAlertApprove;
    }
    public void setRemoteAlertApprove(Boolean remoteAlertApprove)
    {
        this.remoteAlertApprove = remoteAlertApprove;
    }
    public String getLocalApproveUserName()
    {
        return localApproveUserName;
    }
    public void setLocalApproveUserName(String localApproveUserName)
    {
        this.localApproveUserName = localApproveUserName;
    }
    public BigDecimal getAddRef()
    {
        return addRef;
    }
    public void setAddRef(BigDecimal addRef)
    {
        this.addRef = addRef;
    }
}
