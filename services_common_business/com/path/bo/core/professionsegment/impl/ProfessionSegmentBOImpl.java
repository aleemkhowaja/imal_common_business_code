package com.path.bo.core.professionsegment.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.professionsegment.ProfessionSegmentBO;
import com.path.dao.core.professionsegment.ProfessionSegmentDAO;
import com.path.dbmaps.vo.CTS_PROFESSION_SEGMENTVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.professioncategory.ProfessionCategorySC;
import com.path.vo.core.professionsegment.ProfessionSegmentSC;


public class ProfessionSegmentBOImpl extends BaseBO implements ProfessionSegmentBO
{
    private ProfessionSegmentDAO professionSegmentDAO;

 
    public List professionSegmentList(ProfessionSegmentSC professionSegmentSC) throws BaseException
    {
	return professionSegmentDAO.professionSegmentList(professionSegmentSC);
    }

    public int professionSegmentListCount(ProfessionSegmentSC professionSegmentSC) throws BaseException
    {
	return professionSegmentDAO.professionSegmentListCount(professionSegmentSC);
    }

    public ProfessionSegmentDAO getProfessionSegmentDAO()
    {
        return professionSegmentDAO;
    }

    public void setProfessionSegmentDAO(ProfessionSegmentDAO professionSegmentDAO)
    {
        this.professionSegmentDAO = professionSegmentDAO;
    }

    public CTS_PROFESSION_SEGMENTVO returnDependencyByProfessionSegment(ProfessionSegmentSC professionSegmentSC) throws BaseException    
    {
	CTS_PROFESSION_SEGMENTVO professionSegmentVO = professionSegmentDAO.returnDependencyByProfessionSegment(professionSegmentSC);
	if(professionSegmentVO == null) 
	{
	    throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "prof_segment_key" });
	}
	return professionSegmentVO;	
    }   
}
