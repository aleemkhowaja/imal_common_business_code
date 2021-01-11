/**
 * @Auther:MarwanMaddah
 * @Date:Mar 2, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.bo.core.account;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.AMFVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.account.AccountCO;
import com.path.vo.core.account.AccountSC;

/**
 * @author MarwanMaddah
 * 
 */
public interface AccountBO
{
    public int accountListCount(AccountSC criteria) throws BaseException;
    public List accountList(AccountSC criteria) throws BaseException;
    public AMFVO checkAccountValidation(AccountSC criteria) throws BaseException;
    public AMFVO returnAccountByReference(AccountSC criteria) throws BaseException;
    public AMFVO returnAMFBySLNo(AccountSC criteria) throws BaseException;
    public int cifRelatedAccountListCount(AccountSC criteria) throws BaseException;
    public List cifRelatedAccountList(AccountSC criteria) throws BaseException;
    public int accountNumberListCount(AccountSC criteria) throws BaseException;
    public List accountNumberList(AccountSC criteria) throws BaseException;
    public int checkAccountNumber(AccountSC criteria)throws BaseException;
    public AccountCO returnAMFDetails(AccountSC criteria) throws BaseException;
    public int getAccountsListCount(AccountSC criteria) throws BaseException;
    public List getAccountsList(AccountSC criteria) throws BaseException;
    public AMFVO validateBySlNo(AccountSC criteria) throws BaseException;
    public List<AMFVO> checkAccountInAMF(AccountSC criteria) throws BaseException;
    public List<AMFVO> returnAMFByCIFSUBNO(AccountSC criteria) throws BaseException;
    public AccountCO returnAMFByAddRef(AccountSC criteria) throws BaseException;
    public AMFVO returnAMFByAddRefList(AccountSC criteria) throws BaseException;
    public String checkAccountStatus(AccountSC criteria,AMFVO amfVO) throws BaseException;
    public AccountCO returnAMFByAccountType(AccountSC criteria) throws BaseException;
    public AccountCO returnTellerAccountByCy(AccountSC criteria) throws BaseException;
    public int accountListCountByBrCyGlCif(AccountSC criteria) throws BaseException;
    public List accountListByBrCyGlCif(AccountSC criteria) throws BaseException;
    public AccountCO returnGlDetailsByBrCyGlCifSlForValidation(AccountSC criteria) throws BaseException;
    public AccountCO retrieveAMFFlagandStatus(AccountCO criteria) throws BaseException;
    public AccountSC returnTrxTypeCriteria(AccountSC criteria) throws BaseException;
    public List<AMFVO> getAccountList(AccountSC criteria) throws BaseException;
    public List<AMFVO> returnAccountsInAMFByCondition(AccountSC criteria) throws BaseException;
    public boolean verifyCifAllowedToDebitOrCredit(AccountSC criteria)throws BaseException;
    public int checkBranchExistsInAMF(AccountSC criteria) throws DAOException;
    public int returnAccountsDataFromW_cif_accounts1_ListCount(AccountSC criteria) throws BaseException;
    public List returnAccountsDataFromW_cif_accounts1_List(AccountSC criteria) throws BaseException;
    public int accountsDataBDCListCount(AccountSC criteria) throws BaseException;
    public List accountsDataBDCList(AccountSC criteria) throws BaseException;
    public AMFVO returnAccountsDataBDC(AccountSC criteria) throws DAOException;
    public int deductFromAccountCount(AccountSC criteria) throws DAOException;
    public List<AccountCO> deductFromAccountList(AccountSC criteria) throws DAOException;
    public int getAMFReportCompBranchLkpListCount(AccountSC criteria) throws BaseException;
    public List<AccountCO> getAMFReportCompBranchLkpList(AccountSC criteria) throws BaseException;
    //NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
    public BigDecimal countAMFByCIFSUBNO(AccountSC criteria) throws BaseException;
    /**
     * For IIS Covering account Lookup
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<AccountCO> getCoveringAccountsList(AccountSC criteria) throws BaseException;

    public int getCoveringAccountsListCount(AccountSC criteria) throws BaseException;
    public AMFVO returnCardAccount(AccountSC criteria) throws BaseException;
    public int callFillAccRestricted(AccountSC criteria) throws BaseException;
    public AccountSC returnAllAccountList(AccountSC criteria) throws BaseException;
    public AccountSC returnCifRelatedAccountList(AccountSC criteria) throws BaseException;
    public AccountSC returnAccountList(AccountSC criteria) throws BaseException;
    public AccountSC returnAccListByBrCyGlCifList(AccountSC criteria) throws BaseException;
    public List<AMFVO> getAccountListInAMF(AccountSC criteria) throws BaseException;

}
