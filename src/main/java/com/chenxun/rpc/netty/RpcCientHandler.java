/**
 * Project Name:chenxun-rpc
 * File Name:RpcCientHandler.java
 * Package Name:com.chenxun.rpc.netty
 * Date:2016年11月21日下午5:08:09
 * Copyright (c) 2016, Shanghai Law Cloud Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.chenxun.rpc.netty;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

import com.chenxun.rpc.RpcClient;
import com.chenxun.rpc.proxy.serializer.Request;
import com.chenxun.rpc.proxy.serializer.Response;
import com.wcwl.nettyrpcdemo.NettyRpcClient.RPCFuture;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * ClassName:RpcCientHandler <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月21日 下午5:08:09 <br/>
 * @author   陈勋
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class RpcCientHandler extends ChannelInboundHandlerAdapter implements RpcClient {
	
	private Channel channel;
	
	private ConcurrentHashMap<String, Future<Response>> reposneMap=new ConcurrentHashMap<String, Future<Response>>();
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		Response response=(Response)msg;
		 Future<Response> future=reposneMap.get(response.getRequestId());
		 future.
		
		
		
	}
	
	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		super.channelRegistered(ctx);
	    this.channel=ctx.channel();
	}
	
	
	@Override
	public Future<Response> send(Request request) throws Exception {
		 Future<Response> rpcFuture = new RpcFuture<Response>();
		//pendingRPC.put(request.getRequestId(), rpcFuture);
		channel.writeAndFlush(request);
	
		return rpcFuture;
	}
	
	


}

