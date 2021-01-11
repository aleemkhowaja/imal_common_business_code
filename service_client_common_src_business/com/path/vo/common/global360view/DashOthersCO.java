/**
 * 
 */
package com.path.vo.common.global360view;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSMEMOVO;
import com.path.dbmaps.vo.CTSMEMO_DETVO;
import com.path.dbmaps.vo.CTSSPCONDVO;
import com.path.dbmaps.vo.CTSTRSVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.ID_TYPESVO;
import com.path.dbmaps.vo.S_LINK_CIF_AMFVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: elieachkar
 *
 * DashOthersCO.java used to
 */
public class DashOthersCO extends RetailBaseVO
{
    private CIFVO cifVO;
    private CIFVO cifVO1;
    private ID_TYPESVO idTypesVO;
    private CTSSPCONDVO ctsSpCondVO;
    private AMFVO amfVO;
    private AMFVO amfVO1;
    private S_LINK_CIF_AMFVO sLinkCifAmfVO;
    private CTSMEMO_DETVO ctsMemoDetVO;
    private CTSMEMOVO ctsMemoVO;
    private CTSTRSVO ctstrsVO;
    private CTSTRXTYPEVO ctstrxTypeVO;
    private int isCifCif;
    private int isAccAcc;
    private int isAccCif;
    private int isCifAcc;
    private String remittanceStatus;
    private BigDecimal decimal_points;
    private String remittanceType;
    private Date endDate;
    private Date startDate;
    private String trsType;
    private String from_add_reference;
    private String to_add_reference;
    private String trsStatusDesc;
    private BigDecimal nbrOfTemplateSO;
    private BigDecimal nbrOfProcessedSO;
    
    public int getIsCifCif()
    {
        return isCifCif;
    }
    public void setIsCifCif(int isCifCif)
    {
        this.isCifCif = isCifCif;
    }
    public int getIsAccAcc()
    {
        return isAccAcc;
    }
    public void setIsAccAcc(int isAccAcc)
    {
        this.isAccAcc = isAccAcc;
    }
    public int getIsAccCif()
    {
        return isAccCif;
    }
    public void setIsAccCif(int isAccCif)
    {
        this.isAccCif = isAccCif;
    }
    public int getIsCifAcc()
    {
        return isCifAcc;
    }
    public void setIsCifAcc(int isCifAcc)
    {
        this.isCifAcc = isCifAcc;
    }
    public CIFVO getCifVO()
    {
        return cifVO;
    }
    public void setCifVO(CIFVO cifVO)
    {
        this.cifVO = cifVO;
    }
    public ID_TYPESVO getIdTypesVO()
    {
        return idTypesVO;
    }
    public void setIdTypesVO(ID_TYPESVO idTypesVO)
    {
        this.idTypesVO = idTypesVO;
    }
    public CTSSPCONDVO getCtsSpCondVO()
    {
        return ctsSpCondVO;
    }
    public void setCtsSpCondVO(CTSSPCONDVO ctsSpCondVO)
    {
        this.ctsSpCondVO = ctsSpCondVO;
    }
    public AMFVO getAmfVO()
    {
        return amfVO;
    }
    public void setAmfVO(AMFVO amfVO)
    {
        this.amfVO = amfVO;
    }
    public S_LINK_CIF_AMFVO getsLinkCifAmfVO()
    {
        return sLinkCifAmfVO;
    }
    public void setsLinkCifAmfVO(S_LINK_CIF_AMFVO sLinkCifAmfVO)
    {
        this.sLinkCifAmfVO = sLinkCifAmfVO;
    }
    public CIFVO getCifVO1()
    {
        return cifVO1;
    }
    public void setCifVO1(CIFVO cifVO1)
    {
        this.cifVO1 = cifVO1;
    }
    public AMFVO getAmfVO1()
    {
        return amfVO1;
    }
    public void setAmfVO1(AMFVO amfVO1)
    {
        this.amfVO1 = amfVO1;
    }
    public CTSMEMO_DETVO getCtsMemoDetVO()
    {
        return ctsMemoDetVO;
    }
    public void setCtsMemoDetVO(CTSMEMO_DETVO ctsMemoDetVO)
    {
        this.ctsMemoDetVO = ctsMemoDetVO;
    }
    public CTSMEMOVO getCtsMemoVO()
    {
        return ctsMemoVO;
    }
    public void setCtsMemoVO(CTSMEMOVO ctsMemoVO)
    {
        this.ctsMemoVO = ctsMemoVO;
    }
    public CTSTRXTYPEVO getCtstrxTypeVO()
    {
        return ctstrxTypeVO;
    }
    public void setCtstrxTypeVO(CTSTRXTYPEVO ctstrxTypeVO)
    {
        this.ctstrxTypeVO = ctstrxTypeVO;
    }
    public CTSTRSVO getCtstrsVO()
    {
        return ctstrsVO;
    }
    public void setCtstrsVO(CTSTRSVO ctstrsVO)
    {
        this.ctstrsVO = ctstrsVO;
    }
    public String getRemittanceStatus()
    {
        return remittanceStatus;
    }
    public void setRemittanceStatus(String remittanceStatus)
    {
        this.remittanceStatus = remittanceStatus;
    }
    /**
     * @return the decimal_points
     */
    public BigDecimal getDecimal_points()
    {
        return decimal_points;
    }
    /**
     * @param decimalPoints the decimal_points to set
     */
    public void setDecimal_points(BigDecimal decimalPoints)
    {
        decimal_points = decimalPoints;
    }
    public String getRemittanceType()
    {
        return remittanceType;
    }
    public void setRemittanceType(String remittanceType)
    {
        this.remittanceType = remittanceType;
    }
    /**
     * @return the endDate
     */
    public Date getEndDate()
    {
        return endDate;
    }
    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }
    /**
     * @return the startDate
     */
    public Date getStartDate()
    {
        return startDate;
    }
    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }
    public String getTrsType()
    {
        return trsType;
    }
    public void setTrsType(String trsType)
    {
        this.trsType = trsType;
    }
    public String getFrom_add_reference()
    {
        return from_add_reference;
    }
    public void setFrom_add_reference(String fromAddReference)
    {
        from_add_reference = fromAddReference;
    }
    public String getTo_add_reference()
    {
        return to_add_reference;
    }
    public void setTo_add_reference(String toAddReference)
    {
        to_add_reference = toAddReference;
    }
    public String getTrsStatusDesc()
    {
        return trsStatusDesc;
    }
    public void setTrsStatusDesc(String trsStatusDesc)
    {
        this.trsStatusDesc = trsStatusDesc;
    }
    public BigDecimal getNbrOfTemplateSO()
    {
        return nbrOfTemplateSO;
    }
    public void setNbrOfTemplateSO(BigDecimal nbrOfTemplateSO)
    {
        this.nbrOfTemplateSO = nbrOfTemplateSO;
    }
    public BigDecimal getNbrOfProcessedSO()
    {
        return nbrOfProcessedSO;
    }
    public void setNbrOfProcessedSO(BigDecimal nbrOfProcessedSO)
    {
        this.nbrOfProcessedSO = nbrOfProcessedSO;
    }
}