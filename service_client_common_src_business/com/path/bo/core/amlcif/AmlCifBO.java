/**
 * @Auther:Nour
 * @Date:Mar 6, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.bo.core.amlcif;

import java.util.List;
import com.path.dbmaps.vo.AML_CUSTOMERVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cif.CifSC;

/**
 * @author Nour
 * 
 */
public interface AmlCifBO
{

	List returnBankCIF(CifSC criteria) throws BaseException;

	/**
	 * 
	 * @param criteria
	 * @return int
	 * @throws BaseException
	 */
	int returnBankCifListCount(CifSC criteria) throws BaseException;

	int cifListCount(CifSC criteria) throws BaseException;

	List cifList(CifSC criteria) throws BaseException;

	public AML_CUSTOMERVO returnCifByNo(CifSC criteria) throws BaseException;

}
