package com.example.a15017206.p03psclassjournal;

/**
 * Created by 15017206 on 04/05/2017.
 */

public class Modules {
    private String moduleCode;
    private String moduleName;

    public  Modules (String moduleCode, String moduleName){
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
    }

    public String getModuleCode(){
        return moduleCode;
    }
    public String getModuleName(){
        return moduleName;
    }

}
