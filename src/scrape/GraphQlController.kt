package dk.andro.isten.scrape

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.exception.ApolloException

class GraphQlController {

    //Looks good: https://stackoverflow.com/questions/59776117/how-to-use-apollo-android-from-kotlin-but-without-android
    init {
        // First, create an `ApolloClient`
        // Replace the serverUrl with your GraphQL endpoint
        val apolloClient = ApolloClient.builder()
            .serverUrl("https://fakeql.com/graphql/40b73b7150f7ddf63ec7b317b172f68e")
            .build()

// in your coroutine scope, call `ApolloClient.query(...).toDeferred().await()`

        val response = try {
            apolloClient.query(UserOne()).toDeferred().await()
        } catch (e: ApolloException) {
            // handle protocol errors
            return@launch
        }

        val launch = response.data.launch
        if (launch == null || response.hasErrors()) {
            // handle application errors
            return@launch
        }
    }
}