import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
import java.net.*;
import java.io.*;


public class client_2015010r1 extends Thread 
{
	static Socket soc = null;
	static DataOutputStream out = null;
	static DataInputStream in = null;
	static PrintStream priOstr = null;
	static BufferedReader br = null;
	//static InputStreamReader istrRead = null;
	static int flag = 0;
		

	public void run(){
		try{
			String str;
			while((str = in.readLine())!=null){
				//System.out.println("lopo "+str.indexOf("close"));
				System.out.println(str);
				//str = in.readLine();
				if(str.indexOf("close")!= -1)
					break;
				//System.out.println("lopoo");
			}
		flag = 1;
		//System.out.println("lopsoo");
		return;
		}
		catch(Exception r){
			System.out.println("You got an IOException..");
		}
	}


	public static void main(String[] args) throws Exception
	{
		//arg[0] - IP address //arg[1] - Port
		try
		{
			soc = new Socket("127.0.0.1",2222);
			//takes input from terminal
			System.out.println("Connection established");
			//Scjset
			in = new DataInputStream(soc.getInputStream());	
			//sends output to socket
			//out = new DataOutputStream(soc.getOutputStream());
			priOstr = new PrintStream(soc.getOutputStream());
			br = new BufferedReader(new InputStreamReader(System.in));
		} 
		catch(IOException e)
		{
			System.out.println("IO problem ");
		}

		//String st = "";
		//String st2 = "";
		new Thread(new client_2015010r1()).start();
		while(flag == 0)
		{
			try
			{
				//	st = br.readLine();
				//new Thread(new client_2015010r1()).start();
				priOstr.println(br.readLine());
				//out.writeUTF(st);
				//st2 = in.readUTF();
				//System.out.println("Message from server: " + st2);
			}
			catch(Exception ex)
			{
				System.out.println("Server Didn't send a proper message.");
				break;
			}
		}
		System.out.println("Connection closed.");
		try
		{
			priOstr.close();
			in.close();
			soc.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
