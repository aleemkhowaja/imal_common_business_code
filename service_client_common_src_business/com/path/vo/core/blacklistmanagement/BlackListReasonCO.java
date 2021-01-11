package com.path.vo.core.blacklistmanagement;

import com.path.dbmaps.vo.CTS_BLCKLIST_REASON_LOGVOKey;
import com.path.vo.core.common.RetailBaseVO;

public class BlackListReasonCO extends RetailBaseVO
{

    private CTS_BLCKLIST_REASON_LOGVOKey ctsBlckListReasonLogVO = new CTS_BLCKLIST_REASON_LOGVOKey();

    public CTS_BLCKLIST_REASON_LOGVOKey getCtsBlckListReasonLogVO()
    {
        return ctsBlckListReasonLogVO;
    }

    public void setCtsBlckListReasonLogVO(CTS_BLCKLIST_REASON_LOGVOKey ctsBlckListReasonLogVO)
    {
        this.ctsBlckListReasonLogVO = ctsBlckListReasonLogVO;
    }
    
    
    
}
