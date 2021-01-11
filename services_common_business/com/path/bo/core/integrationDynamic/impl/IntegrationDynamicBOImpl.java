package com.path.bo.core.integrationDynamic.impl;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.integrationDynamic.IntegrationDynamicBO;
import com.path.bo.core.integrationDynamic.IntegrationDynamicConstant;
import com.path.dao.core.integrationDynamic.IntegrationDynamicDAO;
import com.path.dbmaps.vo.CIF_TRXTYPE_LIMITSVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.CommonLibSC;
import com.path.vo.core.integrationDynamic.IntegrationDynamicCO;
import com.path.vo.core.integrationDynamic.IntegrationDynamicSC;




public class IntegrationDynamicBOImpl extends BaseBO implements IntegrationDynamicBO
{

    private IntegrationDynamicDAO integrationDynamicDAO;
    
    public IntegrationDynamicCO returnColumnsLkpList(IntegrationDynamicSC integrationDynamicSC) throws BaseException
    {
	return integrationDynamicDAO.returnColumnsLkpList(integrationDynamicSC);
    }
    
    public int returndynamicIntegrationListCount(IntegrationDynamicSC integrationDynamicSC) throws BaseException
    {
	return integrationDynamicDAO.returndynamicIntegrationListCount(integrationDynamicSC);
    }

    /**
     * Method used to return List of dynamicIntegration
     * 
     * @param criteria Search Criteria Parameter
     * @return List Result
     * @throws BaseException
     */
    public List returndynamicIntegrationList(IntegrationDynamicSC integrationDynamicSC) throws BaseException
    {
	List<IntegrationDynamicCO> integrationDynList = integrationDynamicDAO.returndynamicIntegrationList(integrationDynamicSC);
	/*  TP#333970 invalid numeric format is shown in integration screen
	 *  This method is added to remove the .000 in case of dynamic look up integration opening in Trx screen,
	 * since in case the number is saved .000 in the DB (sybase) , so , It will be shown with .000 in the lookup (even if the type of the column is set to number) which is wrong  */
	trailingZerosFromNumber(integrationDynList);
	return integrationDynList ;
    }
    
    public List trailingZerosFromNumber(List<IntegrationDynamicCO> integrationDynList ) throws BaseException
    {
	for (int i=0; i <integrationDynList.size();i++ )
	{
	    if (null != integrationDynList.get(i).getCts_integrationVO().getNUMBER1())
	    {
	      if (integrationDynList.get(i).getCts_integrationVO().getNUMBER1().toString().contains(".000"))
	       {
		  integrationDynList.get(i).getCts_integrationVO().setNUMBER1(new BigDecimal(integrationDynList.get(i).getCts_integrationVO().getNUMBER1().stripTrailingZeros().toPlainString()));
	       }
	    }
	    if (null != integrationDynList.get(i).getCts_integrationVO().getNUMBER2())
	    {
	      if (integrationDynList.get(i).getCts_integrationVO().getNUMBER2().toString().contains(".000"))
	       {
		  integrationDynList.get(i).getCts_integrationVO().setNUMBER2(new BigDecimal(integrationDynList.get(i).getCts_integrationVO().getNUMBER2().stripTrailingZeros().toPlainString()));
	       }
	    }
	    if (null != integrationDynList.get(i).getCts_integrationVO().getNUMBER3())
	    {
	      if (integrationDynList.get(i).getCts_integrationVO().getNUMBER3().toString().contains(".000"))
	       {
		  integrationDynList.get(i).getCts_integrationVO().setNUMBER3(new BigDecimal(integrationDynList.get(i).getCts_integrationVO().getNUMBER3().stripTrailingZeros().toPlainString()));
	       }
	    }
	    if (null != integrationDynList.get(i).getCts_integrationVO().getNUMBER4())
	    {
	      if (integrationDynList.get(i).getCts_integrationVO().getNUMBER4().toString().contains(".000"))
	       {
		  integrationDynList.get(i).getCts_integrationVO().setNUMBER4(new BigDecimal(integrationDynList.get(i).getCts_integrationVO().getNUMBER4().stripTrailingZeros().toPlainString()));
	       }
	    }
	    if (null != integrationDynList.get(i).getCts_integrationVO().getNUMBER5())
	    {
	      if (integrationDynList.get(i).getCts_integrationVO().getNUMBER5().toString().contains(".000"))
	       {
		  integrationDynList.get(i).getCts_integrationVO().setNUMBER5(new BigDecimal(integrationDynList.get(i).getCts_integrationVO().getNUMBER5().stripTrailingZeros().toPlainString()));
	       }
	    }
	    if (null != integrationDynList.get(i).getCts_integrationVO().getNUMBER6())
	    {
	      if (integrationDynList.get(i).getCts_integrationVO().getNUMBER6().toString().contains(".000"))
	       {
		  integrationDynList.get(i).getCts_integrationVO().setNUMBER6(new BigDecimal(integrationDynList.get(i).getCts_integrationVO().getNUMBER6().stripTrailingZeros().toPlainString()));
	       }
	    }
	    if (null != integrationDynList.get(i).getCts_integrationVO().getNUMBER7())
	    {
	      if (integrationDynList.get(i).getCts_integrationVO().getNUMBER7().toString().contains(".000"))
	       {
		  integrationDynList.get(i).getCts_integrationVO().setNUMBER7(new BigDecimal(integrationDynList.get(i).getCts_integrationVO().getNUMBER7().stripTrailingZeros().toPlainString()));
	       }
	    }
	    if (null != integrationDynList.get(i).getCts_integrationVO().getNUMBER8())
	    {
	      if (integrationDynList.get(i).getCts_integrationVO().getNUMBER8().toString().contains(".000"))
	       {
		  integrationDynList.get(i).getCts_integrationVO().setNUMBER8(new BigDecimal(integrationDynList.get(i).getCts_integrationVO().getNUMBER8().stripTrailingZeros().toPlainString()));
	       }
	    }
	    if (null != integrationDynList.get(i).getCts_integrationVO().getNUMBER9())
	    {
	      if (integrationDynList.get(i).getCts_integrationVO().getNUMBER9().toString().contains(".000"))
	       {
		  integrationDynList.get(i).getCts_integrationVO().setNUMBER9(new BigDecimal(integrationDynList.get(i).getCts_integrationVO().getNUMBER9().stripTrailingZeros().toPlainString()));
	       }
	    }
	    if (null != integrationDynList.get(i).getCts_integrationVO().getNUMBER10())
	    {
	      if (integrationDynList.get(i).getCts_integrationVO().getNUMBER10().toString().contains(".000"))
	       {
		  integrationDynList.get(i).getCts_integrationVO().setNUMBER10(new BigDecimal(integrationDynList.get(i).getCts_integrationVO().getNUMBER10().stripTrailingZeros().toPlainString()));
	       }
	    }
	}
	
	return integrationDynList;
    }
    
    public CIF_TRXTYPE_LIMITSVO returnTypeCode(IntegrationDynamicSC integrationDynamicSC) throws BaseException
    {
	CIF_TRXTYPE_LIMITSVO cifTrxTypeLimits = new CIF_TRXTYPE_LIMITSVO();
	cifTrxTypeLimits.setCOMP_CODE(integrationDynamicSC.getCompCode());
	cifTrxTypeLimits.setCIF_NO(integrationDynamicSC.getBankCif());
	cifTrxTypeLimits.setTRX_TYPE(integrationDynamicSC.getTrxType());
	cifTrxTypeLimits.setCY(integrationDynamicSC.getTrsCy());
	return (CIF_TRXTYPE_LIMITSVO) genericDAO.selectByPK(cifTrxTypeLimits);
    }
    
    public IntegrationDynamicCO constructDynamicLookup(IntegrationDynamicCO integrationDynamicParamCO,IntegrationDynamicSC integrationDynamicSC) throws BaseException
    {
	IntegrationDynamicCO integrationDynamicCO = integrationDynamicParamCO;
	
	 CommonLibSC sc = new CommonLibSC();
	    sc.setAppName(IntegrationDynamicConstant.RET_APP_NAME);
	    sc.setLanguage(integrationDynamicCO.getLanguage());
	    sc.setProgRef(IntegrationDynamicConstant.PROGREF_ROOT);        
	
	    integrationDynamicCO = returnColumnsLkpList(integrationDynamicSC);
	    int columnOrderMax = IntegrationDynamicConstant.nullabelOrder;
	    int columnFirstOrder = IntegrationDynamicConstant.firstOrder;
	    int columnOrder = 0;
	    String labelDescription="";
	      
	   if (null != integrationDynamicCO)
	   {
	        //Preparing the list of dynamic columns (30 dynamic columns and 17 static) "names, titles and coltypes", and with the order defined in CSMADMIN  TP#83004
	        Map<Integer, String> name = new TreeMap<Integer, String>();
	        Map<Integer, String> titles = new TreeMap<Integer, String>();
	        Map<Integer, String> colType = new TreeMap<Integer, String>();
	          // always putting the code and type code at the first rank
	           name.put(columnFirstOrder, "cts_integrationVO.CODE");
	           sc.setAppName(IntegrationDynamicConstant.IMAL_APP_NAME);
	           sc.setKeyLabelCode("Code__key");
		   titles.put(columnFirstOrder,commonLibBO.returnKeyLabelTrans(sc)); 
		   colType.put(columnFirstOrder,"number");
		
	 	   name.put(columnOrder, "cts_integ_paramVO.TYPE_CODE");
	 	   sc.setKeyLabelCode("Type_code_key");
		   titles.put(columnOrder,commonLibBO.returnKeyLabelTrans(sc)); 
		   colType.put(columnOrder,"number");
	        
	        /* Number */
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getNUMBER1_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getNUMBER1_DESC_ORDER() == null) /*If no order is defined ==> put the column at least*/
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getNUMBER1_DESC_ORDER().intValue();
			}
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getNUMBER1_DESC();
			name.put(columnOrder, "cts_integrationVO.NUMBER1");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"number");
			
		    }

		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getNUMBER2_DESC())))
		    {

			if(integrationDynamicCO.getCts_integ_paramVO().getNUMBER2_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getNUMBER2_DESC_ORDER().intValue();
			}
			
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getNUMBER2_DESC();
			name.put(columnOrder, "cts_integrationVO.NUMBER2");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"number");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getNUMBER3_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getNUMBER3_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getNUMBER3_DESC_ORDER().intValue();
			}
			
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getNUMBER3_DESC();
			name.put(columnOrder, "cts_integrationVO.NUMBER3");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"number");
		    }
		  
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getNUMBER4_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getNUMBER4_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getNUMBER4_DESC_ORDER().intValue();
			}
			
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getNUMBER4_DESC();
			name.put(columnOrder, "cts_integrationVO.NUMBER4");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"number");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getNUMBER5_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getNUMBER5_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getNUMBER5_DESC_ORDER().intValue();
			}
			
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getNUMBER5_DESC();
			name.put(columnOrder, "cts_integrationVO.NUMBER5");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"number");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getNUMBER6_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getNUMBER6_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getNUMBER6_DESC_ORDER().intValue();
			}
			
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getNUMBER6_DESC();
			name.put(columnOrder, "cts_integrationVO.NUMBER6");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"number");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getNUMBER7_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getNUMBER7_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getNUMBER7_DESC_ORDER().intValue();
			}
			
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getNUMBER7_DESC();
			name.put(columnOrder, "cts_integrationVO.NUMBER7");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"number");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getNUMBER8_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getNUMBER8_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getNUMBER8_DESC_ORDER().intValue();
			}
			
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getNUMBER8_DESC();
			name.put(columnOrder, "cts_integrationVO.NUMBER8");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"number");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getNUMBER9_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getNUMBER9_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getNUMBER9_DESC_ORDER().intValue();
			}
			
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getNUMBER9_DESC();
			name.put(columnOrder, "cts_integrationVO.NUMBER9");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"number");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getNUMBER10_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getNUMBER10_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getNUMBER10_DESC_ORDER().intValue();
			}
			
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getNUMBER10_DESC();
			name.put(columnOrder, "cts_integrationVO.NUMBER10");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"number");
		    }
		    /* String */
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getSTRING1_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getSTRING1_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getSTRING1_DESC_ORDER().intValue();
			}
			
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getSTRING1_DESC();
			name.put(columnOrder, "cts_integrationVO.STRING1");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"text");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getSTRING2_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getSTRING2_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getSTRING2_DESC_ORDER().intValue();
			}
			
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getSTRING2_DESC();
			name.put(columnOrder, "cts_integrationVO.STRING2");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"text");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getSTRING3_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getSTRING2_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getSTRING3_DESC_ORDER().intValue();
			}
			
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getSTRING3_DESC();
			name.put(columnOrder, "cts_integrationVO.STRING3");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"text");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getSTRING4_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getSTRING4_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getSTRING4_DESC_ORDER().intValue();
			}
			
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getSTRING4_DESC();
			name.put(columnOrder, "cts_integrationVO.STRING4");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"text");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getSTRING5_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getSTRING5_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getSTRING5_DESC_ORDER().intValue();
			}
			
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getSTRING5_DESC();
			name.put(columnOrder, "cts_integrationVO.STRING5");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"text");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getSTRING6_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getSTRING6_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getSTRING6_DESC_ORDER().intValue();
			}
			
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getSTRING6_DESC();
			name.put(columnOrder, "cts_integrationVO.STRING6");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"text");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getSTRING7_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getSTRING7_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getSTRING7_DESC_ORDER().intValue();
			}
			
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getSTRING7_DESC();
			name.put(columnOrder, "cts_integrationVO.STRING7");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"text");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getSTRING8_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getSTRING8_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getSTRING8_DESC_ORDER().intValue();
			}
			
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getSTRING8_DESC();
			name.put(columnOrder, "cts_integrationVO.STRING8");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"text");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getSTRING9_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getSTRING9_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getSTRING9_DESC_ORDER().intValue();
			}
			
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getSTRING9_DESC();
			name.put(columnOrder, "cts_integrationVO.STRING9");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"text");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getSTRING10_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getSTRING10_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getSTRING10_DESC_ORDER().intValue();
			}
			
			
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getSTRING10_DESC();
			name.put(columnOrder, "cts_integrationVO.STRING10");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"text");
		    }
		    /* Dates */
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getDATE1_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getDATE1_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getDATE1_DESC_ORDER().intValue();
			}
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getDATE1_DESC();
			name.put(columnOrder, "cts_integrationVO.DATE1");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"date");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getDATE2_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getDATE2_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getDATE2_DESC_ORDER().intValue();
			}
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getDATE2_DESC();
			name.put(columnOrder, "cts_integrationVO.DATE2");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"date");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getDATE3_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getDATE3_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getDATE3_DESC_ORDER().intValue();
			}
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getDATE3_DESC();
			name.put(columnOrder, "cts_integrationVO.DATE3");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"date");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getDATE4_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getDATE4_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getDATE4_DESC_ORDER().intValue();
			}
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getDATE4_DESC();
			name.put(columnOrder, "cts_integrationVO.DATE4");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"date");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getDATE5_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getDATE5_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getDATE5_DESC_ORDER().intValue();
			}
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getDATE5_DESC();
			name.put(columnOrder, "cts_integrationVO.DATE5");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"date");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getDATE6_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getDATE6_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getDATE6_DESC_ORDER().intValue();
			}
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getDATE6_DESC();
			name.put(columnOrder, "cts_integrationVO.DATE6");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"date");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getDATE7_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getDATE7_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getDATE7_DESC_ORDER().intValue();
			}
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getDATE7_DESC();
			name.put(columnOrder, "cts_integrationVO.DATE7");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"date");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getDATE8_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getDATE8_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getDATE8_DESC_ORDER().intValue();
			}
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getDATE8_DESC();
			name.put(columnOrder, "cts_integrationVO.DATE8");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"date");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getDATE9_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getDATE9_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getDATE9_DESC_ORDER().intValue();
			}
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getDATE9_DESC();
			name.put(columnOrder, "cts_integrationVO.DATE9");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"date");
		    }
		    if(!("").equals(StringUtil.nullToEmpty(integrationDynamicCO.getCts_integ_paramVO().getDATE10_DESC())))
		    {
			if(integrationDynamicCO.getCts_integ_paramVO().getDATE10_DESC_ORDER() == null)
			{
			    columnOrder = columnOrderMax++;
			}
			else
			{
			    columnOrder = integrationDynamicCO.getCts_integ_paramVO().getDATE10_DESC_ORDER().intValue();
			}
			labelDescription = integrationDynamicCO.getCts_integ_paramVO().getDATE10_DESC();
			name.put(columnOrder, "cts_integrationVO.DATE10");
			titles.put(columnOrder,labelDescription); 
			colType.put(columnOrder,"date");
		    }

		    //Fill the columns with static labels at last in the grid if no order is set
		    if(integrationDynamicCO.getCts_integ_paramVO().getSTATUS_ORDER() == null)
		    {
			columnOrder = columnOrderMax++;
		    }
		    else
		    {
			columnOrder = integrationDynamicCO.getCts_integ_paramVO().getSTATUS_ORDER().intValue();
		    }
		    sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
		    sc.setKeyLabelCode("status_key");
		    labelDescription = commonLibBO.returnKeyLabelTrans(sc);
		    name.put(columnOrder, "statusDesc");
		    titles.put(columnOrder,labelDescription); 
		    colType.put(columnOrder,"text");
		    if(integrationDynamicCO.getCts_integ_paramVO().getTRS_NO_ORDER() == null)
		    {
			columnOrder = columnOrderMax++;
		    }
		    else
		    {
			columnOrder = integrationDynamicCO.getCts_integ_paramVO().getTRS_NO_ORDER().intValue();
		    }
		    sc.setKeyLabelCode("Transaction_No_key");
		    labelDescription = commonLibBO.returnKeyLabelTrans(sc);
		    name.put(columnOrder, "cts_integrationVO.TRS_NO");
		    titles.put(columnOrder,labelDescription); 
		    colType.put(columnOrder,"text");
		    if(integrationDynamicCO.getCts_integ_paramVO().getCTSTRS_BR_ORDER() == null)
		    {
			columnOrder = columnOrderMax++;
		    }
		    else
		    {
			columnOrder = integrationDynamicCO.getCts_integ_paramVO().getCTSTRS_BR_ORDER().intValue();
		    }
		    sc.setKeyLabelCode("trx_branch_key");
		    labelDescription = commonLibBO.returnKeyLabelTrans(sc);
		    name.put(columnOrder, "cts_integrationVO.CTSTRS_BR");
		    titles.put(columnOrder,labelDescription); 
		    colType.put(columnOrder,"text");
		    if(integrationDynamicCO.getCts_integ_paramVO().getMODIFIED_DATE_ORDER() == null)
		    {
			columnOrder = columnOrderMax++;
		    }
		    else
		    {
			columnOrder = integrationDynamicCO.getCts_integ_paramVO().getMODIFIED_DATE_ORDER().intValue();
		    }
		    sc.setKeyLabelCode("Last_updated_date_key");
		    labelDescription = commonLibBO.returnKeyLabelTrans(sc);
		    name.put(columnOrder, "cts_integrationVO.MODIFIED_DATE");
		    titles.put(columnOrder,labelDescription); 
		    colType.put(columnOrder,"date");
		    if(integrationDynamicCO.getCts_integ_paramVO().getREASON_ORDER() == null)
		    {
			columnOrder = columnOrderMax++;
		    }
		    else
		    {
			columnOrder = integrationDynamicCO.getCts_integ_paramVO().getREASON_ORDER().intValue();
		    }
		    sc.setKeyLabelCode("Reason_key");
		    labelDescription = commonLibBO.returnKeyLabelTrans(sc);
		    name.put(columnOrder, "cts_integrationVO.REASON");
		    titles.put(columnOrder,labelDescription); 
		    colType.put(columnOrder,"text");
		    if(integrationDynamicCO.getCts_integ_paramVO().getDATE_OF_INSERTION_ORDER() == null)
		    {
			columnOrder = columnOrderMax++;
		    }
		    else
		    {
			columnOrder = integrationDynamicCO.getCts_integ_paramVO().getDATE_OF_INSERTION_ORDER().intValue();
		    }
		    sc.setAppName(ConstantsCommon.RET_APP_NAME);
		    sc.setKeyLabelCode("date_of_insertion_key");
		    labelDescription = commonLibBO.returnKeyLabelTrans(sc);
		    name.put(columnOrder, "cts_integrationVO.DATE_OF_INSERTION");
		    titles.put(columnOrder,labelDescription); 
		    colType.put(columnOrder,"date");
		    if(integrationDynamicCO.getCts_integ_paramVO().getADDITIONAL_REFERENCE_ORDER() == null)
		    {
			columnOrder = columnOrderMax++;
		    }
		    else
		    {
			columnOrder = integrationDynamicCO.getCts_integ_paramVO().getADDITIONAL_REFERENCE_ORDER().intValue();
		    }
		    sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
		    sc.setKeyLabelCode("Additional_Reference_key");
		    labelDescription = commonLibBO.returnKeyLabelTrans(sc);
		    name.put(columnOrder, "cts_integrationVO.ADDITIONAL_REFERENCE");
		    titles.put(columnOrder,labelDescription); 
		    colType.put(columnOrder,"text");
		    if(integrationDynamicCO.getCts_integ_paramVO().getCREDITING_DATE_ORDER() == null)
		    {
			columnOrder = columnOrderMax++;
		    }
		    else
		    {
			columnOrder = integrationDynamicCO.getCts_integ_paramVO().getCREDITING_DATE_ORDER().intValue();
		    }
		    sc.setAppName(ConstantsCommon.RET_APP_NAME);
		    sc.setKeyLabelCode("credit_date_key");
		    labelDescription = commonLibBO.returnKeyLabelTrans(sc);
		    name.put(columnOrder, "cts_integrationVO.CREDITING_DATE");
		    titles.put(columnOrder,labelDescription); 
		    colType.put(columnOrder,"date");
		    if(integrationDynamicCO.getCts_integ_paramVO().getAMOUNT_ORDER() == null)
		    {
			columnOrder = columnOrderMax++;
		    }
		    else
		    {
			columnOrder = integrationDynamicCO.getCts_integ_paramVO().getAMOUNT_ORDER().intValue();
		    }
		    sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
		    sc.setKeyLabelCode("Amount_key");
		    labelDescription = commonLibBO.returnKeyLabelTrans(sc);
		    name.put(columnOrder, "cts_integrationVO.AMOUNT");
		    titles.put(columnOrder,labelDescription); 
		    colType.put(columnOrder,"number");
		    if(integrationDynamicCO.getCts_integ_paramVO().getREFUND_DATE_ORDER() == null)
		    {
			columnOrder = columnOrderMax++;
		    }
		    else
		    {
			columnOrder = integrationDynamicCO.getCts_integ_paramVO().getREFUND_DATE_ORDER().intValue();
		    }
		    sc.setAppName(ConstantsCommon.RET_APP_NAME);
		    sc.setKeyLabelCode("Refund_date_key");
		    labelDescription = commonLibBO.returnKeyLabelTrans(sc);
		    name.put(columnOrder, "cts_integrationVO.REFUND_DATE");
		    titles.put(columnOrder,labelDescription); 
		    colType.put(columnOrder,"date");
		    if(integrationDynamicCO.getCts_integ_paramVO().getEXPIRY_DATE_ORDER() == null)
		    {
			columnOrder = columnOrderMax++;
		    }
		    else
		    {
			columnOrder = integrationDynamicCO.getCts_integ_paramVO().getEXPIRY_DATE_ORDER().intValue();
		    }
		    sc.setKeyLabelCode("Expiry_date_key");
		    labelDescription = commonLibBO.returnKeyLabelTrans(sc);
		    name.put(columnOrder, "cts_integrationVO.EXPIRY_DATE");
		    titles.put(columnOrder,labelDescription); 
		    colType.put(columnOrder,"date");
		    if(integrationDynamicCO.getCts_integ_paramVO().getDATE_CLAIMED_ORDER() == null)
		    {
			columnOrder = columnOrderMax++;
		    }
		    else
		    {
			columnOrder = integrationDynamicCO.getCts_integ_paramVO().getDATE_CLAIMED_ORDER().intValue();
		    }
		    sc.setKeyLabelCode("Date_claimed_key");
		    labelDescription = commonLibBO.returnKeyLabelTrans(sc);
		    name.put(columnOrder, "cts_integrationVO.DATE_CLAIMED");
		    titles.put(columnOrder,labelDescription); 
		    colType.put(columnOrder,"date");
		    if(integrationDynamicCO.getCts_integ_paramVO().getREFUND_TRS_BR_ORDER() == null)
		    {
			columnOrder = columnOrderMax++;
		    }
		    else
		    {
			columnOrder = integrationDynamicCO.getCts_integ_paramVO().getREFUND_TRS_BR_ORDER().intValue();
		    }
		    sc.setKeyLabelCode("Refund_trs_br_key");
		    labelDescription = commonLibBO.returnKeyLabelTrans(sc);
		    name.put(columnOrder, "cts_integrationVO.REFUND_TRS_BR");
		    titles.put(columnOrder,labelDescription); 
		    colType.put(columnOrder,"text");
		    if(integrationDynamicCO.getCts_integ_paramVO().getREFUND_TRS_NO_ORDER() == null)
		    {
			columnOrder = columnOrderMax++;
		    }
		    else
		    {
			columnOrder = integrationDynamicCO.getCts_integ_paramVO().getREFUND_TRS_NO_ORDER().intValue();
		    }
		    sc.setKeyLabelCode("Refund_trs_no_key");
		    labelDescription = commonLibBO.returnKeyLabelTrans(sc);
		    name.put(columnOrder, "cts_integrationVO.REFUND_TRS_NO");
		    titles.put(columnOrder,labelDescription); 
		    colType.put(columnOrder,"number");
		    if(integrationDynamicCO.getCts_integ_paramVO().getREFUND_CHQ_NO_ORDER() == null)
		    {
			columnOrder = columnOrderMax++;
		    }
		    else
		    {
			columnOrder = integrationDynamicCO.getCts_integ_paramVO().getREFUND_CHQ_NO_ORDER().intValue();
		    }
		    sc.setAppName(ConstantsCommon.RET_APP_NAME);
		    sc.setKeyLabelCode("Refund_chq_no_key");
		    labelDescription =commonLibBO.returnKeyLabelTrans(sc);
		    name.put(columnOrder, "cts_integrationVO.REFUND_CHQ_NO");
		    titles.put(columnOrder,labelDescription); 
		    colType.put(columnOrder,"number");
		    if(integrationDynamicCO.getCts_integ_paramVO().getDATE_STOPPED_ORDER() == null)
		    {
			columnOrder = columnOrderMax++;
		    }
		    else
		    {
			columnOrder = integrationDynamicCO.getCts_integ_paramVO().getDATE_STOPPED_ORDER().intValue();
		    }
		    sc.setKeyLabelCode("Date_stopped_key");
		    labelDescription = commonLibBO.returnKeyLabelTrans(sc);
		    name.put(columnOrder, "cts_integrationVO.DATE_STOPPED");
		    titles.put(columnOrder,labelDescription); 
		    colType.put(columnOrder,"date");
		    if(integrationDynamicCO.getCts_integ_paramVO().getDATE_REJECTED_ORDER() == null)
		    {
			columnOrder = columnOrderMax++;
		    }
		    else
		    {
			columnOrder = integrationDynamicCO.getCts_integ_paramVO().getDATE_REJECTED_ORDER().intValue();
		    }
		    sc.setKeyLabelCode("Date_rejected_key");
		    labelDescription = commonLibBO.returnKeyLabelTrans(sc);
		    name.put(columnOrder, "cts_integrationVO.DATE_REJECTED");
		    titles.put(columnOrder,labelDescription); 
		    colType.put(columnOrder,"date");
	        
		    List<String> listNames = new ArrayList<String>(name.values());
	            List<String> listTitles = new ArrayList<String>(titles.values());
	            List<String> listColtype = new ArrayList<String>(colType.values());
	            
	            integrationDynamicCO.setListNames(listNames);
	            integrationDynamicCO.setListTitles(listTitles);
	            integrationDynamicCO.setListColtype(listColtype);
	   }
       return integrationDynamicCO; 	
    }

    public IntegrationDynamicDAO getIntegrationDynamicDAO()
    {
        return integrationDynamicDAO;
    }

    public void setIntegrationDynamicDAO(IntegrationDynamicDAO integrationDynamicDAO)
    {
        this.integrationDynamicDAO = integrationDynamicDAO;
    }
    
}
