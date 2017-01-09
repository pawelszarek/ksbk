package com.ksubaka.moviequery;

import com.ksubaka.moviequery.exceptions.MovieRetrieverException;
import com.ksubaka.moviequery.model.ApiType;
import com.ksubaka.moviequery.model.Production;
import com.ksubaka.moviequery.retrievers.MovieRetriever;
import com.ksubaka.moviequery.retrievers.MovieRetrieverFactory;
import org.apache.commons.cli.*;

import java.util.List;
import java.util.Properties;

public class Application {

    public static void main(String[] args) {
        try {
            Properties properties = parseCommandLine(args);
            List<Production> productions = retrieveMovies(properties);
            productions.forEach(production -> System.out.println(production.print()));
        } catch (ParseException | MovieRetrieverException e) {
            System.err.println(e.getMessage());
        }
    }

    static List<Production> retrieveMovies(Properties properties) throws MovieRetrieverException {
        ApiType apiType = ApiType.getEnum((String) properties.get("api"));
        String movieName = (String) properties.get("movieName");
        MovieRetrieverFactory movieRetrieverFactory = new MovieRetrieverFactory();
        MovieRetriever movieRetriever = movieRetrieverFactory.getProperRetriever(apiType);
        return movieRetriever.retrieve(movieName);
    }


    static Properties parseCommandLine(String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        Option option = Option.builder("D").numberOfArgs(2).valueSeparator().required().build();
        options.addOption(option);
        CommandLine commandLine = parser.parse(options, args);

        return commandLine.getOptionProperties("D");
    }
}
