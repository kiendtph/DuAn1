package kiendtph37589.fpoly.appbanquanao.Retrofit;


import com.google.gson.stream.JsonReader;

import java.io.Reader;
import java.io.StringReader;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import kiendtph37589.fpoly.appbanquanao.model.LoaiSp;
import kiendtph37589.fpoly.appbanquanao.model.LoaiSpModel;
import kiendtph37589.fpoly.appbanquanao.utils.Utils;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit instance;

    public static Retrofit getInstance(String baseUrl){
        if (instance == null){

            instance = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
        }
        return instance;
    }
}
