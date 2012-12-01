package model;

public class ComentarioApi implements IComentario {
	
	private String mensagem;
	private String usuario;

	@Override
	public String getUsuario() {
		return usuario;
	}

	@Override
	public String getMensagem() {
		return mensagem;
	}

	@Override
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
		
	}

	@Override
	public void setUsuario(String usuario) {
		this.usuario = usuario;
		
	}

}
