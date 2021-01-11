
function onEditInlineBeforeTopcics_addParamClass(entityType)
{
	//var entityType = $("#entityType_"+_pageRef).val();
	var criteriaParamGridTbl = $("#criteriaParamGridTbl_Id_" + _pageRef+"_"+entityType);

	var selRow = criteriaParamGridTbl.jqGrid("getGridParam", 'selrow');
	divId = $("#dialog_div_sp" + selRow + "_" + entityType + _pageRef);
	var paramVal = criteriaParamGridTbl.jqGrid("getCell", selRow, "ctsCriteriaParamVO.PARAM_CLASS");
	var paramType = criteriaParamGridTbl.jqGrid("getCell", selRow, "ctsCriteriaParamVO.PARAM_TYPE");
	  if (paramVal == "F" || paramVal == "D")
			  {
			    criteriaParamGridTbl.jqGrid('setCellValue',selRow,"ctsCriteriaParamVO.SESSION_ATTR_NAME",null);
			    criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.PARAM_VALUE", false);
			    criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.SESSION_ATTR_NAME", true);
			    criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.PARAM_QUERY_ID", true);
			    criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp", true);
			    criteriaParamGridTbl.jqGrid('setCellValue',selRow,"ctsCriteriaParamVO.PARAM_QUERY_ID",null);
		        criteriaParamGridTbl.jqGrid('setCellValue',selRow,"multiSelectlkp",null);
		        criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "criteriaSelectParameterDetails", true);
				criteriaParamGridTbl.jqGrid("setCellValue", selRow, "querySelectParamGridStr", "");
				criteriaParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray", "");
//				divId.empty().html("");
			  }
	  else if(paramVal == "S"  )
        	 {
                criteriaParamGridTbl.jqGrid('setCellValue',selRow,"ctsCriteriaParamVO.PARAM_VALUE",null);
		        criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.PARAM_VALUE", true);
		        criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.SESSION_ATTR_NAME", false);
		        criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.PARAM_QUERY_ID", true);
		        criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp", true);
		        criteriaParamGridTbl.jqGrid('setCellValue',selRow,"ctsCriteriaParamVO.PARAM_QUERY_ID",null);
		        criteriaParamGridTbl.jqGrid('setCellValue',selRow,"multiSelectlkp",null);
		        criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "criteriaSelectParameterDetails", true);
		        criteriaParamGridTbl.jqGrid("setCellValue", selRow, "querySelectParamGridStr", "");
		        criteriaParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray", "");
//				divId.empty().html("");
	         }
	//Added by bilal for Add Option 'Query'
	  else if(paramVal == "Q"  )
		  {
		  if(paramType != "DATE" && paramType != "DATETIME")
			 {
			  	 criteriaParamGridTbl.jqGrid('setCellValue',selRow,"ctsCriteriaParamVO.SESSION_ATTR_NAME",null);
			     criteriaParamGridTbl.jqGrid('setCellValue',selRow,"ctsCriteriaParamVO.PARAM_VALUE",null);
			     criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.PARAM_VALUE", true);
			     criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.SESSION_ATTR_NAME", true);
			     criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.PARAM_QUERY_ID", false);
			     criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp", false);
			     criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "criteriaSelectParameterDetails", false);
			 }
		  else
			 {
			   var preValue = criteriaParamGridTbl.jqGrid("getCellInputElt", selRow, "ctsCriteriaParamVO.PARAM_CLASS").attr("prevValue");
			   criteriaParamGridTbl.jqGrid('setCellValue',selRow,"ctsCriteriaParamVO.PARAM_CLASS", preValue);
			 }
		  }
	  else
		  {
			criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.PARAM_VALUE", true);
			criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.SESSION_ATTR_NAME", true);
			criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.PARAM_QUERY_ID", true);
			criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp", true);
			criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "criteriaSelectParameterDetails", true);
			criteriaParamGridTbl.jqGrid("setCellValue", selRow, "querySelectParamGridStr", "");
			criteriaParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray", "");
			criteriaParamGridTbl.jqGrid('setCellValue',selRow,"ctsCriteriaParamVO.SESSION_ATTR_NAME",null);
		    criteriaParamGridTbl.jqGrid('setCellValue',selRow,"ctsCriteriaParamVO.PARAM_VALUE",null);
		    criteriaParamGridTbl.jqGrid('setCellValue',selRow,"ctsCriteriaParamVO.PARAM_QUERY_ID",null);
	        criteriaParamGridTbl.jqGrid('setCellValue',selRow,"multiSelectlkp",null);
		  }
	  
  criteriaParamGridTbl.jqGrid('setDialogCellReadOnlyText', selRow, "multiSelectlkp", true);
  

}

function criteriaParam_onEditInlineBeforeTopics(entityType)
{
	var criteriaParamEntityType = $("#criteriaParamEntityType_"+_pageRef).val();
	
	var criteriaParamGridTbl = $("#criteriaParamGridTbl_Id_" + _pageRef+"_"+criteriaParamEntityType);
	var selRow = criteriaParamGridTbl.jqGrid("getGridParam", 'selrow');
	divId = $("#dialog_div_sp" + selRow + "_" + entityType  + _pageRef);
	var paramVal = criteriaParamGridTbl.jqGrid("getCell", selRow, "ctsCriteriaParamVO.PARAM_CLASS");
	
	if(paramVal == "S" )
	{
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.SESSION_ATTR_NAME", false);
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.PARAM_VALUE", true);
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.PARAM_QUERY_ID", true);
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp", true);
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "criteriaSelectParameterDetails", true);

	}
	else if(paramVal == "F"  || paramVal == "D")
	{
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.SESSION_ATTR_NAME", true);
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.PARAM_VALUE", false);
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.PARAM_QUERY_ID", true);
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp", true);
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "criteriaSelectParameterDetails", true);
	}
	else if(paramVal == "Q")
	{
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.SESSION_ATTR_NAME", true);
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.PARAM_VALUE", true);
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.PARAM_QUERY_ID", false);
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp", false);
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "criteriaSelectParameterDetails", false);
	}
	else
	{
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.PARAM_VALUE", true);
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.SESSION_ATTR_NAME", true);
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.PARAM_QUERY_ID", true);
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp", true);
		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "criteriaSelectParameterDetails", true);
		criteriaParamGridTbl.jqGrid("setCellValue", selRow, "querySelectParamGridStr", "");
		criteriaParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray", "");
	}
	
	//Commented by bilal and move it to segmentationParamList.js
	//Rania - ABSAI180073
//	debugger;
//	if(_pageRef.indexOf("CSG00CR") == 0)
//	{
//		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.SESSION_ATTR_NAME", true);
//		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.PARAM_VALUE", true);
//		criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsCriteriaParamVO.PARAM_CLASS", true);
//	}
	//
	
	criteriaParamGridTbl.jqGrid('setDialogCellReadOnlyText', selRow, "multiSelectlkp", true); //setDialogCellReadOnlyText //setCellEltReadOnly
	
	restrictParamType(criteriaParamEntityType);
	
}




function restrictParamType(entityType)
{
	var criteriaParamGridTbl = $("#criteriaParamGridTbl_Id_" + _pageRef + "_"
			+ entityType);
	var selRow = criteriaParamGridTbl.jqGrid("getGridParam", 'selrow');
	var paramType = criteriaParamGridTbl.jqGrid("getCell", selRow,
			"ctsCriteriaParamVO.PARAM_TYPE");
	var paramName = criteriaParamGridTbl.jqGrid("getCell", selRow,"ctsCriteriaParamVO.PARAM_NAME"); //added by bilalFor BUG#974702
	if (paramType == 'NUMBER') {
		var columnName = document.getElementById(selRow+ "_ctsCriteriaParamVO." + "PARAM_VALUE");
		//added by bilalFor BUG#974702
		if(paramName == "AL_SCORE_VALUE_FROM" || paramName == "AL_SCORE_VALUE_TO" || paramName.indexOf("AMOUNT")  == 0 || paramName.indexOf("_PERC") == 0)
		{
			$(columnName).numeric( {
				format : {format : "#,##0.000" }
			});
		}
		else
		{
			$(columnName).numeric();
		}
		//end bilal

	}

	else if (paramType == 'DATE') {
		var columnName = document.getElementById(selRow+ "_ctsCriteriaParamVO." + "PARAM_VALUE");
		$(columnName).datepicker();

	}

}

function onChangeParamQuery(entityType)
{
	var criteriaParamGridTbl = $("#criteriaParamGridTbl_Id_" + _pageRef+"_"+entityType);

	var selRow = criteriaParamGridTbl.jqGrid("getGridParam", 'selrow');
	var divId = $("#dialog_div_sp" + selRow + "_" + entityType + _pageRef);
	var paramVal = criteriaParamGridTbl.jqGrid("getCell", selRow, "ctsCriteriaParamVO.PARAM_CLASS");
	var paramQueryId = criteriaParamGridTbl.jqGrid("getCell", selRow, "ctsCriteriaParamVO.PARAM_QUERY_ID");
	if(paramVal == "Q"  )
	 {
		if(paramQueryId == null || paramQueryId == "")
		{
			criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp", true);
		}
		else
		{
			criteriaParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp", false);
		}
		
		criteriaParamGridTbl.jqGrid('setCellValue',selRow,"multiSelectlkp",null);
		criteriaParamGridTbl.jqGrid("setCellValue", selRow, "querySelectParamGridStr", "");
		criteriaParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray", "");
		divId.empty().html("");
	  }
	criteriaParamGridTbl.jqGrid('setDialogCellReadOnlyText', selRow, "multiSelectlkp", true);
}

function criteriaSelectParam_onEditInlineBeforeTopics(entityType)
{
	
}