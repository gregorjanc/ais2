package zrno;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class MojeZrno
 */
@Stateless

public class MojeZrno implements MojeZrnoLocal {

	@Override
	public double izracunajITM(double teza, double visina) {
	
		return 	teza/(visina*visina) ;
	}

	
 
   
  
}
