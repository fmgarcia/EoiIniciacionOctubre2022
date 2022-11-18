package ventanas;

public class Main {

	public static void main(String[] args) {
		Ventana[] ventanas=new Ventana[10];
		for(int i=0;i<ventanas.length;i++) {
			ventanas[i]=new Ventana((int)(90+(Math.random()*(120-90))),
								(int)(40+(Math.random()*(100-40))));
		}
		for (int i=0;i<ventanas.length;i++)		{
			ventanas[i].mostrar();
		}

	}

}
