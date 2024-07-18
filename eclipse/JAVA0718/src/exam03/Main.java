package exam03;

public class Main {
	public static void main(String[] args) {
		ImplementationC impIC = new ImplementationC();
		
		InterfaceA ia = impIC;
		ia.methodA();
		
		InterfaceB ib = impIC;
		ib.methodB();
		
		InterfaceC ic = impIC;
		ic.methodA();
		ic.methodB();
		ic.methodC();
	}
}
