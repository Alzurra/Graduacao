package graduacao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.swing.JOptionPane;

public class PosGraduacao extends Aluno {

	public static void main(String[] args) {
		Aluno al = new Aluno() {
			@Override
			public void cadastrar() {
				nome = JOptionPane.showInputDialog("Digite o nome completo do aluno: ");
				ra = JOptionPane.showInputDialog("\nDigite o RA do aluno: ");
				sexo = JOptionPane.showInputDialog("\nDigite sexo do aluno: ");
				curso = JOptionPane.showInputDialog("\nDigite o curso do aluno: ");
				data_nasc = JOptionPane.showInputDialog("\nDigite a data de nascimento do aluno no modelo dd/mm/yyyy: ");
				calcular_media();
			}

			private String getDateTime() {
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();
				return dateFormat.format(date);
			}

			@Override
			public int calcular_idade() {
				String data_atu = getDateTime();
				int dia_atu = Integer.parseInt(data_atu.substring(0, 2));
				int mes_atu = Integer.parseInt(data_atu.substring(3, 5));
				int ano_atu = Integer.parseInt(data_atu.substring(6, 10));
				int dia_nasc = Integer.parseInt(data_nasc.substring(0, 1));
				int mes_nasc = Integer.parseInt(data_nasc.substring(3, 4));
				int ano_nasc = Integer.parseInt(data_nasc.substring(6, 10));
				idade = ano_atu - ano_nasc;
				if (mes_atu < mes_nasc && dia_atu < dia_nasc)
					idade -= 1;// idade = idade - 1;
				return idade;
			}

			@Override
			public void calcular_media() {
				double tb1, tb2, p1;
				tb1 = Double.parseDouble(JOptionPane.showInputDialog("[Prova - 1]\n Digite a nota: "));
				tb2 = Double.parseDouble(JOptionPane.showInputDialog("[Prova - 2]\n Digite a nota: "));
				p1 = Double.parseDouble(JOptionPane.showInputDialog("[Trabalho]\n Digite a nota: "));
				media = (tb1 * 0.2 + tb2 * 0.2 + p1 * 0.6);
			}

			@Override
			public void mostrar() {
				JOptionPane.showMessageDialog(null,
						"[Aluno Pós-Graduação]\n\n" + "Nome: " + nome + "\n" + "RA: " + ra + "\n" + "Data Nasc: "
								+ data_nasc + "\n" + "Idade: " + calcular_idade() + "\n" + "Curso: " + curso + "\n"
								+ "Sexo: " + sexo + "\n" + "Média: " + media);
			}
		};
		
		PosGraduacao b = new PosGraduacao();
		b.mostrar();
	
	}
}
