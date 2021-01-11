/**
 * 
 */
package com.path.bo.core.ctstrsowing.impl;

import java.util.List;

import com.path.bo.core.ctstrsowing.CtstrsOwingBO;
import com.path.dao.core.ctstrsowing.CtstrsOwingDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.ctstrsowing.CtstrsOwingSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * CtstrsOwingBOImpl.java used to
 */
public class CtstrsOwingBOImpl extends BaseBO implements CtstrsOwingBO
{
    private CtstrsOwingDAO ctstrsOwingDAO;
    /**
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int ctstrsOwingListCount(CtstrsOwingSC criteria) throws BaseException
    {
	return ctstrsOwingDAO.ctstrsOwingListCount(criteria);
    }
    
    /**
     * return a list contains all accounts based on the criteria...
     * this function call the dynamic query for Account 
     * Pbd :w_lookup_amf_dyn
     * @param criteria
     * @return list
     * @throws BaseException
     */
    public List ctstrsOwingList(CtstrsOwingSC criteria) throws BaseException
    {
	return ctstrsOwingDAO.ctstrsOwingList(criteria);
    }

    /**
     * @return the ctstrsOwingDAO
     */
    public CtstrsOwingDAO getCtstrsOwingDAO()
    {
        return ctstrsOwingDAO;
    }

    /**
     * @param ctstrsOwingDAO the ctstrsOwingDAO to set
     */
    public void setCtstrsOwingDAO(CtstrsOwingDAO ctstrsOwingDAO)
    {
        this.ctstrsOwingDAO = ctstrsOwingDAO;
    }

}
