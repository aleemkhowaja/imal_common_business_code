/**
 * 
 */
package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2014, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Reda Charabaty
 * 
 *          FOMOneObligorSC.java used to
 */
public class FOMOneObligorSC extends GridParamsSC
{
    private BigDecimal cifNo;
    private String langCode;

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public String getLangCode()
    {
        return langCode;
    }

    public void setLangCode(String langCode)
    {
        this.langCode = langCode;
    }

    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }

}
