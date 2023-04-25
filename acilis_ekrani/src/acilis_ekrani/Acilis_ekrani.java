/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package acilis_ekrani;

/**
 *
 * @author Zehra
 */
public class Acilis_ekrani {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException{
        progress_yukleme giris = new progress_yukleme();
        giris.setVisible(true);
        sonuc_ekrani sonuc = new sonuc_ekrani();
        try{
            for(int i =  0; i<=100 ; i++){
                Thread.sleep(50);
                progress_yukleme.progres_yukleniyor.setValue(i);
                if(i==100){
                    giris.setVisible(false);
                    sonuc.setVisible(true);
                }
            }
        }catch(InterruptedException e){
            
        }
        
    }
    
}
