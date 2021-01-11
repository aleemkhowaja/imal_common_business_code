package com.path.dao.common.reservedcif;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.common.reservedcif.ReservedCifSC;

public interface ReservedCifDAO
{
	public List getReservedCifList(ReservedCifSC criteria) throws DAOException;

	public int getReservedCifListCount(ReservedCifSC criteria) throws DAOException;
	
	public int returnReservedCifCount(ReservedCifSC criteria) throws DAOException;
}
