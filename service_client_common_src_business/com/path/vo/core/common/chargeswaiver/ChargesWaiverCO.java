package com.path.vo.core.common.chargeswaiver;


import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSCHARGES_WAIVERVO;
import com.path.dbmaps.vo.CTSCHARGES_WAIVER_TRXVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.core.common.RetailBaseVO;

public class ChargesWaiverCO extends RetailBaseVO
{
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> sysParamScreenDisplayHm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    
    private CTSCHARGES_WAIVERVO ctsChargesWaiverVO = new CTSCHARGES_WAIVERVO();
    
    private Boolean isVisible  = false;
    
    private Date runningDate;
    
    private String chargesWaiverGridUpdates;
    
    private CIFVO cifVo  = new CIFVO();
    
    private String latestDateUpdated;
    
    private String cifStatus;
    
    private Date cif_UpdateDate;
    
    private List<ChargesWaiverCO> chargesWaiverList;
    
    private String screenRef;
    
    private String entityCode;
    
    private String entityType;
    
    // Rania - AIB150186 and AIB170086
    private CTSCHARGES_WAIVER_TRXVO ctsChargesWaiverTrxVO = new CTSCHARGES_WAIVER_TRXVO();
    private String trxTypesWaiverChargesGridUpdate;
    private String trxTypeWaiverChargesLoaded;
    private List<CTSCHARGES_WAIVER_TRXVO> ctsChargesWaiverTrxListVO;
    private String trxTypeDesc;
    //
    
    public CTSCHARGES_WAIVERVO getCtsChargesWaiverVO()
    {
        return ctsChargesWaiverVO;
    }

    public void setCtsChargesWaiverVO(CTSCHARGES_WAIVERVO ctsChargesWaiverVO)
    {
        this.ctsChargesWaiverVO = ctsChargesWaiverVO;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getSysParamScreenDisplayHm()
    {
        return sysParamScreenDisplayHm;
    }

    public void setSysParamScreenDisplayHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> sysParamScreenDisplayHm)
    {
        this.sysParamScreenDisplayHm = sysParamScreenDisplayHm;
    }

    public Boolean getIsVisible()
    {
        return isVisible;
    }

    public void setIsVisible(Boolean isVisible)
    {
        this.isVisible = isVisible;
    }

    public Date getRunningDate()
    {
        return runningDate;
    }

    public void setRunningDate(Date runningDate)
    {
        this.runningDate = runningDate;
    }
    public CIFVO getCifVo()
    {
        return cifVo;
    }

    public void setCifVo(CIFVO cifVo)
    {
        this.cifVo = cifVo;
    }

    public String getLatestDateUpdated()
    {
        return latestDateUpdated;
    }

    public void setLatestDateUpdated(String latestDateUpdated)
    {
        this.latestDateUpdated = latestDateUpdated;
    }

    public String getCifStatus()
    {
        return cifStatus;
    }

    public void setCifStatus(String cifStatus)
    {
        this.cifStatus = cifStatus;
    }

    public Date getCif_UpdateDate()
    {
        return cif_UpdateDate;
    }

    public void setCif_UpdateDate(Date cif_UpdateDate)
    {
        this.cif_UpdateDate = cif_UpdateDate;
    }

    public String getChargesWaiverGridUpdates()
    {
        return chargesWaiverGridUpdates;
    }

    public void setChargesWaiverGridUpdates(String chargesWaiverGridUpdates)
    {
        this.chargesWaiverGridUpdates = chargesWaiverGridUpdates;
    }

    public List<ChargesWaiverCO> getChargesWaiverList()
    {
        return chargesWaiverList;
    }

    public void setChargesWaiverList(List<ChargesWaiverCO> chargesWaiverList)
    {
        this.chargesWaiverList = chargesWaiverList;
    }

    public String getScreenRef()
    {
        return screenRef;
    }

    public void setScreenRef(String screenRef)
    {
        this.screenRef = screenRef;
    }

    public String getEntityCode()
    {
        return entityCode;
    }

    public void setEntityCode(String entityCode)
    {
        this.entityCode = entityCode;
    }

    public String getEntityType()
    {
        return entityType;
    }

    public void setEntityType(String entityType)
    {
        this.entityType = entityType;
    }

    public CTSCHARGES_WAIVER_TRXVO getCtsChargesWaiverTrxVO()
    {
        return ctsChargesWaiverTrxVO;
    }

    public void setCtsChargesWaiverTrxVO(CTSCHARGES_WAIVER_TRXVO ctsChargesWaiverTrxVO)
    {
        this.ctsChargesWaiverTrxVO = ctsChargesWaiverTrxVO;
    }

    public String getTrxTypesWaiverChargesGridUpdate()
    {
        return trxTypesWaiverChargesGridUpdate;
    }

    public void setTrxTypesWaiverChargesGridUpdate(String trxTypesWaiverChargesGridUpdate)
    {
        this.trxTypesWaiverChargesGridUpdate = trxTypesWaiverChargesGridUpdate;
    }

    public String getTrxTypeWaiverChargesLoaded()
    {
        return trxTypeWaiverChargesLoaded;
    }

    public void setTrxTypeWaiverChargesLoaded(String trxTypeWaiverChargesLoaded)
    {
        this.trxTypeWaiverChargesLoaded = trxTypeWaiverChargesLoaded;
    }

    public List<CTSCHARGES_WAIVER_TRXVO> getCtsChargesWaiverTrxListVO()
    {
        return ctsChargesWaiverTrxListVO;
    }

    public void setCtsChargesWaiverTrxListVO(List<CTSCHARGES_WAIVER_TRXVO> ctsChargesWaiverTrxListVO)
    {
        this.ctsChargesWaiverTrxListVO = ctsChargesWaiverTrxListVO;
    }

    public String getTrxTypeDesc()
    {
        return trxTypeDesc;
    }

    public void setTrxTypeDesc(String trxTypeDesc)
    {
        this.trxTypeDesc = trxTypeDesc;
    }
}
