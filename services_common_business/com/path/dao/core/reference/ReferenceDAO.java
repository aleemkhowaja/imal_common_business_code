package com.path.dao.core.reference;

import java.math.BigDecimal;
import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.reference.ReferenceCO;
import com.path.vo.core.reference.ReferenceSC;

public interface ReferenceDAO
{
    public int referenceListCount(ReferenceSC referenceSC) throws DAOException;
    public List referenceList(ReferenceSC referenceSC) throws DAOException;    
    public BigDecimal returnReference(ReferenceSC criteria) throws DAOException;
    
    public int referenceLGListCount(ReferenceSC referenceSC) throws DAOException;
    public List referenceLGList(ReferenceSC referenceSC) throws DAOException;    
    
    public int referenceBCListCount(ReferenceSC referenceSC) throws DAOException;
    public List referenceBCList(ReferenceSC referenceSC) throws DAOException;    
    
    public int referenceDealListCount(ReferenceSC referenceSC) throws DAOException;
    public List referenceDealList(ReferenceSC referenceSC) throws DAOException;   
    
    /**
     * FxDeal Lookup Count
     * 
     * @author: BoushraFahs
     * @date: 23 Jan 2014
     * @PB: w_lookup_fx_deal (tfa06)
     * @param referenceSC
     */
    int returnFxDealLkpCount(ReferenceSC referenceSC) throws DAOException;

    /**
     * FxDeal Lookup list
     * 
     * @author: BoushraFahs
     * @date: 23 Jan 2014
     * @PB: w_lookup_fx_deal (tfa06)
     * @param referenceSC
     */
    List<ReferenceCO> returnFxDealLkpList(ReferenceSC referenceSC) throws DAOException;

}
