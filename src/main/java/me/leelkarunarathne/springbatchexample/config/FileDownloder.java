package me.leelkarunarathne.springbatchexample.config;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

@Service
public class FileDownloder {


    public void downloadFile(String url, String outputFileName) throws IOException {

        try {
            URL urlLink = new URL(url);

            try (InputStream in = urlLink.openStream();
                 ReadableByteChannel rbc = Channels.newChannel(in);
                 FileOutputStream fos = new FileOutputStream(outputFileName)) {
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            }


        } catch (Exception e) {
            throw e;
        }

    }


}
