package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.cifswift.CifSwiftBO;
import com.path.dbmaps.vo.S_PMSCIFSWIFTVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.cifswift.CifSwiftSC;
import com.path.vo.core.csmfom.FomCifSwiftCO;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: lvalappil
 * 
 * CifSwiftDependencyAction.java used to
 */
public class CifSwiftDependencyAction extends RetailBaseAction
{
    private CifSwiftBO cifSwiftBO;
    private S_PMSCIFSWIFTVO cifSwiftVO;
    private FomCifSwiftCO fomCifSwiftCO;
    private CifSwiftSC criteria = new CifSwiftSC();
    private BigDecimal code;

    public String dependencyByCifCode()
    {
        try
        {
            SessionCO sessionCO = returnSessionObject();
            CifSwiftSC criteria = new CifSwiftSC();
            criteria.setCompCode(sessionCO.getCompanyCode());
            criteria.setCifCode(code);
            cifSwiftVO = cifSwiftBO.returnBankById(criteria);

        }
        catch(Exception e)
        {
            handleException(e, "ERROR in CifSwift Dependency", null);
        }
        return SUCCESS;
    }

    /**
     * [EAOUN] triggered when user fill data in "Receiver BIC" under
     * "Receiver Correspondant Details"
     */
    public String dependencySwiftReceiverBIC()
    {
        try
        {
            SessionCO sessionCO = returnSessionObject();
            criteria.setCompCode(sessionCO.getCompanyCode());
            criteria.setClientIsBank("N");
            criteria.setRma("0");
            if(StringUtil.isNotEmpty(criteria.getBankCode()))
            {
                fomCifSwiftCO = cifSwiftBO.dependencySwiftReceiverBIC(criteria);
            }

        }
        catch(Exception ex)
        {
            handleException(ex, null, null);
        }
        return SUCCESS;
    }

    /**
     * used for the dependency management on BIC Code
     * 
     * @author: BoushraFahs
     * @date: 7 Oct 2013
     * @PB:
     * @return
     */
    public String dependencyByBankCifCode()
    {
        try
        {
            if(NumberUtil.isEmptyDecimal(criteria.getCifCode()))
            {
                throw new BOException(MessageCodes.BIC_CODE_SHOULD_BE_N_CHARACTERS, new String[] {criteria
                	.getBicCodeLimit().toString()});
            }
            else
            {
        	SessionCO sessionCO = returnSessionObject();
        	criteria.setCompCode(sessionCO.getCompanyCode());
        	criteria.setCifCode(code);
        	fomCifSwiftCO = cifSwiftBO.returnBicCodeById(criteria);
        	if(fomCifSwiftCO == null)
        	{
        	    throw new BOException(MessageCodes.BIC_CODE_SHOULD_BE_N_CHARACTERS, new String[] {criteria
        		    .getBicCodeLimit().toString()});
        	}
            }
        }
        catch(Exception e)
        {
            handleException(e, "ERROR in CifSwift Dependency", null);
        }
        return SUCCESS;
    }

    public S_PMSCIFSWIFTVO getCifSwiftVO()
    {
        return cifSwiftVO;
    }

    public void setCifSwiftVO(S_PMSCIFSWIFTVO cifSwiftVO)
    {
        this.cifSwiftVO = cifSwiftVO;
    }

    public BigDecimal getCode()
    {
        return code;
    }

    public void setCode(BigDecimal code)
    {
        this.code = code;
    }

    public void setCifSwiftBO(CifSwiftBO cifSwiftBO)
    {
        this.cifSwiftBO = cifSwiftBO;
    }

    public CifSwiftSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(CifSwiftSC criteria)
    {
        this.criteria = criteria;
    }

    public FomCifSwiftCO getFomCifSwiftCO()
    {
        return fomCifSwiftCO;
    }

    public void setFomCifSwiftCO(FomCifSwiftCO fomCifSwiftCO)
    {
        this.fomCifSwiftCO = fomCifSwiftCO;
    }

}
