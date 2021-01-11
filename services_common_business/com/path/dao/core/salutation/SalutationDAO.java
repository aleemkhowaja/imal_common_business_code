package com.path.dao.core.salutation;

import java.util.List;

import com.path.dbmaps.vo.CIVIL_CODESVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.salutation.SalutationSC;

public interface SalutationDAO
{
	public int salutationListCount(SalutationSC criteria) throws DAOException;
	public List salutationList(SalutationSC criteria) throws DAOException;
	public CIVIL_CODESVO returnSalutationById(SalutationSC criteria) throws DAOException;
	public int checkSalutationExistance(SalutationSC criteria) throws DAOException;
	public int checkSalutExistByCifType(SalutationSC criteria) throws DAOException;
}
