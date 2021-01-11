package com.path.core.actions.segmentation;

import java.math.BigDecimal;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;

public class CustSegmentationDependencyAction extends CustSegmentationMaintAction
{

	/**
	 * Common method : fill session variables before calling each dependency
	 */
	private void fillSessionVariables() throws BaseException
	{
		SessionCO sessionCO = returnSessionObject();

		custSegmentationCO.setLoginCompCode(sessionCO.getCompanyCode());
		custSegmentationCO.setLoginBraCode(sessionCO.getBranchCode());
		custSegmentationCO.setRunningDate(sessionCO.getRunningDateRET());
		custSegmentationCO.setCrud(getIv_crud());
		custSegmentationCO.setLoginUserId(sessionCO.getUserName());
		custSegmentationCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
		custSegmentationCO.setLanguage(sessionCO.getLanguage());
	}

	public String dependencyBySegmentCode()
	{
		try
		{
			if (!NumberUtil.isNumberPositive(custSegmentationCO.getCtsSegmentVO().getSEGMENT_CODE()))
			{
				custSegmentationCO.getCtsSegmentVO().setSEGMENT_CODE(null);
				return LOADJSON;
			}

			fillSessionVariables();
			
			if(get_pageRef().contains("CSC00SC"))
			{
				custSegmentationCO.getCtsSegmentVO().setSEGMENT_TYPE("SC");
			}
			else if(get_pageRef().contains("CSG00SEG"))
			{
				custSegmentationCO.getCtsSegmentVO().setSEGMENT_TYPE("S");
			}
			
			custSegmentationCO.setOpt(get_pageRef());
						
			custSegmentationCO = custSegmentationBO.dependencyBySegmentCode(custSegmentationCO);
		}
		catch (Exception e)
		{
			custSegmentationCO.getCtsSegmentVO().setSEGMENT_CODE(null);
			handleException(e, null, null);
		}
		return LOADJSON;

	}

	public String dependencyByCriteriaCode()
	{
		try
		{
			NumberUtil.resetEmptyValues(custSegmentationCO.getCtsSegmentDetVO());
			if (checkNumberValidity(custSegmentationCO.getCtsSegmentDetVO().getCRITERIA_CODE()))
			{
				fillSessionVariables();
				custSegmentationCO = custSegmentationBO.dependencyByCriteriaCode(custSegmentationCO);
			}
			else
			{
				custSegmentationCO.getCtsSegmentDetVO().setCRITERIA_CODE(null);
			}
		}
		catch (Exception e)
		{
			custSegmentationCO.getCtsSegmentDetVO().setCRITERIA_CODE(null);
			handleException(e, null, null);
		}
		return LOADJSON;
	}

	/**
	 * 
	 */
	private boolean checkNumberValidity(BigDecimal value) throws BaseException
	{

		return (!NumberUtil.isEmptyDecimal(value) && NumberUtil.toDouble(value) >= 0);
	}

	public String dependencyProcessBranch()
	{
		try
		{
			if (!NumberUtil.isEmptyDecimal(custSegmentationSC.getBranchCode()))
			{
				SessionCO sessionCO = returnSessionObject();
				custSegmentationSC.setCompCode(sessionCO.getCompanyCode());

				custSegmentationSC = custSegmentationBO.validateBranchCode(custSegmentationSC);
			}
			else
			{
				custSegmentationSC.setBranchCode(null);
			}
		}
		catch (Exception e)
		{
			custSegmentationSC.setBranchCode(null);
			handleException(e, null, null);
		}
		return LOADJSON;

	}

	public String dependencyByCif()
	{
		try
		{
			if (!NumberUtil.isEmptyDecimal(custSegmentationSC.getCifNo()))
			{
				SessionCO sessionCO = returnSessionObject();
				custSegmentationSC.setCompCode(sessionCO.getCompanyCode());
				custSegmentationSC.setUserId(sessionCO.getUserName());
				// if(null == sessionCO.getCtsTellerVO())
				// {
				// custSegmentationSC.setAllowCifCreationMaskYN("1");
				// }
				// else
				// {
				// custSegmentationSC
				// .setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
				// }

				custSegmentationSC = custSegmentationBO.dependencyByCif(custSegmentationSC);

				// if(!NumberUtil.isEmptyDecimal(custSegmentationSC.getCifNo()))
				// {
				// MemoSC memoSC = new MemoSC();
				// memoSC.setCompCode(sessionCO.getCompanyCode());
				// memoSC.setForAccOrCif(MemoConstants.CIF);
				// memoSC.setCifNo(custSegmentationSC.getCifNo());
				// checkForMemo(memoSC);
				// }
			}
			else
			{
				custSegmentationSC.setCifNo(null);
			}

		}
		catch (BOException e)
		{
			custSegmentationSC.setCifNo(null);
			handleException(e, null, null);
		}
		catch (Exception e)
		{
			log.error(e, "Error in dependencyByCif method of CifDependencyAction");
			handleException(e, null, null);
		}
		return LOADJSON;
	}

	/**
	 * @author raniaalbitar
	 * 718813 - Dynamic Customer Scoring on latest
	 */

	public String dependencyByMainCif()
	{
		try
		{
			if (!NumberUtil.isEmptyDecimal(custSegmentationSC.getCifNo()))
			{
				SessionCO sessionCO = returnSessionObject();
				custSegmentationSC.setCompCode(sessionCO.getCompanyCode());
				custSegmentationSC.setUserId(sessionCO.getUserName());

				custSegmentationSC = custSegmentationBO.dependencyByMainCif(custSegmentationSC);
			}
			else
			{
				custSegmentationSC.setCifNo(null);
			}

		}
		catch (BOException e)
		{
			custSegmentationSC.setCifNo(null);
			handleException(e, null, null);
		}
		catch (Exception e)
		{
			log.error(e, "Error in dependencyByCif method of CifDependencyAction");
			handleException(e, null, null);
		}
		return LOADJSON;
	}
	
	/**
	 * @author raniaalbitar
	 * 718813 - Dynamic Customer Scoring on latest
	 */
	public String dependencyByMainSegmentCode()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			custSegmentationSC.setCompCode(sessionCO.getCompanyCode());
			custSegmentationSC.setBranchCode(sessionCO.getBranchCode());
			custSegmentationSC.setUserId(sessionCO.getUserName());
			custSegmentationSC.setTellerCode(sessionCO.getCtsTellerVO().getCODE());
			
			custSegmentationSC = custSegmentationBO.dependencyByMainSegmentCode(custSegmentationSC);
		}
		catch (Exception e)
		{
			custSegmentationSC.setSegmentCode(null);
			handleException(e, null, null);
		}
		return LOADJSON;

	}
	
	/**
	 * @author raniaalbitar
	 * 718813 - Dynamic Customer Scoring on latest
	 */
	
	public String dependencyByGroupCode()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			custSegmentationSC.setCompCode(sessionCO.getCompanyCode());
					
			custSegmentationSC = custSegmentationBO.dependencyByGroupCode(custSegmentationSC);
		}
		catch (Exception e)
		{
			custSegmentationSC.setGroupCode(null);
			handleException(e, null, null);
		}
		return LOADJSON;

	}
	
    /**
     * @author RaniaAlBitar
     * BMO180147 - Risk Assessment of customers on the basis of products, services and geographic locations
     */

    public String dependencyByMainScore()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    int count = 0;
	    
	    custSegmentationCO.getCtsSegmentVO().setCOMP_CODE(sessionCO.getCompanyCode());

	    if("1".equals(custSegmentationCO.getCtsSegmentVO().getMAIN_SCORE_YN()))
	    {
		count = custSegmentationBO.dependencyByMainScore(custSegmentationCO);
		
		if(count > 0)
		{
		    throw new BOException("Main Score must be checked once at most");
		}
	    }
	}
	catch(Exception e)
	{
	    custSegmentationCO.getCtsSegmentVO().setMAIN_SCORE_YN("0");
	    handleException(e, null, null);
	}
	return LOADJSON;
    }
}
