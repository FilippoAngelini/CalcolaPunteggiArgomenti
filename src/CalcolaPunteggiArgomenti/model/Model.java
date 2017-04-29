package CalcolaPunteggiArgomenti.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import CalcolaPunteggiArgomenti.model.ParolaChiave;

public class Model {
	
	List<ParolaChiave> paroleChiave;
	
	public Model() throws IOException{
		
		paroleChiave = new LinkedList<ParolaChiave>();
		
		FileReader fr = new FileReader ("paroleConArgomenti.txt");
		BufferedReader br = new BufferedReader(fr);
		String riga = "";
		
		ParolaChiave parola = null;
		
		while((riga=br.readLine())!=null){
			String array[] = riga.split(";");
			for(int i = 0; i<array.length;i++){
				if(i==0){
					parola = new ParolaChiave(array[i]);
					paroleChiave.add(parola);
				}
				else
					parola.addArgomento(Integer.parseInt(array[i]));
			}
		}
		
		br.close();
		fr.close();
	}
	
	public void Stampa(){
		System.out.println(paroleChiave.toString());
	}
	
	public void calcolaPunteggi() throws IOException{
		
		FileReader fr = new FileReader ("righe.txt");
		BufferedReader br = new BufferedReader(fr);
		String riga = "";
		ParolaChiave parola1 = null;
		ParolaChiave parola2 = null;

		while((riga=br.readLine())!=null){
			String array[] = riga.split("	");

			for(int i = 0; i<array.length ; i++){
				if(paroleChiave.contains(new ParolaChiave(array[i]))){
					parola1 = paroleChiave.get(paroleChiave.indexOf(new ParolaChiave(array[i])));
					for(int j=0 ; j<array.length ; j++){
						if(paroleChiave.contains(new ParolaChiave(array[j]))){
							parola2 = paroleChiave.get(paroleChiave.indexOf(new ParolaChiave(array[j])));
							for(Integer k : parola2.getArgomenti())
								parola1.aumentaPunteggio(k);
						}
					}
				}
			}
		}
		
		br.close();
		fr.close();
	}
	
	public void stampaPunteggi(){
		
		for(ParolaChiave p : paroleChiave)
			//System.out.println("Parola: " + p.getParola() + " Punteggi: " + p.stampaPunteggi());
			System.out.println("" + p.getParola() + "	" + p.stampaPunteggi());
	}

}
