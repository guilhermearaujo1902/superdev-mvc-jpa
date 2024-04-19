package br.com.padaria;

import javax.persistence.Persistence;

public class TesteJPA {

	public static void main(String[] args) {
		
		Persistence.createEntityManagerFactory("padaria");

	}

}
