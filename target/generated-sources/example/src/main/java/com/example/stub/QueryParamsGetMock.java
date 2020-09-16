package com.example.stub;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.*;
import com.github.tomakehurst.wiremock.matching.*;
import com.github.tomakehurst.wiremock.common.Json;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import com.github.tomakehurst.wiremock.stubbing.StubImport;
import com.example.model.*;
import com.example.support.*;

import java.util.*;
import java.util.function.Consumer;

import static com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder.jsonResponse;
import static com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder.like;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class QueryParamsGetMock {

    
    public static class GetObjectByParams {

        private static final String PATH = "/get/v1/object";

        private UrlPattern urlPattern;
        
        private final Map<String, StringValuePattern> queryParams = new LinkedHashMap<>();

        
        
        
        
        public GetObjectByParams inQueryStingParam(String stingParam) {
            queryParams.put("stingParam", equalTo(stingParam.toString()));
            return this;
        }
        
        
        
        
        
        
        public GetObjectByParams inQueryIntegerParam(Integer integerParam) {
            queryParams.put("integerParam", equalTo(integerParam.toString()));
            return this;
        }
        
        
        
        
        
        
        public GetObjectByParams inQueryLongParam(Long longParam) {
            queryParams.put("longParam", equalTo(longParam.toString()));
            return this;
        }
        
        
        
        
        
        
        public GetObjectByParams inQueryBoolParam(Boolean boolParam) {
            queryParams.put("boolParam", equalTo(boolParam.toString()));
            return this;
        }
        
        
        
        
        
        
        public GetObjectByParams inQueryFloatParam(Float floatParam) {
            queryParams.put("floatParam", equalTo(floatParam.toString()));
            return this;
        }
        
        
        
        
        
        
        public GetObjectByParams inQueryDoubleParam(Double doubleParam) {
            queryParams.put("doubleParam", equalTo(doubleParam.toString()));
            return this;
        }
        
        
        
        
        
        
        public GetObjectByParams inQueryEnumParam(String enumParam) {
            queryParams.put("enumParam", equalTo(enumParam.toString()));
            return this;
        }
        
        
        

        

        
        public Code200Builder code200(){
            return new Code200Builder();
        }

        public class Code200Builder{
            
            
            
            private String response;
            
            
            
            

            
            
            
            
            public Code200Builder inResp(String response) {
                this.response = response;
                return this;
            }
            
            
            

            public StubMapping buildStub() {
                MappingBuilder builder = get(urlPattern)
                    .withQueryParams(queryParams)
                
                .willReturn(aResponse().withBody(response).withHeader("content-type", "*/*").withStatus(200));
                
                
                
                
                return builder.build();
            }

            
            



            public void mock() {
                
                
                WireMock.importStubs(StubImport.stubImport().stub(buildStub()).build());
                
            }
        }
        

        
    }
    

}
