package name.caiyao.wifipwd;

import javax.inject.Singleton;

import dagger.Component;
import name.caiyao.wifipwd.module.AppModule;
import name.caiyao.wifipwd.util.WifiUtil;

/**
 * Created by xiaomu on 2017/4/1.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

  WifiUtil wifiUtil();
}
