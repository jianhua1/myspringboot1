package test;

class Factory{
    public static Object getObj(String className){
        if("Fread".equals(className)){
            return new Fread();
        }else{
            return new Rice();
        }
    }
}
class Fread{
    public void getContent(){
        System.out.println("fread...");
    }

}

class Rice{
   public void getContent(){
       System.out.println("rice...");
   }
}

public class MyFactory {
    public static void main(String[] args) {
        Object fread = Factory.getObj("Fread");


    }
}
