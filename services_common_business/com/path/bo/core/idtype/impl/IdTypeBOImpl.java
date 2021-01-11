package com.path.bo.core.idtype.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.common.CoreCommonServiceBO;
import com.path.bo.core.common.base.RetailBaseBO;
import com.path.bo.core.csmfom.FomConstant;
import com.path.bo.core.csmfom.NCifMaintenanceConstant;
import com.path.bo.core.idtype.IdTypeBO;
import com.path.dao.core.idtype.IdTypeDAO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSTRXTYPE_EXTENDEDVO;
import com.path.dbmaps.vo.ID_TYPESVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.DepositerSC;
import com.path.vo.core.blacklistmanagement.BlackListIdsCO;
import com.path.vo.core.csmfom.FomCO;
import com.path.vo.core.idtype.IdTypeSC;

public class IdTypeBOImpl extends RetailBaseBO implements IdTypeBO
{
    private IdTypeDAO idTypeDAO;
    private BlackListIdsCO blackListIdsCO;
    private CoreCommonServiceBO coreCommonServiceBO;
    private FomCO fomCO = new FomCO();
    


    public IdTypeDAO getIdTypeDAO()
    {
	return idTypeDAO;
    }

    public void setIdTypeDAO(IdTypeDAO idTypeDAO)
    {
	this.idTypeDAO = idTypeDAO;
    }

    @Override
    public List idTypeList(IdTypeSC idTypeSC) throws BaseException
    {
	return idTypeDAO.idTypeList(idTypeSC);
    }

    @Override
    public int idTypeListCount(IdTypeSC idTypeSC) throws BaseException
    {
	return idTypeDAO.idTypeListCount(idTypeSC);
    }

    @Override
    public FomCO returnIdTypeById(IdTypeSC idTypeSC) throws BaseException
    {
    	if(NumberUtil.isEmptyDecimal(idTypeSC.getIdTypeCode()) && FomConstant.MAINTENANCE_OPT.equals(idTypeSC.getSectionKey()))
    	{
    	    // TP 262352 Hala Al Sheikh Enhance the checking on the US Passport
    		coreCommonServiceBO.addActionToFOMElement(idTypeSC.getCountryOfIssuanceIDName(), ConstantsCommon.ACTION_TYPE_VISIBLE,
    			BigDecimal.ZERO, fomCO);
    		coreCommonServiceBO.addActionToFOMElement(idTypeSC.getCountryOfIssuanceIDName(), ConstantsCommon.ACTION_TYPE_VALUE,
    			null, fomCO);
    		coreCommonServiceBO.addActionToFOMElement(idTypeSC.getCountryOfIssuanceDescIDName(), ConstantsCommon.ACTION_TYPE_VALUE,
    			null, fomCO);
    		coreCommonServiceBO.addActionToFOMElement(idTypeSC.getCountryOfIssuanceIDName(), ConstantsCommon.ACTION_TYPE_MANDATORY,
    			BigDecimal.ZERO, fomCO);
    	  //End Hala
    	    return fomCO;
    	    
    	}
    	
    	  //BUG#800812 copied from BUG#492803
//	ID_TYPESVO IDTypesVO = (ID_TYPESVO) idTypeDAO.returnIdTypeById(idTypeSC);
//	if(null == IDTypesVO && "true".equals(idTypeSC.getShowInvalideCodeMsg()))
//	{
//	    throw new BOException(MessageCodes.INVALID_PARAM, new String[] { "ID_Type_key" });
//	}
    	
    	//falha SBI200114 - Complete ID Types are not displaying in Member Detail Screen.
	    if("1".equals(idTypeSC.getFromMember()))
	    {
		if(idTypeSC.getMemberCifNo()!=null && !NumberUtil.isEmptyDecimal(idTypeSC.getMemberCifNo()))
		{  
		CIFVO cifvo=new CIFVO();
		cifvo.setCIF_NO(idTypeSC.getMemberCifNo());
		cifvo.setCOMP_CODE(idTypeSC.getCompCode());
		cifvo=(CIFVO)genericDAO.selectByPK(cifvo);
		idTypeSC.setCifTypeCode(cifvo.getCIF_TYPE());
		}		
		else
		{ 
		idTypeSC.setCifTypeCode(ConstantsCommon.EMPTY_BIGDECIMAL_VALUE);
		}
	    }
	 //falha SBI200114 - Complete ID Types are not displaying in Member Detail Screen.

    	ID_TYPESVO IDTypesVO = returnIdTypeByIdDetails(idTypeSC);
    	// END BUG#800812 copied from BUG#492803
	FomCO fomCO = new FomCO();
	if(null == IDTypesVO)
	{
	    return fomCO; 
	}
	
	/*commented since we are searching within the grid directly 
	 * in case of grid flip option deleted records will persist in the DB thus wrong checking was made
	 * we are selecting all the record within the grid and searching for duplication if exists.   
	 * //TP260314 adjust the checking on existing IDs
    fomCO.getCifVO().setID_TYPE(idTypeSC.getIdTypeCode());
    fomCO.setLoginCompCode(idTypeSC.getCompCode());
    fomCO.getCifVO().setCIF_NO(idTypeSC.getCifNo());
    fomCO.getCifVO().setCIF_TYPE(idTypeSC.getCifTypeCode());
	nCifMaintenanceBO.checkFomIdsListCount(fomCO);
	//end TP260314*/
	IDTypesVO.setCOMP_CODE(idTypeSC.getCompCode());
	fomCO.setIdTypesVO(IDTypesVO);
	BigDecimal idType2 = NumberUtil.nullToZero(idTypeSC.getIdTypeCode2());
	if(!NumberUtil.isEmptyDecimal(idTypeSC.getIdTypeCode()) 
		&& idTypeSC.getIdTypeCode().intValue() > 0 && idType2.intValue() > 0
		&& idTypeSC.getIdTypeCode().intValue() == idType2.intValue())
	{
	    throw new BOException(MessageCodes.ID_Type_Already_in_Use, new String[] { ": "+idType2.toString()}, true) ;
	}
	if(coreCommonServiceBO.checkCivilId(IDTypesVO, null).booleanValue())
	{
	    CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	    cifControlVO.setCOMP_CODE(idTypeSC.getCompCode());
	    cifControlVO = commonLibBO.returnCifControlDetails(cifControlVO);
	    fomCO.setCifControlVO(cifControlVO);
	    if(!NumberUtil.isEmptyDecimal(cifControlVO.getCID_LENGH()) && StringUtil.isNotEmpty(idTypeSC.getElements()))
	    {
		coreCommonServiceBO.addActionToFOMElement(idTypeSC.getElements(), ConstantsCommon.ACTION_TYPE_MAXLENGTH, cifControlVO.getCID_LENGH(), fomCO);
		coreCommonServiceBO.addActionToFOMElement(idTypeSC.getElements(), ConstantsCommon.ACTION_TYPE_VALUE, "", fomCO);
	    }
	}
	/*
	 * BB140191
	 */
	idTypeSC.setEnableMagneticCardReader(IDTypesVO.getENABLE_MCR());
	fomCO.setCardReaderEnabled(coreCommonServiceBO.checkCardReaderEnability(idTypeSC));
	
	// TP 262352 Hala Al Sheikh Enhance the checking on the US Passport
	String fromScreen = idTypeSC.getSectionKey();
	// if this method called from FOM
	if(FomConstant.MAINTENANCE_OPT.equals(fromScreen))
	{
	    fomCO.setIdType(idTypeSC.getIdTypeCode());
	    fomCO.setIdType2(idTypeSC.getIdTypeCode2());
	    fomCO.setLoginCompCode(idTypeSC.getCompCode());
	    fomCO.setCountryOfIssuanceIDName(idTypeSC.getCountryOfIssuanceIDName());
	    fomCO.setCountryOfIssuanceDescIDName(idTypeSC.getCountryOfIssuanceDescIDName());
	    fomCO.setFromGrid(idTypeSC.getFromGrid());
	    coreCommonServiceBO.checkPassportIDType(fomCO);
	}
	//End Hala
	
	/*
	 * BB140191
	 */
	idTypeSC.setEnableMagneticCardReader(IDTypesVO.getENABLE_MCR());
	
	if(NCifMaintenanceConstant.ID_CARD_TYPE_PACI.equals(StringUtil.nullEmptyToValue(IDTypesVO.getID_CARD_TYPE(), "0")))
	{
	fomCO.setCardReaderEnabled(coreCommonServiceBO.checkCardReaderEnability(idTypeSC));
	}
	//Hussein Elhajj-AUBBH150040-Swift Changes 
	if(!NumberUtil.isEmptyDecimal(idTypeSC.getCompCode())&& !NumberUtil.isEmptyDecimal(idTypeSC.getTrxType()))
	{
        	CTSTRXTYPE_EXTENDEDVO ctstrxtype_EXTENDEDVO = new CTSTRXTYPE_EXTENDEDVO();
        	ctstrxtype_EXTENDEDVO.setCOMP_CODE(idTypeSC.getCompCode());
        	ctstrxtype_EXTENDEDVO.setCODE(idTypeSC.getTrxType());
        	ctstrxtype_EXTENDEDVO = (CTSTRXTYPE_EXTENDEDVO) genericDAO.selectByPK(ctstrxtype_EXTENDEDVO);
        	
        	if("1".equals(ctstrxtype_EXTENDEDVO.getVALD_ID_TYPE_SWIFT_CODE_YN()))
        	{
        	 	    
        	    IDTypesVO = (ID_TYPESVO) genericDAO.selectByPK(IDTypesVO);
        	    fomCO.setIdTypesVO(IDTypesVO);
        	    if(IDTypesVO.getID_TYPE_SWIFT_CODE() == null || "".equals(IDTypesVO.getID_TYPE_SWIFT_CODE()))
        	    
        	    {
        		throw new BOException(MessageCodes.ELEMENT_MISSING_WITH_PARAM,
        			new String[] { "swift_code_for_id_type_key" });
        	    }
                 }
	}

	return fomCO;

    }
    
    //BUG#800812 copied from BUG#492803
    public ID_TYPESVO returnIdTypeByIdDetails(IdTypeSC idTypeSC) throws BaseException
    {
	ID_TYPESVO IDTypesVO = (ID_TYPESVO) idTypeDAO.returnIdTypeById(idTypeSC);
	if(null == IDTypesVO && "true".equals(idTypeSC.getShowInvalideCodeMsg()) && !NumberUtil.isEmptyDecimal(idTypeSC.getIdTypeCode()))
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_CIF_TYPE_CODE);
	}
	return IDTypesVO;
    }

    @Override
    public ID_TYPESVO dependencyByIdNo(IdTypeSC idTypeSC) throws BaseException
    {
	List<BlackListIdsCO> lst = idTypeSC.getIdTypeCOList();
	if(lst != null && !lst.isEmpty())
	{
	    for(int i = 0; i < lst.size() - 1; i++)
	    {
		BigDecimal idType1 = lst.get(i).getBlackListIdVO().getID_TYPE();
		String idNo1 = lst.get(i).getBlackListIdVO().getID_NO();
		
		//Hasan Bug#573859 - TBI170087 17/10/2017
		ID_TYPESVO idTypesVO = new ID_TYPESVO();
		idTypesVO.setCOMP_CODE(idTypeSC.getCompCode());
		idTypesVO.setCODE(idType1);
		
		idTypesVO = (ID_TYPESVO)genericDAO.selectByPK(idTypesVO);
		
		if(idTypesVO == null)
		{
		    throw new BOException(MessageCodes.INVALID_MISSING_ID_NO);
		}
		
		coreCommonServiceBO.checkDataType(idNo1, idTypesVO.getDATA_TYPE());

		for(int j = i + 1; j < lst.size(); j++)
		{
		    BigDecimal idType2 = lst.get(j).getBlackListIdVO().getID_TYPE();
		    String idNo2 = lst.get(j).getBlackListIdVO().getID_NO();

		    if(idType1 != null && idNo1 != null &&
			    idType1.equals(idType2) && idNo1.equals(idNo2))
		    {
			throw new BOException(MessageCodes.DUPLICATED_ENTRY_OF_RECORD);
		    }
		}
	    }
	}
	return null;
    }
    
    /*
     * fboukarroum 82940 - AMANA110094 - Alpha - Numeric characters in FOM - MORE CONTACT - ID field
     * 
     * This method to check the Id number of a Id types triggered on the change in this field 
     * it invokes an error message if there is mismatch between the id_no and id_type format	
     */   
    public void validateIdsIdNo(IdTypeSC criteria) throws BaseException
    {
//	ID_TYPESVO idTypeVo = new ID_TYPESVO();
//	idTypeVo.setCODE(criteria.getIdTypeCode());
//	idTypeVo.setCOMP_CODE(criteria.getCompCode());
//	idTypeVo = (ID_TYPESVO) genericDAO.selectByPK(idTypeVo);

	DepositerSC depositerSC = new DepositerSC();
	depositerSC.setCompCode(criteria.getCompCode());
	depositerSC.setBranchCode(criteria.getBranchCode());
	depositerSC.setPreferredLanguage(criteria.getPreferredLanguage());
	depositerSC.setDepositerId(criteria.getIdNoCode());
	depositerSC.setIdType(criteria.getIdTypeCode());
	depositerSC.setCifNo(NumberUtil.emptyDecimalToNull(criteria.getCifNo()));
	depositerSC.setShowSuspicious("false");
	depositerSC.setCheckIdTypesLength("false");
	depositerSC.setMosBlackListedStatus("'A','P'");
	depositerSC = coreCommonBO.checkIdNo(depositerSC);

	// if(StringUtil.isNotEmpty(criteria.getIdNoCode()))
	// {
	// nCifMaintenanceBO.checkDataType(criteria.getIdNoCode().toString(),
	// idTypeVo.getDATA_TYPE());
	// }
    }
    
    /*
     * fboukarroum 82962 - IIAB110527 - Document Number Repetition in CIF
     * 
     * This method checks for duplication of id_no, id_type 
     */  
    public FomCO checkDuplicateIdNo(FomCO fomCO)throws BaseException
    {
	ID_TYPESVO idTypeVo = new ID_TYPESVO();
	idTypeVo.setCODE(fomCO.getIdTypeValue());
	idTypeVo.setCOMP_CODE(fomCO.getCifVO().getCOMP_CODE());
	idTypeVo = (ID_TYPESVO) genericDAO.selectByPK(idTypeVo);
	
	if (StringUtil.isEmptyString(fomCO.getFromAddNationalities()) || !("true".equals(fomCO.getFromAddNationalities()))){ //924844 - replacing the and by or since this will have the value true only from FOMAddNationalities.jsp and it is null in all the other cases; or this section should be accessible in the other cases
	    

	HashMap<String, ID_TYPESVO> mp = new HashMap<String, ID_TYPESVO>();
	mp.put("ID_TYPE", idTypeVo);
     	fomCO.setIdTypessVO(mp);
     	fomCO.setIdTypesVO(idTypeVo);
     	fomCO.setFromIdsButton("1");
     	coreCommonServiceBO.validateIdNo(fomCO);
     	coreCommonServiceBO.fillCifControlDetails(fomCO);
     	coreCommonServiceBO.validateLegnhIdNo(fomCO);
     	
	}
	
	return fomCO;
	
	
    }
    
    @Override
    public List idTypeByCIFTypeList(IdTypeSC idTypeSC) throws BaseException
    {
	//falha SBI200114 - Complete ID Types are not displaying in Member Detail Screen.
	    if("1".equals(idTypeSC.getFromMember()))
	    {
		if(idTypeSC.getMemberCifNo()!=null && !NumberUtil.isEmptyDecimal(idTypeSC.getMemberCifNo()))
		{  
		CIFVO cifvo=new CIFVO();
		cifvo.setCIF_NO(idTypeSC.getMemberCifNo());
		cifvo.setCOMP_CODE(idTypeSC.getCompCode());
		cifvo=(CIFVO)genericDAO.selectByPK(cifvo);
		idTypeSC.setCifTypeCode(cifvo.getCIF_TYPE());
		}		
		else
		{ 
		idTypeSC.setCifTypeCode(ConstantsCommon.EMPTY_BIGDECIMAL_VALUE);
		}
	    }
	 //falha SBI200114 - Complete ID Types are not displaying in Member Detail Screen.
	return idTypeDAO.idTypeByCIFTypeList(idTypeSC);
    }

    @Override
    public int idTypeByCIFTypeListCount(IdTypeSC idTypeSC) throws BaseException
    {
	//falha SBI200114 - Complete ID Types are not displaying in Member Detail Screen.
	    if("1".equals(idTypeSC.getFromMember()))
	    {
		if(idTypeSC.getMemberCifNo()!=null && !NumberUtil.isEmptyDecimal(idTypeSC.getMemberCifNo()))
		{  
		CIFVO cifvo=new CIFVO();
		cifvo.setCIF_NO(idTypeSC.getMemberCifNo());
		cifvo.setCOMP_CODE(idTypeSC.getCompCode());
		cifvo=(CIFVO)genericDAO.selectByPK(cifvo);
		idTypeSC.setCifTypeCode(cifvo.getCIF_TYPE());
		}		
		else
		{ 
		idTypeSC.setCifTypeCode(ConstantsCommon.EMPTY_BIGDECIMAL_VALUE);
		}
	    }
	 //falha SBI200114 - Complete ID Types are not displaying in Member Detail Screen.
	return idTypeDAO.idTypeByCIFTypeListCount(idTypeSC);
    }

    public BlackListIdsCO getBlackListIdsCO()
    {
	return blackListIdsCO;
    }

    public void setBlackListIdsCO(BlackListIdsCO blackListIdsCO)
    {
	this.blackListIdsCO = blackListIdsCO;
    }
    
    public FomCO getFomCO()
    {
        return fomCO;
    }

    public void setFomCO(FomCO fomCO)
    {
        this.fomCO = fomCO;
    }

    public CoreCommonServiceBO getCoreCommonServiceBO()
    {
        return coreCommonServiceBO;
    }

    @Override
    public void setCoreCommonServiceBO(CoreCommonServiceBO coreCommonServiceBO)
    {
        this.coreCommonServiceBO = coreCommonServiceBO;
    }
}
