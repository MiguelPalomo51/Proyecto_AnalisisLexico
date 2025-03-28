package graficadorafinal;

import java_cup.runtime.Symbol;
 
%%
%cupsym Simbolo
%cup
%class AnalisisLexico
%public
%unicode
%line
%char
%ignorecase

%{
    
    private void error(String message) {
    
        System.out.println("Error: "+message);
  }
%}

%%

<YYINITIAL>{

    
    "linea" {
        return new Symbol(Simbolo.linea,yytext());
    }
    
    "cuadrado" {
        return new Symbol(Simbolo.cuadrado,yytext());
    }

    "rectangulo" {
        return new Symbol(Simbolo.rectangulo,yytext());
    }

    "circulo" {
        return new Symbol(Simbolo.circulo,yytext());
    }

    "ovalo" {
        return new Symbol(Simbolo.ovalo,yytext());
    }

    "trianguloRectangulo" {
        return new Symbol(Simbolo.trianguloRectangulo,yytext());
    }
    
    "estrella" {
        return new Symbol(Simbolo.estrella,yytext());
    }

    "poligono" {
        return new Symbol(Simbolo.poligono,yytext());
    }

    "pacman" {
        return new Symbol(Simbolo.pacman,yytext());
    }

    "(" {
        return new Symbol(Simbolo.parAbre,yytext());
    }

    ")" {
        return new Symbol(Simbolo.parCierra,yytext());
    }

    [0-9]+ {
        return new Symbol(Simbolo.entero,yytext());
    }

    "," {
        return new Symbol(Simbolo.coma,yytext());
    }

    ";" {
        return new Symbol(Simbolo.pcoma,yytext());
    }
    
    "rojo" {
        return new Symbol(Simbolo.rojo,yytext());
    }

    "azul" {
        return new Symbol(Simbolo.azul,yytext());
    }

    "celeste" {
        return new Symbol(Simbolo.celeste,yytext());
    }

    "verde" {
        return new Symbol(Simbolo.verde,yytext());
    }

    "negro" {
        return new Symbol(Simbolo.negro,yytext());
    }

    "morado" {
        return new Symbol(Simbolo.morado,yytext());
    }

    "anaranjado" {
        return new Symbol(Simbolo.anaranjado,yytext());
    }

    "rosado" {
        return new Symbol(Simbolo.rosado,yytext());
    }

    "cafe" {
        return new Symbol(Simbolo.cafe,yytext());
    }

    "amarillo" {
        return new Symbol(Simbolo.amarillo,yytext());
    }

    "gris" {
        return new Symbol(Simbolo.gris,yytext());
    }

    "rellena" {
        return new Symbol(Simbolo.rellena,yytext());
    }

    "contorno" {
        return new Symbol(Simbolo.contorno,yytext());
    }
    "pequeno" {
        return new Symbol(Simbolo.pequeno,yytext());
    }
    "mediano" {
        return new Symbol(Simbolo.mediano,yytext());
    }
    "grande" {
        return new Symbol(Simbolo.grande,yytext());
    }

    (" " | \r | \n | \t | \f)+ {}

    .   {   
        error(yytext());      

    }

}

