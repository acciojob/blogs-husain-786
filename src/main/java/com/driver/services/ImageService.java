package com.driver.services;

import com.driver.models.*;
import com.driver.models.Image;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Blog blog = blogRepository2.findById(blogId).get();
        Image image = new Image();

        image.setDescription(description);
        image.setDimensions(dimensions);
        image.setBlog(blog);

        blog.getImageList().add(image);

        blogRepository2.save(blog);

        return image;
    }

    public void deleteImage(Integer id){
        Image image = imageRepository2.findById(id).get();

        Blog blog = image.getBlog();

        imageRepository2.deleteById(id);

        blog.getImageList().remove(image);

        blogRepository2.save(blog);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        List<Image> imageList = imageRepository2.findAll();
        int count = 0;
        for (Image image: imageList){
            if (image.getDimensions().compareTo(screenDimensions) <= 0){
                count++;
            }
        }
        return count;
    }
}
