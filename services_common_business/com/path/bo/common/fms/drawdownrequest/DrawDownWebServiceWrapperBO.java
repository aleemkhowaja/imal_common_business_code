package com.path.bo.common.fms.drawdownrequest;

import java.util.HashMap;

import com.path.lib.common.exception.BaseException;

public interface DrawDownWebServiceWrapperBO
{
    HashMap<String, Object> reverseDrawDown(HashMap<String, Object> hashIn) throws BaseException;

}
