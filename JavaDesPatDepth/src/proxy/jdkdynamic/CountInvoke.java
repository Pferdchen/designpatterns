package proxy.jdkdynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CountInvoke implements InvocationHandler {

	private int count = 0;
	private Object obj;

	public CountInvoke(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		count++;
		method.invoke(obj, args);
		return null;
	}

	int getCount() {
		return count;
	}

}
