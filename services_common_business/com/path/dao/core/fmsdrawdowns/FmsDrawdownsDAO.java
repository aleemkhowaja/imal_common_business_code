/**
 *
 */
package com.path.dao.core.fmsdrawdowns;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.facilitytype.FacilityTypeSC;
import com.path.vo.core.fmsdrowdowns.FMSDrawdownCO;
import com.path.vo.core.fmsdrowdowns.FMSDrawdownSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code
 *
 * @author: raees
 *
 * FmsDrawdownsDAO.java used to
 */
public interface FmsDrawdownsDAO
{
    public int fmsDrawDownsListCount(FacilityTypeSC facilityTypeSC) throws DAOException;

    public List fmsDrawDownsList(FacilityTypeSC facilityTypeSC) throws DAOException;

    public int fmsDrawDownsListCountFMS(FacilityTypeSC facilityTypeSC) throws DAOException;

    public List fmsDrawDownsListFMS(FacilityTypeSC facilityTypeSC) throws DAOException;

    public FMSDrawdownCO returnDependencyByCode(FacilityTypeSC facilityTypeSC)throws DAOException;

    public int returnCountFMSDRWDWNByCodeAndStatus(FMSDrawdownSC fMSDrawdownSC)throws DAOException;

    public FMSDrawdownCO validateDrawdownCodeforAccounts(FacilityTypeSC facilityTypeSC) throws DAOException;

    /**
     * TfaFmsDrawDowns Lookup count
     *
     * @author: BoushraFahs
     * @date: 27 Feb 2014
     * @PB: w_lookup_draw_down (tfa06.pbl)/ dw_lookup_draw_down (ora_syb.pbl,syb_tfa.pbl)
     */
    int returnTfaDrwDwnCount(FacilityTypeSC facilityTypeSC) throws DAOException;

    /**
     * TfaFmsDrawDowns Lookup list
     *
     * @author: BoushraFahs
     * @date: 27 Feb 2014
     * @PB: w_lookup_draw_down (tfa06.pbl)/ dw_lookup_draw_down (ora_syb.pbl,syb_tfa.pbl)
     */
    List<FMSDrawdownCO> returnTfaDrwDwnList(FacilityTypeSC facilityTypeSC) throws DAOException;
    
    int returnDrwDwnAccountCount(FacilityTypeSC facilityTypeSC) throws DAOException;
    List<FMSDrawdownCO> returnDrwDwnAccountList(FacilityTypeSC facilityTypeSC) throws DAOException;
    
    int returnDrwDwnListCount(FacilityTypeSC facilityTypeSC) throws DAOException;
    List<FMSDrawdownCO> returnDrwDwnList(FacilityTypeSC facilityTypeSC) throws DAOException;

    public int fmsDrawDownsListCountTemplateFMS(FacilityTypeSC facilityTypeSC) throws DAOException;

    public List fmsDrawDownsListTemplateFMS(FacilityTypeSC facilityTypeSC) throws DAOException;

    
}
