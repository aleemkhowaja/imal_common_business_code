/**
 * 
 */
package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.profession.ProfessionBO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CIF_EXTENDEDVO;
import com.path.dbmaps.vo.CTS_PROFESSIONVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.profession.ProfessionSC;


public class ProfessionDependencyAction extends RetailBaseAction
{
    private ProfessionBO professionBO;
    private ProfessionSC professionSC = new ProfessionSC();
    private CTS_PROFESSIONVO professionVO;
    
    public String dependencyByProfession()
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
	    if(("1").equals(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN())) && NumberUtil.emptyDecimalToNull(professionSC.getSegmentCode()) == null)
	    {
		throw new BOException(MessageCodes.PLEASE_FILL, new String[] { "profession_segment_key" });
	    }	 
	    
	    if(!NumberUtil.isEmptyDecimal(professionSC.getCode()))
	    {
		professionSC.setCompCode(sessionCO.getCompanyCode());
		professionSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
		professionSC.setUseCifMatrix(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN()));
		professionVO = professionBO.returnDependencyByProfession(professionSC);
		
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByProfession method of ProfessionDependencyAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    @Override
    public ProfessionSC getModel()
    {
	return professionSC;
    }

    public ProfessionBO getProfessionBO()
    {
        return professionBO;
    }

    public void setProfessionBO(ProfessionBO professionBO)
    {
        this.professionBO = professionBO;
    }

    public ProfessionSC getProfessionSC()
    {
        return professionSC;
    }

    public void setProfessionSC(ProfessionSC professionSC)
    {
        this.professionSC = professionSC;
    }

    public CTS_PROFESSIONVO getProfessionVO()
    {
        return professionVO;
    }

    public void setProfessionVO(CTS_PROFESSIONVO professionVO)
    {
        this.professionVO = professionVO;
    }


}
