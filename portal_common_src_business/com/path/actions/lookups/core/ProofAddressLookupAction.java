package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.proofaddress.ProofAddressBO;
import com.path.dbmaps.vo.CTS_PROOF_ADDRESSVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.proofaddress.ProofAddressSC;

public class ProofAddressLookupAction extends LookupBaseAction
{

    private ProofAddressBO proofAddressBO;
    private ProofAddressSC proofAddressSC = new ProofAddressSC();
    private BigDecimal PROF_ADDRESS_CODE;
    private CTS_PROOF_ADDRESSVO ctsProofAddressVO = new CTS_PROOF_ADDRESSVO();

    @Override
    public Object getModel()
    {
	return proofAddressSC;
    }

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "PROF_ADDRESS_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG" };
	    String[] colType = { "number", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Brief_Name_key"), getText("Long_Name_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Code_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/ProofAddressLookup_fillProofAddressLookup");
	    lookup(grid, proofAddressSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillProofAddressLookup()
    {
	try
	{
	    List<CTS_PROOF_ADDRESSVO> proofAddressVOList;
	    setSearchFilter(proofAddressSC);
	    copyproperties(proofAddressSC);
	    SessionCO sessionCO = returnSessionObject();
	    proofAddressSC.setCompCode(sessionCO.getCompanyCode());

	    if(checkNbRec(proofAddressSC))
	    {
		setRecords(proofAddressBO.proofAddressListCount(proofAddressSC));
	    }
	    proofAddressVOList = proofAddressBO.proofAddressList(proofAddressSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(proofAddressVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of ProofAddressLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String dependencyByProofAddressCode()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    proofAddressSC.setCompCode(sessionCO.getCompanyCode());
	    proofAddressSC.setCode(PROF_ADDRESS_CODE);
	    if(NumberUtil.isEmptyDecimal(PROF_ADDRESS_CODE))
	    {
	    	ctsProofAddressVO = new CTS_PROOF_ADDRESSVO();
	    }
	    else
	    {
	    	ctsProofAddressVO = proofAddressBO.returnProofAddressCodeById(proofAddressSC);
	    }
	   
	}
	catch(Exception e)
	{
		ctsProofAddressVO = new CTS_PROOF_ADDRESSVO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

	public ProofAddressSC getProofAddressSC() {
		return proofAddressSC;
	}

	public void setProofAddressSC(ProofAddressSC proofAddressSC) {
		this.proofAddressSC = proofAddressSC;
	}

	public BigDecimal getPROF_ADDRESS_CODE() {
		return PROF_ADDRESS_CODE;
	}

	public void setPROF_ADDRESS_CODE(BigDecimal pROF_ADDRESS_CODE) {
		PROF_ADDRESS_CODE = pROF_ADDRESS_CODE;
	}

	public CTS_PROOF_ADDRESSVO getCtsProofAddressVO() {
		return ctsProofAddressVO;
	}

	public void setCtsProofAddressVO(CTS_PROOF_ADDRESSVO ctsProofAddressVO) {
		this.ctsProofAddressVO = ctsProofAddressVO;
	}

	public void setProofAddressBO(ProofAddressBO proofAddressBO) {
		this.proofAddressBO = proofAddressBO;
	}

}
