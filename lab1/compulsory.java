package l1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Teodorovici Gavril-Anton
 */
public class compulsory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        // Compulsory 
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        
        n *= 3;
        n += Integer.parseInt("10101",2);
        n += Integer.parseInt("FF", 16);
        n *= 6;
       
        int newRes = 0;
        
        // voi face suma numerelor lui n, iar cand termin de facut suma verific daca rezultatul are mai mult de o cifra 
        //caz in care voi face din nou suma cifrelor si ma voi opri in momentul in care suma obtinuta va fi de doar o cifra.
        while(n>0)
        {
            newRes += n%10 ;
            n /= 10;
            if(n == 0){
                if(newRes > 9) {
                    n = newRes;
                    newRes = 0;
                }
                else
                    break;
            }
        }
        
        
        System.out.println("Willy-nilly, this semester I will learn " + languages[newRes] + ".");
    
    }
}
