package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.itempropertydet.ItemPropertydetBO;
import com.path.dbmaps.vo.TRS_ITEM_PROPERTYDETVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.itempropertydet.ItemPropertydetSC;

/**
 * @Auther:Pappady
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
@SuppressWarnings("serial")
public class ItemPropertydetDependencyAction extends RetailBaseAction
{
    private ItemPropertydetSC criteria = new ItemPropertydetSC();
    private ItemPropertydetBO itemPropertydetBO;
    private TRS_ITEM_PROPERTYDETVO trsItemPropertydetVO;

    /**
     * dependencyByFromTraveler.
     * 
     * @return String
     */
    public String dependencyByItemPropertydet()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    if(criteria.getPropertyCode() != null && criteria.getLineNo() != null)
	    {
		trsItemPropertydetVO = itemPropertydetBO.returnItemPropertydetByCode(criteria);
	    }
	}

	catch(Exception e)
	{
	    trsItemPropertydetVO = new TRS_ITEM_PROPERTYDETVO();
	    log.error(e, "Error in TradeDealsDependencyAction method of dependencyByItemPropertydet");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public ItemPropertydetSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(ItemPropertydetSC criteria)
    {
	this.criteria = criteria;
    }

    public TRS_ITEM_PROPERTYDETVO getTrsItemPropertydetVO()
    {
	return trsItemPropertydetVO;
    }

    public void setTrsItemPropertydetVO(TRS_ITEM_PROPERTYDETVO trsItemPropertydetVO)
    {
	this.trsItemPropertydetVO = trsItemPropertydetVO;
    }

    public void setItemPropertydetBO(ItemPropertydetBO itemPropertydetBO)
    {
	this.itemPropertydetBO = itemPropertydetBO;
    }

}
