public class AnnotationsExample {

	public static void main(String[] args) {
		AnnotationsExample ae = new AnnotationsExample();
		MyClasss myClasss = ae.new MyClasss();
		System.out.println(myClasss.toString());
		MyMethodWithMyCustomAnnotation();
	}
	@MyAnnotation(count = 10)
	private static void MyMethodWithMyCustomAnnotation() {
		
	}

	private class MyClasss {
		@Override
		public String toString() {
			return "From MyClass ;)";
		}
	}
}
