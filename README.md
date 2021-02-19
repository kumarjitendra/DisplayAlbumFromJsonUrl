# DisplayAlbumFromJsonUrl
Display list of album from url : https://static.leboncoin.fr/img/shared/technical-test.json



Issues ongoing : 
I am using retrofit 2.6.4 but result is null array from  response body .

steps done : 
 
	BASE_URL = "https://static.leboncoin.fr/" 
	in repositoryRetriever 
	
	 @GET(value : "/img/shared/technical-test.json/?q=title") inside service interface 

my code working absolutely fine with 

BASE_URL = "https://api.github.com/"

@GET("/search/repositories?q=title") inside service interface 
