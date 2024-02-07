package com.group1.service;

import com.group1.config.ImgurUploader;
import com.group1.dto.request.PersonelSaveRequestDto;
import com.group1.dto.request.UpdatePersonelRequestDto;
import com.group1.repository.ImageRepository;
import com.group1.repository.entity.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;
    private final ImgurUploader imgurUploader;

//    public Image saveImage(PersonelSaveRequestDto dto) throws IOException {
//        List<String> imageUrls = new ArrayList<>();
//        List<MultipartFile> images = dto.getImages();
//        if(images.size()>0 && images.size()<5){
//            for(int i = 0; i<images.size();i++) {
//                String imageUrl = imgurUploader.upload(images.get(i));
//                imageUrls.add(imageUrl);
//            }
//        } else {
//            throw new RuntimeException("bir şeyler yanlış gitti...");
//        }
//
//        Image image =  Image.builder()
//                .mainImageUrl(imageUrls.get(0))
//                .addiotionalImageUrls(imageUrls.subList(1,imageUrls.size()))
//                .build();
//
//        return imageRepository.save(image);
//    }
//    public Image saveImage(UpdatePersonelRequestDto dto) throws IOException {
//        List<String> imageUrls = new ArrayList<>();
//        List<MultipartFile> images = dto.getImages();
//        if(images.size()>0 && images.size()<5){
//            for(int i = 0; i<images.size();i++) {
//                String imageUrl = imgurUploader.upload(images.get(i));
//                imageUrls.add(imageUrl);
//            }
//        } else {
//            throw new RuntimeException("bir şeyler yanlış gitti...");
//        }
//
//        Image image =  Image.builder()
//                .mainImageUrl(imageUrls.get(0))
//                .addiotionalImageUrls(imageUrls.subList(1,imageUrls.size()))
//                .build();
//
//        return imageRepository.save(image);
//    }
}
