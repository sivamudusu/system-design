package org.example.designpatterns.factory;

public class UiFactoryFactory {
    public static UIfactory getUIfactory(SupportedPlatforms supportedPlatforms){
        switch (supportedPlatforms){
            case WINDOWS : return new WindowsFactory();
            case ANDROID: return new AndroidFactory();
            case IOS: return new IOSFactory();
        }
        return null;
    }
}
