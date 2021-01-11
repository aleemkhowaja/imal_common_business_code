package com.path.vo.core.addcompanion;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class AddCompanionDefSC extends GridParamsSC
{
    private String language;
    private BigDecimal fileCode;
    private BigDecimal lineno;
    private BigDecimal cifno;
    private BigDecimal BenefStatusLov;
    /**
     * @return the language
     */
    public String getLanguage()
    {
        return language;
    }
    /**
     * @param language the language to set
     */
    public void setLanguage(String language)
    {
        this.language = language;
    }
    /**
     * @return the fileCode
     */
    public BigDecimal getFileCode()
    {
        return fileCode;
    }
    /**
     * @param fileCode the fileCode to set
     */
    public void setFileCode(BigDecimal fileCode)
    {
        this.fileCode = fileCode;
    }
    /**
     * @return the line_no
     */
    public BigDecimal getLineno()
    {
        return lineno;
    }
    /**
     * @param lineNo the line_no to set
     */
    public void setLineno(BigDecimal lineNo)
    {
        lineno = lineNo;
    }
  
    public BigDecimal getCifno()
    {
        return cifno;
    }
    public void setCifno(BigDecimal cifno)
    {
        this.cifno = cifno;
    }
    public BigDecimal getBenefStatusLov()
    {
        return BenefStatusLov;
    }
    public void setBenefStatusLov(BigDecimal benefStatusLov)
    {
        BenefStatusLov = benefStatusLov;
    }
    
    
    
    
}
