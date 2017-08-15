
import java.io.IOException;

import fluxo.Fotografias;
import webDriver.Navegador;

public class main {

	public static void main(String[] args) throws IOException {
		Navegador navegador = new Navegador();
		Fotografias fotografias = new Fotografias(navegador.driver);
		fotografias.logar();
		fotografias.salvarFotografiasMiniaturas();

	}

}
