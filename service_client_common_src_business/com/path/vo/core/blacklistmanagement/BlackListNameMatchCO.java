package com.path.vo.core.blacklistmanagement;

import com.path.dbmaps.vo.CTS_BLCKLIST_NAME_MATCHVO;
import com.path.dbmaps.vo.CTS_BLCKLIST_REASON_LOGVOKey;
import com.path.vo.core.common.RetailBaseVO;

public class BlackListNameMatchCO extends RetailBaseVO
{

    private CTS_BLCKLIST_NAME_MATCHVO ctsBlckListNameMatchVO = new CTS_BLCKLIST_NAME_MATCHVO();

    public CTS_BLCKLIST_NAME_MATCHVO getCtsBlckListNameMatchVO()
    {
        return ctsBlckListNameMatchVO;
    }

    public void setCtsBlckListNameMatchVO(CTS_BLCKLIST_NAME_MATCHVO ctsBlckListNameMatchVO)
    {
        this.ctsBlckListNameMatchVO = ctsBlckListNameMatchVO;
    }

    
    
}
