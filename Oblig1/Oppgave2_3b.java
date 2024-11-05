public class Oppgave2_3b{

	public static void main(String[] args){
		Planet mars = new Planet("Mars", 3389.5, 3.711);  //Bruker klassen Planet som ble laget i Planet.java filen.
		Planet yo = new Planet("Saturn", 4234, 34.3);

 			mars.getInfo();
			yo.getInfo();

	/*System.out.println("Planeten " + yo.getname() +
	" har en radius pa " + yo.getrad() + " og en gravitasjon pa " + yo.getgrav() + " m/s^2");*/
}
}
