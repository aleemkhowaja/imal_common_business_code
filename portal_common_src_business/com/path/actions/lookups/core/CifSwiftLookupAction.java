package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.cifswift.CifSwiftBO;
import com.path.bo.core.csmfom.FomConstant;
import com.path.dbmaps.vo.S_PMSCIFSWIFTVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.cifswift.CifSwiftSC;
import com.path.vo.core.csmfom.FomCifSwiftCO;

public class CifSwiftLookupAction extends LookupBaseAction
{
    private CifSwiftSC criteria = new CifSwiftSC();
    private CifSwiftBO cifSwiftBO;
    private String client_Is_Bank;
    private String is_rma;
    private BigDecimal code;

    @Override
    public Object getModel()
    {
	return criteria;
    }

    /**
     * PB : n_transaction / uf_dw_main_rbuttondown_1 / w_lookup_cifswift
     * @return
     */
    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] columnArr[] = { { "CIF", "number", getText("CIF_key") },
		    { "CIF_NAME", "text", getText("Bank_Name_key") },
		    { "SWIFT_BIC_BBBB", "text", getText("Bank_Code_key") },
		    { "SWIFT_BIC_CC", "text", getText("Country_Code_key") },
		    { "SWIFT_BIC_LL", "text", getText("Location_Code_key") },
		    { "SWIFT_BIC_T", "text", getText("Terminal_Id_key") },
		    { "SWIFT_BIC_BCD", "text", getText("Branch_Code_key") }, };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption("");
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifSwiftLookup_fillSwiftLookup");
	    lookup(grid, criteria, columnArr);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }
    
    /**
     * Fill the lookup Cities data filtered by the defined criteria
     * @PB w_lookup_cifswift_country
     * @return
     */
    public String fillSwiftLookup()
    {
	try
	{
	    List<S_PMSCIFSWIFTVO> swiftVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    

	    // if isnull(is_rma) or is_rma = '' or is_rma <> '1' Then is_rma =
	    // '0'
	    // if isnull(is_parm) or is_parm = '' or is_parm <> 'Y' Then is_parm
	    // = 'N'

	    is_rma = client_Is_Bank;
	    if(!StringUtil.isNotEmpty(is_rma) || (!"1".equalsIgnoreCase(is_rma)))
	    {
		is_rma = "0";
	    }
	    if((!StringUtil.isNotEmpty(client_Is_Bank)) || (!"Y".equalsIgnoreCase(client_Is_Bank)))
	    {
		client_Is_Bank = "N";
	    }

	    criteria.setClientIsBank(client_Is_Bank);
	    criteria.setRma(is_rma);

	    if(checkNbRec(criteria))
	    {
		setRecords(cifSwiftBO.bankListCount(criteria));
	    }
	    swiftVOList = cifSwiftBO.bankList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(swiftVOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    //Hala Al Sheikh - TP826465 DBU190589 
    public String constructLookupByCountry()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] columnArr[] = { { "CIF", "number", getText("CIF_key") },
		    { "CIF_NAME", "text", getText("Bank_Name_key") },
		    { "SWIFT_BIC_BBBB", "text", getText("Bank_Code_key") },
		    { "SWIFT_BIC_CC", "text", getText("Country_Code_key") },
		    { "SWIFT_BIC_LL", "text", getText("Location_Code_key") },
		    { "SWIFT_BIC_T", "text", getText("Terminal_Id_key") },
		    { "SWIFT_BIC_BCD", "text", getText("Branch_Code_key") }, };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption("");
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CifSwiftLookup_dependencySwiftReceiverBICByCountry");
	    lookup(grid, criteria, columnArr);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }
 
    public String dependencySwiftReceiverBICByCountry()
    {
	try
        {
	    List<S_PMSCIFSWIFTVO> swiftVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
            criteria.setCompCode(sessionCO.getCompanyCode());
            criteria.setClientIsBank("N");
            criteria.setRma("0");
            if(NumberUtil.emptyDecimalToNull(criteria.getBankCif())== null)
            {
        	if(NumberUtil.emptyDecimalToNull(criteria.getCorrBank())== null)
                {
            	criteria.setBankCif(BigDecimal.ZERO);
                }
        	else
        	{
        	    criteria.setBankCif(criteria.getCorrBank()); 
        	}       	
            }
            if(checkNbRec(criteria))
	    {
		setRecords(cifSwiftBO.benefBankBicByCountryCount(criteria));
	    }
	    swiftVOList = cifSwiftBO.benefBankBicByCountryList(criteria);
	    setGridModel(swiftVOList);
        }
        catch(Exception ex)
        {
            handleException(ex, null, null);
        }
        return SUCCESS;
    }
    //End Hala
    /**
     * Construct Bic Code Lookup
     * @author: BoushraFahs
     * @date: 7 Oct 2013
     * @PB: w_lookup_bic_code,w_lookup_cifswift_country
     */
    public String constructBicCodeLookup()
    {
        try
        {
            // Design the Grid by defining the column model and column names
            String[] name = {"cifSwiftVO.CIF", "cifName", "cifSwiftVO.SWIFT_BIC_BBBB",
                "cifSwiftVO.SWIFT_BIC_CC", "cifSwiftVO.SWIFT_BIC_LL", "cifSwiftVO.SWIFT_BIC_T",
                "cifSwiftVO.SWIFT_BIC_BCD", "bicCodeNumber"};
            String[] colType = {"number", "text", "text", "text", "text", "text", "text", "text"};
            String[] titles = {getText("CIF_key"), getText("Bank_Name_key"), getText("Bank_Code_key"),
                getText("Country_Code_key"), getText("Location_Code_key"), getText("Terminal_Id_key"),
                getText("Branch_Code_key"), getText("BIC_key")};

            // Defining the Grid
            LookupGrid grid = new LookupGrid();
            grid.setCaption("");
            grid.setRowNum("5");
            grid.setUrl("/pathdesktop/CifSwiftLookup_fillBicLookup");
            List<LookupGridColumn> acceptGridColumn = returnStandarColSpecs(name, colType, titles);
            for(int i = 0; i < name.length; i++)
            {
                if("bicCodeNumber".equals(acceptGridColumn.get(i).getName()))
                {
                    acceptGridColumn.get(i).setHidden(true);
                }
            }
            lookup(grid, acceptGridColumn, null, criteria);
        }
        catch(Exception e)
        {
            log.error(e, "Error in constructLookup of CifSwiftLookupAction");
            handleException(e, null, null);
        }

        return SUCCESS;
    }

    /**
     * Fill the lookup BIC data filtered by the defined criteria
     * 
     * @author: BoushraFahs
     * @date: 7 Oct 2013
     * @PB:
     * @return
     */
    public String fillBicLookup()
    {
        try
        {
            setSearchFilter(criteria);
            copyproperties(criteria);
            SessionCO sessionCO = returnSessionObject();
            criteria.setCompCode(sessionCO.getCompanyCode());
            criteria.setBranchCode(sessionCO.getBranchCode());

            //BMOI130017
	    if(FomConstant.RB_REAL_BENEFICIARIES_REF.equals(criteria.getFromWhere()))
	    {
		FomCifSwiftCO co = cifSwiftBO.fillBenefParam(criteria);
		criteria.setCountryCode(co.getIsoCountry());
		criteria.setTrxType(BigDecimal.ZERO);
		criteria.setCifCode(BigDecimal.ZERO);
		criteria.setRma("0");
		criteria.setCurrencyCode(BigDecimal.ZERO);
	    }
            
            
            if(checkNbRec(criteria))
            {
                setRecords(cifSwiftBO.returnBicCodeLookupCount(criteria));
            }
            // set the collection into gridModel attribute defined at JSP grid
            setGridModel( cifSwiftBO.returnBicCodeLookupList(criteria));
        }
        catch(Exception e)
        {
            log.error(e, "Error in fillBicLookup of CifSwiftLookupAction");
            handleException(e, null, null);
        }
        return SUCCESS;
    }


    public CifSwiftSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(CifSwiftSC criteria)
    {
	this.criteria = criteria;
    }

    public void setCifSwiftBO(CifSwiftBO cifSwiftBO)
    {
	this.cifSwiftBO = cifSwiftBO;
    }

    public BigDecimal getCode()
    {
	return code;
    }

    public void setCode(BigDecimal code)
    {
	this.code = code;
    }

    public String getClient_Is_Bank()
    {
	return client_Is_Bank;
    }

    public void setClient_Is_Bank(String clientIsBank)
    {
	client_Is_Bank = clientIsBank;
    }

    public String getIs_rma()
    {
	return is_rma;
    }

    public void setIs_rma(String isRma)
    {
	is_rma = isRma;
    }


}
