import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

@ManagedBean(name="graf")
@SessionScoped
public class Graf implements Serializable {
	
	
	Calendar odDatuma = new GregorianCalendar();
	Calendar doDatuma = new GregorianCalendar();
	
	ModelPlebejec modelPlebejec;
	
//	public Graf(ModelPlebejec modelPlebejec) {
//		this.modelPlebejec=modelPlebejec;
//	}

//	private static final long serialVersionUID = 5702309359691639172L;
	
	private List<Meritev> podatki;
	
	private ClanBaza baza = ClanBaza.getInstance();

	private LineChartModel lineModel;

	@PostConstruct
	public void init() {
		createLineModels();
	}

	private void createLineModels() {
		lineModel = initLinearModel();
		//if(lineModel==null) return;
		lineModel.setTitle("Graf");
		lineModel.setLegendPosition("e");
//		 Axis yAxis = lineModel.getAxis(AxisType.Y);
//		 yAxis.setMin(0);
//		 yAxis.setMax(200);

	}

	public LineChartModel getLineModel() {
		return lineModel;
	}

	private LineChartModel initLinearModel() {
		LineChartModel model = new LineChartModel();

		LineChartSeries series1 = new LineChartSeries();
		series1.setLabel("Teza");
		//if(podatki==null) return null;
//		for (int i = 0; i < podatki.size(); i++) {
//			series1.set(podatki.get(i).getDatum(), podatki.get(i).getTeza());
//		}

        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);
 

		model.addSeries(series1);

		return model;
	}

	public void izberiObdobje(Calendar odDatuma, Calendar doDatuma, int clan) {
		podatki = new ArrayList<>();

		Iterator iterator = new Iterator(baza.getSeznamMeritevPoVrsti(clan), odDatuma, doDatuma);

		while (iterator.hasNext()) {

			

				podatki.add(iterator.next());

			

		}
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

}
