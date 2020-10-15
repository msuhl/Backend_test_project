package dk.andro.isten.scrape

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.exception.ApolloException

class GraphQlController {

    //Looks good:
    // https://www.apollographql.com/docs/android/essentials/get-started-kotlin/
    // https://stackoverflow.com/questions/59776117/how-to-use-apollo-android-from-kotlin-but-without-android
    init {
        // First, create an `ApolloClient`
        // Replace the serverUrl with your GraphQL endpoint
        val apolloClient = ApolloClient.builder()
            .serverUrl("https://fakeql.com/graphql/63c186327645e3a55dee03419de4d557")
            .build()

        val response = try {
            apolloClient.query(userOne()).toDeferred().await()
        } catch (e: ApolloException) {
            print("Query catched")

            // handle protocol errors
//            return@launch
        }
//
//        val launch = response.data.launch
//        if (launch == null || response.hasErrors()) {
//            // handle application errors
//            return@launch
//        }
    }
}