package proxy.jdkdynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class GenericProxy {

	public static Object createProxy(Object obj, InvocationHandler invokeObj) {
		Object proxy = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
				invokeObj);
		return proxy;
	}

}
