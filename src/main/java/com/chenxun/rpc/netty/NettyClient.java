/**
 * Project Name:chenxun-rpc
 * File Name:NettyClient.java
 * Package Name:com.chenxun.rpc.proxy
 * Date:2016年11月21日下午3:41:00
 * Copyright (c) 2016, Shanghai Law Cloud Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.chenxun.rpc.netty;

import java.util.concurrent.Future;

import com.chenxun.rpc.RpcClient;
import com.chenxun.rpc.proxy.serializer.Request;
import com.chenxun.rpc.proxy.serializer.Response;

/**
 * ClassName:NettyClient <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月21日 下午3:41:00 <br/>
 * @author   陈勋
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class NettyClient implements RpcClient {

	@Override
	public Future<Response> send(Request request) throws Exception {
		 Future<Response> rpcFuture = new RpcFuture<Response>;
		//pendingRPC.put(request.getRequestId(), rpcFuture);
		channel.writeAndFlush(request);
	
		return rpcFuture;
	}
	
	

	

}

