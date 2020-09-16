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

public class QueryParamsGetResponseMock {

    
    public static class GetWithResponse {

        private static final String PATH = "/get/v1/response";

        private UrlPattern urlPattern;
        
        private final Map<String, StringValuePattern> queryParams = new LinkedHashMap<>();

        
        
        
        
        public GetWithResponse inQueryStingParam(String stingParam) {
            queryParams.put("stingParam", equalTo(stingParam.toString()));
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
        
        public Code201Builder code201(){
            return new Code201Builder();
        }

        public class Code201Builder{
            
            
            private List<String> response = new ArrayList<>();
            
            
            
            

            
            
            
            public StringBuilder<Code201Builder> inResp() {
                return new StringBuilder<Code201Builder>(this, response);
            }
            
            
            
            

            public StubMapping buildStub() {
                MappingBuilder builder = get(urlPattern)
                    .withQueryParams(queryParams)
                
                
                .willReturn(like(jsonResponse(response)).withStatus(201));
                
                
                
                return builder.build();
            }

            
            



            public void mock() {
                
                
                WireMock.importStubs(StubImport.stubImport().stub(buildStub()).build());
                
            }
        }
        
        public Code202Builder code202(){
            return new Code202Builder();
        }

        public class Code202Builder{
            
            
            
            
            private CompositeBodyParam response = new CompositeBodyParam();
            
            
            

            
            
            
            
            
            
            
            
            public Code202Builder inRespPrimitive(String primitive){
                
                response.setPrimitive(primitive);
                return this;
            }
            
            
            
            
            public Code202Builder inRespComposite(CompositeFieldParam composite){
                
                response.setComposite(composite);
                return this;
            }
            
            
            
            public StringBuilder<Code202Builder> inRespPrimitiveList(){
                List<String> collection = new ArrayList<String>();
                response.setPrimitiveList(collection);
                return new StringBuilder<Code202Builder>(this, collection);
            }
            
            
            
            
            public CompositeFieldParamBuilder<Code202Builder> inRespCompositeList(){
                List<CompositeFieldParam> collection = new ArrayList<CompositeFieldParam>();
                response.setCompositeList(collection);
                return new CompositeFieldParamBuilder<Code202Builder>(this, collection);
            }
            
            
            
            
            

            public StubMapping buildStub() {
                MappingBuilder builder = get(urlPattern)
                    .withQueryParams(queryParams)
                
                .willReturn(like(jsonResponse(response)).withStatus(202));
                
                return builder.build();
            }

            
            



            public void mock() {
                
                
                WireMock.importStubs(StubImport.stubImport().stub(buildStub()).build());
                
            }
        }
        
        public Code203Builder code203(){
            return new Code203Builder();
        }

        public class Code203Builder{
            
            
            private List<CompositeBodyParam> response = new ArrayList<>();
            
            
            
            

            
            
            
            
            public CompositeBodyParamBuilder<Code203Builder> inResp(){
                return new CompositeBodyParamBuilder<Code203Builder>(this, response);
            }
            
            
            

            public StubMapping buildStub() {
                MappingBuilder builder = get(urlPattern)
                    .withQueryParams(queryParams)
                
                .willReturn(like(jsonResponse(response)).withStatus(203));
                
                return builder.build();
            }

            
            



            public void mock() {
                
                
                WireMock.importStubs(StubImport.stubImport().stub(buildStub()).build());
                
            }
        }
        

        
        
        public static class StringBuilder<E> extends PrimitiveCollectionBuilder<String> {

            private E enter;

            public StringBuilder(E enter, Collection<String> collection, Consumer<String> consumer) {
                super(collection, consumer);
                this.enter = enter;
            }

            public StringBuilder(E enter, Collection<String> collection) {
                super(collection, null);
                this.enter = enter;
            }

            public StringBuilder<E> addNew(String value) {
                this.collection.add(value);
                return this;
            }

            public E exit() {
                if(consumer!=null){
                    super.collection.forEach(super.consumer);
                }
                return this.enter;
            }
        }
        
        
        
        
        
        public static class CompositeFieldParamBuilder<E> extends CollectionBuilder<CompositeFieldParam> {

            private E enter;

            public CompositeFieldParamBuilder(E enter, Collection<CompositeFieldParam> collection, Consumer<CompositeFieldParam> consumer) {
                super(collection, consumer);
                this.enter = enter;
            }

            public CompositeFieldParamBuilder(E enter, Collection<CompositeFieldParam> collection) {
                super(collection, null);
                this.enter = enter;
            }

            public CompositeFieldParamBuilder<E> addNew() {
                super.value = new CompositeFieldParam();
                super.collection.add(super.value);
                return this;
            }

            
            
            
            public CompositeFieldParamBuilder<E>inBodyInnerField(String innerField){
                
                super.value.setInnerField(innerField);
                return this;
            }
            
            
            public E exit() {
                if(consumer!=null){
                    super.collection.forEach(super.consumer);
                }
                return this.enter;
            }
        }
        
        
        
        
        public static class CompositeBodyParamBuilder<E> extends CollectionBuilder<CompositeBodyParam> {

            private E enter;

            public CompositeBodyParamBuilder(E enter, Collection<CompositeBodyParam> collection, Consumer<CompositeBodyParam> consumer) {
                super(collection, consumer);
                this.enter = enter;
            }

            public CompositeBodyParamBuilder(E enter, Collection<CompositeBodyParam> collection) {
                super(collection, null);
                this.enter = enter;
            }

            public CompositeBodyParamBuilder<E> addNew() {
                super.value = new CompositeBodyParam();
                super.collection.add(super.value);
                return this;
            }

            
            
            
            public CompositeBodyParamBuilder<E>inRespPrimitive(String primitive){
                
                super.value.setPrimitive(primitive);
                return this;
            }
            
            
            
            
            public CompositeBodyParamBuilder<E>inRespComposite(CompositeFieldParam composite){
                
                super.value.setComposite(composite);
                return this;
            }
            
            
            
            public StringBuilder<CompositeBodyParamBuilder<E>> inRespPrimitiveList(){
                List<String> collection = new ArrayList<String>();
                this.value.setPrimitiveList(collection);
                return new StringBuilder<CompositeBodyParamBuilder<E>>(this, collection);
            }
            
            
            
            
            public CompositeFieldParamBuilder<CompositeBodyParamBuilder<E>> inRespCompositeList(){
                List<CompositeFieldParam> collection = new ArrayList<CompositeFieldParam>();
                this.value.setCompositeList(collection);
                return new CompositeFieldParamBuilder<CompositeBodyParamBuilder<E>>(this, collection);
            }
            
            
            
            public E exit() {
                if(consumer!=null){
                    super.collection.forEach(super.consumer);
                }
                return this.enter;
            }
        }
        
        
    }
    

}
