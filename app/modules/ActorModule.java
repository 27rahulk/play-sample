package modules;

import com.google.inject.AbstractModule;

import actors.DummyDestituteActor;
import actors.SampleActor;
import akka.routing.FromConfig;
import play.libs.akka.AkkaGuiceSupport;

public class ActorModule extends AbstractModule implements AkkaGuiceSupport {
	
	@Override
	protected void configure() {
//		bindActor(SampleActor.class, "sample-actor");
//		bindActor(DummyDestituteActor.class, "dummy-destitute-actor",props->{
//			return props.withDispatcher("akka.actor.custom-dispatcher");
//		});
		FromConfig config = new FromConfig();
		bindActor(SampleActor.class, "sample-actor",props->{
			return props.withRouter(config);
		});
		bindActor(DummyDestituteActor.class, "dummy-destitute-actor",props->{
			return props.withRouter(config);
		});

	}
}
