package analisadorlexico;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        String token;
        AnaliseLexica al;
        
        System.out.print("Digite o token a ser analisado : ");
        token = ler.next();
        
        al = new AnaliseLexica(token);
        Boolean saida = al.analisador();
        
        if(saida){
            System.out.println("\n token foi aceito na linguagem!");
        }else{
            System.out.println("\n token não foi aceito na linguagem!");
        }
    }
}
