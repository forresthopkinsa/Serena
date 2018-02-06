import com.google.gson.Gson
import com.typesafe.config.ConfigFactory
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.*


fun main(args: Array<String>) {
    Main().request()
}


class Main {

    val config = ConfigFactory.defaultApplication()
    val dyn = config.getString("dyn")
    val dtsg = config.getString("dtsg")
    val jazoest = config.getString("jazoest")

    fun request() {

        val query = """
            {"o0":{"doc_id":"1508526735892416","query_params":{"id":"100000746827681","message_limit":200,"load_messages":1,"load_read_receipts":true,"before":null}}}
            """.trimIndent()

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
                .addHeader("Origin", "https://www.facebook.com")
                .addHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.119 Safari/537.36")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Accept", "*/*")
                .addHeader("Referer", "https://www.facebook.com/messages/t/serena.kronschnabel")
                .addHeader("Accept-Encoding", "deflate")
                .addHeader("Accept-Language", "en-US,en;q=0.9")
                .addHeader("Cookie", "datr=PtBwWiWbl-8hAmRLalktnDgm; sb=5ihxWrxTbz6GmS1P_Ckd7H97; c_user=100005901819196; xs=14%3ArvCyyB7QJg3VRg%3A2%3A1517365478%3A1961%3A2315; wd=502x625; act=1517856858180%2F47; presence=EDvF3EtimeF1517856868EuserFA21B05901819196A2EstateFDutF1517856868136CEchFDp_5f1B05901819196F557CC")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Postman-Token", "f569a365-85ea-4a83-d7ce-f8523eb3c0a9")
                .build()

        val response = client.newCall(request).execute()

        println(response.message())

        val json = response.body()?.string()?.dropLast(79)

        println(json)

        val obj = Gson().fromJson(json, Root::class.java)

        val messages = obj.o0.data.messageThread.messages.nodes

        println(messages.last().message.text.takeUnless { it.isEmpty() } ?: "empty")

        messages.forEach { println(it.messageSender.id + " : " + Date(it.timestampPrecise.toLong()) + " : " + it.message.text) }


    }

}