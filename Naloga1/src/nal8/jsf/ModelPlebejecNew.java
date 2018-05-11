package nal8.jsf;
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

import nal8.ejb.ClanEjbVmesnik;
import nal8.ejb.MeritevEjbVmesnik;
import nal8.vao.ClanVao;
import nal8.vao.MeritevVao;
import nal9.FasadaVmesnik;
import zrno.MojeZrnoLocal;
import u.Iterator;

@ManagedBean(name = "plebNew")
@SessionScoped
public class ModelPlebejecNew {
	
	@EJB
	MeritevEjbVmesnik mv;
	
	@EJB
	ClanEjbVmesnik cv;
	
	@EJB
	FasadaVmesnik fasada;

	private boolean preklopPrikaza = true;
	private int izbranClan;
	private List<MeritevVao> izbraneMeritve;

	private MeritevVao meritev= new MeritevVao();
	
	Calendar odDatuma = new GregorianCalendar();
	Calendar doDatuma = new GregorianCalendar();

	public void dodajMeritev() {

		mv.vpisiMeritev(meritev, izbranClan);
		
		//fasada.posljiMail(izbranClan);
		
	}

	public void izberiPleba() {

		meritev=mv.dobiZadnjo(izbranClan);

	}

	public void izberiObdobje() {
		init();

	}

	public List<MeritevVao> getUporabaIteratorja() {
		List<MeritevVao> temp = new ArrayList<>();

		if (izbranClan == 0)
			return null;

		Iterator iterator = new Iterator(mv.getSeznamMeritevPoVrsti(izbranClan), odDatuma, doDatuma);

			for (MeritevVao meritev : iterator) {
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
				series1.set(izbraneMeritve.get(i).getDatum(), mz.izracunajITM(izbraneMeritve.get(i).getTeza(), izbraneMeritve.get(i).getTelesnaVisina()));
			}

		}



		model.addSeries(series1);

		return model;
	}

	public List<MeritevVao> getSeznamMeritve() {
		if (izbranClan == 0)
			return null;
		List<MeritevVao> list = mv.getSeznamMeritev(izbranClan);

		return list;
	}

	public List<ClanVao> getClani() {
		 
		return cv.vsiClani();
	}

	public int getIzbranClan() {
		return izbranClan;
	}

	public void setIzbranClan(int izbranClan) {
		this.izbranClan = izbranClan;
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

	public void setLineModel(LineChartModel lineModel) {
		this.lineModel = lineModel;
	}

	public boolean isPreklopPrikaza() {
		return preklopPrikaza;
	}

	public void setPreklopPrikaza(boolean preklopPrikaza) {
		this.preklopPrikaza = preklopPrikaza;
	}

	public List<MeritevVao> getIzbraneMeritve() {
		return izbraneMeritve;
	}

	public void setIzbraneMeritve(List<MeritevVao> izbraneMeritve) {
		this.izbraneMeritve = izbraneMeritve;
	}

	public MeritevVao getMeritev() {
		return meritev;
	}

	public void setMeritev(MeritevVao meritev) {
		this.meritev = meritev;
	}


}
