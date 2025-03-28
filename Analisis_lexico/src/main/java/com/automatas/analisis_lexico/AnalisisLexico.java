/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.automatas.analisis_lexico;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author miguel
 */
public class AnalisisLexico {
    
    LinkedList<Simbolo> tablaLexico = new LinkedList<>();
    LinkedList<String> errorLexico = new LinkedList<>();

    Set<String> Reservadas = new HashSet<>(Arrays.asList(
    "Si", "Sino", "Mientras", "Para", "Segun", "Hacer", "Dim", "As", "Entero", "Cadena", "Escribir",
    "Leer", "Entonces", "FinSi", "Siguiente", "Para", "Hasta", "Caso", "CasoElse", "FinSegun", "Funcion",
    "Como", "FinFuncion", "Numero", "Metodo", "FinMetodo"
    ));
    
    public String anlizar (String entrada){
        String codigoHtml = "";
        Simbolo s = new Simbolo();
        char[] letras = entrada.toCharArray();
        char estado = 'A';
        int columna = 0;
        int linea = 1;
        boolean validarCaracteres;
        for (char letra : letras) {
            columna++;
            validarCaracteres = false;
            switch (estado) {
                case 'A':
                    switch (letra) {
                        case 'i':
                            estado = 'B';
                            s.lexema = "i";
                            s.columna = columna;
                            s.linea = linea;
                            break;
                        case 's':
                            estado = 'C';
                            s.lexema = "s";
                            s.columna = columna;
                            s.linea = linea;
                            break;
                        case 'D':
                            estado = 'D';
                            s.lexema = "D";
                            s.columna = columna;
                            s.linea = linea;
                            break;
                        case 'S':
                            estado = 'B';
                            s.lexema = "S";
                            s.columna = columna;
                            s.linea = linea;
                            break;
                        case 'A':
                            estado = 'B';
                            s.lexema = "A";
                            s.columna = columna;
                            s.linea = linea;
                            break;
                        case 'L':
                            estado = 'B';
                            s.lexema = "L";
                            s.columna = columna;
                            s.linea = linea;
                            break;
                        case '+':
                            codigoHtml += "<font size='12' color='red'>+</font>";
                            s.lexema = "+";
                            s.expresionRegular = "+";
                            s.token = "mas";
                            s.columna = columna;
                            s.linea = linea;
                            tablaLexico.add(s);
                            s = new Simbolo();
                            break;
                        case '-':
                            codigoHtml += "<font size='12' color='red'>-</font>";
                            s.lexema = "-";
                            s.expresionRegular = "-";
                            s.token = "menos";
                            s.columna = columna;
                            s.linea = linea;
                            tablaLexico.add(s);
                            s = new Simbolo();
                            break;
                        case '<':
                            codigoHtml += "<font size='12' color='red'>&lt;</font>";
                            s.lexema = "<";
                            s.expresionRegular = "<";
                            s.token = "menor";
                            s.columna = columna;
                            s.linea = linea;
                            tablaLexico.add(s);
                            s = new Simbolo();
                            break;
                        case '>':
                            codigoHtml += "<font size='12' color='red'>&gt;</font>";
                            s.lexema = ">";
                            s.expresionRegular = ">";
                            s.token = "mayor";
                            s.columna = columna;
                            s.linea = linea;
                            tablaLexico.add(s);
                            s = new Simbolo();
                            break;
                        case '=':
                            codigoHtml += "<font size='12' color='red'>=</font>";
                            s.lexema = "=";
                            s.expresionRegular = "=";
                            s.token = "igual";
                            s.columna = columna;
                            s.linea = linea;
                            tablaLexico.add(s);
                            s = new Simbolo();
                            break;
                        case '{':
                            codigoHtml += "<font size='12' color='purple'>{</font>";
                            s.lexema = "{";
                            s.expresionRegular = "{";
                            s.token = "llave abre";
                            s.columna = columna;
                            s.linea = linea;
                            tablaLexico.add(s);
                            s = new Simbolo();
                            break;
                        case '}':
                            codigoHtml += "<font size='12' color='purple'>}</font>";
                            s.lexema = "}";
                            s.expresionRegular = "}";
                            s.token = "llave cierra";
                            s.columna = columna;
                            s.linea = linea;
                            tablaLexico.add(s);
                            s = new Simbolo();
                            break;
                        case '(':
                            codigoHtml += "<font size='12' color='purple'>(</font>";
                            s.lexema = "(";
                            s.expresionRegular = "(";
                            s.token = "par. abre";
                            s.columna = columna;
                            s.linea = linea;
                            tablaLexico.add(s);
                            s = new Simbolo();
                            break;
                        case ')':
                            codigoHtml += "<font size='12' color='purple'>)</font>";
                            s.lexema = ")";
                            s.expresionRegular = ")";
                            s.token = "par. cierra";
                            s.columna = columna;
                            s.linea = linea;
                            tablaLexico.add(s);
                            s = new Simbolo();
                            break;
                        case ';':
                            codigoHtml += "<font size='12' color='green' >;</font>";
                            s.lexema = ";";
                            s.expresionRegular = ";";
                            s.token = "punto y coma";
                            s.columna = columna;
                            s.linea = linea;
                            tablaLexico.add(s);
                            s = new Simbolo();
                            break;
                            case '\'':
                            codigoHtml += "<font size='12' color='gray'>'</font>";
                            estado = 'Z';
                            break;
                            case '\"':
                            codigoHtml += "<font size='12' color='orange'>\"</font>";
                            estado = 'M';
                            break;
                        case ' ':
                            codigoHtml += "&nbsp;";
                            break;
                        case '\n':
                            columna = 0;
                            linea++;
                            codigoHtml += "<br>";
                            break;
                        case '\t':
                            codigoHtml += "&nbsp;&nbsp;&nbsp;";
                            break;
                        default:
                            validarCaracteres = true;
                    }
                    if (validarCaracteres) {
                        if ((letra >= 65 && letra <= 90) || (letra >= 97 && letra <= 122)) {
                            estado = 'E';
                            s.lexema = letra + "";
                            s.columna = columna;
                            s.linea = linea;
                        } else {
                            if (letra >= 48 && letra <= 57) {
                                estado = 'F';
                                s.lexema = letra + "";
                                s.columna = columna;
                                s.linea = linea;
                            } else {
                                String error = "Error lexico linea " + linea + ", columna: " + columna + ", caracter no reconocido: "+letra;
                                errorLexico.add(error);
                            }
                        }

                    }
                    break;
            }
        }
        return codigoHtml;
    }
}

