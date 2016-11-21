/**
 * Project Name:chenxun-rpc
 * File Name:RpcClient.java
 * Package Name:com.chenxun.rpc
 * Date:2016年11月21日下午2:59:39
 * Copyright (c) 2016, Shanghai Law Cloud Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.chenxun.rpc;

import java.util.concurrent.Future;

import com.chenxun.rpc.proxy.serializer.Request;
import com.chenxun.rpc.proxy.serializer.Response;

/**
 * ClassName:RpcClient <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月21日 下午2:59:39 <br/>
 * @author   陈勋
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface RpcClient {
	
	
	Future<Response>  send(Request request)throws Exception;

}

