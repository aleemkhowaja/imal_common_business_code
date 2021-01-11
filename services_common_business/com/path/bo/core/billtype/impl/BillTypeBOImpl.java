/**
 * @author GhenoieSaab
 * @Date:June 6, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.bo.core.billtype.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.billtype.BillTypeBO;
import com.path.dao.core.billtype.BillTypeDAO;
import com.path.dbmaps.vo.CTS_BILL_TYPEVO;
import com.path.dbmaps.vo.CTS_REG_BILL_TYPEVOKey;
import com.path.dbmaps.vo.CTS_SERV_REGVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.core.billtype.BillTypeCO;
import com.path.vo.core.billtype.BillTypeSC;
import com.path.vo.core.csmfom.FomBillTypeCO;

public class BillTypeBOImpl extends BaseBO implements BillTypeBO
{
    private BillTypeDAO billTypeDAO;

    public int billTypeListCount(BillTypeSC criteria) throws BaseException
    {
	return billTypeDAO.billTypeListCount(criteria);
    }

    public List billTypeList(BillTypeSC criteria) throws BaseException
    {
	return billTypeDAO.billTypeList(criteria);
    }

    public CTS_BILL_TYPEVO returnBillTypeById(BillTypeSC criteria) throws BaseException
    {
	return billTypeDAO.returnBillTypeById(criteria);
    }

    public BillTypeDAO getBillTypeDAO()
    {
	return billTypeDAO;
    }

    public void setBillTypeDAO(BillTypeDAO billTypeDAO)
    {
	this.billTypeDAO = billTypeDAO;
    }

    @Override
    public CTS_BILL_TYPEVO returnBillTypeNameById(BillTypeSC criteria) throws BaseException
    {
	List<FomBillTypeCO> lst = criteria.getFomBillTypeGrid_lst();
	if(lst != null && !lst.isEmpty())
	{
	    for(int i = 0; i < lst.size() - 1; i++)
	    {
		BigDecimal billType1 = lst.get(i).getCtsRegBillType().getBILL_TYPE();

		for(int j = i + 1; j < lst.size(); j++)
		{
		    BigDecimal billType2 = lst.get(j).getCtsRegBillType().getBILL_TYPE();

		    if(billType1 != null && billType1.equals(billType2))
		    {
			throw new BOException(MessageCodes.BILLTYPE_ALREADY_ASSIGNED_FOR_CIF);
		    }
		}
	    }
	}
	return billTypeDAO.returnBillTypeNameById(criteria);
    }

    @Override
    public List billTypeListAll(BillTypeSC criteria) throws BaseException
    {
	return billTypeDAO.billTypeListAll(criteria);
    }

    @Override
    public int billTypeListAllCount(BillTypeSC criteria) throws BaseException
    {
	return billTypeDAO.billTypeListAllCount(criteria);
    }

    @Override
    public List<CTS_REG_BILL_TYPEVOKey> getCtsRegBillTypeDetail(CTS_REG_BILL_TYPEVOKey CTS_REG_BILL_TYPEVOKey)
	    throws BaseException
    {
	return billTypeDAO.getCtsRegBillTypeDetail(CTS_REG_BILL_TYPEVOKey);
    }

    @Override
    public List<CTS_BILL_TYPEVO> getCtsRegBillTypeList(BillTypeSC billTypeSC) throws BaseException
    {
	return billTypeDAO.getCtsRegBillTypeList(billTypeSC);
    }

    @Override
    public List<String> getCtsBillTypeRefPrefix(BillTypeSC billTypeSC) throws BaseException
    {
	return billTypeDAO.getCtsBillTypeRefPrefix(billTypeSC);
    }

    @Override
    public List<BillTypeCO> getBillTypeLst(BillTypeSC billTypeSC) throws BaseException
    {
	return billTypeDAO.getBillTypeLst(billTypeSC);
    }

    /**
     * @author EliasAoun 15/11/2013
     * @Description this method validate the reference set by user based on some
     *              conditions
     * @param BillTypeCO / opt "REF", "UTIL"
     */
    public BillTypeCO validateProviderReference(BillTypeCO billTypeCO) throws BaseException
    {
	BillTypeSC billTypeSC = new BillTypeSC();
	billTypeSC.setCompCode(billTypeCO.getLoginCompCode());
	billTypeSC.setBillType(billTypeCO.getBillType());
	billTypeSC.setCifNo(billTypeCO.getCifNo());
	billTypeSC.setSectionKey(billTypeCO.getOpt());
	List<BillTypeCO> billTypeCOLst = getBillTypeLst(billTypeSC);

	int cnt = 0;
	boolean valid = true;
	String soReference = "";
	if(StringUtil.isNotEmpty(billTypeCO.getReference()))
	{
	    soReference = billTypeCO.getReference();
	}

	StringBuffer param = new StringBuffer();
	if(billTypeCOLst != null)
	{
	    for(int i = 0; i < billTypeCOLst.size(); i++)
	    {
		if(StringUtil.isNotEmpty(billTypeCOLst.get(i).getStartWith()))
		{
		    valid = false;
		    break;
		}
	    }
	}
	for(int i = 0; i < billTypeCOLst.size(); i++)
	{
	    String startWith = billTypeCOLst.get(i).getStartWith();
	    if(StringUtil.isNotEmpty(startWith))
	    {
		if(soReference.startsWith(startWith))
		{
		    valid = true;
		    break;
		}
		else
		{
		    cnt++;
		    if(cnt == 1)
		    {
			param.append(startWith);
		    }
		    else
		    {
			param.append(" or ").append( startWith);
		    }
		}
	    }
	}
	if(!valid)
	{
	    throw new BOException(MessageCodes.REFERENCE_MUST_START_WITH, new String[] { param.toString() });
	}
	if(!NumberUtil.isNumber(soReference) && "N".equals(billTypeCO.getRefFieldType()))
	{
	    throw new BOException(MessageCodes.REFERENCE_MAY_CONTAINS_NUMBER_ONLY);
	}
	else if(!StringUtil.isAlpha(soReference, false) && "A".equals(billTypeCO.getRefFieldType()))
	{
	    throw new BOException(MessageCodes.REFERENCE_MAY_CONTAIN_ALPHA_CHAR_ONLY);
	}
	if("M".equals(billTypeCO.getRefMinMax()))
	{
	    if(soReference.length() < billTypeCO.getRefFieldLength().intValue())
	    {
		throw new BOException(MessageCodes.REFERENCE_MUST_HAVE_MIN_LENGTH, new String[] { billTypeCO
			.getRefFieldLength().toString() });
	    }
	}
	else if("X".equals(billTypeCO.getRefMinMax()))
	{
	    if(soReference.length() > billTypeCO.getRefFieldLength().intValue())
	    {
		throw new BOException(MessageCodes.REFERENCE_MUST_HAVE_MAX_LENGTH, new String[] { billTypeCO
			.getRefFieldLength().toString() });
	    }
	}
	else if("A".equals(billTypeCO.getRefMinMax())
	
	    &&soReference.length() != billTypeCO.getRefFieldLength().intValue())
	    {
		throw new BOException(MessageCodes.REFERENCE_MUST_LENGTH_EQUAL, new String[] { billTypeCO
			.getRefFieldLength().toString() });
	    }
	
	return billTypeCO;
    }

    @Override
    public List<CTS_BILL_TYPEVO> returnBillTypeLst(BillTypeSC criteria) throws BaseException
    {
	return billTypeDAO.returnBillTypeLst(criteria);
    }

    /**
     * @author RaniaAlBitar
     * Bug #829901
     * @param criteria
     * @return
     * @throws BaseException
     */
    
    public Integer returnBillPaymentListCount(BillTypeSC criteria) throws BaseException
    {
	return billTypeDAO.returnBillPaymentListCount(criteria);
    }

    /**
     * @author RaniaAlBitar
     * Bug #829901
     * @param criteria
     * @return
     * @throws BaseException
     */
    
    public List<CTS_SERV_REGVO> returnBillPaymentList(BillTypeSC criteria) throws BaseException
    {
	return billTypeDAO.returnBillPaymentList(criteria);
    }
}
