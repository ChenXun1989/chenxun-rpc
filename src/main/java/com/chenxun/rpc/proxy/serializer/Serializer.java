/**
 * Project Name:chenxun-rpc
 * File Name:Serializer.java
 * Package Name:com.chenxun.rpc.proxy.serializer
 * Date:2016年11月21日下午4:03:16
 * Copyright (c) 2016, Shanghai Law Cloud Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.chenxun.rpc.proxy.serializer;

import java.io.Serializable;

/**
 * ClassName:Serializer <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月21日 下午4:03:16 <br/>
 * @author   陈勋
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface Serializer {
	
  <T> byte[] serialize( T t );
  
  <T> T deserialize(byte[] data, Class<T> cls) ;

}

