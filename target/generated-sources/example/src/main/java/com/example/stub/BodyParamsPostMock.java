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

public class BodyParamsPostMock {

    
    public static class PostObjectPrimitive {

        private static final String PATH = "/post/v1/primitive";

        private UrlPattern urlPattern;
        
        
        
        private String body;
        
        
        
        private final Map<String, StringValuePattern> queryParams = new LinkedHashMap<>();

        

        
        
        
        
        public PostObjectPrimitive inBody(String body) {
            this.body = body;
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
                MappingBuilder builder = post(urlPattern)
                    .withQueryParams(queryParams)
                
                .willReturn(aResponse().withBody(response).withHeader("content-type", "*/*").withStatus(200));
                
                
                
                
                
                
                builder.withRequestBody(equalTo(body.toString()));
                
                
                
                
                
                return builder.build();
            }

            
            



            public void mock() {
                
                
                WireMock.importStubs(StubImport.stubImport().stub(buildStub()).build());
                
            }
        }
        

        
    }
    
    public static class PostObjectComposite {

        private static final String PATH = "/post/v1/composite";

        private UrlPattern urlPattern;
        
        
        
        
        private CompositeBodyParam body = new CompositeBodyParam();
        
        
        private final Map<String, StringValuePattern> queryParams = new LinkedHashMap<>();

        

        
        
        
        
        
        
        
        
        public PostObjectComposite inBodyPrimitive(String primitive){
            
            body.setPrimitive(primitive);
            return this;
        }
        
        
        
        
        public PostObjectComposite inBodyComposite(CompositeFieldParam composite){
            
            body.setComposite(composite);
            return this;
        }
        
        
        
        public StringBuilder<PostObjectComposite> inBodyPrimitiveList(){
            List<String> collection = new ArrayList<String>();
            body.setPrimitiveList(collection);
            return new StringBuilder<PostObjectComposite>(this, collection);
        }
        
        
        
        
        public CompositeFieldParamBuilder<PostObjectComposite> inBodyCompositeList(){
            List<CompositeFieldParam> collection = new ArrayList<CompositeFieldParam>();
            body.setCompositeList(collection);
            return new CompositeFieldParamBuilder<PostObjectComposite>(this, collection);
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
                MappingBuilder builder = post(urlPattern)
                    .withQueryParams(queryParams)
                
                .willReturn(aResponse().withBody(response).withHeader("content-type", "*/*").withStatus(200));
                
                
                
                
                
                
                builder.withRequestBody(equalToJson(Json.write(body), true, true));
                
                
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
        
        
    }
    
    public static class PostObjectPrimitiveList {

        private static final String PATH = "/post/v1/primitiveList";

        private UrlPattern urlPattern;
        
        
        private List<String> body = new ArrayList<String>();
        
        
        
        private final Map<String, StringValuePattern> queryParams = new LinkedHashMap<>();

        

        
        
        
        public StringBuilder<PostObjectPrimitiveList> inBody() {
            return new StringBuilder<PostObjectPrimitiveList>(this, body);
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
                MappingBuilder builder = post(urlPattern)
                    .withQueryParams(queryParams)
                
                .willReturn(aResponse().withBody(response).withHeader("content-type", "*/*").withStatus(200));
                
                
                
                
                
                
                
                builder.withRequestBody(equalToJson(Json.write(body), true, true));
                
                
                
                
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
        
        
    }
    
    public static class PostObjectCompositeList {

        private static final String PATH = "/post/v1/compositeList";

        private UrlPattern urlPattern;
        
        
        private List<CompositeBodyParam> body = new ArrayList<CompositeBodyParam>();
        
        
        
        private final Map<String, StringValuePattern> queryParams = new LinkedHashMap<>();

        

        
        
        
        
        public CompositeBodyParamBuilder<PostObjectCompositeList> inBody(){
            return new CompositeBodyParamBuilder<PostObjectCompositeList>(this, body);
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
                MappingBuilder builder = post(urlPattern)
                    .withQueryParams(queryParams)
                
                .willReturn(aResponse().withBody(response).withHeader("content-type", "*/*").withStatus(200));
                
                
                
                
                
                
                builder.withRequestBody(equalToJson(Json.write(body), true, true));
                
                
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

            
            
            
            public CompositeBodyParamBuilder<E>inBodyPrimitive(String primitive){
                
                super.value.setPrimitive(primitive);
                return this;
            }
            
            
            
            
            public CompositeBodyParamBuilder<E>inBodyComposite(CompositeFieldParam composite){
                
                super.value.setComposite(composite);
                return this;
            }
            
            
            
            public StringBuilder<CompositeBodyParamBuilder<E>> inBodyPrimitiveList(){
                List<String> collection = new ArrayList<String>();
                this.value.setPrimitiveList(collection);
                return new StringBuilder<CompositeBodyParamBuilder<E>>(this, collection);
            }
            
            
            
            
            public CompositeFieldParamBuilder<CompositeBodyParamBuilder<E>> inBodyCompositeList(){
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
