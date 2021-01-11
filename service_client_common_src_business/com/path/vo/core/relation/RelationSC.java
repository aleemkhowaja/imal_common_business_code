package com.path.vo.core.relation;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class RelationSC extends GridParamsSC
{
    private BigDecimal relationCode;
    private String addReference;

    public BigDecimal getRelationCode()
    {
	return relationCode;
    }

    public void setRelationCode(BigDecimal relationCode)
    {
	this.relationCode = relationCode;
    }

    public String getAddReference()
    {
        return addReference;
    }

    public void setAddReference(String addReference)
    {
        this.addReference = addReference;
    }

   
    
    
}
