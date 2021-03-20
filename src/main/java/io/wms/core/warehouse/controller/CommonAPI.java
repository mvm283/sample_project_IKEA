package io.wms.core.warehouse.controller;

import io.wms.core.warehouse.dataload.ImportJson;
import io.wms.core.warehouse.model.Article;
import io.wms.core.warehouse.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/")
public class CommonAPI {

    ImportJson<Product> productLoader;

    ImportJson<Article> articleLoader;


    @Autowired
    @Qualifier("products")
    private void setProductLoader(ImportJson loader){
        System.out.println("Products autowired");
        this.productLoader = loader;
    }

    @Autowired
    @Qualifier("articles")
    private void setArticleLoader(ImportJson loader){
        System.out.println("articles autowired");
        this.articleLoader = loader;
    }

    @RequestMapping(path = "status",method = RequestMethod.GET)
    public String importStatus(){
       String products =  this.productLoader.importData().toString();
        String articles =  this.articleLoader.importData().toString();

        return products + " --------- " + articles;
    }
}
