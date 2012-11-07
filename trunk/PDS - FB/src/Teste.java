
public class Teste {

	public static void main(String[] args) {
		
		String token = "AAACEdEose0cBALF3ZB6mZAe1b7YFM0x8uTujHVgbjwm0AOs1n6v2RMMyGV7QK6JuWpttfxLbzZCYKHu54ojARAdSb6NVkLcz64K0Mz9sCONSrYXq8g2";
		Cliente.setToken(token);
		
		String name = "felipecordeiroalves";
		
		BuscarInfoUsuario info = new BuscarInfoUsuario();
		System.out.println(info.buscarInfoUsuario(name).getName());
	
	}
}
