package zrno;

import javax.ejb.Local;
import javax.ejb.Remote;


@Remote
public interface MojeZrnoLocal {
	
	double izracunajITM(double teza, double visina);

}
