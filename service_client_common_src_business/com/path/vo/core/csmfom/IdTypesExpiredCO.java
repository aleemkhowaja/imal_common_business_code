package com.path.vo.core.csmfom;

import com.path.dbmaps.vo.ID_TYPESVO;
import com.path.dbmaps.vo.ID_TYPES_EXPIREDVO;
import com.path.vo.core.common.RetailBaseVO;

public class IdTypesExpiredCO extends RetailBaseVO
{
    private ID_TYPESVO idTypesVO = new ID_TYPESVO();
    private ID_TYPES_EXPIREDVO idTypesExpiredVO = new ID_TYPES_EXPIREDVO();
    private String     idTypeDesc;
    private String     ADDITIONAL_REFERENCE;
    private String     accName;

    public ID_TYPESVO getIdTypesVO()
    {
        return idTypesVO;
    }

    public void setIdTypesVO(ID_TYPESVO idTypesVO)
    {
        this.idTypesVO = idTypesVO;
    }

    public String getIdTypeDesc()
    {
        return idTypeDesc;
    }

    public void setIdTypeDesc(String idTypeDesc)
    {
        this.idTypeDesc = idTypeDesc;
    }

    public String getAccName()
    {
        return accName;
    }

    public void setAccName(String accName)
    {
        this.accName = accName;
    }

    public String getADDITIONAL_REFERENCE()
    {
	return ADDITIONAL_REFERENCE;
    }

    public void setADDITIONAL_REFERENCE(String aDDITIONAL_REFERENCE)
    {
	ADDITIONAL_REFERENCE = aDDITIONAL_REFERENCE;
    }

    public ID_TYPES_EXPIREDVO getIdTypesExpiredVO()
    {
        return idTypesExpiredVO;
    }

    public void setIdTypesExpiredVO(ID_TYPES_EXPIREDVO idTypesExpiredVO)
    {
        this.idTypesExpiredVO = idTypesExpiredVO;
    }
    
}
