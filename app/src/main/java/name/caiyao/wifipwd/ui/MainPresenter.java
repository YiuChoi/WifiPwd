package name.caiyao.wifipwd.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.os.Build;

import com.orhanobut.logger.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import name.caiyao.wifipwd.data.WifiRequest;
import name.caiyao.wifipwd.data.WifiResult;
import name.caiyao.wifipwd.util.AesUtils;
import name.caiyao.wifipwd.util.WifiUtil;

import static name.caiyao.wifipwd.base.Common.AES_IV;
import static name.caiyao.wifipwd.base.Common.AES_KEY;
import static name.caiyao.wifipwd.base.Common.DT;

/**
 * Created by xiaomu on 2017/4/6.
 */

public class MainPresenter implements MainContract.Presenter {

  private Context context;

  private final MainContract.View view;

  @Inject
  MainPresenter(Context context, MainContract.View view) {
    this.view = view;
    this.context = context;
  }

  @Inject
  void setupListeners() {
    view.setPresenter(this);
  }

  @Override
  public void start() {

  }

  @Override
  public void getWifilist() {
    WifiUtil wifiUtil = new WifiUtil(context);
    wifiUtil.startScan();
    view.showWifilist(wifiUtil.getWifiList());
  }

  @TargetApi(Build.VERSION_CODES.KITKAT)
  @Override
  public void getPwd(ScanResult scanResult) {
    String s = null;
    try {
      s = URLEncoder.encode(DT.replace("SSID", scanResult.SSID).replace("MAC", scanResult.BSSID), "UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    String appId = "A0008";
    String ed = AesUtils.encryptString(AES_KEY, s, AES_IV);
    String et = "a";
    String pid = "00300109";
    String st = "m";
    String ss = appId + ed + et + pid + st;
    String salt = "*Lm%qiOHVEedH3%A^uFFsZvFH9T8QAZe";
    String sign = AesUtils.getMD5(ss + salt);
    WifiRequest.getWifiApi()
        .getPwd(appId, pid, ed, st, et, sign)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<WifiResult>() {
          @Override
          public void onSubscribe(Disposable d) {

          }

          @Override
          public void onNext(WifiResult value) {
            if (!value.getAps().isEmpty()) {
              String pdd = AesUtils.decryptString(AES_KEY, value.getAps().get(0).getPwd(), AES_IV);
              if (pdd != null) {
                Logger.i(pdd);
                int length = Integer.parseInt(pdd.substring(0, 3));
                String pwd = pdd.substring(3, 3 + length);
                Logger.i(pwd);
                view.showPwd(pwd);
              }
            }
          }

          @Override
          public void onError(Throwable e) {

          }

          @Override
          public void onComplete() {

          }
        });
  }
}
