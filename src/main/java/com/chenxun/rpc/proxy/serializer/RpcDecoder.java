/**
 * Project Name:chenxun-rpc
 * File Name:RpcDecoder.java
 * Package Name:com.chenxun.rpc.proxy.serializer
 * Date:2016年11月21日下午4:09:29
 * Copyright (c) 2016, Shanghai Law Cloud Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.chenxun.rpc.proxy.serializer;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

/**
 * ClassName:RpcDecoder <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月21日 下午4:09:29 <br/>
 * @author   陈勋
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class RpcDecoder<T> extends ByteToMessageDecoder {
	
	
	private final Serializer serializer;
	
	private final Class<T> t;
	
	public RpcDecoder(Serializer serializer,Class<T> t){
		this.serializer=serializer;
		this.t=t;
	}


	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

		if (in.readableBytes() < 4) {
			return;
		}
		in.markReaderIndex();
		int dataLength = in.readInt();
		if (in.readableBytes() < dataLength) {
			in.resetReaderIndex();
			return;
		}
		byte[] data = new byte[dataLength];
		in.readBytes(data);

		Object obj = serializer.deserialize(data,t);
		out.add(obj);

	}

}

