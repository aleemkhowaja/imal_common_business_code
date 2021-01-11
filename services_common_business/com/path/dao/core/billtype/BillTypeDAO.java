/**
 * @author GhenoieSaab
 * @Date:Jun 6, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.dao.core.billtype;

import java.util.List;

import com.path.dbmaps.vo.CTS_BILL_TYPEVO;
import com.path.dbmaps.vo.CTS_REG_BILL_TYPEVOKey;
import com.path.dbmaps.vo.CTS_SERV_REGVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.billtype.BillTypeCO;
import com.path.vo.core.billtype.BillTypeSC;

public interface BillTypeDAO
{
    public int billTypeListCount(BillTypeSC criteria) throws DAOException;

    public List billTypeList(BillTypeSC criteria) throws DAOException;

    public CTS_BILL_TYPEVO returnBillTypeById(BillTypeSC criteria) throws DAOException;

    public int billTypeListAllCount(BillTypeSC criteria) throws DAOException;

    public List billTypeListAll(BillTypeSC criteria) throws DAOException;

    public CTS_BILL_TYPEVO returnBillTypeNameById(BillTypeSC criteria) throws DAOException;

    public List<CTS_REG_BILL_TYPEVOKey> getCtsRegBillTypeDetail(CTS_REG_BILL_TYPEVOKey cTSREGBILLTYPEVOKey)
	    throws DAOException;

    /**
     * @param billTypeSC
     * @return
     */
    public List<CTS_BILL_TYPEVO> getCtsRegBillTypeList(BillTypeSC billTypeSC) throws DAOException;

    /**
     * @param billTypeSC
     * @return
     */
    public List<String> getCtsBillTypeRefPrefix(BillTypeSC billTypeSC) throws DAOException;

    /**
     * @param billTypeSC
     * @return
     */
    public List<BillTypeCO> getBillTypeLst(BillTypeSC billTypeSC) throws DAOException;

    public List<CTS_BILL_TYPEVO> returnBillTypeLst(BillTypeSC criteria) throws DAOException;
    
    public Integer returnBillPaymentListCount(BillTypeSC criteria) throws DAOException;
    public List<CTS_SERV_REGVO> returnBillPaymentList(BillTypeSC criteria) throws DAOException;
}
