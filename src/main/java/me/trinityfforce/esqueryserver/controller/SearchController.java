package me.trinityfforce.esqueryserver.controller;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import lombok.RequiredArgsConstructor;
import me.trinityfforce.esqueryserver.dto.ItemResponseDto;
import me.trinityfforce.esqueryserver.entity.Item;
import me.trinityfforce.esqueryserver.service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/es")
public class SearchController {

    private final SearchService searchService;

    @GetMapping("search/{keyword}")
    List<ItemResponseDto> fuzzySearch(@PathVariable String keyword) throws IOException {
        SearchResponse<Object> searchResponse = searchService.fuzzySearch(keyword);
        List<Hit<Object>> hitList = searchResponse.hits().hits();
        List<Object> itemList = new ArrayList<>();
        for(Hit<Object> hit : hitList) {
            itemList.add(hit.source());
        }
        List<ItemResponseDto> responseDtoList = new ArrayList<>();
        for (Object obj : itemList) {
            ItemResponseDto dto = new ItemResponseDto();
            dto.mapToItemResponseDto(obj);
            responseDtoList.add(dto);
        }
        return responseDtoList;
    }

    @GetMapping("/findAll")
    Iterable<Item> findAll() {
        return searchService.findAll();
    }
}
