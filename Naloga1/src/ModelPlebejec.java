import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;

import zrno.MojeZrnoLocal;

@ManagedBean(name = "pleb")
@SessionScoped
public class ModelPlebejec {

	private boolean preklopPrikaza = true;

	private ClanBaza baza = ClanBaza.getInstance();

	private List<Clan> clani = baza.getVsiClani();

	private int izbranClan;

	private List<Meritev> izbraneMeritve;

	double teza;
	double obseg;
	double visina;
	Calendar c = new GregorianCalendar();
	Calendar odDatuma = new GregorianCalendar();
	Calendar doDatuma = new GregorianCalendar();

	public void dodajMeritev() {

		baza.vpisiMeritev(c, teza, obseg, visina, izbranClan);

	}

	public void izberiPleba() {

		// uporabi nekaj boljsega

	}

	public void izberiObdobje() {
		init();

	}

	public List<Meritev> getUporabaIteratorja() {
		List<Meritev> temp = new ArrayList<>();

		if (izbranClan == 0)
			return null;

		Iterator iterator = new Iterator(baza.getSeznamMeritevPoVrsti(izbranClan), odDatuma, doDatuma);

//		while (iterator.hasNext()) {
//
//
//				temp.add(iterator.next());
//
//		}
			for (Meritev meritev : iterator) {
					temp.add(meritev);
}
		
		
		
		izbraneMeritve = temp;
		return temp;

	}

	public void preklopiPrikaz() {
		if (preklopPrikaza)
			preklopPrikaza = false;
		else
			preklopPrikaza = true;

		init();

	}

	//
	// GRAF
	//
	private LineChartModel lineModel = new LineChartModel();

	public void init() {
		// if (izbranClan==0) return;
		createLineModels();
	}

	private void createLineModels() {
		lineModel = initCategoryModel();
		// if(lineModel==null) return;
		lineModel.setTitle("Graf");
		lineModel.setLegendPosition("e");
		lineModel.setShowPointLabels(true);
		lineModel.getAxes().put(AxisType.X, new CategoryAxis("Cas"));

	}

	public LineChartModel getLineModel() {
		return lineModel;
	}
	
	
	@EJB
	MojeZrnoLocal mz;
	
	private LineChartModel initCategoryModel() {
		if (izbraneMeritve == null)
			return null;
		LineChartModel model = new LineChartModel();

		ChartSeries series1 = new ChartSeries();
		if (preklopPrikaza)
			series1.setLabel("Teza");
		else
			series1.setLabel("ITM");

		for (int i = 0; i < izbraneMeritve.size(); i++) {
			if (izbraneMeritve.get(i) == null)
				break;

			if (izbraneMeritve.get(i) == null)
				break;
			if (preklopPrikaza)
				series1.set(izbraneMeritve.get(i).getDatum(), izbraneMeritve.get(i).getTeza());
			else {
//				
//				double tempITM = izbraneMeritve.get(i).getTeza();
//				double q = izbraneMeritve.get(i).getTelesnaVisina()*izbraneMeritve.get(i).getTelesnaVisina();

				series1.set(izbraneMeritve.get(i).getDatum(), mz.izracunajITM(izbraneMeritve.get(i).getTeza(), izbraneMeritve.get(i).getTelesnaVisina()));
			}

		}

		// series1.set("1sa sf", 2);
		// series1.set("2", 1);
		// series1.set("3", 3);
		// series1.set("4", 6);
		// series1.set("5", 8);

		model.addSeries(series1);

		return model;
	}

	public List<Meritev> getSeznamMeritve() {
		if (izbranClan == 0)
			return null;
		List<Meritev> list = baza.getSeznamMeritev(izbranClan);

		return list;
	}

	public List<Clan> getClani() {
		clani = baza.getVsiClani();
		return clani;
	}

	public void setClani(List<Clan> clani) {
		this.clani = clani;
	}

	public int getIzbranClan() {
		return izbranClan;
	}

	public void setIzbranClan(int izbranClan) {
		this.izbranClan = izbranClan;
	}

	public double getTeza() {
		return teza;
	}

	public void setTeza(double teza) {
		this.teza = teza;
	}

	public double getObseg() {
		return obseg;
	}

	public void setObseg(double obseg) {
		this.obseg = obseg;
	}

	public double getVisina() {
		return visina;
	}

	public void setVisina(double visina) {
		this.visina = visina;
	}

	public Calendar getC() {
		return c;
	}

	public void setC(Calendar c) {
		this.c = c;
	}

	public Calendar getOdDatuma() {
		return odDatuma;
	}

	public void setOdDatuma(Calendar odDatuma) {
		this.odDatuma = odDatuma;
	}

	public Calendar getDoDatuma() {
		return doDatuma;
	}

	public void setDoDatuma(Calendar doDatuma) {
		this.doDatuma = doDatuma;
	}

	public List<Meritev> getIzbraneMeritve() {
		return izbraneMeritve;
	}

	public void setIzbraneMeritve(List<Meritev> izbraneMeritve) {
		this.izbraneMeritve = izbraneMeritve;
	}

	public void setLineModel(LineChartModel lineModel) {
		this.lineModel = lineModel;
	}

	public boolean isPreklopPrikaza() {
		return preklopPrikaza;
	}

	public void setPreklopPrikaza(boolean preklopPrikaza) {
		this.preklopPrikaza = preklopPrikaza;
	}

	// public Graf getGraf() {
	// return graf;
	// }
	//
	// public void setGraf(Graf graf) {
	// this.graf = graf;
	// }

}
