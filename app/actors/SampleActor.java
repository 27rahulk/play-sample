package actors;

import javax.inject.Inject;
import javax.inject.Named;

import org.joda.time.Instant;
import org.slf4j.Logger;

import akka.actor.ActorRef;
import akka.actor.UntypedAbstractActor;

public class SampleActor extends UntypedAbstractActor{
	
	private final Logger logger = org.slf4j.LoggerFactory.getLogger("application");
	
	@Inject
	@Named("dummy-destitute-actor")
	private ActorRef dummyActor;

	@Override
	public void onReceive(Object message) throws Throwable {
		logger.info("Actor hash :"+this.hashCode());
		logger.info("Actor ThreadId :"+Thread.currentThread().getId());
		logger.info("path "+self().path());
		logger.info("dispatcher "+context().dispatcher().toString());
		sender().tell(Instant.now().toString(), self());
		dummyActor.tell(Instant.now().toString(), self());
	}

}
