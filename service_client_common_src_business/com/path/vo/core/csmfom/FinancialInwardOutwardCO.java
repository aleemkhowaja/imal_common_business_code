package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_IN_OUT_FLOWVO;
import com.path.dbmaps.vo.CTSTELLERVO;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: AIssac
 * 
 *          FOMBalanceLimitCO.java used to
 */
public class FinancialInwardOutwardCO extends CIF_IN_OUT_FLOWVO
{
    private String INDICATOR_DESC;
    private String FLOW_TYPE;
    private BigDecimal NET_VALUE;
    private BigDecimal TOTAL_NET_INCOME;
    private BigDecimal TOTAL_GROSS_INCOME;
    private BigDecimal TOTAL_NET_FIN_COMMIT;
    private BigDecimal TOTAL_FIN_COMMIT;
    private String msgDelete;
    private String msgSave;
    private String addGrid;
    private String errorMessage;
    private CIFVO cifVo  = new CIFVO();
    private String latestDateUpdated;
    private Boolean accesByTeller = true;
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    
    

    public String getINDICATOR_DESC()
    {
	return INDICATOR_DESC;
    }

    public void setINDICATOR_DESC(String iNDICATORDESC)
    {
	INDICATOR_DESC = iNDICATORDESC;
    }

    public BigDecimal getNET_VALUE()
    {
	return NET_VALUE;
    }

    public void setNET_VALUE(BigDecimal nETVALUE)
    {
	NET_VALUE = nETVALUE;
    }

    public BigDecimal getTOTAL_NET_FIN_COMMIT()
    {
	return TOTAL_NET_FIN_COMMIT;
    }

    public void setTOTAL_NET_FIN_COMMIT(BigDecimal tOTALNETFINCOMMIT)
    {
	TOTAL_NET_FIN_COMMIT = tOTALNETFINCOMMIT;
    }

    public BigDecimal getTOTAL_FIN_COMMIT()
    {
	return TOTAL_FIN_COMMIT;
    }

    public void setTOTAL_FIN_COMMIT(BigDecimal tOTALFINCOMMIT)
    {
	TOTAL_FIN_COMMIT = tOTALFINCOMMIT;
    }

    public BigDecimal getTOTAL_NET_INCOME()
    {
	return TOTAL_NET_INCOME;
    }

    public void setTOTAL_NET_INCOME(BigDecimal tOTALNETINCOME)
    {
	TOTAL_NET_INCOME = tOTALNETINCOME;
    }

    public BigDecimal getTOTAL_GROSS_INCOME()
    {
	return TOTAL_GROSS_INCOME;
    }

    public void setTOTAL_GROSS_INCOME(BigDecimal tOTALGROSSINCOME)
    {
	TOTAL_GROSS_INCOME = tOTALGROSSINCOME;
    }

    public String getFLOW_TYPE()
    {
	return FLOW_TYPE;
    }

    public void setFLOW_TYPE(String fLOWTYPE)
    {
	FLOW_TYPE = fLOWTYPE;
    }

    public String getMsgDelete()
    {
	return msgDelete;
    }

    public void setMsgDelete(String msgDelete)
    {
	this.msgDelete = msgDelete;
    }

    public String getMsgSave()
    {
	return msgSave;
    }

    public void setMsgSave(String msgSave)
    {
	this.msgSave = msgSave;
    }

    public String getAddGrid()
    {
	return addGrid;
    }

    public void setAddGrid(String addGrid)
    {
	this.addGrid = addGrid;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
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
    
    public Boolean getAccesByTeller()
    {
	return accesByTeller;
    }

    public void setAccesByTeller(Boolean accesByTeller)
    {
	this.accesByTeller = accesByTeller;
    }

    public CTSTELLERVO getCtsTellerVO()
    {
	return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
	this.ctsTellerVO = ctsTellerVO;
    }
}
