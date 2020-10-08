package br.gov.sp.fatec.baralho;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Baralho {
  private Carta[] cartas;
  
  public Baralho() {
    Naipe[] naipes = new Naipe[] {Naipe.OUROS, Naipe.ESPADAS, Naipe.COPAS, Naipe.PAUS, Naipe.CORINGA};
    Nome[] nomes = new Nome[] {Nome.AS, Nome.DOIS, Nome.TRES, Nome.QUATRO, Nome.CINCO, Nome.SEIS, Nome.SETE, 
                               Nome.OITO, Nome.NOVE, Nome.DEZ, Nome.VALETE, Nome.DAMA, Nome.REI, Nome.CORINGA};
    
    setCartas(cartas = new Carta[(naipes.length - 1) * nomes.length]);
    
    int contador = 0;
    
    for(int i = 0; i < (naipes.length - 1); i++) {
      for(int j = 0; j < nomes.length; j++) {
        if(nomes[j] != Nome.CORINGA) {
          cartas[contador] = new Carta(nomes[j], naipes[i]);
        } else {
          cartas[contador] = new Carta(nomes[nomes.length - 1], naipes[naipes.length - 1]);
        }
        contador++;
      }
    }
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
  
  public static void main(String[] args) {
    Baralho baralho = new Baralho();
    
    baralho.imprimirBaralho();
    
    baralho.embaralhar();
    
    baralho.imprimirBaralho();
    
    for(int i = 0; i < (baralho.getCartas().length) - 1; i++) {
      Carta retirada = baralho.distribuirCarta();
      System.out.println("RETIRADA " + retirada.getNome() + " de " + retirada.getNaipe());
    }
    
    System.out.println(baralho.hasCarta());
    
    baralho.imprimirBaralho();
    
    System.out.println(baralho.hasCarta());
    
    baralho.distribuirCarta();
    
    System.out.println(baralho.hasCarta());
    
    baralho.distribuirCarta();
    
    System.out.println(baralho.hasCarta());
  }
}
