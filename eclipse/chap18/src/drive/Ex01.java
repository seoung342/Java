package drive;

import mvc.command.CommandHandler;

class Aaa{
	void disp() {
		System.out.println("프린트 Aaa");
	}
}

public class Ex01 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class<?> handlerClass = Class.forName("drive.Aaa");
        Object handlerInstance = handlerClass.newInstance();
        Aaa aa = (Aaa) handlerInstance;
        aa.disp();
	}
}