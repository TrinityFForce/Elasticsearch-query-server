package me.trinityfforce.esqueryserver.controller;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import lombok.RequiredArgsConstructor;
import me.trinityfforce.esqueryserver.dto.ItemResponseDto;
import me.trinityfforce.esqueryserver.entity.Item;
import me.trinityfforce.esqueryserver.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/es")
public class SearchController {

    private final SearchService searchService;

    @GetMapping("search/{keyword}")
    List<Item> fuzzySearch(@PathVariable String keyword) throws IOException {
        SearchResponse<Item> searchResponse = searchService.fuzzySearch(keyword);
        List<Hit<Item>> hitList = searchResponse.hits().hits();
        List<Item> itemList = new ArrayList<>();
        for(Hit<Item> hit : hitList) {
            itemList.add(hit.source());
        }
        return itemList;
    }

    @GetMapping("/findAll")
    Iterable<Item> findAll() {
        return searchService.findAll();
    }

//    @PostMapping("/insert")
//    public Item insertItem(@RequestBody Item item) {
//        return
//    }
}
