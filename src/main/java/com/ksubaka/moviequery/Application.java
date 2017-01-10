package com.ksubaka.moviequery;

import com.ksubaka.moviequery.exceptions.ProductionRetrieverException;
import com.ksubaka.moviequery.model.ApiType;
import com.ksubaka.moviequery.model.Production;
import com.ksubaka.moviequery.retrievers.ProductionRetriever;
import com.ksubaka.moviequery.retrievers.ProductionRetrieverFactory;
import org.apache.commons.cli.*;

import java.util.List;
import java.util.Properties;

public class Application {

    public static void main(String[] args) {
        try {
            Properties properties = parseCommandLine(args);
            List<Production> productions = retrieveMovies(properties);
            productions.forEach(production -> System.out.println(production.print()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static List<Production> retrieveMovies(Properties properties) throws ProductionRetrieverException {
        ApiType apiType = ApiType.getEnum((String) properties.get("api"));
        String movieName = (String) properties.get("movie");
        ProductionRetrieverFactory productionRetrieverFactory = new ProductionRetrieverFactory();
        ProductionRetriever productionRetriever = productionRetrieverFactory.getProperRetriever(apiType);
        return productionRetriever.retrieve(movieName);
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
