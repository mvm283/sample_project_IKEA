package io.wms.core.warehouse.dataload;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.wms.core.warehouse.common.Loggable;
import io.wms.core.warehouse.model.Element;
import io.wms.core.warehouse.model.Product;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.stream.Stream;

@Component("products")
public class ImportProducts implements ImportJson<Product>, Loggable {

    @Override
    public List<Product> importData() {
        List<Product> products= new ArrayList<>();

        try{
             JsonNode nodes  = new ObjectMapper().
                     readTree(new File("src/main/init-data/products.json")).get("products");


            if (nodes.isArray()) {
                for ( JsonNode node : nodes) {
                    Product product = new Product();
                    product.setId(getUUID());
                    product.setName(node.get("name").textValue());

                    JsonNode containes = node.get("contain_articles");

                   List<Element> elements = new ArrayList<>();

                   for (JsonNode art : containes){
                       Element element = new Element();
                       element.setArtId(art.get("art_id").textValue());
                       element.setAmountOf(art.get("amount_of").textValue());
                       elements.add(element);
                   }
                   product.setContainArticles(elements);
                   products.add(product);
                }
            }


            logger().log(Level.WARNING,products.toString());

            logger().log(Level.WARNING,"read from product file successfully");

        }catch(IOException e){
            logger().log(Level.WARNING,"Can not load products from json file");
            logger().log(Level.WARNING,e.getMessage());
        }
        return products;
    }

    private String getUUID(){
        return  UUID.randomUUID().toString();
    }

}
