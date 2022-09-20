package com.ofss.route;

import com.ofss.Processors.*;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {

		from("file:C:/camel/input?noop=true")
				.process(new FileCopyProcessor())
				.to("file:C:/camel/output");

		from("file:C:/camel/inputFolder")
			.process(new FileToSrcQueueProcessor())
			.to("jms:queue:myQueue");
		
		from("jms:queue:myQueue")
				.process(new SrcToTargetProcessor())
			.to("jms:queue:TargetQueue")
					.process(new TargetToTargetAckProcessor())
					.to("jms:queue:TargetQueueAck");

	}
}