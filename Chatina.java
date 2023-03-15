import java.net.*;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

class Receptor extends Thread
{
	public void run()
		throws IOException
	{
		ServerSocket servidor	= new ServerSocket(12345);
		Socket cliente		= servidor.accept();
        	Scanner msg		= new Scanner(cliente.getInputStream());

		System.out.println("Chatina App de Conversacoes");
		System.out.println("______________________________________________");
		System.out.println("Conectado com usuario " + cliente.getInetAddress().getHostAddress());

		while(msg.hasNextLine())
			System.out.println(msg.nextLine());

		msg.close();
		cliente.close();
		servidor.close();
	}
}

class Emissor
{
	public void run()
			throws UnknownHostException , IOException
	{
		Socket cliente		= new Socket("127.0.0.1", 12345);
		PrintStream saida	= new PrintStream(cliente.getOutputStream());
        	Scanner teclado		= new Scanner(System.in);

		System.out.println("Chatina App de Conversacoes");
		System.out.println("______________________________________________");
		System.out.println("Conectado com usuario " + cliente.getInetAddress().getHostAddress());

		while(teclado.hasNextLine())
			saida.println(teclado.nextLine());

		teclado.close();
		saida.close();
		cliente.close();
	}
}
