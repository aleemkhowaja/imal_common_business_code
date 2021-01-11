package com.path.vo.core.segmentation;

import java.math.BigDecimal;
import com.path.struts2.lib.common.GridParamsSC;

public class ExcludeCIFSC extends GridParamsSC
{
	private BigDecimal segment_code;
	private BigDecimal cif_no;
	private String segmentType; //Rania - 718813 - Dynamic Customer Scoring on latest
	
	public BigDecimal getSegment_code()
	{
		return segment_code;
	}

	public void setSegment_code(BigDecimal segmentCode)
	{
		segment_code = segmentCode;
	}

	public BigDecimal getCif_no()
	{
		return cif_no;
	}

	public void setCif_no(BigDecimal cifNo)
	{
		cif_no = cifNo;
	}

	
	public String getSegmentType()
	{
		return segmentType;
	}

	
	public void setSegmentType(String segmentType)
	{
		this.segmentType = segmentType;
	}
}
