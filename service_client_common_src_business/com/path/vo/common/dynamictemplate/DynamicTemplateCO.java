package com.path.vo.common.dynamictemplate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.BCOM_DYN_ENT_TEMPL_CONVVO;
import com.path.dbmaps.vo.BCOM_DYN_PROD_TEMPLATEVO;
import com.path.dbmaps.vo.BCOM_DYN_PROD_TEMPLATE_NODEVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTS_SEGMENTVO;
import com.path.dbmaps.vo.BCOM_DYN_ENT_TEMPL_CONV_ALRTVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_TEMPL_PARAMVO;
import com.path.lib.vo.BaseVO;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * DynamicTemplateCO.java used to
 */
public class DynamicTemplateCO extends RetailBaseVO implements Serializable
{
    private String DYN_TEMP_ID;
    private String PARENT_ID;
    private String APP_NAME;
    private String APP_DESC;
    private BCOM_DYN_PROD_TEMPLATEVO dynTemplateVO = new BCOM_DYN_PROD_TEMPLATEVO();
    private BCOM_DYN_PROD_TEMPLATE_NODEVO dynTemplateNodesVO = new BCOM_DYN_PROD_TEMPLATE_NODEVO();
    private SYS_PARAM_SCREEN_TEMPL_PARAMVO sysParamChrgTempScreensVO = new SYS_PARAM_SCREEN_TEMPL_PARAMVO();
    private BCOM_DYN_ENT_TEMPL_CONVVO dynTempConvVO = new BCOM_DYN_ENT_TEMPL_CONVVO(); 
    private BCOM_DYN_ENT_TEMPL_CONV_ALRTVO dynTempConvAlrtVO = new BCOM_DYN_ENT_TEMPL_CONV_ALRTVO(); 
    private String ParentNode; 
    private String nodeType;
    private BigDecimal screenId;
    private BigDecimal compCode;
    private BigDecimal branchCode;
    private String appName;
    private String progRef;
    private String userID;
    private Date runningDate;
    private String ivCrud;
    private String language;
    private String MAX_NODE_ID;
    private String statusDesc;
    private String entityDesc;
    private String accountName;
    private String cifName;
    private String accAddRef;
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
   
    private AlertsParamCO alertsParamCO = new AlertsParamCO();
    
    private String alertHeaderDetails;
    
    private String segmentName;
    
    private String isFromAlert;
    
    private AMFVO amfVO = new AMFVO();
 
    private CTS_SEGMENTVO  ctsSegmentVO = new CTS_SEGMENTVO();
    
    private CIFVO cifVO = new CIFVO();

    public void setDYN_TEMP_ID(String DYN_TEMP_ID)
    {
	this.DYN_TEMP_ID = DYN_TEMP_ID;
    }

    public String getDYN_TEMP_ID()
    {
	return DYN_TEMP_ID;
    }

    public void setPARENT_ID(String PARENT_ID)
    {
	this.PARENT_ID = PARENT_ID;
    }

    public String getPARENT_ID()
    {
	return PARENT_ID;
    }

    public void setAPP_NAME(String APP_NAME)
    {
	this.APP_NAME = APP_NAME;
    }

    public String getAPP_NAME()
    {
	return APP_NAME;
    }

    public void setAPP_DESC(String APP_DESC)
    {
	this.APP_DESC = APP_DESC;
    }

    public String getAPP_DESC()
    {
	return APP_DESC;
    }
   

   

    public String getParentNode()
    {
        return ParentNode;
    }

    public void setParentNode(String parentNode)
    {
        ParentNode = parentNode;
    }

  

    public String getNodeType()
    {
        return nodeType;
    }

    public void setNodeType(String nodeType)
    {
        this.nodeType = nodeType;
    }

    public BigDecimal getScreenId()
    {
        return screenId;
    }

    public void setScreenId(BigDecimal screenId)
    {
        this.screenId = screenId;
    }

    public BigDecimal getCompCode()
    {
        return compCode;
    }

    public void setCompCode(BigDecimal compCode)
    {
        this.compCode = compCode;
    }

    public BigDecimal getBranchCode()
    {
        return branchCode;
    }

    public void setBranchCode(BigDecimal branchCode)
    {
        this.branchCode = branchCode;
    }

    public String getAppName()
    {
        return appName;
    }

    public void setAppName(String appName)
    {
        this.appName = appName;
    }

    public String getProgRef()
    {
        return progRef;
    }

    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }

    public String getUserID()
    {
        return userID;
    }

    public void setUserID(String userID)
    {
        this.userID = userID;
    }

    public Date getRunningDate()
    {
        return runningDate;
    }

    public void setRunningDate(Date runningDate)
    {
        this.runningDate = runningDate;
    }

    public String getIvCrud()
    {
        return ivCrud;
    }

    public void setIvCrud(String ivCrud)
    {
        this.ivCrud = ivCrud;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getMAX_NODE_ID()
    {
        return MAX_NODE_ID;
    }

    public void setMAX_NODE_ID(String mAX_NODE_ID)
    {
        MAX_NODE_ID = mAX_NODE_ID;
    }


    public String getStatusDesc()
    {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc)
    {
        this.statusDesc = statusDesc;
    }

    public String getEntityDesc()
    {
        return entityDesc;
    }

    public void setEntityDesc(String entityDesc)
    {
        this.entityDesc = entityDesc;
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


    public String getAccAddRef()
    {
        return accAddRef;
    }

    public void setAccAddRef(String accAddRef)
    {
        this.accAddRef = accAddRef;
    }

   

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm()
    {
        return hm;
    }

    public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm)
    {
        this.hm = hm;
    }
  

    public AlertsParamCO getAlertsParamCO()
    {
        return alertsParamCO;
    }

    public void setAlertsParamCO(AlertsParamCO alertsParamCO)
    {
        this.alertsParamCO = alertsParamCO;
    }

    public String getAlertHeaderDetails()
    {
        return alertHeaderDetails;
    }

    public void setAlertHeaderDetails(String alertHeaderDetails)
    {
        this.alertHeaderDetails = alertHeaderDetails;
    }

    public String getIsFromAlert()
    {
        return isFromAlert;
    }

    public void setIsFromAlert(String isFromAlert)
    {
        this.isFromAlert = isFromAlert;
    }

    public AMFVO getAmfVO()
    {
        return amfVO;
    }

    public void setAmfVO(AMFVO amfVO)
    {
        this.amfVO = amfVO;
    }

    public CTS_SEGMENTVO getCtsSegmentVO()
    {
        return ctsSegmentVO;
    }

    public void setCtsSegmentVO(CTS_SEGMENTVO ctsSegmentVO)
    {
        this.ctsSegmentVO = ctsSegmentVO;
    }

    public String getSegmentName()
    {
        return segmentName;
    }

    public void setSegmentName(String segmentName)
    {
        this.segmentName = segmentName;
    }

    public CIFVO getCifVO()
    {
        return cifVO;
    }

    public void setCifVO(CIFVO cifVO)
    {
        this.cifVO = cifVO;
    }

    public SYS_PARAM_SCREEN_TEMPL_PARAMVO getSysParamChrgTempScreensVO()
    {
        return sysParamChrgTempScreensVO;
    }

    public void setSysParamChrgTempScreensVO(SYS_PARAM_SCREEN_TEMPL_PARAMVO sysParamChrgTempScreensVO)
    {
        this.sysParamChrgTempScreensVO = sysParamChrgTempScreensVO;
    }

    public BCOM_DYN_PROD_TEMPLATEVO getDynTemplateVO()
    {
        return dynTemplateVO;
    }

    public void setDynTemplateVO(BCOM_DYN_PROD_TEMPLATEVO dynTemplateVO)
    {
        this.dynTemplateVO = dynTemplateVO;
    }

    public BCOM_DYN_PROD_TEMPLATE_NODEVO getDynTemplateNodesVO()
    {
        return dynTemplateNodesVO;
    }

    public void setDynTemplateNodesVO(BCOM_DYN_PROD_TEMPLATE_NODEVO dynTemplateNodesVO)
    {
        this.dynTemplateNodesVO = dynTemplateNodesVO;
    }

    public BCOM_DYN_ENT_TEMPL_CONVVO getDynTempConvVO()
    {
        return dynTempConvVO;
    }

    public void setDynTempConvVO(BCOM_DYN_ENT_TEMPL_CONVVO dynTempConvVO)
    {
        this.dynTempConvVO = dynTempConvVO;
    }

    public BCOM_DYN_ENT_TEMPL_CONV_ALRTVO getDynTempConvAlrtVO()
    {
        return dynTempConvAlrtVO;
    }

    public void setDynTempConvAlrtVO(BCOM_DYN_ENT_TEMPL_CONV_ALRTVO dynTempConvAlrtVO)
    {
        this.dynTempConvAlrtVO = dynTempConvAlrtVO;
    }

}
