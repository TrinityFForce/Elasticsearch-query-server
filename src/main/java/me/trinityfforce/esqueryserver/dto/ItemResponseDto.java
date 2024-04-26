package me.trinityfforce.esqueryserver.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemResponseDto {

    private Long id;
    private String name;
    private Integer bidCount;
    private Integer highestPrice;
    private String username;
    private String status;
    private Integer viewCount;
    private String url;

    public void mapToItemResponseDto(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.valueToTree(obj);
        this.id = node.get("class").get("id").asLong();
        this.name = node.get("class").get("name").asText();
        this.bidCount = node.get("class").get("bid_count").asInt();
        this.highestPrice = node.get("class").get("highest_price").asInt();
        this.username = node.get("class").get("name").asText();
        this.status = node.get("class").get("status").asText();
        this.viewCount = node.get("class").get("view_count").asInt();
        this.url = node.get("class").get("url").asText();
    }
}
