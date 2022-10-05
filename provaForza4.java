
import java.util.Arrays;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Graphics;
import java.awt.Color;

public class provaForza4 extends java.applet.Applet implements ActionListener {
    
        static int colpo1,colpo12,colpo13,colpo14,colpo15,colpo16,colpo17;
        static int pos;
        static int valore;
        static boolean pl1;
        static boolean pl2;
        static boolean win;
        static String save_game;
        private static final int rows = 6;
        private static final int columns = 7;
        private static final boolean x= false;
        

    
    public static void main(String[] args) throws IOException{
       

        
        int Matrice[][];
        colpo1=colpo12=colpo13=colpo14=colpo15=colpo16=colpo17=5;
        pl1 = true;
        pl2 = false;
        win = true;
        Matrice = new int [rows][columns];
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Vuoi riprendere la partita rimasta sospesa? [Y/N]");
        save_game = in.next();
        if(save_game == "Y"){
            readFile(Matrice);
            printMatrix(Matrice);
            inputMatrice(Matrice);
        }
        else
        inputMatrice(Matrice);
    }

    public static void inputMatrice(int matr[][]) throws IOException{
    
        while((colpo1 >= 0 || colpo12 >= 0 || colpo13 >= 0 || colpo14 >= 0 || colpo15 >= 0 || colpo16 >= 0 || colpo17 >= 0) && (win))
        {
            if(pl1){
                System.out.println("E il turno di 1: " );
            }
            else{
                System.out.println("E il turno di 1 : ");
            }
           
            Scanner in = new Scanner(System.in);
            System.out.println("Vuoi interropere la partita?[Y/N]");
            x = in.nextBoolean(); 
            if(x == true ){
                printMatrix(matr);
            }

            System.out.println("Inserisci posizione");
            System.out.flush();
            pos = System.in.read()-'0';
            System.in.skip(2);
            pos = pos - 1;

                switch(pos){
                    case 0:
                    {
                        if(colpo1 >= 0){
                            Turno();
                            matr[colpo1][pos] = valore;
                            CheckWin(matr,colpo1,pos);
                            printMatrix(matr);
                            colpo1 = colpo1 - 1;
                        } else System.out.println("Posizione non valida,riprova.");
                    } 
                    break;

                    case 1:
                    {
                        if(colpo12 >= 0){
                            Turno();
                            matr[colpo12][pos] = valore;
                            CheckWin(matr, colpo12, pos);
                            printMatrix(matr);
                            colpo12 = colpo12 - 1;
                        } else System.out.println("Posizione non valida,riprova.");
                    }
                    break;

                    case 2:
                    {
                        if(colpo13 >= 0){
                            Turno();
                            matr[colpo13][pos] = valore;
                            CheckWin(matr, colpo13, pos);
                            printMatrix(matr);
                            colpo13 = colpo13 - 1; 
                        } else System.out.println("Posizione non valida,riprova.");
                    }
                    break;
                    
                    case 3:
                    {
                        if(colpo14 >= 0){
                            Turno();
                            matr[colpo14][pos] = valore;
                            CheckWin(matr, colpo14, pos);
                            printMatrix(matr);
                            colpo14 = colpo14 - 1; 
                        } else System.out.println("Posizione non valida,riprova.");
                    }
                    break;

                    case 4:
                    {
                        if(colpo15 >= 0){
                            Turno();
                            matr[colpo15][pos] = valore;
                            CheckWin(matr, colpo15, pos);
                            printMatrix(matr);
                            colpo15 = colpo15 - 1; 
                        } else System.out.println("Posizione non valida,riprova.");
                    }
                    break;

                    case 5:
                    {
                        if(colpo16 >= 0){
                            Turno();
                            matr[colpo16][pos] = valore;
                            CheckWin(matr, colpo16, pos);
                            printMatrix(matr);
                            colpo16 = colpo16 - 1; 
                        } else System.out.println("Posizione non valida,riprova.");
                    }
                    break;

                    case 6:
                    {
                        if(colpo17 >= 0){
                            Turno();
                            matr[colpo17][pos] = valore;
                            CheckWin(matr, colpo17, pos);
                            printMatrix(matr);
                            colpo17 = colpo17 - 1; 
                        } else System.out.println("Posizione non valida,riprova.");
                    }
                    break;

                    default : System.out.println("Posizione non valida,riprova.");
                }
        }
    }

    public static void CheckWin(int matr[][],int posY , int posX){
        int temp;
        System.out.println(posX);
        // cerco orizzontali nella meta di sinistra
        if(posX < 4)
        {
            for(int i = 0 ; i < 4 ; i++)
            {
                temp= matr[posY][i];
                if(temp == matr[posY][i+1] && temp == matr[posY][i+2] && temp == matr[posY][i+3]){
                    WhoWin(temp);
                    if(!win) System.out.println("orizzontale da sx verso dx");
                    break;
                }
            }
        }
        // cerco orizzontali nella metà di destra
        else if(posX >= 4){
            for(int i = 6 ; i>3 ; i--){
                temp = matr[posY][i];
                if(temp == matr[posY][i-1] && temp == matr[posY][i-2] && temp == matr[posY][i-3]){
                    if(!win) System.out.println("orizzontale da dx verso sx");
                    break;
                }
            }
        }

        // cerco veritcali verso basso che sono 4
        if(posY <= 2 && win == true){
            temp = matr[posY][posX];
            if(temp == matr[posY+1][posX] && temp == matr[posY+2][posX] && temp == matr[posY+3][posX]){
                WhoWin(temp);
                if(!win){
                    System.out.println("verticale");
                }
            }
        }

        for (int j = 0 ; j < 6 ; j++)
        {
            if(!win) break;
                for (int i = 0 ; i < 7; i++)
                {
                    temp = matr[j][i];
                    if(temp != 0)
                    {
                        if(j > 2 && i <= 3){
                            if(     temp == matr[j-1][i+1] &&
                                    temp == matr[j-2][i+2] &&
                                    temp == matr[j-3][i+3]){
                                WhoWin(temp);
                                if(!win) break;
                            }
                        }
                        else if(j <= 2 && i <= 3){
                            if(     temp == matr[j+1][i+1] &&
                                    temp == matr[j+2][i+2] &&
                                    temp == matr[j+3][i+3]){
                                WhoWin(temp);
                                if(!win)break;
                            }
                        }
                        else if(j <= 2 && i >= 3){
                            if(     temp == matr[j-1][i-1] &&
                                    temp == matr[j-2][i-2] &&
                                    temp == matr[j-3][i-3]){
                                WhoWin(temp);
                                if(!win)break;
                            }
                        }
                        else if (j > 2 && i >= 3){
                            if(     temp == matr[j-1][i-1] &&
                                    temp == matr[j-2][i-2] &&
                                    temp == matr[j-3][i-3]){
                                WhoWin(temp);
                                if(!win)break;
                            }
                        }
                    }
                }
        }
        System.out.flush();
    }

    public static void WhoWin(int player){
        if(player == 1){
            System.out.println("giocatore 1 HA VINTO ");
            win = false;
        }else if(player == 2){
            System.out.println("giocatore 2 HA VINTO");
            win  = false;
        }

    }

    public static void namePlayers(){
        Scanner in = new Scanner(System.in);

        
        String Giocatore_1,Giocatore_2;
        System.out.print("inserisci il nome del primo giocatore: ");
        Giocatore_1 = in.next();
        System.out.print("inserisci il nome del secondo giocatore: ");
        Giocatore_2 = in.next();
    }


    //gestisco turno dei giocatori 
    public static void Turno(){

        if(pl1){
            pl1 = false;
            pl2 = true;
            valore = 1;
        }
        else{
            pl1 = true;
            pl2 = false;
            valore = 2; 
        }
    }

    // carico la matrice
    public static void loadMatric(int matr[][]) throws IOException{

        for(int i = 0 ; i < 7; i++){
            for(int j = 0 ; j < 6 ; j++){
                System.out.println("INSERISCI "+i+j+": ");
                System.out.flush();
                matr[i][j] = System.in.read()-'0';
                System.in.skip(2);
            }
        }
    }

    //stampa matrice
    public static void printMatrix(int matr[][]){
        System.out.println();
        for(int i = 0 ; i < 6 ; i++){
            for(int j = 0 ; j < 7 ; j++){
                System.out.flush();
                System.out.print(matr[i][j]+" ");
            }
            System.out.println();
        }

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("matrix.txt")));
            
            for(int i = 0; i < matr.length ; i++){
                for(int j = 0 ; j < matr[i].length; j++){
                    writer.write(matr[i][j]+ " ");
                }
                writer.newLine();
            }
            writer.flush();
            writer.close();

        }catch(IOException e){
            System.out.println("error.");
        }}
        // classe che deve riprendere la partita lasciata sospesa
        public static void readFile(int matr[][])throws FileNotFoundException{  
            Scanner sc = new Scanner(System.in);
            FileReader file = new FileReader("matrix.txt");
            BufferedReader b = new BufferedReader(file);
            while(sc.hasNextLine())
            {
                for(int i=0 ; i<matr.length ; i++){
                    String[] line = sc.nextLine().trim().split(" ");
                    for(int j=0 ; j<line.length ; j++ ){
                        matr[i][j] = Integer.parseInt(line[j]);
                    }
                }
            }
            System.out.println(Arrays.deepToString(matr));
             
            


        

        }
    }


    

  


