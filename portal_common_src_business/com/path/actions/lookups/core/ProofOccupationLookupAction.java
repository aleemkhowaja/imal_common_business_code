package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.proofoccupation.ProofOccupationBO;
import com.path.dbmaps.vo.CTS_PROOF_OCCUPATIONVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.proofoccupation.ProofOccupationSC;

public class ProofOccupationLookupAction extends LookupBaseAction
{

    private ProofOccupationBO proofOccupationBO;
    private ProofOccupationSC proofOccupationSC = new ProofOccupationSC();
    private BigDecimal PROOF_OCCUPATION_CODE;
    private CTS_PROOF_OCCUPATIONVO ctsProofOccupationVO = new CTS_PROOF_OCCUPATIONVO();

    @Override
    public Object getModel()
    {
	return proofOccupationSC;
    }

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "PROOF_OCCUPATION_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG" };
	    String[] colType = { "number", "text", "text" };
	    String[] titles = { getText("Code_key"), getText("Brief_Name_key"), getText("Long_Name_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Code_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/ProofOccupationLookup_fillProofOccupationLookup");
	    lookup(grid, proofOccupationSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String fillProofOccupationLookup()
    {
	try
	{
	    List<CTS_PROOF_OCCUPATIONVO> proofOccupationVOList;
	    setSearchFilter(proofOccupationSC);
	    copyproperties(proofOccupationSC);
	    SessionCO sessionCO = returnSessionObject();
	    proofOccupationSC.setCompCode(sessionCO.getCompanyCode());

	    if(checkNbRec(proofOccupationSC))
	    {
		setRecords(proofOccupationBO.proofOccupationListCount(proofOccupationSC));
	    }
	    proofOccupationVOList = proofOccupationBO.proofOccupationList(proofOccupationSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(proofOccupationVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of ProofOccupationLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String dependencyByProofOccupationCode()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    proofOccupationSC.setCompCode(sessionCO.getCompanyCode());
	    proofOccupationSC.setCode(PROOF_OCCUPATION_CODE);
	    if(NumberUtil.isEmptyDecimal(PROOF_OCCUPATION_CODE))
	    {
	    	ctsProofOccupationVO = new CTS_PROOF_OCCUPATIONVO();
	    }
	    else
	    {
	    	ctsProofOccupationVO = proofOccupationBO.returnProofOccupationCodeById(proofOccupationSC);
	    }
	   
	}
	catch(Exception e)
	{
		ctsProofOccupationVO = new CTS_PROOF_OCCUPATIONVO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

	public ProofOccupationSC getProofOccupationSC() {
		return proofOccupationSC;
	}

	public void setProofOccupationSC(ProofOccupationSC proofOccupationSC) {
		this.proofOccupationSC = proofOccupationSC;
	}

	public BigDecimal getPROOF_OCCUPATION_CODE() {
		return PROOF_OCCUPATION_CODE;
	}

	public void setPROOF_OCCUPATION_CODE(BigDecimal pROOF_OCCUPATION_CODE) {
		PROOF_OCCUPATION_CODE = pROOF_OCCUPATION_CODE;
	}

	public CTS_PROOF_OCCUPATIONVO getCtsProofOccupationVO() {
		return ctsProofOccupationVO;
	}

	public void setCtsProofOccupationVO(CTS_PROOF_OCCUPATIONVO ctsProofOccupationVO) {
		this.ctsProofOccupationVO = ctsProofOccupationVO;
	}

	public void setProofOccupationBO(ProofOccupationBO proofOccupationBO) {
		this.proofOccupationBO = proofOccupationBO;
	}

}
