
public class Teste {

	public static void main(String[] args) {
		
		String name = "felipecordeiroalves";
		
		BuscarInfoUsuario info = new BuscarInfoUsuario();
		System.out.println(info.buscarInfoUsuario(name).getBirthday());
		
		BuscarAmigos friends = new BuscarAmigos();
		
		System.out.println(friends.buscarAmigos(name).getData().size());
		
		BuscarAmigosDeAmigos amigosdeamigos = new BuscarAmigosDeAmigos();
		System.out.println(amigosdeamigos.buscarAmigosDeAmigos(friends.buscarAmigos(name), "Larissa Batista Leite").getData().size());
		
	
		
		
	}
}
