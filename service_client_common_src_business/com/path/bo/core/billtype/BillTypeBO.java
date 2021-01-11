/**
 * @author GhenoieSaab
 * @Date:Jun 6, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.bo.core.billtype;

import java.util.List;

import com.path.dbmaps.vo.CTS_BILL_TYPEVO;
import com.path.dbmaps.vo.CTS_REG_BILL_TYPEVOKey;
import com.path.dbmaps.vo.CTS_SERV_REGVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.billtype.BillTypeCO;
import com.path.vo.core.billtype.BillTypeSC;

public interface BillTypeBO
{
    public int billTypeListCount(BillTypeSC criteria) throws BaseException;

    public List billTypeList(BillTypeSC criteria) throws BaseException;

    public CTS_BILL_TYPEVO returnBillTypeById(BillTypeSC criteria) throws BaseException;

    public int billTypeListAllCount(BillTypeSC criteria) throws BaseException;

    public List billTypeListAll(BillTypeSC criteria) throws BaseException;

    public CTS_BILL_TYPEVO returnBillTypeNameById(BillTypeSC criteria) throws BaseException;

    /**
     * @author EliasAoun
     * @param #{COMP_CODE}, #{CIF_NO}, #{CY_CODE}, #{BILL_TYPE}
     * @return List<CTS_REG_BILL_TYPEVOKey>
     * @throws BaseException
     */
    public List<CTS_REG_BILL_TYPEVOKey> getCtsRegBillTypeDetail(CTS_REG_BILL_TYPEVOKey CTS_REG_BILL_TYPEVOKey)
	    throws BaseException;

    /**
     * @param billTypeSC
     * @return
     */
    public List<CTS_BILL_TYPEVO> getCtsRegBillTypeList(BillTypeSC billTypeSC) throws BaseException;

    /**
     * @param billTypeSC
     * @return
     */
    public List<String> getCtsBillTypeRefPrefix(BillTypeSC billTypeSC) throws BaseException;

    /**
     * @author EliasAoun 15/11/2013
     * @param billTypeSC
     * @return
     * @throws BaseException
     */
    public List<BillTypeCO> getBillTypeLst(BillTypeSC billTypeSC) throws BaseException;

    /**
     * @author EliasAoun 15/11/2013
     * @param billTypeSC
     * @return
     * @throws BaseException
     */
    public BillTypeCO validateProviderReference(BillTypeCO billTypeCO) throws BaseException;

    public List<CTS_BILL_TYPEVO> returnBillTypeLst(BillTypeSC criteria) throws BaseException;
    
    public Integer returnBillPaymentListCount(BillTypeSC criteria) throws BaseException;
    public List<CTS_SERV_REGVO> returnBillPaymentList(BillTypeSC criteria) throws BaseException;

}