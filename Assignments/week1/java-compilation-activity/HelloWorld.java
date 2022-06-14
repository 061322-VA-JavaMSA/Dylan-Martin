public class HelloWorld {

	public static void main(String[] args) {

		switch (args.length) {
		
		//Get random number
		case 1:
		int rand = (int)(Math.random() * Integer.parseInt(args[0])) + 1;
		System.out.println(rand);
		break;

		//print a string x times
		case 2:
		int x = Integer.parseInt(args[0]);
		for (int i=0; i<x; i++) {
			System.out.println(args[1]);
			}
		break;

		//default case
		default:
		break;
		
		}

	}

}