package com.sisdis.resources;

import com.google.gson.Gson;
import com.sisdis.Util.ImageUtil;
import com.sisdis.representations.ImageInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by wahyuoi on 9/30/15.
 */
@Path("tugas2/client")
public class ImageInformationClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImageInformationClient.class);

    @GET
    @Path("/{name}")
    public Response showImage(@PathParam("name") String name){
        try {
            String url_ = "http://localhost:8080/tugas2/server/"+name;
            URL url = null;
            url = new URL(url_);
            InputStream is = url.openConnection().getInputStream();
            BufferedReader reader = new BufferedReader( new InputStreamReader( is )  );
            String line = "";
            String line_temp;
            while( ( line_temp = reader.readLine() ) != null )  {
                line += line_temp;
            }
            reader.close();

            Gson gson = new Gson();
            ImageInformation temp_image = gson.fromJson(line, ImageInformation.class);
            String isi_berkas = temp_image.getIsi_berkas();
            String path = temp_image.getLokasi_berkas();
            String ukuran = temp_image.getUkuran_berkas();

            // TODO tinggal nampilin base64 image udah selesai, deploy deh
            return Response.ok("<img src='data:image/jpg;base64, "+isi_berkas+"' /><br>" +
                    "Lokasi pada server : " + path + "<br>" +
                    "Ukuran : " + ukuran).build();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
