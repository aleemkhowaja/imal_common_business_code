package com.path.vo.common.dynamictemplate;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * DynamicTemplateSC.java used to
 */
public class DynamicTemplateSC extends GridParamsSC
{
    public DynamicTemplateSC()
    {
		super.setSearchCols(new String[]{"DYN_TEMP_ID", "PARENT_ID", "APP_NAME", "APP_DESC","CONVENTION_NUMBER","ENTITY_DESC","STATUS_DESC"});
    }
    private String menuRef;
    private BigDecimal dyntempId;
    private String nodeId;
    private String parentNodeId;
    private BigDecimal lovTypeEntity;
    private BigDecimal lovLkOptType;
    private BigDecimal accBr;
    private BigDecimal accCy;
    private BigDecimal accGl;
    private BigDecimal accCif;
    private BigDecimal accSl;
    private BigDecimal cifNo;
    private BigDecimal segmentNo;
    private BigDecimal dtConvNo;
    private String convOldStatus;
    private String productType;
    private String entityType;
    private BigDecimal screenId;
    
    public String getMenuRef()
    {
        return menuRef;
    }
    public void setMenuRef(String menuRef)
    {
        this.menuRef = menuRef;
    }
    public BigDecimal getDyntempId()
    {
        return dyntempId;
    }
    public void setDyntempId(BigDecimal dyntempId)
    {
        this.dyntempId = dyntempId;
    }
    public String getNodeId()
    {
        return nodeId;
    }
    public void setNodeId(String nodeId)
    {
        this.nodeId = nodeId;
    }
    public String getParentNodeId()
    {
        return parentNodeId;
    }
    public void setParentNodeId(String parentNodeId)
    {
        this.parentNodeId = parentNodeId;
    }
    public BigDecimal getLovTypeEntity()
    {
        return lovTypeEntity;
    }
    public void setLovTypeEntity(BigDecimal lovTypeEntity)
    {
        this.lovTypeEntity = lovTypeEntity;
    }
    public BigDecimal getLovLkOptType()
    {
        return lovLkOptType;
    }
    public void setLovLkOptType(BigDecimal lovLkOptType)
    {
        this.lovLkOptType = lovLkOptType;
    }
    public BigDecimal getAccBr()
    {
        return accBr;
    }
    public void setAccBr(BigDecimal accBr)
    {
        this.accBr = accBr;
    }
    public BigDecimal getAccCy()
    {
        return accCy;
    }
    public void setAccCy(BigDecimal accCy)
    {
        this.accCy = accCy;
    }
    public BigDecimal getAccGl()
    {
        return accGl;
    }
    public void setAccGl(BigDecimal accGl)
    {
        this.accGl = accGl;
    }
    public BigDecimal getAccCif()
    {
        return accCif;
    }
    public void setAccCif(BigDecimal accCif)
    {
        this.accCif = accCif;
    }
    public BigDecimal getAccSl()
    {
        return accSl;
    }
    public void setAccSl(BigDecimal accSl)
    {
        this.accSl = accSl;
    }
    public BigDecimal getCifNo()
    {
        return cifNo;
    }
    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }
    public BigDecimal getSegmentNo()
    {
        return segmentNo;
    }
    public void setSegmentNo(BigDecimal segmentNo)
    {
        this.segmentNo = segmentNo;
    }
    public BigDecimal getDtConvNo()
    {
        return dtConvNo;
    }
    public void setDtConvNo(BigDecimal dtConvNo)
    {
        this.dtConvNo = dtConvNo;
    }
    public String getConvOldStatus()
    {
        return convOldStatus;
    }
    public void setConvOldStatus(String convOldStatus)
    {
        this.convOldStatus = convOldStatus;
    }
    public String getProductType()
    {
        return productType;
    }
    public void setProductType(String productType)
    {
        this.productType = productType;
    }
    public String getEntityType()
    {
        return entityType;
    }
    public void setEntityType(String entityType)
    {
        this.entityType = entityType;
    }
    public BigDecimal getScreenId()
    {
        return screenId;
    }
    public void setScreenId(BigDecimal screenId)
    {
        this.screenId = screenId;
    }
    
}
