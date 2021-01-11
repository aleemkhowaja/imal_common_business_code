/**
 * 
 */
package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.professioncategory.ProfessionCategoryBO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTS_PROFESSION_CATEGORYVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.professioncategory.ProfessionCategorySC;


public class ProfessionCategoryDependencyAction extends RetailBaseAction
{
    private ProfessionCategoryBO professionCategoryBO;
    private ProfessionCategorySC professionCategorySC = new ProfessionCategorySC();
    private CTS_PROFESSION_CATEGORYVO professionCategoryVO;
    private CIFVO cifVO;

    public String dependencyByProfessionCategory()
    {
	try
	{
       	    SessionCO sessionCO = returnSessionObject();
	    CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	    cifControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    cifControlVO = returnCommonLibBO().returnCifControlDetails(cifControlVO);
	    if (null != cifControlVO)
	    {
		cifControlVO.getUSE_CIF_MATRIX_YN();
	    }	    
	    if(("1").equals(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN())) && NumberUtil.emptyDecimalToNull(cifVO.getLEGAL_STATUS()) == null)
	    {
		throw new BOException(MessageCodes.PLEASE_FILL, new String[] { "Legal_Status_key" });
	    }	 
	    
	    if(!NumberUtil.isEmptyDecimal(professionCategorySC.getCode()))
	    {
		professionCategorySC.setCompCode(sessionCO.getCompanyCode());
		professionCategorySC.setPreferredLanguage(sessionCO.getPreferredLanguage());
		professionCategorySC.setUseCifMatrix(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN()));
		professionCategoryVO = professionCategoryBO.returnDependencyByProfessionCategory(professionCategorySC);
		
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByProfessionCategory method of ProfessionCategoryDependencyAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    @Override
    public ProfessionCategorySC getModel()
    {
	return professionCategorySC;
    }


    public CTS_PROFESSION_CATEGORYVO getProfessionCategoryVO()
    {
        return professionCategoryVO;
    }

    public void setProfessionCategoryVO(CTS_PROFESSION_CATEGORYVO professionCategoryVO)
    {
        this.professionCategoryVO = professionCategoryVO;
    }

    public ProfessionCategorySC getProfessionCategorySC()
    {
        return professionCategorySC;
    }

    public void setProfessionCategorySC(ProfessionCategorySC professionCategorySC)
    {
        this.professionCategorySC = professionCategorySC;
    }

    public ProfessionCategoryBO getProfessionCategoryBO()
    {
        return professionCategoryBO;
    }

    public void setProfessionCategoryBO(ProfessionCategoryBO professionCategoryBO)
    {
        this.professionCategoryBO = professionCategoryBO;
    }

    public CIFVO getCifVO()
    {
        return cifVO;
    }

    public void setCifVO(CIFVO cifVO)
    {
        this.cifVO = cifVO;
    }


}
