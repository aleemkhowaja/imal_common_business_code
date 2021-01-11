/**
 * 
 */
package com.path.bo.core.amfstatus.impl;

import java.util.List;

import com.path.dao.core.amfstatus.AmfStatusReasonDAO;
import com.path.dbmaps.vo.AMF_SUSPEND_REASONVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.amfstatus.AmfStatusSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * AmfStatusReasonBO.java used to
 */
public class AmfStatusReasonBOImpl extends BaseBO implements com.path.bo.core.amfstatus.AmfStatusReasonBO
{
    
    private AmfStatusReasonDAO amfStatusReasonDAO;

    public List<AMF_SUSPEND_REASONVO> amfStatusReasonList(AmfStatusSC amfStatusSC) throws BaseException
    {
	return amfStatusReasonDAO.amfStatusReasonList(amfStatusSC);
    }


    public int amfStatusReasonListCount(AmfStatusSC amfStatusSC) throws BaseException
    {
	return amfStatusReasonDAO.amfStatusReasonListCount(amfStatusSC);
    }

    public AMF_SUSPEND_REASONVO returnDependencyByCode(AmfStatusSC amfStatusSC) throws BaseException
    {
	return amfStatusReasonDAO.returnDependencyByCode(amfStatusSC);
    }

    /**
     * @return the amfStatusReasonDAO
     */
    public AmfStatusReasonDAO getAmfStatusReasonDAO()
    {
        return amfStatusReasonDAO;
    }

    /**
     * @param amfStatusReasonDAO the amfStatusReasonDAO to set
     */
    public void setAmfStatusReasonDAO(AmfStatusReasonDAO amfStatusReasonDAO)
    {
        this.amfStatusReasonDAO = amfStatusReasonDAO;
    }

}
