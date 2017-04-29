package CalcolaPunteggiArgomenti.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Appoggio {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		List<ParolaChiave> paroleChiave = new LinkedList<ParolaChiave>();
		
		FileReader fr = new FileReader ("appoggio.txt");
		BufferedReader br = new BufferedReader(fr);
		String riga = "";
		
		ParolaChiave parola = null;
		int arg = 1;
		
		while((riga=br.readLine())!=null){
			String array[] = riga.split("	");
			for(int i = 0; i<array.length;i++){
				if(!paroleChiave.contains(new ParolaChiave(array[i]))){
					parola = new ParolaChiave(array[i]);
					paroleChiave.add(parola);
				}
				else
					parola = paroleChiave.get(paroleChiave.indexOf(new ParolaChiave(array[i])));
				
				parola.addArgomento(arg);
			}
			arg++;
		}
		
		br.close();
		fr.close();
		
		System.out.println(paroleChiave.size());
		
		for(ParolaChiave p : paroleChiave){
			
			System.out.println(p.getParola() + p.stampaArgomenti());
		}
		
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("Parole Errate:\n");
		
		fr = new FileReader ("righe.txt");
		br = new BufferedReader(fr);
		riga = "";
		
		parola = null;
		
		String paroleErrate = "";
		
		int rigaCorso = 16;
		
		while((riga=br.readLine())!=null){
			String array[] = riga.split("	");
			for(int i = 0; i<array.length;i++){
				if(!paroleChiave.contains(new ParolaChiave(array[i]))){
					paroleErrate += "parola: " + array[i] + " riga: " + rigaCorso +  "\n";
				}

			}
			rigaCorso++;
		}
		
		br.close();
		fr.close();
		
		System.out.println(paroleErrate);

	}

}
