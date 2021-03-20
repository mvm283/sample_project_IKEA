package io.wms.core.warehouse.dataload;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.wms.core.warehouse.common.Loggable;
import io.wms.core.warehouse.model.Article;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

@Component("articles")
public class ImportArticles implements ImportJson<Article>, Loggable {
    @Override
    public List<Article> importData() {
        List<Article> articles = new ArrayList<>();
        try{
            JsonNode nodes  = new ObjectMapper().
                    readTree(new File("src/main/init-data/inventory.json")).get("inventory");

            if (nodes.isArray()) {
                for ( JsonNode node : nodes) {
                    Article article = new Article();
                    article.setId(getUUID());
                    article.setStock(node.get("stock").textValue());
                    article.setExternalId(node.get("art_id").textValue());
                    article.setName(node.get("name").textValue());

                    articles.add(article);
                }
            }

            logger().log(Level.WARNING,articles.toString());
            logger().log(Level.WARNING,"read from article file successfully");
        }catch(IOException e){
            logger().log(Level.WARNING,"Can not load articles from json file");
        }
        return articles;
    }


    private String getUUID(){
        return  UUID.randomUUID().toString();
    }
}
