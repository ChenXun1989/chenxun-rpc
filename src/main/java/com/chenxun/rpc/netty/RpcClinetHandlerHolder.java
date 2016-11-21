/**
 * Project Name:chenxun-rpc
 * File Name:RpcClinetHolder.java
 * Package Name:com.chenxun.rpc
 * Date:2016年11月21日下午3:35:48
 * Copyright (c) 2016, Shanghai Law Cloud Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.chenxun.rpc.netty;

import com.chenxun.rpc.RpcClient;
import com.chenxun.rpc.proxy.serializer.Request;
import com.chenxun.rpc.proxy.serializer.Response;
import com.chenxun.rpc.proxy.serializer.RpcDecoder;
import com.chenxun.rpc.proxy.serializer.RpcEncoder;
import com.chenxun.rpc.proxy.serializer.Serializer;
import com.wcwl.nettyrpcdemo.NettyRpcClient.RpcClientHandler;
import com.wcwl.nettyrpcdemo.protocol.RpcRequest;
import com.wcwl.nettyrpcdemo.protocol.RpcResponse;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * ClassName:RpcClinetHolder <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月21日 下午3:35:48 <br/>
 * @author   陈勋
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class RpcClinetHandlerHolder {
	
	private  EventLoopGroup eventLoopGroup = new NioEventLoopGroup(4);
	
   public static RpcClient  getRpcClient(){
	   return null;
	   
   }; 
   
   private Serializer serializer;
   
   public  void init(){
	    Bootstrap b = new Bootstrap();
		b.group(eventLoopGroup).channel(NioSocketChannel.class).handler(new ChannelInitializer(){

			@Override
			protected void initChannel(Channel ch) throws Exception {
				ChannelPipeline cp = ch.pipeline();
				//编码
				cp.addLast(new RpcEncoder<Request>(serializer));
				cp.addLast(new LengthFieldBasedFrameDecoder(65536, 0, 4, 0, 0));
				//解码
				cp.addLast(new RpcDecoder<Response>(serializer, Response.class));
				// 处理请求
			//	cp.addLast(new RpcClientHandler()););
			}
			
		});

		ChannelFuture channelFuture = b.connect("",8888);
		channelFuture.addListener(new ChannelFutureListener() {
			public void operationComplete(final ChannelFuture channelFuture) throws Exception {
				if (channelFuture.isSuccess()) {
					RpcClientHandler handler = channelFuture.channel().pipeline().get(RpcClientHandler.class);
					addHandler(handler);
				}
			}
		});
   }
   

}

