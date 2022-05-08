package br.com.fiap;

import java.time.LocalDate;
import java.time.Period;

import javax.swing.JOptionPane;

public class Pessoa {
	private String nome;
	private LocalDate dataNascimento;
	
	public Pessoa() {
	}
	
	public Pessoa(String nome, LocalDate dataNascimento) {
		setNome(nome);
		setDataNascimento(dataNascimento);
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		LocalDate inicio = LocalDate.parse("1899-12-31");
		LocalDate fim = LocalDate.now();
		try {
			if (dataNascimento.isAfter(inicio) && dataNascimento.isBefore(fim)) {
				this.dataNascimento = dataNascimento;
			} else {
				throw new Exception("Data fora do período permitido");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(0); //encerra a execução do programa
			
		}
	}
	
	public int calculaIdade() {
		LocalDate dataAtual = LocalDate.now();
		Period idade = Period.between(dataNascimento, dataAtual);
		return idade.getYears();
	}
	
	

}
