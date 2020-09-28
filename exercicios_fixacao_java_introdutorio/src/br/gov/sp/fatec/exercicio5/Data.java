package br.gov.sp.fatec.exercicio5;

import java.sql.Date;
import java.text.DateFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {  
  private  Integer dia;
  private  Integer mes;
  private  Integer ano;
  private String datavazia;
  
  public Data(Integer dia, Integer mes, Integer ano) {
    if (dia <= 31 && dia >= 1){
      setDia(dia);
    }else {
      setDia(1);
      mes+= 1;
    }
    if (mes <= 12 && mes >= 1) {
      setMes(mes);
    }else {
      setMes(1);
      ano+=1;
    }       
    setAno(ano);
  } 
  
  public Data() {
    String str = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date(System.currentTimeMillis()));
    setDatavazia(str);
  }
  
  public String toString() {
    return dia+"/"+mes+"/"+ano;
  }
  
  public String toString2(String str) {
    return str;
  }
  
  public Data avancarData(Data data) {
    Data novo = new Data((data.dia+1),data.mes,data.ano); 
    return novo;
  }
}
