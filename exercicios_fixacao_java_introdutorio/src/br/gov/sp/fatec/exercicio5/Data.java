package br.gov.sp.fatec.exercicio5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {  
  private Integer dia;
  private Integer mes;
  private Integer ano;
  
  public Data(Integer dia, Integer mes, Integer ano) {
    this.dia = (dia <= 31 && dia >= 1) ? dia : null;
    this.mes = (mes <= 12 && mes >= 1) ? mes : null;
    this.ano = (ano >= 0 ) ? ano : null;
  }
  
  public String Data() {
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
    Calendar c = Calendar.getInstance(); 
    return df.format(c.getTime());
  }

  public String toString() {
    return dia+"/"+mes+"/"+ano;
  }
  
  public void avancarData() {
    if (dia == 30 || dia == 31 ) {
      if (mes < 12) {
        mes += 1;
      } else {
        ano +=1;
      }       
    }
  }

}
