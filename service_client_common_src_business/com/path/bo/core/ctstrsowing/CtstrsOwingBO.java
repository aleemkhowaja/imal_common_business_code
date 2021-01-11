/**
 * 
 */
package com.path.bo.core.ctstrsowing;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.core.ctstrsowing.CtstrsOwingSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * CtstrsOwingBO.java used to
 */
public interface CtstrsOwingBO
{
    public int ctstrsOwingListCount(CtstrsOwingSC criteria) throws BaseException;
    public List ctstrsOwingList(CtstrsOwingSC criteria) throws BaseException;

}
