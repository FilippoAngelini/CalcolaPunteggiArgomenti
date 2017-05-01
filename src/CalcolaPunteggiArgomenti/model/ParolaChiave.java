package CalcolaPunteggiArgomenti.model;

import java.util.LinkedList;
import java.util.List;

public class ParolaChiave {
	
	String parola;
	List <Integer> argomenti = new LinkedList<Integer>();
	int[] punteggi = new int[9];
	
	public ParolaChiave(String parola){
		this.parola = parola;
	}
	
	public String getParola(){
		return parola;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParolaChiave [parola=" + parola + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parola == null) ? 0 : parola.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParolaChiave other = (ParolaChiave) obj;
		if (parola == null) {
			if (other.parola != null)
				return false;
		} else if (!parola.equals(other.parola))
			return false;
		return true;
	}

	/**
	 * @return the argomenti
	 */
	public List<Integer> getArgomenti() {
		return argomenti;
	}

	public void aumentaPunteggio(Integer k) {
		
		if(argomenti.contains(k))
			punteggi[k-1]++;
		
		//punteggi[k-1]++;
	}

	public void addArgomento(int argomento) {
		
		argomenti.add(argomento);
	}

	public String stampaArgomenti() {

		String ris = "";
		
		for(int i : argomenti)
			ris += ";" + i;
		
		return ris;
	}
	
	public String stampaPunteggi(){
		
		String ris = "";
		
		for(int i = 0 ; i<punteggi.length ; i++){
			ris += punteggi[i] + "	";
		}
		
		return ris;
	}

}
