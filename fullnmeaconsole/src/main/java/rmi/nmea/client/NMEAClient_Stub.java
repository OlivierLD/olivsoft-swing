// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package rmi.nmea.client;

public final class NMEAClient_Stub
    extends java.rmi.server.RemoteStub
    implements rmi.nmea.client.Notifiable
{
    private static final java.rmi.server.Operation[] operations = {
	new java.rmi.server.Operation("java.lang.String getAddress()"),
	new java.rmi.server.Operation("void notify(nmea.server.ctx.NMEADataCache)")
    };
    
    private static final long interfaceHash = -7285216383323056028L;
    
    private static final long serialVersionUID = 2;
    
    private static boolean useNewInvoke;
    private static java.lang.reflect.Method $method_getAddress_0;
    private static java.lang.reflect.Method $method_notify_1;
    
    static {
	try {
	    java.rmi.server.RemoteRef.class.getMethod("invoke",
		new java.lang.Class[] {
		    java.rmi.Remote.class,
		    java.lang.reflect.Method.class,
		    java.lang.Object[].class,
		    long.class
		});
	    useNewInvoke = true;
	    $method_getAddress_0 = rmi.nmea.client.Notifiable.class.getMethod("getAddress", new java.lang.Class[] {});
	    $method_notify_1 = rmi.nmea.client.Notifiable.class.getMethod("notify", new java.lang.Class[] {nmea.server.ctx.NMEADataCache.class});
	} catch (java.lang.NoSuchMethodException e) {
	    useNewInvoke = false;
	}
    }
    
    // constructors
    public NMEAClient_Stub() {
	super();
    }
    public NMEAClient_Stub(java.rmi.server.RemoteRef ref) {
	super(ref);
    }
    
    // methods from remote interfaces
    
    // implementation of getAddress()
    public java.lang.String getAddress()
	throws java.rmi.RemoteException
    {
	try {
	    if (useNewInvoke) {
		Object $result = ref.invoke(this, $method_getAddress_0, null, 7650440960692401886L);
		return ((java.lang.String) $result);
	    } else {
		java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 0, interfaceHash);
		ref.invoke(call);
		java.lang.String $result;
		try {
		    java.io.ObjectInput in = call.getInputStream();
		    $result = (java.lang.String) in.readObject();
		} catch (java.io.IOException e) {
		    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
		} catch (java.lang.ClassNotFoundException e) {
		    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
		} finally {
		    ref.done(call);
		}
		return $result;
	    }
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of notify(NMEADataCache)
    public void notify(nmea.server.ctx.NMEADataCache $param_NMEADataCache_1)
	throws java.rmi.RemoteException
    {
	try {
	    if (useNewInvoke) {
		ref.invoke(this, $method_notify_1, new java.lang.Object[] {$param_NMEADataCache_1}, -4935293009707984834L);
	    } else {
		java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 1, interfaceHash);
		try {
		    java.io.ObjectOutput out = call.getOutputStream();
		    out.writeObject($param_NMEADataCache_1);
		} catch (java.io.IOException e) {
		    throw new java.rmi.MarshalException("error marshalling arguments", e);
		}
		ref.invoke(call);
		ref.done(call);
	    }
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
}
