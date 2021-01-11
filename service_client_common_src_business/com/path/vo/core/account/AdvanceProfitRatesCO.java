package com.path.vo.core.account;

import com.path.dbmaps.vo.AMF_ADVANCE_PROFIT_PAY_RATEVO;
import com.path.vo.core.common.RetailBaseVO;

public class AdvanceProfitRatesCO extends RetailBaseVO
{
    AMF_ADVANCE_PROFIT_PAY_RATEVO amfAdvanceProfitPayRateVO = new AMF_ADVANCE_PROFIT_PAY_RATEVO();

    public AMF_ADVANCE_PROFIT_PAY_RATEVO getAmfAdvanceProfitPayRateVO()
    {
        return amfAdvanceProfitPayRateVO;
    }

    public void setAmfAdvanceProfitPayRateVO(AMF_ADVANCE_PROFIT_PAY_RATEVO amfAdvanceProfitPayRateVO)
    {
        this.amfAdvanceProfitPayRateVO = amfAdvanceProfitPayRateVO;
    }
}
