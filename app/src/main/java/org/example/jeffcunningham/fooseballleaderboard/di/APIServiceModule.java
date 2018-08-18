package org.example.jeffcunningham.fooseballleaderboard.di;

import dagger.Module;

@Module
public class APIServiceModule {
//    @Provides
//    OkHttpClient provideHttpClient(){
//        final int TIMEOUT_CONNECT = 1000;
//        final int TIMEOUT_READ = 1000;
//        final ConnectionPool CONNECTION_POOL = new ConnectionPool();
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        // set your desired log level
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient client = new OkHttpClient.Builder()
//                .connectTimeout(TIMEOUT_CONNECT, TimeUnit.MILLISECONDS)
//                .readTimeout(TIMEOUT_READ,TimeUnit.MILLISECONDS)
//                .connectionPool(CONNECTION_POOL)
//                .addInterceptor(logging)
//                .build();
//        return client;
//    }
//
//    @Provides
//    @ApplicationScope
//    static Retrofit provideRetrofit(OkHttpClient httpClient, Gson gson) {
//
//        return new Retrofit.Builder()
//                .baseUrl(APIConfiguration.API_HOST) // {@see ConfiSelectorInterceptor}
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .client(httpClient).build();
//    }
//
//    @Provides
//    @ApplicationScope
//    static RankingsAPI provideRankingsAPI(Retrofit retrofit){
//        return retrofit.create(RankingsAPI.class);
//    };
}
