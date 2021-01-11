package com.path.dao.core.amlcif.impl;

import java.util.List;
import com.path.dao.core.amlcif.AmlCifDAO;
import com.path.dbmaps.vo.AML_CUSTOMERVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.cif.CifSC;

/**
 * @author Nour Choueikani
 * 
 */
public class AmlCifDAOImpl extends BaseDAO implements AmlCifDAO
{

	/**
	 * sql map to get the count of the CIF list based on a defined criteria
	 * 
	 * @param criteria
	 * @return
	 * @throws DAOException
	 */
	public int returnBankCifListCount(CifSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "amlCifMapper.bankCifMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("amlCifMapper.bankCifCount", criteria)).intValue();
		return nb;
	}

	/**
	 * @param criteria
	 * @return
	 * @throws DAOException
	 */
	public List returnBankCIF(CifSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "amlCifMapper.bankCifMap");
		if (criteria.getNbRec() == -1)
		{
			return getSqlMap().queryForList("amlCifMapper.bankCifList", criteria);
		}
		else
		{
			return getSqlMap().queryForList("amlCifMapper.bankCifList", criteria, criteria.getRecToskip(), criteria.getNbRec());
		}

	}

	@Override
	public List returnCIF(CifSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "amlCifMapper.bankCifMap");
		if (criteria.getNbRec() == -1)
		{
			return getSqlMap().queryForList("amlCifMapper.bankCifList", criteria);
		}
		else
		{
			return getSqlMap().queryForList("amlCifMapper.cifList", criteria, criteria.getRecToskip(), criteria.getNbRec());
		}
	}

	@Override
	public int returnCifListCount(CifSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "amlCifMapper.bankCifMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("amlCifMapper.cifCount", criteria)).intValue();
		return nb;
	}
	
	/**
     * sql map to get AML_CUSTOMER based on the cif_no.
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public AML_CUSTOMERVO returnCifByNo(CifSC criteria) throws DAOException
    {
	return (AML_CUSTOMERVO) getSqlMap().queryForObject("amlCifMapper.returnCifByNo", criteria);
    }

}
