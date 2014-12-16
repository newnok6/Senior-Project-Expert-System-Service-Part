/**
 * Travel Recommender example for the jCOLIBRI2 framework. 
 * @author Juan A. Recio-Garc�a.
 * GAIA - Group for Artificial Intelligence Applications
 * http://gaia.fdi.ucm.es
 * 25/07/2006
 */
package jcolibri.examples.Pizza.gui;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import jcolibri.cbrcore.CBRQuery;
import jcolibri.examples.Pizza.PizzaDescription;

import jcolibri.examples.TravelRecommender.TravelDescription;
import jcolibri.examples.TravelRecommender.TravelRecommender;
import jcolibri.examples.TravelRecommender.TravelDescription.AccommodationTypes;
import jcolibri.examples.TravelRecommender.TravelDescription.Seasons;
import jcolibri.util.FileIO;

/**
 * Query dialgo
 * @author Juan A. Recio-Garcia
 * @version 1.0
 */
public class QueryDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	JLabel image;
	
	JComboBox typeOfpizza;
	SpinnerNumberModel  numberOfPersons;
	//JComboBox size;
	//SpinnerNumberModel  price;
	public QueryDialog(JFrame parent)
	{
		super(parent,true);
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
		
		this.setTitle("Configure Query");

		
		image = new JLabel();
		image.setIcon(new ImageIcon(FileIO.findFile("main/java/jcolibri/examples/TravelRecommender/gui/step1.png")));
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(image, BorderLayout.WEST);
		
		
		/**********************************************************/
		JPanel panel = new JPanel();
		//panel.setLayout(new GridLayout(8,2));
		panel.setLayout(new SpringLayout());
		
		JLabel label;
		panel.add(label = new JLabel("Attribute"));
		label.setFont(label.getFont().deriveFont(Font.BOLD));
		panel.add(label = new JLabel("Value"));
		label.setFont(label.getFont().deriveFont(Font.BOLD));
		
		panel.add(new JLabel("Type Of Pizza"));
		String[] holidayTypes = {"ThinandCripy","DeepPanBase"};
		panel.add(typeOfpizza = new JComboBox(holidayTypes));
		
		panel.add(new JLabel("Number of persons"));
		numberOfPersons = new SpinnerNumberModel(2,1,12,1); 
		panel.add(new JSpinner(numberOfPersons));
		
		//panel.add(new JLabel("size of pizza"));
		//String[] sizes = {"large","medium","small"};
		//panel.add(size = new JComboBox(sizes));
		
	//	panel.add(new JLabel("price of pizza"));
		//price = new SpinnerNumberModel(2,1,12,1); 
		//panel.add(new JSpinner(price));
		
//		Lay out the panel.
		Utils.makeCompactGrid(panel,
		                3, 2, //rows, cols
		                6, 6,        //initX, initY
		                12, 12);       //xPad, yPad
		
		JPanel panelAux = new JPanel();
		panelAux.setLayout(new BorderLayout());
		panelAux.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		panelAux.add(panel,BorderLayout.NORTH);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new BorderLayout());
		
		JButton ok = new JButton("Set Query >>");
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setQuery();
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
	
	void setQuery()
	{
		this.setVisible(false);
	}
	
	public CBRQuery getQuery()
	{
		PizzaDescription desc = new PizzaDescription();
	//	desc.setAccommodation(AccommodationTypes.valueOf((String)this.accommodation.getSelectedItem()));
		//desc.setDuration(this.duration.getNumber().intValue());
		desc.setTypeOfpizza((String)this.typeOfpizza.getSelectedItem());
		desc.setNumberOfPersons(this.numberOfPersons.getNumber().intValue());
	//	desc.setSize(Size.valueOf((String)this.size.getSelectedItem()));
	//	desc.setPrice(this.price.getNumber().intValue());
		//desc.setRegion(this.region.getSelectedInstance());
		//desc.setSeason(Seasons.valueOf((String)this.season.getSelectedItem()));
		//desc.setTransportation((String)this.transportation.getSelectedItem());
		
		CBRQuery query = new CBRQuery();
		query.setDescription(desc);
		
		return query;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QueryDialog qf = new QueryDialog(null);
		qf.setVisible(true);
		System.out.println("Bye");
	}

	

}
