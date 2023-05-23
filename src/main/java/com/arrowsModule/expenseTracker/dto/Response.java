package com.arrowsModule.expenseTracker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {
    private String path;
    private Object content;
    private Integer httpCode;
    private String httpMessage;
    private String moreInfo;

    public Response(String path, Object content, Integer httpCode, String httpMessage) {
        this.path = path;
        this.content = content;
        this.httpCode = httpCode;
        this.httpMessage = httpMessage;
    }
}
