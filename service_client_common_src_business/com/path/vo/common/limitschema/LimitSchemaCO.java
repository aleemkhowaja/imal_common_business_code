/**
 * 
 */
package com.path.vo.common.limitschema;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.LIMIT_SCHEMAVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: raees
 * 
 *          LimitSchemaCO.java used to
 */
public class LimitSchemaCO extends RetailBaseVO implements Serializable
{
    private LIMIT_SCHEMAVO limitSchemaVO = new LIMIT_SCHEMAVO();
    private CIFVO cifVo = new CIFVO();
    private String unlimited;
    private String transactionDesc;
    private String neverExpire;
    private BigDecimal limitAmtFormat;
    // Flag for validating combinations
    // Yes will check combination for group1 to group10
    // No will check combination for group1 to group4
    private boolean allowAllGroupCombination;
    // Flag to identify from the where the record was fetched.
    // origin 1-LIMIT_SCHEMAVO and origin 2-LIMIT_SCHEMA_TEMPVO
    private String origin;
    private String ADDED;
    private String CHANGED;
    private String DELETED;
    private String auditFor;
    private String cifStatus;
    private Date cif_UpdateDate;
    private String LatestDateUpdated;
    private CTSTELLERVO ctsTellerVO;
    private Boolean accesByTeller = true;
    private String fromWhere;
    
    /**
     * @return the limitSchemaVO
     */
    public LIMIT_SCHEMAVO getLimitSchemaVO()
    {
	return limitSchemaVO;
    }

    /**
     * @param limitSchemaVO the limitSchemaVO to set
     */
    public void setLimitSchemaVO(LIMIT_SCHEMAVO limitSchemaVO)
    {
	this.limitSchemaVO = limitSchemaVO;
    }

    /**
     * @return the unlimited
     */
    public String getUnlimited()
    {
	return unlimited;
    }

    /**
     * @param unlimited the unlimited to set
     */
    public void setUnlimited(String unlimited)
    {
	this.unlimited = unlimited;
    }

    /**
     * @return the transactionDesc
     */
    public String getTransactionDesc()
    {
	return transactionDesc;
    }

    /**
     * @param transactionDesc the transactionDesc to set
     */
    public void setTransactionDesc(String transactionDesc)
    {
	this.transactionDesc = transactionDesc;
    }

    /**
     * @return the neverExpire
     */
    public String getNeverExpire()
    {
	return neverExpire;
    }

    /**
     * @param neverExpire the neverExpire to set
     */
    public void setNeverExpire(String neverExpire)
    {
	this.neverExpire = neverExpire;
    }

    /**
     * @return the allowAllGroupCombination
     */
    public boolean isAllowAllGroupCombination()
    {
	return allowAllGroupCombination;
    }

    /**
     * @param allowAllGroupCombination the allowAllGroupCombination to set
     */
    public void setAllowAllGroupCombination(boolean allowAllGroupCombination)
    {
	this.allowAllGroupCombination = allowAllGroupCombination;
    }

    /**
     * @return the limitAmtFormat
     */
    public BigDecimal getLimitAmtFormat()
    {
	return limitAmtFormat;
    }

    /**
     * @param limitAmtFormat the limitAmtFormat to set
     */
    public void setLimitAmtFormat(BigDecimal limitAmtFormat)
    {
	this.limitAmtFormat = limitAmtFormat;
    }

    public String getOrigin()
    {
	return origin;
    }

    public void setOrigin(String origin)
    {
	this.origin = origin;
    }

    public String getADDED()
    {
	return ADDED;
    }

    public void setADDED(String aDDED)
    {
	ADDED = aDDED;
    }

    public CIFVO getCifVo()
    {
        return cifVo;
    }

    public void setCifVo(CIFVO cifVo)
    {
        this.cifVo = cifVo;
    }

    public String getCHANGED()
    {
	return CHANGED;
    }

    public void setCHANGED(String cHANGED)
    {
	CHANGED = cHANGED;
    }

    public String getDELETED()
    {
	return DELETED;
    }

    public void setDELETED(String dELETED)
    {
	DELETED = dELETED;
    }

    public String getAuditFor()
    {
	return auditFor;
    }

    public void setAuditFor(String auditFor)
    {
	this.auditFor = auditFor;
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

    public void setCif_UpdateDate(Date cifUpdateDate)
    {
        cif_UpdateDate = cifUpdateDate;
    }

    public String getLatestDateUpdated()
    {
        return LatestDateUpdated;
    }

    public void setLatestDateUpdated(String latestDateUpdated)
    {
        LatestDateUpdated = latestDateUpdated;
    }

    public CTSTELLERVO getCtsTellerVO()
    {
        return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
        this.ctsTellerVO = ctsTellerVO;
    }

    public Boolean getAccesByTeller()
    {
        return accesByTeller;
    }

    public void setAccesByTeller(Boolean accesByTeller)
    {
        this.accesByTeller = accesByTeller;
    }

    public String getFromWhere()
    {
        return fromWhere;
    }

    public void setFromWhere(String fromWhere)
    {
        this.fromWhere = fromWhere;
    }
}
