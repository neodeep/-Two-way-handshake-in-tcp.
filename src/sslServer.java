import java.io.*;

import java.security.KeyPair;
import java.security.cert.CertificateFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Scanner;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import java.sql.Timestamp;

import java.security.PrivateKey;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.net.Socket;
import java.net.SocketException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.security.PublicKey;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

class EchoServer {
private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
	  public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
	    SSLServerSocket sslServerSocket = null;
	    try {
	      SSLServerSocketFactory sslServerSocketFactory =
	          (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
	      sslServerSocket = (SSLServerSocket) sslServerSocketFactory.
	                        createServerSocket(7575);
	      SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
	      System.out.println("Connection Established");
	      display_public_key();//
	      
	     File file = new File("C:\\Users\\neodeep\\Desktop\\deneme.txt");
	        FileInputStream fis = new FileInputStream(file);
	        BufferedInputStream bis = new BufferedInputStream(fis); 
	          
	        //Get socket's output stream
	        OutputStream os = sslSocket.getOutputStream();
	                
	        //Read File Contents into contents array 
	        byte[] contents=new byte[9999]; 
	        int size = 9999;
	        bis.read(contents, 0,size); 
	        os.write(contents);
	        os.flush(); 
	        bis.close();
	        //File transfer done.
	        sslSocket.close();
	        sslServerSocket.close();
	        System.out.println("File sent succesfully!");
	        System.out.println("the connection has terminated gracefully!!!");
	      



	      
	    } finally {
	      if (sslServerSocket != null) {
	        try {
	          sslServerSocket.close();
	        } catch (IOException x) {
	          // Handle error
	        }
	      }
	    }
	  }

  	public static void display_public_key() throws NoSuchAlgorithmException  {
		  
	 
	 KeyPairGenerator ibg_key = KeyPairGenerator.getInstance("RSA");
         ibg_key.initialize(1024,new SecureRandom());
         KeyPair key_pair = ibg_key.generateKeyPair();
         PublicKey ibg_public_Key = key_pair.getPublic();
         System.out.println("-  Public Key  -");
         System.out.println( ibg_public_Key);
         System.out.println("-Certificate Type-");
         System.out.println(ibg_public_Key.getFormat());

	  }



	}
