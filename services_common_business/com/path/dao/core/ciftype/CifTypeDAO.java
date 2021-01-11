package com.path.dao.core.ciftype;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.RIFCTTVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.ciftype.CifTypeSC;
import com.path.vo.core.csmfom.FomSC;

public interface CifTypeDAO
{

    public int cifTypeListCount(CifTypeSC criteria) throws DAOException;

    public List cifTypeList(CifTypeSC criteria) throws DAOException;

    public RIFCTTVO returnCifTypeById(CifTypeSC criteria) throws DAOException;

    public RIFCTTVO returnCifAgeDet(CifTypeSC criteria) throws DAOException;

    public BigDecimal returnExpiryDays(CifTypeSC criteria) throws DAOException;
    
    public String returnCifGender(CifTypeSC criteria) throws DAOException;
    
    public void deleteKycYmcRelatedData(FomSC fomSC) throws DAOException;

}
