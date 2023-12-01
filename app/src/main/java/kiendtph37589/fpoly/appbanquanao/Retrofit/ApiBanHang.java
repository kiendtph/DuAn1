package kiendtph37589.fpoly.appbanquanao.Retrofit;

import io.reactivex.rxjava3.core.Observable;
import kiendtph37589.fpoly.appbanquanao.model.LoaiSpModel;
import kiendtph37589.fpoly.appbanquanao.model.SanPhamMoimodel;
import retrofit2.http.GET;

public interface ApiBanHang {
    @GET("getloaisp.php")
    Observable<LoaiSpModel> getLoaiSp();

    @GET("getspmoi.php")
    Observable<SanPhamMoimodel> getSpMoi();
}
