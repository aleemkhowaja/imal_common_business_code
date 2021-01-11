package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;
import com.path.bo.core.sourcefunds.SourceFundsBO;
import com.path.dbmaps.vo.CTS_SOURCE_FUNDSVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.sourcefunds.SourceFundsSC;

public class SourceFundsLookupAction extends LookupBaseAction
{

	private SourceFundsBO sourceFundsBO;
	private SourceFundsSC sourceFundsSC = new SourceFundsSC();
	private CTS_SOURCE_FUNDSVO ctsSourceFundsVO = new CTS_SOURCE_FUNDSVO();

	@Override
	public Object getModel()
	{
		return sourceFundsSC;
	}

	public String constructLookup()
	{
		try
		{
			// Design the Grid by defining the column model and column names
			String[] name = { "SOURCE_FUNDS_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG" };
			String[] colType = { "text", "text", "text" };
			String[] titles = { getText("Code_key"), getText("Brief_Name_key"), getText("Long_Name_key") };

			// Defining the Grid
			LookupGrid grid = new LookupGrid();
			grid.setCaption(getText("Lookup/Code_key"));
			grid.setRowNum("5");
			grid.setUrl("/pathdesktop/SourceFundsLookup_fillSourceFundsLookup");
			lookup(grid, sourceFundsSC, name, colType, titles);
		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}

		return SUCCESS;

	}

	public String fillSourceFundsLookup()
	{
		try
		{
			List<SourceFundsSC> sourceFundsVOList;
			setSearchFilter(sourceFundsSC);
			copyproperties(sourceFundsSC);
			SessionCO sessionCO = returnSessionObject();
			sourceFundsSC.setCompCode(sessionCO.getCompanyCode());

			if (checkNbRec(sourceFundsSC))
			{
				setRecords(sourceFundsBO.sourceFundsListCount(sourceFundsSC));
			}
			sourceFundsVOList = sourceFundsBO.sourceFundsList(sourceFundsSC);
			// set the collection into gridModel attribute defined at JSP grid
			setGridModel(sourceFundsVOList);

		}
		catch (Exception e)
		{
			log.error(e, "Error in fillLookupData of SourceFundsLookupAction");
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String dependencyBySourceFundsCode()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();

			sourceFundsSC.setCompCode(sessionCO.getCompanyCode());
			if (StringUtil.isEmptyString(sourceFundsSC.getSOURCE_FUNDS_CODE()))
			{
				ctsSourceFundsVO = new CTS_SOURCE_FUNDSVO();
			}
			else
			{
				sourceFundsSC.setCode(new BigDecimal(sourceFundsSC.getSOURCE_FUNDS_CODE()));
				ctsSourceFundsVO = sourceFundsBO.returnSourceFundsCodeById(sourceFundsSC);

				if ((ctsSourceFundsVO == null || ctsSourceFundsVO.getSOURCE_FUNDS_CODE() == null) && BigDecimal.ZERO.compareTo(sourceFundsSC.getCode()) == 0)
				{
					if (ctsSourceFundsVO == null)
					{
						ctsSourceFundsVO = new CTS_SOURCE_FUNDSVO();
					}

					ctsSourceFundsVO.setSOURCE_FUNDS_CODE(BigDecimal.ZERO);
				}

				sourceFundsSC.setSOURCE_FUNDS_CODE(ctsSourceFundsVO.getSOURCE_FUNDS_CODE().toString());
			}
			
			sourceFundDescReadOnlyMode();
		}
		catch (Exception e)
		{
			ctsSourceFundsVO = new CTS_SOURCE_FUNDSVO();
			handleException(e, null, null);
		}
		return SUCCESS;
	}
	/**
	 * @author RaniaAlBitar
	 * BMO180181
	 * @return
	 */
	
	public void sourceFundDescReadOnlyMode()
    {
    	try
    	{
    		SYS_PARAM_SCREEN_DISPLAYVO vo = new SYS_PARAM_SCREEN_DISPLAYVO();
    		
    		if (ctsSourceFundsVO != null && ctsSourceFundsVO.getSOURCE_FUNDS_CODE() != null && BigDecimal.ZERO.compareTo(ctsSourceFundsVO.getSOURCE_FUNDS_CODE()) == 0)
			{
				vo.setIS_READONLY(BigDecimal.ZERO);
				vo.setIS_MANDATORY(BigDecimal.ONE);
			}
			else
			{
				vo.setIS_READONLY(BigDecimal.ONE);
				vo.setIS_MANDATORY(BigDecimal.ZERO);
			}

			getAdditionalScreenParams().put("fomCO_cifExtendedVO_SOURCE_FUNDS_DESC", vo);
    	}
    	catch(Exception e)
    	{
    	    handleException(e, null, null);
    	}
    }
	public SourceFundsSC getSourceFundsSC()
	{
		return sourceFundsSC;
	}

	public void setSourceFundsSC(SourceFundsSC sourceFundsSC)
	{
		this.sourceFundsSC = sourceFundsSC;
	}

	public CTS_SOURCE_FUNDSVO getCtsSourceFundsVO()
	{
		return ctsSourceFundsVO;
	}

	public void setCtsSourceFundsVO(CTS_SOURCE_FUNDSVO ctsSourceFundsVO)
	{
		this.ctsSourceFundsVO = ctsSourceFundsVO;
	}

	public void setSourceFundsBO(SourceFundsBO sourceFundsBO)
	{
		this.sourceFundsBO = sourceFundsBO;
	}
}
