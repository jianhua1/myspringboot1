package test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Jx{
    private String ip="127.0.0.1";
    private String port="8080";
    private String url(){
        System.out.println("ip:"+ip+" port:"+port);
        return "ip:"+ip+" port:"+port;
    }

}
public class Test {
    public void invokeUrl(){
        try {
            Jx jx = Jx.class.newInstance();
            Class<Jx> jxClass = Jx.class;
            Field[] fields = jxClass.getFields();
            for (Field field : fields) {
                System.out.println(field.getName());
            }
            System.out.println("======================");
            Method[] declaredMethods = jxClass.getDeclaredMethods();
            Field[] declaredFields = jxClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                String name = declaredField.getName();
                declaredField.setAccessible(true);
                Object o = declaredField.get(jx);
                System.out.println(name+":"+o.toString());
            }
            for (Method declaredMethod : declaredMethods) {
                String name = declaredMethod.getName();
                declaredMethod.setAccessible(true);
                try {
                    System.out.println(name+":"+declaredMethod.invoke(jx));
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Test test=new Test();
        test.invokeUrl();
    }
}
