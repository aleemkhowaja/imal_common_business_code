package com.path.dao.core.chargesschema.impl;

import java.util.List;

import com.path.dao.core.chargesschema.ChargesSchemaDAO;
import com.path.dbmaps.vo.CTSCHARGES_SCHEMAVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.chargesschema.ChargesSchemaSC;
import com.path.vo.core.csmfom.CTSChargesCO;

public class ChargesSchemaDAOImpl extends BaseDAO implements ChargesSchemaDAO
{

	@Override
	public List chargesSchemaList(ChargesSchemaSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "chargesSchemaMapper.chargesSchemaListMap");
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("chargesSchemaMapper.chargesSchemaList", criteria);
		}
		else
		{
		    return getSqlMap().queryForList("chargesSchemaMapper.chargesSchemaList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int chargesSchemaListCount(ChargesSchemaSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "chargesSchemaMapper.chargesSchemaListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("chargesSchemaMapper.chargesSchemaListCount", criteria)).intValue();
		return nb;
	}

	public CTSCHARGES_SCHEMAVO returnDependencyByCode(ChargesSchemaSC criteria) throws DAOException
	{
	    //DAOHelper.fixGridMaps(criteria, getSqlMap(), "chargesSchemaMapper.chargesSchemaListMap");
	    return (CTSCHARGES_SCHEMAVO)getSqlMap().queryForObject("chargesSchemaMapper.returnDependencyByCode", criteria);
	}

	@Override
	public CTSCHARGES_SCHEMAVO returnChargesSchemaDetailByCode(ChargesSchemaSC criteria) throws DAOException
	{
		return (CTSCHARGES_SCHEMAVO)getSqlMap().queryForObject("chargesSchemaMapper.returnChargesSchemaDetailByCode", criteria);
	}
	
	@Override
	public List trxChargesSchemaList(ChargesSchemaSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "CTSCHARGES_SCHEMA.BaseResultMap");
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("chargesSchemaMapper.trxChargesSchemaList", criteria);
		}
		else
		{
		    return getSqlMap().queryForList("chargesSchemaMapper.trxChargesSchemaList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int trxChargesSchemaListCount(ChargesSchemaSC criteria) throws DAOException
	{
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("chargesSchemaMapper.trxChargesSchemaListCount", criteria)).intValue();
		return nb;
	}

	@Override
	public List maintenenceChargesList(ChargesSchemaSC criteria)
			throws DAOException {
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "CTSCHARGES_ROSTER.BaseResultMap");
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("chargesSchemaMapper.maintenenceChargesList", criteria);
		}
		else
		{
		    return getSqlMap().queryForList("chargesSchemaMapper.maintenenceChargesList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int maintenenceChargesListCount(ChargesSchemaSC criteria)
			throws DAOException {
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("chargesSchemaMapper.maintenenceChargesListCount", criteria)).intValue();
		return nb;
	}

	@Override
	public List excemptedInBranchesList(ChargesSchemaSC criteria)
			throws DAOException {
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "CTSCHARGES_EXEMPTED_BRANCH.BaseResultMap");
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("chargesSchemaMapper.excemptedInBranchesList", criteria);
		}
		else
		{
		    return getSqlMap().queryForList("chargesSchemaMapper.excemptedInBranchesList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int excemptedInBranchesListCount(ChargesSchemaSC criteria)
			throws DAOException {
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("chargesSchemaMapper.excemptedInBranchesListCount", criteria)).intValue();
		return nb;
	}

	@Override
	public CTSChargesCO returnChargesDetailByCode(ChargesSchemaSC criteria)
			throws DAOException {
		return (CTSChargesCO)getSqlMap().queryForObject("chargesSchemaMapper.returnChargesDetailByCode", criteria);
	}

	@Override
	public List chargesSchemaForeignCYChargeList(ChargesSchemaSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "chargesSchemaMapper.ctsChargesCurrencyListMap");
		if(criteria.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("chargesSchemaMapper.chargesSchemaForeignCYChargeList", criteria);
		}
		else
		{
		    return getSqlMap().queryForList("chargesSchemaMapper.chargesSchemaForeignCYChargeList", criteria, criteria.getRecToskip(),
			    criteria.getNbRec());
		}
	}

	@Override
	public int chargesSchemaForeignCYChargeListCount(ChargesSchemaSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "chargesSchemaMapper.ctsChargesCurrencyListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("chargesSchemaMapper.chargesSchemaForeignCYChargeListCount", criteria)).intValue();
		return nb;
	}
	
	//829186 Customers Segmentation Enhancement
	public int isRosterChanged(ChargesSchemaSC criteria) throws DAOException
	{
	    return ((Integer) getSqlMap().queryForObject("chargesSchemaMapper.isRosterChanged", criteria)).intValue();
		  
	}
	public int isCurrencyChanged(ChargesSchemaSC criteria) throws DAOException
	{
	    return ((Integer) getSqlMap().queryForObject("chargesSchemaMapper.isCurrencyChanged", criteria)).intValue();
		  
	}
	@Override
	public CTSChargesCO returnSegChargesDetailByCode(ChargesSchemaSC criteria)
			throws DAOException {
		return (CTSChargesCO)getSqlMap().queryForObject("chargesSchemaMapper.returnSegChargesDetailByCode", criteria);
	}
	//829186 Customers Segmentation Enhancement
}
