package com.path.bo.common.reservedcif;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.reservedcif.ReservedCifSC;

public interface ReservedCifBO
{
	public List getReservedCifList(ReservedCifSC criteria) throws BaseException;

	public int getReservedCifListCount(ReservedCifSC criteria) throws BaseException;
	
	public int returnReservedCifCount(ReservedCifSC criteria) throws BaseException;
}
