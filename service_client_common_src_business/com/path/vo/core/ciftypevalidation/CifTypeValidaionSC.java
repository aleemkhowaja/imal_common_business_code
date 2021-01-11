package com.path.vo.core.ciftypevalidation;

import java.math.BigDecimal;

import com.path.dbmaps.vo.CIFVO;
import com.path.struts2.lib.common.BaseSC;

public class CifTypeValidaionSC extends BaseSC
{
    private CIFVO cifVO=new CIFVO();
    private BigDecimal typeCode;
 
    private String vtInd="";
    private String inwardOutwardClrChq="";
    private String allowChangeIdType="";
   
   

public BigDecimal getTypeCode()
{
    return typeCode;
}
public void setTypeCode(BigDecimal typeCode)
{
    this.typeCode = typeCode;
}
public String getVtInd()
{
    return vtInd;
}
public void setVtInd(String vtInd)
{
    this.vtInd = vtInd;
}
public String getInwardOutwardClrChq()
{
    return inwardOutwardClrChq;
}
public void setInwardOutwardClrChq(String inwardOutwardClrChq)
{
    this.inwardOutwardClrChq = inwardOutwardClrChq;
}
public String getAllowChangeIdType()
{
    return allowChangeIdType;
}
public void setAllowChangeIdType(String allowChangeIdType)
{
    this.allowChangeIdType = allowChangeIdType;
}

public CIFVO getCifVO()
{
    return cifVO;
}
public void setCifVO(CIFVO cifVO)
{
    this.cifVO = cifVO;
}
}
