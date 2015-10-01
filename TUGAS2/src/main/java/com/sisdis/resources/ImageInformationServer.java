package com.sisdis.resources;

import com.sisdis.Util.ImageUtil;
import com.sisdis.representations.ErrorMessage;
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
import java.io.File;
import java.io.IOException;

/**
 * Created by wahyuoi on 9/30/15.
 */
@Path("tugas2/server")
@Produces(MediaType.APPLICATION_JSON)
public class ImageInformationServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImageInformationServer.class);

    @GET
    @Path("/{name}")
    public Response getFileInfo(@PathParam("name") String name){
        String encodedImg = null;
        String path = "/home/wahyuoi/" + name;
        File file = new File(path);
        if (!file.exists()){
            return Response.ok(new ErrorMessage(404, "Image Not Found")).build();
        }
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            double bytes = file.length();
            double kilobytes = bytes/1024;
            String size = kilobytes + " KB";
            String type = name.substring(name.length()-3);
            encodedImg = ImageUtil.encode(bufferedImage, type);
            com.sisdis.representations.ImageInformation imageInformation = new com.sisdis.representations.ImageInformation(encodedImg, path, size);
            return Response.ok(imageInformation).build();
        } catch (IOException e) {
            return Response.ok(new ErrorMessage(500, "Internal Server Error")).build();
        }
    }
}
