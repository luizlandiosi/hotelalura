package Modelo;


import java.sql.PreparedStatement;

public interface Autenticavel {

	String getUser();

	String getPassword();

	boolean autentica(PreparedStatement pstm);
}