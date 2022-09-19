package me.leelkarunarathne.springbatchexample.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DownloadFileRequestDto {

    private String url;
    private String myParam;


}
