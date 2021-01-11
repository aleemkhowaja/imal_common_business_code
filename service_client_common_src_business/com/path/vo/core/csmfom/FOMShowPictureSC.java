/**
 * 
 */
package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.BaseSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * FOMShowPictureSC.java used to
 */
public class FOMShowPictureSC extends BaseSC
{
    private BigDecimal idNo;
    private byte[] blobImage;
    /**
     * @return the idNo
     */
    public BigDecimal getIdNo()
    {
        return idNo;
    }
    /**
     * @param idNo the idNo to set
     */
    public void setIdNo(BigDecimal idNo)
    {
        this.idNo = idNo;
    }
    /**
     * @return the blobImage
     */
    public byte[] getBlobImage()
    {
        return blobImage;
    }
    /**
     * @param blobImage the blobImage to set
     */
    public void setBlobImage(byte[] blobImage)
    {
        this.blobImage = blobImage;
    }
}
