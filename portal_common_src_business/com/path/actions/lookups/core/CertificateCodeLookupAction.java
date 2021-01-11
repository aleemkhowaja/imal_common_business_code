package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.certificate.CertificateLookupBO;
import com.path.dbmaps.vo.CTSCERTIFICATEACCVO;
import com.path.dbmaps.vo.CTSCERTIFICATEVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.certificate.CertificateLookupCO;
import com.path.vo.core.certificate.CertificateLookupSC;

public class CertificateCodeLookupAction extends LookupBaseAction
{
    private CertificateLookupBO certificateLookupBO;
    private CertificateLookupSC certificateLookupSC = new CertificateLookupSC();
    private CTSCERTIFICATEVO ctsCertificateVO = new CTSCERTIFICATEVO();
    private CTSCERTIFICATEACCVO ctsCertificateAccVO = new CTSCERTIFICATEACCVO();
    private CertificateLookupCO certificateLookupCO = new CertificateLookupCO(); 
    

    @Override
    public Object getModel()
    {
	return certificateLookupSC;
    }

    public String constructCertificateCodeLookup()
    {

	try
	{
	    // Types the Grid by defining the column model and column names
	    String[] name = { "CERTIFICATE_CODE", "ADDITIONAL_REFERENCE", "BRANCH"};
	    String[] colType = { "number", "text", "number"};
	    String[] titles = { getText("Certificate_Code_key"), getText("Additional_Reference_key"),
		    getText("Branch_Code_key") };
	
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("CertificateCode"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CertificateCodeLookupAction_fillCertificateLookup");
	    lookup(grid, certificateLookupSC, name, colType, titles);
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
    public String fillCertificateLookup()
    {
	try
	{
	    List<CTSCERTIFICATEVO> certificateVOList;
	    setSearchFilter(certificateLookupSC);
	    copyproperties(certificateLookupSC);

	    SessionCO sessionCO = returnSessionObject();
	    certificateLookupSC.setUserId(sessionCO.getUserName());
	    certificateLookupSC.setCompCode(sessionCO.getCompanyCode());

	    if(getRecords() == 0)
	    {
		setRecords(certificateLookupBO.returnCertificateLookupCount(certificateLookupSC));
	    }
	    certificateVOList = certificateLookupBO.returnCertificateLookup(certificateLookupSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(certificateVOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setCertificateLookupBO(CertificateLookupBO certificateLookupBO)
    {
	this.certificateLookupBO = certificateLookupBO;
    }

    public CertificateLookupSC getCertificateLookupSC()
    {
	return certificateLookupSC;
    }

    public void setAvaFileLkpSC(CertificateLookupSC certificateLookupSC)
    {
	this.certificateLookupSC = certificateLookupSC;
    }
    
    public CTSCERTIFICATEVO getCtsCertificateVO()
    {
        return ctsCertificateVO;
    }

    public void setCtsCertificateVO(CTSCERTIFICATEVO ctsCertificateVO)
    {
        this.ctsCertificateVO = ctsCertificateVO;
    }

    public void setCertificateLookupCO(CertificateLookupCO certificateLookupCO)
    {
	this.certificateLookupCO = certificateLookupCO;
    }

    public CertificateLookupCO getCertificateLookupCO()
    {
	return certificateLookupCO;
    }

    public void setCtsCertificateAccVO(CTSCERTIFICATEACCVO ctsCertificateAccVO)
    {
	this.ctsCertificateAccVO = ctsCertificateAccVO;
    }

    public CTSCERTIFICATEACCVO getCtsCertificateAccVO()
    {
	return ctsCertificateAccVO;
    }

}
