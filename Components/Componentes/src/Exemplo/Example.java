package Exemplo;
import java.util.Scanner;

import speak.Speak;
import tradutor.Translate;

public class Example {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println(Translate.translate("Hello"));
			System.out.println(Translate.translate("Oi tudo bem", "en"));
			Speak.speak(scan.nextLine());
		}
		catch(Exception e) {
			System.out.println("Deu errado");
		}
		scan.close();
		System.out.println("Fim");
	}
}