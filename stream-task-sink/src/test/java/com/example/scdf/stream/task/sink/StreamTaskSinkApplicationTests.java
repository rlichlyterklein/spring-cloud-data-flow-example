package com.example.scdf.stream.task.sink;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.deployer.spi.core.AppDeploymentRequest;
import org.springframework.cloud.deployer.spi.task.TaskLauncher;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamTaskSinkApplicationTests {

	@Autowired
	ApplicationContext context;

	@Autowired
	private Sink sink;


	@Test
	public void contextLoads() {
	}

	/**
	 * Test is based on this on in the spring-cloud-task-samples
	 * @see <a href="https://github.com/spring-cloud/spring-cloud-task/blob/master/spring-cloud-task-samples/tasksink/src/test/java/io/spring/TaskSinkApplicationTests.java#L57">TaskSinkApplicationTest.java</a>
	 */
	@Test
	public void testLaunch() {
		assertNotNull(this.sink.input());
		TaskLauncher testTaskLauncher = context.getBean(TaskLauncher.class);

		Map<String, String> properties = new HashMap();
		properties.put("server.port", "0");

		TaskLaunchRequest request = new TaskLaunchRequest(
				"maven://com.example.scdf:dataflow-task:1.0.1.RELEASE",
				null,
				properties,
				null,
				"Test-TaskLaunchRequest");
		GenericMessage<TaskLaunchRequest> message = new GenericMessage<>(request);
		this.sink.input().send(message);

		ArgumentCaptor<AppDeploymentRequest> deploymentRequest = ArgumentCaptor.forClass(AppDeploymentRequest.class);

		verify(testTaskLauncher).launch(deploymentRequest.capture());

		AppDeploymentRequest actualRequest = deploymentRequest.getValue();

		assertTrue(actualRequest.getCommandlineArguments().isEmpty());
		assertEquals("0", actualRequest.getDefinition().getProperties().get("server.port"));
		assertTrue(actualRequest.getResource().toString()
					.contains("dataflow-task"));

	}
}
