package com.path.bo.core.professionsegment;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.dbmaps.vo.CTS_PROFESSION_SEGMENTVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.professionsegment.ProfessionSegmentSC;

public interface ProfessionSegmentBO
{
    public int professionSegmentListCount(ProfessionSegmentSC professionSegmentSC) throws BaseException;

    public List professionSegmentList(ProfessionSegmentSC professionSegmentSC) throws BaseException;

    public CTS_PROFESSION_SEGMENTVO returnDependencyByProfessionSegment(ProfessionSegmentSC professionSegmentSC) throws BaseException;      
}
