package com.path.core.actions.aml;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.path.bo.core.aml.KycManagementBO;
import com.path.bo.core.aml.KycManagementConstant;
import com.path.vo.core.aml.KycManagementCO;
import com.path.vo.core.aml.KycManagementSC;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.dbmaps.vo.CIF_KYC_PARAMETERSVO;
import com.path.dbmaps.vo.COUNTRIESVO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.csmfom.CIFCountryInfoCO;
import com.path.vo.core.csmfom.CIFKycFinancialInfoCountryCO;
import com.path.vo.core.csmfom.CIF_KYC_FINANCIAL_INFOCO;
import com.path.vo.core.csmfom.CTS_CIF_PEP_DETAILSCO;
import com.path.vo.core.csmfom.FomSC;

public class KycManagementLookupAction extends LookupBaseAction
{

	private FomSC fomSC = new FomSC();
	private KycManagementSC kycManagementSC = new KycManagementSC();
	private String update;
	private String cityCode;
	private String updates;
	private CIF_KYC_FINANCIAL_INFOCO cifKycFinancialInfoCO;
	private String actionType;
	private String financialType;
	private String lineNo;
	private String inGridStr;
	private String fromScreen;
	private String glCode;
	private String slNo;
	private CTS_CIF_PEP_DETAILSCO ctsCifPepDetailsCO;
	private CIF_KYC_PARAMETERSVO cifKycParametersVO;
	private KycManagementBO kycManagementBO;

	public String loadCifCountryInfoGrid()
	{
		try
		{

			copyproperties(fomSC);
			setSearchFilter(fomSC);
			SessionCO sessionCO = returnSessionObject();
			fomSC.setCompCode(sessionCO.getCompanyCode());
			if (StringUtil.isNotEmpty(update))
			{
				fomSC.setCifNo(new BigDecimal(update));
			}
			List<CIFCountryInfoCO> ls = kycManagementBO.retCifCountryInfoGridWithoutPagination(fomSC);
			int size = kycManagementBO.retCifCountryInfoCount(fomSC);
			setRecords(size);
			setGridModel(ls);
		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String ymcCountriesLookup()
	{
		try
		{
			fillYmcCountriesLookup("/path/kycManagement/KycManagementLookupAction_fillYmcCountriesGrid.action", "");
		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String fillYmcCountriesGrid()
	{
		try
		{

			copyproperties(fomSC);
			setSearchFilter(fomSC);
			SessionCO sessionCO = returnSessionObject();
			fomSC.setCompCode(sessionCO.getCompanyCode());
			// Abdo US 382751 - BB KYC with Dynamic Screen
			S_APPVO sappVO = new S_APPVO();
			sappVO.setAPP_NAME(ConstantsCommon.ITR_APP_NAME); // check if ITR
			sappVO = returnCommonLibBO().returnApplicationDetails(sappVO);
			if (sappVO == null)
			{
				fomSC.setADD_STRING2(null);
			} // End Abdo
			ArrayList<COUNTRIESVO> ls = kycManagementBO.retYmcFinancialCountries(fomSC);
			int size = kycManagementBO.retYmcFinancialCountriesCount(fomSC);
			setRecords(size);
			setGridModel(ls);

		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String fillYmcCountriesLookup(String gridUrl, String gridCaption)
	{
		try
		{
			String[] name = { "COUNTRY_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ARAB" };
			String[] colType = { "number", "text", "text", "text", "text" };
			String[] titles = { getText("code_key"), getText("briefDesc"), getText("long_desc_eng_key"), getText("legal_status_brief_desc_arab_key"),
					getText("long_desc_arab_key") };
			// Defining the Grid
			LookupGrid grid = new LookupGrid();
			grid.setCaption(gridCaption);
			grid.setRowNum("10");
			grid.setUrl(gridUrl);
			List<LookupGridColumn> lsGridColumn = new ArrayList<LookupGridColumn>();
			int cols = name.length;
			for (int i = 0; i < cols; i++)
			{
				// Defining each column
				LookupGridColumn gridColumn = new LookupGridColumn();
				gridColumn.setName(name[i]);
				gridColumn.setIndex(name[i]);
				gridColumn.setColType(colType[i]);
				gridColumn.setTitle(titles[i]);
				gridColumn.setSearch(true);

				// adding column to the list
				lsGridColumn.add(gridColumn);
			}
			lookup(grid, lsGridColumn, null, fomSC);
		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String ymcCountriesLookupDependency()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			fomSC.setCompCode(sessionCO.getCompanyCode());
			cifKycFinancialInfoCO = new CIF_KYC_FINANCIAL_INFOCO();
			if (StringUtil.isNotEmpty(update))
			{
				fomSC.setCountry(new BigDecimal(update));
				fomSC.setRecToskip(0);
				fomSC.setNbRec(1);
				// - BB KYC with Dynamic Screen
				S_APPVO sappVO = new S_APPVO();
				sappVO.setAPP_NAME(ConstantsCommon.ITR_APP_NAME); // check if
				// ITR
				sappVO = returnCommonLibBO().returnApplicationDetails(sappVO);
				if (sappVO == null)
				{
					fomSC.setADD_STRING2(null);
				}
				ArrayList<COUNTRIESVO> resultList = kycManagementBO.retYmcFinancialCountries(fomSC);
				if (!resultList.isEmpty())
				{
					if (StringUtil.nullToEmpty(kycManagementSC.getFinancialType()).equals("D")
							|| StringUtil.nullToEmpty(kycManagementSC.getFinancialType()).equals("E"))
					{
						cifKycFinancialInfoCO = kycManagementBO.formatUSTin(kycManagementSC);
						getAdditionalScreenParams().putAll(cifKycFinancialInfoCO.getHm());
						if (!cifKycFinancialInfoCO.getHm().isEmpty())
						{
							setAdditionalScreenParams(cifKycFinancialInfoCO.getHm());
						}
					}
					COUNTRIESVO vo = resultList.get(0);
					cifKycFinancialInfoCO.setKYC_FINANCIAL_BIRTH_COUNTRY_DESC(vo.getLONG_DESC_ENG());
					cifKycFinancialInfoCO.getCifKycFinancialInfoVO().setKYC_FINANCIAL_BIRTH_COUNTRY(vo.getCOUNTRY_CODE());
				}
				else
				{
					throw new BOException(MessageCodes.INVALID_COUNTRY_CODE);
				}

			}
		}
		catch (Exception e)
		{
			cifKycFinancialInfoCO.setKYC_FINANCIAL_BIRTH_COUNTRY_DESC(null);
			cifKycFinancialInfoCO.getCifKycFinancialInfoVO().setKYC_FINANCIAL_BIRTH_COUNTRY(null);
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String savekycInGrid()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			cifKycFinancialInfoCO = new CIF_KYC_FINANCIAL_INFOCO();
			cifKycFinancialInfoCO.getCifKycFinancialInfoVO().setCOMP_CODE(sessionCO.getCompanyCode());
			cifKycFinancialInfoCO.getCifKycFinancialInfoVO().setCIF_NO(new BigDecimal(update));
			cifKycFinancialInfoCO.getCifKycFinancialInfoVO().setLINE_NO(BigDecimal.ZERO);
			if (StringUtil.isNotEmpty(updates))
			{
				GridUpdates gu = getGridUpdates(updates, CIFKycFinancialInfoCountryCO.class, true);
				cifKycFinancialInfoCO.setCifKycFinancialInfoCountryCOs(gu.getLstAllRec());
			}
			cifKycFinancialInfoCO.setInGridStr(updates);
			kycManagementBO.saveInGrid(cifKycFinancialInfoCO);
		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String saveCifCountryInfoGrid()
	{
		try
		{
			copyproperties(fomSC);
			setSearchFilter(fomSC);
			SessionCO sessionCO = returnSessionObject();
			fomSC.setCompCode(sessionCO.getCompanyCode());
			if (StringUtil.isNotEmpty(update))
			{
				fomSC.setCifNo(new BigDecimal(update));
			}
			GridUpdates gu = getGridUpdates(updates, CIFCountryInfoCO.class, true);
			List<CIFCountryInfoCO> cifCountryInfoList = gu.getLstAllRec();
			kycManagementBO.saveCifCountryInfo(cifCountryInfoList, fomSC);

		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String getActionType()
	{
		return actionType;
	}

	public void setActionType(String actionType)
	{
		this.actionType = actionType;
	}

	public String getCityCode()
	{
		return cityCode;
	}

	public void setCityCode(String cityCode)
	{
		this.cityCode = cityCode;
	}

	public String getUpdates()
	{
		return updates;
	}

	public void setUpdates(String updates)
	{
		this.updates = updates;
	}

	public CIF_KYC_FINANCIAL_INFOCO getCifKycFinancialInfoCO()
	{
		return cifKycFinancialInfoCO;
	}

	public void setCifKycFinancialInfoCO(CIF_KYC_FINANCIAL_INFOCO cifKycFinancialInfoCO)
	{
		this.cifKycFinancialInfoCO = cifKycFinancialInfoCO;
	}

	public String getUpdate()
	{
		return update;
	}

	public void setUpdate(String update)
	{
		this.update = update;
	}

	public FomSC getFomSC()
	{
		return fomSC;
	}

	public void setFomSC(FomSC fomSC)
	{
		this.fomSC = fomSC;
	}

	@Override
	public Object getModel()
	{
		return fomSC;
	}

	public String getFinancialType()
	{
		return financialType;
	}

	public void setFinancialType(String financialType)
	{
		this.financialType = financialType;
	}

	public String getLineNo()
	{
		return lineNo;
	}

	public void setLineNo(String lineNo)
	{
		this.lineNo = lineNo;
	}

	public String getInGridStr()
	{
		return inGridStr;
	}

	public void setInGridStr(String inGridStr)
	{
		this.inGridStr = inGridStr;
	}

	public String getFromScreen()
	{
		return fromScreen;
	}

	public void setFromScreen(String fromScreen)
	{
		this.fromScreen = fromScreen;
	}

	public String getGlCode()
	{
		return glCode;
	}

	public void setGlCode(String glCode)
	{
		this.glCode = glCode;
	}

	public String getSlNo()
	{
		return slNo;
	}

	public void setSlNo(String slNo)
	{
		this.slNo = slNo;
	}

	public CTS_CIF_PEP_DETAILSCO getCtsCifPepDetailsCO()
	{
		return ctsCifPepDetailsCO;
	}

	public void setCtsCifPepDetailsCO(CTS_CIF_PEP_DETAILSCO ctsCifPepDetailsCO)
	{
		this.ctsCifPepDetailsCO = ctsCifPepDetailsCO;
	}

	public CIF_KYC_PARAMETERSVO getCifKycParametersVO()
	{
		return cifKycParametersVO;
	}

	public void setCifKycParametersVO(CIF_KYC_PARAMETERSVO cifKycParametersVO)
	{
		this.cifKycParametersVO = cifKycParametersVO;
	}

	public void setKycManagementBO(KycManagementBO kycManagementBO)
	{
		this.kycManagementBO = kycManagementBO;
	}

	public KycManagementSC getKycManagementSC()
	{
		return kycManagementSC;
	}

	public void setKycManagementSC(KycManagementSC kycManagementSC)
	{
		this.kycManagementSC = kycManagementSC;
	}

}
