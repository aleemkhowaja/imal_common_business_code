package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.path.bo.core.avapayment.AvaPaymentLkpBO;
import com.path.bo.core.common.CoreCommonBO;
import com.path.dbmaps.vo.CTSTRXTYPE_EXTENDEDVO;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.avapayment.AvaPaymentCO;
import com.path.vo.core.avapayment.AvaPaymentLkpSC;

/**
 * 
 * @author AbdoWazen
 * EWBI160072
 */
public class AvaPaymentLookupAction extends LookupBaseAction
{
    private AvaPaymentLkpBO avaPaymentLkpBO; 
    private AvaPaymentLkpSC avaPaymentLkpSC = new AvaPaymentLkpSC();
    private List<AvaPaymentCO> avaPaymentCOList;
    private CoreCommonBO coreCommonBO;

    @Override
    public Object getModel()
    {
	return avaPaymentLkpSC;
    }

    public String constructPaymentLookup()
    {

	try
	{
	   
	 if(!("").equals(StringUtil.nullToEmpty(avaPaymentLkpSC.getTrxType())))  /*From Trx screen*/
			 {
		    SessionCO sessionCO = returnSessionObject();
		    CTSTRXTYPE_EXTENDEDVO trxTypeVO = new CTSTRXTYPE_EXTENDEDVO();
		    trxTypeVO.setCOMP_CODE(sessionCO.getCompanyCode());
		    trxTypeVO.setCODE(avaPaymentLkpSC.getTrxType());
		    trxTypeVO = coreCommonBO.findTrxTypeExtended(trxTypeVO);
		    
		    
		if (("P").equals(StringUtil.nullToEmpty(trxTypeVO.getAVA_PAYMENT_CODE())))
		{
			    String[]  name = { "avaPaymentVO.PAYMENT_CODE", "avaPaymentVO.FILE_CODE","avaFileVO.CIF_NO","avaBeneficiariesDefCO.avaBeneficiariesVO.SHORT_NAME",
			    		  "avaBeneficiariesDefCO.idTypeDesc","avaBeneficiariesDefCO.avaBeneficiariesVO.ID_NO","avaPaymentVO.PAYMENT_DATE","paymentMethod","avaPaymentVO.AMOUNT_PAID","destinationCountry"};
			    String[] colType = { "number","number","number","text","text","number","date","text","number","text" };
			    String[] titles = { getText("add_Payment_Code_key"), getText("add_File_Code_key"),getText("CIF_No_key"),
			    		getText("add_Benef_Short_Name_Key"),getText("Id_Type_key"),getText("ID_Number_key"),getText("Payment_Date_key"),getText("Payment_Method_Key"),
			    		getText("Amount_Paid_Key"),getText("Destination_Country_key")};
			    
			    // Defining the Grid
			    LookupGrid grid = new LookupGrid();
			    grid.setCaption(getText("PaymentList"));
			    grid.setRowNum("5");
			    grid.setUrl("/pathdesktop/AvaPaymentLookupAction_fillPaymentTrxLkp");
			    lookup(grid, avaPaymentLkpSC, name, colType, titles);
		}
		if (("R").equals(StringUtil.nullToEmpty(trxTypeVO.getAVA_PAYMENT_CODE())))
		{
			 String[]  name = { "avaPaymentVO.PAYMENT_CODE", "avaPaymentVO.FILE_CODE","avaFileVO.CIF_NO","avaPaymentVO.LINKED_PAYMENT_CODE",
		    		  "avaPaymentVO.AMOUNT_PAID","returnType","avaPaymentVO.RETURN_AMOUNT_FC","avaPaymentVO.RETURN_AMOUNT_CV"};
		    String[] colType = { "number","number","number","number","number","text","number","number"};
		    String[] titles = { getText("add_Return_Payment_Code_key"), getText("add_File_Code_key"),getText("CIF_No_key"),
		    		getText("add_Payment_Code_key"),getText("Amount_Paid_Key"),getText("return_Type_key"),getText("add_Return_Amount_CV_Key"),getText("add_Return_Amount_FC_Key")};
		    // Defining the Grid
		    LookupGrid grid = new LookupGrid();
		    grid.setCaption(getText("PaymentList"));
		    grid.setRowNum("5");
		    grid.setUrl("/pathdesktop/AvaPaymentLookupAction_fillPaymentTrxLkp");
		    
		    lookup(grid, avaPaymentLkpSC, name, colType, titles);
		}
		
			 }
		
	 else
	 {
		// Types the Grid by defining the column model and column names
	    String[] name = {"avaPaymentVO.PAYMENT_CODE", 
		    "avaBeneficiariesDefCO.avaBeneficiariesVO.CIF_NO", 		   
		    "avaPaymentVO.FILE_CODE",		    
		    "avaBeneficiariesDefCO.avaBeneficiariesVO.LONG_NAME",
		    "avaBeneficiariesDefCO.avaBeneficiariesVO.SHORT_NAME", 
		    "avaBeneficiariesDefCO.avaBeneficiariesVO.ID_TYPE", 
		    "avaBeneficiariesDefCO.avaBeneficiariesVO.ID_NO" };
	    String[] colType = {"number", "number", "number",  "text", "text", "number","text" };
	    String[] titles = { getText("add_Payment_Code_key"),getText("Cif_No_key"), getText("File_Code_key"), 
		    getText("Beneficiary_Long_Name_key"), getText("Beneficiary_Short_Name_key"),
		    getText("ID_Type_key"), getText("ID_Number_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("PaymentList"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/AvaPaymentLookupAction_fillPaymentLkp");
	    lookup(grid, avaPaymentLkpSC, name, colType, titles);
	 }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup Types data filtered by user.
     * 
     * @return
     * 
     */
    public String fillPaymentLkp()
    {
	try
	{
	    List<AvaPaymentCO> paymentCOList;
	    setSearchFilter(avaPaymentLkpSC);
	    copyproperties(avaPaymentLkpSC);

	    SessionCO sessionCO = returnSessionObject();
	    avaPaymentLkpSC.setUserId(sessionCO.getUserName());
	    avaPaymentLkpSC.setCompCode(sessionCO.getCompanyCode());

	    if(getRecords() == 0)
	    {
		setRecords(avaPaymentLkpBO.returnAvaPaymentLookupCount(avaPaymentLkpSC));
	    }
	    paymentCOList = avaPaymentLkpBO.returnAvaPaymentLookupList(avaPaymentLkpSC);

	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(paymentCOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
    /**
     * Fill the lookup Types data filtered by user.
     * 
     * @return
     * 
     */
    public String fillPaymentTrxLkp()
    {
	try
	{
	   
		HashMap<String,String> hmDate = new HashMap<String,String>();
		hmDate.put("avaPaymentVO.PAYMENT_DATE","avaPaymentVO.PAYMENT_DATE");
		avaPaymentLkpSC.setDateSearchCols(hmDate);
	    setSearchFilter(avaPaymentLkpSC);
	    copyproperties(avaPaymentLkpSC);
	    SessionCO sessionCO = returnSessionObject();
	    CTSTRXTYPE_EXTENDEDVO trxTypeVO = new CTSTRXTYPE_EXTENDEDVO();
	    trxTypeVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    trxTypeVO.setCODE(avaPaymentLkpSC.getTrxType());
	    trxTypeVO = coreCommonBO.findTrxTypeExtended(trxTypeVO);
	    avaPaymentLkpSC.setAvaPaymentCode(trxTypeVO.getAVA_PAYMENT_CODE());
	   
	    avaPaymentLkpSC.setUserId(sessionCO.getUserName());
	    avaPaymentLkpSC.setCompCode(sessionCO.getCompanyCode());
	    avaPaymentLkpSC.setLanguage(sessionCO.getLanguage());
	    avaPaymentLkpSC.setLovPayMethod(new BigDecimal(727));
	    avaPaymentLkpSC.setLovReturnType(new BigDecimal(728));
	    if(getRecords() == 0)
	    {
		setRecords(avaPaymentLkpBO.returnAvaPaymentTrxLookupCount(avaPaymentLkpSC));
	    }
	    avaPaymentCOList = avaPaymentLkpBO.returnAvaPaymentTrxLookupList(avaPaymentLkpSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(avaPaymentCOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    

    public AvaPaymentLkpSC getAvaPaymentLkpSC()
    {
	return avaPaymentLkpSC;
    }

    public void setAvaPaymentLkpSC(AvaPaymentLkpSC avaPaymentLkpSC)
    {
	this.avaPaymentLkpSC = avaPaymentLkpSC;
    }

    public void setAvaPaymentLkpBO(AvaPaymentLkpBO avaPaymentLkpBO)
    {
	this.avaPaymentLkpBO = avaPaymentLkpBO;
    }

	public void setCoreCommonBO(CoreCommonBO coreCommonBO) {
		this.coreCommonBO = coreCommonBO;
	}

}
