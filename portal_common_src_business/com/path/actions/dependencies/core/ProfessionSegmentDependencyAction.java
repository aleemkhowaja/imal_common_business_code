/**
 * 
 */
package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.professionsegment.ProfessionSegmentBO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CTS_PROFESSION_SEGMENTVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.professionsegment.ProfessionSegmentSC;



public class ProfessionSegmentDependencyAction extends RetailBaseAction
{
    private ProfessionSegmentBO professionSegmentBO;
    private ProfessionSegmentSC professionSegmentSC = new ProfessionSegmentSC();
    private CTS_PROFESSION_SEGMENTVO professionSegmentVO;

    public String dependencyByProfessionSegment()
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
	    if(("1").equals(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN())) && NumberUtil.emptyDecimalToNull(professionSegmentSC.getCategoryCode()) == null)
	    {

		throw new BOException(MessageCodes.PLEASE_FILL, new String[] { "profession_category_key" });
	    }	 
	    
	    if(!NumberUtil.isEmptyDecimal(professionSegmentSC.getCode()))
	    {
		professionSegmentSC.setCompCode(sessionCO.getCompanyCode());
		professionSegmentSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
                professionSegmentSC.setUseCifMatrix(StringUtil.nullToEmpty(cifControlVO.getUSE_CIF_MATRIX_YN()));
		professionSegmentVO = professionSegmentBO.returnDependencyByProfessionSegment(professionSegmentSC);
		
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByProfessionSegment method of ProfessionSegmentDependencyAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    @Override
    public ProfessionSegmentSC getModel()
    {
	return professionSegmentSC;
    }

    public ProfessionSegmentBO getProfessionSegmentBO()
    {
        return professionSegmentBO;
    }

    public void setProfessionSegmentBO(ProfessionSegmentBO professionSegmentBO)
    {
        this.professionSegmentBO = professionSegmentBO;
    }

    public ProfessionSegmentSC getProfessionSegmentSC()
    {
        return professionSegmentSC;
    }

    public void setProfessionSegmentSC(ProfessionSegmentSC professionSegmentSC)
    {
        this.professionSegmentSC = professionSegmentSC;
    }

    public CTS_PROFESSION_SEGMENTVO getProfessionSegmentVO()
    {
        return professionSegmentVO;
    }

    public void setProfessionSegmentVO(CTS_PROFESSION_SEGMENTVO professionSegmentVO)
    {
        this.professionSegmentVO = professionSegmentVO;
    }


}
