package graduacao;

public class Graduacao extends Aluno {
	public static void main(String[] args) {
		Graduacao g = new Graduacao();
		g.cadastrar();
		g.calcular_idade();
		g.calcular_media();
		g.mostrar();

	}
}
