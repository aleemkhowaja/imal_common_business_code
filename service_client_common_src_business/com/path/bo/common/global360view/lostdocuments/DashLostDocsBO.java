/**
 * 
 */
package com.path.bo.common.global360view.lostdocuments;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.global360view.DashboardSC;
import com.path.vo.common.global360view.LostDocumentsCO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DashLostDocsBO.java used to
 */
public interface DashLostDocsBO
{
    public int lostDocsListCount(DashboardSC criteria) throws BaseException;
    public List<LostDocumentsCO> lostDocsList(DashboardSC criteria) throws BaseException;
}
