/**
 * Project Name:chenxun-rpc
 * File Name:RpcProxy.java
 * Package Name:com.chenxun.rpc.proxy
 * Date:2016年11月21日下午3:13:17
 * Copyright (c) 2016, Shanghai Law Cloud Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.chenxun.rpc.proxy;
/**
 * ClassName:RpcProxy <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月21日 下午3:13:17 <br/>
 * @author   陈勋
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface RpcProxy {
	
	<T> T proxy(Class<T> interfaceClass) throws Throwable;

}

