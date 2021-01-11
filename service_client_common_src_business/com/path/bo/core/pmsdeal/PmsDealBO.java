/**
 * 
 */
package com.path.bo.core.pmsdeal;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.core.pmsdeal.PmsDealCO;
import com.path.vo.core.pmsdeal.PmsDealSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: raees
 * 
 *          PmsDealBO.java used to
 */
public interface PmsDealBO
{
    public int pmsDealListCount(PmsDealSC criteria) throws BaseException;

    public List<PmsDealCO> pmsDealList(PmsDealSC criteria) throws BaseException;

    public PmsDealCO returnDependencyByDealNo(PmsDealSC criteria) throws BaseException;

    /**
     * 
     * @param criteria
     * @return
     * @throws BaseException return deal details
     */
    public PmsDealCO returnDealAndDealCyDetail(PmsDealSC criteria) throws BaseException;
}
