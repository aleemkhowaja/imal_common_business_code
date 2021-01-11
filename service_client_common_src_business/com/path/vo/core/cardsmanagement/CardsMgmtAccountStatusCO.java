package com.path.vo.core.cardsmanagement;

import java.util.Date;
import java.util.HashMap;

import com.path.dbmaps.vo.BRANCHESVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSCARDSVO;
import com.path.dbmaps.vo.CTSCARDS_ACCVO;
import com.path.dbmaps.vo.CTSCARDS_MGTVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.GEN_LEDGERVO;
import com.path.dbmaps.vo.RIFCTTVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.core.common.RetailBaseVO;

public class CardsMgmtAccountStatusCO extends RetailBaseVO
{
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private CTSCARDS_MGTVO cardsMgtVO = new CTSCARDS_MGTVO();
    private CTSCARDSVO ctsCardsVO = new CTSCARDSVO();
    private CTSTRXTYPEVO ctsTrxTypeVO = new CTSTRXTYPEVO();
    private BRANCHESVO branchesVO = new BRANCHESVO();
    private CURRENCIESVO currencyVO = new CURRENCIESVO();
    private GEN_LEDGERVO genLedgerVO = new GEN_LEDGERVO(); 
    private CIFVO cifVO = new CIFVO();
    private RIFCTTVO rifcttVO = new RIFCTTVO();
    private CTSCARDS_ACCVO accountVO = new CTSCARDS_ACCVO();
    private String branch_name;
    private String currency_name;
    private String gl_name;
    private String cif_name;
    private String acc_name;
    private String reason_code1;
    private String reason_code;
    private String acc_cif;
    private Date runningDateRET;
    private String crud;
    private String type;

    public CTSCARDS_MGTVO getCardsMgtVO()
    {
	return cardsMgtVO;
    }

    public void setCardsMgtVO(CTSCARDS_MGTVO cardsMgtVO)
    {
	this.cardsMgtVO = cardsMgtVO;
    }

    public CIFVO getCifVO()
    {
	return cifVO;
    }

    public void setCifVO(CIFVO cifVO)
    {
	this.cifVO = cifVO;
    }

    public RIFCTTVO getRifcttVO()
    {
	return rifcttVO;
    }

    public void setRifcttVO(RIFCTTVO rifcttVO)
    {
	this.rifcttVO = rifcttVO;
    }

    public CTSCARDS_ACCVO getAccountVO()
    {
	return accountVO;
    }

    public void setAccountVO(CTSCARDS_ACCVO accountVO)
    {
	this.accountVO = accountVO;
    }

    public String getBranch_name()
    {
	return branch_name;
    }

    public void setBranch_name(String branchName)
    {
	branch_name = branchName;
    }

    public String getCurrency_name()
    {
	return currency_name;
    }

    public void setCurrency_name(String currencyName)
    {
	currency_name = currencyName;
    }

    public String getGl_name()
    {
	return gl_name;
    }

    public void setGl_name(String glName)
    {
	gl_name = glName;
    }

    public String getCif_name()
    {
	return cif_name;
    }

    public void setCif_name(String cifName)
    {
	cif_name = cifName;
    }

    public String getAcc_name()
    {
	return acc_name;
    }

    public void setAcc_name(String accName)
    {
	acc_name = accName;
    }

    public String getReason_code1()
    {
	return reason_code1;
    }

    public void setReason_code1(String reasonCode1)
    {
	reason_code1 = reasonCode1;
    }

    public String getReason_code()
    {
	return reason_code;
    }

    public void setReason_code(String reasonCode)
    {
	reason_code = reasonCode;
    }

    public String getAcc_cif()
    {
	return acc_cif;
    }

    public void setAcc_cif(String accCif)
    {
	acc_cif = accCif;
    }

    public CTSCARDSVO getCtsCardsVO()
    {
	return ctsCardsVO;
    }

    public void setCtsCardsVO(CTSCARDSVO ctsCardsVO)
    {
	this.ctsCardsVO = ctsCardsVO;
    }

    public CTSTRXTYPEVO getCtsTrxTypeVO()
    {
	return ctsTrxTypeVO;
    }

    public void setCtsTrxTypeVO(CTSTRXTYPEVO ctsTrxTypeVO)
    {
	this.ctsTrxTypeVO = ctsTrxTypeVO;
    }

    public BRANCHESVO getBranchesVO()
    {
	return branchesVO;
    }

    public void setBranchesVO(BRANCHESVO branchesVO)
    {
	this.branchesVO = branchesVO;
    }

    public String getCrud()
    {
	return crud;
    }

    public void setCrud(String crud)
    {
	this.crud = crud;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Date getRunningDateRET()
    {
        return runningDateRET;
    }

    public void setRunningDateRET(Date runningDateRET)
    {
        this.runningDateRET = runningDateRET;
    }

    public CURRENCIESVO getCurrencyVO()
    {
        return currencyVO;
    }

    public void setCurrencyVO(CURRENCIESVO currencyVO)
    {
        this.currencyVO = currencyVO;
    }

    public GEN_LEDGERVO getGenLedgerVO()
    {
        return genLedgerVO;
    }

    public void setGenLedgerVO(GEN_LEDGERVO genLedgerVO)
    {
        this.genLedgerVO = genLedgerVO;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm()
    {
        return hm;
    }

    public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm)
    {
        this.hm = hm;
    }
}