package com.dropwizard.app;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        HelloWorldApplication helloWorldApplication = new HelloWorldApplication();
        helloWorldApplication.run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {

    }

    public void run(AppConfiguration configuration, Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );

        final AppHealthCheck appHealthCheck = new AppHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", appHealthCheck);
        environment.jersey().register(resource);
    }
}
