public class Planet{

		private String name;
		private double radius;
		private double grav;

	public Planet(String name, double radius, double grav){
		this.name = name;
		this.radius = radius;                           //Konstruktøren
		this.grav = grav;
		}
	public void setname(String name){
		this.name = name;                        //Om vi ønsker at objektet skal bytte navn
		}
	public void setrad(double radius){
		this.radius = radius;                  //Bytte radius
		}
	public void setgrav(double grav){
		this.grav = grav;                   //Bytte gravitasjon
	}
		public String getname(){
			return name;                   //Kaller navnet til objektet
			}
		public double getrad(){           // Kaller radiusen
			return radius;
			}
		public double getgrav(){          // Kaller gravitasjonen
			return grav;
			}
		public void getInfo(){
			System.out.println("Planeten " + this.name +
			" har en radius pa " + this.radius + "km" + " og en gravitasjon pa " + this.grav + " m/s^2");
		}
	public static void main(String[] args){

	}
}
