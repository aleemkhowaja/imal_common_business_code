/**
 * @Auther:WissamAbouJaoude
 * @Date:Mar 27, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.bo.core.credittype;

import java.util.List;

import com.path.dbmaps.vo.CTSCREDIT_TYPEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.credittype.CreditTypeSC;

public interface CreditTypeBO 
{
    public int creditTypeListCount(CreditTypeSC criteria)throws BaseException;
    public List creditTypeList(CreditTypeSC criteria)throws BaseException;
    public CTSCREDIT_TYPEVO returnCreditTypeById(CreditTypeSC criteria)throws BaseException;
}