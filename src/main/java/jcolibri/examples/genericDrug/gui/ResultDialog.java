/**
 * Travel Recommender example for the jCOLIBRI2 framework. 
 * @author Juan A. Recio-Garc�a.
 * GAIA - Group for Artificial Intelligence Applications
 * http://gaia.fdi.ucm.es
 * 25/07/2006
 */
package jcolibri.examples.genericDrug.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import jcolibri.cbrcore.CBRCase;
import jcolibri.examples.Pizza.PizzaDescription;
import jcolibri.examples.Pizza.PizzaSolution;
import jcolibri.examples.Pizza.gui.*;
import jcolibri.examples.TravelRecommender.TravelDescription;
import jcolibri.examples.TravelRecommender.TravelRecommender;
import jcolibri.examples.TravelRecommender.TravelSolution;
import jcolibri.examples.genericDrug.GenericDescription;
import jcolibri.examples.genericDrug.GenericDrugSolution;
import jcolibri.method.retrieve.RetrievalResult;
import jcolibri.util.FileIO;

/**
 * Result dialog
 * @author Juan A. Recio-Garcia
 * @version 1.0
 */
public class ResultDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	JLabel image;
	
	JLabel name;
	JLabel  useweighOfExcipient;
    JLabel  TotalWeigh;
    JLabel  disgrationtime;
	//JLabel size;
	//JLabel  prices;
	//JLabel region;
	//JLabel transportation;
	//JLabel  duration;
	//JLabel season;
	//JLabel accommodation;
	JLabel caseId;
	JLabel price;
	JLabel id;
	
	ArrayList<RetrievalResult> cases;
	int currentCase;
	
	public ResultDialog(JFrame main)
	{
		super(main,true);
		configureFrame();
	}
	
	private void configureFrame()
	{
		try
		{
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1)
		{
		}
		
		this.setTitle("Retrived cases");

		
		image = new JLabel();
		image.setIcon(new ImageIcon(FileIO.findFile("jcolibri/examples/TravelRecommender/gui/step3.png")));
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(image, BorderLayout.WEST);
		
		
		/**********************************************************/
		JPanel panel = new JPanel();
		//panel.setLayout(new GridLayout(8,2));
		panel.setLayout(new SpringLayout());
		
		JLabel label;

		panel.add(label = new JLabel("Description"));
		label.setFont(label.getFont().deriveFont(Font.BOLD));
		panel.add(label = new JLabel());

		
		panel.add(new JLabel("Name Of Substance"));
		panel.add(name = new JLabel());
		
		panel.add(new JLabel("useWeigh Of Excipient"));
		panel.add(this.useweighOfExcipient = new JLabel());

        panel.add(new JLabel("TotalWeigh Of Formulation"));
        panel.add(this.TotalWeigh = new JLabel());

        panel.add(new JLabel("disgrationtime"));
        panel.add(this.disgrationtime = new JLabel());
	//	panel.add(new JLabel("size"));
	//	panel.add(this.size = new JLabel());
		
		//panel.add(new JLabel("prices"));
		//panel.add(this.prices = new JLabel());
		
	//	panel.add(new JLabel("Region"));
	//	panel.add(this.region = new JLabel());
		
	//	panel.add(new JLabel("Transportation"));
	//	panel.add(this.transportation = new JLabel());
		
	//	panel.add(new JLabel("Duration"));
	//	panel.add(this.duration = new JLabel());
		
	///	panel.add(new JLabel("Season"));
		//panel.add(this.season = new JLabel());
		
	//	panel.add(new JLabel("Accommodation"));
	//	panel.add(this.accommodation = new JLabel());
		
		panel.add(label = new JLabel("Solution"));
		label.setFont(label.getFont().deriveFont(Font.BOLD));
		panel.add(label = new JLabel());

		
		//panel.add(new JLabel("ID"));
		//panel.add(price = new JLabel());
		
		panel.add(new JLabel("id of production"));
		panel.add(id = new JLabel());
		
//		Lay out the panel.
		jcolibri.examples.Pizza.gui.Utils.makeCompactGrid(panel,
                5, 2, //rows, cols
                6, 6,        //initX, initY
                30, 10);       //xPad, yPad
		
		JPanel casesPanel = new JPanel();
		casesPanel.setLayout(new BorderLayout());
		casesPanel.add(panel, BorderLayout.CENTER);
		
		JPanel casesIterPanel = new JPanel();
		casesIterPanel.setLayout(new FlowLayout());
		JButton prev = new JButton("<<");
		casesIterPanel.add(prev);
		casesIterPanel.add(caseId = new JLabel("Case id"));
		JButton follow = new JButton(">>");
		casesIterPanel.add(follow);
		
		prev.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				currentCase = (currentCase+cases.size()-1) % cases.size();
				showCase();
			}
		});
		
		follow.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				currentCase = (currentCase+1) % cases.size();
				showCase();
			}
		});
		
		casesPanel.add(casesIterPanel, BorderLayout.NORTH);
		
		
		JPanel panelAux = new JPanel();
		panelAux.setLayout(new BorderLayout());
		panelAux.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		panelAux.add(casesPanel,BorderLayout.NORTH);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new BorderLayout());
		
		JButton ok = new JButton("Next >>");
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
		buttons.add(ok,BorderLayout.CENTER);
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					TravelRecommender.getInstance().postCycle();
				} catch (Exception ex) {
					org.apache.commons.logging.LogFactory.getLog(TravelRecommender.class).error(ex);
				}
				System.exit(-1);
			}
		});
		buttons.add(exit,BorderLayout.WEST);
		
		panelAux.add(buttons, BorderLayout.SOUTH);
		this.getContentPane().add(panelAux, BorderLayout.CENTER);
		
		/**********************************************************/
		
		
		this.pack();
		this.setSize(600, this.getHeight());
		this.setResizable(false);
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - this.getWidth()) / 2,
			(screenSize.height - this.getHeight()) / 2, 
			getWidth(),
			getHeight());
	}
	
	void next()
	{
		this.setVisible(false);
	}
	
	
	public void showCases(Collection<RetrievalResult> eval, Collection<CBRCase> selected)
	{
		cases = new ArrayList<RetrievalResult>();
		for(RetrievalResult rr: eval)
			if(selected.contains(rr.get_case()))
				cases.add(rr);
		currentCase = 0;
		showCase();
	}
	
	void showCase()
	{
		RetrievalResult rr = cases.get(currentCase);
		double sim = rr.getEval();
		
		CBRCase _case = rr.get_case();
		this.caseId.setText(_case.getID().toString()+" -> "+sim+" ("+(currentCase+1)+"/"+cases.size()+")");
		
		GenericDescription desc = (GenericDescription) _case.getDescription();
		///this.accommodation.setText(desc.getAccommodation().toString());
		//this.duration.setText(desc.getDuration().toString());
		this.name.setText(desc.getName());
		//this.useweighOfExcipient.setText(desc.getWeighOfTablet());
        //this.TotalWeigh.setText(desc.getTablet().toString());
        this.disgrationtime.setText(desc.getDisgrationtime().toString());
	///	this.size.setText(desc.getSize().);
		///this.prices.setText(desc.getPrice().toString());
	//	this.numberOfPersons.setText(desc.getNumberOfPersons());
	///	this.region.setText(desc.getRegion().toString());
		///this.season.setText(desc.getSeason().toString());
	///	this.transportation.setText(desc.getTransportation());
		
		GenericDrugSolution sol = (GenericDrugSolution) _case.getSolution();
		//this.price.setText(sol.getPrice().toString());
		this.id.setText(sol.getProduction().getId());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ResultDialog qf = new ResultDialog(null);
		qf.setVisible(true);
		System.out.println("Bye");
	}

	

}
