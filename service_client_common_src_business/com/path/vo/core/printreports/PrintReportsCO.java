package com.path.vo.core.printreports;

import com.path.dbmaps.vo.CTSREPORTS_FILE_TYPEVO;
import com.path.dbmaps.vo.REP_INFOVO;
import com.path.vo.core.common.RetailBaseVO;

public class PrintReportsCO extends RetailBaseVO
{

   private CTSREPORTS_FILE_TYPEVO ctsRepFileTypeVO = new CTSREPORTS_FILE_TYPEVO();
    
   private REP_INFOVO repInfoVO = new REP_INFOVO();

    public CTSREPORTS_FILE_TYPEVO getCtsRepFileTypeVO()
    {
	return ctsRepFileTypeVO;
    }

    public void setCtsRepFileTypeVO(CTSREPORTS_FILE_TYPEVO ctsRepFileTypeVO)
    {
	this.ctsRepFileTypeVO = ctsRepFileTypeVO;
    }

    public REP_INFOVO getRepInfoVO()
    {
	return repInfoVO;
    }

    public void setRepInfoVO(REP_INFOVO repInfoVO)
    {
	this.repInfoVO = repInfoVO;
    }

    
}
