package com.path.bo.core.idtype;

import java.util.List;

import com.path.dbmaps.vo.ID_TYPESVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.csmfom.FomCO;
import com.path.vo.core.idtype.IdTypeSC;

public interface IdTypeBO
{

    public int idTypeListCount(IdTypeSC idTypeSC) throws BaseException;

    public List idTypeList(IdTypeSC idTypeSC) throws BaseException;
    
    public FomCO returnIdTypeById(IdTypeSC idTypeSC) throws BaseException;
    
    public int idTypeByCIFTypeListCount(IdTypeSC idTypeSC) throws BaseException;

    public List idTypeByCIFTypeList(IdTypeSC idTypeSC) throws BaseException;

    public ID_TYPESVO dependencyByIdNo(IdTypeSC criteria) throws BaseException;
    
    public void validateIdsIdNo(IdTypeSC criteria) throws BaseException;

    public FomCO checkDuplicateIdNo(FomCO fomCO)throws BaseException;
    
    public ID_TYPESVO returnIdTypeByIdDetails(IdTypeSC criteria) throws BaseException;
    
}
