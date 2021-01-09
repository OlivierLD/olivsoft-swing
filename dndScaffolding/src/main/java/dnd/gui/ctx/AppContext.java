package dnd.gui.ctx;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;

public class AppContext
		implements Serializable {
	private static AppContext instance = null;

	private transient ArrayList<ImageAppListener> applicationListeners = null;
	private transient VetoableChangeSupport vetoableChangeSupport = new VetoableChangeSupport(this);
	private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	private AppContext()
	{
		this.applicationListeners = new ArrayList(2);
	}

	public static synchronized AppContext getInstance() {
		if (instance == null)
			instance = new AppContext();
		return instance;
	}

	public void addVetoableChangeListener(VetoableChangeListener l) {
		this.vetoableChangeSupport.addVetoableChangeListener(l);
	}

	public void removeVetoableChangeListener(VetoableChangeListener l) {
		this.vetoableChangeSupport.removeVetoableChangeListener(l);
	}

	public void addPropertyChangeListener(PropertyChangeListener l) {
		this.propertyChangeSupport.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(PropertyChangeListener l) {
		this.propertyChangeSupport.removePropertyChangeListener(l);
	}

	public ArrayList<ImageAppListener> getListeners() {
		return this.applicationListeners;
	}

	public synchronized void addApplicationListener(ImageAppListener l) {
		if (!getListeners().contains(l)) {
			getListeners().add(l);
		}
	}

	public synchronized void removeApplicationListener(ImageAppListener l)
	{
		getListeners().remove(l);
	}

	public void fireDisplayImage(String in) {
		getListeners().stream().forEach(ial -> ial.displayImage(in));
	}


	public void fireSetStatusLabel(String s) {
		for (ImageAppListener ial : getListeners()) {
			ial.setStatusLabel(s);
		}
	}

	public void fireActivateProgressBar(boolean b) {
		for (ImageAppListener ial : getListeners()) {
			ial.activateProgressBar(b);
		}
	}

	public void fireSetProgressBar(int v, int max) {
		for (ImageAppListener ial : getListeners()) {
			ial.setProgressBar(v, max);
		}
	}
}
