package applicazione.progetto.travelplan;

import java.util.Date;

/**
 * Created by FRANCESCO on 06/02/2018.
 */

public class Utente
{
    int id;
    String nome;
    String cognome;
    Date data;
    String email;
    String username;
    String password;

    public Utente (String n,String c,String e,String un,String p, Date d){

        this.nome= n;
        this.cognome = c;
        this.email = e;
        this.username = un;
        this.password = p;
        this.data = d;

    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome( String nome ) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome( String cognome ) {
        this.cognome = cognome;
    }

    public Date getData() {
        return data;
    }

    public void setData( Date data ) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }
}
