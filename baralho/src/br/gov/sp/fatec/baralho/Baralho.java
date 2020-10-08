package br.gov.sp.fatec.baralho;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Baralho {
  private Carta[] cartas;
  
  public Baralho() {
    setCartas(cartas = new Carta[56]);
    cartas[0] = new Carta(Nome.AS, Naipe.OUROS);
    cartas[1] = new Carta(Nome.DOIS, Naipe.OUROS);
    cartas[2] = new Carta(Nome.TRES, Naipe.OUROS);
    cartas[3] = new Carta(Nome.QUATRO, Naipe.OUROS);
    cartas[4] = new Carta(Nome.CINCO, Naipe.OUROS);
    cartas[5] = new Carta(Nome.SEIS, Naipe.OUROS);
    cartas[6] = new Carta(Nome.SETE, Naipe.OUROS);
    cartas[7] = new Carta(Nome.OITO, Naipe.OUROS);
    cartas[8] = new Carta(Nome.NOVE, Naipe.OUROS);
    cartas[9] = new Carta(Nome.DEZ, Naipe.OUROS);
    cartas[10] = new Carta(Nome.VALETE, Naipe.OUROS);
    cartas[11] = new Carta(Nome.DAMA, Naipe.OUROS);
    cartas[12] = new Carta(Nome.REI, Naipe.OUROS);
    cartas[13] = new Carta(Nome.AS, Naipe.ESPADAS);
    cartas[14] = new Carta(Nome.DOIS, Naipe.ESPADAS);
    cartas[15] = new Carta(Nome.TRES, Naipe.ESPADAS);
    cartas[16] = new Carta(Nome.QUATRO, Naipe.ESPADAS);
    cartas[17] = new Carta(Nome.CINCO, Naipe.ESPADAS);
    cartas[18] = new Carta(Nome.SEIS, Naipe.ESPADAS);
    cartas[19] = new Carta(Nome.SETE, Naipe.ESPADAS);
    cartas[20] = new Carta(Nome.OITO, Naipe.ESPADAS);
    cartas[21] = new Carta(Nome.NOVE, Naipe.ESPADAS);
    cartas[22] = new Carta(Nome.DEZ, Naipe.ESPADAS);
    cartas[23] = new Carta(Nome.VALETE, Naipe.ESPADAS);
    cartas[24] = new Carta(Nome.DAMA, Naipe.ESPADAS);
    cartas[25] = new Carta(Nome.REI, Naipe.ESPADAS);
    cartas[26] = new Carta(Nome.AS, Naipe.COPAS);
    cartas[27] = new Carta(Nome.DOIS, Naipe.COPAS);
    cartas[28] = new Carta(Nome.TRES, Naipe.COPAS);
    cartas[29] = new Carta(Nome.QUATRO, Naipe.COPAS);
    cartas[30] = new Carta(Nome.CINCO, Naipe.COPAS);
    cartas[31] = new Carta(Nome.SEIS, Naipe.COPAS);
    cartas[32] = new Carta(Nome.SETE, Naipe.COPAS);
    cartas[33] = new Carta(Nome.OITO, Naipe.COPAS);
    cartas[34] = new Carta(Nome.NOVE, Naipe.COPAS);
    cartas[35] = new Carta(Nome.DEZ, Naipe.COPAS);
    cartas[36] = new Carta(Nome.VALETE, Naipe.COPAS);
    cartas[37] = new Carta(Nome.DAMA, Naipe.COPAS);
    cartas[38] = new Carta(Nome.REI, Naipe.COPAS);
    cartas[39] = new Carta(Nome.AS, Naipe.PAUS);
    cartas[40] = new Carta(Nome.DOIS, Naipe.PAUS);
    cartas[41] = new Carta(Nome.TRES, Naipe.PAUS);
    cartas[42] = new Carta(Nome.QUATRO, Naipe.PAUS);
    cartas[43] = new Carta(Nome.CINCO, Naipe.PAUS);
    cartas[44] = new Carta(Nome.SEIS, Naipe.PAUS);
    cartas[45] = new Carta(Nome.SETE, Naipe.PAUS);
    cartas[46] = new Carta(Nome.OITO, Naipe.PAUS);
    cartas[47] = new Carta(Nome.NOVE, Naipe.PAUS);
    cartas[48] = new Carta(Nome.DEZ, Naipe.PAUS);
    cartas[49] = new Carta(Nome.VALETE, Naipe.PAUS);
    cartas[50] = new Carta(Nome.DAMA, Naipe.PAUS);
    cartas[51] = new Carta(Nome.REI, Naipe.PAUS);
    cartas[52] = new Carta(Nome.CORINGA, Naipe.CORINGA);
    cartas[53] = new Carta(Nome.CORINGA, Naipe.CORINGA);
    cartas[54] = new Carta(Nome.CORINGA, Naipe.CORINGA);
    cartas[55] = new Carta(Nome.CORINGA, Naipe.CORINGA);
  }
  
  public void embaralhar() {
    int posicao = 0;
    Carta auxiliar = null;
    for(int i = 0; i < getCartas().length; i++) {
      posicao = (int) (Math.random() * 10 * 5.5);
      auxiliar = getCartas()[i];
      getCartas()[i] = getCartas()[posicao];
      getCartas()[posicao] = auxiliar;
    }
  }
  
  public Carta distribuirCarta() {
    Carta auxiliar = null;
    if(getCartas()[0] != null) {
      for(int i = getCartas().length - 1; i >= 0; i--) {
        if(getCartas()[i] != null) {
          auxiliar = getCartas()[i];
          this.cartas[i] = null;
          return auxiliar;
        }
      }      
    }
    return auxiliar;
  }
  
  public boolean hasCarta() {
    return getCartas()[0] != null ? true : false;
  }
  
  public void imprimirBaralho() {
    for(int i = 0; i < getCartas().length; i++) {
      if(getCartas()[i] != null) {
        System.out.println(getCartas()[i].getNome() + " de " + getCartas()[i].getNaipe());
      } else {
        break;
      }
    }
  }
}
