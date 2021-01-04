package olivsoftdesktop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.Map;

import java.util.Set;

import olivsoftdesktop.param.CategoryPanel;
import olivsoftdesktop.param.ParamData;
import olivsoftdesktop.param.ParamPanel;

public class PreferencesCLI
{
  public PreferencesCLI()
  {
    super();
  }

  private static final BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

  public static String userInput(String prompt)
  {
    String retString = "";
    System.err.print(prompt);
    try
    {
      retString = stdin.readLine();
    }
    catch(Exception e)
    {
      System.out.println(e);
      String s;
      try
      {
        s = userInput("<Oooch/>");
      }
      catch(Exception exception) 
      {
        exception.printStackTrace();
      }
    }
    return retString;
  }

  private static class OldNew
  {
    private String oldValue = "", newValue = "";
    public OldNew(String o, String n)
    {
      this.oldValue = o;
      this.newValue = n;
    }
    
    public String getOld() { return this.oldValue; }
    public String getNew() { return this.newValue; }
    
    public void setNew(String n)
    {
      this.newValue = n;
    }
  }
  
  public static void main(String... args)
  {
    Map<Integer, OldNew> changes = new HashMap<>();
    Object[] prefsByCat = ParamPanel.getPrefsByCategory();
    ParamPanel.setUserValues();
    String ui = "";
    boolean changed = false;
    System.out.println("Set the preferences from the command line.");
    System.out.println("Choose a Category:");
    boolean quit = false;
    while (!quit)
    {
      for (int i=0; i<CategoryPanel.CATEGORIES.length; i++)
      {
        System.out.println(Integer.toString(i+1) + " for " + CategoryPanel.CATEGORIES[i]);
      }
      System.out.println("Q to Quit. (or return)");
      ui = userInput("You choose: ");
      if ("Q".equalsIgnoreCase(ui) || ui.trim().length() == 0)
        quit = true;
      else
      {
        int opt = -1;
        try
        {
          opt = Integer.parseInt(ui);
          if (opt < 1 || opt > CategoryPanel.CATEGORIES.length)
          {
            throw new Exception("A number between 1 and " + Integer.toString(CategoryPanel.CATEGORIES.length) + ", please.");
          }
          int[] thisCat = (int[])prefsByCat[opt - 1];
          boolean up = false;
          while (!up)
          {
            for (int i=0; i< thisCat.length; i++)
            {
              int prefIdx = thisCat[i];
              System.out.println(Integer.toString(i+1) + " " + ParamData.getLabels()[prefIdx] + " [" + (ParamPanel.getData()[prefIdx][ParamPanel.PRM_VALUE]).toString() + "]");
            }
            System.out.println("Q Back up to Categories. (or return)");
            int pref = -1;
            ui = userInput("You choose: ");
            if ("Q".equalsIgnoreCase(ui) || ui.trim().length() == 0)
              up = true;
            else
            {
              try
              {
                pref = Integer.parseInt(ui);
                if (pref < 1 || pref > thisCat.length)
                {
                  throw new Exception("A number between 1 and " + Integer.toString(thisCat.length) + ", please.");
                }
                int preferenceIndex = thisCat[pref - 1];
                String prefHelp = ParamData.getHelpText()[preferenceIndex];
                System.out.println("Description:");
                System.out.println(prefHelp);                
                Object currentValue = (ParamPanel.getData()[preferenceIndex][ParamPanel.PRM_VALUE]);
                System.out.println("This preference's type is a " + currentValue.getClass().getName());
                System.out.println("Current is [" + currentValue + "]");
                ui = userInput("New Value: ");
                System.out.println("Change [" + currentValue + "] to [" + ui + "]");
                String confirm = userInput("Confirm y|n > ");
                if ("Y".equalsIgnoreCase(confirm))
                {
                  Object newObj = null;
                  // Replace value
                  if (currentValue instanceof Boolean)
                  {
                    try
                    {
                      newObj = Boolean.valueOf(ui);
                      // Keep track of the changes for recap
                      OldNew on = changes.get(preferenceIndex);
                      if (on == null)
                        on = new OldNew(currentValue.toString(), ui);
                      else
                        on.setNew(ui);                        
                      changes.put(preferenceIndex, on);
                      ParamPanel.getData()[preferenceIndex][ParamPanel.PRM_VALUE] = newObj;
                      changed = true;
                    }
                    catch (Exception ex)
                    {
                      ex.printStackTrace();
                    }
                  }
                  else if (currentValue instanceof String)
                  {
                    try
                    {
                      newObj = ui;
                      // Keep track of the changes for recap
                      OldNew on = changes.get(preferenceIndex);
                      if (on == null)
                        on = new OldNew(currentValue.toString(), ui);
                      else
                        on.setNew(ui);                        
                      changes.put(preferenceIndex, on);
                      ParamPanel.getData()[preferenceIndex][ParamPanel.PRM_VALUE] = newObj;
                      changed = true;
                    }
                    catch (Exception ex)
                    {
                      ex.printStackTrace();
                    }
                  }
                  else if (currentValue instanceof Integer)
                  {
                    try
                    {
                      newObj = new Integer(ui);
                      // Keep track of the changes for recap
                      OldNew on = changes.get(preferenceIndex);
                      if (on == null)
                        on = new OldNew(currentValue.toString(), ui);
                      else
                        on.setNew(ui);                        
                      changes.put(preferenceIndex, on);
                      ParamPanel.getData()[preferenceIndex][ParamPanel.PRM_VALUE] = newObj;
                      changed = true;
                    }
                    catch (Exception ex)
                    {
                      ex.printStackTrace();
                    }
                  }
                  else if (currentValue instanceof Float)
                  {
                    try
                    {
                      newObj = new Float(ui);
                      // Keep track of the changes for recap
                      OldNew on = changes.get(preferenceIndex);
                      if (on == null)
                        on = new OldNew(currentValue.toString(), ui);
                      else
                        on.setNew(ui);                        
                      changes.put(preferenceIndex, on);
                      ParamPanel.getData()[preferenceIndex][ParamPanel.PRM_VALUE] = newObj;
                      changed = true;
                    }
                    catch (Exception ex)
                    {
                      ex.printStackTrace();
                    }
                  }
                  else if (currentValue instanceof Double)
                  {
                    try
                    {
                      newObj = new Double(ui);
                      // Keep track of the changes for recap
                      OldNew on = changes.get(preferenceIndex);
                      if (on == null)
                        on = new OldNew(currentValue.toString(), ui);
                      else
                        on.setNew(ui);                        
                      changes.put(preferenceIndex, on);
                      ParamPanel.getData()[preferenceIndex][ParamPanel.PRM_VALUE] = newObj;
                      changed = true;
                    }
                    catch (Exception ex)
                    {
                      ex.printStackTrace();
                    }
                  }
                  else if (currentValue instanceof ParamPanel.ImageFile)
                  {
                    try
                    {
                      newObj = new ParamPanel.ImageFile(ui);
                      // Keep track of the changes for recap
                      OldNew on = changes.get(preferenceIndex);
                      if (on == null)
                        on = new OldNew(currentValue.toString(), ui);
                      else
                        on.setNew(ui);                        
                      changes.put(preferenceIndex, on);
                      ParamPanel.getData()[preferenceIndex][ParamPanel.PRM_VALUE] = newObj;
                      changed = true;
                    }
                    catch (Exception ex)
                    {
                      ex.printStackTrace();
                    }
                  }
                  else if (currentValue instanceof ParamPanel.XMLFile)
                  {
                    try
                    {
                      newObj = new ParamPanel.XMLFile(ui);
                      // Keep track of the changes for recap
                      OldNew on = changes.get(preferenceIndex);
                      if (on == null)
                        on = new OldNew(currentValue.toString(), ui);
                      else
                        on.setNew(ui);                        
                      changes.put(preferenceIndex, on);
                      ParamPanel.getData()[preferenceIndex][ParamPanel.PRM_VALUE] = newObj;
                      changed = true;
                    }
                    catch (Exception ex)
                    {
                      ex.printStackTrace();
                    }
                  }
                  else if (currentValue instanceof ParamPanel.DataDirectory)
                  {
                    try
                    {
                      String desc = ((ParamPanel.DataDirectory)currentValue).getDesc();
                      newObj = new ParamPanel.DataDirectory(desc, ui);
                      // Keep track of the changes for recap
                      OldNew on = changes.get(preferenceIndex);
                      if (on == null)
                        on = new OldNew(currentValue.toString(), ui);
                      else
                        on.setNew(ui);                        
                      changes.put(preferenceIndex, on);
                      ParamPanel.getData()[preferenceIndex][ParamPanel.PRM_VALUE] = newObj;
                      changed = true;
                    }
                    catch (Exception ex)
                    {
                      ex.printStackTrace();
                    }
                  }
                  else
                  {
                    System.out.println(">>> This type is not managed from the Command line Interface.");
                  }
                }
              }
              catch (Exception ex)
              {
                ex.printStackTrace();
                ui = userInput("...hit [Return] to try again");
              }
            }
          }
        }
        catch (Exception  nfe)
        {
          nfe.printStackTrace();
          ui = userInput("...hit [Return] to try again");
        }
      }
    }
    if (changed)
    {
      System.out.println("Summary of changes:");
      Set<Integer> keys = changes.keySet();
      for (int k : keys)
        System.out.println("- Changed [" + ParamData.getLabels()[k] + "] from [" + changes.get(k).getOld() + "] to [" + changes.get(k).getNew() + "]");

      ui = userInput("Save your changes y|n ? > ");
      if ("Y".equalsIgnoreCase(ui))
      {
        ParamPanel.saveParameters();
      }
    }
    System.out.println("Bye.");
  }
}
