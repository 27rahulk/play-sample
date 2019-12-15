package controllers.sample;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;

import akka.actor.ActorRef;
import akka.pattern.Patterns;
import akka.util.Timeout;
import play.mvc.Controller;
import play.mvc.Http.Request;
import play.mvc.Result;
import scala.compat.java8.FutureConverters;

public class SampleController extends Controller{
	
	private final Logger logger = org.slf4j.LoggerFactory.getLogger("application");
	
	@Inject
	@Named("sample-actor")
	private ActorRef sampleActor;
	
	public CompletionStage<Result> timeSample(Request request) {
		logger.info("Controller hash :"+this.hashCode());
		logger.info("Controller ThreadId :"+Thread.currentThread().getId());
		return FutureConverters.toJava(Patterns.ask(sampleActor, request, new Timeout(5, TimeUnit.SECONDS))).thenApply(response->ok((String)response));
	}
}
