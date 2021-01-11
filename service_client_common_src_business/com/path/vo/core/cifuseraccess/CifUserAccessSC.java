package com.path.vo.core.cifuseraccess;

import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTELLER_AXSVO;
import com.path.struts2.lib.common.BaseSC;

public class CifUserAccessSC extends BaseSC
{

    private CTSTELLER_AXSVO ctsTellerAxsVO=new CTSTELLER_AXSVO();
    private CTSTELLERVO ctsTellerVO=new CTSTELLERVO();
    private String allowToModifyCif;
    private String appName;

    public CTSTELLER_AXSVO getCtsTellerAxsVO()
    {
        return ctsTellerAxsVO;
    }

    public void setCtsTellerAxsVO(CTSTELLER_AXSVO ctsTellerAxsVO)
    {
        this.ctsTellerAxsVO = ctsTellerAxsVO;
    }

    public CTSTELLERVO getCtsTellerVO()
    {
        return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
        this.ctsTellerVO = ctsTellerVO;
    }

    public String getAllowToModifyCif()
    {
        return allowToModifyCif;
    }

    public void setAllowToModifyCif(String allowToModifyCif)
    {
        this.allowToModifyCif = allowToModifyCif;
    }

    public String getAppName()
    {
        return appName;
    }

    public void setAppName(String appName)
    {
        this.appName = appName;
    }

   
}
