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
class serverOutput implements Runnable {

    
    DataInputStream inp;
   
    String x ;
    String pass;
    int flag;
    boolean login;
    int client_no; 
    
    public serverOutput(DataInputStream dinp ,int clientno ) {
            inp = dinp;
            
            x = "init";
            pass = "root";
            flag = 0;
            login = false;
            client_no = clientno;
    }
    
    
    
    @Override
    public void run() {
        
        
        try{
            while(!x.equals("exit")) {
                  x = inp.readUTF();
                System.out.println(x);
                    
                
                if(x.startsWith("Password")){
                    int j =0;
                   for(int k = 9; k <=12;k++,j++){
                       if(x.charAt(k) != pass.charAt(j)){
                           flag = 1;
                           break;
                       }else
                           flag = 2;
                   } 
                    
                  if(flag == 2) {
                      login = true;
                  Mserver_gui.success = true;
                  Mserver_gui.successsockets[client_no] = 1;
                  }
                  
                }
           
                if(login && !x.startsWith("Password")) {
                
                   Mserver_gui.sendthistoeveryone(x,client_no);
                }
            }
            
           
        }catch(Exception e) {
            e.printStackTrace();
           
        }
        
    }
    
    
}
