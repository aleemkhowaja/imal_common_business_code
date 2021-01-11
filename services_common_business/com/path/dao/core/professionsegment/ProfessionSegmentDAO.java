package com.path.dao.core.professionsegment;

import java.util.List;

import com.path.dbmaps.vo.CTS_PROFESSION_SEGMENTVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.professioncategory.ProfessionCategorySC;
import com.path.vo.core.professionsegment.ProfessionSegmentSC;

public interface ProfessionSegmentDAO
{
    public List professionSegmentList(ProfessionSegmentSC professionSegmentSC) throws DAOException;

    public int professionSegmentListCount(ProfessionSegmentSC professionSegmentSC) throws DAOException;

    public CTS_PROFESSION_SEGMENTVO returnDependencyByProfessionSegment(ProfessionSegmentSC professionSegmentSC) throws DAOException;
    
}
