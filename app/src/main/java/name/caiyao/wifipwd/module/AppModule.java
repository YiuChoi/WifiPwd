package name.caiyao.wifipwd.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import name.caiyao.wifipwd.util.WifiUtil;

/**
 * Created by xiaomu on 2017/4/1.
 */
@Module
public class AppModule {
  private Context context;

  public AppModule(Context context) {
    this.context = context;
  }

  @Singleton
  @Provides
  public WifiUtil getWifiUtil() {
    return new WifiUtil(context);
  }
}
