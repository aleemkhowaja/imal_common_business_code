/**
 * @Auther:WissamAbouJaoude
 * @Date:May 17, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.position.PositionBO;
import com.path.dbmaps.vo.POSITIONSVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.position.PositionSC;

public class PositionDependencyAction extends RetailBaseAction
{
    private final PositionSC positionSC = new PositionSC();
    private PositionBO positionBO;
    private POSITIONSVO positionVO;
    private BigDecimal POSITION_CODE;
    
    
    public Object getModel()
    {
	return positionSC;
    }
    
    public String dependencyByPositionCode() 
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    positionSC.setCompCode(sessionCO.getCompanyCode());
	    positionSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    positionSC.setPosition_code(POSITION_CODE);
	    positionVO = positionBO.positionDependency(positionSC);
	}
	catch(Exception e)
	{
	    log.error(e,"Error in dependencyByPositionCode method of PositionDependencyAction");
	    handleException(e, "ERROR in Position Dependency", null);
	}
	return SUCCESS;

    }

    public POSITIONSVO getPositionVO()
    {
        return positionVO;
    }

    public void setPositionVO(POSITIONSVO positionVO)
    {
        this.positionVO = positionVO;
    }

    public void setPositionBO(PositionBO positionBO)
    {
        this.positionBO = positionBO;
    }

    public BigDecimal getPOSITION_CODE()
    {
        return POSITION_CODE;
    }

    public void setPOSITION_CODE(BigDecimal pOSITIONCODE)
    {
        POSITION_CODE = pOSITIONCODE;
    }


}


