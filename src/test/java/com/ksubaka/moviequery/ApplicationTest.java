package com.ksubaka.moviequery;

import com.ksubaka.moviequery.exceptions.ProductionRetrieverException;
import org.apache.commons.cli.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;


public class ApplicationTest {

    @Test(expected = ParseException.class)
    public void testCommandLineParserCriteria_missingArguments() throws Exception {
        Application.parseCommandLine(new String[0]);
    }

    @Test(expected = ProductionRetrieverException.class)
    public void testCommandLineParserCriteria_unsupportedApi() throws Exception {
        String[] testArgs =
                { "-Dapi=imdb", "-Dmovie=Indiana Jones"};
        Properties properties = Application.parseCommandLine(testArgs);
        Application.retrieveMovies(properties);
    }

    @Test
    public void testCommandLineParserCriteria() throws Exception {
        String[] testArgs =
                { "-Dapi=imdb", "-Dmovie=Indiana Jones"};
        Properties properties = Application.parseCommandLine(testArgs);
        Assert.assertEquals(properties.get("api"), "imdb");
    }
}
