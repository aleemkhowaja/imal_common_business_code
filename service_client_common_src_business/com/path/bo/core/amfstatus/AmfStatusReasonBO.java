/**
 * 
 */
package com.path.bo.core.amfstatus;

import java.util.List;

import com.path.dbmaps.vo.AMF_SUSPEND_REASONVO;
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
public interface AmfStatusReasonBO
{
    public int amfStatusReasonListCount(AmfStatusSC amfStatusSC) throws BaseException;

    public List<AMF_SUSPEND_REASONVO> amfStatusReasonList(AmfStatusSC amfStatusSC) throws BaseException;
    
    public AMF_SUSPEND_REASONVO returnDependencyByCode(AmfStatusSC amfStatusSC) throws BaseException;
}
