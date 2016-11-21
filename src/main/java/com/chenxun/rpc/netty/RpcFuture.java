/**
 * Project Name:chenxun-rpc
 * File Name:RpcFuture.java
 * Package Name:com.chenxun.rpc.netty
 * Date:2016年11月21日下午5:13:09
 * Copyright (c) 2016, Shanghai Law Cloud Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.chenxun.rpc.netty;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.wcwl.nettyrpcdemo.protocol.RpcResponse;

/**
 * ClassName:RpcFuture <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月21日 下午5:13:09 <br/>
 * @author   陈勋
 * @version  
 * @param <V>
 * @since    JDK 1.7
 * @see 	 
 */
public class RpcFuture<V> implements Future<V> {

	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCancelled() {
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDone() {
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get() throws InterruptedException, ExecutionException {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
		
		// TODO Auto-generated method stub
		return null;
	}
	

	
	

}

