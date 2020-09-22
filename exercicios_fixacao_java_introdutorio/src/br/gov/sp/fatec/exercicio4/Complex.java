package br.gov.sp.fatec.exercicio4;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Complex {
  private double real;
  private double imaginaria;

  public Complex() {
    this.real = 0;
    this.imaginaria = 0;
  }

  public Complex(double real) {
    this.real = real;
    this.imaginaria = 0;
  }

  public Complex(double real, double imaginaria) {
    this.real = real;
    this.imaginaria = imaginaria;
  }

  public Double getModulo() {
    Double realPow = Math.pow(real, 2);
    Double imaginariaPow = Math.pow(imaginaria, 2);
    Double somaRealPowImaginariaPow = realPow + imaginariaPow;
    Double raizSomaRealPowImaginariaPow = Math.sqrt(somaRealPowImaginariaPow);
    
    return raizSomaRealPowImaginariaPow;
  }
  
  public Double getAngulo() {
    Double modulo = this.getModulo();
    Double divisaoRealImaginaria = real / imaginaria;
    Double tangenteDivisaoRealImaginaria = Math.tan(divisaoRealImaginaria);
    Double arcotangenteTangenteDivisaoRealImaginaria = Math.atan(tangenteDivisaoRealImaginaria);
    
    return arcotangenteTangenteDivisaoRealImaginaria;
  }

  public Double getInversoAditivo() {
    Double somaRealImaginaria = real + imaginaria;
    Double inversoAditivo = Math.pow(somaRealImaginaria, -1);
    
    return inversoAditivo;
  }

  public Complex somar(Complex x, Complex y) {
    return new Complex(x.real + y.real, x.imaginaria + y.imaginaria);
  }

  public Complex subtrair(Complex x, Complex y) {
    return new Complex(x.real - y.real, x.imaginaria - y.imaginaria);
  }

  public Complex multiplicar(Complex x, Complex y) {
    return new Complex(x.real * y.real, x.imaginaria * y.imaginaria);
  }

  public Complex dividir(Complex x, Complex y) {
    return (y.real > 0 && y.imaginaria > 0) ? new Complex(x.real / y.real, x.imaginaria / y.imaginaria) : new Complex();
  }

  public String toString() {
    return "(" + real + ", " + imaginaria + ")";
  }

}
