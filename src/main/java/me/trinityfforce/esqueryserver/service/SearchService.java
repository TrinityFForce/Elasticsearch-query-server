package me.trinityfforce.esqueryserver.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import lombok.RequiredArgsConstructor;
import me.trinityfforce.esqueryserver.entity.Item;
import me.trinityfforce.esqueryserver.repository.SearchRepository;
import me.trinityfforce.esqueryserver.util.ElasticsearchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final SearchRepository searchRepository;
    private final ElasticsearchClient elasticsearchClient;
    public SearchResponse<Object> fuzzySearch(String keyword) throws IOException {
        Supplier<Query> supplier = ElasticsearchUtil.createSupplierQuery(keyword);
        SearchResponse<Object> response = elasticsearchClient
            .search(s->s.index("sagopalgo.item").query(supplier.get()), Object.class);
        return response;
    }

    public Iterable<Item> findAll() {
        return searchRepository.findAll();
    }
}
