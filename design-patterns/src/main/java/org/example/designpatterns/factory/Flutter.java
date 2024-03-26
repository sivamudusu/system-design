package org.example.designpatterns.factory;

public class Flutter {
    SupportedPlatforms supportedPlatforms;

    public Flutter(SupportedPlatforms supportedPlatforms) {
        this.supportedPlatforms = supportedPlatforms;
    }

    public UIfactory createUiFactory(){
        return UiFactoryFactory.getUIfactory(supportedPlatforms);
    }
}
