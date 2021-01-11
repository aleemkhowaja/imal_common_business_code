package com.path.vo.core.cardintegration;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSCARDSVO;
import com.path.dbmaps.vo.CTS_DB_CARD_AUTOMATIONVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.common.dynfiles.DynFilesImportCO;
import com.path.vo.common.reportresponse.ReportResponseCO;
import com.path.vo.core.common.RetailBaseVO;

public class CardIntegrationCO extends RetailBaseVO
{	
    private CTS_DB_CARD_AUTOMATIONVO cardIntegrationVO = new CTS_DB_CARD_AUTOMATIONVO();
    private CTSCARDSVO ctsCardsVO= new CTSCARDSVO();
    
    private CIFVO cifVO=new CIFVO();
    private AMFVO amfVO=new AMFVO();
    
    private String SHORT_NAME_ENG;
    private String CIF_STATUS;
    
    private String ADDITIONAL_REFERENCE;
    private String ACC_DESC;
    
    private String callingScreen;
    
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    
    private DynFilesImportCO dynFilesImportCO = new DynFilesImportCO();
    
    private ArrayList<LinkedHashMap> returnDynGridRowsData = new ArrayList<LinkedHashMap>();
    
    private String REQUEST_STATUS_DESC;
    
    private Date newExpiryDate;
    
    private String errorCode;
    
    private String ERROR_MESG;
    
    private String MASKED_CARD_NO;
    
    private String ACTION_DESC;
    
    private String defaultAction;
    
    //Hasan ghrayeb -DB200119
    private String DateforRenewal;
    
    //Print Screen-Ali Nakouzi
    private ReportResponseCO reportResponseCO = new ReportResponseCO();
    private String printConfirmationMessage;
    
    
    public CTS_DB_CARD_AUTOMATIONVO getCardIntegrationVO()
    {
        return cardIntegrationVO;
    }
    public void setCardIntegrationVO(CTS_DB_CARD_AUTOMATIONVO cardIntegrationVO)
    {
        this.cardIntegrationVO = cardIntegrationVO;
    }
    public CTSCARDSVO getCtsCardsVO()
    {
        return ctsCardsVO;
    }
    public void setCtsCardsVO(CTSCARDSVO ctsCardsVO)
    {
        this.ctsCardsVO = ctsCardsVO;
    }
    public String getSHORT_NAME_ENG()
    {
        return SHORT_NAME_ENG;
    }
    public void setSHORT_NAME_ENG(String sHORT_NAME_ENG)
    {
        SHORT_NAME_ENG = sHORT_NAME_ENG;
    }
    public String getCIF_STATUS()
    {
        return CIF_STATUS;
    }
    public void setCIF_STATUS(String cIF_STATUS)
    {
        CIF_STATUS = cIF_STATUS;
    }
    public String getADDITIONAL_REFERENCE()
    {
        return ADDITIONAL_REFERENCE;
    }
    public void setADDITIONAL_REFERENCE(String aDDITIONAL_REFERENCE)
    {
        ADDITIONAL_REFERENCE = aDDITIONAL_REFERENCE;
    }
    public String getACC_DESC()
    {
        return ACC_DESC;
    }
    public void setACC_DESC(String aCC_DESC)
    {
        ACC_DESC = aCC_DESC;
    }
    public String getCallingScreen()
    {
        return callingScreen;
    }
    public void setCallingScreen(String callingScreen)
    {
        this.callingScreen = callingScreen;
    }
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm()
    {
        return hm;
    }
    public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm)
    {
        this.hm = hm;
    }
    public DynFilesImportCO getDynFilesImportCO()
    {
        return dynFilesImportCO;
    }
    public void setDynFilesImportCO(DynFilesImportCO dynFilesImportCO)
    {
        this.dynFilesImportCO = dynFilesImportCO;
    }
    public ArrayList<LinkedHashMap> getReturnDynGridRowsData()
    {
        return returnDynGridRowsData;
    }
    public void setReturnDynGridRowsData(ArrayList<LinkedHashMap> returnDynGridRowsData)
    {
        this.returnDynGridRowsData = returnDynGridRowsData;
    }
    public String getREQUEST_STATUS_DESC()
    {
        return REQUEST_STATUS_DESC;
    }
    public void setREQUEST_STATUS_DESC(String rEQUEST_STATUS_DESC)
    {
        REQUEST_STATUS_DESC = rEQUEST_STATUS_DESC;
    }
    public Date getNewExpiryDate()
    {
        return newExpiryDate;
    }
    public void setNewExpiryDate(Date newExpiryDate)
    {
        this.newExpiryDate = newExpiryDate;
    }
    public String getErrorCode()
    {
        return errorCode;
    }
    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }
    public String getERROR_MESG()
    {
        return ERROR_MESG;
    }
    public void setERROR_MESG(String eRROR_MESG)
    {
        ERROR_MESG = eRROR_MESG; 
    }
    public String getMASKED_CARD_NO()
    {
        return MASKED_CARD_NO;
    }
    public void setMASKED_CARD_NO(String mASKED_CARD_NO)
    {
        MASKED_CARD_NO = mASKED_CARD_NO;
    }
    public String getACTION_DESC()
    {
        return ACTION_DESC;
    }
    public void setACTION_DESC(String aCTION_DESC)
    {
        ACTION_DESC = aCTION_DESC;
    }
    public ReportResponseCO getReportResponseCO()
    {
        return reportResponseCO;
    }
    public void setReportResponseCO(ReportResponseCO reportResponseCO)
    {
        this.reportResponseCO = reportResponseCO;
    }
    public String getPrintConfirmationMessage()
    {
        return printConfirmationMessage;
    }
    public void setPrintConfirmationMessage(String printConfirmationMessage)
    {
        this.printConfirmationMessage = printConfirmationMessage;
    }
    public CIFVO getCifVO()
    {
        return cifVO;
    }
    public void setCifVO(CIFVO cifVO)
    {
        this.cifVO = cifVO;
    }
    public AMFVO getAmfVO()
    {
        return amfVO;
    }
    public void setAmfVO(AMFVO amfVO)
    {
        this.amfVO = amfVO;
    }
    public String getDefaultAction()
    {
        return defaultAction;
    }
    public void setDefaultAction(String defaultAction)
    {
        this.defaultAction = defaultAction;
    }

    public String getDateforRenewal()
    {
        return DateforRenewal;
    }
    public void setDateforRenewal(String dateforRenewal)
    {
        DateforRenewal = dateforRenewal;
    }
  
 
    }
