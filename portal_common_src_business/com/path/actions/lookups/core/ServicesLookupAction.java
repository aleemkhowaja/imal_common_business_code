package com.path.actions.lookups.core;

import java.math.BigDecimal;

import com.path.bo.core.services.ServicesBO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.services.ServicesSC;

public class ServicesLookupAction extends LookupBaseAction
{

    private ServicesBO servicesBO;
    private ServicesSC servicesSC = new ServicesSC();
    
    @Override
    public Object getModel()
    {
	return servicesSC;
    }
    
    public String constructTerminalIDLookup()
    {

	try
	{
	    String[] name = {"SERVICE_CODE", "ATM_T_ID", "SERVICE_DESC", "TRX_BR_CODE", "TELLER_ID","SERVICE_TYPE","MSG_SOURCE"};
	    String[] colType = {"number", "text", "text", "number", "number", "number", "text"};
	    String[] titles = {getText("service_code_key"), getText("atm_t_id_key"), getText("Service_Desc_key"), getText("trx_br_code_key"), getText("teller_iD_key"), getText("service_type_key"), getText("msg_source_key")};
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "SERVICE_CODE", "ATM_T_ID", "SERVICE_DESC", "TRX_BR_CODE", "TELLER_ID","SERVICE_TYPE","MSG_SOURCE" };
		colType = new String[] {"number", "text", "text", "number", "number", "number", "text"};
		titles = new String[] {getText("service_code_key"), getText("atm_t_id_key"), getText("Service_Desc_key"), getText("trx_br_code_key"), getText("teller_iD_key"), getText("service_type_key"), getText("msg_source_key")};
	    }
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("terminal_Id_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/servicesLookup_fillTerminalIDLookup");	   
	    lookup(grid, servicesSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in ServicesLookupAction of constructTerminalIDLookup");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String fillTerminalIDLookup()
    {
	try
	{	   
	    setSearchFilter(servicesSC);
	    copyproperties(servicesSC);
	    SessionCO sessionCO = returnSessionObject();
	    servicesSC.setCompCode(sessionCO.getCompanyCode());
	    servicesSC.setServiceType(BigDecimal.valueOf(2));

	    if(checkNbRec(servicesSC))
	    {
		setRecords(servicesBO.returnTerminalIdListCount(servicesSC));
	    }
	    setGridModel(servicesBO.returnTerminalIdList(servicesSC));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

   
    public void setServicesBO(ServicesBO servicesBO)
    {
        this.servicesBO = servicesBO;
    }

    public ServicesSC getServicesSC()
    {
        return servicesSC;
    }

    public void setServicesSC(ServicesSC servicesSC)
    {
        this.servicesSC = servicesSC;
    }
    
    
    
}
