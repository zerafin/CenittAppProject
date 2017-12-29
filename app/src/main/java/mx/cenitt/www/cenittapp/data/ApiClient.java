package mx.cenitt.www.cenittapp.data;

import android.support.annotation.NonNull;

import com.google.gson.Gson;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Luis Roberto Zerafin on 17/12/2017.
 */
public abstract class ApiClient<ApiService> {
    public ApiService mApiService;

    public ApiClient(){
        final OkHttpClient okHttpClient =new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(getUrl())
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        mApiService=retrofit.create(getApiService());
    }

    @NonNull
    protected Gson getGson(){
        return new Gson();
    }

    protected abstract Class<ApiService> getApiService();
    protected abstract  String getUrl();


}
