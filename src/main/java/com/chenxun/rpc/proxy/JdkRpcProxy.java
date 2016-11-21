/**
 * Project Name:chenxun-rpc
 * File Name:JdkRpcProxy.java
 * Package Name:com.chenxun.rpc.proxy
 * Date:2016年11月21日下午3:14:09
 * Copyright (c) 2016, Shanghai Law Cloud Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.chenxun.rpc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import com.chenxun.rpc.RpcClient;
import com.chenxun.rpc.netty.RpcClinetHandlerHolder;
import com.chenxun.rpc.proxy.serializer.Request;
import com.chenxun.rpc.proxy.serializer.Response;

/**
 * ClassName:JdkRpcProxy <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月21日 下午3:14:09 <br/>
 * @author   陈勋
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class JdkRpcProxy implements RpcProxy {
	
	private InvocationHandler jdkInvocationHandler=new JdkInvocationHandler();

	@Override
	public <T> T proxy(Class<T> interfaceClass) throws Throwable {
		if(!interfaceClass.isInterface()){
			throw new Exception("目前只支持接口代理");
		}
		
		Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[] { interfaceClass },jdkInvocationHandler);
		return null;
	}
	
	private class JdkInvocationHandler implements InvocationHandler{

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			
			  // 转成request对象
			String interfaceName = method.getDeclaringClass().getName();	 
			Request request=new Request();
			request.setInterfaceName(interfaceName);
			request.setRequestId(generateRequestId());
			request.setMethodName(method.getName());
			List<String> paramTypes = new LinkedList<String>();
			for (Class<?> parameterType : method.getParameterTypes()) {
				paramTypes.add(parameterType.getName());
			}
			request.setParamTypes(paramTypes.toArray(new String[paramTypes.size()]));
			request.setParams(args);
			// 远程调用
			RpcClient client=RpcClinetHandlerHolder.getRpcClient();
			//阻塞
			Response response= (Response) client.send(request).get();
			if(response.getException()!=null){
				throw new RuntimeException(response.getException());
			}	
			return response.getResult();

		}
		
		private String generateRequestId(){
			return UUID.randomUUID().toString().replaceAll("-", "");
		};
		
	}
	
	
	
}

