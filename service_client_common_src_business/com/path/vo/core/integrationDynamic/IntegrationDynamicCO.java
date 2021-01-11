package com.path.vo.core.integrationDynamic;

import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.CTS_INTEGRATIONVO;
import com.path.dbmaps.vo.CTS_INTEG_PARAMVO;
import com.path.vo.core.common.RetailBaseVO;

public class IntegrationDynamicCO extends RetailBaseVO
{
    private CTS_INTEGRATIONVO cts_integrationVO = new CTS_INTEGRATIONVO();
    private CTS_INTEG_PARAMVO cts_integ_paramVO = new CTS_INTEG_PARAMVO();
    private String statusDesc;
    List<String> listNames = new ArrayList<String>();
    List<String> listTitles = new ArrayList<String>();
    List<String> listColtype = new ArrayList<String>();
    
  
  
    public CTS_INTEGRATIONVO getCts_integrationVO()
    {
        return cts_integrationVO;
    }
    public void setCts_integrationVO(CTS_INTEGRATIONVO ctsIntegrationVO)
    {
        cts_integrationVO = ctsIntegrationVO;
    }
    public CTS_INTEG_PARAMVO getCts_integ_paramVO()
    {
        return cts_integ_paramVO;
    }
    public void setCts_integ_paramVO(CTS_INTEG_PARAMVO ctsIntegParamVO)
    {
        cts_integ_paramVO = ctsIntegParamVO;
    }
    public String getStatusDesc()
    {
        return statusDesc;
    }
    public void setStatusDesc(String statusDesc)
    {
        this.statusDesc = statusDesc;
    }
    public List<String> getListNames()
    {
        return listNames;
    }
    public void setListNames(List<String> listNames)
    {
        this.listNames = listNames;
    }
    public List<String> getListTitles()
    {
        return listTitles;
    }
    public void setListTitles(List<String> listTitles)
    {
        this.listTitles = listTitles;
    }
    public List<String> getListColtype()
    {
        return listColtype;
    }
    public void setListColtype(List<String> listColtype)
    {
        this.listColtype = listColtype;
    }
}
