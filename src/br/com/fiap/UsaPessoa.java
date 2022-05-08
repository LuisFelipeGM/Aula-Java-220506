package br.com.fiap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class UsaPessoa {
	public static void main(String[] args) {
		String nome, dataNascimento, formatoUSA;
		Pessoa pessoa1;
		
		try {
			nome = JOptionPane.showInputDialog("Digite seu nome");
			dataNascimento = JOptionPane.showInputDialog("Digite a Data de Nascimento (dia-mes-ano)");
			
			formatoUSA = dataNascimento.substring(6, 10); // ano
			formatoUSA += "-" + dataNascimento.substring(3, 5); // mes
			formatoUSA += "-" + dataNascimento.substring(0, 2); // dia
			pessoa1 = new Pessoa(nome, LocalDate.parse(formatoUSA));
			
			JOptionPane.showMessageDialog(null, "Data de Nascimento no Formato Americano: " + formatoUSA);
			
			LocalDate data = pessoa1.getDataNascimento(); 
			DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataFormatada = data.format(dft);
			
			JOptionPane.showMessageDialog(null, 
					"Nome: " + pessoa1.getNome() + 
					" \nData de Nascimento: " + dataFormatada + 
					" \nIdade: " + pessoa1.calculaIdade());

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(0);
		}
	}
}
