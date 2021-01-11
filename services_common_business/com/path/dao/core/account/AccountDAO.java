/**
 * @Auther:MarwanMaddah
 * @Date:Mar 5, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.dao.core.account;

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
public interface AccountDAO
{
    public int accountListCount(AccountSC criteria) throws DAOException;

    public List accountList(AccountSC criteria) throws DAOException;

    public AMFVO checkAccountValidation(AccountSC criteria) throws DAOException;

    public List returnAccountByReference(AccountSC criteria) throws DAOException;

    public AMFVO returnAMFBySLNo(AccountSC criteria) throws DAOException;

    public int cifRelatedAccountListCount(AccountSC criteria) throws DAOException;

    public List cifRelatedAccountList(AccountSC criteria) throws DAOException;

    public int accountNumberListCount(AccountSC criteria) throws DAOException;

    public List accountNumberList(AccountSC criteria) throws DAOException;

    public int checkAccountNumber(AccountSC criteria) throws DAOException;

    public AccountCO returnAMFDetails(AccountSC criteria) throws DAOException;

    public List<AMFVO> checkAccountInAMF(AccountSC criteria) throws DAOException;

    public int getAccountsListCount(AccountSC criteria) throws DAOException;

    public List getAccountsList(AccountSC criteria) throws DAOException;

    public AMFVO validateBySlNo(AccountSC criteria) throws DAOException;

    public List<AMFVO> returnAMFByCIFSUBNO(AccountSC criteria) throws BaseException;

    public AccountCO returnAMFByAddRef(AccountSC criteria) throws DAOException;

    public List<AMFVO> returnAMFByAddRefList(AccountSC criteria) throws DAOException;

    public AccountCO returnAMFByAccountType(AccountSC criteria) throws DAOException;

    public AccountCO returnTellerAccountByCy(AccountSC criteria) throws DAOException;

    public int accountListCountByBrCyGlCif(AccountSC criteria) throws DAOException;

    public List accountListByBrCyGlCif(AccountSC criteria) throws DAOException;

    public AccountCO returnGlDetailsByBrCyGlCifSlForValidation(AccountSC criteria) throws DAOException;

    public AccountCO retrieveAMFFlagandStatus(AccountCO criteria) throws DAOException;

    public String verifyCifAllowedToDebitOrCredit(AccountSC criteria) throws DAOException;

    public int checkBranchExistsInAMF(AccountSC criteria) throws DAOException;

    public int returnAccountsDataFromW_cif_accounts1_ListCount(AccountSC criteria) throws DAOException;

    public List returnAccountsDataFromW_cif_accounts1_List(AccountSC criteria) throws DAOException;

    public List accountsDataBDCList(AccountSC criteria) throws DAOException;

    public int accountsDataBDCListCount(AccountSC criteria) throws DAOException;

    public AMFVO returnAccountsDataBDC(AccountSC criteria) throws DAOException;

    public int deductFromAccountCount(AccountSC criteria) throws DAOException;

    public List<AccountCO> deductFromAccountList(AccountSC criteria) throws DAOException;

    public List<AccountCO> getAMFReportCompBranchLkpList(AccountSC criteria) throws DAOException;

    public int getAMFReportCompBranchLkpListCount(AccountSC criteria) throws DAOException;

    // NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
    public BigDecimal countAMFByCIFSUBNO(AccountSC criteria) throws DAOException;

    /**
     * To get the Account list count by IIS product class
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public int accountListByProductClassCount(AccountSC criteria) throws DAOException;

    /**
     * To get the Account list by IIS product class
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List accountByProductClassList(AccountSC criteria) throws DAOException;
    
    /**
     * IIS Covering account Lookup 
     * @param criteria
     * @return
     * @throws DAOException
     * @author Ramesh
     */
    public List<AccountCO> getCoveringAccountsList(AccountSC criteria) throws DAOException;

    public int getCoveringAccountsListCount(AccountSC criteria) throws DAOException;
    
    public AMFVO returnCardAccount(AccountSC criteria) throws DAOException;
}
