package model;
import java.util.ArrayList;
import java.util.List;


public class Cliente extends Pessoa {
	private String estadocivil;
	private int renda;
	private int idCliente;
	public Cliente(String nome, int idade , String telefone, String estadocivil, int renda, int id) {
		super(nome, idade, telefone);
		this.estadocivil = estadocivil;
		this.renda = renda;
		this.idCliente = id;
	}
	public void setId(int id) {
		this.idCliente = id;
	}
	public int getId() {
		return idCliente;
	}
	
}
