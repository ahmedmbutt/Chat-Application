/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Anas Mughal
 */
class mainThread implements Runnable {
    
    ServerSocket yosoc;
    DataInputStream dinp;
    DataOutputStream dout;
    Thread[] t1 = new Thread[10];
    
    public mainThread(ServerSocket yo) {
        yosoc =  yo;
    }

    
    public void run() {
        
        int i  =0;
        try {
            
          //  Thread epic =  new Thread(new epicthread());
          //  epic.start();
            
            while(true) {
                Socket client = yosoc.accept();
                
                DataInputStream  dinp =  new DataInputStream(client.getInputStream());
               // DataOutputStream dout = new DataOutputStream(client.getOutputStream());
                
                  t1[i] = new Thread(new serverOutput(dinp,i));
                    t1[i].start();
                   
                    
                   Mserver_gui.globalsockets[i] = client;
                  
                  Mserver_gui.socketscount++;
                    i++;
            
            }
        
            
        }catch (Exception e){
             e.printStackTrace();
        }
    }

}

