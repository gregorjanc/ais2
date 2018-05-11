package u;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import nal8.vao.MeritevVao;

public class Iterator implements java.util.Iterator<MeritevVao>, Iterable<MeritevVao> {

	public Iterator(List<MeritevVao> l, Calendar odDatum, Calendar doDatum) {
		this.l = l;

		if (odDatum.before(doDatum)) {
			this.doDatum = doDatum;
			this.odDatum = odDatum;

		} else {
			this.doDatum = odDatum;
			this.odDatum = doDatum;

		}

		// System.out.println(l);
		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// System.out.println("do " + format.format(doDatum.getTime()));
		// System.out.println("od " + format.format(odDatum.getTime()));

	}

	private Calendar doDatum;
	private Calendar odDatum;
	private List<MeritevVao> l;

	private int i = 0;

	@Override
	public boolean hasNext() {
		if (i < l.size()) {
			return true;
		} else
			return false;
	}
	

	@Override
	public MeritevVao next() {

		// if (!hasNext())
		// throw new KonecIzjema();

		while (l.get(i).getDatumMeritve().before(odDatum)) {
			i++;

			if (!hasNext()) {

				i = l.size();
				return null;
			}

		}

		if (l.get(i).getDatumMeritve().after(doDatum)) {

			i = l.size();

			return null;

		}

		if ((l.size() - 1) == i) {

			if (l.get(i).getDatumMeritve().before(doDatum)) {

				return l.get(i++);
			}

		}

		if (l.size() > (i + 1)) {
			if (l.get(i + 1).getDatumMeritve().after(doDatum)) {
				MeritevVao tempp = l.get(i);
				i = l.size();

				return tempp;
			}
		}

		return l.get(i++);

	}

	@Override
	public java.util.Iterator<MeritevVao> iterator() {
		// TODO Auto-generated method stub
		return this;
	}
	



}
