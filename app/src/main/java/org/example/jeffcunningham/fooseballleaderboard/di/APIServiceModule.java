package org.example.jeffcunningham.fooseballleaderboard.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.example.jeffcunningham.fooseballleaderboard.repository.api.APIConfiguration;
import org.example.jeffcunningham.fooseballleaderboard.repository.api.RankingsAPI;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class APIServiceModule {

  @Provides
  static Retrofit provideRetrofit(OkHttpClient httpClient, Gson gson) {

    return new Retrofit.Builder()
        .baseUrl(APIConfiguration.API_HOST) // {@see ConfiSelectorInterceptor}
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(httpClient).build();
  }

  @Provides
  static RankingsAPI provideRankingsAPI(Retrofit retrofit) {
    return retrofit.create(RankingsAPI.class);
  }

  @Provides
  static Gson provideGson() {
    final GsonBuilder gsonBuilder = new GsonBuilder();
    return gsonBuilder.create();
  }

  @Provides
  OkHttpClient provideHttpClient() {
    final int TIMEOUT_CONNECT = 1000;
    final int TIMEOUT_READ = 1000;
    final ConnectionPool CONNECTION_POOL = new ConnectionPool();
    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    // set your desired log level
    logging.setLevel(HttpLoggingInterceptor.Level.BODY);

    OkHttpClient client = new OkHttpClient.Builder()
        .connectTimeout(TIMEOUT_CONNECT, TimeUnit.MILLISECONDS)
        .readTimeout(TIMEOUT_READ, TimeUnit.MILLISECONDS)
        .connectionPool(CONNECTION_POOL)
        .addInterceptor(logging)
        .build();
    return client;
  }

}
