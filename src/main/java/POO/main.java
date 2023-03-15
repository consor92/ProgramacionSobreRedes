package POO;

import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Gonza
 *
 */
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Cuchillo arma1 = new Cuchillo(452334 , "Navaja" );
		
		Detective Sherlock = new Detective(new Dni("Sherlock"), new Lugar( "" , 5 ) );
		Mafioso DarthVader = new Mafioso( new Dni("DarthVader"), new Lugar( "" , 2 )  );
		
		Antecedente antCiviles = new Antecedente();
		Antecedente antPenales = new Antecedente();
		
		Perfiles sociopata = new Perfiles();
		
		Sherlock.setAntecedentes(antCiviles);
		DarthVader.setAntecedentes(antPenales);
		
		ArrayList<Arma> armasDetective =  Sherlock.getMisArmas();
		armasDetective.add(arma1);
		Sherlock.setMisArmas( armasDetective );
		
		
		Sherlock.herir( DarthVader );
		
		
	}

}
