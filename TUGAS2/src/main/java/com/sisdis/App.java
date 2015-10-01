package com.sisdis;

import com.sisdis.resources.ImageInformationClient;
import com.sisdis.resources.ImageInformationServer;
import io.dropwizard.Application;

import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App extends Application<AppConfiguration>
{
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) throws Exception {
        new App().run(args);
    }

    public void initialize(Bootstrap<AppConfiguration> bootstrap){
        bootstrap.addBundle(new AssetsBundle("/assets/img", "/img"));
    }

    @Override
    public void run(AppConfiguration configuration, Environment environment) throws Exception {
        LOGGER.info("Method App#run() called");

        // add resource to env
        environment.jersey().register(new ImageInformationServer());
        environment.jersey().register(new ImageInformationClient());
    }
}
