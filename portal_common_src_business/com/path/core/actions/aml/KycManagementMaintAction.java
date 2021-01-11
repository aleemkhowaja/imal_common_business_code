package com.path.core.actions.aml;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.commons.beanutils.PropertyUtils;
import com.opensymphony.xwork2.ActionContext;
import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.core.aml.KycManagementBO;
import com.path.bo.core.aml.KycManagementConstant;
import com.path.bo.core.blacklistsource.BlackListSourceConstant;
import com.path.bo.core.cif.CifBO;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.dbmaps.vo.CIF1VO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_ADDRESSVO;
import com.path.dbmaps.vo.CIF_KYCVO;
import com.path.dbmaps.vo.CTS_DYN_CIF_KYCVO;
import com.path.expression.common.PBFunc.BaseException;
import com.path.expression.lib.util.DateUtil;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.PathLocalizedTextUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.common.address.AddressCommonCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.fom.FomKYCLabelCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.core.aml.KycManagementCO;
import com.path.vo.core.aml.KycManagementSC;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.csmfom.CIF_KYC_FINANCIAL_INFOCO;
import com.path.vo.core.csmfom.FomCO;
import com.path.vo.core.csmfom.FomCifAddressCO;
import com.path.vo.core.csmfom.FomSC;
import net.sf.json.JSONException;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * KycManagementMaintAction.java used to
 */
public class KycManagementMaintAction extends RetailBaseAction
{

	private KycManagementBO kycManagementBO;
	private CifBO cifBO;
	private KycManagementCO kycManagementCO = new KycManagementCO();
	private KycManagementSC kycManagementSC = new KycManagementSC();
	private FomSC fomSC = new FomSC();
	private FomCO fomCO = new FomCO();
	private CIF1VO cifVO1 = new CIF1VO();
	private ArrayList<SmartCO> smartCOList;
	private String screenLang;
	private BigDecimal screenId;
	private String updates;
	private ArrayList<CTS_DYN_CIF_KYCVO> listKycVOs;
	private String cifNo;
	private String branchId;
	private String neededLocale;
	private String update;
	private CIF_KYC_FINANCIAL_INFOCO cifKycFinancialInfoCO;
	private AddressCommonCO addressCO = new AddressCommonCO();
	private FomCifAddressCO cifAddressCO = new FomCifAddressCO();
	private CIF_ADDRESSVO addressVO = new CIF_ADDRESSVO();
	private BigDecimal cifCode;
	private Date cif_UpdateDate;
	private String cifStatus;
	private String saveType;
	private String latestCifupdateDate;
	private FomKYCLabelCO fomKYCLabel = new FomKYCLabelCO();
	private String passportSaveType = KycManagementConstant.C;

	/**
	 * This is a parameter used when opening the FOMMaint.jsp (links hyperlink) from the 360 degree page it is used to set set_recReadOnly("true")
	 */
	private String isLookUp;

	/**
	 * make a loop on the list names to generate them
	 */

	private List<SelectCO> languagesList = new ArrayList<SelectCO>();

	public List<SelectCO> getLanguagesList()
	{
		return languagesList;
	}

	public void setLanguagesList(List<SelectCO> languagesList)
	{
		this.languagesList = languagesList;
	}

	public String loadKycManagementPage()
	{
		try
		{
			kycManagementCO = kycManagementBO.checkCif(kycManagementCO);
			setAdditionalScreenParams(kycManagementCO.getScreenParam());

			set_searchGridId("kycManagementListGridTbl_Id");
			if ((CoreCommonConstants.CRUD_MAINTENANCE.equals(getIv_crud())))
			{
				set_showNewInfoBtn(KycManagementConstant.TRUE);
				set_enableAudit(true);
				set_showSmartInfoBtn(KycManagementConstant.TRUE);
				set_recReadOnly(KycManagementConstant.FALSE);

			}

			if (getIv_crud().equalsIgnoreCase(KycManagementConstant.STATUS_APPROVED))
			{
				set_showTrackChngBtn(KycManagementConstant.FALSE);

			}
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return "kycManagementList";
	}

	/**
	 * FILL THE FORM FROM DATABASE (RETREIVE DATA).
	 */
	public String loadRecords()
	{
		try
		{
			fillSessionVariables();
			fillSessionCO();

			// load data
			kycManagementCO = kycManagementBO.returnKycManagement(kycManagementSC);
			getAdditionalScreenParams().putAll(kycManagementCO.getScreenParam());
			if ((CoreCommonConstants.CRUD_MAINTENANCE.equals(getIv_crud())
					&& CoreCommonConstants.STATUS_APPROVED.equals(kycManagementCO.getAmlKycVO().getENTITY_STATUS()))
					|| (CoreCommonConstants.CRUD_APPROVE.equals(getIv_crud())) || (CoreCommonConstants.CRUD_CANCEL.equals(getIv_crud()))
					|| ((KycManagementConstant.CRUD_UPDATE_AFTER_AUTHORIZE.equals(getIv_crud()))
							&& (StringUtil.isEmptyString(kycManagementCO.getAmlKycVO().getENTITY_STATUS())))

			)
			{
				set_recReadOnly(KycManagementConstant.TRUE);
			}

			if (getIv_crud().equalsIgnoreCase(CoreCommonConstants.CRUD_MAINTENANCE)
					&& CoreCommonConstants.STATUS_DELETED.equals(kycManagementCO.getAmlKycVO().getENTITY_STATUS()))
			{
				set_recReadOnly(KycManagementConstant.TRUE);
			}
			if (getIv_crud().equalsIgnoreCase(CoreCommonConstants.CRUD_MAINTENANCE)
					&& kycManagementCO.getAmlKycVO().getENTITY_STATUS().equals(KycManagementConstant.STATUS_ACTIVE)
					|| (KycManagementConstant.CRUD_UPDATE_AFTER_AUTHORIZE.equals(getIv_crud())
							&& kycManagementCO.getAmlKycVO().getENTITY_STATUS().equals(KycManagementConstant.STATUS_APPROVED)))
			{
				set_recReadOnly(KycManagementConstant.FALSE);
			}

			fillSessionCO();

			applyRetrieveAudit(AuditConstant.KYC_MANAGEMENT_KEY, kycManagementCO.getAmlKycVO(), kycManagementCO);
			AuditRefCO refCO = initAuditRefCO();
			refCO.setTrxNbr(getAuditTrxNbr());
			applyChangesHighlights(refCO);

		}

		catch (Exception ex)
		{
			handleException(ex, null, null);
			return ERROR_ACTION;
		}
		return "kycManagementMaint";
	}

	/**
	 * reloads the page on new btn clicked
	 */
	public String reload() throws BaseException
	{
		try
		{
			loadKycManagementPage();
		}
		catch (Exception e)
		{
			handleException(e, null, null);
			return ERROR_ACTION;
		}
		return "kycManagementMaint";
	}

	public String dependencyByCode() throws JSONException
	{
		try
		{
			fillSessionCO();

			if (NumberUtil.isEmptyDecimal(kycManagementCO.getAmlKycVO().getCODE()))
			{
				kycManagementCO = new KycManagementCO();
			}
			else
			{
				kycManagementCO = kycManagementBO.returnDepByCode(kycManagementCO);

			}

		}
		catch (Exception e)
		{
			kycManagementCO.getAmlKycVO().setCODE(null);
			handleException(e, null, null);
		}

		return SUCCESS;
	}

	/**
	 * Save
	 **/

	public String saveKyc() throws BaseException
	{
		try
		{
			fillSessionCO();
			fillSessionVariables();
			fillSessionData();
			fomCO.getCifVO().setCIF_NO(kycManagementCO.getAmlKycVO().getCIF_NO());
			fomCO.getCifVO().setCIF_TYPE(kycManagementCO.getCifType());

			// smart
			kycManagementCO.setSmartCOList(smartCOList);

			// audit
			AuditRefCO refCO = initAuditRefCO();
			refCO.setOperationType(AuditConstant.CREATED);
			refCO.setKeyRef(AuditConstant.KYC_MANAGEMENT_KEY);
			kycManagementCO.setAuditRefCO(refCO);
			fomCO.setAuditRefCO(refCO);
			SessionCO sessionCO = returnSessionObject();
			fomCO.getCifVO().setCOMP_CODE(sessionCO.getCompanyCode());
			fomCO.setSaveType(getSaveType());// save type

			if (null != fomCO.getCif1VO())
			{
				fomCO.getCif1VO().setCOMP_CODE(returnSessionObject().getCompanyCode());
			}

			fomCO.setPassportSaveType(passportSaveType);

			kycManagementCO = kycManagementBO.saveKyc(kycManagementCO, fomCO);
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return SUCCESS;
	}

	public String updateKyc() throws BaseException, com.path.lib.common.exception.BaseException
	{

		AuditRefCO refCO = initAuditRefCO();
		refCO.setOperationType(AuditConstant.UPDATE);
		refCO.setKeyRef(AuditConstant.KYC_MANAGEMENT_KEY);
		refCO.setTrxNbr(getAuditTrxNbr());
		fillSessionData();
		fomCO.getCifVO().setCIF_NO(kycManagementCO.getAmlKycVO().getCIF_NO());
		fomCO.getCifVO().setCIF_TYPE(kycManagementCO.getCifType());
		fillSessionVariables();

		// smart
		kycManagementCO.setSmartCOList(smartCOList);

		kycManagementCO.setAuditRefCO(refCO);
		kycManagementCO.setAuditObj(returnAuditObject(kycManagementCO.getClass()));

		fillSessionCO();

		kycManagementCO = kycManagementBO.updateKyc(kycManagementCO, fomCO);
		return SUCCESS;
	}

	public String deleteRecord() throws BaseException
	{
		try
		{

			NumberUtil.resetEmptyValues(kycManagementCO);
			fillSessionCO();
			fillSessionVariables();
			kycManagementCO.setDelete(BigDecimal.ONE);
			AuditRefCO refCO = initAuditRefCO();
			refCO.setKeyRef(AuditConstant.KYC_MANAGEMENT_KEY);
			refCO.setOperationType(AuditConstant.UPDATE);
			refCO.setTrxNbr(getAuditTrxNbr());
			kycManagementCO.setAuditRefCO(refCO);
			kycManagementCO.setAuditObj(returnAuditObject(kycManagementCO.getClass()));

			kycManagementBO.deleteRecord(kycManagementCO, refCO);

		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}

		return SUCCESS;
	}

	public String approveKyc() throws BaseException
	{
		try
		{
			NumberUtil.resetEmptyValues(kycManagementCO);
			fillSessionCO();
			fillSessionVariables();

			kycManagementCO.setMethod(BigDecimal.ONE);
			// smart
			kycManagementCO.setSmartCOList(smartCOList);

			// CALL AUDIT FOR APPROVE.
			AuditRefCO refCO = initAuditRefCO();
			refCO.setKeyRef(AuditConstant.KYC_MANAGEMENT_KEY);
			refCO.setOperationType(AuditConstant.UPDATE);
			refCO.setTrxNbr(getAuditTrxNbr());
			kycManagementCO.setAuditRefCO(refCO);
			kycManagementCO.setAuditObj(returnAuditObject(kycManagementCO.getClass()));

			kycManagementCO = kycManagementBO.approveKyc(kycManagementCO);

		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return SUCCESS;
	}

	public String dependencyByCifCode() throws JSONException
	{
		try
		{
			fillSessionCO();

			if (NumberUtil.isEmptyDecimal(kycManagementCO.getAmlKycVO().getCIF_NO()))
			{
				kycManagementCO = kycManagementBO.checkCif(kycManagementCO);
				getAdditionalScreenParams().putAll(kycManagementCO.getScreenParam());

				kycManagementCO.getAmlKycVO().setCIF_NO(null);
			}
			else
			{
				kycManagementCO = kycManagementBO.returnDepByCifCode(kycManagementCO);
				getAdditionalScreenParams().putAll(kycManagementCO.getScreenParam());


			}

		}
		catch (Exception e)
		{
			kycManagementCO.getAmlKycVO().setCIF_NO(null);
			handleException(e, null, null);
		}

		return SUCCESS;
	}

	/**
	 * This method is to load the FOMKYCDetails screen upon clicking on button KYC Details in the Additional Details Tab
	 * 
	 * @return
	 */
	public String loadAMLKycDetails()
	{

		try
		{
			SessionCO sessionCO = returnSessionObject();
			fomCO.setLoginCompCode(sessionCO.getCompanyCode());
			fomCO.setLoginBraCode(sessionCO.getBranchCode());
			fomCO.setLanguage(sessionCO.getLanguage());
			fomCO.setBaseCurrDecPoint(sessionCO.getBaseCurrDecPoint());
			fomCO.setFomKYCIsloaded(KycManagementConstant.ONE);

			// To retrieve saved FomKYC records from Database
			if (!NumberUtil.isEmptyDecimal(fomCO.getCifVO().getCIF_NO()) && KycManagementConstant.ONE.equals(fomCO.getIsEmptyScreen()))
			{
				fomCO = kycManagementBO.returnAMLKycDetailsRec(fomCO);

			}

			getNeededLocale();// en_US
			Locale old_locale = ActionContext.getContext().getLocale();
			Locale requested_locale = PathLocalizedTextUtil.localeFromString(getNeededLocale(), null);

			ActionContext.getContext().setLocale(requested_locale);
			fillFomKYCLabelCO();

			ActionContext.getContext().setLocale(old_locale);
			fillSessionData();
			fomCO = onFomKYCLoad(fomCO);
			getAdditionalScreenParams().putAll(fomCO.getBuisnessElement());

			String cifStatus = StringUtil.nullEmptyToValue(fomCO.getCifVO().getSTATUS(), KycManagementConstant.CIF_INACTIVE);
			if (KycManagementConstant.ONE.equals(isLookUp) || !KycManagementConstant.R.equalsIgnoreCase(getIv_crud())
					|| (!KycManagementConstant.CIF_INACTIVE.equals(cifStatus) && !KycManagementConstant.CIF_ACTIVE.equals(cifStatus)))
			{
				set_recReadOnly(KycManagementConstant.TRUE);
			}

		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}
		if (updates != null && fomCO.getCifKYCVO().getKYC_UPDATE_DATE() != null)
		{
			CTS_DYN_CIF_KYCVO vo = new CTS_DYN_CIF_KYCVO();
			vo.setELEMENT_ID("fomCO.cifKYCVO.KYC_UPDATE_DATE");
			vo.setELEMENT_VALUE(fomCO.getCifKYCVO().getKYC_UPDATE_DATE().toString());
			return SUCCESS;
		}
		else
		{
			return SUCCESS;
		}
	}

	/**
	 * This method is used to set the selected user language in the Name & Address Tab Language dropdown List
	 * 
	 * @param language
	 * @throws BaseException
	 */
	public void fillFomKYCLabelCO() throws BaseException
	{
		try
		{
			if (fomKYCLabel.getKycUpdateDate() == null)
			{
				fomCO = kycManagementBO.addActionToFOMElement("KYCUpdateDate", ConstantsCommon.ACTION_TYPE_LABEL, getText("KYCUpdateDate_key"), fomCO);

			}
			if (fomKYCLabel.getPurposeOfOpeningAcc() == null)
			{
				fomCO.getBuisnessElement().putAll(returnCommonLibBO().applyDynScreenDisplay(new String[] { "lookuptxt_purposeOfOpeningAcc" },
						ConstantsCommon.ACTION_TYPE_LABEL, getText("purposeOfOpeningAcc_key"), fomCO.getBuisnessElement(), null));
			}
			if (fomKYCLabel.getOtherExstingAcc() == null)
			{
				fomKYCLabel.setOtherExstingAcc(getText("otherExstingAcc_key"));

			}
			if (fomKYCLabel.getResident() == null)
			{
				fomKYCLabel.setResident(getText("Resident_key"));
			}
			if (fomKYCLabel.getNonResident() == null)
			{
				fomKYCLabel.setNonResident(getText("cust.nonResident"));
			}
			if (fomKYCLabel.getNotApplicable() == null)
			{
				fomKYCLabel.setNotApplicable(getText("N/A"));
			}
			if (fomKYCLabel.getNotApplicable() == null)
			{
				fomKYCLabel.setNotApplicable(getText("N/A"));
			}
			if (fomKYCLabel.getBankName() == null)
			{
				fomKYCLabel.setBankName(getText("Bank_Name_key"));
			}
			if (fomKYCLabel.getCountryName() == null)
			{
				fomKYCLabel.setCountryName(getText("Country_Name_key"));
			}

			if (fomKYCLabel.getConfirmPoliticalMember() == null)
			{
				fomKYCLabel.setConfirmPoliticalMember(getText("confirmPoliticalMember_key"));
			}
			if (fomKYCLabel.getOtherPassport() == null)
			{
				fomKYCLabel.setOtherPassport(getText("otherPassport_key"));
			}

			if (fomKYCLabel.getGreenCard() == null)
			{
				fomKYCLabel.setGreenCard(getText("greenCard_key"));
			}
			if (fomKYCLabel.getLongStay() == null)
			{
				fomKYCLabel.setLongStay(getText("longStay_key"));
			}
			if (fomKYCLabel.getTaxPayer() == null)
			{
				fomKYCLabel.setTaxPayer(getText("Tax_Payer_key"));
			}
			if (fomKYCLabel.getStandInstr() == null)
			{
				fomKYCLabel.setStandInstr(getText("Stand_Instr_key"));
			}
			if (fomKYCLabel.getAttorney() == null)
			{
				fomKYCLabel.setAttorney(getText("Attorney_key"));
			}
			if (fomKYCLabel.getAddress() == null)
			{
				fomKYCLabel.setAddress(getText("kyc_address_question_key"));
			}

			if (fomKYCLabel.getPleaseSpecify() == null)
			{
				fomCO.getBuisnessElement().putAll(returnCommonLibBO().applyDynScreenDisplay(new String[] { "pleaseSpecify" }, ConstantsCommon.ACTION_TYPE_LABEL,
						getText("pleaseSpecify_key"), fomCO.getBuisnessElement(), null));
				fomKYCLabel.setPleaseSpecify(getText("pleaseSpecify_key"));
			}
			if (fomKYCLabel.getBusiness() == null)
			{
				fomKYCLabel.setBusiness(getText("business_key"));
			}
			if (fomKYCLabel.getEcoSector() == null)
			{
				fomKYCLabel.setEcoSector(getText("economic_sector_key"));
			}

			if (fomKYCLabel.getFatcaCompliant() == null)
			{
				fomKYCLabel.setFatcaCompliant(getText("Fatca_Compliant_key"));
			}

			if (fomKYCLabel.getOtherSpecify() == null)
			{
				fomCO.getBuisnessElement().putAll(returnCommonLibBO().applyDynScreenDisplay(new String[] { "otherSpecify" }, ConstantsCommon.ACTION_TYPE_LABEL,
						getText("otherSpecify_key"), fomCO.getBuisnessElement(), null));
			}
			if (fomKYCLabel.getEstimatedIncome() == null)
			{
				fomCO.getBuisnessElement().putAll(returnCommonLibBO().applyDynScreenDisplay(new String[] { "estimatedIncome" },
						ConstantsCommon.ACTION_TYPE_LABEL, getText("estimatedIncome_key"), fomCO.getBuisnessElement(), null));
			}
			if (fomKYCLabel.getSourceOfWealth() == null)
			{
				fomKYCLabel.setSourceOfWealth(getText("sourceOfWealth_key"));
			}
			if (fomKYCLabel.getSavings() == null)
			{

				fomKYCLabel.setSavings(getText("savings_key"));
			}
			if (fomKYCLabel.getInvestments() == null)
			{
				fomKYCLabel.setInvestments(getText("investments_key"));
			}
			if (fomKYCLabel.getInheritance() == null)
			{
				fomKYCLabel.setInheritance(getText("inheritance_key"));
			}
			if (fomKYCLabel.getEmployment() == null)
			{
				fomKYCLabel.setEmployment(getText("employment_key"));
			}
			if (fomKYCLabel.getOther() == null)
			{
				fomKYCLabel.setOther(getText("other_key"));
			}
			if (fomKYCLabel.getMonths() == null)
			{
				fomKYCLabel.setMonths(getText("Month(s)_key"));
			}
			if (fomKYCLabel.getYears() == null)
			{
				fomKYCLabel.setYears(getText("years_key"));
			}
			if (fomKYCLabel.getNo() == null)
			{
				fomKYCLabel.setNo(getText("no_text_key"));
			}
			if (fomKYCLabel.getYes() == null)
			{
				fomKYCLabel.setYes(getText("yes_key"));
			}
			if (fomKYCLabel.getOtherAddIncome() == null)
			{
				fomCO.getBuisnessElement().putAll(returnCommonLibBO().applyDynScreenDisplay(new String[] { "otherAddIncome" },
						ConstantsCommon.ACTION_TYPE_LABEL, getText("otherAddIncome_key"), fomCO.getBuisnessElement(), null));
			}
		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}
	}

	public FomCO onFomKYCLoad(FomCO fomCO) throws BaseException, com.path.lib.common.exception.BaseException
	{
		return kycManagementBO.onFomKYCLoad(fomCO);
	}

	public String getNeededLocale()
	{
		return neededLocale;
	}

	public String loadTheValues()
	{
		try
		{

			loadAMLKycDetails();
			if (!NumberUtil.isEmptyDecimal(fomCO.getCifVO().getCIF_NO()))
			{
				SessionCO sessionCO = returnSessionObject();
				FomSC fomSC = new FomSC();
				fomSC.setCompCode(sessionCO.getCompanyCode());
				fomSC.setCifNo(fomCO.getCifVO().getCIF_NO());
				if (updates != null)
				{
					fomSC.setBaseCurrencyCode(new BigDecimal(updates)); // screen id
				}

				listKycVOs = kycManagementBO.retDynScreenValues(fomSC, sessionCO.getRunningDateRET(), fomCO); // check if the user add
																												// new fileds to the
				fomCO.setScreenId(new BigDecimal(updates));
				// dynamic screen

			}

		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	/**
	 * 
	 * This method is to check the mandatory fields in AMLKYCDeltails screen
	 */
	public String checkAMLKYCMandatoryFields()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			fomCO.setAppName(sessionCO.getCurrentAppName());
			fomCO.setLanguage(sessionCO.getLanguage());
			fomCO.setOpt(get_pageRef());
			fomCO.setLoginCompCode(sessionCO.getCompanyCode());
			fomCO.setCrud(getIv_crud());
			fomCO.setRunningDate(sessionCO.getRunningDateRET());
			fomCO = kycManagementBO.checkAmlKYCMandatoryFields(fomCO);
		}
		catch (BOException e)
		{
			if (e.getExceptionsLst() != null && !e.getExceptionsLst().isEmpty())
			{
				for (com.path.lib.common.exception.BaseException ex : e.getExceptionsLst())
				{
					if (ex.getRetValue() != null && ex.getRetValue() instanceof CIF_KYCVO)
					{
						fomCO.setCifKYCVO((CIF_KYCVO) ex.getRetValue());
						break;
					}
				}
			}
			handleException(e, null, null);
		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}

		return SUCCESS;

	}

	/**
	 * fill variables in CO
	 * 
	 * @throws com.path.lib.common.exception.BaseException
	 */
	public void fillSessionCO()
	{
		SessionCO sessionCO = returnSessionObject();
		kycManagementCO.getAmlKycVO().setCOMP_CODE(sessionCO.getCompanyCode());
		kycManagementCO.getAmlKycVO().setBRANCH_CODE(sessionCO.getBranchCode());
		kycManagementCO.setAppName(sessionCO.getCurrentAppName());
		kycManagementCO.setLanguage(sessionCO.getLanguage());
		kycManagementCO.setOpt(get_pageRef());
		kycManagementCO.setLoginUserId(sessionCO.getUserName());
		kycManagementCO.setIvCrud(getIv_crud());
		kycManagementCO.setProgRef(get_pageRef());
		kycManagementCO.setRunningDate(sessionCO.getRunningDateRET());

	}

	public void fillSessionData() throws BaseException
	{
		SessionCO sessionCO = returnSessionObject();

		fomCO.setLoginCompCode(sessionCO.getCompanyCode());
		fomCO.setLoginBraCode(sessionCO.getBranchCode());
		fomCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
		fomCO.setOriginBraCode(sessionCO.getBranchCode());

		fomCO.setAppName(sessionCO.getCurrentAppName());
		fomCO.setLanguage(sessionCO.getLanguage());
		fomCO.setLoginPreferrredLanguage(sessionCO.getPreferredLanguage());
		fomCO.setPreferredLanguage(sessionCO.getPreferredLanguage());
		fomCO.setLoginUserId(sessionCO.getUserName());
		fomCO.setCrud(getIv_crud());
		fomCO.setRunningDate(sessionCO.getRunningDateRET());

	}

	public String populatePassportInfoPopup()
	{
		try
		{
			SessionCO sessionObject = returnSessionObject();
			CifSC criteria = new CifSC();
			criteria.setCompCode(sessionObject.getCompanyCode());

			Boolean cifUserAcess = true;
			if (StringUtil.isNotEmpty(cifNo) && !Boolean.valueOf(fomCO.getKycLoadPassPortInfo()))
			{
				criteria.setCif_no(new BigDecimal(cifNo));
				fomCO = cifBO.returnPassportInfoFromCIF(criteria);

			}
			if (fomCO == null)
			{
				fomCO = new FomCO();
			}
			fomCO.setFomPassportInfoLoaded(KycManagementConstant.TRUE);

			if (StringUtil.isNotEmpty(isLookUp) || !cifUserAcess)
			{
				set_recReadOnly(KycManagementConstant.TRUE);
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error(e, "Error in populatePassportInfoPopup");
		}
		return "populatePassportInfoPopup";
	}

	public String openCifCountryInfoGrid()
	{
		return "amlCifCountryInfoGrid";
	}

	/**
	 * fill variables
	 */
	public void fillSessionVariables() throws BaseException
	{
		SessionCO sessionCO = returnSessionObject();
		kycManagementSC.setCompCode(sessionCO.getCompanyCode());
		kycManagementSC.setBranchCode(sessionCO.getBranchCode());
		kycManagementSC.setLanguage(sessionCO.getLanguage());
		kycManagementSC.setAppName(sessionCO.getCurrentAppName());
		kycManagementSC.setProgRef(get_pageRef());
		kycManagementSC.setIvCrud(getIv_crud());
		kycManagementSC.setRunningDate(sessionCO.getRunningDateRET());
		kycManagementSC.setLovTypeId(BlackListSourceConstant.LOV_TYPE);
		kycManagementSC.setIsRTLDir(sessionCO.getIsRTLDir());

	}

	/**
	 * Enhance the checking on the US Passport
	 * 
	 * @return
	 */
	public String dependencyByPassportNumber()
	{
		try
		{
			fomCO = kycManagementBO.dependencyByPassportNumber(fomCO);
		}
		catch (Exception e)
		{
			fomCO.getCif1VO().setPASPORT_NO(null);
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String validatePassportIssueDate()
	{
		try
		{
			NumberUtil.resetEmptyValues(cifVO1);
			SessionCO sessionCO = returnSessionObject();
			Date passportIssueDate = cifVO1.getPASSPORT_ISSUE_DATE();
			Date systemDate = sessionCO.getRunningDateRET();
			if (cifVO1.getPASSPORT_ISSUE_DATE() != null)
			{

				if (DateUtil.parseDate("01/01/1880", "dd/mm/yyyy").compareTo(passportIssueDate) == 1 || (passportIssueDate).compareTo(systemDate) == 1)
				{
					throw new BOException(MessageCodes.INVALID_DATE);
				}
				if (null != cifVO1.getPASSPORT_EXPIRY_DATE() && cifVO1.getPASSPORT_EXPIRY_DATE().compareTo(cifVO1.getPASSPORT_ISSUE_DATE()) <= 0)
				{
					throw new BOException(MessageCodes.EXPIRY_DATE_GREATER_ISSUING_DATE);
				}
			}
		}
		catch (Exception e)
		{
			cifVO1.setPASSPORT_ISSUE_DATE(null);
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String validatePassportExpiryDate()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			fomCO.setRunningDate(sessionCO.getRunningDateRET());

			NumberUtil.resetEmptyValues(cifVO1);
			Date passportExpiryDate = cifVO1.getPASSPORT_EXPIRY_DATE();
			if (cifVO1.getPASSPORT_EXPIRY_DATE() != null)
			{

				if (DateUtil.parseDate("01/01/1880", "dd/mm/yyyy").compareTo(passportExpiryDate) == 1)
				{
					throw new BOException(MessageCodes.INVALID_DATE);
				}
				if (null != cifVO1.getPASSPORT_ISSUE_DATE() && passportExpiryDate.compareTo(cifVO1.getPASSPORT_ISSUE_DATE()) <= 0)
				{
					throw new BOException(MessageCodes.EXPIRY_DATE_GREATER_ISSUING_DATE);
				}

			}
		}
		catch (Exception e)
		{
			cifVO1.setPASSPORT_EXPIRY_DATE(null);
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	/**
	 * Enhance the checking on the US Passport
	 * 
	 * @return
	 */
	public String dependencyByPassportNumber2()
	{
		try
		{
			fomCO = kycManagementBO.dependencyByPassportNumber2(fomCO);
		}
		catch (Exception e)
		{
			fomCO.getCif1VO().setPASSPORT_NO2(null);
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	/**
	 * Enhance the checking on the US Passport
	 * 
	 * @return
	 */
	public String dependencyByPassportNumber3()
	{
		try
		{
			fomCO = kycManagementBO.dependencyByPassportNumber3(fomCO);
		}
		catch (Exception e)
		{
			fomCO.getCif1VO().setPASSPORT_NO3(null);
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String saveAddressPopupDetails()
	{
		try
		{
			PropertyUtils.copyProperties(addressVO, addressCO);

			cifAddressCO.setCifAddressVO(addressVO);
			cifAddressCO.getCifAddressVO().setCOMP_CODE(returnSessionObject().getCompanyCode());
			cifAddressCO.getCifAddressVO().setBRANCH_CODE(returnSessionObject().getBranchCode());
			if (NumberUtil.isEmptyDecimal(cifAddressCO.getCifAddressVO().getCIF_NO()))// if new record
			{
				cifAddressCO.getCifAddressVO().setCIF_NO(cifCode);
			}
			cifAddressCO.getCifAddressVO().setPERM_ADDRESS(addressCO.getPermnAddrFlag() ? KycManagementConstant.Y : KycManagementConstant.ZERO);
			cifAddressCO.getCifAddressVO().setDEFAULT_ADD(addressCO.getDefaultAddrFlag() ? KycManagementConstant.ONE : KycManagementConstant.ZERO);
			cifAddressCO.getCifAddressVO().setE_WALLET_YN(addressCO.geteWalletFlag() ? KycManagementConstant.ONE : KycManagementConstant.ZERO);// 757880 maureen
			cifAddressCO.getCifAddressVO().setPRINT_STAT(addressCO.getPrintAddrFlag() ? BigDecimal.ONE : BigDecimal.ZERO);
			cifAddressCO.setCif_UpdateDate(getCif_UpdateDate());
			cifAddressCO.setSaveType(saveType);
			cifAddressCO.setRunningDate(returnSessionObject().getRunningDateRET());
			cifAddressCO.setIv_crud(getIv_crud());
			cifAddressCO.setCifStatus(getCifStatus());
			cifAddressCO.setCtsTellerVO(returnSessionObject().getCtsTellerVO());

			addressCO.setPreferredLanguage(returnSessionObject().getPreferredLanguage());
			addressCO.setLoginCompCode(returnSessionObject().getCompanyCode());
			addressCO.setLoginBraCode(returnSessionObject().getBranchCode());
			addressCO.setCOMP_CODE(returnSessionObject().getCompanyCode());
			addressCO.setPERM_ADDRESS(addressCO.getPermnAddrFlag() ? KycManagementConstant.TRUE : KycManagementConstant.FALSE);
			addressCO.setAppName(returnSessionObject().getCurrentAppName());
			addressCO.setBRANCH_CODE(returnSessionObject().getBranchCode());

			addressCO.setLoginUserId(returnSessionObject().getUserName());

			prepareAuditObject();
			CIFVO cifVo = kycManagementBO.saveFomCifMoreAddress(cifAddressCO, addressCO);
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS", Locale.ENGLISH);
			latestCifupdateDate = df.format(cifVo.getDATE_UPDATED());
			setCifStatus(cifVo.getSTATUS());

		}
		catch (RuntimeException e)
		{
			throw e;
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return SUCCESS;
	}

	private void prepareAuditObject()
	{
		AuditRefCO refCO = initAuditRefCO();
		refCO.setOperationType(AuditConstant.UPDATE);
		refCO.setKeyRef(AuditConstant.FOM_KEY_REF);
		cifAddressCO.setAuditRefCO(refCO);
		FomCO fomCO = new FomCO();
		cifAddressCO.setAuditObj(returnAuditObject(fomCO.getClass()));
	}

	public void setKycManagementBO(KycManagementBO kycManagementBO)
	{
		this.kycManagementBO = kycManagementBO;

	}

	public KycManagementCO getKycManagementCO()
	{
		return kycManagementCO;
	}

	public void setKycManagementCO(KycManagementCO kycManagementCO)
	{
		this.kycManagementCO = kycManagementCO;
	}

	public KycManagementSC getKycManagementSC()
	{
		return kycManagementSC;
	}

	public void setKycManagementSC(KycManagementSC kycManagementSC)
	{
		this.kycManagementSC = kycManagementSC;
	}

	public ArrayList<SmartCO> getSmartCOList()
	{
		return smartCOList;
	}

	public void setSmartCOList(ArrayList<SmartCO> smartCOList)
	{
		this.smartCOList = smartCOList;
	}

	public String getScreenLang()
	{
		return screenLang;
	}

	public void setScreenLang(String screenLang)
	{
		this.screenLang = screenLang;
	}

	public BigDecimal getScreenId()
	{
		return screenId;
	}

	public void setScreenId(BigDecimal screenId)
	{
		this.screenId = screenId;
	}

	public String getUpdates()
	{
		return updates;
	}

	public void setUpdates(String updates)
	{
		this.updates = updates;
	}

	public ArrayList<CTS_DYN_CIF_KYCVO> getListKycVOs()
	{
		return listKycVOs;
	}

	public void setListKycVOs(ArrayList<CTS_DYN_CIF_KYCVO> listKycVOs)
	{
		this.listKycVOs = listKycVOs;
	}

	public FomCO getFomCO()
	{
		return fomCO;
	}

	public void setFomCO(FomCO fomCO)
	{
		this.fomCO = fomCO;
	}

	public String getCifNo()
	{
		return cifNo;
	}

	public void setCifNo(String cifNo)
	{
		this.cifNo = cifNo;
	}

	public String getBranchId()
	{
		return branchId;
	}

	public void setBranchId(String branchId)
	{
		this.branchId = branchId;
	}

	public String getIsLookUp()
	{
		return isLookUp;
	}

	public void setIsLookUp(String isLookUp)
	{
		this.isLookUp = isLookUp;
	}

	public void setCifBO(CifBO cifBO)
	{
		this.cifBO = cifBO;
	}

	public void setNeededLocale(String neededLocale)
	{
		this.neededLocale = neededLocale;
	}

	public CIF1VO getCifVO1()
	{
		return cifVO1;
	}

	public void setCifVO1(CIF1VO cifVO1)
	{
		this.cifVO1 = cifVO1;
	}

	public String getUpdate()
	{
		return update;
	}

	public void setUpdate(String update)
	{
		this.update = update;
	}

	public CIF_KYC_FINANCIAL_INFOCO getCifKycFinancialInfoCO()
	{
		return cifKycFinancialInfoCO;
	}

	public void setCifKycFinancialInfoCO(CIF_KYC_FINANCIAL_INFOCO cifKycFinancialInfoCO)
	{
		this.cifKycFinancialInfoCO = cifKycFinancialInfoCO;
	}

	public FomSC getFomSC()
	{
		return fomSC;
	}

	public void setFomSC(FomSC fomSC)
	{
		this.fomSC = fomSC;
	}

	public AddressCommonCO getAddressCO()
	{
		return addressCO;
	}

	public void setAddressCO(AddressCommonCO addressCO)
	{
		this.addressCO = addressCO;
	}

	public FomCifAddressCO getCifAddressCO()
	{
		return cifAddressCO;
	}

	public void setCifAddressCO(FomCifAddressCO cifAddressCO)
	{
		this.cifAddressCO = cifAddressCO;
	}

	public CIF_ADDRESSVO getAddressVO()
	{
		return addressVO;
	}

	public void setAddressVO(CIF_ADDRESSVO addressVO)
	{
		this.addressVO = addressVO;
	}

	public BigDecimal getCifCode()
	{
		return cifCode;
	}

	public void setCifCode(BigDecimal cifCode)
	{
		this.cifCode = cifCode;
	}

	public Date getCif_UpdateDate()
	{
		return cif_UpdateDate;
	}

	public void setCif_UpdateDate(Date cif_UpdateDate)
	{
		this.cif_UpdateDate = cif_UpdateDate;
	}

	public String getCifStatus()
	{
		return cifStatus;
	}

	public void setCifStatus(String cifStatus)
	{
		this.cifStatus = cifStatus;
	}

	public String getSaveType()
	{
		return saveType;
	}

	public void setSaveType(String saveType)
	{
		this.saveType = saveType;
	}

	public String getLatestCifupdateDate()
	{
		return latestCifupdateDate;
	}

	public void setLatestCifupdateDate(String latestCifupdateDate)
	{
		this.latestCifupdateDate = latestCifupdateDate;
	}

	public FomKYCLabelCO getFomKYCLabel()
	{
		return fomKYCLabel;
	}

	public void setFomKYCLabel(FomKYCLabelCO fomKYCLabel)
	{
		this.fomKYCLabel = fomKYCLabel;
	}

	public String getPassportSaveType()
	{
		return passportSaveType;
	}

	public void setPassportSaveType(String passportSaveType)
	{
		this.passportSaveType = passportSaveType;
	}

}
