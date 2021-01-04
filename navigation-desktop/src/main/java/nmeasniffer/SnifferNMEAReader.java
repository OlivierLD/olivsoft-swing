package nmeasniffer;

import nmea.server.NMEAEventManager;
import nmea.server.datareader.CustomNMEAClient;

public class SnifferNMEAReader
        implements NMEAEventManager {
    private boolean verbose = false;
    private String serial = null;
    private int br = 0;

    private int nbLinesRead = 0;

    private CustomNMEAClient nmeaClient = null;
    private Sniffer.SnifferThread parent = null;

    private SnifferNMEAReader instance = this;

    public SnifferNMEAReader(Sniffer.SnifferThread parent, boolean v, String serial, int br) {
        this.parent = parent;
        this.verbose = v;
        this.serial = serial;
        this.br = br;
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        try {
            if (((this.serial != null ? 1 : 0) & (this.serial.trim().length() > 0 ? 1 : 0)) != 0) {
                read(this.serial, this.br);
            } else {
                System.out.println("Nothing to read, exiting.");
                System.exit(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void read() {
        read(this.serial, this.br);
    }

    private void read(final String port, int br) {
        if (this.verbose) System.out.println("Reading " + port + ":" + br + "...");
        this.nmeaClient = new CustomNMEAClient(this, port, br, 5000L) {
            public void manageNMEAError(Throwable t) {
                if (!t.getMessage().contains("took too long")) {
                    SnifferNMEAReader.this.parent.cutTheCrap(SnifferNMEAReader.this.instance, port, t);
                } else if (SnifferNMEAReader.this.verbose)
                    System.out.println("Timeout expired (5000 ms) in thread " + SnifferNMEAReader.this.parent.getName());
            }
        };
    }

    public boolean verbose() {
        return this.verbose;
    }

    public void manageDataEvent(String payload) {
        if (this.verbose) {
            String displ = payload;
            while (((displ.endsWith("\r")) || (displ.endsWith("\n"))) && (displ.length() >= 0))
                displ = displ.substring(0, displ.length() - 1);
            System.out.println(getClass().getName() + ": Read from NMEA :[" + displ + "]");
        }

        try {
            this.nbLinesRead += 1;

            this.parent.dataEvent(this, this.serial, this.br, payload);
            if (this.nbLinesRead > 10) {
                if (this.verbose)
                    System.out.println("Read more than 10 lines from " + this.serial + ". Stopping.");
                stopReader();
            }
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
    }

    public void stopReader() throws Exception {
        if (this.verbose)
            System.out.println(getClass().getName() + ": Stop Reading requested.");
        this.nmeaClient.stopReading();
        synchronized (this) {
            notify();
        }
    }
}
