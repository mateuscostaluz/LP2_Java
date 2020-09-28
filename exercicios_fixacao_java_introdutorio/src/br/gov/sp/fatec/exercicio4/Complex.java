package br.gov.sp.fatec.exercicio4;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Complex {
  private double real;
  private double imaginaria;

  public Complex() {
    setReal(0);
    setImaginaria(0);
  }

  public Complex(double real) {
    setReal(real);
    setImaginaria(0);
  }

  public Complex(double real, double imaginaria) {
    setReal(real);
    setImaginaria(imaginaria);
  }

  public Double getModulo() {
    Double realPow = Math.pow(getReal(), 2);
    Double imaginariaPow = Math.pow(getImaginaria(), 2);
    Double somaRealPowImaginariaPow = realPow + imaginariaPow;
    Double raizSomaRealPowImaginariaPow = Math.sqrt(somaRealPowImaginariaPow);
    
    return raizSomaRealPowImaginariaPow;
  }
  
  public Double getAngulo() {
    Double divisaoRealImaginaria = getReal() / getImaginaria();
    Double tangenteDivisaoRealImaginaria = Math.tan(divisaoRealImaginaria);
    Double arcotangenteTangenteDivisaoRealImaginaria = Math.atan(tangenteDivisaoRealImaginaria);
    
    return arcotangenteTangenteDivisaoRealImaginaria;
  }

  public Double getInversoAditivo() {
    Double somaRealImaginaria = getReal() / getImaginaria();
    Double inversoAditivo = Math.pow(somaRealImaginaria, -1);
    
    return inversoAditivo;
  }

  public Complex somar(Complex x, Complex y) {
    return new Complex(x.getReal() + y.getReal(), x.getImaginaria() + y.getImaginaria());
  }

  public Complex subtrair(Complex x, Complex y) {
    return new Complex(x.getReal() - y.getReal(), x.getImaginaria() - y.getImaginaria());
  }

  public Complex multiplicar(Complex x, Complex y) {
    return new Complex(x.getReal() * y.getReal(), x.getImaginaria() * y.getImaginaria());
  }

  public Complex dividir(Complex x, Complex y) {
    return (y.getReal() > 0 && y.getImaginaria() > 0) ? new Complex(x.getReal() / y.getReal(), 
                                                                    x.getImaginaria() / y.getImaginaria()) 
                                                      : new Complex();
  }

  public String toString() {
    return "(" + getReal() + ", " + getImaginaria() + ")";
  }
}
