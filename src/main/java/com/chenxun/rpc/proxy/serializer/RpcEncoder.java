/**
 * Project Name:chenxun-rpc
 * File Name:RpcEncoder.java
 * Package Name:com.chenxun.rpc.proxy.serializer
 * Date:2016年11月21日下午4:00:45
 * Copyright (c) 2016, Shanghai Law Cloud Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.chenxun.rpc.proxy.serializer;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * ClassName:RpcEncoder <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月21日 下午4:00:45 <br/>
 * @author   陈勋
 * @version  
 * @param <I>
 * @since    JDK 1.7
 * @see 	 
 */
public class RpcEncoder<I> extends MessageToByteEncoder<I> {
	
	private final Serializer serializer;
	
	public RpcEncoder(Serializer serializer){
		this.serializer=serializer;
	}

	@Override
	protected void encode(ChannelHandlerContext ctx, I msg, ByteBuf out) throws Exception {
		byte[] data = serializer.serialize(msg);
		out.writeInt(data.length);
		out.writeBytes(data);		
	}

}

