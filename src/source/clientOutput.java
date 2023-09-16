/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

import java.io.DataInputStream;

/**
 *
 * @author Anas Mughal
 */
class clientOutput implements Runnable {

    
    DataInputStream inp;
    String x ;
    
    public clientOutput(DataInputStream dinp ) {
            inp = dinp;
            x = "init";
    }
    
    
    
    @Override
    public void run() {
        
        
        try{
            while(!x.equals("exit")) {
                 x = inp.readUTF();
                System.out.println(x);
                
                Mclient_gui.jTextPane1.setText(Mclient_gui.jTextPane1.getText() + x+"\n");
               
            }
           // inp.close();
           
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }
        
}

