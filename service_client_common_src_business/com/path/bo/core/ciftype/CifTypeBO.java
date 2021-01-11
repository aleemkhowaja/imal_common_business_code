package com.path.bo.core.ciftype;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.RIFCTTVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.ciftype.CifTypeSC;

public interface CifTypeBO
{
    public int cifTypeListCount(CifTypeSC criteria) throws BaseException;

    public List cifTypeList(CifTypeSC criteria) throws BaseException;

    public RIFCTTVO returnCifTypeById(CifTypeSC criteria) throws BaseException;
    
    public BigDecimal returnIdTypes(CifTypeSC criteria) throws BaseException;
    
    public String returnCifGender(CifTypeSC criteria) throws BaseException;

}
