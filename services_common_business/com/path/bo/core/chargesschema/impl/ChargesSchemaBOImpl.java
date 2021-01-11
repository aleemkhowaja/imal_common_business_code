package com.path.bo.core.chargesschema.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.chargesschema.ChargesSchemaBO;
import com.path.dao.core.chargesschema.ChargesSchemaDAO;
import com.path.dbmaps.vo.CTSCHARGES_SCHEMAVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.StringUtil;
import com.path.vo.core.chargesschema.ChargesSchemaSC;
import com.path.vo.core.csmfom.CTSChargesCO;

public class ChargesSchemaBOImpl extends BaseBO implements ChargesSchemaBO
{
	private ChargesSchemaDAO chargesSchemaDAO;
	@Override
	public List chargesSchemaList(ChargesSchemaSC criteria) throws BaseException
	{
		return chargesSchemaDAO.chargesSchemaList(criteria);
	}

	@Override
	public int chargesSchemaListCount(ChargesSchemaSC criteria) throws BaseException
	{
		return chargesSchemaDAO.chargesSchemaListCount(criteria);
	}

	public ChargesSchemaDAO getChargesSchemaDAO()
	{
		return chargesSchemaDAO;
	}

	public void setChargesSchemaDAO(ChargesSchemaDAO chargesSchemaDAO)
	{
		this.chargesSchemaDAO = chargesSchemaDAO;
	}

	public CTSCHARGES_SCHEMAVO returnDependencyByCode(ChargesSchemaSC criteria) throws BaseException
	{
	    CTSCHARGES_SCHEMAVO chargesSchemaVO =(CTSCHARGES_SCHEMAVO) chargesSchemaDAO.returnDependencyByCode(criteria);
	    
    	    if(chargesSchemaVO == null && "true".equals(StringUtil.nullToEmpty(criteria.getShowMessage())))
            {
    		throw new BOException(MessageCodes.INVALID_CODE);
            }
	    return chargesSchemaVO;
	}

	@Override
	public CTSCHARGES_SCHEMAVO returnChargesSchemaDetailByCode(ChargesSchemaSC criteria) throws BaseException
	{
		return chargesSchemaDAO.returnChargesSchemaDetailByCode(criteria);
	}

	public List trxChargesSchemaList(ChargesSchemaSC criteria) throws BaseException
	{
		return chargesSchemaDAO.trxChargesSchemaList(criteria);
	}

	@Override
	public int trxChargesSchemaListCount(ChargesSchemaSC criteria) throws BaseException
	{
		return chargesSchemaDAO.trxChargesSchemaListCount(criteria);
	}

	@Override
	public List maintenenceChargesList(ChargesSchemaSC criteria)
			throws BaseException {
		return chargesSchemaDAO.maintenenceChargesList(criteria);
	}

	@Override
	public int maintenenceChargesListCount(ChargesSchemaSC criteria)
			throws BaseException {
		return chargesSchemaDAO.maintenenceChargesListCount(criteria);
	}

	@Override
	public List excemptedInBranchesList(ChargesSchemaSC criteria)
			throws BaseException {
		return chargesSchemaDAO.excemptedInBranchesList(criteria);
	}

	@Override
	public int excemptedInBranchesListCount(ChargesSchemaSC criteria)
			throws BaseException {
		return chargesSchemaDAO.excemptedInBranchesListCount(criteria);

	}

	@Override
	public CTSChargesCO returnChargesDetailByCode(ChargesSchemaSC criteria)
			throws BaseException {
		return chargesSchemaDAO.returnChargesDetailByCode(criteria);
	}

	@Override
	public List chargesSchemaForeignCYChargeList(ChargesSchemaSC criteria) throws BaseException
	{
		return chargesSchemaDAO.chargesSchemaForeignCYChargeList(criteria);
	}

	@Override
	public int chargesSchemaForeignCYChargeListCount(ChargesSchemaSC criteria) throws BaseException
	{
		return chargesSchemaDAO.chargesSchemaForeignCYChargeListCount(criteria);
	}

}
