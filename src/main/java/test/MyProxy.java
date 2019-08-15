package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理实现
 */
interface HelloWord{
    void sayHello(String name);
}

class HelloWordImpl implements HelloWord{
    @Override
    public void sayHello(String name){
        System.out.println("say："+name);
    }
}

class MyInvokeHandle implements InvocationHandler {

    private Object target;

    public MyInvokeHandle(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("start...");
        Object obj=method.invoke(target,args);
        System.out.println("end...");
        return obj;

    }
}

public class MyProxy{
    public static void main(String[] args) {
        MyInvokeHandle myInvokeHandle=new MyInvokeHandle(new HelloWordImpl());
        HelloWord o = (HelloWord)Proxy.newProxyInstance(MyProxy.class.getClassLoader(), new Class[]{HelloWord.class}, myInvokeHandle);
        o.sayHello("ab123");
    }
}



