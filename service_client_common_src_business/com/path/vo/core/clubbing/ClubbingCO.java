package com.path.vo.core.clubbing;

import com.path.dbmaps.vo.ACC_CLUBBING_GROUPVO;
import com.path.dbmaps.vo.CTS_CLUBBED_ACCVO;
import com.path.dbmaps.vo.CTS_CLUBVO;
import com.path.lib.vo.BaseVO;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * ClubbingCO.java used to
 */
public class ClubbingCO extends BaseVO
{
	
    CTS_CLUBVO ctsCLUBVO = new CTS_CLUBVO();
    CTS_CLUBBED_ACCVO ctsClubbedAccVO = new CTS_CLUBBED_ACCVO();
    ACC_CLUBBING_GROUPVO accClubGrpVO = new ACC_CLUBBING_GROUPVO();

    public CTS_CLUBVO getCtsCLUBVO()
    {
        return ctsCLUBVO;
    }

    public void setCtsCLUBVO(CTS_CLUBVO ctsCLUBVO)
    {
        this.ctsCLUBVO = ctsCLUBVO;
    }

    public CTS_CLUBBED_ACCVO getCtsClubbedAccVO()
    {
        return ctsClubbedAccVO;
    }

    public void setCtsClubbedAccVO(CTS_CLUBBED_ACCVO ctsClubbedAccVO)
    {
        this.ctsClubbedAccVO = ctsClubbedAccVO;
    }

    public ACC_CLUBBING_GROUPVO getAccClubGrpVO()
    {
        return accClubGrpVO;
    }

    public void setAccClubGrpVO(ACC_CLUBBING_GROUPVO accClubGrpVO)
    {
        this.accClubGrpVO = accClubGrpVO;
    } 
}
