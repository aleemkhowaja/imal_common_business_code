/**
 * @Auther:ElieHaber
 * @Date:Apr 1, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.bo.core.cheque;

import java.util.List;

import com.path.dbmaps.vo.CTSCHEQUESVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cheque.ChequeCO;
import com.path.vo.core.cheque.ChequeSC;

public interface ChequeBO
{
    public List chequesLkpRecords(ChequeSC criteria) throws BaseException;
    public int  chequesLkpCount(ChequeSC criteria) throws BaseException;
    public ChequeCO loadChequeRequestByCode(ChequeCO cheque) throws BaseException;
    public CTSCHEQUESVO returnDefaultedChequeByCifTypeCode(ChequeSC criteria) throws BaseException;
    public CTSCHEQUESVO returnDefaultedBillByCifTypeCode (ChequeSC criteria) throws BaseException;
}
