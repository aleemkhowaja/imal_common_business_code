/**
 * 
 */
package com.path.bo.core.fmsdrawdowns;

import java.util.List;

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
 *          FmsDrawdownsBO.java used to
 */
public interface FmsDrawdownsBO
{
    public int fmsDrawDownsListCount(FacilityTypeSC facilityTypeSC) throws BaseException;

    public List fmsDrawDownsList(FacilityTypeSC facilityTypeSC) throws BaseException;

    public int fmsDrawDownsListCountFMS(FacilityTypeSC facilityTypeSC) throws BaseException;

    public List fmsDrawDownsListFMS(FacilityTypeSC facilityTypeSC) throws BaseException;

    public FMSDrawdownCO returnDependencyByCode(FacilityTypeSC facilityTypeSC) throws BaseException;

    public int returnCountFMSDRWDWNByCodeAndStatus(FMSDrawdownSC fMSDrawdownSC) throws BaseException;

    public FMSDrawdownCO validateDrawdownCodeforAccounts(FacilityTypeSC facilityTypeSC) throws BaseException;

    /**
     * TfaFmsDrawDowns Lookup count
     * 
     * @author: BoushraFahs
     * @date: 27 Feb 2014
     * @PB: w_lookup_draw_down (tfa06.pbl)/ dw_lookup_draw_down
     *      (ora_syb.pbl,syb_tfa.pbl)
     */
    int returnTfaDrwDwnCount(FacilityTypeSC facilityTypeSC) throws BaseException;

    /**
     * TfaFmsDrawDowns Lookup list
     * 
     * @author: BoushraFahs
     * @date: 27 Feb 2014
     * @PB: w_lookup_draw_down (tfa06.pbl)/ dw_lookup_draw_down
     *      (ora_syb.pbl,syb_tfa.pbl)
     */
    List<FMSDrawdownCO> returnTfaDrwDwnList(FacilityTypeSC facilityTypeSC) throws BaseException;

    int returnDrwDwnAccountCount(FacilityTypeSC facilityTypeSC) throws BaseException;

    List<FMSDrawdownCO> returnDrwDwnAccountList(FacilityTypeSC facilityTypeSC) throws BaseException;

    int returnDrwDwnListCount(FacilityTypeSC facilityTypeSC) throws BaseException;

    List<FMSDrawdownCO> returnDrwDwnList(FacilityTypeSC facilityTypeSC) throws BaseException;

    public int fmsDrawDownsListCountTemplateFMS(FacilityTypeSC facilityTypeSC) throws BaseException;

    public List fmsDrawDownsListTemplateFMS(FacilityTypeSC facilityTypeSC) throws BaseException;

}
