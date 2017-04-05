import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class GeradorBinario {

	public static void main(String[] args) {
		try {		
			int bits = Integer.parseInt(args[0]);
			int qnumeros = Integer.parseInt(args[1]);
			
			int valor = (int)(Math.pow(2,bits));
			
			Random gerador = new Random();
			List<String> binary = new LinkedList<String>(); 
			while(binary.size() != qnumeros){
				String value = Integer.toBinaryString(gerador.nextInt(valor));
				if (value.length() == bits){
					binary.add(value);					
				}
			}
			
			File arquivo = new File("binary.txt");
	        try {
	            if (arquivo.exists()) {
	                arquivo.delete();
	            }
	            arquivo.createNewFile();
	            FileWriter fw = new FileWriter(arquivo, true);
	            PrintWriter pw = new PrintWriter(fw);
	
	            for (String x  : binary) {
	                pw.println(x);
	            }
	            pw.flush();
	            pw.close();
	
	            System.out.println("\nArquivo com valores gerado com sucesso!");
	
	        } catch (IOException e) {
	            System.out.println("\nErro ao gerar arquivo com valores!");
	        }
		} catch (Exception e){
			System.out.println("\nErro ao gerar valores!");
			System.out.println("Veja se você está executando corretamente: \n java -jar BinaryGenerator.jar <NumeroDeBits> <NumeroDeValores>\n");
		}
    }

    

}
