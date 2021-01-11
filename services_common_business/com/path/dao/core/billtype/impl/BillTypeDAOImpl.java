/**
 * @author GhenoieSaab
 * @Date:Jun 6, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.dao.core.billtype.impl;

import java.util.List;

import com.path.dao.core.billtype.BillTypeDAO;
import com.path.dbmaps.vo.CTS_BILL_TYPEVO;
import com.path.dbmaps.vo.CTS_REG_BILL_TYPEVOKey;
import com.path.dbmaps.vo.CTS_SERV_REGVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.billtype.BillTypeCO;
import com.path.vo.core.billtype.BillTypeSC;

public class BillTypeDAOImpl extends BaseDAO implements BillTypeDAO
{
    public int billTypeListCount(BillTypeSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "billTypeMapper.billTypeListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("billTypeMapper.billTypeListCount", criteria)).intValue();
	return nb;
    }

    public List billTypeList(BillTypeSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("billTypeMapper.billTypeList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "billTypeMapper.billTypeListMap");
	    return getSqlMap().queryForList("billTypeMapper.billTypeList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    public CTS_BILL_TYPEVO returnBillTypeById(BillTypeSC criteria) throws DAOException
    {
	return (CTS_BILL_TYPEVO) getSqlMap().queryForObject("billTypeMapper.returnBillTypeById", criteria);
    }

    @Override
    public CTS_BILL_TYPEVO returnBillTypeNameById(BillTypeSC criteria) throws DAOException
    {
	return (CTS_BILL_TYPEVO) getSqlMap().queryForObject("billTypeMapper.returnBillTypeNameById", criteria);
    }

    @Override
    public List billTypeListAll(BillTypeSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("billTypeMapper.billTypeListMap", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "billTypeMapper.billTypeListMap");
	    return getSqlMap().queryForList("billTypeMapper.allBillTypeList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    @Override
    public int billTypeListAllCount(BillTypeSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "billTypeMapper.billTypeListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("billTypeMapper.allBillTypeListCount", criteria)).intValue();
	return nb;
    }

    @Override
    public List<CTS_REG_BILL_TYPEVOKey> getCtsRegBillTypeDetail(CTS_REG_BILL_TYPEVOKey cTSREGBILLTYPEVOKey)
	    throws DAOException
    {
	return (List<CTS_REG_BILL_TYPEVOKey>) getSqlMap().queryForList("billTypeMapper.getCtsRegBillTypeDetail",
		cTSREGBILLTYPEVOKey);
    }

    @Override
    public List<CTS_BILL_TYPEVO> getCtsRegBillTypeList( BillTypeSC billTypeSC)
	    throws DAOException
    {
	return (List<CTS_BILL_TYPEVO>) getSqlMap().queryForList("billTypeMapper.getCtsRegBillTypeList",
		billTypeSC);
    }

    @Override
    public List<String> getCtsBillTypeRefPrefix(BillTypeSC billTypeSC) throws DAOException
    {
	return (List<String>) getSqlMap().queryForList("billTypeMapper.getCtsBillTypeRefPrefix",
		billTypeSC);
    }

    @Override
    public List<BillTypeCO> getBillTypeLst(BillTypeSC billTypeSC) throws DAOException
    {
	return (List<BillTypeCO>) getSqlMap().queryForList("billTypeMapper.getBillTypeLst",
		billTypeSC);
    }

    @Override
    public List<CTS_BILL_TYPEVO> returnBillTypeLst(BillTypeSC criteria) throws DAOException
    {
	return (List<CTS_BILL_TYPEVO>) getSqlMap().queryForList("billTypeMapper.returnBillTypeLst", criteria);
    }
    
    public Integer returnBillPaymentListCount(BillTypeSC criteria) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("billTypeMapper.returnBillPaymentListCount", criteria);
    }

    public List<CTS_SERV_REGVO> returnBillPaymentList(BillTypeSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("billTypeMapper.billTypeListMap", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "billTypeMapper.returnBillPaymentListMap");
	    return getSqlMap().queryForList("billTypeMapper.returnBillPaymentList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
}
