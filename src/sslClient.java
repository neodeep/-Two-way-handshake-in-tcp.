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
import java.security.PrivateKey;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.net.Socket;
import java.net.SocketException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.security.PublicKey;


public class sslClient {
	  public static void main(String[] args) throws IOException, NoSuchAlgorithmException{
	    SSLSocket sslSocket = null;
	    try {
	      SSLSocketFactory sslSocketFactory =
	          (SSLSocketFactory) SSLSocketFactory.getDefault();
	      sslSocket =
	        
 		 (SSLSocket) sslSocketFactory.createSocket("localhost", 7575);
	      
 		System.out.println("Connection Established");
	         display_public_key(); //show the public key



	      byte[] contents = new byte[9999];
	      
	      
	      
	      
	     
	      FileOutputStream fos = new FileOutputStream("C:\\Users\\neodeep\\Desktop\\ibg.txt");
	        BufferedOutputStream bos = new BufferedOutputStream(fos);
	        InputStream is = sslSocket.getInputStream();
	        
	        //No of bytes read in one read() call
	        int bytesRead = 0; 
	        long ttime=0;
                long start = System.nanoTime();
	        while((bytesRead=is.read(contents))!=-1)
	            bos.write(contents, 0, bytesRead); 
	        long stop = System.nanoTime();
	        bos.flush(); 
	        sslSocket.close(); 
	        
	        
		ttime = stop - start;
		System.out.println("File arrived successfully!!! in time " + ttime + " nanoseconds");
	      System.out.println("the connection has terminated gracefully!!!");
	      
	      
	      
	      
	      
	      
       /* BufferedReader inFromServer = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
	      String modifiedSentence;
	      
	      modifiedSentence = inFromServer.readLine();
	     System.out.println("FROM SERVER: " + modifiedSentence);
	      */
	      
	    } finally {
	      if (sslSocket != null) {
	        try {
	          sslSocket.close();
	        } catch (IOException x) {
	          // Handle error
	        }
	      }
	    }
	  }
	  
	  public static void display_public_key()  throws NoSuchAlgorithmException {
		  
	 
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