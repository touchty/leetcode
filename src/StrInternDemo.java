public class StrInternDemo {
	public static void main(String[] args) {
		String str1 = "a";
		String str2 = "b";
		//String str3 = "ab";
		//String str4 = str1 + str2;
		String str5 = new String("ab");
		//String str6 = "a" + "b";
		String str7 = new String("ab");
		 
		/*System.out.println(str5.equals(str3));
		System.out.println(str5 == str3);
		System.out.println(str5.intern() == str3);*/
		/*System.out.println(str5.intern() == str4);
		System.out.println(str5.intern() == str6);*/
		System.out.println(str5.intern() == str7);
		System.out.println(str5.intern() == str7.intern());
	}
}