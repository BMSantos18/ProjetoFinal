
package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Acesso {
    
    private int id;
    private String dataAcesso;
    private String horaAcesso;
    private String Login;
    
    public Acesso(){
        SimpleDateFormat sdf = new SimpleDateFormat("kk:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        dataAcesso = sdf2.format(new Date());
        horaAcesso = sdf.format(new Date().getTime());
    }
    
    public int getId(){ return id;}
    public String getDataAcesso(){return dataAcesso;}
    public String gethoraAcesso(){return horaAcesso;}
    public String getLogin(){return Login;}
    public void setDataAcesso(String dataAcesso) {this.dataAcesso = dataAcesso;}
    
    public void setId(int id){ this.id = id;}
    public void setHoraAcesso(String horaAcesso) { this.horaAcesso = horaAcesso;}
    public void setLogin ( String Login)   { this.Login = Login;}

}
