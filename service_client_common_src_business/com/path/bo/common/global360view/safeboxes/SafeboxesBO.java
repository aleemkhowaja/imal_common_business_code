/**
 * 
 */
package com.path.bo.common.global360view.safeboxes;

import java.util.List;

import com.path.vo.common.global360view.SafeboxesCO;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * SafeboxesBO.java used to
 */
public interface SafeboxesBO
{
    public int safeboxesListCount(DashboardSC criteria) throws BaseException;
    public List<SafeboxesCO> safeboxesList(DashboardSC criteria) throws BaseException;
}
