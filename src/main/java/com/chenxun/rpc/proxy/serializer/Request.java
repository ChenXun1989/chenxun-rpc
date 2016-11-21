/**
 * Project Name:chenxun-rpc
 * File Name:Request.java
 * Package Name:com.chenxun.rpc
 * Date:2016年11月21日下午3:00:09
 * Copyright (c) 2016, Shanghai Law Cloud Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.chenxun.rpc.proxy.serializer;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * ClassName:Request <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月21日 下午3:00:09 <br/>
 * @author   陈勋
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Data
public class Request implements Serializable {
	
	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * @since JDK 1.7
	 */
	private static final long serialVersionUID = -2962294215883722031L;

	private String requestId;
	
	private String interfaceName;
	
	private String methodName;
	
	private String[] paramTypes;
	
	private Object[] params;
	
	
}

