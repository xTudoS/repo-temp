package model;
import java.util.ArrayList;
import java.util.List;


public class Cliente extends Pessoa {
	private String estadocivil;
	private int renda;
	public Cliente(String nome, int idade , String telefone, String estadocivil, int renda) {
		super(nome, idade, telefone);
		this.estadocivil = estadocivil;
		this.renda = renda;
	}
	
}
