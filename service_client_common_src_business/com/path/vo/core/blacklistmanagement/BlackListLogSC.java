package com.path.vo.core.blacklistmanagement;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class BlackListLogSC extends GridParamsSC
{
    
    private String ivCrud;
    private BigDecimal blckListLogLineNo;
    
    
    public String getIvCrud()
    {
        return ivCrud;
    }
    public void setIvCrud(String ivCrud)
    {
        this.ivCrud = ivCrud;
    }
    
    public BigDecimal getBlckListLogLineNo()
    {
        return blckListLogLineNo;
    }
    public void setBlckListLogLineNo(BigDecimal blckListLogLineNo)
    {
        this.blckListLogLineNo = blckListLogLineNo;
    }

    
    

}
