/**
 * @Auther:MarwanMaddah
 * @Date:Mar 5, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.dao.core.account.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.dao.core.account.AccountDAO;
import com.path.dbmaps.vo.AMFVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.lib.common.util.StringUtil;
import com.path.vo.core.account.AccountCO;
import com.path.vo.core.account.AccountSC;

/**
 * @author MarwanMaddah
 * 
 */
public class AccountDAOImpl extends BaseDAO implements AccountDAO
{
    /**
     * sql map to get the count of the account list based on a defined criteria
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public int accountListCount(AccountSC criteria) throws DAOException
    {

	DAOHelper.fixGridMaps(criteria, getSqlMap(), "accountMapper.accountListMap");
	if(StringUtil.nullToEmpty(criteria.getWhereQuery()).contains("CIF_SUB_NO"))
	    {
		criteria.setSubsidiarySearch(true);
	    }
	return ((Integer) getSqlMap().queryForObject("accountMapper.accountListCount", criteria)).intValue();
    }

    /**
     * sql map to get the account list based on a defined criteria
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List accountList(AccountSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("accountMapper.accountList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "accountMapper.accountListMap");
	    
	    if(StringUtil.nullToEmpty(criteria.getWhereQuery()).contains("CIF_SUB_NO"))
	    {
		criteria.setSubsidiarySearch(true);
	    }
	    return getSqlMap().queryForList("accountMapper.accountList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    /**
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public AMFVO checkAccountValidation(AccountSC criteria) throws DAOException
    {
	return (AMFVO) getSqlMap().queryForObject("accountMapper.checkAccountValidation", criteria);
    }

    /**
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List returnAccountByReference(AccountSC criteria) throws DAOException
    {/*Bug # 338150 -- [John Massaad] raising a BOException when we have duplicate Additional Reference 
	 for two different accounts raither than static message with DAOException*/
	return getSqlMap().queryForList("accountMapper.returnAccountByReference", criteria);
    }

    public AMFVO returnAMFBySLNo(AccountSC criteria) throws DAOException
    {
	return (AMFVO) getSqlMap().queryForObject("accountMapper.returnAMFBySLNo", criteria);
    }

    @Override
    public List cifRelatedAccountList(AccountSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("accountMapper.cifRelatedAccountList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "AMF.BaseResultMap");
	    return getSqlMap().queryForList("accountMapper.cifRelatedAccountList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    @Override
    public int cifRelatedAccountListCount(AccountSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "AMF.BaseResultMap");
	return ((Integer) getSqlMap().queryForObject("accountMapper.cifRelatedAccountListCount", criteria)).intValue();
    }

    public List accountNumberList(AccountSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("accountMapper.accountNumberList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "AMF.BaseResultMap");
	    return getSqlMap().queryForList("accountMapper.accountNumberList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    public int accountNumberListCount(AccountSC criteria) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("accountMapper.accountNumberListCount", criteria)).intValue();
    }

    public int checkAccountNumber(AccountSC criteria) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("accountMapper.checkAccountNumberCount", criteria)).intValue();
    }

    public AccountCO returnAMFDetails(AccountSC criteria) throws DAOException
    {
	return ((AccountCO) getSqlMap().queryForObject("accountMapper.returnAMFDetails", criteria));
    }

    public List<AMFVO> checkAccountInAMF(AccountSC criteria) throws DAOException
    {
	return getSqlMap().queryForList("accountMapper.checkAccountInAMF", criteria);
    }

    @Override
    public List getAccountsList(AccountSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("accountMapper.selectAccountsList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "accountMapper.getAccountsListMap");
	    if(StringUtil.nullToEmpty(criteria.getWhereQuery()).contains("CIF_SUB_NO"))
	    {
		criteria.setSubsidiarySearch(true);
	    }
	    return getSqlMap().queryForList("accountMapper.selectAccountsList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    @Override
    public int getAccountsListCount(AccountSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "accountMapper.getAccountsListMap");
	if(StringUtil.nullToEmpty(criteria.getWhereQuery()).contains("CIF_SUB_NO"))
	{
	    criteria.setSubsidiarySearch(true);
	}
	return ((Integer) getSqlMap().queryForObject("accountMapper.selectAccountsListCount", criteria)).intValue();
    }

    @Override
    public AMFVO validateBySlNo(AccountSC criteria) throws DAOException
    {
	return (AMFVO) getSqlMap().queryForObject("accountMapper.selectValidateSLNo", criteria);
    }

    public List<AMFVO> returnAMFByCIFSUBNO(AccountSC criteria) throws DAOException
    {
	return getSqlMap().queryForList("accountMapper.returnAMFByCIFSUBNO", criteria);
    }

    // NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
    public BigDecimal countAMFByCIFSUBNO(AccountSC criteria) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("accountMapper.countAMFByCIFSUBNO", criteria);
    }

    public AccountCO returnAMFByAddRef(AccountSC criteria) throws DAOException
    {
	AccountCO accountCO = new AccountCO();
	accountCO.setAmfVO((AMFVO) getSqlMap().queryForObject("accountMapper.returnAMFByAddRef", criteria));
	return accountCO;
    }

    /**
     * @Desc this method is added to handle the case where same
     *       ADDITIONAL_REFERENCE is linked to more than one account
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List<AMFVO> returnAMFByAddRefList(AccountSC criteria) throws DAOException
    {
	return getSqlMap().queryForList("accountMapper.returnAMFByAddRef", criteria);
    }

    public AccountCO returnAMFByAccountType(AccountSC criteria) throws DAOException
    {
	return ((AccountCO) getSqlMap().queryForObject("accountMapper.returnAMFByAccountType", criteria));
    }

    public AccountCO returnTellerAccountByCy(AccountSC criteria) throws DAOException
    {
	return ((AccountCO) getSqlMap().queryForObject("accountMapper.returnTellerAccountByCy", criteria));
    }

    @Override
    public List accountListByBrCyGlCif(AccountSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("accountMapper.accountListByBrCyGlCif", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "accountMapper.getAccountsListMap");
	    return getSqlMap().queryForList("accountMapper.accountListByBrCyGlCif", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    @Override
    public int accountListCountByBrCyGlCif(AccountSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "accountMapper.getAccountsListMap");
	return ((Integer) getSqlMap().queryForObject("accountMapper.accountListCountByBrCyGlCif", criteria)).intValue();
    }

    @Override
    public AccountCO returnGlDetailsByBrCyGlCifSlForValidation(AccountSC criteria) throws DAOException
    {
	return ((AccountCO) getSqlMap().queryForObject("accountMapper.returnGlDetailsByBrCyGlCifSlForValidation",
		criteria));
    }

    public AccountCO retrieveAMFFlagandStatus(AccountCO criteria) throws DAOException
    {
	return ((AccountCO) getSqlMap().queryForObject("accountMapper.retrieveAMFFlagandStatus", criteria));
    }

    /****
     * Method for verifying the CIF is allowed to Debt or Credit
     */
    public String verifyCifAllowedToDebitOrCredit(AccountSC criteria) throws DAOException
    {
	return StringUtil.nullToEmpty(getSqlMap().queryForObject("accountMapper.selectCifAllowedForCrDr", criteria));
    }

    public int checkBranchExistsInAMF(AccountSC criteria) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("accountMapper.checkBranchExistsInAMF", criteria)).intValue();
    }

    @Override
    public List returnAccountsDataFromW_cif_accounts1_List(AccountSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("accountMapper.accountsDataFromW_cif_accounts1_List", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "accountMapper.cardRelatedAccountsListMap");
	    return getSqlMap().queryForList("accountMapper.accountsDataFromW_cif_accounts1_List", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    public int deductFromAccountCount(AccountSC criteria) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("accountMapper.deductFromAccountCount", criteria)).intValue();
    }

    public List<AccountCO> deductFromAccountList(AccountSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("accountMapper.deductFromAccountList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "accountMapper.accountListMap");
	    return getSqlMap().queryForList("accountMapper.deductFromAccountList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    @Override
    public int returnAccountsDataFromW_cif_accounts1_ListCount(AccountSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "accountMapper.cardRelatedAccountsListMap");
	return ((Integer) getSqlMap().queryForObject("accountMapper.accountsDataFromW_cif_accounts1_ListCount",
		criteria)).intValue();
    }

    public List accountsDataBDCList(AccountSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("accountMapper.accountsDataBDCList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "AMF.BaseResultMap");
	    return getSqlMap().queryForList("accountMapper.accountsDataBDCList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    public int accountsDataBDCListCount(AccountSC criteria) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("accountMapper.accountsDataBDCListCount", criteria)).intValue();
    }

    public AMFVO returnAccountsDataBDC(AccountSC criteria) throws DAOException
    {
	return (AMFVO) getSqlMap().queryForObject("accountMapper.accountsDataBDC", criteria);
    }

    @Override
    public int getAMFReportCompBranchLkpListCount(AccountSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "accountMapper.accountListMap");
	if(StringUtil.nullToEmpty(criteria.getWhereQuery()).contains("CIF_SUB_NO"))
	{
	    criteria.setSubsidiarySearch(true);
	}
	return (Integer) getSqlMap().queryForObject("accountMapper.getAMFReportCompBranchLkpListCount", criteria);
    }

    @Override
    public List<AccountCO> getAMFReportCompBranchLkpList(AccountSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("accountMapper.getAMFReportCompBranchLkpList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "accountMapper.accountListMap");
	    if(StringUtil.nullToEmpty(criteria.getWhereQuery()).contains("CIF_SUB_NO"))
	    {
		criteria.setSubsidiarySearch(true);
	    }
	    return getSqlMap().queryForList("accountMapper.getAMFReportCompBranchLkpList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    /**
     * @author Saheer.Naduthodi
     * 
     *         sql map to get the count of the account list based on a product
     *         class
     * @param criteria
     * @return
     * @throws DAOException
     */
    public int accountListByProductClassCount(AccountSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "accountMapper.accountListMap");
	return ((Integer) getSqlMap().queryForObject("accountMapper.accountListByProductClassCount", criteria))
		.intValue();
    }

    /**
     * @author Saheer.Naduthodi
     * 
     *         sql map to get the account list based on a product class
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List accountByProductClassList(AccountSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("accountMapper.accountByProductClassList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "accountMapper.accountListMap");
	    return getSqlMap().queryForList("accountMapper.accountByProductClassList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }
    
    /**
     * for IIS covering account Lookup
     * @author Ramesh
     */
    public List<AccountCO> getCoveringAccountsList(AccountSC criteria) throws DAOException
    {
      if(criteria.getNbRec() == -1)
      {
          return getSqlMap().queryForList("accountMapper.getCoveringAccountsList", criteria);
      }
      else
      {
          DAOHelper.fixGridMaps(criteria, getSqlMap(), "accountMapper.getAccountsListMap");
          return getSqlMap().queryForList("accountMapper.getCoveringAccountsList", criteria, criteria.getRecToskip(),
                criteria.getNbRec());
      }
    }

    @Override
    public int getCoveringAccountsListCount(AccountSC criteria) throws DAOException
    {
      DAOHelper.fixGridMaps(criteria, getSqlMap(), "accountMapper.getAccountsListMap");
      return ((Integer) getSqlMap().queryForObject("accountMapper.selectCoveringAccountsListCount", criteria))
            .intValue();
    }
    @Override
    public AMFVO returnCardAccount(AccountSC criteria) throws DAOException
    {
	return (AMFVO) getSqlMap().queryForObject("accountMapper.returnCardAccount", criteria);
    }

    
}
