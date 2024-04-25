package me.trinityfforce.esqueryserver.repository;

import me.trinityfforce.esqueryserver.entity.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SearchRepository  extends ElasticsearchRepository<Item, Integer> {
}
