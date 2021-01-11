/**
 * 
 */
package com.path.dao.core.amfstatus;

import java.util.List;

import com.path.dbmaps.vo.AMF_SUSPEND_REASONVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.amfstatus.AmfStatusSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * AmfStatusReasonDAO.java used to
 */
public interface AmfStatusReasonDAO
{
    public int amfStatusReasonListCount(AmfStatusSC amfStatusSC) throws DAOException;

    public List<AMF_SUSPEND_REASONVO> amfStatusReasonList(AmfStatusSC amfStatusSC) throws DAOException;
    
    public AMF_SUSPEND_REASONVO returnDependencyByCode(AmfStatusSC amfStatusSC) throws DAOException;
}
