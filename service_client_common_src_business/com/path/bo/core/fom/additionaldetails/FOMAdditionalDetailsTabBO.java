package com.path.bo.core.fom.additionaldetails;

import java.util.List;

import com.path.lib.common.exception.BOException;
import com.path.vo.core.cifcategory.CIFCategorySC;

public interface FOMAdditionalDetailsTabBO
{
    public List<CIFCategorySC> fillCIFCategory() throws BOException;
}
