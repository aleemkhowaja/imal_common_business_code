/**
 * 
 */
package com.path.bo.core.fmsdrawdowns;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.dao.core.fmsdrawdowns.FmsDrawdownsDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.facilitytype.FacilityTypeSC;
import com.path.vo.core.fmsdrowdowns.FMSDrawdownCO;
import com.path.vo.core.fmsdrowdowns.FMSDrawdownSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: raees
 * 
 *          FmsDrawdownsBOImpl.java used to
 */
public class FmsDrawdownsBOImpl extends BaseBO implements FmsDrawdownsBO
{

    FmsDrawdownsDAO fmsDrawdownsDAO;

    public List fmsDrawDownsList(FacilityTypeSC facilityTypeSC) throws BaseException
    {
	return fmsDrawdownsDAO.fmsDrawDownsList(facilityTypeSC);
    }

    public int fmsDrawDownsListCount(FacilityTypeSC facilityTypeSC) throws BaseException
    {
	return fmsDrawdownsDAO.fmsDrawDownsListCount(facilityTypeSC);
    }

    public List fmsDrawDownsListFMS(FacilityTypeSC facilityTypeSC) throws BaseException
    {
	return fmsDrawdownsDAO.fmsDrawDownsListFMS(facilityTypeSC);
    }

    public int fmsDrawDownsListCountFMS(FacilityTypeSC facilityTypeSC) throws BaseException
    {
	return fmsDrawdownsDAO.fmsDrawDownsListCountFMS(facilityTypeSC);
    }

    /**
     * @return the fmsDrawdownsDAO
     */
    public FmsDrawdownsDAO getFmsDrawdownsDAO()
    {
	return fmsDrawdownsDAO;
    }

    /**
     * @param fmsDrawdownsDAO the fmsDrawdownsDAO to set
     */
    public void setFmsDrawdownsDAO(FmsDrawdownsDAO fmsDrawdownsDAO)
    {
	this.fmsDrawdownsDAO = fmsDrawdownsDAO;
    }

    public FMSDrawdownCO returnDependencyByCode(FacilityTypeSC facilityTypeSC) throws BaseException
    {
	return fmsDrawdownsDAO.returnDependencyByCode(facilityTypeSC);
    }

    public int returnCountFMSDRWDWNByCodeAndStatus(FMSDrawdownSC fMSDrawdownSC) throws BaseException
    {
	return fmsDrawdownsDAO.returnCountFMSDRWDWNByCodeAndStatus(fMSDrawdownSC);
    }


    /**
     * @param FacilityTypeSC : compCode,branchCode,currencyCode,cifNo,code
     */
    public FMSDrawdownCO validateDrawdownCodeforAccounts(FacilityTypeSC facilityTypeSC) throws BaseException
    {
	FMSDrawdownCO fMSDrawdownCO = fmsDrawdownsDAO.validateDrawdownCodeforAccounts(facilityTypeSC);
	if(fMSDrawdownCO == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_DRAWDOWN_NUMBER);
	}
	return fMSDrawdownCO;
    }
    

    /**
     * TfaFmsDrawDowns Lookup count
     * 
     * @author: BoushraFahs
     * @date: 27 Feb 2014
     * @PB: w_lookup_draw_down (tfa06.pbl)/ dw_lookup_draw_down
     *      (ora_syb.pbl,syb_tfa.pbl)
     */
    public int returnTfaDrwDwnCount(FacilityTypeSC facilityTypeSC) throws BaseException
    {
	return fmsDrawdownsDAO.returnTfaDrwDwnCount(facilityTypeSC);
    }

    /**
     * TfaFmsDrawDowns Lookup list
     * 
     * @author: BoushraFahs
     * @date: 27 Feb 2014
     * @PB: w_lookup_draw_down (tfa06.pbl)/ dw_lookup_draw_down
     *      (ora_syb.pbl,syb_tfa.pbl)
     */
    public List<FMSDrawdownCO> returnTfaDrwDwnList(FacilityTypeSC facilityTypeSC) throws BaseException
    {
	return fmsDrawdownsDAO.returnTfaDrwDwnList(facilityTypeSC);
    }

    public int returnDrwDwnAccountCount(FacilityTypeSC facilityTypeSC) throws BaseException
    {
	return fmsDrawdownsDAO.returnDrwDwnAccountCount(facilityTypeSC);
    }
    
    public List<FMSDrawdownCO> returnDrwDwnAccountList(FacilityTypeSC facilityTypeSC) throws BaseException
    {
	return fmsDrawdownsDAO.returnDrwDwnAccountList(facilityTypeSC);
    }
    
    public int returnDrwDwnListCount(FacilityTypeSC facilityTypeSC) throws BaseException
    {
	return fmsDrawdownsDAO.returnDrwDwnListCount(facilityTypeSC);
    }
    
    public List<FMSDrawdownCO> returnDrwDwnList(FacilityTypeSC facilityTypeSC) throws BaseException
    {
	return fmsDrawdownsDAO.returnDrwDwnList(facilityTypeSC);
    }

    
    public List fmsDrawDownsListTemplateFMS(FacilityTypeSC facilityTypeSC) throws BaseException
    {
	return fmsDrawdownsDAO.fmsDrawDownsListTemplateFMS(facilityTypeSC);
    }

    public int fmsDrawDownsListCountTemplateFMS(FacilityTypeSC facilityTypeSC) throws BaseException
    {
	return fmsDrawdownsDAO.fmsDrawDownsListCountTemplateFMS(facilityTypeSC);
    }
    
}
