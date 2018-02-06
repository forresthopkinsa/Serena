import com.google.gson.GsonBuilder
import com.typesafe.config.ConfigFactory
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.*


fun main(args: Array<String>) {
    Main().request()
}


class Main {

    val gson = GsonBuilder().serializeNulls().create()
    val config = ConfigFactory.defaultApplication()
    val dyn = config.getString("dyn")
    val dtsg = config.getString("dtsg")
    val jazoest = config.getString("jazoest")
    val c_user = config.getString("c_user")
    val xs = config.getString("xs")

    fun request() {

        val requestRoot = RequestRoot(Request("1508526735892416", QueryParams("100000746827681", 200, 1, true, null)))
        val query = gson.toJson(requestRoot)

        val client = OkHttpClient()

        val form = FormBody.Builder()
                .add("__a", "1")
                .add("__be", "1")
                .add("__dyn", dyn)
                .add("__pc", "PHASED:DEFAULT")
                .add("__req", "cf")
                .add("__rev", "3559466")
                .add("__spin_b", "trunk")
                .add("__spin_r", "3559466")
                .add("__spin_t", "1515297453")
                .add("__user", "100005901819196")
                .add("batch_name", "MessengerGraphQLThreadFetcherRe")
                .add("fb_dtsg", dtsg)
                .add("jazoest", jazoest)
                .add("queries", query)
                .build()

        val request = Request.Builder()
                .url("https://www.facebook.com/api/graphqlbatch/")
                .post(form)
                .addHeader("Accept-Encoding", "deflate")
                .addHeader("Cookie", "c_user=$c_user; xs=$xs")
                .addHeader("Cache-Control", "no-cache")
                .build()

        val response = client.newCall(request).execute()

        println(response.message())

        val json = response.body()?.string()?.dropLast(79)

        println(json)

        val obj = gson.fromJson(json, ResponseRoot::class.java)

        val messages = obj.response.data.messageThread.messages.nodes

        println(messages.last().message.text.takeUnless { it.isEmpty() } ?: "empty")

        messages.forEach { println(it.messageSender.id + " : " + Date(it.timestampPrecise.toLong()) + " : " + it.message.text) }


    }

}