package nightsky;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class NightPanelHolder
  extends JPanel
{
  @SuppressWarnings("compatibility:6984553488292253145")
  public final static long serialVersionUID = 1L;

  private JSlider latitudeSlider = new JSlider();
  private JSlider lhaAriesSlider = new JSlider();
  private JPanel sliderHolder = new JPanel();
  
  private NightSkyPanel nsp = null;
  private GridBagLayout gridBagLayout = new GridBagLayout();
  
  private JPanel hemispherePanel = new JPanel();
  private JRadioButton northRadioButton = new JRadioButton("North");
  private JRadioButton southRadioButton = new JRadioButton("South");
  private ButtonGroup group = new ButtonGroup();
  
  private JCheckBox starsCheckBox              = new JCheckBox("Stars");
  private JCheckBox starNamesCheckBox          = new JCheckBox("Star Names");
  private JCheckBox constallationsCheckBox     = new JCheckBox("Constellations");
  private JCheckBox constallationNamesCheckBox = new JCheckBox("Const. Names");
  private JCheckBox visibleSkyCheckBox         = new JCheckBox("Visible Sky");
  private JCheckBox celestSphereCheckBox       = new JCheckBox("Full Sphere");
  private JCheckBox wanderingBodiesCheckBox    = new JCheckBox("Wandering Bodies");
  
  public final static int WITH_CONSTELLATIONS    = 0;
  public final static int WITHOUT_CONSTELLATIONS = 1;
  
  private int constOption = WITHOUT_CONSTELLATIONS;
  
  public NightPanelHolder()
  {
    this(NightSkyPanel.STAR_FINDER_OPTION, null, WITHOUT_CONSTELLATIONS);
  }
  
  public NightPanelHolder(int displayOption, NightSkyPanel nightSkyPanel, int constellationOption)
  {
    if (displayOption != NightSkyPanel.STAR_FINDER_OPTION && displayOption != NightSkyPanel.SKY_CHART_OPTION)
      throw new RuntimeException("Unknown Display Option");
    if (constellationOption != WITH_CONSTELLATIONS && constellationOption != WITHOUT_CONSTELLATIONS)
      throw new RuntimeException("Unknown Constellation Option");
    
    this.constOption = constellationOption;
    if (nightSkyPanel == null)
      nsp = new NightSkyPanel(displayOption);
    else
      nsp = nightSkyPanel;
    if (displayOption == NightSkyPanel.SKY_CHART_OPTION)
    {
      Thread go = new Thread()
        {
          public void run()
          {
            nsp.setShowFullGrid(false);
          }
        };
      go.start();
    }
    try
    {
      jbInit();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  private void jbInit()
    throws Exception
  {
    this.setLayout(new BorderLayout());
    this.setSize(new Dimension(650, 650));
    
    latitudeSlider.setMinimum(2);
    latitudeSlider.setMaximum(88);
    latitudeSlider.setValue(35);
    latitudeSlider.setSize(new Dimension(600, 16));
    latitudeSlider.setPreferredSize(new Dimension(600, 16));
    latitudeSlider.setMinimumSize(new Dimension(400, 16));
    latitudeSlider.addChangeListener(new ChangeListener()
      {
        public void stateChanged(ChangeEvent evt)
        {
          JSlider slider = (JSlider) evt.getSource();
          {
            // Get new value
            final int value = slider.getValue();
            Thread go = new Thread() 
              {
                public void run()
                {
                  nsp.setLatitude((double) value);    
                }
              };
            go.start();
          }
        }
      });
    lhaAriesSlider.setMinimum(-180);
    lhaAriesSlider.setMaximum(180);
    lhaAriesSlider.setValue(0);
    lhaAriesSlider.addChangeListener(new ChangeListener()
      {
        public void stateChanged(ChangeEvent evt)
        {
          JSlider slider = (JSlider) evt.getSource();
          {
            // Get new value
            final int value = slider.getValue();
//          System.out.println("LHA Aries:" + value);
            Thread go = new Thread() 
              {
                public void run()
                {
                  nsp.setLHAAries((double) value);
                }
              };
            go.start();
          }
        }
      });
    sliderHolder.setLayout(gridBagLayout);
    sliderHolder.add(latitudeSlider, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
          new Insets(0, 0, 0, 0), 0, 0));
    sliderHolder.add(lhaAriesSlider, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
          new Insets(0, 0, 0, 0), 0, 0));
      
    northRadioButton.setSelected(true);
    group.add(northRadioButton);
    group.add(southRadioButton);
    hemispherePanel.add(northRadioButton);
    hemispherePanel.add(southRadioButton);
    northRadioButton.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
          if (northRadioButton.isSelected())
          {
            Thread go = new Thread()
              {
                public void run()
                {
                  nsp.setHemisphere(NightSkyPanel.NORTH_HEMISPHERE);
                }
              };
            go.start();
          }
        }
      });
    southRadioButton.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
          if (southRadioButton.isSelected())
          {
            Thread go = new Thread()
              {
                public void run()
                {
                  nsp.setHemisphere(NightSkyPanel.SOUTH_HEMISPHERE);                
                }
              };
            go.start();
          }
        }
      });
    
    starsCheckBox.setSelected(true);
    starNamesCheckBox.setSelected(true);
    constallationsCheckBox.setSelected(constOption == WITH_CONSTELLATIONS);
    constallationNamesCheckBox.setSelected(constOption == WITH_CONSTELLATIONS);
    visibleSkyCheckBox.setSelected(true);
    celestSphereCheckBox.setSelected(true);
    wanderingBodiesCheckBox.setSelected(false);
      
    starsCheckBox.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          Thread go = new Thread()
            {
              public void run()
              {
                nsp.setWithStars(starsCheckBox.isSelected());
              }
            };
          go.start();
        }
      });
    starNamesCheckBox.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          Thread go = new Thread()
            {
              public void run()
              {
                nsp.setWithStarNames(starNamesCheckBox.isSelected());
              }
            };
          go.start();
        }
      });
    constallationsCheckBox.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          Thread go = new Thread()
            {
              public void run()
              {
                nsp.setWithConstellations(constallationsCheckBox.isSelected());
              }
            };
          go.start();
        }
      });
    constallationNamesCheckBox.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          Thread go = new Thread()
            {
              public void run()
              {
                nsp.setWithConstellationNames(constallationNamesCheckBox.isSelected());
              }
            };
          go.start();
        }
      });
    visibleSkyCheckBox.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          Thread go = new Thread()
            {
              public void run()
              {
                nsp.setWithVisibleSky(visibleSkyCheckBox.isSelected());
              }
            };
          go.start();
        }
      });
    celestSphereCheckBox.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          Thread go = new Thread()
            {
              public void run()
              {
                nsp.setWithCelestSphere(celestSphereCheckBox.isSelected());
              }
            };
          go.start();
        }
      });
    wanderingBodiesCheckBox.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          Thread go = new Thread()
            {
              public void run()
              {
                nsp.setWithWanderingBodies(wanderingBodiesCheckBox.isSelected());
              }
            };
          go.start();
        }
      });
      
    hemispherePanel.add(starsCheckBox);
    hemispherePanel.add(starNamesCheckBox);
    if (constOption == WITH_CONSTELLATIONS)
    {
      hemispherePanel.add(constallationsCheckBox);
      hemispherePanel.add(constallationNamesCheckBox);
    }
    hemispherePanel.add(visibleSkyCheckBox);
    hemispherePanel.add(celestSphereCheckBox);    
    hemispherePanel.add(wanderingBodiesCheckBox);
    
    this.add(hemispherePanel, BorderLayout.NORTH);
    this.add(nsp, BorderLayout.CENTER);
    this.add(sliderHolder, BorderLayout.SOUTH);
  }
  
  public void setObserverLatitude(double d)
  {
    nsp.setObserverLatitude(d);
    latitudeSlider.setValue((int)Math.abs(d));
    northRadioButton.setSelected(d >= 0);
    southRadioButton.setSelected(d < 0);
  }
  
  public void setLHAAries(double d)
  {
    nsp.setLHAAries(d);
    lhaAriesSlider.setValue((int)d);
  }
}
