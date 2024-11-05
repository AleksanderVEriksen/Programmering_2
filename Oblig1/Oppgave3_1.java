import java.util.Scanner;               //For å kunne spørre brukeren

public class Oppgave3_1{

	public static void main(String[] args){
	Scanner myObj = new Scanner(System.in);       // Lager scanner objekt
  Boolean valg = true;                          //Boolean verdi for å bruke i while()
  do{

  System.out.println("Skriv inn planetnavn: ");
  String name = myObj.next();                 //Spør bruker og kaller scanner objektet
                                             // MyObj.next() sier at det neste som skrives i terminalen blir lagret i String name.
  System.out.println("Skriv inn radius: ");
  double rad = myObj.nextDouble();                 // Samme videre for andre verdier.

  System.out.println("Skriv inn grav: ");
  double grav = myObj.nextDouble();

  Planet ka = new Planet(name, rad, grav);         //Setter variablene inne i planet objektet slik at det blir lagret.


	ka.getInfo();

  System.out.println("Vil du fortsette? true/false");
  valg = myObj.nextBoolean();                  //Booleanen som sier om vi forstetter

  System.out.println("Du skrev " + valg);



}while(valg == true);  // Programmet forstetter så lenge valg er true, endrer vi det til false over, så hopper man ut av programmet.
}



}
//Denne Oppgaven inneholder både 3_1 og 3_2.
