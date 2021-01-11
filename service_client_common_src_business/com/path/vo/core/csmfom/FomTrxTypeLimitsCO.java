package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CIF_TRXTYPE_LIMITSVO;
import com.path.dbmaps.vo.CIF_UTIL_REF_PREFIXVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.CTS_PAYMENT_CHANNELVO;
import com.path.dbmaps.vo.CTS_REG_BILL_TYPEVO;
import com.path.dbmaps.vo.CTS_REG_BILL_TYPEVOKey;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: AIssac
 * 
 *          FomTrxTypeLimitsCO.java used to
 */
public class FomTrxTypeLimitsCO extends RetailBaseVO
{
    private CIF_TRXTYPE_LIMITSVO fomCifTrxtypeLimitsVO = new CIF_TRXTYPE_LIMITSVO();
    private CTSTRXTYPEVO CtsTrxTypeVO = new CTSTRXTYPEVO();
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private CTS_REG_BILL_TYPEVO ctsRegBillType = new CTS_REG_BILL_TYPEVO();
    List<CIF_UTIL_REF_PREFIXVO> listRefPrefix = new ArrayList<CIF_UTIL_REF_PREFIXVO>();
    List<CTS_PAYMENT_CHANNELVO> listBillRegnChannel = new ArrayList<CTS_PAYMENT_CHANNELVO>();
    private String BILL_DESC;
    private String billTypeGridUpdates;
    private String addFieldsGridUpdates;// abir
    
    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> businessElement = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();

    private String TRX_DESC;
    private String CY_DESC;
    private String cif_no;
    private String TMP_DESC;
    private String CHARGE_SCHEMA_NAME;
    private String CHARGE_SCHEMA_OPER_NAME;
    private String TYPE_DESC;
    private String DESC_PROVIDER_REP_ENG;
    private String DESC_PROVIDER_REP_ARAB;
    private String DESC_PROVIDER_ARG_ENG;
    private String DESC_PROVIDER_ARG_ARAB;
    private String USER_LEVEL_DESC;
    private String paymentChannelkey;
    private String registerBillTypekey;
    private String referencePrefixKey;
    // added by jihad
    private String saveType;
    private String colName;
    private String cifStatus;
    private String iv_crud;
    private String appName;
    private Date cif_UpdateDate;

    private String AC_DESC;
    private String ACC_ADD_REF;

    private Boolean accesByTeller = true;
    
    private ArrayList<FomTrxTypeLimitsCO> regBillTypeListCO  = new ArrayList<FomTrxTypeLimitsCO>();
    private ArrayList<FomTrxTypelimitAddFieldsCO> addFieldsListCO  = new ArrayList<FomTrxTypelimitAddFieldsCO>();//abir

    
    private String CIF_SHORT_NAME_ARAB;
    private String CIF_SHORT_NAME_ENG;
    private String BILL_TYPE_LONG_DESC_ARAB;
    private String BILL_TYPE_LONG_DESC_ENG;
    private String CY_BRIEF_DESC_ARAB;
    private String CY_LONG_DESC_ENG;
    private String CY_BRIEF_DESC_ENG;
    private String ADDITIONAL_REFERENCE;
    private String SHOW_TRX_PURPOSE;
    private String E_WALLET_YN;
    private String NICKNAME_MANDATORY_YN;
    private BigDecimal Limit;
    private BigDecimal oldTrxType;
    private BigDecimal oldCyCode;
    private BigDecimal compCodeCif;
    private String addAccByProviderByBill;
    private BigDecimal oldCifCode;
    private BigDecimal oldCy;
    private AMFVO accountVO = new AMFVO();
    //used for webservice 
    private String delete;
    
    @Override
    public String getAppName()
    {
	return appName;
    }

    @Override
    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    public String getBILL_DESC()
    {
        return BILL_DESC;
    }

    public void setBILL_DESC(String bILLDESC)
    {
        BILL_DESC = bILLDESC;
    }

    public String getUSER_LEVEL_DESC()
    {
	return USER_LEVEL_DESC;
    }

    public void setUSER_LEVEL_DESC(String uSERLEVELDESC)
    {
	USER_LEVEL_DESC = uSERLEVELDESC;
    }

    public String getTMP_DESC()
    {
	return TMP_DESC;
    }

    public void setTMP_DESC(String tMPDESC)
    {
	TMP_DESC = tMPDESC;
    }

    public String getCHARGE_SCHEMA_NAME()
    {
	return CHARGE_SCHEMA_NAME;
    }

    public void setCHARGE_SCHEMA_NAME(String cHARGESCHEMANAME)
    {
	CHARGE_SCHEMA_NAME = cHARGESCHEMANAME;
    }

    public String getCHARGE_SCHEMA_OPER_NAME()
    {
	return CHARGE_SCHEMA_OPER_NAME;
    }

    public void setCHARGE_SCHEMA_OPER_NAME(String cHARGESCHEMAOPERNAME)
    {
	CHARGE_SCHEMA_OPER_NAME = cHARGESCHEMAOPERNAME;
    }

    public String getTYPE_DESC()
    {
	return TYPE_DESC;
    }

    public void setTYPE_DESC(String tYPEDESC)
    {
	TYPE_DESC = tYPEDESC;
    }

    public String getDESC_PROVIDER_REP_ENG()
    {
	return DESC_PROVIDER_REP_ENG;
    }

    public void setDESC_PROVIDER_REP_ENG(String dESCPROVIDERREPENG)
    {
	DESC_PROVIDER_REP_ENG = dESCPROVIDERREPENG;
    }

    public String getTRX_DESC()
    {
	return TRX_DESC;
    }

    public void setTRX_DESC(String tRXDESC)
    {
	TRX_DESC = tRXDESC;
    }

    public String getCY_DESC()
    {
	return CY_DESC;
    }

    public void setCY_DESC(String cYDESC)
    {
	CY_DESC = cYDESC;
    }

    public CIF_TRXTYPE_LIMITSVO getFomCifTrxtypeLimitsVO()
    {
	return fomCifTrxtypeLimitsVO;
    }

    public void setFomCifTrxtypeLimitsVO(CIF_TRXTYPE_LIMITSVO fomCifTrxtypeLimitsVO)
    {
	this.fomCifTrxtypeLimitsVO = fomCifTrxtypeLimitsVO;
    }

    public String getSaveType()
    {
	return saveType;
    }

    public void setSaveType(String saveType)
    {
	this.saveType = saveType;
    }

    public String getCifStatus()
    {
	return cifStatus;
    }

    public void setCifStatus(String cifStatus)
    {
	this.cifStatus = cifStatus;
    }

    public String getIv_crud()
    {
	return iv_crud;
    }

    public void setIv_crud(String ivCrud)
    {
	iv_crud = ivCrud;
    }

    public Date getCif_UpdateDate()
    {
	return cif_UpdateDate;
    }

    public void setCif_UpdateDate(Date cifUpdateDate)
    {
	cif_UpdateDate = cifUpdateDate;
    }

    public CTSTELLERVO getCtsTellerVO()
    {
	return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
	this.ctsTellerVO = ctsTellerVO;
    }

    public String getAC_DESC()
    {
	return AC_DESC;
    }

    public void setAC_DESC(String aCDESC)
    {
	AC_DESC = aCDESC;
    }

    public Boolean getAccesByTeller()
    {
	return accesByTeller;
    }

    public void setAccesByTeller(Boolean accesByTeller)
    {
	this.accesByTeller = accesByTeller;
    }

    public CTSTRXTYPEVO getCtsTrxTypeVO()
    {
        return CtsTrxTypeVO;
    }

    public void setCtsTrxTypeVO(CTSTRXTYPEVO ctsTrxTypeVO)
    {
        CtsTrxTypeVO = ctsTrxTypeVO;
    }

    public String getACC_ADD_REF()
    {
        return ACC_ADD_REF;
    }

    public void setACC_ADD_REF(String aCCADDREF)
    {
        ACC_ADD_REF = aCCADDREF;
    }

    /**
     * @return the paymentChannelkey
     */
    public String getPaymentChannelkey()
    {
        return paymentChannelkey;
    }

    /**
     * @param paymentChannelkey the paymentChannelkey to set
     */
    public void setPaymentChannelkey(String paymentChannelkey)
    {
        this.paymentChannelkey = paymentChannelkey;
    }

    /**
     * @return the registerBillTypekey
     */
    public String getRegisterBillTypekey()
    {
        return registerBillTypekey;
    }

    /**
     * @param registerBillTypekey the registerBillTypekey to set
     */
    public void setRegisterBillTypekey(String registerBillTypekey)
    {
        this.registerBillTypekey = registerBillTypekey;
    }

    /**
     * @return the referencePrefixKey
     */
    public String getReferencePrefixKey()
    {
        return referencePrefixKey;
    }

    /**
     * @param referencePrefixKey the referencePrefixKey to set
     */
    public void setReferencePrefixKey(String referencePrefixKey)
    {
        this.referencePrefixKey = referencePrefixKey;
    }

    /**
     * @return the cif_no
     */
    public String getCif_no()
    {
        return cif_no;
    }

    /**
     * @param cifNo the cif_no to set
     */
    public void setCif_no(String cifNo)
    {
        cif_no = cifNo;
    }

    /**
     * @return the businessElement
     */
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getBusinessElement()
    {
        return businessElement;
    }

    /**
     * @param businessElement the businessElement to set
     */
    public void setBusinessElement(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> businessElement)
    {
        this.businessElement = businessElement;
    }

    /**
     * @return the dESC_PROVIDER_REP_ARAB
     */
    public String getDESC_PROVIDER_REP_ARAB()
    {
        return DESC_PROVIDER_REP_ARAB;
    }

    /**
     * @param dESCPROVIDERREPARAB the dESC_PROVIDER_REP_ARAB to set
     */
    public void setDESC_PROVIDER_REP_ARAB(String dESCPROVIDERREPARAB)
    {
        DESC_PROVIDER_REP_ARAB = dESCPROVIDERREPARAB;
    }

    /**
     * @return the dESC_PROVIDER_ARG_ENG
     */
    public String getDESC_PROVIDER_ARG_ENG()
    {
        return DESC_PROVIDER_ARG_ENG;
    }

    /**
     * @param dESCPROVIDERARGENG the dESC_PROVIDER_ARG_ENG to set
     */
    public void setDESC_PROVIDER_ARG_ENG(String dESCPROVIDERARGENG)
    {
        DESC_PROVIDER_ARG_ENG = dESCPROVIDERARGENG;
    }

    /**
     * @return the dESC_PROVIDER_ARG_ARAB
     */
    public String getDESC_PROVIDER_ARG_ARAB()
    {
        return DESC_PROVIDER_ARG_ARAB;
    }

    /**
     * @param dESCPROVIDERARGARAB the dESC_PROVIDER_ARG_ARAB to set
     */
    public void setDESC_PROVIDER_ARG_ARAB(String dESCPROVIDERARGARAB)
    {
        DESC_PROVIDER_ARG_ARAB = dESCPROVIDERARGARAB;
    }

    /**
     * @return the colName
     */
    public String getColName()
    {
        return colName;
    }

    /**
     * @param colName the colName to set
     */
    public void setColName(String colName)
    {
        this.colName = colName;
    }


    public ArrayList<FomTrxTypeLimitsCO> getRegBillTypeListCO()
    {
        return regBillTypeListCO;
    }

    public void setRegBillTypeListCO(ArrayList<FomTrxTypeLimitsCO> regBillTypeListCO)
    {
        this.regBillTypeListCO = regBillTypeListCO;
    }

    public String getBillTypeGridUpdates()
    {
        return billTypeGridUpdates;
    }

    public void setBillTypeGridUpdates(String billTypeGridUpdates)
    {
        this.billTypeGridUpdates = billTypeGridUpdates;
    }

    public CTS_REG_BILL_TYPEVO getCtsRegBillType()
    {
        return ctsRegBillType;
    }

    public void setCtsRegBillType(CTS_REG_BILL_TYPEVO ctsRegBillType)
    {
        this.ctsRegBillType = ctsRegBillType;
    }

    public List<CIF_UTIL_REF_PREFIXVO> getListRefPrefix()
    {
        return listRefPrefix;
    }

    public void setListRefPrefix(List<CIF_UTIL_REF_PREFIXVO> listRefPrefix)
    {
        this.listRefPrefix = listRefPrefix;
    }

    public List<CTS_PAYMENT_CHANNELVO> getListBillRegnChannel()
    {
        return listBillRegnChannel;
    }

    public void setListBillRegnChannel(List<CTS_PAYMENT_CHANNELVO> listBillRegnChannel)
    {
        this.listBillRegnChannel = listBillRegnChannel;
    }

    public String getAddFieldsGridUpdates()
    {
        return addFieldsGridUpdates;
    }

    public void setAddFieldsGridUpdates(String addFieldsGridUpdates)
    {
        this.addFieldsGridUpdates = addFieldsGridUpdates;
    }

    public ArrayList<FomTrxTypelimitAddFieldsCO> getAddFieldsListCO()
    {
        return addFieldsListCO;
    }

    public void setAddFieldsListCO(ArrayList<FomTrxTypelimitAddFieldsCO> addFieldsListCO)
    {
        this.addFieldsListCO = addFieldsListCO;
    }



    public String getCIF_SHORT_NAME_ARAB()
    {
	return CIF_SHORT_NAME_ARAB;
    }

    public void setCIF_SHORT_NAME_ARAB(String cIF_SHORT_NAME_ARAB)
    {
	CIF_SHORT_NAME_ARAB = cIF_SHORT_NAME_ARAB;
    }

    public String getCIF_SHORT_NAME_ENG()
    {
	return CIF_SHORT_NAME_ENG;
    }

    public void setCIF_SHORT_NAME_ENG(String cIF_SHORT_NAME_ENG)
    {
	CIF_SHORT_NAME_ENG = cIF_SHORT_NAME_ENG;
    }

    public String getBILL_TYPE_LONG_DESC_ARAB()
    {
	return BILL_TYPE_LONG_DESC_ARAB;
    }

    public void setBILL_TYPE_LONG_DESC_ARAB(String bILL_TYPE_LONG_DESC_ARAB)
    {
	BILL_TYPE_LONG_DESC_ARAB = bILL_TYPE_LONG_DESC_ARAB;
    }

    public String getCY_BRIEF_DESC_ARAB()
    {
	return CY_BRIEF_DESC_ARAB;
    }

    public void setCY_BRIEF_DESC_ARAB(String cY_BRIEF_DESC_ARAB)
    {
	CY_BRIEF_DESC_ARAB = cY_BRIEF_DESC_ARAB;
    }

    public String getCY_LONG_DESC_ENG()
    {
	return CY_LONG_DESC_ENG;
    }

    public void setCY_LONG_DESC_ENG(String cY_LONG_DESC_ENG)
    {
	CY_LONG_DESC_ENG = cY_LONG_DESC_ENG;
    }

    public String getCY_BRIEF_DESC_ENG()
    {
        return CY_BRIEF_DESC_ENG;
    }

    public void setCY_BRIEF_DESC_ENG(String cY_BRIEF_DESC_ENG)
    {
        CY_BRIEF_DESC_ENG = cY_BRIEF_DESC_ENG;
    }

    public String getADDITIONAL_REFERENCE()
    {
        return ADDITIONAL_REFERENCE;
    }

    public void setADDITIONAL_REFERENCE(String aDDITIONAL_REFERENCE)
    {
        ADDITIONAL_REFERENCE = aDDITIONAL_REFERENCE;
    }

    public String getSHOW_TRX_PURPOSE()
    {
        return SHOW_TRX_PURPOSE;
    }

    public void setSHOW_TRX_PURPOSE(String sHOW_TRX_PURPOSE)
    {
        SHOW_TRX_PURPOSE = sHOW_TRX_PURPOSE;
    }

    public String getE_WALLET_YN()
    {
        return E_WALLET_YN;
    }

    public void setE_WALLET_YN(String e_WALLET_YN)
    {
        E_WALLET_YN = e_WALLET_YN;
    }

    public String getBILL_TYPE_LONG_DESC_ENG()
    {
        return BILL_TYPE_LONG_DESC_ENG;
    }

    public void setBILL_TYPE_LONG_DESC_ENG(String bILL_TYPE_LONG_DESC_ENG)
    {
        BILL_TYPE_LONG_DESC_ENG = bILL_TYPE_LONG_DESC_ENG;
    }

    public String getNICKNAME_MANDATORY_YN()
    {
        return NICKNAME_MANDATORY_YN;
    }

    public void setNICKNAME_MANDATORY_YN(String nICKNAME_MANDATORY_YN)
    {
        NICKNAME_MANDATORY_YN = nICKNAME_MANDATORY_YN;
    }

    public BigDecimal getLimit()
    {
	return Limit;
    }

    public void setLimit(BigDecimal limit)
    {
	Limit = limit;
    }

    public AMFVO getAccountVO()
    {
        return accountVO;
    }

    public void setAccountVO(AMFVO accountVO)
    {
        this.accountVO = accountVO;
    }

    public String getDelete()
    {
        return delete;
    }

    public void setDelete(String delete)
    {
        this.delete = delete;
    }

    public BigDecimal getOldTrxType()
    {
        return oldTrxType;
    }

    public void setOldTrxType(BigDecimal oldTrxType)
    {
        this.oldTrxType = oldTrxType;
    }

    public BigDecimal getOldCyCode()
    {
        return oldCyCode;
    }

    public void setOldCyCode(BigDecimal oldCyCode)
    {
        this.oldCyCode = oldCyCode;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
	this.compCodeCif = compCodeCif;
    }

    public BigDecimal getCompCodeCif()
    {
	return compCodeCif;
    }

    public String getAddAccByProviderByBill()
    {
        return addAccByProviderByBill;
    }

    public void setAddAccByProviderByBill(String addAccByProviderByBill)
    {
        this.addAccByProviderByBill = addAccByProviderByBill;
    }
    
    public BigDecimal getOldCifCode()
    {
        return oldCifCode;
    }

    public void setOldCifCode(BigDecimal oldCifCode)
    {
        this.oldCifCode = oldCifCode;
    }

    public BigDecimal getOldCy()
    {
        return oldCy;
    }

    public void setOldCy(BigDecimal oldCy)
    {
        this.oldCy = oldCy;
    }

}
