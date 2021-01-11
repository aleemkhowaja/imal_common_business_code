package com.path.vo.core.teller;

import com.path.dbmaps.vo.CTSTELLERDETVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.lib.vo.BaseVO;

 /**
   TP # 412662 -- Customer RelationShip Management  -- [Joyce Kanazeh]
 */

public class TellerCO extends BaseVO
{
    private CTSTELLERDETVO ctsTellerDetVO = new CTSTELLERDETVO();
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();

    private String representiveDesc;

    public CTSTELLERDETVO getCtsTellerDetVO()
    {
	return ctsTellerDetVO;
    }

    public void setCtsTellerDetVO(CTSTELLERDETVO ctsTellerDetVO)
    {
	this.ctsTellerDetVO = ctsTellerDetVO;
    }

    public String getRepresentiveDesc()
    {
	return representiveDesc;
    }

    public void setRepresentiveDesc(String representiveDesc)
    {
	this.representiveDesc = representiveDesc;
    }

    public CTSTELLERVO getCtsTellerVO()
    {
	return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
	this.ctsTellerVO = ctsTellerVO;
    }

}
