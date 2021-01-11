package com.path.vo.common.suspicious;

import java.math.BigDecimal;

import com.path.struts2.lib.common.BaseSC;

public class SuspiciousCO  extends BaseSC{
    
     private BigDecimal cifNO;
     private String shortNameEng;
     private String longNameEng;
     private String shortNameArab;
     private String longNameArab;
     
    public BigDecimal getCifNO()
    {
        return cifNO;
    }
    public void setCifNO(BigDecimal cifNO)
    {
        this.cifNO = cifNO;
    }
    public String getShortNameEng()
    {
        return shortNameEng;
    }
    public void setShortNameEng(String shortNameEng)
    {
        this.shortNameEng = shortNameEng;
    }
    public String getLongNameEng()
    {
        return longNameEng;
    }
    public void setLongNameEng(String longNameEng)
    {
        this.longNameEng = longNameEng;
    }
    public String getShortNameArab()
    {
        return shortNameArab;
    }
    public void setShortNameArab(String shortNameArab)
    {
        this.shortNameArab = shortNameArab;
    }
    public String getLongNameArab()
    {
        return longNameArab;
    }
    public void setLongNameArab(String longNameArab)
    {
        this.longNameArab = longNameArab;
    }
     
   
     
}
