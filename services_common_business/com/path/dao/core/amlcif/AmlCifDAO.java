/**
 * @Auther:MarwanMaddah
 * @Date:Mar 6, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.dao.core.amlcif;

import java.util.List;
import com.path.dbmaps.vo.AML_CUSTOMERVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.cif.CifSC;

/**
 * @author Nour
 * 
 */
public interface AmlCifDAO
{

	/**
	 * 
	 * @param criteria
	 * @return
	 * @throws DAOException
	 */
	List returnBankCIF(CifSC criteria) throws DAOException;

	/**
	 * 
	 * @param criteria
	 * @return
	 * @throws DAOException
	 */
	int returnBankCifListCount(CifSC criteria) throws DAOException;

	List returnCIF(CifSC criteria) throws DAOException;

	int returnCifListCount(CifSC criteria) throws DAOException;

	public AML_CUSTOMERVO returnCifByNo(CifSC criteria) throws DAOException;

}
