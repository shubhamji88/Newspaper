package shubhamji.com.newspaper.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val BASE_URL="https://newsapi.org/"
private val ApiKey="a0fb30d2985a45a9a69cd5fc6d03e264"
private val moshi=Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit=Retrofit.Builder()
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
interface NewsApiService{
    @GET("v2/top-headlines?country=us&apiKey=a0fb30d2985a45a9a69cd5fc6d03e264")
    fun getNews():Deferred<List<NewsList>>
}
object MarsApi{
    val retrifitService: NewsApiService by lazy {
        retrofit.create(NewsApiService::class.java)
    }
}