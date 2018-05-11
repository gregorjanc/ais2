package paketi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public interface PaketVmesnik {
	@Override
	String toString();

	void posljiMail();

}
