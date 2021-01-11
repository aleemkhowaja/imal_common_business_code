<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<%@ taglib prefix="ptt"  uri="/path-toolbar-tags" %> 

<script>   
$.struts2_jquery.require("BlackListMaint.js" ,null,jQuery.contextPath+"/businesscommon/js/blacklistmanagement/");
var printAffectedCifKey = "<ps:text name='print_list_of_affected_cif'/>";
</script>

<ps:form id="blackListMaintForm_${_pageRef}" useHiddenProps="true" >
<ps:hidden name="blackListCO.blackListVO.COMP_CODE" id="compCode_${_pageRef}" />
<ps:hidden name="blackListCO.blackListVO.BRANCH" id="branch_${_pageRef}" />
<ps:hidden name="blackListCO.blackListVO.STATUS" id="blackListVO_STATUS_${_pageRef}" />
<ps:hidden name="blackListCO.blackListVO.DATE_APPROVED" id="blackListVO_DATE_APPROVED_${_pageRef}" />
<ps:hidden name="blackListCO.blackListVO.DATE_CREATED" id="blackListVO_DATE_CREATED_${_pageRef}" />
<ps:hidden name="blackListCO.blackListVO.CREATED_BY" id="blackListVO_CREATED_BY_${_pageRef}" />
<ps:hidden name="blackListCO.blackListVO.DATE_UPDATED" id="blackListVO_DATE_UPDATED_${_pageRef}" />
<ps:hidden name="blackListCO.blackListVO.UPDATED_BY" id="blackListVO_UPDATED_BY_${_pageRef}" />
<ps:hidden name="blackListCO.userIsBranchManager" id="userIsBranchManager_${_pageRef}" />
<ps:hidden name="blackListIdsStr" id="blackListIdsStr_${_pageRef}" />
<ps:hidden id="methodName_${_pageRef}" />
<ps:hidden name="blackListCO.blackListVO.APPROVED_BY" id="approvedById_${_pageRef}" />
<ps:hidden name="blackListCO.blackListVO.REVERSED_BY" id="reversedById_${_pageRef}" />


<ps:hidden id="actionType_${_pageRef}" name="blackListCO.actionType" />
<br/>
<table width="100%" border="0" class="headerPortionContent ui-widget-content">
	<tr>
 		<td width="12%" class="fldLabelView">
			<ps:label key="Code__key" id="lbl_blackListVO_CODE_${_pageRef}" for="blackListVO_CODE_${_pageRef}"/>
		</td>
		<td width="20%">
			<ps:if test='%{iv_crud=="R" && blackListCO.blackListVO.CODE==null}'>
				<ps:textfield name="blackListCO.blackListVO.CODE" id="blackListVO_CODE_${_pageRef}" mode="number" leadZeros="8" maxlength="8" 
					dependencySrc="${pageContext.request.contextPath}/path/blackList/BlackListDependency_validateBlackListCode"
					parameter="blackListVO.CODE:blackListVO_CODE_${_pageRef}"
		            dependency="blackListVO_CODE_${_pageRef}:blackListCO.blackListVO.CODE"
		            afterDepEvent="blackListCodeDependency_showHideBlackListIdGrid();"
				/>
			</ps:if>
			<ps:else>
				<ps:textfield name="blackListCO.blackListVO.CODE" id="blackListVO_CODE_${_pageRef}" mode="number" leadZeros="8" maxlength="8" 
				readonly="true" />
			</ps:else>
		</td>
		<td width="33%" ></td>
		<td width="10%" class="fldLabelView">
			<ps:label key="Status_key" id="lbl_blackListCO_statusDesc_${_pageRef}" for="blackListCO_statusDesc_${_pageRef}"/>
		</td>
		<td width="15%">
			<ps:textfield name="blackListCO.statusDesc" id="blackListCO_statusDesc_${_pageRef}" readonly="true"/>
		</td>
		<td width="10%">
			<psj:a button="true" buttonIcon="ui-icon-folder-open" onclick="onBlackListStatusClicked()">
				<ps:label key='Status_key'/>
			</psj:a>
		</td>
	</tr>
</table>
<br/>
<ps:collapsgroup id="blackListMaint_Div_${_pageRef}">
		
<ps:collapspanel id="blackListMainInfo" key="Main_Information_key">
		
			<table width="100%" border="0" class="headerPortionContent ui-widget-content">
				
				<tr>
				    <td width="12%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="13%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="13%"></td>
					<td width="12%"></td>
				</tr>
				<tr>
				
		  			<td class="fldLabelView" >
						<ps:label key="Document_Nbr._key" id="lbl_blackListVO_OID_DOCUMENT_NBR_${_pageRef}" for="blackListVO_OID_DOCUMENT_NBR_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center" colspan="2" >
						<ps:textfield name="blackListCO.blackListVO.OID_DOCUMENT_NBR" maxlength="20" id="blackListVO_OID_DOCUMENT_NBR_${_pageRef}"
						maxLength="20"
						dependencySrc="${pageContext.request.contextPath}/path/blackList/BlackListDependency_dependnecyByDocNo"
						dependency="lookuptxt_blackListVO_CIF_${_pageRef}:blackListCO.cifCO.cifVO.CIF_NO,
									blackListCO_cifDesc_${_pageRef}:blackListCO.cifCO.cifVO.SHORT_NAME_ENG,
									lookuptxt_blackListVO_COUNTRY_${_pageRef}:blackListCO.cifCO.cifVO.COUNTRY,
				                    blackListCO_countriesDesc_${_pageRef}:blackListCO.cifCO.COUNTRY_DESC,
				                    lookuptxt_blackListVO_CIF_REGION_CODE_${_pageRef}:blackListCO.cifCO.cifVO.REGION_CODE,
				                    blackListCO_regionDesc_${_pageRef}:blackListCO.cifCO.REGION_DESC,
				                    lookuptxt_blackListVO_CIF_NATION_CODE_${_pageRef}:blackListCO.cifCO.cifVO.NATION_CODE,
				                    blackListCO_nationDesc_${_pageRef}:blackListCO.cifCO.NATION_DESC,
				                    lookuptxt_blackListVO_LEGAL_STATUS_${_pageRef}:blackListCO.cifCO.cifVO.LEGAL_STATUS,
				                    blackListCO_legalStatusDesc_${_pageRef}:blackListCO.cifCO.LEGAL_STATUS_DESC,
				                    lookuptxt_blackListVO_CIF_TYPE_${_pageRef}:blackListCO.cifCO.cifVO.CIF_TYPE,
				                    blackListCO_ciftypeDesc_${_pageRef}:blackListCO.cifCO.CIF_TYPE_DESC,
				                    blackListVO_CIF_REGISTER_NO_${_pageRef}:blackListCO.cifCO.cifVO.REGISTER_NO,
				                    blackListVO_OID_DOCUMENT_NBR_${_pageRef}:blackListCO.cifCO.cifVO.ID_NO,
				                    blackListVO_BRIEF_NAME_ENG_${_pageRef}:blackListCO.cifCO.cifVO.SHORT_NAME_ENG,
				                    blackListVO_BRIEF_NAME_ARAB_${_pageRef}:blackListCO.cifCO.cifVO.SHORT_NAME_ARAB,
				                    blackListVO_LONG_NAME_ENG_${_pageRef}:blackListCO.cifCO.cifVO.LONG_NAME_ENG,
				                    blackListVO_LONG_NAME_ARAB_${_pageRef}:blackListCO.cifCO.cifVO.LONG_NAME_ARAB,
				                    blackListVO_CIF_MOTHER_FNAME_${_pageRef}:blackListCO.cifCO.cifVO.MOTHER_FIRST_NAME,
				                    blackListVO_CIF_MOTHER_LNAME_${_pageRef}:blackListCO.cifCO.cifVO.MOTHER_LAST_NAME,
				                    blackListVO_CIF_FIRST_NAME_ENG_${_pageRef}:blackListCO.cifCO.cifVO.FIRST_NAME_ENG,
				                    blackListVO_CIF_SEC_NAME_ENG_${_pageRef}:blackListCO.cifCO.cifVO.SEC_NAME_ENG,
				                    blackListVO_CIF_THIRD_NAME_ENG_${_pageRef}:blackListCO.cifCO.cifVO.THIRD_NAME_ENG,
				                    blackListVO_CIF_LAST_NAME_ENG_${_pageRef}:blackListCO.cifCO.cifVO.LAST_NAME_ENG,
				                    blackListVO_CIF_FIRST_NAME_AR_${_pageRef}:blackListCO.cifCO.cifVO.FIRST_NAME_AR,
				                    blackListVO_CIF_SEC_NAME_AR_${_pageRef}:blackListCO.cifCO.cifVO.SEC_NAME_AR,
				                    blackListVO_CIF_THIRD_NAME_AR_${_pageRef}:blackListCO.cifCO.cifVO.THIRD_NAME_AR,
				                    blackListVO_CIF_LAST_NAME_AR_${_pageRef}:blackListCO.cifCO.cifVO.LAST_NAME_AR,
				                    blackListVO_DATE_OF_BIRTH_${_pageRef}:blackListCO.cifCO.cifVO.BIRTH_DATE,
				                    blackListVO_TYPE_${_pageRef}:blackListCO.cifCO.cifVO.TYPE"
						parameter="blackListVO.OID_DOCUMENT_NBR:blackListVO_OID_DOCUMENT_NBR_${_pageRef},blackListVO.CODE:blackListVO_CODE_${_pageRef}"
						/>
					</td>
					<td colspan="4"></td>
					<td class="fldLabelView" >
						<ps:label key="Register_No_key" id="lbl_blackListVO_CIF_REGISTER_NO_${_pageRef}" for="blackListVO_CIF_REGISTER_NO_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center" >
						<ps:textfield name="blackListCO.blackListVO.CIF_REGISTER_NO" id="blackListVO_CIF_REGISTER_NO_${_pageRef}"
						 	maxlength="20"  mode="number"
						/>
					</td>
				</tr>
				<tr>
	  				<td class="fldLabelView">
						<ps:label key="Legal_Status_key" id="lbl_blackListVO_LEGAL_STATUS_${_pageRef}" for="lookuptxt_blackListVO_LEGAL_STATUS_${_pageRef}"/>
					</td>
					<td colspan="2">
						<psj:livesearch id="blackListVO_LEGAL_STATUS_${_pageRef}" name="blackListCO.blackListVO.LEGAL_STATUS"
							actionName="${pageContext.request.contextPath}/pathdesktop/LegalStatus_constructLookup"
		                    searchElement="STATUS_CODE"  autoSearch="false" size="10" mode="number" maxlength="3" leadZeros="3"
		                    resultList="LONG_DESC_ENG:blackListCO_legalStatusDesc_${_pageRef}"
		                    
		                    dependencySrc="${pageContext.request.contextPath}/pathdesktop/LegalStatusDependencyAction_dependencyByStatusCode"
                      		dependency="blackListCO_legalStatusDesc_${_pageRef}:legalStatusVO.LONG_DESC_ENG,lookuptxt_blackListVO_LEGAL_STATUS_${_pageRef}:legalStatusVO.STATUS_CODE"
		                    parameter="legalStatusSC.statusCode:lookuptxt_blackListVO_LEGAL_STATUS_${_pageRef}"
		                
		                
		                />
		            </td>
		             <td colspan="2">
		                <ps:textfield name="blackListCO.legalStatusDesc" id="blackListCO_legalStatusDesc_${_pageRef}" readonly="true"/>
					</td>
					<td colspan="2"></td>
					<td class="fldLabelView" >
						 <ps:label key="Doc_Reg_No_2" id="lbl_blackListVO_REG_NO_2_${_pageRef}" for="blackListVO_REG_NO_2_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center" colspan="2">
						<ps:textarea  name="blackListCO.blackListVO.REG_NO_2" id="blackListVO_REG_NO_2_${_pageRef}" cssClass="textCompSize ui-state-focus ui-corner-all" cssStyle="height:70px;"
						maxlength="250"
						/>
					</td>
				</tr>
	  			<tr>
					<td colspan="4" align="center">
						<psj:a id="blackList_id_Btn_${_pageRef}" button="true" buttonIcon="ui-icon-carat-1-s" onclick="blackListIds_showHideBlackListIdGrid()">
							<ps:label key='IDs_key'/>
						</psj:a>
					</td>
					<td colspan="5"></td>
				</tr>
				
				<tr  style="visibility: collapse;" id="blackList_idTr_${_pageRef}" align="center">
					<td colspan="9" >
						<jsp:include page="BlackListIdsGrid.jsp"></jsp:include>
					</td>
					
				</tr>
				<tr>
	  				<td colspan="9">
	  					<div class="ui-state-active"></div>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td class="fldLabelView">
						<ps:label key="CIF_key" id="lbl_blackListVO_CIF_${_pageRef}" for="lookuptxt_blackListVO_CIF_${_pageRef}"/>
					</td>
					<td colspan="2">
						<psj:livesearch id="blackListVO_CIF_${_pageRef}" name="blackListCO.blackListVO.CIF"
							actionName="${pageContext.request.contextPath}/pathdesktop/CifLookup_constructLookup" 
		                    searchElement="CIF_NO"  autoSearch="false" size="10" mode="number" maxlength="8" leadZeros="8"
		                    resultList="SHORT_NAME_ENG:blackListCO_cifDesc_${_pageRef}"
		                    
							dependencySrc="${pageContext.request.contextPath}/path/blackList/BlackListDependency_dependnecyByCIFNo"
		                    dependency="blackListCO_cifDesc_${_pageRef}:blackListCO.cifCO.cifVO.SHORT_NAME_ENG,
		                    			lookuptxt_blackListVO_COUNTRY_${_pageRef}:blackListCO.cifCO.cifVO.COUNTRY,
					                    blackListCO_countriesDesc_${_pageRef}:blackListCO.cifCO.COUNTRY_DESC,
					                    lookuptxt_blackListVO_CIF_REGION_CODE_${_pageRef}:blackListCO.cifCO.cifVO.REGION_CODE,
					                    blackListCO_regionDesc_${_pageRef}:blackListCO.cifCO.REGION_DESC,
					                    lookuptxt_blackListVO_CIF_NATION_CODE_${_pageRef}:blackListCO.cifCO.cifVO.NATION_CODE,
					                    blackListCO_nationDesc_${_pageRef}:blackListCO.cifCO.NATION_DESC,
					                    lookuptxt_blackListVO_LEGAL_STATUS_${_pageRef}:blackListCO.cifCO.cifVO.LEGAL_STATUS,
					                    blackListCO_legalStatusDesc_${_pageRef}:blackListCO.cifCO.LEGAL_STATUS_DESC,
					                    lookuptxt_blackListVO_CIF_TYPE_${_pageRef}:blackListCO.cifCO.cifVO.CIF_TYPE,
					                    blackListCO_ciftypeDesc_${_pageRef}:blackListCO.cifCO.CIF_TYPE_DESC,
					                    blackListVO_CIF_REGISTER_NO_${_pageRef}:blackListCO.cifCO.cifVO.REGISTER_NO,
					                    blackListVO_OID_DOCUMENT_NBR_${_pageRef}:blackListCO.cifCO.cifVO.ID_NO,
					                    blackListVO_BRIEF_NAME_ENG_${_pageRef}:blackListCO.cifCO.cifVO.SHORT_NAME_ENG,
					                    blackListVO_BRIEF_NAME_ARAB_${_pageRef}:blackListCO.cifCO.cifVO.SHORT_NAME_ARAB,
					                    blackListVO_LONG_NAME_ENG_${_pageRef}:blackListCO.cifCO.cifVO.LONG_NAME_ENG,
					                    blackListVO_LONG_NAME_ARAB_${_pageRef}:blackListCO.cifCO.cifVO.LONG_NAME_ARAB,
					                    blackListVO_CIF_MOTHER_FNAME_${_pageRef}:blackListCO.cifCO.cifVO.MOTHER_FIRST_NAME,
					                    blackListVO_CIF_MOTHER_LNAME_${_pageRef}:blackListCO.cifCO.cifVO.MOTHER_LAST_NAME,
					                    blackListVO_CIF_FIRST_NAME_ENG_${_pageRef}:blackListCO.cifCO.cifVO.FIRST_NAME_ENG,
					                    blackListVO_CIF_SEC_NAME_ENG_${_pageRef}:blackListCO.cifCO.cifVO.SEC_NAME_ENG,
					                    blackListVO_CIF_THIRD_NAME_ENG_${_pageRef}:blackListCO.cifCO.cifVO.THIRD_NAME_ENG,
					                    blackListVO_CIF_LAST_NAME_ENG_${_pageRef}:blackListCO.cifCO.cifVO.LAST_NAME_ENG,
					                    blackListVO_CIF_FIRST_NAME_AR_${_pageRef}:blackListCO.cifCO.cifVO.FIRST_NAME_AR,
					                    blackListVO_CIF_SEC_NAME_AR_${_pageRef}:blackListCO.cifCO.cifVO.SEC_NAME_AR,
					                    blackListVO_CIF_THIRD_NAME_AR_${_pageRef}:blackListCO.cifCO.cifVO.THIRD_NAME_AR,
					                    blackListVO_CIF_LAST_NAME_AR_${_pageRef}:blackListCO.cifCO.cifVO.LAST_NAME_AR,
					                    blackListVO_DATE_OF_BIRTH_${_pageRef}:blackListCO.cifCO.cifVO.BIRTH_DATE,
				              			lookuptxt_blackListVO_CIF_${_pageRef}:blackListCO.cifCO.cifVO.CIF_NO,
					                    blackListVO_TYPE_${_pageRef}:blackListCO.cifCO.cifVO.TYPE,
					                    blackListVO_CIF_PLACE_OF_BIRTH_${_pageRef}:blackListCO.cifCO.cifVO.PLACE_OF_BIRTH
					                    "
							parameter="cifCO.cifVO.CIF_NO:lookuptxt_blackListVO_CIF_${_pageRef},blackListVO.CODE:blackListVO_CODE_${_pageRef}"
						/>
		             </td>
		             <td colspan="2">
		                <ps:textfield name="blackListCO.cifDesc" id="blackListCO_cifDesc_${_pageRef}" readonly="true"/>
					</td>
					<td colspan="4"></td>
				</tr>
	  			<tr>
		  			<td class="fldLabelView ">
						<ps:label key="Brief_Desc_Eng_key" id="lbl_blackListVO_BRIEF_NAME_ENG_${_pageRef}" for="blackListVO_BRIEF_NAME_ENG_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center" colspan="2">
						<ps:textfield name="blackListCO.blackListVO.BRIEF_NAME_ENG" maxlength="20" id="blackListVO_BRIEF_NAME_ENG_${_pageRef}"
						maxLength="20"
						/>
					</td>
					<td colspan="3"></td>
					<td class="fldDataEdit center" colspan="2">
						<ps:textfield name="blackListCO.blackListVO.BRIEF_NAME_ARAB" maxlength="20" id="blackListVO_BRIEF_NAME_ARAB_${_pageRef}"  cssStyle="direction:rtl" 
						maxLength="20"
						/>
					</td>
					<td class="fldLabelView right">
						<ps:label key="Brief_Desc_Arab_key" id="lbl_blackListVO_BRIEF_NAME_ARAB_${_pageRef}" for="blackListVO_BRIEF_NAME_ARAB_${_pageRef}"/>
					</td>
				</tr>
				
				<tr>
					<td class="fldLabelView ">
						<ps:label key="Long_Desc_Eng_key" id="lbl_blackListVO_LONG_NAME_ENG_${_pageRef}" for="blackListVO_LONG_NAME_ENG_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center" colspan="3">
						<ps:textfield name="blackListCO.blackListVO.LONG_NAME_ENG" maxlength="100" id="blackListVO_LONG_NAME_ENG_${_pageRef}"
						maxLength="100"
						/>
					</td>
					<td></td>
					<td class="fldDataEdit center" colspan="3">
						<ps:textfield name="blackListCO.blackListVO.LONG_NAME_ARAB" maxlength="40" id="blackListVO_LONG_NAME_ARAB_${_pageRef}" cssStyle="direction:rtl"
						maxLength="40"
						/>
					</td>
					<td class="fldLabelView right">
						<ps:label key="Long_Desc_Arab_key" id="lbl_blackListVO_LONG_NAME_ARAB_${_pageRef}" for="blackListVO_LONG_NAME_ARAB_${_pageRef}"/>
					</td>
				</tr>
				<tr>
	  				<td colspan="9">
	  					<div class="ui-state-active"></div>
	  				</td>
	  			</tr>
	  			<tr>
					<td class="fldLabelView">
						<ps:label key="Mother_First_Name_key" id="lbl_blackListVO_CIF_MOTHER_FNAME_${_pageRef}" for="blackListVO_CIF_MOTHER_FNAME_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center" colspan="3">
						<ps:textfield name="blackListCO.blackListVO.CIF_MOTHER_FNAME" maxlength="25" id="blackListVO_CIF_MOTHER_FNAME_${_pageRef}" 
						maxLength="25"
						/>
					</td>
					<td></td>
					<td class="fldDataEdit center" colspan="3">
						<ps:textfield name="blackListCO.blackListVO.CIF_MOTHER_FNAME_ARAB" maxlength="25" id="blackListVO_CIF_MOTHER_FNAME_ARAB_${_pageRef}" cssStyle="direction:rtl" 
						maxLength="25"
						/>
					</td>
					<td class="fldLabelView right">
						<ps:label key="mother_first_name_arab_key" id="lbl_blackListVO_CIF_MOTHER_FNAME_ARAB_${_pageRef}" for="blackListVO_CIF_MOTHER_FNAME_ARAB_${_pageRef}"/>
					</td>
				</tr>
				
				<tr>
					<td class="fldLabelView">
						<ps:label key="Mother_Last_Name_key" id="lbl_blackListVO_CIF_MOTHER_LNAME_${_pageRef}" for="blackListVO_CIF_MOTHER_LNAME_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center" colspan="3">
						<ps:textfield name="blackListCO.blackListVO.CIF_MOTHER_LNAME" maxlength="25" id="blackListVO_CIF_MOTHER_LNAME_${_pageRef}" 
						maxLength="25"
						/>
					</td>
					<td></td>
					<td class="fldDataEdit center" colspan="3">
						<ps:textfield name="blackListCO.blackListVO.CIF_MOTHER_LNAME_ARAB" maxlength="25" id="blackListVO_CIF_MOTHER_LNAME_ARAB_${_pageRef}" cssStyle="direction:rtl" 
						maxLength="25"
						/>
					</td>
					<td class="fldLabelView right">
						<ps:label key="mother_last_name_arab_key" id="lbl_blackListVO_CIF_MOTHER_LNAME_ARAB_${_pageRef}" for="blackListVO_CIF_MOTHER_LNAME_ARAB_${_pageRef}"/>
					</td>
				</tr>
				
				<tr>
				  	<td class="fldLabelView">
						<ps:label key="First_Name_eng_static_key" id="lbl_blackListVO_CIF_FIRST_NAME_ENG_${_pageRef}" for="blackListVO_CIF_FIRST_NAME_ENG_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center" colspan="3">
						<ps:textfield name="blackListCO.blackListVO.CIF_FIRST_NAME_ENG" maxlength="30" id="blackListVO_CIF_FIRST_NAME_ENG_${_pageRef}" 
						maxLength="30"
						/>
					</td>
					<td></td>
					<td class="fldDataEdit center" colspan="3">
						<ps:textfield name="blackListCO.blackListVO.CIF_FIRST_NAME_AR" maxlength="30" id="blackListVO_CIF_FIRST_NAME_AR_${_pageRef}" cssStyle="direction:rtl" 
						maxLength="30"
						/>
					</td>
					<td class="fldLabelView right">
						<ps:label key="First_Name_ar_key" id="lbl_blackListVO_CIF_FIRST_NAME_AR_${_pageRef}" for="blackListVO_CIF_FIRST_NAME_AR_${_pageRef}"/>
					</td>
				</tr>
				<tr>
					<td class="fldLabelView">
						<ps:label key="Second_Name_eng_static_key" id="lbl_blackListVO_CIF_SEC_NAME_ENG_${_pageRef}" for="blackListVO_CIF_SEC_NAME_ENG_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center" colspan="3">
						<ps:textfield name="blackListCO.blackListVO.CIF_SEC_NAME_ENG" maxlength="30" id="blackListVO_CIF_SEC_NAME_ENG_${_pageRef}" 
						maxLength="30"
						/>
					</td>
					<td></td>
					<td class="fldDataEdit center" colspan="3">
						<ps:textfield name="blackListCO.blackListVO.CIF_SEC_NAME_AR" maxlength="30" id="blackListVO_CIF_SEC_NAME_AR_${_pageRef}" cssStyle="direction:rtl" 
						maxLength="30"
						/>
					</td>
					<td class="fldLabelView right" >
						<ps:label key="Second_Name_ar_key" id="lbl_blackListVO_CIF_SEC_NAME_AR_${_pageRef}" for="blackListVO_CIF_SEC_NAME_AR_${_pageRef}"/>
					</td>
				</tr>
				<tr>
					<td class="fldLabelView">
						<ps:label key="Third_Name_eng_static_key" id="lbl_blackListVO_CIF_THIRD_NAME_ENG_${_pageRef}" for="blackListVO_CIF_THIRD_NAME_ENG_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center" colspan="3">
						<ps:textfield name="blackListCO.blackListVO.CIF_THIRD_NAME_ENG" maxlength="30" id="blackListVO_CIF_THIRD_NAME_ENG_${_pageRef}" 
						maxLength="30"
						/>
					</td>
					<td></td>
					<td class="fldDataEdit center" colspan="3">
						<ps:textfield name="blackListCO.blackListVO.CIF_THIRD_NAME_AR" maxlength="30" id="blackListVO_CIF_THIRD_NAME_AR_${_pageRef}" cssStyle="direction:rtl" 
						maxLength="30"
						/>
					</td>
					<td class="fldLabelView right" >
						<ps:label key="Third_Name_ar_key" id="lbl_blackListVO_CIF_THIRD_NAME_AR_${_pageRef}" for="blackListVO_CIF_THIRD_NAME_AR_${_pageRef}"/>
					</td>
				</tr>
				<tr>
					<td  class="fldLabelView">
						<ps:label key="Last_Name_eng_static_key" id="lbl_blackListVO_CIF_LAST_NAME_ENG_${_pageRef}" for="blackListVO_CIF_LAST_NAME_ENG_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center" colspan="3">
						<ps:textfield name="blackListCO.blackListVO.CIF_LAST_NAME_ENG" maxlength="30" id="blackListVO_CIF_LAST_NAME_ENG_${_pageRef}" 
						maxLength="30"
						/>
					</td>
					<td></td>
					<td class="fldDataEdit center" colspan="3">
						<ps:textfield name="blackListCO.blackListVO.CIF_LAST_NAME_AR" maxlength="30" id="blackListVO_CIF_LAST_NAME_AR_${_pageRef}" cssStyle="direction:rtl" 
						maxLength="30"
						/>
					</td>
					<td class="fldLabelView right" >
						<ps:label key="Last_Name_ar_key" id="lbl_blackListVO_CIF_LAST_NAME_AR_${_pageRef}" for="blackListVO_CIF_LAST_NAME_AR_${_pageRef}"/>
					</td>
				</tr>
				<tr>
	  				<td colspan="9">
	  					<div class="ui-state-active"></div>
	  				</td>
	  			</tr>
	  			<tr>
					<td class="fldLabelView" >
						 <ps:label key="Date_of_Birth_Establishement_key" id="lbl_blackListVO_DATE_OF_BIRTH_${_pageRef}" for="blackListVO_DATE_OF_BIRTH_${_pageRef}"/>
					</td>
					<td class="fldDataEdit" colspan="3">
						<psj:datepicker buttonImageOnly="true" name="blackListCO.blackListVO.DATE_OF_BIRTH" id="blackListVO_DATE_OF_BIRTH_${_pageRef}"
							dependencySrc="${pageContext.request.contextPath}/path/blackList/BlackListDependency_dependencyValidationByBlackListBirthDate"
							parameter="blackListVO.DATE_OF_BIRTH:blackListVO_DATE_OF_BIRTH_${_pageRef}"
					    	dependency="blackListVO_DATE_OF_BIRTH_${_pageRef}:blackListCO.blackListVO.DATE_OF_BIRTH"
					    	
					    />
					</td>
					<td></td>
	  				<td class="fldLabelView" colspan="2">
						<ps:label key="Country_Of_Citizenship_key" id="lbl_blackListVO_COUNTRY_${_pageRef}" for="lookuptxt_blackListVO_COUNTRY_${_pageRef}"/>
					</td>
					<td >
						<psj:livesearch id="blackListVO_COUNTRY_${_pageRef}" name="blackListCO.blackListVO.COUNTRY"
							actionName="${pageContext.request.contextPath}/pathdesktop/CountriesLookup_constructLookup" 
		                    searchElement="COUNTRY_CODE"  autoSearch="false" size="10" mode="number" maxlength="3" leadZeros="3"
		                    resultList="LONG_DESC_ENG:blackListCO_countriesDesc_${_pageRef}"
		                    
		                    dependencySrc="${pageContext.request.contextPath}/pathdesktop/CountriesDependencyAction_dependencyByCountryCode"
		                    dependency="blackListCO_countriesDesc_${_pageRef}:countriesVO.LONG_DESC_ENG,lookuptxt_blackListVO_COUNTRY_${_pageRef}:countriesVO.COUNTRY_CODE,lookuptxt_blackListVO_CIF_REGION_CODE_${_pageRef}:null,blackListCO_regionDesc_${_pageRef}:null"
		                    parameter="COUNTRY_CODE:lookuptxt_blackListVO_COUNTRY_${_pageRef}"
		                />
		             </td>
		             <td>
		                <ps:textfield name="blackListCO.countriesDesc" id="blackListCO_countriesDesc_${_pageRef}" readonly="true"/>
					</td>
				</tr>
					<tr>
					<td class="fldLabelView" >
						 <ps:label key="Place_of_Birth_key" id="lbl_blackListVO_CIF_PLACE_OF_BIRTH_${_pageRef}" for="blackListVO_CIF_PLACE_OF_BIRTH_${_pageRef}"/>
					</td>
					<td class="fldDataEdit" colspan="3">
						<ps:textfield name="blackListCO.blackListVO.CIF_PLACE_OF_BIRTH" id="blackListVO_CIF_PLACE_OF_BIRTH_${_pageRef}"
						 maxlength="20" 
						/>
					</td>
					<td></td>
	  				<td class="fldLabelView" colspan="2">
						<ps:label key="Region_key" id="lbl_blackListVO_CIF_REGION_CODE_${_pageRef}" for="lookuptxt_blackListVO_CIF_REGION_CODE_${_pageRef}"/>
					</td>
					<td >
						<psj:livesearch id="blackListVO_CIF_REGION_CODE_${_pageRef}" name="blackListCO.blackListVO.CIF_REGION_CODE"
							actionName="${pageContext.request.contextPath}/pathdesktop/CountriesRegion_constructLookup"
		                    resultList="BRIEF_DESC_ENG:blackListCO_regionDesc_${_pageRef}"
							paramList="COUNTRY_CODE:lookuptxt_blackListVO_COUNTRY_${_pageRef}"
		                    searchElement="REGION_CODE"  autoSearch="false" size="10" mode="number" maxlength="6" leadZeros="6"
		                    
		                    dependencySrc="${pageContext.request.contextPath}/pathdesktop/CountriesRegionDependencyAction_dependencyByRegionCode"
		                    dependency="lookuptxt_blackListVO_CIF_REGION_CODE_${_pageRef}:countriesRegionVO.REGION_CODE,blackListCO_regionDesc_${_pageRef}:countriesRegionVO.BRIEF_DESC_ENG"
		                    parameter="REGION_CODE:lookuptxt_blackListVO_CIF_REGION_CODE_${_pageRef},COUNTRY_CODE:lookuptxt_blackListVO_COUNTRY_${_pageRef}"
		                />
		             </td>
		             <td >
		                <ps:textfield name="blackListCO.regionDesc" id="blackListCO_regionDesc_${_pageRef}" readonly="true"/>
					</td>
				</tr>
				
				<tr>
					<td class="fldLabelView">
						<ps:label key="Nationality_key" id="lbl_blackListVO_CIF_NATION_CODE_${_pageRef}" for="lookuptxt_blackListVO_CIF_NATION_CODE_${_pageRef}"/>
					</td>
					<td>
						<psj:livesearch id="blackListVO_CIF_NATION_CODE_${_pageRef}" name="blackListCO.blackListVO.CIF_NATION_CODE"
							actionName="${pageContext.request.contextPath}/pathdesktop/NationalityLookup_constructLookup" 
		                    searchElement="CODE"  autoSearch="false" size="10" mode="number" maxlength="3" leadZeros="3"
		                    resultList="BRIEF_DESC_ENG:blackListCO_nationDesc_${_pageRef}"
		                    
		                    dependencySrc="${pageContext.request.contextPath}/pathdesktop/NationalityDependencyAction_dependencyByNationalityCode"
	                        dependency="blackListCO_nationDesc_${_pageRef}:nationalityVO.BRIEF_DESC_ENG,lookuptxt_blackListVO_CIF_NATION_CODE_${_pageRef}:nationalityVO.CODE"
	                        parameter="NATIONALITY_CODE:lookuptxt_blackListVO_CIF_NATION_CODE_${_pageRef}"
		                />
		             </td>
		             <td colspan="2">
		                <ps:textfield name="blackListCO.nationDesc" id="blackListCO_nationDesc_${_pageRef}" readonly="true"/>
					</td>
					<td colspan="5"></td>
				</tr>
				
				<tr>
					<td class="fldLabelView">
						<ps:label key="Cif_Type_key" id="lbl_blackListVO_CIF_TYPE_${_pageRef}" for="lookuptxt_blackListVO_CIF_TYPE_${_pageRef}"/>
					</td>
					<td>
						<psj:livesearch id="blackListVO_CIF_TYPE_${_pageRef}" name="blackListCO.blackListVO.CIF_TYPE"
							actionName="${pageContext.request.contextPath}/pathdesktop/CifTypeLookup_constructLookup" 
		                    searchElement="TYPE_CODE"  autoSearch="false" size="10" mode="number" maxlength="4" leadZeros="4"
		                    resultList="BRIEF_DESC_ENG:blackListCO_ciftypeDesc_${_pageRef}"
		                    
		                    dependencySrc="${pageContext.request.contextPath}/pathdesktop/CifTypeDependencyAction_dependencyByCifTypeCode"
		                    dependency="blackListCO_ciftypeDesc_${_pageRef}:cifTypeVO.BRIEF_DESC_ENG,lookuptxt_blackListVO_CIF_TYPE_${_pageRef}:cifTypeVO.TYPE_CODE,blackListVO_TYPE_${_pageRef}:cifTypeVO.VT_IND"
		                    parameter="cifTypeCode:lookuptxt_blackListVO_CIF_TYPE_${_pageRef}"
		                />
		             </td>
		             <td colspan="2">
		                <ps:textfield name="blackListCO.ciftypeDesc" id="blackListCO_ciftypeDesc_${_pageRef}" readonly="true"/>
					</td>
					<td colspan="5"></td>
				</tr>
				<tr>
					<td class="fldLabelView">
						<ps:label key="Individual_Institution_key" id="lbl_blackListVO_TYPE_${_pageRef}" for="blackListVO_TYPE_${_pageRef}"/>
					</td>
					<%-- 
					<td colspan="2">
						<ps:radio list="{'Individual_key'}"  name="blackListCO.blackListVO.TYPE" id="blackListVO_TYPE_${_pageRef}" value="V"/>
		             </td>
		             <td colspan="2">
		                <ps:radio list="{'Institution_key'}" name="blackListCO.blackListVO.TYPE" id="blackListVO_TYPE_${_pageRef}" value="T"/>
					</td>
					--%>
					<td colspan="4">
					<%-- 
						<ps:radio list="#{'V':'Individual_key','T':'Institution_key'}" name="blackListCO.blackListVO.TYPE" id="blackListVO_TYPE_${_pageRef}" value="V"/>
					--%>
						<ps:radio theme="simple" id="blackListVO_TYPE_${_pageRef}" name="blackListCO.blackListVO.TYPE"
							list="typeRadioMap" value="typeRadioMapDefaultValue" />
					</td>
					
					<td colspan="4"></td>
				</tr>
				
	  	</table>
	  			
	  			
		
		</ps:collapspanel>
	  	<br/> 
<ps:collapspanel id="blackListAdditionalDetails" cssClass="collapsed" key="Additional__Details_key">
			<table width="100%" border="0" class="headerPortionContent ui-widget-content">
				<tr>
					<td width="12%"></td>
					<td width="10%"></td>
					<td width="20%"></td>
					<td width="13%"></td>
					<td width="10%"></td>
					<td width="15%"></td>
					<td width="20%"></td>
				</tr>
	  			<tr>
			  		<td class="fldLabelView">
						<ps:label key="Issuing_Country_key" id="lbl_blackListVO_OID_ISSUING_COUNTRY_${_pageRef}" for="lookuptxt_blackListVO_OID_ISSUING_COUNTRY_${_pageRef}"/>
					</td>
					<td>
						<psj:livesearch id="blackListVO_OID_ISSUING_COUNTRY_${_pageRef}" name="blackListCO.blackListVO.OID_ISSUING_COUNTRY"
							actionName="${pageContext.request.contextPath}/pathdesktop/CountriesLookup_constructLookup" 
		                    searchElement="COUNTRY_CODE"  autoSearch="false" size="10" mode="number" maxlength="3" leadZeros="3"
		                    resultList="LONG_DESC_ENG:blackListCO_issueCountryDesc_${_pageRef}"
		                    
		                    dependencySrc="${pageContext.request.contextPath}/pathdesktop/CountriesDependencyAction_dependencyByCountryCode"
		                    dependency="blackListCO_issueCountryDesc_${_pageRef}:countriesVO.LONG_DESC_ENG,lookuptxt_blackListVO_OID_ISSUING_COUNTRY_${_pageRef}:countriesVO.COUNTRY_CODE"
		                    parameter="COUNTRY_CODE:lookuptxt_blackListVO_OID_ISSUING_COUNTRY_${_pageRef}"
		                />
		             </td>
		             <td>
		                <ps:textfield name="blackListCO.issueCountryDesc" id="blackListCO_issueCountryDesc_${_pageRef}" readonly="true"/>
					 </td>
					 <td></td>
					 <td class="fldLabelView">
						 <ps:label key="Date_Issued_key" id="lbl_blackListVO_OID_DATE_ISSUED_${_pageRef}" for="blackListVO_OID_DATE_ISSUED_${_pageRef}"/>
					 </td>
					 <td class="fldDataEdit" colspan="2">
						<psj:datepicker buttonImageOnly="true" name="blackListCO.blackListVO.OID_DATE_ISSUED" id="blackListVO_OID_DATE_ISSUED_${_pageRef}"
							dependencySrc="${pageContext.request.contextPath}/path/blackList/BlackListDependency_dependencyValidationByBlackListIssueDate"
							parameter="blackListVO.OID_DATE_ISSUED:blackListVO_OID_DATE_ISSUED_${_pageRef}"
		                    dependency="blackListVO_OID_DATE_ISSUED_${_pageRef}:blackListCO.blackListVO.OID_DATE_ISSUED"
		                />
					 </td>
				</tr>
				<tr>
	  				<td colspan="7">
	  					<div class="ui-state-active"></div>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td class="fldLabelView" >
					 <ps:label key="Source_Of_Blacklisting_key" id="lbl_blackListVO_SOURCE_OF_BLACKLISTING_${_pageRef}" for="blackListVO_SOURCE_OF_BLACKLISTING_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center" colspan="2">
						<ps:textfield name="blackListCO.blackListVO.SOURCE_OF_BLACKLISTING" id="blackListVO_SOURCE_OF_BLACKLISTING_${_pageRef}"
						maxlength="60"
						/>
					</td>
					<td colspan="4"></td>
	  			</tr>
	  			<tr>
	  				<td class="fldLabelView">
						<ps:label key="Source_Code_key" id="lbl_blackListVO_CODE_SOURCE_${_pageRef}" for="lookuptxt_blackListVO_CODE_SOURCE_${_pageRef}"/>
					</td>
					<td>
						<psj:livesearch id="blackListVO_CODE_SOURCE_${_pageRef}" name="blackListCO.blackListVO.CODE_SOURCE"
							actionName="${pageContext.request.contextPath}/pathdesktop/BlackSourceLookup_constructLookup" 
		                    searchElement="CODE"  autoSearch="false" size="10" mode="number" maxlength="4" leadZeros="4"
		                    resultList="BRIEF_DESC_ENG:blackListCO_codeSourceDesc_${_pageRef}"
		                    
		                    dependencySrc="${pageContext.request.contextPath}/pathdesktop/BlackSourceDependencyAction_dependencyByBlackSourceCode"
		                    dependency="blackListCO_codeSourceDesc_${_pageRef}:blacksourceVO.BRIEF_DESC_ENG,lookuptxt_blackListVO_CODE_SOURCE_${_pageRef}:blacksourceVO.CODE"
		                    parameter="CODE:lookuptxt_blackListVO_CODE_SOURCE_${_pageRef},isMainScreen:~CONST_0"
		                />
					</td>
		            <td>
		                <ps:textfield name="blackListCO.codeSourceDesc" id="blackListCO_codeSourceDesc_${_pageRef}" readonly="true"/>
					</td>
					<td colspan="4"></td>
	  			</tr>
	  			<tr>
	  				<td class="fldLabelView" >
					 <ps:label key="Source_Reference_key" id="lbl_blackListVO_SOURCE_REFERENCE_${_pageRef}" for="blackListVO_SOURCE_REFERENCE_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center" colspan="2">
						<ps:textfield name="blackListCO.blackListVO.SOURCE_REFERENCE" id="blackListVO_SOURCE_REFERENCE_${_pageRef}"
						maxlength="35"
						/>
					</td>
					<td></td>
					<td class="fldLabelView" >
						 <ps:label key="Source_Date_key" id="lbl_blackListVO_SOURCE_DATE_${_pageRef}" for="blackListVO_SOURCE_DATE_${_pageRef}"/>
					</td>
					<td class="fldDataEdit" colspan="2">
						<psj:datepicker buttonImageOnly="true" name="blackListCO.blackListVO.SOURCE_DATE" id="blackListVO_SOURCE_DATE_${_pageRef}"
							dependencySrc="${pageContext.request.contextPath}/path/blackList/BlackListDependency_dependencyValidationByBlackListSourceDate"
							parameter="blackListVO.BLACKLIST_TYPE:lookuptxt_blackListVO_BLACKLIST_TYPE_${_pageRef},blackListCO.blackListVO.SOURCE_DATE:blackListVO_SOURCE_DATE_${_pageRef}"
		                    dependency="blackListVO_SOURCE_DATE_${_pageRef}:blackListCO.blackListVO.SOURCE_DATE,blackListVO_REVISION_DATE_${_pageRef}:blackListCO.blackListVO.REVISION_DATE"
		                />
					</td>
	  			</tr>
	  			<tr>
	  				<td class="fldLabelView" >
					 <ps:label key="Reporting_Banks" id="lbl_blackListVO_REPORTING_BANKS_${_pageRef}" for="blackListVO_REPORTING_BANKS_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center" colspan="2">
						<ps:textarea  name="blackListCO.blackListVO.REPORTING_BANKS" id="blackListVO_REPORTING_BANKS_${_pageRef}" cssClass="textCompSize ui-state-focus ui-corner-all" cssStyle="height:70px;"
						maxlength="255"
						/>
					</td>
					<td colspan="4"></td>
	  			</tr>
	  			<tr>
	  				<td colspan="7">
	  					<div class="ui-state-active"></div>
	  				</td>
	  			</tr>
	  			<tr>
			  		<td class="fldLabelView">
						<ps:label key="Type_key" id="lbl_blackListVO_BLACKLIST_TYPE_${_pageRef}" for="lookuptxt_blackListVO_BLACKLIST_TYPE_${_pageRef}"/>
					</td>
					<td>
						<psj:livesearch id="blackListVO_BLACKLIST_TYPE_${_pageRef}" name="blackListCO.blackListVO.BLACKLIST_TYPE"
							actionName="${pageContext.request.contextPath}/pathdesktop/BlackListTypeLookup_constructLookup" 
		                    searchElement="CODE"  autoSearch="false" size="10" mode="number" maxlength="4" leadZeros="4"
		                    resultList="BRIEF_NAME_ENG:blackListCO_typeDesc_${_pageRef}"
		                    
		                    dependencySrc="${pageContext.request.contextPath}/path/blackList/BlackListDependency_dependencyByBlackListTypeCode"
		                    parameter="blackListVO.BLACKLIST_TYPE:lookuptxt_blackListVO_BLACKLIST_TYPE_${_pageRef},
										blackListVO.SOURCE_DATE:blackListVO_SOURCE_DATE_${_pageRef},
										blackListVO.REVISION_DATE:blackListVO_REVISION_DATE_${_pageRef},
										blackListVO.DATE_APPROVED:blackListVO_DATE_APPROVED_${_pageRef},
										blackListVO.DATE_CREATED:blackListVO_DATE_CREATED_${_pageRef}"
		                    dependency="blackListCO_typeDesc_${_pageRef}:blackListCO.typeDesc,
		                    			lookuptxt_blackListVO_BLACKLIST_TYPE_${_pageRef}:blackListCO.blackListVO.BLACKLIST_TYPE,
		                    			blackListVO_REVISION_DATE_${_pageRef}:blackListCO.blackListVO.REVISION_DATE"
		                    
		                />
		                <%-- 
		                    dependencySrc="${pageContext.request.contextPath}/pathdesktop/BlackListTypeDependencyAction_dependencyByBlackListTypeCode"
		                    dependency="blackListCO_typeDesc_${_pageRef}:blackListTypeVO.BRIEF_NAME_ENG,lookuptxt_blackListVO_BLACKLIST_TYPE_${_pageRef}:blackListTypeVO.CODE"
		                    parameter="CODE:lookuptxt_blackListVO_BLACKLIST_TYPE_${_pageRef}"
		                    --%>
		             </td>
		             <td>
		                <ps:textfield name="blackListCO.typeDesc" id="blackListCO_typeDesc_${_pageRef}" readonly="true"/>
					</td>
					<td></td>
					<td class="fldLabelView" >
						 <ps:label key="Revision_Date_key" id="lbl_blackListVO_REVISION_DATE_${_pageRef}" for="blackListVO_REVISION_DATE_${_pageRef}"/>
					</td>
					<td class="fldDataEdit" colspan="2">
						<psj:datepicker buttonImageOnly="true" name="blackListCO.blackListVO.REVISION_DATE" id="blackListVO_REVISION_DATE_${_pageRef}"
							dependencySrc="${pageContext.request.contextPath}/path/blackList/BlackListDependency_dependencyValidationByBlackListRevisionDate"
							parameter="blackListVO.OID_DATE_ISSUED:blackListVO_OID_DATE_ISSUED_${_pageRef},blackListVO.SOURCE_DATE:blackListVO_SOURCE_DATE_${_pageRef},blackListVO.REVISION_DATE:blackListVO_REVISION_DATE_${_pageRef}"
							dependency="blackListVO_REVISION_DATE_${_pageRef}:blackListCO.blackListVO.REVISION_DATE"
						/>
					</td>
	  			</tr>
	  			
	  			<tr>
	  				<td class="fldLabelView" >
					 	<ps:label key="Reason_key" id="lbl_blackListVO_REASON_${_pageRef}" for="blackListVO_REASON_${_pageRef}"/>
					</td>
					<td class="fldDataEdit center" colspan="2">
						<ps:textarea  name="blackListCO.blackListVO.REASON" id="blackListVO_REASON_${_pageRef}" cssClass="textCompSize ui-state-focus ui-corner-all" cssStyle="height:70px;"
						maxlength="100"
						/>
					</td>
					<td colspan="4"></td>
	  			</tr>
	  			<tr>
	  				<td colspan="7">
	  					<div class="ui-state-active"></div>
	  				</td>
	  			</tr>
	  		</table>
		</ps:collapspanel>
</ps:collapsgroup>
<br/>
<ptt:toolBar id="blackListToolBar_${_pageRef}" hideInAlert="true">

	<ps:url id="saveBlackListUrl" namespace="/path/blackList" action="BlackListMaint_saveBlackList" />
	<ps:url id="deleteBlackListUrl" namespace="/path/blackList" action="BlackListMaint_deleteBlackList" />
	<ps:url id="approveBlackListUrl" namespace="/path/blackList" action="BlackListMaint_approveBlackList" />
	<ps:url id="updateAfterApproveBlackListUrl" namespace="/path/blackList" action="BlackListMaint_saveBlackList" />
	<ps:url id="reverseBlackListUrl" namespace="/path/blackList" action="BlackListMaint_reverseBlackList" />
	<ps:url id="toBeReversedBlackListUrl" namespace="/path/blackList" action="BlackListMaint_toBeReversedBlackList" />
	
	<%-- Save --%>		 
	<ps:if test='%{iv_crud=="R" && (blackListCO.blackListVO.STATUS == null || blackListCO.blackListVO.STATUS=="A") }'>
		<psj:submit id="blackList_Save_btn_${_pageRef}" button="true" onclick="blacklistMaint_amendMethodName('%{saveBlackListUrl}')" freezeOnSubmit="true">
	 		<ps:label key="Save_key" for="blackList_Save_btn_${_pageRef}" />
	 	</psj:submit>
	</ps:if>


	<%-- Delete --%>
	<ps:if test='%{iv_crud=="R" && blackListCO.blackListVO.CODE!=null && blackListCO.blackListVO.STATUS=="A"}'>
		<psj:submit id="blackList_Delete_btn_${_pageRef}" button="true" type="button" onclick="blackListMgnt_deleteBlackList('%{deleteBlackListUrl}')" 
				freezeOnSubmit="true"  progRef="BL001D">
	 		<ps:label key="Delete_key" for="blackList_Delete_btn_${_pageRef}" />
	 	</psj:submit>
	</ps:if>
	
	<%-- Approve --%>
	<ps:if test='%{iv_crud=="P" && blackListCO.blackListVO.CODE!=null}'>
		<psj:submit id="blackList_Approve_btn_${_pageRef}" button="true" onclick="blacklistMaint_amendMethodName('%{approveBlackListUrl}')" 
				freezeOnSubmit="true"  progRef="BL001P">
	 		<ps:label key="Approve_key" for="blackList_Approve_btn_${_pageRef}" />
	 	</psj:submit>
	</ps:if>
	
	<%-- Update After Approve --%>
	<ps:if test='%{iv_crud=="UP" && blackListCO.blackListVO.CODE!=null}'>
		<psj:submit id="blackList_Update_Approve_btn_${_pageRef}" button="true" onclick="blacklistMaint_amendMethodName('%{updateAfterApproveBlackListUrl}')" 
				freezeOnSubmit="true"  progRef="BL001UP">
	 		<ps:label key="Update_After_Approve_key" for="blackList_Update_Approve_btn_${_pageRef}" />
	 	</psj:submit>
	</ps:if>
	
	<%-- Reverse --%>
	<ps:if test='%{iv_crud=="V" && blackListCO.blackListVO.CODE!=null}'>
		<psj:submit id="blackList_Reverse_btn_${_pageRef}" button="true" onclick="blacklistMaint_amendMethodName('%{reverseBlackListUrl}')" 
				freezeOnSubmit="true"  progRef="BL001V">
	 		<ps:label key="reverse_key" for="blackList_Reverse_btn_${_pageRef}" />
	 	</psj:submit>
	</ps:if>
	
	<%-- To be Reversed --%>
	<ps:if test='%{iv_crud=="TV" && blackListCO.blackListVO.CODE!=null}'>
		<psj:submit id="blackList_To_be_Reversed_btn_${_pageRef}" button="true" onclick="blacklistMaint_amendMethodName('%{toBeReversedBlackListUrl}')" 
				freezeOnSubmit="true"  progRef="BL001TV">
	 		<ps:label key="toBeReversed_key" for="blackList_To_be_Reversed_btn_${_pageRef}" />
	 	</psj:submit>
	</ps:if>
	<ps:if test="blackListCO.appName != 'AML'">
		<ps:if
			test='%{(blackListCO.blackListVO.CODE!=null)
				&&( blackListCO.blackListVO.STATUS=="A" || blackListCO.blackListVO.STATUS=="V" )
				&&(blackListCO.userIsBranchManager!="1")}'>
			<psj:a button="true" onclick="blackList_openAlertsClicked()">
				<ps:text name="Alerts_key"></ps:text>
			</psj:a>
		</ps:if>
	</ps:if>
	
</ptt:toolBar>
</ps:form>
<div id="blackListStatus_div_${_pageRef}"></div>

<script type="text/javascript">  
var Please_define_blacklist_code_key = "<ps:text name='Please_define_blacklist_code_key' />";
var Please_id_no_key = "<ps:text name='please_id_no_key' />";
var Please_id_type_key = "<ps:text name='please_id_type_key' />";

$(document).ready(function(){
	$("div#blackListMaint_Div_"+_pageRef+" .collapsibleContainer").collapsiblePanel();
	$( "#blackListMaint_Div_"+_pageRef).sortable({ handle : '.collapsibleContainerTitle'});
	$("#blackListMaintForm_"+_pageRef).processAfterValid("blackListMgnt_submitBlackList",[]);
	blackListMaint_onDocReady();
});

</script>