# ksbk

## Supported API types:
omdb
poromenos

## Sample usage:
java -jar movie-query-1.0.0.jar -Dapi=omdb -Dmovie=batman
java -jar movie-query-1.0.0.jar -Dapi=poromenos -Dmovie=mario

I decided to develop this simple app with TDD approach but I also didn't use any mocking framework.
That is the reason I could follow TDD only in the beginning and develop retrievers in a regular way.


## Assumptions:
I found two free (also with no registrations) APIs that let me get the TV productions with GET API.
OMDB (in the way I used it) is an API to search movies.
Poromenos (in the way I used it) is an API to search TV Shows
I assumed that there might be more APIs in the future so I decided to use Abstract Factory patter to retrieve proper
retriever.

The most generic type that is returned by my ProductionRetrievers is (TV) Production, 
right now this can be a Movie or (TV Show) only but it is prepared for new types of Productions (i.e. TV Series). 

I used Unirest to perform HTTP (GET) requests to 3rd parties APIs.
I used jackson to parse responses from APIs.

I placed APIs return types inside the same package as corresponding retrievers with the package private access 
so they won't be exposed anywhere else.