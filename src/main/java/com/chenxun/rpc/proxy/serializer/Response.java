/**
 * Project Name:chenxun-rpc
 * File Name:Response.java
 * Package Name:com.chenxun.rpc.proxy.serializer
 * Date:2016年11月21日下午3:00:59
 * Copyright (c) 2016, Shanghai Law Cloud Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.chenxun.rpc.proxy.serializer;

import java.io.Serializable;

import lombok.Data;

/**
 * ClassName:Response <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月21日 下午3:00:59 <br/>
 * @author   陈勋
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Data
public class Response implements Serializable {
	
	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * @since JDK 1.7
	 */
	private static final long serialVersionUID = 2301698519561823768L;

	private String requestId;
	
	private RuntimeException exception;
	
	private Object result;

}

