package com.path.vo.core.trxmgnt;

import java.util.List;

import com.path.vo.core.common.RetailBaseVO;

public class TrxSOChargesCO  extends RetailBaseVO
{
    private List<TrxMgntSOChargesCO> 	trxMgntSOChargesCOs;
    private boolean 			isEmptied;
    private String			chargeType;		//To set Charge Type
    
    
    
    public List<TrxMgntSOChargesCO> getTrxMgntSOChargesCOs()
    {
        return trxMgntSOChargesCOs;
    }

    public void setTrxMgntSOChargesCOs(List<TrxMgntSOChargesCO> trxMgntSOChargesCOs)
    {
        this.trxMgntSOChargesCOs = trxMgntSOChargesCOs;
    }

    public boolean isEmptied()
    {
        return isEmptied;
    }

    public void setEmptied(boolean isEmptied)
    {
        this.isEmptied = isEmptied;
    }

    public String getChargeType()
    {
        return chargeType;
    }

    public void setChargeType(String chargeType)
    {
        this.chargeType = chargeType;
    }
}
