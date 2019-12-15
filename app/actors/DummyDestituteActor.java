package actors;

import org.slf4j.Logger;

import akka.actor.UntypedAbstractActor;

public class DummyDestituteActor extends UntypedAbstractActor{
	
	private final Logger logger = org.slf4j.LoggerFactory.getLogger("application");

	@Override
	public void onReceive(Object message) throws Throwable {
		logger.info("Actor ThreadId :"+Thread.currentThread().getId());
		logger.info("path "+self().path());
		logger.info("dispatcher "+context().dispatcher().toString());
		logger.info("This actor is just for demo invocation : "+message);
	}

}
